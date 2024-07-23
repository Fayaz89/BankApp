package com.pack.family.exception;

public class FamilyMemberAlreadyExistsException extends Exception {

	String msg;
	public FamilyMemberAlreadyExistsException(String msg)
	{
		this.msg=msg;
	}
}
