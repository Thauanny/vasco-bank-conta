package com.vascobancoconta.vascobancocontaarti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vascobancoconta.vascobancocontaarti.models.Cheque;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Integer> {
    @Modifying
    @Query(value = "SELECT * FROM CHEQUE WHERE conta_id = :idConta",  nativeQuery = true)
    public List<Cheque> cheques(@Param("idConta") Integer idConta);



}
