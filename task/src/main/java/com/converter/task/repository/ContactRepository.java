package com.converter.task.repository;

import com.converter.task.models.Contact;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository {
    int save(Contact contact);
}
