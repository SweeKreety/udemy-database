package com.udemyproject.databasedemo.jpa;

import com.udemyproject.databasedemo.jdbc.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {
    //connect to the database
    @PersistenceContext
    //Entity Manager is an interface to the Peristence Context
    EntityManager entityManager;

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }
    public Person update(Person person){
        return entityManager.merge(person);
    }
    public Person insert(Person person){
        return entityManager.merge(person);
    }
    public void deleteById(int id){
        Person person= findById(id);
         entityManager.remove(person);

    }
    }
