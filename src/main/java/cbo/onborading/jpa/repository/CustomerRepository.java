package cbo.onborading.jpa.repository;

import cbo.onborading.jpa.entity.CustomerData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerData,Integer> {
    @Query("select u from CustomerData u")
    List<CustomerData> allCustomer();
    @Query("select u from CustomerData u where u.mobilePhoneNumber=?1")
    CustomerData getCustomerBymobile(String mobilePhoneNumber);

    @Query("select u from CustomerData u where u.mobilePhoneNumber=?1")
    CustomerData getCustomerByCustomerID(String transactionId);
}
