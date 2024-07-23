package com.pack.family.exception;

public class FamilyMemberNotFoundException extends Exception {

	String msg;
	public FamilyMemberNotFoundException(String msg)
	{
		this.msg=msg;
	}
}
