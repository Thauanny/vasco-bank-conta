package com.vascobancoconta.vascobancocontaarti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vascobancoconta.vascobancocontaarti.models.Cheque;

@Repository
public interface ChequeRepository extends JpaRepository<Cheque, Integer> {
    // @Query("SELECT * FROM CHEQUE s WHERE s.id_conta = ?idConta")
    // public List<Cheque> cheques(@Param("idConta") Integer idConta);

}
