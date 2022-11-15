package br.org.com.parasemear.model;

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	@Column(name = "uf_ins", nullable = false, length = 2)
    private String uf;
    @Column(name = "cidade_ins", nullable = false)
    private String cidade;
    @Column(name = "bairro_ins", nullable = false)
    private String bairro;
    @Column(name = "name = logradouro_ins", nullable = false)
    private String logradouro;
    @Column(name = "cep_ins", nullable = false)
    private String cep;
    @Column(name = "numero_ins", nullable = false)
    private String numero;
    
    @ManyToMany(fetch = FetchType.LAZY)
	private List<Perfil> perfis = new ArrayList<>();
	
	@OneToMany(mappedBy = "instituicao", fetch = FetchType.LAZY)
    private List<Doacao> doacoes;
	
	@OneToMany(mappedBy = "instituicao", fetch = FetchType.LAZY)
    private List<Relatorio> relatorios;
	
	@OneToMany(mappedBy = "instituicao", fetch = FetchType.LAZY)
    private List<Projeto> projetos;
	
	public Instituicao() {
	}
	
	public Instituicao(String cnpj, String razao, String nomeFan, String nomeRes, String telefone,
			String email, String senha, String uf, String cidade, String bairro, String logradouro, String cep,
			String numero) {
		this.cnpj = cnpj;
		this.razao = razao;
		this.nomeFan = nomeFan;
		this.nomeRes = nomeRes;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
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
	public Instituicao uf(String uf) {
		setUf(uf);
		return this;
	}
	public Instituicao cidade(String cidade) {
		setCidade(cidade);
		return this;
	}
	public Instituicao bairro(String bairro) {
		setBairro(bairro);
		return this;
	}
	public Instituicao logradouro(String logradouro) {
		setLogradouro(logradouro);
		return this;
	}
	public Instituicao cep(String cep) {
		setCep(cep);
		return this;
	}
	public Instituicao numero(String numero) {
		setNumero(numero);
		return this;
	}
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, cnpj, doacoes, email, id, logradouro, nomeFan, nomeRes, numero, perfis,
				projetos, razao, relatorios, senha, telefone, uf);
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
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(doacoes, other.doacoes) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(nomeFan, other.nomeFan)
				&& Objects.equals(nomeRes, other.nomeRes) && Objects.equals(numero, other.numero)
				&& Objects.equals(perfis, other.perfis) && Objects.equals(projetos, other.projetos)
				&& Objects.equals(razao, other.razao) && Objects.equals(relatorios, other.relatorios)
				&& Objects.equals(senha, other.senha) && Objects.equals(telefone, other.telefone)
				&& Objects.equals(uf, other.uf);
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
