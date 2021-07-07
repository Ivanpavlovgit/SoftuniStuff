package Entity.SalesEntities;
import Entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String name;
    private String email;
    private String creditCardNumber;
    private Set<Sale> sales;
@OneToMany(mappedBy = "customer")
    public Set<Sale> getSales () {
        return this.sales;
    }

    public Customer setSales (Set<Sale> sales) {
        this.sales = sales;
        return this;
    }

    @Column(name = "name")
    public String getName () {
        return this.name;
    }

    public Customer setName (String name) {
        this.name = name;
        return this;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail () {
        return this.email;
    }

    public Customer setEmail (String email) {
        this.email = email;
        return this;
    }

    @Column(name = "credit_card_number")
    public String getCreditCardNumber () {
        return this.creditCardNumber;
    }

    public Customer setCreditCardNumber (String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        return this;
    }

    public Customer () {
    }
}
