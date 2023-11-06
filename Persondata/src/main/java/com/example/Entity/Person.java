package com.example.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity 
@NoArgsConstructor
@AllArgsConstructor
@Table(name="full_stack")
public class Person {

	@Id
	@GeneratedValue
	private Integer pid;
	@Pattern(regexp = "^[A-Z][a-z]*$",message = "Name starts with UPPERCASE only")
	private String pname;

	@Pattern(regexp = "^[6-9][0-9]{9}$",message = "mobile number starts between 6 to 9 And number must consist of 10 digits")
	private String pnum;
	@Min(18)
	@Max(60)
	private Integer page;
	private String padd;
	
}
