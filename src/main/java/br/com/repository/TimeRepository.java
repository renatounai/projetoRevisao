package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Integer> {
	
}
