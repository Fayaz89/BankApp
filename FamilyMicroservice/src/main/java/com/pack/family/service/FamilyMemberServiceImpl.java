package com.pack.family.service;

import com.pack.family.exception.FamilyMemberAlreadyExistsException;
import com.pack.family.exception.FamilyMemberNotFoundException;
import com.pack.family.model.FamilyMember;
import com.pack.family.repository.FamilyMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyMemberServiceImpl {

	@Autowired
	private FamilyMemberRepository familyMemberRepository;

	public FamilyMember addFamilyMember(FamilyMember familyMember) throws FamilyMemberAlreadyExistsException {
		FamilyMember familyMember1 = familyMemberRepository.findById(familyMember.getMemberId()).orElse(null);
		if (familyMember1 != null)
			throw new FamilyMemberAlreadyExistsException("Family memeber already exists");
		return familyMemberRepository.save(familyMember);

	}

	public List<FamilyMember> getFamilyMembersByUserId(int userId) {
		return familyMemberRepository.findByUserId(userId);
	}

	public FamilyMember getFamilyMemberByUserIdAndMemberId(int memberId)
			throws FamilyMemberNotFoundException {
		FamilyMember familyMember = familyMemberRepository.findById(memberId).orElse(null);
		if (familyMember != null) {
			return familyMember;
		}
		throw new FamilyMemberNotFoundException("Family member not found");
	}

	public FamilyMember updateFamilyMember(int memberId,FamilyMember familyMember) throws FamilyMemberNotFoundException {
		FamilyMember familyMember1 = familyMemberRepository.findById(memberId).orElse(null);
		if (familyMember1 != null) {
			familyMember1.setContactNumber(familyMember.getContactNumber());
			familyMember1.setEmail(familyMember.getEmail());
			familyMember1.setName(familyMember.getName());
			familyMember1.setPassword(familyMember.getPassword());
			familyMember1.setRelation(familyMember.getRelation());
			return familyMemberRepository.save(familyMember1);
		}
		throw new FamilyMemberNotFoundException("Family member not found");
	}

	public FamilyMember deleteFamilyMember(int memberId) throws FamilyMemberNotFoundException {
		FamilyMember familyMember = familyMemberRepository.findById(memberId).orElse(null);
		if (familyMember != null) {
			familyMemberRepository.delete(familyMember);
			return familyMember;
		}
		throw new FamilyMemberNotFoundException("Family member not found");
	}
	
	public FamilyMember loginUser(String email, String password) throws FamilyMemberNotFoundException {

		FamilyMember familyMember = familyMemberRepository.findByEmailAndPassword(email,password).orElse(null);
		if (familyMember != null) {
			return familyMember;

		} else {
			throw new FamilyMemberNotFoundException("Family member not found");
		}

	}
}
