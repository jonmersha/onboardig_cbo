package cbo.onborading.model;

public class CoreCredentials {
    private int userID;
    private String corePassWord;
    private String coreUserName;
    private String companyCode;


    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCorePassWord() {
        return corePassWord;
    }

    public void setCorePassWord(String corePassWord) {
        this.corePassWord = corePassWord;
    }

    public String getCoreUserName() {
        return coreUserName;
    }

    public void setCoreUserName(String coreUserName) {
        this.coreUserName = coreUserName;
    }
}
