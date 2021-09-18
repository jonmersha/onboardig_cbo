package cbo.onborading.model.internal;


import javax.persistence.*;

@Entity
@Table(name="CCC")
public class UCCC {
    @Id
    private String id;
    private String mobileOTP;
    private String emailOTP;
    private boolean mobileOTPValid;
    private boolean emailOTPValid;
    private String mobileOTPGenTime;
    private String emailOTPGenTime;
    private int mobileOTPTryCount;
    private int emailOTPTryCount;
    private String companyCode;
    private String corePassword;
    private String coreUserName;


    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobileOTP() {
        return mobileOTP;
    }

    public void setMobileOTP(String mobileOTP) {
        this.mobileOTP = mobileOTP;
    }

    public String getEmailOTP() {
        return emailOTP;
    }

    public void setEmailOTP(String emailOTP) {
        this.emailOTP = emailOTP;
    }

    public boolean isMobileOTPValid() {
        return mobileOTPValid;
    }

    public void setMobileOTPValid(boolean mobileOTPValid) {
        this.mobileOTPValid = mobileOTPValid;
    }

    public boolean isEmailOTPValid() {
        return emailOTPValid;
    }

    public void setEmailOTPValid(boolean emailOTPValid) {
        this.emailOTPValid = emailOTPValid;
    }

    public int getMobileOTPTryCount() {
        return mobileOTPTryCount;
    }

    public String getMobileOTPGenTime() {
        return mobileOTPGenTime;
    }

    public void setMobileOTPGenTime(String mobileOTPGenTime) {
        this.mobileOTPGenTime = mobileOTPGenTime;
    }

    public String getEmailOTPGenTime() {
        return emailOTPGenTime;
    }

    public void setEmailOTPGenTime(String emailOTPGenTime) {
        this.emailOTPGenTime = emailOTPGenTime;
    }

    public void setMobileOTPTryCount(int mobileOTPTryCount) {
        this.mobileOTPTryCount = mobileOTPTryCount;
    }

    public int getEmailOTPTryCount() {
        return emailOTPTryCount;
    }

    public void setEmailOTPTryCount(int emailOTPTryCount) {
        this.emailOTPTryCount = emailOTPTryCount;
    }

    public String getCorePassword() {
        return corePassword;
    }

    public void setCorePassword(String corePassword) {
        this.corePassword = corePassword;
    }

    public String getCoreUserName() {
        return coreUserName;
    }

    public void setCoreUserName(String coreUserName) {
        this.coreUserName = coreUserName;
    }


}
