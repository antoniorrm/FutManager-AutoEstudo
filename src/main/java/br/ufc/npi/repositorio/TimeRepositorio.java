package br.ufc.npi.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.npi.bean.Time;

@Repository
@Transactional
public interface TimeRepositorio extends JpaRepository<Time, Integer>{
	Time findByNome(String nome);
}
