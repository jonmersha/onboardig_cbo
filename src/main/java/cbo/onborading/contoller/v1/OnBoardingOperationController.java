package cbo.onborading.contoller.v1;


import cbo.onborading.model.Customer;
import cbo.onborading.service.CustomerService;
import cbo.onborading.response_object.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnBoardingOperationController {
    @Autowired
    CustomerService customerService;

    //customer Creation
    @PostMapping("/v1/create/customer")
    public ResponseMessage createCustomer(@RequestBody Customer customer){
       return customerService.createCustomer(customer);

    }

    //customer Authorization
    @PostMapping("/v1/authorize/customer")
    public String authorizeCustomer(@RequestBody Customer customer){
        return "";
    }

    //account Creation

    @PostMapping("/v1/create/account")
    public String createAccount(@RequestBody Customer customer){
        return "";
    }

    //Account Authorization
    @PostMapping("/v1/authorize/account")
    public String authorizeAccount(@RequestBody Customer customer){
        return "";
    }



    //image capture
    @PostMapping("/v1/create/image")
    public String createImage(@RequestBody Customer customer){
        return "";
    }

    //image upload
    @PostMapping("/v1/upload/image")
    public String uploadImage(@RequestBody Customer customer){
        return "";
    }

    //image upload authorization
    @PostMapping("/v1/authorize/image")
    public String authorizeImage(@RequestBody Customer customer){
        return "";
    }



    //actual file upload
    @PostMapping("/v1/upload")
    public String upload(@RequestBody Customer customer){
        return "";
    }
}
