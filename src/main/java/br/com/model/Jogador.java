package br.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Define que essa classe representa uma tabela no banco de dados
@Getter // Gera os métodos get de forma automática
@Setter // Gera os métodos set de forma automática
@NoArgsConstructor // Gera um construtor sem parâmetro
@AllArgsConstructor // Gera um construtor que tem como parâmetro todas as propriedades da classe 
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Cria os métodos equals e hashcode para comparar dois objetos
public class Jogador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String nome;	
	 
	/*
	  * Sempre que eu tenho apenas um objeto na minha classe, será um ManyToOne. 
	  * Se fosse uma lista de objetos, seria um OneToMany.
	  * */
	@ManyToOne
	private Time time;
}
