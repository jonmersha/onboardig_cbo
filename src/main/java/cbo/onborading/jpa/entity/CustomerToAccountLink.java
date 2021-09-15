package cbo.onborading.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerBankAccountLink")
public class CustomerToAccountLink {
    @Id
    private String customer_id;
    private String customer_account;
    private String linkDate;
    private String linkedBY;
    private boolean authorized;
    private boolean locked;
    private String lockDate;
    private String lockReason;

}
