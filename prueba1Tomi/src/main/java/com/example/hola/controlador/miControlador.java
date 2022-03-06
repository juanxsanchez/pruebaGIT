package com.example.hola.controlador;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hola.dto.CarDto;
import com.example.hola.service.CarService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController // marca la clase como bean> puede ser singleton(solo uno) o prototype(mas de
				// uno)
@RequestMapping("/car")
public class miControlador {
	@Autowired
	CarService carService;

	@PostMapping // cada vez q le peguen conun post va a entrar a este metodo
	@PreAuthorize("hasAnyRole('ROLE_USER')")
	public void createCar(@RequestBody @Valid CarDto car) {
		System.out.println("estoy aqui queriendota, ahogandome");
		carService.createNewCar(car);
	}

	@GetMapping
	public String returnToken() {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT")
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 120000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;

	}
}
