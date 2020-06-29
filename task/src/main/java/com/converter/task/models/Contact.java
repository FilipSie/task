package com.converter.task.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Table(value = "contacts")
public class Contact {

    @Id
    BigInteger id;
    @ManyToOne
    @JoinColumn(name = "ID_CUSTOMER")
    BigInteger idCustomer;
    @Column(value = "TYPE")
    Integer type;
    @Column(value = "CONTACT")
    String contact;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public BigInteger getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(BigInteger idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Contact(BigInteger idCustomer, Integer type, String contact) {
        this.idCustomer = idCustomer;
        this.type = type;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", idCustomer=" + idCustomer +
                ", type=" + type +
                ", contact='" + contact + '\'' +
                '}';
    }
}
