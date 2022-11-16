package br.org.com.parasemear.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.com.parasemear.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{
	Optional<Colaborador> findByEmail(String email);
	Colaborador findByNome(String nomeCliente);
}
