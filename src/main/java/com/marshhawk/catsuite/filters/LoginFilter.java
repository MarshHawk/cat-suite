package com.marshhawk.catsuite.filters;

import java.io.IOException;
import static java.util.Collections.emptyList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marshhawk.catsuite.model.AccountCredentials;
import com.marshhawk.catsuite.service.AuthenticationService;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	  public LoginFilter(String url, AuthenticationManager authManager) {
	    super(new AntPathRequestMatcher(url));
	    setAuthenticationManager(authManager);
	  }

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		  AccountCredentials credentials = new ObjectMapper()
			        .readValue(request.getInputStream(), AccountCredentials.class);
			  return getAuthenticationManager().authenticate(
			        new UsernamePasswordAuthenticationToken(
			            credentials.getUsername(),
			            credentials.getPassword(),
			            emptyList()
			        )
			    );
	}
	
	  @Override
	  protected void successfulAuthentication(
	      HttpServletRequest req,
	      HttpServletResponse res, FilterChain chain,
	      Authentication auth) throws IOException, ServletException {
	    AuthenticationService.addToken(res, auth.getName());
	  }
}
