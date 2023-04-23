package com.erudio.crud.services;
import com.erudio.crud.exceptions.ResourceNotFoundException;
import com.erudio.crud.models.Person;
import com.erudio.crud.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {


    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id) {
        logger.info("Finding One Person");


        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }

    public List<Person> findAll() {
        logger.info("Finding all people!");

        return repository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("updating one person!");
        Person entity = repository.findById(person.getId()).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("deleting one person!");
        Person entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }


}
