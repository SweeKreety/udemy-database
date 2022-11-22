package com.udemyproject.databasedemo;

import com.udemyproject.databasedemo.jdbc.PersonJdbcDao;
import com.udemyproject.databasedemo.jdbc.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	logger.info("All users -> {}",dao.findAll());
		logger.info("User with id 1001 -> {}",dao.findById(1001));
		logger.info("Deleting User 1001 -> No. of rows deleted- {}",dao.deleteById(1001));
		logger.info("Inserting 1004 -> {}", dao.insert(new Person(1004, "Nick", "America")));
		logger.info("Updating 1003->{}", dao.update(new Person(1003, "Priyanka", "India")));
	}
}
