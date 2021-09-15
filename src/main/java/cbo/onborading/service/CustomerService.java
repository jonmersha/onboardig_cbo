package cbo.onborading.service;


import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.internal.model.InternalUser;
import cbo.onborading.model.CoreCredentials;
import cbo.onborading.model.Customer;
import cbo.onborading.remote.soap.body.CustomerBody;
import cbo.onborading.utility.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    InternalUserRepository officerRepository;
    @Autowired
    SecurityService securityService;

    public ResponseMessage createCustomer(Customer customer){
        //authentication
       CoreCredentials coreUser=securityService.getOficerCore(customer.getCashierCode(),customer.getCashierPassword());
        if(officer==null) return new ResponseMessage().error("Officer Login problem");
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
