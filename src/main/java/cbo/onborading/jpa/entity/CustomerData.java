package cbo.onborading.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerData {
    @Id
    private String mobilePhoneNumber;
    private String createdBuy;
    private String firstName;
    private String middleName;
    private String lastName;
    private String messageID;
    private String mnemonic;
    private String sector;
    private String industry;
    private String target;
    private String title;
    private String maritalStatus;
    private String gender;
    private String dob;
    private String officeTelNumber;
    private String emailId;
    private String city;
    private String streetName;
    private String poBox;
    private String address;
    private String country;
    private String idNumber;
    private String documentName;
    private String nameOnDocument;
    private String issueAuthority;
    private String issueDate;
    private String expirationDate;

}
