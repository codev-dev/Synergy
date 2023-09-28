package com.codev.benched.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codev.benched.model.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

	// For more custom JPA methods, refer to JPA doc for the method naming
	// conversions
	// Ref:
	// https://docs.spring.io/spring-data/jpa/docs/2.2.4.RELEASE/reference/html/#jpa.query-methods.query-creation
	// For example, this will translate to following query:
	// select s from Member s where s.first_name like ?1 or s.last_name like ?1
	List<Member> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
