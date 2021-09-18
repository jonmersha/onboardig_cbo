package cbo.onborading.jpa.repository;


import cbo.onborading.model.internal.UCCC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CCCRepository extends CrudRepository<UCCC,Integer> {
    @Query("select u from UCCC u where u.id=?1")
    UCCC getOfficerCustomerID(String customerID);


}
