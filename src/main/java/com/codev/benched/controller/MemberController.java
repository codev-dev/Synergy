package com.codev.benched.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codev.benched.model.Member;
import com.codev.benched.repository.MemberRepository;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable("id") Long id) {
		LOGGER.info("GET v1/members/{}", id);

		try {
			Optional<Member> member = this.repository.findById(id);

			if (member.isPresent()) {
				LOGGER.debug("GET v1/members/{} - OK", id);
				return new ResponseEntity<Member>(member.get(), HttpStatus.OK);
			} else {
				LOGGER.warn("GET v1/members/{} - NOT FOUND", id);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOGGER.error("GET v1/members/{} - ERROR: {}", id, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/query")
	public ResponseEntity<?> findStudentByName(@RequestParam("name") String name) {
		LOGGER.info("GET v1/members/query?name={}", name);

		try {
			List<Member> members = this.repository.findByFirstNameContainingOrLastNameContaining(name, name);

			return new ResponseEntity<>(members, HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("GET v1/members/query?name={} - ERROR: {}", name, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<?> createStudent(@RequestBody Member member) {
		LOGGER.info("POST v1/members/");

		try {
			LOGGER.debug(member.toString());

			this.repository.save(member);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("POST v1/members/ - ERROR: {}", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping
	public ResponseEntity<?> updateStudent(@RequestBody Member member) {
		LOGGER.info("PUT v1/members/");

		try {
			Optional<Member> o = this.repository.findById(member.getId());

			if (o.isPresent()) {
				this.repository.save(member);

				return new ResponseEntity<>(HttpStatus.OK);

			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOGGER.error("PUT v1/members - ERROR: {}", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
		LOGGER.info("DELETE v1/members/{}", id);

		try {
			Optional<Member> member = this.repository.findById(id);

			if (member.isPresent()) {
				this.repository.delete(member.get());
			}

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("DELETE v1/members/{} - ERROR: {}", id, e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<?> listAll() {
		LOGGER.info("GET v1/members/");

		try {
			Iterable<Member> all = this.repository.findAll();

			return new ResponseEntity<>(all, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("GET v1/members/ - ERROR: {}", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}