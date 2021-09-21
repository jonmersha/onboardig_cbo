package cbo.onborading.service;


import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.model.internal.InternalUser;
import cbo.onborading.model.operation.Authorization;
import cbo.onborading.model.operation.ImageCapture;
import cbo.onborading.model.operation.ImageUpload;
import cbo.onborading.remote.soap.body.authorization.AccountAuthorization;
import cbo.onborading.remote.soap.body.authorization.ImageUploadAuthorization;
import cbo.onborading.remote.soap.body.creation.ImageCaptureSoap;
import cbo.onborading.remote.soap.body.creation.ImageUploadSoap;
import cbo.onborading.remote.soap.request.RequestProcess;
import cbo.onborading.response_object.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.soap.SOAPMessage;

@Service
public class ImageService {
    @Autowired
    SecurityService securityService;
    @Autowired
    CommonFunc commonFunc;



    public ResponseMessage imageCapture(ImageCapture imageCapture){


        InternalUser internalUser=securityService.login(imageCapture.getUserName(),imageCapture.getPassWord());
        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");
        CoreCredentials coreUser=commonFunc.coreCredential(internalUser);
        if(coreUser==null)
            return new ResponseMessage().error("Core credentials Not set");
        String soapBody= ImageCaptureSoap.body(imageCapture,coreUser);
        SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);



        return new ResponseMessage().error("Image Capturing Failed");

    }
    public ResponseMessage imageUpload(ImageUpload imageUpload){

        InternalUser internalUser=securityService.login(imageUpload.getUserName(),imageUpload.getPassWord());
        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");
        CoreCredentials coreUser=commonFunc.coreCredential(internalUser);
        if(coreUser==null)
            return new ResponseMessage().error("Core credentials Not set");
        String soapBody= ImageUploadSoap.body(imageUpload,coreUser);
        SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);

        return new ResponseMessage().error("Image Uploading Failed");
    }
    public ResponseMessage imageUploadAuth(Authorization authorization){
        InternalUser internalUser=securityService.login(authorization.getUserName(),authorization.getPassWord());
        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");
        CoreCredentials coreUser=commonFunc.coreCredential(internalUser);
        if(coreUser==null)
            return new ResponseMessage().error("Core credentials Not set");
        String soapBody= ImageUploadAuthorization.body(authorization.getTransactionId(),coreUser);
        SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);

        return new ResponseMessage().error("Account Authorization Failed");

    }
    public ResponseMessage fileUpload(){
        return new ResponseMessage().error("image file upload failed");

    }
}
