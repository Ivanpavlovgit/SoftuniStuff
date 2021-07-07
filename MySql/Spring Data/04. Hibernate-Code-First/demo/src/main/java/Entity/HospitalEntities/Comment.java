package Entity.HospitalEntities;

import Entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    private String text;

    @Column(name = "text", nullable = false)
    public String getText () {
        return this.text;
    }

    public Comment setText (String text) {
        this.text = text;
        return this;
    }

    public Comment () {
    }
}
