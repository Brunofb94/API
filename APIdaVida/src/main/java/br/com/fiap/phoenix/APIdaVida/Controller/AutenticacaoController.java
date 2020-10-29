package br.com.fiap.phoenix.APIdaVida.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.phoenix.APIdaVida.Entity.Login;
import br.com.fiap.phoenix.APIdaVida.Security.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenServices;
	
	@PostMapping
	public ResponseEntity<?> aunteticar(@RequestBody @Valid Login usuario) {
		UsernamePasswordAuthenticationToken dadoslogin = new UsernamePasswordAuthenticationToken(usuario.getEmail(),usuario.getSenha());
		
		try {
			 Authentication authentication = authManager.authenticate(dadoslogin);
			 String token = tokenServices.gerarToken(authentication);
				return ResponseEntity.ok("Token for Auth -| "+ token);
		} catch (AuthenticationException e) {
			// TODO: handle exception
			return ResponseEntity.badRequest().build();
		}
	}
}
