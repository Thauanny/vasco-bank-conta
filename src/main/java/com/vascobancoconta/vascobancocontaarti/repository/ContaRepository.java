package com.vascobancoconta.vascobancocontaarti.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vascobancoconta.vascobancocontaarti.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{
    
}
