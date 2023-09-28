package com.codev.benched.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class Member {

	@Id
	@Column(name = "id")
	private Long id; // id

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName; // name

	@Column(name = "role")
	private int role;

	@Column(name = "team_id")
	private int teamId; // name

	@Column(name = "bench_start_date", columnDefinition = "DATE")
	private LocalDate benchStartDate;

	@Column(name = "bench_end_date", columnDefinition = "DATE")
	private LocalDate benchEndDate;

	@Column(name = "status")
	private int status;

	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;

}
