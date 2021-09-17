package cbo.onborading.service;


import cbo.onborading.internal.model.Branch;
import cbo.onborading.jpa.repository.BranchRepository;
import cbo.onborading.response_object.EmployeeBranch;
import cbo.onborading.response_object.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;


    public ResponseMessage saveBranch(Branch branch){
        try{
            branchRepository.save(branch);
            return new ResponseMessage().success("Branch Created Successfully");
        }
        catch(Exception e){
            return new ResponseMessage().error("Error Creating Branch Please check Company Code, Name");
        }
    }
//5432
    public Branch searchBranch(String CompanyCode){

        return branchRepository.getBranchCompanyCode(CompanyCode);
    }

    public List<Branch> getAllBranch(){
        //List<Branch> branches=branchRepository.getAllBranch();

        return branchRepository.getAllBranch();

    }

    public List<EmployeeBranch> employeeBranch(){
        List<Branch> branches=branchRepository.getAllBranch();
       List<EmployeeBranch> employeeBranch= new ArrayList<>();

        for (Branch br :branches
                ) {
            employeeBranch.add(new EmployeeBranch(br.getCompanyCode(),br.getBranchName()));

        }
         return employeeBranch;

    }

}
