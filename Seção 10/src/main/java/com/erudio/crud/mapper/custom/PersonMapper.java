package com.erudio.crud.mapper.custom;

import com.erudio.crud.da.vo.v2.PersonVOV2;
import com.erudio.crud.models.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setBirthday(new Date());
        vo.setGender(person.getGender());
        vo.setAddress(person.getAddress());
        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        //entity.setBirthday(new Date());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());
        return entity;
    }
}
