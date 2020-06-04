package br.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Time;
import br.com.repository.TimeRepository;
import exception.NaoEncontradoException;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository repository;
	
	/*
	 * Optional é uma caixinha de alguma coisa que pode ou não estar vazia
	**/
	public Time selecionarPorId(Integer id) {
		return repository.findById(id).orElseThrow(() -> new NaoEncontradoException("Time não encontrado!"));
	}
	
	public void alterar(Time time) {
		if (repository.existsById(time.getId())) {
			repository.save(time);
		} else {
			throw new NaoEncontradoException("Time não encontrado!");
		}
	}
	
	public void incluir(Time time) {
		if (repository.existsById(time.getId())) {
			throw new IllegalArgumentException("Time já está cadastrado!");			
		} else {
			repository.save(time);
		}
	}
	
	public void delete(Integer id) {
		Time time = selecionarPorId(id);
		repository.delete(time);
	}
}
