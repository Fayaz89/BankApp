package com.pack.family.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.family.model.FamilyMember;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Integer>{

	List<FamilyMember> findByUserId(int userId);
    Optional<FamilyMember> findByUserIdAndMemberId(int userId, int memberId);
}
