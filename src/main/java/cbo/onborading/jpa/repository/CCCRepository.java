package cbo.onborading.jpa.repository;

import cbo.onborading.internal.model.InternalUser;
import cbo.onborading.internal.model.UCCC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CCCRepository extends CrudRepository<UCCC,Integer> {
//    @Query("select u from UCCC u where u.mobile=?1")
//    InternalUser getOfficerBYPhone(String phoneNumber);
//
//    @Query("select u from InternalUser u where ((u.mobile=?1 or u.email=?1) and u.password=?2)")
//    InternalUser officerLogin(String phoneNumber, String password);
//
//    @Query("select u from InternalUser u ")
//    List<InternalUser> getAllOfficer();



}
