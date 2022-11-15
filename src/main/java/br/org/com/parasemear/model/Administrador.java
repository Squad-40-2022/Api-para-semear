package br.org.com.parasemear.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Administrador implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "cpf_adm", nullable = false, length = 14, unique = true)
	private String cpf;
	@Column(name = "nome_adm", nullable = false, length = 30)
	private String nome;
	@Column(name = "sobrenome_adm", nullable = false, length = 50)
	private String sobrenome;
	@Column(name = "telefone_adm", nullable = false, length = 15)
	private String telefone;
	@Column(name = "email_adm", nullable = false, length = 100, unique = true)
	private String email;
	@Column(name = "senha_adm", nullable = false, length = 20)
	private String senha;
	@Column(name = "uf_adm", nullable = false, length = 2)
	private String uf;
	@Column(name = "cidade_adm", nullable = false)
	private String cidade;
	@Column(name = "bairro_adm", nullable = false)
	private String bairro;
	@Column(name = "name = logradouro_adm", nullable = false)
	private String logradouro;
	@Column(name = "cep_adm", nullable = false)
	private String cep;
	@Column(name = "numero_adm", nullable = false)
	private String numero;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNasc;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Perfil> perfis = new ArrayList<>();

	public Administrador() {
	}

	public Administrador(String cpf, String nome, String sobrenome, String telefone, String email,
			String senha, String uf, String cidade, String bairro, String logradouro, String cep, String numero,
			LocalDate dataNasc) {
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.dataNasc = dataNasc;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Administrador id(long id) {
		setId(id);
		return this;
	}

	public Administrador cpf(String cpf) {
		setCpf(cpf);
		return this;
	}

	public Administrador nome(String nome) {
		setNome(nome);
		return this;
	}

	public Administrador sobrenome(String sobrenome) {
		setSobrenome(sobrenome);
		return this;
	}

	public Administrador telefone(String telefone) {
		setTelefone(telefone);
		return this;
	}

	public Administrador email(String email) {
		setEmail(email);
		return this;
	}

	public Administrador senha(String senha) {
		setSenha(senha);
		return this;
	}

	public Administrador uf(String uf) {
		setUf(uf);
		return this;
	}

	public Administrador cidade(String cidade) {
		setCidade(cidade);
		return this;
	}

	public Administrador bairro(String bairro) {
		setBairro(bairro);
		return this;
	}

	public Administrador logradouro(String logradouro) {
		setLogradouro(logradouro);
		return this;
	}

	public Administrador cep(String cep) {
		setCep(cep);
		return this;
	}

	public Administrador numero(String numero) {
		setNumero(numero);
		return this;
	}

	public Administrador dataNasc(LocalDate dataNasc) {
		setDataNasc(dataNasc);
		return this;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, cpf, dataNasc, email, id, logradouro, nome, numero, perfis, senha,
				sobrenome, telefone, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataNasc, other.dataNasc) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(nome, other.nome)
				&& Objects.equals(numero, other.numero) && Objects.equals(perfis, other.perfis)
				&& Objects.equals(senha, other.senha) && Objects.equals(sobrenome, other.sobrenome)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(uf, other.uf);
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
