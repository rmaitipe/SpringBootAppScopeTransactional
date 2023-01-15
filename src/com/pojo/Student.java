package com.pojo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {

	@Id
	private int id;
	private String firstName;
	private String lastName;
	boolean isModified;
	private String description;
	
	public Student(int id, String firstName, String lastName) {
		this.id =id;
		this.firstName=firstName;
		this.lastName=lastName;
	}

}
