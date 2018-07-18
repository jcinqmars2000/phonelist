package com.steereengineering.commands;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PhoneListCommand {
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String extension;
	private String cellphone;
	private String options;
}
