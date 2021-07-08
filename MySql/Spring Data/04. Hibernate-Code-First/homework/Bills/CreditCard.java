package Entity.Bills;

import javax.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard extends BillingDetail {
    private CardType cardType;
    private Integer expirationMonth;
    private Integer expirationYear;
@Enumerated(EnumType.STRING)
    public CardType getCardType () {
        return this.cardType;
    }

    public CreditCard setCardType (CardType cardType) {
        this.cardType = cardType;
        return this;
    }
@Column(name="expiration_month")
    public Integer getExpiration_month () {
        return this.expirationMonth;
    }

    public CreditCard setExpiration_month (Integer expiration_month) {
        this.expirationMonth = expiration_month;
        return this;
    }
    @Column(name="expiration_year")
    public Integer getExpiration_year () {
        return this.expirationYear;
    }

    public CreditCard setExpiration_year (Integer expiration_year) {
        this.expirationYear = expiration_year;
        return this;
    }

    public CreditCard () {
    }
}
