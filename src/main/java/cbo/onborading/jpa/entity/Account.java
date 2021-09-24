package cbo.onborading.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    private String customerID;
    private String productCode;
    private String accountName;
    private String messageId;
    private String shortName;
    private String currency;

    private String accountNumber;
    private String creator;
    private String authorizer;

    private String signatureImageId;
    private String personImageId;

    private boolean accountCreated;
    private boolean accountAuthorized;


    private boolean signatureUploaded;
    private boolean signatureAuthorized;

    private boolean photoUploaded;
    private boolean photoAuthorized;

    private boolean signatureFileUploaded;
    private boolean photoFileUploaded;


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAuthorizer() {
        return authorizer;
    }

    public void setAuthorizer(String authorizer) {
        this.authorizer = authorizer;
    }

    public boolean isAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(boolean accountCreated) {
        this.accountCreated = accountCreated;
    }

    public boolean isAccountAuthorized() {
        return accountAuthorized;
    }

    public void setAccountAuthorized(boolean accountAuthorized) {
        this.accountAuthorized = accountAuthorized;
    }

    public String getSignatureImageId() {
        return signatureImageId;
    }

    public void setSignatureImageId(String signatureImageId) {
        this.signatureImageId = signatureImageId;
    }

    public String getPersonImageId() {
        return personImageId;
    }

    public void setPersonImageId(String personImageId) {
        this.personImageId = personImageId;
    }

    public boolean isSignatureUploaded() {
        return signatureUploaded;
    }

    public void setSignatureUploaded(boolean signatureUploaded) {
        this.signatureUploaded = signatureUploaded;
    }

    public boolean isSignatureAuthorized() {
        return signatureAuthorized;
    }

    public void setSignatureAuthorized(boolean signatureAuthorized) {
        this.signatureAuthorized = signatureAuthorized;
    }

    public boolean isPhotoUploaded() {
        return photoUploaded;
    }

    public void setPhotoUploaded(boolean photoUploaded) {
        this.photoUploaded = photoUploaded;
    }

    public boolean isPhotoAuthorized() {
        return photoAuthorized;
    }

    public void setPhotoAuthorized(boolean photoAuthorized) {
        this.photoAuthorized = photoAuthorized;
    }

    public boolean isSignatureFileUploaded() {
        return signatureFileUploaded;
    }

    public void setSignatureFileUploaded(boolean signatureFileUploaded) {
        this.signatureFileUploaded = signatureFileUploaded;
    }

    public boolean isPhotoFileUploaded() {
        return photoFileUploaded;
    }

    public void setPhotoFileUploaded(boolean photoFileUploaded) {
        this.photoFileUploaded = photoFileUploaded;
    }

}
