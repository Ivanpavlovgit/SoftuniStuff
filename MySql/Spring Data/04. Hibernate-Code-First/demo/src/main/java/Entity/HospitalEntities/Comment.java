package Entity.HospitalEntities;

import Entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {


    public Comment () {
    }
}
