package br.com.fiap.phoenix.APIdaVida.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.fiap.phoenix.APIdaVida.Entity.Usuario;
import br.com.fiap.phoenix.APIdaVida.Repository.UsuarioRepository;

public class AutenticacaoTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UsuarioRepository repository;
	
	public AutenticacaoTokenFilter (TokenService tokenService, UsuarioRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = recuperarToken(request);
		boolean valido = tokenService.isTokenValido(token);
		
		System.out.println(valido);
		if(valido) {
			autenticarUsuario(token);
		}
		System.out.println(token);
		filterChain.doFilter(request, response);
		
	}
	private void autenticarUsuario(String token) {
		// TODO Auto-generated method stub
		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario = repository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken	  authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) { return null; }
		return token.substring(7, token.length());
		
	}

}
