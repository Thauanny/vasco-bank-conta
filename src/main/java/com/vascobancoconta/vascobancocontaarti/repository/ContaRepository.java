package com.vascobancoconta.vascobancocontaarti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vascobancoconta.vascobancocontaarti.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    @Query(value = "SELECT * FROM CONTA WHERE user_id = :userId",  nativeQuery = true)
    public Conta retornarConta(@Param("userId") Integer userId);
}
