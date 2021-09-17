package cbo.onborading.jpa.repository;


import cbo.onborading.internal.model.UCCC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CCCRepository extends CrudRepository<UCCC,Integer> {
    @Query("select u from UCCC u where u.id=?1")
    UCCC getOfficerCustomerID(String customerID);


}
