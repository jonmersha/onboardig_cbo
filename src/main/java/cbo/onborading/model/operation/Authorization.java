package cbo.onborading.model.operation;

public class Authorization {
    private String userName;
    private String passWord;
    private String transactionId;
    private String cashierCode;
    private String cashierPassword;




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCashierCode() {
        return cashierCode;
    }

    public void setCashierCode(String cashierCode) {
        this.cashierCode = cashierCode;
    }

    public String getCashierPassword() {
        return cashierPassword;
    }

    public void setCashierPassword(String cashierPassword) {
        this.cashierPassword = cashierPassword;
    }
}
