package br.ufc.npi.repositorio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ufc.npi.bean.Jogador;

@Transactional
@Repository
public interface JogadorRepositorio extends JpaRepository<Jogador, Integer>{
	Jogador findByNome(String nome);
	
	@Query("from Jogador j where j.time is null")
	List<Jogador> buscarJogadorSemTime();
}
