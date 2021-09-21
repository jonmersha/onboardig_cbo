package cbo.onborading.jpa.repository;


import cbo.onborading.jpa.entity.CustomerAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<CustomerAccount,Integer> {

    @Query("SELECT u FROM CustomerAccount u where u.customerID=?1")
    CustomerAccount getAccountByCustomer(Integer customerID);

}
