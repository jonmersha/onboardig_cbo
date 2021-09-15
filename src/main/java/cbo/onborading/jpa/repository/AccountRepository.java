package cbo.onborading.jpa.repository;

import cbo.onborading.jpa.entity.BranchEnt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AccountRepository extends CrudRepository<BranchEnt,Integer> {


}
