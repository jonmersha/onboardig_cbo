package cbo.onborading.service;


import cbo.onborading.jpa.entity.Account;
import cbo.onborading.jpa.repository.AccountRepository;
import cbo.onborading.model.operation.Authorization;
import cbo.onborading.model.operation.ImageCapture;
import cbo.onborading.model.operation.ImageUpload;
import cbo.onborading.remote.soap.body.authorization.ImageUploadAuthorization;
import cbo.onborading.remote.soap.body.creation.ImageCaptureSoap;
import cbo.onborading.remote.soap.body.creation.ImageUploadSoap;
import cbo.onborading.remote.soap.request.RequestProcess;
import cbo.onborading.remote.soap.response.AuthorizationResponse;
import cbo.onborading.remote.soap.response.CreationResponse;
import cbo.onborading.response_object.CoreLocalCredential;
import cbo.onborading.response_object.ResponseMessage;
import cbo.onborading.utility.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.soap.SOAPMessage;

@Service
public class ImageService {
    @Autowired
    SecurityService securityService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CommonFunc commonFunc;

    @Autowired
    CoreLocalCredential coreCredentials;

    public ResponseMessage imageCapture(ImageCapture imageCapture){

         coreCredentials.checkCredentials(imageCapture.getUserName(),imageCapture.getPassWord());
        if(coreCredentials.getResponseMessage().getStatus().equals("Error"))
            return coreCredentials.getResponseMessage();
        Account account=accountRepository.getCustomerAccountBYAccountNUmber(imageCapture.getAccountNumber());
        if(account==null)
            return new ResponseMessage().error("No Account numbers In local Database").setTransactionID(imageCapture.getAccountNumber());

        imageCapture.setMessageId("CA"+ RandomNumber.getRandom());
        String soapBody= ImageCaptureSoap.body(imageCapture,coreCredentials.getCoreCredentials());
        System.out.println(soapBody);
        SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);
        Account customerAccount=new CreationResponse().imageCapture(soapMessage,account,imageCapture.imageType);
        accountRepository.save(customerAccount);
        if(imageCapture.getImageType().equals("SIGNATURES"))
            return new ResponseMessage().success(imageCapture.getImageType()+"Image Captured Successfully").setTransactionID(customerAccount.getSignatureImageId());

        return new ResponseMessage().success(imageCapture.getImageType()+"Image Captured Successfully").setTransactionID(customerAccount.getPersonImageId());
    }
    public ResponseMessage imageUpload(ImageUpload imageUpload){
        coreCredentials.checkCredentials(imageUpload.getUserName(),imageUpload.getPassWord());
        if(coreCredentials.getResponseMessage().getStatus().equals("Error"))
            return coreCredentials.getResponseMessage();


        imageUpload.setMessageId("IU"+ RandomNumber.getRandom());
        String soapBody= ImageUploadSoap.body(imageUpload,coreCredentials.getCoreCredentials());
        SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);

        Account account=accountRepository.getCustomerAccount(imageUpload.getAccountNumber());
        if(account==null)
            return new ResponseMessage().error("No Such Bank Account");
        Account customerAccount=new CreationResponse().imageUpload(soapMessage,account,imageUpload.getImageType());
        accountRepository.save(customerAccount);
        if(imageUpload.getImageType().equals("SIGNATURES"))
        return new ResponseMessage().success(imageUpload.getImageType()+" Image Uploaded Successfully").setTransactionID(customerAccount.getSignatureImageId());

        return new ResponseMessage().success(imageUpload.getImageType()+" Image Uploaded Successfully").setTransactionID(customerAccount.getPersonImageId());
    }
    public ResponseMessage imageUploadAuth(Authorization authorization){
        coreCredentials.checkCredentials(authorization.getUserName(),authorization.getPassWord());
        if(coreCredentials.getResponseMessage().getStatus().equals("Error"))
            return coreCredentials.getResponseMessage();
            String soapBody= ImageUploadAuthorization.body(authorization.getTransactionId(),coreCredentials.getCoreCredentials());
            SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);
            Account account=accountRepository.getAccountByImageCaptureID(authorization.getTransactionId());
            if(account==null)
                return new ResponseMessage().error("No Account numbers In local Database").setTransactionID(authorization.getTransactionId());
            Account customerAccount=new AuthorizationResponse().imageUploadAuthorization(soapMessage,account,authorization.getImageType());
           accountRepository.save(customerAccount);
            return new ResponseMessage().success(authorization.getImageType()+" authorized successfully");
    }
    public ResponseMessage fileUpload(){
        return new ResponseMessage().error("image file uploaded failed");
    }

}
