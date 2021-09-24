package cbo.onborading.model;

import cbo.onborading.jpa.entity.Account;
import cbo.onborading.jpa.entity.CustomerData;

public class FusedServiceContainer {
    private String username;
    private String passWord;
    private CustomerData customerData;
    private Account account;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
