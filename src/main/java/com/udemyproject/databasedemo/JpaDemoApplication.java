package com.udemyproject.databasedemo;

import com.udemyproject.databasedemo.jdbc.PersonJdbcDao;
import com.udemyproject.databasedemo.jdbc.entity.Person;
import com.udemyproject.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Inserting -> {}", repository.insert(new Person("Nick", "America")));
		logger.info("Inserting -> {}", repository.insert(new Person("Sam", "Nigeria")));
		logger.info("Inserting -> {}", repository.insert(new Person("Mike", "Netherlands")));
		logger.info("Updating 1->{}", repository.update(new Person(1, "Priyanka", "America")));
		logger.info("User with id 1 -> {}",repository.findById(1));
		repository.deleteById(1);
		logger.info("All users -> {}",repository.findAll());
	}
}
