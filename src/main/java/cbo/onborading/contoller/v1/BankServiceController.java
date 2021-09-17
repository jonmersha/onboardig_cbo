package cbo.onborading.contoller.v1;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankServiceController {


    //Account Information
    @PostMapping("/v1/account/detail")
    public void accountDetails(){}
    //Customer information
    @PostMapping("/v1/customer/detail")
    public void customerDetails(){}
    //Customer Balance





}
