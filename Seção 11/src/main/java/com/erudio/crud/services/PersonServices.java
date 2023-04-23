package com.erudio.crud.services;
import com.erudio.crud.da.vo.v1.PersonVO;
import com.erudio.crud.exceptions.ResourceNotFoundException;
import com.erudio.crud.mapper.DozerMapper;
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

    public PersonVO findById(Long id) {
        logger.info("Finding One PersonVO");
        var entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("Finding all people!");

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one PersonVO!");

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = repository.save(entity);

        return DozerMapper.parseObject(vo, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        logger.info("updating one PersonVO!");
        var entity = repository.findById(person.getId()).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public void delete(Long id) {
        logger.info("deleting one PersonVO!");
        Person entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        repository.delete(entity);
    }


}
