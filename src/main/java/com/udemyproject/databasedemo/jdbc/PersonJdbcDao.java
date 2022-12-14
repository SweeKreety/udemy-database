package com.udemyproject.databasedemo.jdbc;

import com.udemyproject.databasedemo.jdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

   class PersonRowMapper implements RowMapper<Person> {
       public Person mapRow(ResultSet rs, int rowNum) throws SQLException{
           Person person= new Person();
           person.setId(rs.getInt("id"));
           person.setName(rs.getString("name"));
           person.setLocation(rs.getString("location"));
           return person;
       }
   }

    public List<Person> findAll(){
        return jdbcTemplate.query("Select * from person", new PersonRowMapper());
    }
    public Person findById(int id){
        return jdbcTemplate.queryForObject("Select * from person where id=?", new Object[]{id},
                new PersonRowMapper());
    }
    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id=?", new Object[]{id});
    }
    public int insert(Person person){
        return jdbcTemplate.update("insert into person(id, name, location) values (?, ?, ?)",
                new Object[]{ person.getId(), person.getName(), person.getLocation()});
    }
    public int update(Person person){
        return jdbcTemplate.update("update person"
                        + " set name= ?, location= ?"
                        + "where id =?",
                new Object[]{ person.getName(), person.getLocation(), person.getId()});
    }
}
