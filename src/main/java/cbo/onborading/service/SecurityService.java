package cbo.onborading.service;


import cbo.onborading.model.internal.ChangePassword;
import cbo.onborading.model.internal.InternalUser;
import cbo.onborading.jpa.repository.CCCRepository;
import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.utility.Collections;
import cbo.onborading.utility.NotificationService;
import cbo.onborading.response_object.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
public class SecurityService {
    @Autowired
    CCCRepository cccRepository;
    @Autowired
    InternalUserRepository internalUserRepository;


   public InternalUser login(String userName, String password) {
       password=Collections.encP(password);
      return   internalUserRepository.officerLogin(userName,password);
    }
    public ResponseMessage sendSaveDefaultPassword(InternalUser iu){
        int userId=iu.getId();
            String password=Collections.randomString(8);
            String encPassword=Collections.encP(password);
            String incID=Collections.encP(iu.getId()+"");
            iu.setPassword(encPassword);
            internalUserRepository.save(iu);
            String subject="Default Password --please do not reply to this email";
            String message="Dear Customer your Account Is created and your Default  password is===     <b> "+password+"</b><br/>     ==== please change the password immediately 24 hours.\n  for any help use hullupay@lehulupay.com";

        try {
            NotificationService.emailNotification(subject,message,iu.getEmail());
        } catch (MessagingException e) {
            return new ResponseMessage().success("user Account Created"+e.getLocalizedMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //send Email
        return new ResponseMessage().success("user Account Created and Password Sent via registered email please change defaUlt PASSWORD");
    }
    public CoreCredentials getOfficerCore(String cashierCode, String cashierPassword) {

        return null;
    }
    public ResponseMessage changePassword(ChangePassword chp) {
       if(!chp.getNewPassWord().equals(chp.getConfirmPassword())){
           return new ResponseMessage().error("Password is not Confirmed");
       }
       //loing chack
        InternalUser user=login(chp.getUsername(),chp.getOldPassWord());
        if(user==null)
            return new ResponseMessage().error("Invalid Credential Supplied");
        String encPassword=Collections.encP(chp.getNewPassWord());
        user.setPassword(encPassword);
        user.setDefaultPasswordChanged(true);
        user.setEmailVerified(true);
        internalUserRepository.save(user);

        String subject="Default Password changed--please do not reply to this email";
        String message="Recently you have changed your default password,";

        try {
            NotificationService.emailNotification(subject,message,user.getEmail());
        } catch (MessagingException e) {
            return new ResponseMessage().success("Default Password Changed"+e.getLocalizedMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //send Email
        return new ResponseMessage().success("Your Default Password has been changed Succefully");


    }

}
