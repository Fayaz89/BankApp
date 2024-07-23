package com.pack.family.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.family.model.FamilyMember;

public interface FamilyMemberService {

	public FamilyMember addFamilyMember(FamilyMember familyMember);
    public List<FamilyMember> getFamilyMembersByUserId(int userId);
    public FamilyMember getFamilyMemberByUserIdAndMemberId(int userId, int memberId);

    public FamilyMember updateFamilyMember(FamilyMember familyMember);

    public void deleteFamilyMember(int memberId) ;
}
