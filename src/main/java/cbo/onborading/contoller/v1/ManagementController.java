package cbo.onborading.contoller.v1;


import cbo.onborading.internal.model.Branch;
import cbo.onborading.internal.model.ChangePassword;
import cbo.onborading.internal.model.LoginCredentials;
import cbo.onborading.internal.model.InternalUser;
import cbo.onborading.service.BranchService;
import cbo.onborading.service.InternalUserService;
import cbo.onborading.service.SecurityService;
import cbo.onborading.utility.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagementController {
    @Autowired
    BranchService branchService;
    @Autowired
    InternalUserService officerService;

    @Autowired
    SecurityService securityService;

    @GetMapping("/")
    public String getSystemInformation(){
        return "<h1>Coopay Onbording</h1>";
    }
    @PostMapping("/v1/add/branch")
    public ResponseMessage newBranch(@RequestBody Branch branch){
        return branchService.saveBranch(branch);
    }
    @PostMapping("/v1/add/user")
    public ResponseMessage addInternalUser(@RequestBody InternalUser internalUser){
        return officerService.createUser(internalUser);
    }
    @PostMapping("/v1/add/admin")
    public ResponseMessage addAdminUser(@RequestBody InternalUser internalUser){
        return officerService.createUser(internalUser);
    }

    @PostMapping("/v1/login/user")
    public LoginCredentials logIn(@RequestBody LoginCredentials loginCredentials){
         InternalUser user= securityService.login(loginCredentials.getUserName(),loginCredentials.getPassword());
        if(user==null){
            return new LoginCredentials().setLoginStatus("Login not Successful");
        }
        return loginCredentials.setLoginStatus("Success");
    }
    @PostMapping("/v1/pw/change")
public ResponseMessage changePassword(@RequestBody ChangePassword chp){
        return securityService.changePassword(chp);
    }



    //manager Signup
    //Manger login

    //officer signup
    //officer login

    //officer Authorization
    //officer enabling


    //officer core account update
    //officer disabling



    //branch creation



}
