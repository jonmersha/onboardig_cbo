package cbo.onborading.contoller.v1;

import cbo.onborading.model.operation.*;
import cbo.onborading.service.AccountService;
import cbo.onborading.service.CustomerService;
import cbo.onborading.response_object.ResponseMessage;
import cbo.onborading.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OnBoardingOperationController {
    @Autowired
    CustomerService customerService;
    @Autowired
    AccountService accountService;

    @Autowired
    ImageService imageService;
    //customer Creation
    @PostMapping("/v1/create/customer")
    public ResponseMessage createCustomer(@RequestBody Customer customer){
       return customerService.createCustomer(customer);
    }
    //customer Authorization
    @PostMapping("/v1/authorize/customer")
    public ResponseMessage authorizeCustomer(@RequestBody Authorization authorization){
        return  customerService.authorizeCustomer(authorization);
    }
    //account Creation
    @PostMapping("/v1/create/account")
    public ResponseMessage createAccount(@RequestBody AccountWraper accountWraper){
        return accountService.createAccount(accountWraper);
    }
    //Account Authorization
    @PostMapping("/v1/authorize/account")
    public ResponseMessage accountAuthorization(@RequestBody Authorization authorization){
       return accountService.authorizeAccount(authorization);
    }
    //image capture
    @PostMapping("/v1/create/image")
    public ResponseMessage createImage(@RequestBody ImageCapture imageCapture){
        return imageService.imageCapture(imageCapture);
    }
    //image upload
    @PostMapping("/v1/upload/image")
    public ResponseMessage uploadImage(@RequestBody ImageUpload imageUpload){
        return imageService.imageUpload(imageUpload);
    }
    //image upload authorization
    @PostMapping("/v1/authorize/image")
    public ResponseMessage authorizeImage(@RequestBody Authorization authorization){
        return imageService.imageUploadAuth(authorization);
    }



    //actual file upload
    @PostMapping("/v1/upload")
    public ResponseMessage upload(@RequestBody Customer customer){
        return imageService.fileUpload();
    }
}
