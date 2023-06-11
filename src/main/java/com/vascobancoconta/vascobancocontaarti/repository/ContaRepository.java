package com.vascobancoconta.vascobancocontaarti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vascobancoconta.vascobancocontaarti.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    @Query(value = "SELECT * FROM CONTA WHERE user_id = :userId LIMIT 1",  nativeQuery = true)
    public Conta retornarConta(@Param("userId") Integer userId);

    @Query(value = "SELECT * FROM CONTA WHERE chave_pix = :chave_pix LIMIT 1",  nativeQuery = true)
    public Conta buscarChaves(@Param("chave") String chave);

    @Query(value = "SELECT * FROM CONTA WHERE chave_pix = :chave",  nativeQuery = true)
    public Conta retornarContaChavePix(@Param("chave") String chave);



    
}
