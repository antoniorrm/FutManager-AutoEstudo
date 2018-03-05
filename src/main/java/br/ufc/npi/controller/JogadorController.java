package br.ufc.npi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.npi.bean.Jogador;

import br.ufc.npi.service.JogadorService;

@Controller
@RequestMapping(path="/jogadores/")
public class JogadorController {
	
	@Autowired
	JogadorService service;
	
	@RequestMapping(path="/")
	public ModelAndView index (){
		
		ModelAndView model = new ModelAndView("jogadores");
		List<Jogador> jogadores= service.getTodosJogadores();
		model.addObject("jogadores", jogadores);
		return model;
	}
	
	@RequestMapping(path="/salvar", method=RequestMethod.POST)
	public String salvarTime(@RequestParam String nomeJogador, @RequestParam Integer idadeJogador){
		service.salvarJogador(nomeJogador, idadeJogador);
		
		return "redirect:/jogadores/";
	}
}
