package com.pack.family.controller;

import com.pack.family.exception.FamilyMemberAlreadyExistsException;
import com.pack.family.exception.FamilyMemberNotFoundException;
import com.pack.family.model.FamilyMember;
import com.pack.family.model.Login;
import com.pack.family.response.ResponseHandler;
import com.pack.family.service.FamilyMemberService;
import com.pack.family.service.FamilyMemberServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/families/members")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberServiceImpl familyMemberService;
    
    @PostMapping
    public ResponseEntity<Object> addFamilyMember(@RequestBody FamilyMember familyMember) throws FamilyMemberAlreadyExistsException {
       
        return ResponseHandler.generateResponse("Family member added successfully", HttpStatus.CREATED,
    			familyMemberService.addFamilyMember(familyMember));
    }

    @GetMapping("/getAll/{userId}")
    public ResponseEntity<Object> getAllFamilyMembers(@PathVariable int userId) {
    	List<FamilyMember> family=familyMemberService.getFamilyMembersByUserId(userId);
    	if(family.isEmpty())
    	{
    		return ResponseHandler.generateResponse("No family members found", HttpStatus.INTERNAL_SERVER_ERROR,"Family members are not added for the given user Id");
    	}
    	return ResponseHandler.generateResponse("Retrieved all family members successfully", HttpStatus.OK,
    			familyMemberService.getFamilyMembersByUserId(userId));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Object> getFamilyMember(@PathVariable int memberId) throws FamilyMemberNotFoundException {
    	return ResponseHandler.generateResponse("Retrieved family member with given Id successfully", HttpStatus.OK,
    			familyMemberService.getFamilyMemberByUserIdAndMemberId( memberId));
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<Object> updateFamilyMember(@PathVariable int memberId, @RequestBody FamilyMember familyMember) throws FamilyMemberNotFoundException {
        
        return ResponseHandler.generateResponse("Updated family member details successfully", HttpStatus.OK,
    			familyMemberService.updateFamilyMember(memberId,familyMember));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Object> deleteFamilyMember(@PathVariable int memberId) throws FamilyMemberNotFoundException {
    	return ResponseHandler.generateResponse("Deleted family member successfully", HttpStatus.OK,
    			familyMemberService.deleteFamilyMember(memberId));
    }
    
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Login login) throws FamilyMemberNotFoundException{
			
		return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK,
				familyMemberService.loginUser(login.getEmail(), login.getPassword()));
	}
}
