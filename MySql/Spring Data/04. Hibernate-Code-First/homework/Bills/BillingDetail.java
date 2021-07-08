package Entity.Bills;

import Entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BillingDetail extends BaseEntity {
    private String number;
    private User user;

    @Column(nullable = false, unique = true)
    public String getNumber () {
        return this.number;
    }

    public BillingDetail setNumber (String number) {
        this.number = number;
        return this;
    }

    @ManyToOne
    public User getUser () {
        return this.user;
    }

    public BillingDetail setUser (User user) {
        this.user = user;
        return this;
    }

    public BillingDetail () {
    }
}
