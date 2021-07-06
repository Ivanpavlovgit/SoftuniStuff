package Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
    private long id;

    public BaseEntity (long id) {
        this.id = id;
    }
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId () {
        return this.id;
    }

    public BaseEntity () {
    }

    public BaseEntity setId (long id) {
        this.id = id;
        return this;
    }
}