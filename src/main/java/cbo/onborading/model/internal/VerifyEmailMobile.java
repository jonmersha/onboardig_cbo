package cbo.onborading.model.internal;

public class VerifyEmailMobile {
    private String username;
    private String password;
    private String verificationCode;
    private String toBeVerified;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getToBeVerified() {
        return toBeVerified;
    }

    public void setToBeVerified(String toBeVerified) {
        this.toBeVerified = toBeVerified;
    }
}
