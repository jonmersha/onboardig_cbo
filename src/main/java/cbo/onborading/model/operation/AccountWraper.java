package cbo.onborading.model.operation;

import cbo.onborading.jpa.entity.Account;

public class AccountWraper {
    private String userName;
    private String password;
    private Account account;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
