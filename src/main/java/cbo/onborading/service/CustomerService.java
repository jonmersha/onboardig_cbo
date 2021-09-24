package cbo.onborading.service;


import cbo.onborading.jpa.entity.CustomerData;
import cbo.onborading.jpa.repository.CustomerRepository;
import cbo.onborading.model.internal.InternalUser;
import cbo.onborading.jpa.repository.CCCRepository;
import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.model.operation.Authorization;
import cbo.onborading.model.operation.Customer;
import cbo.onborading.remote.soap.body.authorization.CustomerAuthorization;
import cbo.onborading.remote.soap.body.creation.CustomerCreation;
import cbo.onborading.remote.soap.request.RequestProcess;
import cbo.onborading.remote.soap.response.AuthorizationResponse;
import cbo.onborading.remote.soap.response.CreationResponse;
import cbo.onborading.response_object.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.soap.SOAPMessage;

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

    @Autowired
    CustomerRepository customerRepository;

    public ResponseMessage createCustomer(Customer customer){
        //authentication
        InternalUser internalUser=securityService.login(customer.getUserName(),customer.getPassWord());

        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");

        if(!internalUser.isEmailVerified())
            return new ResponseMessage().error("Email Not Verified");

//        if(!internalUser.isMobileVerified())
//            return new ResponseMessage().error("Mobile Not Verified");

        CoreCredentials coreUser=commonFunc.coreCredential(internalUser);

       if(coreUser==null)
           return new ResponseMessage().error("Core credentials Not set");

        CustomerData cd=customerRepository.getCustomerBymobile(customer.getCustomerData().getMobilePhoneNumber());

        if(cd!=null && cd.getStatus().equals("Success"))
            return new ResponseMessage().error("Customer is Already Created on core system").setTransactionID(cd.getTransactionID());
        customer=generateValue(customer);

        String soapBody= CustomerCreation.body(coreUser,customer.getCustomerData());
        SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);

        CustomerData customerData=new CreationResponse().customerCreation(soapMessage,customer.getCustomerData());
try{
    if(customerData.getStatus().equals("Success"))
        customerData.setCreatedBY(customer.getUserName());
    customerRepository.save(customerData);
}
catch (Exception ex){
    return new ResponseMessage().error(ex.getMessage());
}
    if(customerData.getStatus().equals("Success"))
            return new ResponseMessage().success(customerData.getMessages()).setTransactionID(customerData.getTransactionID());

            return new ResponseMessage().error(customerData.getMessages());
    }
    public ResponseMessage authorizeCustomer( Authorization authorization){

        InternalUser internalUser=securityService.login(authorization.getUserName(),authorization.getPassWord());
        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");
        CoreCredentials coreUser=commonFunc.coreCredential(internalUser);
        if(coreUser==null)
            return new ResponseMessage().error("Core credentials Not set");
        CustomerData cd=customerRepository.getCustomerByCustomerNumber(authorization.getTransactionId());
        if(cd==null)
            return new ResponseMessage().error("invalid Customer ID Supplied").setTransactionID(authorization.getTransactionId());


        if(cd.isAuthorized())
            return new ResponseMessage().error("Customer Already authorized").setTransactionID(authorization.getTransactionId());

//        if(cd.getCreatedBuy()!=internalUser.getMobile() && cd.getCreatedBuy()!=internalUser.getEmail())
//            return new ResponseMessage().error("You are not authorized to authorize this customer creation");
//        //proceed to authorizations


        String customerAuth= CustomerAuthorization.body(authorization.getTransactionId(),coreUser);
        SOAPMessage message=new RequestProcess().soapRequest(customerAuth);
        CustomerData customer=new AuthorizationResponse().customerAuthorization(message,cd);


        if(customer.isAuthorized())
            return new ResponseMessage()
                    .success("Customer Authorized Successfully")
                    .setTransactionID(customer.getTransactionID());

        return new ResponseMessage()
                .error("Customer Authorization failed")
                .setTransactionID(customer.getTransactionID());
        //return "";
    }
    public String searchCustomer(){
        return "";
    }
    public Customer generateValue(Customer customer){

        String initial=customer.getCustomerData().getFirstName().substring(0,1).toUpperCase();
        String mobileNumber=customer.getCustomerData().getMobilePhoneNumber();
        int len=mobileNumber.length();
        if(len>=10)
            mobileNumber=mobileNumber.substring(len-9,len);
        customer.getCustomerData().setMessageID(initial+customer.getCustomerData().getMobilePhoneNumber());
        customer.getCustomerData().setMnemonic(initial+mobileNumber);
        return customer;
    }


}
