package cbo.onborading.jpa.repository;


import cbo.onborading.jpa.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account,Integer> {

    @Query("SELECT u FROM Account u where u.customerID=?1")
    Account getAccountByCustomer(Integer customerID);

    @Query("SELECT u FROM Account u ")
    List<Account> getAllAccount();

    @Query("SELECT u FROM Account u where u.accountNumber=?1 ")
    Account getCustomerAccount(String accountNumber);

    @Query("SELECT u FROM Account u where u.accountNumber=?1 ")
    Account getCustomerAccountBYAccountNUmber(String transactionId);

    @Query("SELECT u FROM Account u where u.personImageId=?1 or u.signatureImageId=?1")
    Account getAccountByImageCaptureID(String imageId);
}
