package Entity.SalesEntities;
import Entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name ="store_locations")
public class StoreLocation  extends BaseEntity {
    private String locationName;
@Column(name = "location_name",nullable = false)
    public String getLocationName () {
        return this.locationName;
    }
private Set<Sale> sales;
@OneToMany(mappedBy = "storeLocation")
    public Set<Sale> getSales () {
        return this.sales;
    }

    public StoreLocation setSales (Set<Sale> sales) {
        this.sales = sales;
        return this;
    }

    public StoreLocation setLocationName (String locationName) {
        this.locationName = locationName;
        return this;
    }

    public StoreLocation () {
    }
}
