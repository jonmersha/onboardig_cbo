package cbo.onborading.response_object;

import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.model.internal.InternalUser;
import cbo.onborading.service.CommonFunc;
import cbo.onborading.service.SecurityService;
import cbo.onborading.utility.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreLocalCredential {


    @Autowired
    SecurityService securityService;
    @Autowired
    CommonFunc commonFunc;
    @Autowired
    InternalUserRepository internalUserRepository;

    private ResponseMessage responseMessage;
    private CoreCredentials coreCredentials;

    public CoreLocalCredential checkCredentials(String userName, String passWord){
        //checking local user account
        InternalUser internalUser=securityService.login(userName,passWord);
        if(internalUser==null) {
            this.responseMessage = new ResponseMessage().error("invalid Credentials Supplied");
            return this;
        }
        if(!internalUser.isDefaultPasswordChanged()){
            this.responseMessage=new ResponseMessage().error("Default Password Not Changed");
            return this;
        }
        if(!internalUser.isEmailVerified()){
            this.responseMessage=new ResponseMessage().error("Email Not Verified");
            return this;
        }
        this.responseMessage=new ResponseMessage().success("Login Successful");
        CoreCredentials coreUser=commonFunc.coreCredential(internalUser);
        if(coreUser==null){
            this.responseMessage=new  ResponseMessage().error("Core credentials Not set");
            return this;
        }
        this.coreCredentials=coreUser;
        this.responseMessage=new  ResponseMessage().success("all Credentials Correct");
        return this;
    }
    public ResponseMessage getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
    }

    public CoreCredentials getCoreCredentials() {
        return coreCredentials;
    }

    public void setCoreCredentials(CoreCredentials coreCredentials) {
        this.coreCredentials = coreCredentials;
    }
}
