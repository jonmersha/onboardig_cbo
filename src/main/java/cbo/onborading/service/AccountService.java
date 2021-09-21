package cbo.onborading.service;


import cbo.onborading.jpa.entity.CustomerAccount;
import cbo.onborading.jpa.repository.AccountRepository;
import cbo.onborading.model.internal.InternalUser;
import cbo.onborading.jpa.repository.CCCRepository;
import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.model.operation.Account;
import cbo.onborading.model.operation.Authorization;
import cbo.onborading.remote.soap.body.authorization.AccountAuthorization;
import cbo.onborading.remote.soap.body.creation.AccountCreation;
import cbo.onborading.remote.soap.request.RequestProcess;
import cbo.onborading.remote.soap.response.CreationResponse;
import cbo.onborading.response_object.ResponseMessage;
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




    public ResponseMessage createAccount(Account account){

        InternalUser internalUser=securityService.login(account.getUserName(),account.getPassword());
        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");
        CoreCredentials coreUser=commonFunc.coreCredential(internalUser);
        if(coreUser==null)
            return new ResponseMessage().error("Core credentials Not set");
        String soapBody= AccountCreation.body(account.getCustomerAccount(),coreUser);
        SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);


        CustomerAccount customerAccount=new CreationResponse().accountCreation(soapMessage, account.getCustomerAccount());
        accountRepository.save(customerAccount);

        return new ResponseMessage().success("Login Success");
    }
    public ResponseMessage authorizeAccount(Authorization authorization){
        InternalUser internalUser=securityService.login(authorization.getUserName(),authorization.getPassWord());
        if(internalUser==null)
            return new ResponseMessage().error("invalid Credentials Supplied");
        CoreCredentials coreUser=commonFunc.coreCredential(internalUser);
        if(coreUser==null)
            return new ResponseMessage().error("Core credentials Not set");
        String soapBody= AccountAuthorization.body(authorization.getTransactionId(),coreUser);
        SOAPMessage soapMessage=new RequestProcess().soapRequest(soapBody);

        return new ResponseMessage().error("Account Authorization Failed");
    }

}
