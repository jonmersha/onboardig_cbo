package cbo.onborading.service;


import cbo.onborading.internal.model.InternalUser;
import cbo.onborading.internal.model.UCCC;
import cbo.onborading.jpa.repository.CCCRepository;
import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.model.CoreCredentials;
import cbo.onborading.model.Customer;
import cbo.onborading.remote.soap.body.CustomerBody;
import cbo.onborading.response_object.ResponseMessage;
import cbo.onborading.utility.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    InternalUserRepository officerRepository;
    @Autowired
    SecurityService securityService;

    @Autowired
    CCCRepository cccRepository;

    public ResponseMessage createCustomer(Customer customer){
        //authentication
        InternalUser internalUser=securityService.login(customer.getCashierCode(),customer.getCashierPassword());
        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");
       CoreCredentials coreUser=coreCredential(internalUser);
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



public CoreCredentials coreCredential(InternalUser internalUser){

        //return new UCCC();
    String encriyptedId=Collections.encP(internalUser.getCoreUserName()+"");
    UCCC uccc = cccRepository.getOfficerCustomerID(encriyptedId);

    if(uccc==null)
        return null;
    CoreCredentials coreUser=new CoreCredentials();
    coreUser.setCorePassWord(coreUser.getCorePassWord());
    coreUser.setCoreUserName(internalUser.getCoreUserName());
    coreUser.setCompanyCode(coreUser.getCompanyCode());
    return  coreUser;
}
}
