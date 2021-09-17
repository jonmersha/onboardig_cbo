package cbo.onborading.contoller.v1;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountManagementController {



    @PostMapping("/v1/account/link")
    public String linkAccount(){
        return "Account Link Functionality";
    }

    @PostMapping("/v1/account/balance")
    public String balance(){
        return "Account Balance Functionality";

    }

    @PostMapping("/v1/account/transfer")
    public String transfer(){
        return "Account to account transfer Functionality";

    }

    @PostMapping("/v1/merchant/payment")
    public String merchantPayment(){

        return "merchant Payment Functionality";

    }







}
