package cbo.onborading.response_object;

public class FusedOperationResponseMessage {
    private String customerCreateStatus;
    private String customerAuthorizeStatus;

    private String AccountCreateStatus;
    private String accountAuthorizeStatus;

    private String imageCaptureStatus;
    private String imageUploadStatus;
    private String imageAuthorizeStatus;



    public String getCustomerCreateStatus() {
        return customerCreateStatus;
    }

    public void setCustomerCreateStatus(String customerCreateStatus) {
        this.customerCreateStatus = customerCreateStatus;
    }

    public String getCustomerAuthorizeStatus() {
        return customerAuthorizeStatus;
    }

    public void setCustomerAuthorizeStatus(String customerAuthorizeStatus) {
        this.customerAuthorizeStatus = customerAuthorizeStatus;
    }

    public String getAccountCreateStatus() {
        return AccountCreateStatus;
    }

    public void setAccountCreateStatus(String accountCreateStatus) {
        AccountCreateStatus = accountCreateStatus;
    }

    public String getAccountAuthorizeStatus() {
        return accountAuthorizeStatus;
    }

    public void setAccountAuthorizeStatus(String accountAuthorizeStatus) {
        this.accountAuthorizeStatus = accountAuthorizeStatus;
    }

    public String getImageCaptureStatus() {
        return imageCaptureStatus;
    }

    public void setImageCaptureStatus(String imageCaptureStatus) {
        this.imageCaptureStatus = imageCaptureStatus;
    }

    public String getImageUploadStatus() {
        return imageUploadStatus;
    }

    public void setImageUploadStatus(String imageUploadStatus) {
        this.imageUploadStatus = imageUploadStatus;
    }

    public String getImageAuthorizeStatus() {
        return imageAuthorizeStatus;
    }

    public void setImageAuthorizeStatus(String imageAuthorizeStatus) {
        this.imageAuthorizeStatus = imageAuthorizeStatus;
    }
}
