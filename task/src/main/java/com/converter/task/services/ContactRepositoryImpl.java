package com.converter.task.services;

import com.converter.task.models.Contact;
import com.converter.task.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


@Service
public class ContactRepositoryImpl implements ContactRepository {
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

    public int save(Contact contact) {
        return jdbcTemplate.update("INSERT INTO persons.contacts (ID_CUSTOMER,TYPE,CONTACT) values (?, ?, ?)",
                contact.getIdCustomer(), contact.getType(),contact.getContact());
    }


}
