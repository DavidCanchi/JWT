package com.practica.controller;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class JwtController {
	private static Logger LOG = LoggerFactory.getLogger(JwtController.class);
	@GetMapping("/generate-token")
	@ResponseBody
	public String GenerateToken() {
		try{
		//-------------------------------------------------------------------------------
		//------------------------------- HEADER ---------------------------------------
		//-------------------------------------------------------------------------------
		//The JWT signature algorithm we will be using to sign the token
			SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
			SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
			
			//Creating the Header of 
			HashMap<String, Object> header = new HashMap<String,Object>();
			header.put("alg", signatureAlgorithm.toString()); //HS256
			header.put("typ","JWT");
		//-------------------------------------------------------------------------------
		// CREATING TOKEN and ADDING HEADER
		//-------------------------------------------------------------------------------
		//Generate tokenJWT + adding header
			long tiempo = System.currentTimeMillis();
			JwtBuilder tokenJWT = Jwts
								  .builder()
								  .setHeader(header)
								  .setIssuer("https://fusap.com.ar/index.php?lang=ar")  
								  .setId("1")
								  .setSubject("www.fusap.com.ar")
								  .claim("name", "David Canchi")
								  .claim("scope", "admin")
								  // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
								  .setIssuedAt(new Date(tiempo))
								  // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
								  .setExpiration(new Date(tiempo+900)).signWith(key); //expires after 15 minutes
		//-------------------------------------------------------------------------------
		// CREATING TOKEN + ADDING HEADER
		//-------------------------------------------------------------------------------
		//Compact the tokenJWT + save the value in tokenJWTString
					String tokenJWTString = tokenJWT.compact(); //
					LOG.info(tokenJWTString);
					//Response to Request from Controller
			return tokenJWTString;
			}catch (Exception e) {
			LOG.warn(e.getMessage());
			return "Error creating the token JWT" + e;
		}
	}
}



