package cbo.onborading.service;


import cbo.onborading.model.internal.InternalUser;
import cbo.onborading.model.internal.UCCC;
import cbo.onborading.jpa.repository.CCCRepository;
import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.utility.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonFunc {
    @Autowired
    CCCRepository cccRepository;
    @Autowired
    InternalUserRepository internalUserRepository;

    public CoreCredentials coreCredential(InternalUser internalUser){
        //return new UCCC();
        String encriyptedId=Collections.encP(internalUser.getId()+"");
        UCCC uccc = cccRepository.getOfficerCustomerID(encriyptedId);
        if(uccc==null)
            return null;
        CoreCredentials coreUser=new CoreCredentials();
        coreUser.setCorePassWord(uccc.getCorePassword());
        coreUser.setCoreUserName(internalUser.getCoreUserName());
        coreUser.setCompanyCode(uccc.getCompanyCode());
        return  coreUser;
    }
}
