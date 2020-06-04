package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer>{

}
