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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Colaborador implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "cpf_col", nullable = false, length = 14, unique = true)
	private String cpf;
	@Column(name = "nome_col", nullable = false, length = 30)
	private String nome;
	@Column(name = "sobrenome_col", nullable = false, length = 50)
	private String sobrenome;
	@Column(name = "genero_col", nullable = false, length = 30)
	private String genero;
	@Column(name = "telefone_col", nullable = false, length = 15)
	private String telefone;
	@Column(name = "email_col", nullable = false, length = 100, unique = true)
	private String email;
	@Column(name = "senha_col", nullable = false, length = 20)
	private String senha;
	@Column(name = "voluntario", nullable = false, length = 1)
	private String voluntario;
	@Column(name = "disp_col", nullable = false, length = 75)
	private String disponibilidade;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_col", nullable = false)
	private Endereco endereco;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNasc;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();
	
	@OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<Doacao> doacoes;

	public Colaborador() {
	}

	public Colaborador(String cpf, String nome, String sobrenome, String genero, String telefone, String email,
			String senha, String voluntario, String disponibilidade, Endereco endereco, LocalDate dataNasc) {
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.genero = genero;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.voluntario = voluntario;
		this.disponibilidade = disponibilidade;
		this.endereco = endereco;
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
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
	public List<Doacao> getDoacoes() {
		return doacoes;
	}
	public void setDoacoes(List<Doacao> doacoes) {
		this.doacoes = doacoes;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
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
	public Colaborador genero(String genero) {
		setGenero(genero);
		return this;
	}
	public Colaborador telefone(String telefone) {
		setTelefone(telefone);
		return this;
	}
	public Colaborador email(String email) {
		setEmail(email);
		return this;
	}
	public Colaborador senha(String senha) {
		setSenha(senha);
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
	public Colaborador endereco(Endereco endereco) {
		setEndereco(endereco);
		return this;
	}
	public Colaborador dataNasc(LocalDate dataNasc) {
		setDataNasc(dataNasc);
		return this;
	}
	public Colaborador doacoes(List<Doacao> doacoes) {
		setDoacoes(doacoes);
		return this;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataNasc, disponibilidade, email, endereco, genero, id, nome, perfis, senha, sobrenome,
				telefone, voluntario);
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
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataNasc, other.dataNasc)
				&& Objects.equals(disponibilidade, other.disponibilidade) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(genero, other.genero) && id == other.id
				&& Objects.equals(nome, other.nome) && Objects.equals(perfis, other.perfis)
				&& Objects.equals(senha, other.senha) && Objects.equals(sobrenome, other.sobrenome)
				&& Objects.equals(telefone, other.telefone) && voluntario == other.voluntario;
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
