package br.org.com.parasemear.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.com.parasemear.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long>{
	Optional<Administrador> findByEmail(String email);
	Administrador findByNome(String nomeUser);
}
