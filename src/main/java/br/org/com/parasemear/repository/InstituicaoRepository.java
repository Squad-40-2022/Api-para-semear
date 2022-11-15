package br.org.com.parasemear.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.com.parasemear.model.Instituicao;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long>{
	Optional<Instituicao> findByEmail(String email);
	Instituicao findByRazao(String razaoIns);
}
