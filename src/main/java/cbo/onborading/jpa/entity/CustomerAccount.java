package cbo.onborading.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="customer_account")
public class CustomerAccount {
    @Id
    private String customerID;
    private String productCode;
    private String accountName;
    private String shortName;
    private String currency;
    private String messageId;
    private String accountNumber;
    private String createdBy;
    private String creationDate;
    private String status;
    private String message;
    private boolean accountCreated;
    private boolean authorized;


    private boolean photoUploaded;
    private String photoImageID;
    private String photoImageCaptureID;
    private String PhotoImageName;
    private String photoImagePath;
    private String originalPhotoName;

    private boolean sigUploaded;
    private String sigImageID;
    private String sigImageCaptureID;
    private String sigImageName;
    private String sigImagePath;
    private String originalSigName;



    public boolean isPhotoUploaded() {
        return photoUploaded;
    }

    public void setPhotoUploaded(boolean photoUploaded) {
        this.photoUploaded = photoUploaded;
    }

    public boolean isSigUploaded() {
        return sigUploaded;
    }

    public void setSigUploaded(boolean sigUploaded) {
        this.sigUploaded = sigUploaded;
    }

    public String getOriginalPhotoName() {
        return originalPhotoName;
    }

    public void setOriginalPhotoName(String originalPhotoName) {
        this.originalPhotoName = originalPhotoName;
    }

    public String getOriginalSigName() {
        return originalSigName;
    }

    public void setOriginalSigName(String originalSigName) {
        this.originalSigName = originalSigName;
    }

    public String getPhotoImageID() {
        return photoImageID;
    }

    public void setPhotoImageID(String photoImageID) {
        this.photoImageID = photoImageID;
    }

    public String getPhotoImageCaptureID() {
        return photoImageCaptureID;
    }

    public void setPhotoImageCaptureID(String photoImageCaptureID) {
        this.photoImageCaptureID = photoImageCaptureID;
    }

    public String getPhotoImageName() {
        return PhotoImageName;
    }

    public void setPhotoImageName(String photoImageName) {
        PhotoImageName = photoImageName;
    }

    public String getPhotoImagePath() {
        return photoImagePath;
    }

    public void setPhotoImagePath(String photoImagePath) {
        this.photoImagePath = photoImagePath;
    }

    public String getSigImageID() {
        return sigImageID;
    }

    public void setSigImageID(String sigImageID) {
        this.sigImageID = sigImageID;
    }

    public String getSigImageCaptureID() {
        return sigImageCaptureID;
    }

    public void setSigImageCaptureID(String sigImageCaptureID) {
        this.sigImageCaptureID = sigImageCaptureID;
    }

    public String getSigImageName() {
        return sigImageName;
    }

    public void setSigImageName(String sigImageName) {
        this.sigImageName = sigImageName;
    }

    public String getSigImagePath() {
        return sigImagePath;
    }

    public void setSigImagePath(String sigImagePath) {
        this.sigImagePath = sigImagePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(boolean accountCreated) {
        this.accountCreated = accountCreated;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }


}
