package cbo.onborading.service;


import cbo.onborading.model.internal.InternalUser;
import cbo.onborading.jpa.repository.CCCRepository;
import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.model.operation.Customer;
import cbo.onborading.remote.soap.body.CustomerBody;
import cbo.onborading.response_object.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    InternalUserRepository internalUserRepository;
    @Autowired
    SecurityService securityService;

    @Autowired
    CCCRepository cccRepository;

    @Autowired
    CommonFunc commonFunc;

    public ResponseMessage createCustomer(Customer customer){
        //authentication
        InternalUser internalUser=securityService.login(customer.getCashierCode(),customer.getCashierPassword());
        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");
       CoreCredentials coreUser=commonFunc.coreCredential(internalUser);

       if(coreUser==null) return new ResponseMessage().error("Core credentials Not set");
//        //Create soap Body
       String soapBody= CustomerBody.body(coreUser,customer);
       System.out.println(soapBody);
//        //Send request
//        //get Response
//        //get
        return new ResponseMessage().success("Login Success");
    }




    public String authorizeCustomer(){
        return "";
    }
    public String searchCustomer(){
        return "";
    }




}
