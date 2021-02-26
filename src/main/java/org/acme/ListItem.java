package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.ejb.HibernateEntityManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class ListItem extends PanacheEntity {
    @Column(unique = true)
    @NotBlank
    private String item;

    public ListItem () {}

    public ListItem (String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }
}
