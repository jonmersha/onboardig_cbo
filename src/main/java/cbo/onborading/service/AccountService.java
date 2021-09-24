package cbo.onborading.service;


import cbo.onborading.jpa.entity.Account;
import cbo.onborading.jpa.entity.CustomerData;
import cbo.onborading.jpa.repository.AccountRepository;
import cbo.onborading.jpa.repository.CustomerRepository;
import cbo.onborading.model.internal.InternalUser;
import cbo.onborading.jpa.repository.CCCRepository;
import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.model.operation.AccountWraper;
import cbo.onborading.model.operation.Authorization;
import cbo.onborading.remote.soap.body.authorization.AccountAuthorization;
import cbo.onborading.remote.soap.body.creation.AccountCreation;
import cbo.onborading.remote.soap.request.RequestProcess;
import cbo.onborading.remote.soap.response.AuthorizationResponse;
import cbo.onborading.remote.soap.response.CreationResponse;
import cbo.onborading.response_object.ResponseMessage;
import cbo.onborading.utility.RandomNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.soap.SOAPMessage;

@Service
public class AccountService {
    @Autowired
    InternalUserRepository internalUserRepository;
    @Autowired
    SecurityService securityService;

    @Autowired
    CCCRepository cccRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CommonFunc commonFunc;

    @Autowired
    CustomerRepository customerRepository;




    public ResponseMessage createAccount(AccountWraper accountContainer){
        InternalUser internalUser=securityService.login(accountContainer.getUserName(),accountContainer.getPassword());
        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");
        CoreCredentials coreUser=commonFunc.coreCredential(internalUser);
        if(coreUser==null)
            return new ResponseMessage().error("Core credentials Not set");
        Account account=accountContainer.getAccount();


        CustomerData customerData=customerRepository.getCustomerByCustomerNumber(account.getCustomerID());
        if(customerData==null)
            return new ResponseMessage().error("Invalid Customer Id Supplied");
        account.setMessageId("AC"+ RandomNumber.getRandom());
        accountRepository.save(account);

        String soapBody= AccountCreation.body(account,coreUser);

        SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);
        account =new CreationResponse().accountCreation(soapMessage, account);
        //accountRepository.save(accounts);
        if(account.isAccountCreated()) {
            account.setCreator(accountContainer.getUserName());
            accountRepository.save(account);
            return new ResponseMessage().success("Account Created Successfully").setTransactionID(account.getAccountNumber());
        }
            return new ResponseMessage().error("AAccount Creation Not Successful");
    }
    public ResponseMessage authorizeAccount(Authorization authorization){
        //=============================
        InternalUser internalUser=securityService.login(authorization.getUserName(),authorization.getPassWord());
        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");
        CoreCredentials coreUser=commonFunc.coreCredential(internalUser);
        if(coreUser==null)
            return new ResponseMessage().error("Core credentials Not set");
       //==============================
        String soapBody= AccountAuthorization.body(authorization.getTransactionId(),coreUser);
        SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);
        Account account =accountRepository.getCustomerAccount(authorization.getTransactionId());

        if(account==null)
            return new ResponseMessage().error("No Such Account Number").setTransactionID(authorization.getTransactionId());
            account=new AuthorizationResponse().accountAuthorization(soapMessage, account);
            if(account.isAccountAuthorized()) {
                account.setAuthorizer(authorization.getUserName());
                accountRepository.save(account);
                return new ResponseMessage().success("Account authorized Successfully").setTransactionID(account.getAccountNumber());
            }
        return new ResponseMessage().error("Account authorized Failed").setTransactionID(account.getAccountNumber());


    }

}
