package cbo.onborading.service;


import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.internal.model.InternalUser;
import cbo.onborading.response_object.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InternalUserService {
    @Autowired
    InternalUserRepository internalUser;
    @Autowired
    SecurityService securityService;


    public ResponseMessage createUser(InternalUser internalUser){
        try{

            this.internalUser.save(internalUser);
            return securityService.sendSaveDefaultPassword(internalUser);
        }
        catch (Exception e){
            String error="Could not execute statement; SQL [n/a]; constraint [bank_officer.UK_gotbiiiwsnj9b038n3mli8gcq]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement";
           if(error.equals(e.getLocalizedMessage()))
            return new ResponseMessage().error("Error Creating Your Account: mobile, employee Id or Email has been used already");
            return new ResponseMessage().error("Error Creating your account! PLease contact system administrators ");

        }

    }


    public void updateUser(InternalUser user) {
        internalUser.save(user);
    }
}
