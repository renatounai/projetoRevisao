package br.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.model.Time;
import br.com.service.TimeService;

@RestController()
public class TimeRestController {	
	
	@Autowired	
	private TimeService service;
	
	@GetMapping(value = "/times/{id}")
	public Time selecionarTime(@PathVariable Integer id) {
		return service.selecionarPorId(id);
	}
	
	@PostMapping(value = "/times")
	public void incluir(@RequestBody Time time) {
		service.incluir(time);
	}
	
	@PutMapping(value = "/times")
	public void alterar(@RequestBody Time time) {
		service.alterar(time);
	}
	
	@DeleteMapping(value = "/times/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
