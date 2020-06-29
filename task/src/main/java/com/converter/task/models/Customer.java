package com.converter.task.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.math.BigInteger;
import java.util.Set;

@Table(value = "customers")
public class Customer {

    @Id
    BigInteger id;
    @Column(value = "NAME")
    String name;
    @Column(value = "SURNAME")
    String surname;
    @Column(value = "AGE")
    BigInteger age = null;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contact> contactSet;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigInteger getAge() {
        return age;
    }

    public void setAge(BigInteger age) {
        this.age = age;
    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<Contact> contactSet) {
        this.contactSet = contactSet;
    }

    public Customer(String name, String surname, BigInteger age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
