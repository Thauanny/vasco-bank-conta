
package com.vascobancoconta.vascobancocontaarti.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vascobancoconta.vascobancocontaarti.models.Extrato;

@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Integer>{


   // @Query("SELECT * FROM EXTRATO s WHERE s.id_conta = ?idConta AND s.dia = ?dia")
   // public Extrato extratoDia(@Param("idConta") Integer idConta,@Param("dia") Integer dia);

   // @Query("SELECT * FROM EXTRATO s WHERE s.id_conta = ?idConta AND s.ano = ?ano")
   // public Extrato extratoAno(@Param("idConta") Integer idConta,@Param("ano") Integer ano);

   // @Query("SELECT * FROM EXTRATO s WHERE s.id_conta = ?idConta AND s.mes = ?mes")
   // public Extrato extratoMes(@Param("idConta") Integer idConta,@Param("mes") Integer mes);

   
    
}