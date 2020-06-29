package com.converter.task.services;

import com.converter.task.models.Customer;
import com.converter.task.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.*;


@Service
public class CustomerRepositoryImpl implements CustomerRepository {

    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/persons?useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("app");
        dataSource.setPassword("mysql123456789");
        return dataSource;
    }

    @Autowired
    public JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());

    public int save(Customer customer){
        return jdbcTemplate.update("INSERT INTO persons.customers (NAME,SURNAME,AGE) VALUES (?, ?, ?)",
                customer.getName(),customer.getSurname(),customer.getAge());
    }

    @Override
    public BigInteger getId(Customer customer) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/persons?useLegacyDatetimeCode=false&serverTimezone=UTC","app","mysql123456789");
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        String query = "INSERT INTO persons.customer (ID, NAME, SURNAME, AGE) VALUES (?, ?, ?, ?)";
        preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next() && resultSet != null){
            return (BigInteger) resultSet;
        }else {
            return null;
        }
    }


}
