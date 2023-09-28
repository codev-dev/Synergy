package com.codev.benched.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codev.benched.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	
	//For more custom JPA methods, refer to JPA doc for the method naming conversions
	//Ref: https://docs.spring.io/spring-data/jpa/docs/2.2.4.RELEASE/reference/html/#jpa.query-methods.query-creation
	//For example, this will translate to following query:
	//	select s from Student s where s.name like ?1
	List<Student> findByNameContaining(String name);
}
