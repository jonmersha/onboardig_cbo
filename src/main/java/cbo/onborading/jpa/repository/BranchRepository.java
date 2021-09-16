package cbo.onborading.jpa.repository;

import cbo.onborading.internal.model.Branch;
import cbo.onborading.jpa.entity.BranchEnt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BranchRepository extends CrudRepository<Branch,Integer> {
    @Query("select u from Branch u where u.branchName=?1")
    Branch getBranchByName(String branchName);

    @Query("select u from Branch u where u.companyCode=?1")
    Branch getBranchCompanyCode(String companyCode);


    @Query("select u.companyCode,u.branchName from Branch u")
    List<Branch> getAllBranch();

    @Query("select u from Branch u")
    List<Branch> branches();

}
