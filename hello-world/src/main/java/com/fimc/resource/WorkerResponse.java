package com.fimc.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WorkerResponse implements Serializable {
	private String firstname;
	private String lastname;
	private String birthdate;
}
