package cbo.onborading.contoller.v1;

import cbo.onborading.jpa.entity.Account;
import cbo.onborading.model.FusedServiceContainer;
import cbo.onborading.model.operation.*;
import cbo.onborading.response_object.FusedOperationResponseMessage;
import cbo.onborading.response_object.ResponseMessage;
import cbo.onborading.service.AccountService;
import cbo.onborading.service.CustomerService;
import cbo.onborading.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FusedOperationController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AccountService accountService;

    @Autowired
    ImageService imageService;
    //customer Creation
    @PostMapping("/v1/customer_account")
    public FusedOperationResponseMessage createCustomerAccount(@RequestBody FusedServiceContainer accountInformation){
        //Create Customer
        FusedOperationResponseMessage fusedOperationResponseMessage=new FusedOperationResponseMessage();
        Customer customer=new Customer();
        customer.setUserName(accountInformation.getUsername());
        customer.setPassWord(accountInformation.getPassWord());
        customer.setCustomerData(accountInformation.getCustomerData());

        ResponseMessage responseMessage=  customerService.createCustomer(customer);
        if(responseMessage.getStatus().equals("Error"))
        {
            fusedOperationResponseMessage.setCustomerCreateStatus(responseMessage.getMessage());
            return fusedOperationResponseMessage;
        }



        fusedOperationResponseMessage.setCustomerCreateStatus(responseMessage.getMessage());


        //Authorize Customer
        Authorization authorization=new Authorization();
        authorization.setUserName(accountInformation.getUsername());
        authorization.setPassWord(accountInformation.getPassWord());
        authorization.setTransactionId(responseMessage.getTransactionID());

        responseMessage=  customerService.authorizeCustomer(authorization);
        if(responseMessage.getStatus().equals("Error"))
        {
            fusedOperationResponseMessage.setCustomerAuthorizeStatus(responseMessage.getMessage());
            return fusedOperationResponseMessage;
        }
        fusedOperationResponseMessage.setCustomerAuthorizeStatus(responseMessage.getMessage());


        //Create Account
        //Preparing for Account creation
        AccountWraper accountW=new AccountWraper();
        accountW.setUserName(accountInformation.getUsername());
        accountW.setPassword(accountInformation.getPassWord());

        accountW.setAccount(accountInformation.getAccount());
        accountW.getAccount().setCustomerID(responseMessage.getTransactionID());
        responseMessage=  accountService.createAccount(accountW);

        if(responseMessage.getStatus().equals("Error"))
        {
            fusedOperationResponseMessage.setAccountCreateStatus(responseMessage.getMessage());
            return fusedOperationResponseMessage;
        }
        fusedOperationResponseMessage.setAccountCreateStatus(responseMessage.getMessage());
String accountNumber=responseMessage.getTransactionID();
        authorization.setTransactionId(responseMessage.getTransactionID());
        accountService.authorizeAccount(authorization);

        if(responseMessage.getStatus().equals("Error"))
        {
            fusedOperationResponseMessage.setAccountAuthorizeStatus(responseMessage.getMessage());
            return fusedOperationResponseMessage;
        }
        fusedOperationResponseMessage.setAccountAuthorizeStatus(responseMessage.getMessage());


        //Image Capturing

//        ImageCapture imageCapture=new ImageCapture();
//        imageCapture.setAccountNumber(accountNumber);
//        imageCapture.setUserName(accountInformation.getUsername());
//        imageCapture.setPassWord(accountInformation.getPassWord());
//        responseMessage= imageService.imageCapture(imageCapture);
//
//        if(responseMessage.getStatus().equals("Error"))
//        {
//            fusedOperationResponseMessage.setImageCaptureStatus(responseMessage.getMessage());
//            return fusedOperationResponseMessage;
//        }
//        fusedOperationResponseMessage.setImageCaptureStatus(responseMessage.getMessage());


//        String imageID=responseMessage.getTransactionID();
//        ImageUpload imageUpload=new ImageUpload();
//        imageUpload.setImageId(imageID);
//        imageUpload.setAccountNumber(accountNumber);
//        imageUpload.setImageName(accountNumber);
//        responseMessage =   imageService.imageUpload(imageUpload);
//
//        if(responseMessage.getStatus().equals("Error"))
//        {
//            fusedOperationResponseMessage.setImageUploadStatus(responseMessage.getMessage());
//            return fusedOperationResponseMessage;
//        }
//        fusedOperationResponseMessage.setImageUploadStatus(responseMessage.getMessage());
//        //Image Upload Authorization
//        authorization.setTransactionId(responseMessage.getTransactionID());

//        responseMessage= imageService.imageUploadAuth(authorization);
//
//        if(responseMessage.getStatus().equals("Error"))
//        {
//            fusedOperationResponseMessage.setImageAuthorizeStatus(responseMessage.getMessage());
//            return fusedOperationResponseMessage;
//        }
//        fusedOperationResponseMessage.setImageAuthorizeStatus(responseMessage.getMessage());


        return fusedOperationResponseMessage;
    }
    //customer Authorization
    @PostMapping("/v1/image_upload")
    public ResponseMessage authorizeCustomer(@RequestBody Authorization authorization){
        //upload Files to destination

        //capture the images

        //upload image

        //Authorize image upload

        return  customerService.authorizeCustomer(authorization);
    }

}
