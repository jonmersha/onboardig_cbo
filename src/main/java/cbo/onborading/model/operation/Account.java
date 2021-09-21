package cbo.onborading.model.operation;

import cbo.onborading.jpa.entity.CustomerAccount;

public class Account {
    private String userName;
    private String password;
    private CustomerAccount customerAccount;

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

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

}
