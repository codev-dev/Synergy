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
public class Project {

	@Id
	@Column(name = "id")
	private Long id; // id

	@Column(name = "name")
	private String name;

	@Column(name = "start_date", columnDefinition = "DATE")
	private LocalDate startDate;

	@Column(name = "end_date", columnDefinition = "DATE")
	private LocalDate endDate;

	@Column(name = "status")
	private int status;

	@Column(name = "deleted")
	private boolean deleted = Boolean.FALSE;

}
