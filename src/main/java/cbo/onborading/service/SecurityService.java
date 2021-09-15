package cbo.onborading.service;


import cbo.onborading.internal.model.InternalUser;
import cbo.onborading.internal.model.LoginCredentials;
import cbo.onborading.internal.model.UCCC;
import cbo.onborading.jpa.repository.CCCRepository;
import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.model.CoreCredentials;
import cbo.onborading.utility.Collections;
import cbo.onborading.utility.NotificationService;
import cbo.onborading.utility.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public CoreCredentials getOficerCore(String cashierCode, String cashierPassword) {

        return null;
    }
    // public String generatePassword() throws NoSuchAlgorithmException {
//        String password= Collections.randomString(7);
//        MessageDigest m = MessageDigest.getInstance("MD5");
//        m.update(password.getBytes());
//        byte[] bytes = m.digest();
//        return password;
     // return   internalUserRepository.officerLogin(userName,password);
   // }
//    public InternalUser sendEmail(String userName, String password) {
//      return   internalUserRepository.officerLogin(userName,password);
//    }
}
