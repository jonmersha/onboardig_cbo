package cbo.onborading.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_account")
public class CustomerAccountEnt {
    @Id
    private String id;
    private String customer_id;
    @Column(unique = true)
    private String accountNumber;
    private String accountType;

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = this.getCustomer_id()+getAccountNumber();
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
