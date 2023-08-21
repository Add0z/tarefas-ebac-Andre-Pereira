package br.ebac.andre.MemeMeme.repositories;

import br.ebac.andre.MemeMeme.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.sql.Date;
import java.util.List;

public interface MemeRepo extends JpaRepository<Meme, Long> {

    @Query("SELECT m FROM Meme m WHERE m.usuario = :usuario")
    List<Meme> buscaMemesPorUsuario(@Param("usuario") String usuario);

    @Query("SELECT m FROM Meme m WHERE m.categoria = :categoria")
    List<Meme> MemePorCategoria(@Param("categoria") String categoria);

}


//    @Query("SELECT a.nomeRecebedor, COUNT(*) as quantidadeAnimais FROM Animal a WHERE a.dataEntrada >= :startDate AND a.dataEntrada <= :endDate GROUP BY a.nomeRecebedor")
//    List<String> FindEmployees(
//            @Param("startDate") Date startDate,
//            @Param("endDate") Date endDate
//    );