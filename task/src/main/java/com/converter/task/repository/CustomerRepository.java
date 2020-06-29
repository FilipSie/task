package com.converter.task.repository;

import com.converter.task.models.Customer;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.sql.SQLException;


@Repository
public interface CustomerRepository{
    int save(Customer customer);
    BigInteger getId(Customer customer) throws SQLException;
}
