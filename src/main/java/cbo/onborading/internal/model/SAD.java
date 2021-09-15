package cbo.onborading.internal.model;
import javax.persistence.*;

@Entity
@Table(name="sad")
public class SAD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobile;
    private String firstName;
    private String middleName;
    private String lastName;

    private String mobileOTP;
    private String emailOTP;

    private boolean mobileOTPValid;
    private boolean emailOTPValid;

    private String mobileOTPGenTime;
    private String emailOTPGenTime;
    private int mobileOTPTryCount;
    private int emailOTPTryCount;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getMobileOTPTryCount() {
        return mobileOTPTryCount;
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
}
