package Entity.Bills;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account")

public class BankAccount extends BillingDetail {
    private String name;
    private String swift;

    @Column(name = "name", nullable = false, unique = true)
    public String getName () {
        return this.name;
    }

    public BankAccount setName (String name) {
        this.name = name;
        return this;
    }

    @Column(name = "swift", nullable = false, unique = true)
    public String getSwift () {
        return this.swift;
    }

    public BankAccount setSwift (String swift) {
        this.swift = swift;
        return this;
    }

    public BankAccount () {
    }
}
