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
public class Instituicao implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "cnpj_ins", nullable = false, length = 18, unique = true)
	private String cnpj;
	@Column(name = "razao_ins", nullable = false, length = 100)
	private String razao;
	@Column(name = "nomeFan_ins", nullable = false, length = 50)
	private String nomeFan;
	@Column(name = "nomeRes_ins", nullable = false, length = 100)
	private String nomeRes;
	@Column(name = "telefone_ins", nullable = false, length = 15)
	private String telefone;
	@Column(name = "email_ins", nullable = false, length = 100, unique = true)
	private String email;
	@Column(name = "senha_ins", nullable = false, length = 20)
	private String senha;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_ins", nullable = false)
	private Endereco endereco;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	
	public Instituicao() {
	}
	public Instituicao(String cnpj, String razao, String nomeFan, String nomeRes, String telefone, String email,
			String senha, Endereco endereco) {
		this.cnpj = cnpj;
		this.razao = razao;
		this.nomeFan = nomeFan;
		this.nomeRes = nomeRes;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
	}
	public String getNomeFan() {
		return nomeFan;
	}
	public void setNomeFan(String nomeFan) {
		this.nomeFan = nomeFan;
	}
	public String getNomeRes() {
		return nomeRes;
	}
	public void setNomeRes(String nomeRes) {
		this.nomeRes = nomeRes;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Instituicao id(long id) {
		setId(id);
		return this;
	}
	public Instituicao cnpj(String cnpj) {
		setCnpj(cnpj);
		return this;
	}
	public Instituicao razao(String razao) {
		setRazao(razao);
		return this;
	}
	public Instituicao nomeFan(String nomeFan) {
		setNomeFan(nomeFan);
		return this;
	}
	public Instituicao telefone(String telefone) {
		setTelefone(telefone);
		return this;
	}
	public Instituicao email(String email) {
		setEmail(email);
		return this;
	}
	public Instituicao senha(String senha) {
		setSenha(senha);
		return this;
	}
	public Instituicao endereco(Endereco endereco) {
		setEndereco(endereco);
		return this;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cnpj, email, endereco, id, nomeFan, nomeRes, perfis, razao, senha, telefone);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instituicao other = (Instituicao) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && id == other.id && Objects.equals(nomeFan, other.nomeFan)
				&& Objects.equals(nomeRes, other.nomeRes) && Objects.equals(perfis, other.perfis)
				&& Objects.equals(razao, other.razao) && Objects.equals(senha, other.senha)
				&& Objects.equals(telefone, other.telefone);
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
