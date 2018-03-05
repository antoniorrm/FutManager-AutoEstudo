package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Jogador;
import br.ufc.npi.repositorio.JogadorRepositorio;

@Service
public class JogadorService {

	@Autowired
	JogadorRepositorio repo;
	
	public Jogador salvarJogador(String nome, Integer idade){
		Jogador jogador = new Jogador();
		jogador.setNome(nome);
		jogador.setIdade(idade);
		repo.save(jogador);
		
		return jogador;
	}
	
	public List<Jogador> getTodosJogadores(){
		return repo.findAll();
	}
	
	public List<Jogador> getJogadoresSemTime(){
		return repo.buscarJogadorSemTime();
	}
}
