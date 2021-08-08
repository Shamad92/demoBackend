package com.task.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
@AllArgsConstructor
public class Employee {
	private int id;
	private String name;
	private String email;
	private String location;
}
