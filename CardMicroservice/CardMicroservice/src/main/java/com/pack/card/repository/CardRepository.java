package com.pack.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pack.card.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String>{

}
