package cbo.onborading.contoller.v1;

import cbo.onborading.internal.model.*;
import cbo.onborading.jpa.entity.BranchEnt;
import cbo.onborading.jpa.repository.InternalUserRepository;
import cbo.onborading.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetController {

    @Autowired
    BranchService branchService;

    @Autowired
    InternalUserRepository officerRepository;

    @GetMapping("/branch")
    public BranchEnt getBranch(){
       return new BranchEnt();
    }

    @GetMapping("/branches")
    public List<Branch> getAllBranches(){
        return branchService.getAllBranch();
    }

    @GetMapping("/officer")
    public List<InternalUser> getOfficer(){
        return officerRepository.getAllOfficer();
    }

    @GetMapping("/chpass")
    public ChangePassword changePassword(){
        return new ChangePassword();
    }

    @GetMapping("/emailV")
    public VerifyEmailMobile verifyEmailOrPassword(){
        return new VerifyEmailMobile();
    }


    @GetMapping("/login")
    public LoginCredentials loginStructure(){
        return new LoginCredentials().setLoginStatus("Success");
    }

}