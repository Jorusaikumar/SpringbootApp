package com.example.SpringBootApp.service;

import com.example.SpringBootApp.dao.PersonDao;
import com.example.SpringBootApp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        //Here we have the option of providing id or not
        //if not provided it will randomly generate a id(see personDao's default method)
        return personDao.insertPerson(person);

    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id,Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }
}
