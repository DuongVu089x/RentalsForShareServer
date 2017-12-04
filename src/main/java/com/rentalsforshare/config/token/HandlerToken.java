package com.rentalsforshare.config.token;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.rentalsforshare.common.util.Constants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// TODO: Auto-generated Javadoc
/**
 * The Class TokenHandler.
 */
@Component()
public class HandlerToken {

	/** The secret. */
	private final String secret = "DAV_SERVER";
	private static final List<String> tokens = new ArrayList<>();

	/**
	 * Parses the user from token.
	 *
	 * @param token the token
	 * @return the string
	 */
	public String parseUserFromToken(String token) {
		String result = Constants.STR_BLANK;
		/*if (tokens.contains(token)) {*/
			try {
				result = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
			} catch (Exception e) {
				tokens.remove(token);
			}
		/*}*/
		return result;
	}

	/**
	 * Creates the token for user.
	 *
	 * @param username the username
	 * @return the string
	 */
	public String createTokenForUser(String username) {
		Date now = new Date();
		Date expiration = new Date(now.getTime() + TimeUnit.DAYS.toMillis(30l));

		String result = Jwts.builder().setId(UUID.randomUUID().toString()).setSubject(username).setIssuedAt(now)
				.setExpiration(expiration).signWith(SignatureAlgorithm.HS512, secret).compact();
		tokens.add(result);
		return result;
	}
}
