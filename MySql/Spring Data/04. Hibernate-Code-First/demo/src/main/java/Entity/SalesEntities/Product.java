package Entity.SalesEntities;

import javax.persistence.*;
import java.math.BigDecimal;
import Entity.BaseEntity;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private Set<Sale> sales = new HashSet<Sale> ();

    public Product () {
    }

    @Column(name = "name", unique = true)
    public String getName () {
        return this.name;
    }

    public Product setName (String name) {
        this.name = name;
        return this;
    }

    @Column(name = "quantity")
    public Integer getQuantity () {
        return this.quantity;
    }

    public Product setQuantity (Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @Column(name = "price")
    public BigDecimal getPrice () {
        return this.price;
    }

    public Product setPrice (BigDecimal price) {
        this.price = price;
        return this;
    }

    @OneToMany(mappedBy = "product",cascade = CascadeType.PERSIST)
    public Set<Sale> getSales () {
        return this.sales;
    }

    public Product setSales (Set<Sale> sales) {
        this.sales = sales;
        return this;
    }
}

