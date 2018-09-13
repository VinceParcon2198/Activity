package com.fimc.resource;

import java.io.Serializable;
import java.sql.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class WorkerRequest implements Serializable{
	
	private String firstName;
	private String lastName;
	private Date birthDate;
	
}
