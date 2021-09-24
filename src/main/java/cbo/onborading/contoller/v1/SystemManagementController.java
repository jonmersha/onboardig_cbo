package cbo.onborading.contoller.v1;



import cbo.onborading.jpa.repository.CCCRepository;
import cbo.onborading.model.internal.CoreCredentials;
import cbo.onborading.model.internal.*;
import cbo.onborading.service.BranchService;
import cbo.onborading.service.InternalUserService;
import cbo.onborading.service.SecurityService;
import cbo.onborading.storages.StorageService;
import cbo.onborading.response_object.ResponseMessage;
import cbo.onborading.utility.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SystemManagementController {
    @Autowired
    BranchService branchService;
    @Autowired
    InternalUserService internalUserService;

    @Autowired
    SecurityService securityService;
   // private MultipartFile file;

    @Autowired
    CCCRepository cccRepository;

    @GetMapping("/")
    public String getSystemInformation(){
        return "<h1>Coopay Onbording</h1>";
    }



    private final StorageService storageService;


    @Autowired
    public SystemManagementController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/v1/add/branch")
    public ResponseMessage newBranch(@RequestBody Branch branch){
        return branchService.saveBranch(branch);
    }

    @PostMapping("/v1/add/user")
    public ResponseMessage addInternalUser(@RequestBody InternalUser internalUser){
        return internalUserService.createUser(internalUser);
    }

    @PostMapping("/v1/add/admin")
    public ResponseMessage addAdminUser(@RequestBody InternalUser internalUser){
        return internalUserService.createUser(internalUser);
    }

    @PostMapping("/v1/login/user")
    public LoginCredentials logIn(@RequestBody LoginCredentials loginCredentials){
         InternalUser user= securityService.login(loginCredentials.getUserName(),loginCredentials.getPassword());
        if(user==null){
            return new LoginCredentials().setLoginStatus("Login not Successful");
        }

        if(user.isDefaultPasswordChanged())
        return loginCredentials.setLoginStatus("Success");

        return new LoginCredentials().setLoginStatus("Default Password Password not changed");

    }

    @PostMapping("/v1/pw/change")
    public ResponseMessage changePassword(@RequestBody ChangePassword chp){
        return securityService.changePassword(chp);
    }

    @PostMapping("/v1/core/setup")
    public ResponseMessage createCoreCredentials(@RequestBody CoreCredentials coreCredentials){

        InternalUser user= securityService.login(coreCredentials.getUsername(),coreCredentials.getPassword());
        if(user!=null){
            user.setCoreUserName(coreCredentials.getCoreUserName());
            String userId= Collections.encP(user.getId()+"");
            String cureUserName=Collections.encP(coreCredentials.getCoreUserName());


            internalUserService.updateUser(user);

            //create cccc intry
            UCCC uccc=new UCCC();

            uccc.setCorePassword(coreCredentials.getCorePassWord());
            uccc.setCompanyCode(coreCredentials.getCompanyCode());
            uccc.setCoreUserName(cureUserName);
            uccc.setId(userId);


            cccRepository.save(uccc);
            return new ResponseMessage().success("Core Account Created Successfully");

        }
        return new ResponseMessage().error("invalid Credentials");
        //return coreCredentials;
    }


    @PostMapping("/files")
    public InternalUser handleFileUpload(@RequestParam("myfile") MultipartFile file,String password,String username) {
        InternalUser user= securityService.login(username,password);
        if(user==null)
        return new InternalUser();
        return user;
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
