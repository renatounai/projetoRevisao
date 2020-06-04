package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.model.Jogador;
import br.com.service.JogadorService;

@RestController
public class JogadorRestController {
	
	@Autowired
	private JogadorService service;
	
	@GetMapping(value = "/jogadores/{id}")
	public Jogador selecionarJogador(@PathVariable Integer id) {
		return service.selecionarPorId(id);
	}
	
	@PostMapping(value = "/jogadores")
	public void incluir(@RequestBody Jogador jogador) {
		service.incluir(jogador);
	}
	
	@PutMapping(value = "/jogadores")
	public void alterar(@RequestBody Jogador jogador) {
		service.alterar(jogador);
	}
	
	@DeleteMapping(value = "/jogadores/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
