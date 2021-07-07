package Entity.SalesEntities;
import Entity.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {
    private Product product;
    private Customer customer;
    private StoreLocation storeLocation;
    private LocalDateTime date;

    @ManyToOne
    public Product getProduct () {
        return this.product;
    }

    public Sale setProduct (Product product) {
        this.product = product;
        return this;
    }

    @ManyToOne
    public Customer getCustomer () {
        return this.customer;
    }

    public Sale setCustomer (Customer customer) {
        this.customer = customer;
        return this;
    }

    @ManyToOne
    public StoreLocation getStoreLocation () {
        return this.storeLocation;
    }

    public Sale setStoreLocation (StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
        return this;
    }

    public LocalDateTime getDate () {
        return this.date;
    }

    public Sale setDate (LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Sale () {
    }
}
