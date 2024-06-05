package com.alura.projetoAluraSpring.infra.security;

import com.alura.projetoAluraSpring.dominio.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API voll.med")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExperacao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token jwt", exception);
        }
    }


    public String getSubject(String tokenJWT) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API voll.med")
                    .build()
                    .verify("tokenJWT")
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT invalido ou expirado", exception);
        }
    }


    private Instant dataExperacao() {
        return LocalDateTime.now().plusHours(4).toInstant(ZoneOffset.of("03-00"));
    }

}
