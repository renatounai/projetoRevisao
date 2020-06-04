package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Jogador;
import br.com.repository.JogadorRepository;
import exception.NaoEncontradoException;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository repository;
	
	/*
	 * Optional é uma caixinha de alguma coisa que pode ou não estar vazia
	 * */
	
	public Jogador selecionarPorId(Integer id) {
		return repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Jogador não encontrado!"));
	}
	
	public void alterar(Jogador jogador) {
		if (repository.existsById(jogador.getId())) {
			repository.save(jogador);
		} else {
			throw new NaoEncontradoException("Jogador não encontrado!");
		}
	}
	
	public void incluir(Jogador jogador) {
		if (repository.existsById(jogador.getId())) {
			throw new IllegalArgumentException("Jogador já está cadastrado!");			
		} else {
			repository.save(jogador);
		}
	}
	
	public void delete(Integer id) {
		Jogador jogador = selecionarPorId(id);
		repository.delete(jogador);
	}
}
