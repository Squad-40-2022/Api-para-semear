package br.org.com.parasemear.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Colaborador implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cpf, nome, sobrenome, telefone, senha, email, logradouro, cidade, uf, voluntario, disponibilidade;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate nasc;
	

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();

	public Colaborador() {
		super();
	}

	public Colaborador(String cpf, String nome, String sobrenome, String telefone, String senha, String email,
			String logradouro, String cidade, String uf, String voluntario, String disponibilidade, LocalDate nasc) {
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.senha = senha;
		this.email = email;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
		this.voluntario = voluntario;
		this.disponibilidade = disponibilidade;
		this.nasc = nasc;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(String voluntario) {
		this.voluntario = voluntario;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public LocalDate getNasc() {
		return nasc;
	}

	public void setNasc(LocalDate nasc) {
		this.nasc = nasc;
	}

	public Colaborador id(long id) {
		setId(id);
		return this;
	}

	public Colaborador cpf(String cpf) {
		setCpf(cpf);
		return this;
	}

	public Colaborador nome(String nome) {
		setNome(nome);
		return this;
	}

	public Colaborador sobrenome(String sobrenome) {
		setSobrenome(sobrenome);
		return this;
	}

	public Colaborador telefone(String telefone) {
		setTelefone(telefone);
		return this;
	}

	public Colaborador senha(String senha) {
		setSenha(senha);
		return this;
	}

	public Colaborador email(String email) {
		setEmail(email);
		return this;
	}

	public Colaborador logradouro(String logradouro) {
		setLogradouro(logradouro);
		return this;
	}

	public Colaborador cidade(String cidade) {
		setCidade(cidade);
		return this;
	}

	public Colaborador uf(String uf) {
		setUf(uf);
		return this;
	}

	public Colaborador voluntario(String voluntario) {
		setVoluntario(voluntario);
		return this;
	}

	public Colaborador disponibilidade(String disponibilidade) {
		setDisponibilidade(disponibilidade);
		return this;
	}

	public Colaborador nasc(LocalDate nasc) {
		setNasc(nasc);
		return this;
	}

	


	@Override
	public int hashCode() {
		return Objects.hash(cidade, cpf, disponibilidade, email, id, logradouro, nasc, nome, perfis, senha, sobrenome,
				telefone, uf, voluntario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(disponibilidade, other.disponibilidade) && Objects.equals(email, other.email)
				&& id == other.id && Objects.equals(logradouro, other.logradouro) && Objects.equals(nasc, other.nasc)
				&& Objects.equals(nome, other.nome) && Objects.equals(perfis, other.perfis)
				&& Objects.equals(senha, other.senha) && Objects.equals(sobrenome, other.sobrenome)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(uf, other.uf)
				&& Objects.equals(voluntario, other.voluntario);
	}

	@Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return this.perfis;
	  }

	  @Override
	  public String getPassword() {
	    return this.senha;
	  }

	  @Override
	  public String getUsername() {
	    return this.email;
	  }

	  @Override
	  public boolean isAccountNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return true;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return true;
	  }

	  @Override
	  public boolean isEnabled() {
	    return true;
	  }

}
