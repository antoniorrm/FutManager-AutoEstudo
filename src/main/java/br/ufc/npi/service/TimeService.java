package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Jogador;
import br.ufc.npi.bean.Time;
import br.ufc.npi.repositorio.JogadorRepositorio;
import br.ufc.npi.repositorio.TimeRepositorio;

@Service
public class TimeService {
	
	@Autowired
	TimeRepositorio repo;
	
	@Autowired
	JogadorRepositorio Jrepo;
	
	public Time salvarTime(String nome){
		Time time = new Time();
		time.setNome(nome);
		repo.save(time);
		return time;
	}
	
	public List<Time> getTodosTimes(){
		return repo.findAll();
	}
	
	public Time getTime(Integer id){
		return repo.findOne(id);
	}
	
	public boolean addJogadorAoTime(Integer idTime, Integer jogadorSemTimeID) {

		  Time time = repo.findOne(idTime);
		  if(time.getJogadores().size()==7){
		    return false;
		  }else {
		    Jogador jogador =  Jrepo.findOne(jogadorSemTimeID);
		    time.getJogadores().add(jogador);
		    jogador.setTime(time);
		    repo.save(time);
		    Jrepo.save(jogador);
		    return true;
		  }
		}


	public void removerJogadorTime(Integer idTime, Integer jogadorId){
		
		Time time = getTime(idTime);
		Jogador jogador = Jrepo.findOne(jogadorId);
		
		time.getJogadores().remove(jogador);
		jogador.setTime(null);
		
		repo.save(time);
		Jrepo.save(jogador);
	}
	
	
}
