package com.pack.family.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FamilyMember")
public class FamilyMember {

    @Id
    private int memberId;
    private int userId; // Reference to the user
    private String name;
    
    @Column(unique = true)
    private String email;
	private String password;
	private String contactNumber;
    private String relation;
    
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public FamilyMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FamilyMember(int memberId, int userId, String name, String email, String password, String contactNumber,
			String relation) {
		super();
		this.memberId = memberId;
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNumber = contactNumber;
		this.relation = relation;
	}
	
	
}
