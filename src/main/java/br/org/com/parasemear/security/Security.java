package br.org.com.parasemear.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.org.com.parasemear.repository.AdministradorRepository;
import br.org.com.parasemear.repository.ColaboradorRepository;
import br.org.com.parasemear.repository.InstituicaoRepository;

@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter {

	@Autowired
	private AdmAutenticacaoService admAutenticacaoService;
	@Autowired
	private ColabAutenticacaoService colabAutenticacaoService;
	@Autowired
	private InsAutenticacaoService insAutenticacaoService;

	@Autowired
	private AdmTokenService admTokenService;
	@Autowired
	private ColabTokenService colabTokenService;
	@Autowired
	private InsTokenService insTokenService;

	@Autowired
	private AdministradorRepository admRepository;
	@Autowired
	private ColaboradorRepository colabRepository;
	@Autowired
	private InstituicaoRepository insRepository;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// CONFIG AUTENTICAÇÂO
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(admAutenticacaoService).passwordEncoder(new BCryptPasswordEncoder());

		auth.userDetailsService(colabAutenticacaoService).passwordEncoder(new BCryptPasswordEncoder());

		auth.userDetailsService(insAutenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}

	// CONFIG DE AUTORIZAÇÂO
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeHttpRequests()
		.antMatchers(HttpMethod.POST, "/adm/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.GET, "/adm/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.GET, "/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.PUT, "/adm/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/adm/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.antMatchers(HttpMethod.POST, "/**").permitAll()
		.antMatchers(HttpMethod.POST, "/user/auth").permitAll()
		.antMatchers(HttpMethod.POST, "/user/cadastrar").permitAll()
		.antMatchers(HttpMethod.GET, "/user/listar").permitAll()
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AdmTokenFilter(admTokenService, admRepository), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new ColabTokenFilter(colabTokenService, colabRepository), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new InsTokenFilter(insTokenService, insRepository), UsernamePasswordAuthenticationFilter.class);

		
	}

	// CONFIG DE RECURSOS ESTATICOS
	@Override
	public void configure(WebSecurity web) throws Exception {

	}

}
