package cbo.onborading.model.operation;

import cbo.onborading.jpa.entity.CustomerData;

public class Customer {
    private String userName;
    private String passWord;
    private CustomerData customerData;


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

    public CustomerData getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerData customerData) {
        this.customerData = customerData;
    }
}
