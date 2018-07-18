package com.steereengineering.com.Intranet;

import lombok.Data;
import lombok.NonNull;


@Data
public class LombokModel {

	private @NonNull String name;
	private @NonNull String age;
	private @NonNull String address;

	// No Getters and Setters, hashCode, Equal-- even though we can refer it from client code.
	// This is how we are taking help from Lombok to get rid of boiler plate code.
}	