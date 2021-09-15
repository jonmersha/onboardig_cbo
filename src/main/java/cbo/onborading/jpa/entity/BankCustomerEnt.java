package cbo.onborading.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_account")
public class BankCustomerEnt {
    @Id
    private String transactionId;
    @Column(unique = false)
    private String mobileNumber;
    private boolean customerAuthorized;
    private String accountCreator;
    private String signatureImageName;
    private String personImageName;
    private String imageId;
    private String authorizedBY;
    private String creationDate;
    private String imagePath;

}
