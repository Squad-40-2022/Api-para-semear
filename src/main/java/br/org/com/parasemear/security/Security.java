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

@EnableWebSecurity
@Configuration
public class Security extends WebSecurityConfigurerAdapter {

	@Autowired
	private ColabAutenticacaoService autenticacaoService;
	@Autowired
	private AdmAutenticacaoService userAutenticacaoService;

	@Autowired
	private ColabTokenService tokenService;
	@Autowired
	private AdmTokenService userTokenService;

	@Autowired
	private ColaboradorRepository clienteRepository;
	@Autowired
	private AdministradorRepository userRepository;

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// CONFIG AUTENTICAÇÂO
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());

		auth.userDetailsService(userAutenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
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
		.and().addFilterBefore(new ColabAutenticacaoTokenFilter(tokenService, clienteRepository), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new AdmAutenticacaoTokenFilter(userTokenService, userRepository), UsernamePasswordAuthenticationFilter.class);

		
	}

	// CONFIG DE RECURSOS ESTATICOS
	@Override
	public void configure(WebSecurity web) throws Exception {

	}

}
