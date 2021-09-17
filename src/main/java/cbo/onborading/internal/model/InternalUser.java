package cbo.onborading.internal.model;


import javax.persistence.*;

@Entity
@Table(name = "bank_officer")
public class InternalUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String employeeId;
    private String branchCode;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String mobile;
    private String firstName;
    private String middleName;
    private String lastName;
    private String role_id;
    private boolean enabled;
    private String date_created;
    private String dateVerified;
    private String authorized_by;
    private boolean defaultPasswordChanged;
    private boolean emailVerified;
    private boolean mobileVerified;
    private String coreUserName;
    private String password;
    private String deviceId;


    public String getCoreUserName() {
        return coreUserName;
    }

    public void setCoreUserName(String coreUserName) {
        this.coreUserName = coreUserName;
    }

    public boolean isDefaultPasswordChanged() {
        return defaultPasswordChanged;
    }

    public void setDefaultPasswordChanged(boolean defaultPasswordChanged) {
        this.defaultPasswordChanged = defaultPasswordChanged;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDateVerified() {
        return dateVerified;
    }

    public void setDateVerified(String dateVerified) {
        this.dateVerified = dateVerified;
    }

    public String getAuthorized_by() {
        return authorized_by;
    }

    public void setAuthorized_by(String authorized_by) {
        this.authorized_by = authorized_by;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(boolean mobileVerified) {
        this.mobileVerified = mobileVerified;
    }
}
