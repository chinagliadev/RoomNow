package com.chinaglia.salaaluguelapi.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.chinaglia.salaaluguelapi.entity.Usuario;

@Service
public class TokenService {

	@Value("${api.security.token.security}")
	private String secret;
	
	public String generatedToken(Usuario usuario) 
	{
		try 
		{
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withIssuer("sala-aluguel-api")
					.withSubject(usuario.getEmail())
					.withExpiresAt(generatedExpirationDate())
					.sign(algorithm);
			
			return token;
		} 
		catch (JWTCreationException e) 
		{
			throw new RuntimeException("Erro enquanto estava gerando o TOKEN", e);
		}
	}
	
	public String validToken(String token) 
	{
		try 
		{
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer("sala-aluguel-api").build().verify(token).getSubject();
		} 
		catch (JWTVerificationException e) 
		{
			e.getStackTrace();
			return "";
		}
	}
	
	
	private Instant generatedExpirationDate() 
	{
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
