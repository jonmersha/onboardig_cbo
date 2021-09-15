package cbo.onborading.service;


import cbo.onborading.internal.model.Branch;
import cbo.onborading.jpa.entity.BranchEnt;
import cbo.onborading.jpa.repository.BranchRepository;
import cbo.onborading.utility.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return branchRepository.getAllBranch();

    }

}
