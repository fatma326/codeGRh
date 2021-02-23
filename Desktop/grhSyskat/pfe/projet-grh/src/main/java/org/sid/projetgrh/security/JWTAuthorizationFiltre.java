package org.sid.projetgrh.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFiltre extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		//response.setHeader("Access-Control-Allow-Origin", "*");

	    response.setHeader("Access-Control-Allow-Credentials", "true");
	    response.addHeader("Access-Control-Allow-headers", "Origin, Accept, X-Requested-With, Headers,Authorization, authorization");
		response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin,Access-Control-Allow-Credentials,Authorization, authorization");
	    response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, authorization,Authorization");


		response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT,PATCH,DELETE");

		if (request.getMethod().equals("OPTIONS")){
			
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			String jwtToken=request.getHeader(SecurityConstants.HEADER_STRING);

			Enumeration headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String key = (String) headerNames.nextElement();
				String value = request.getHeader(key);
				System.out.println(key + "=>>>>" + value);
			}

			System.out.println("******** secret tokeeen ********* ");
			System.out.println(jwtToken);
			
			if (jwtToken==null || !jwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
				
				filterChain.doFilter(request, response); 
				
			
				return ;
			}
			
			Claims claims=(Claims) Jwts.parser()
					.setSigningKey(SecurityConstants.SECRET)
					.parseClaimsJws(jwtToken.replace(SecurityConstants.TOKEN_PREFIX, ""))
					.getBody();
			String username=claims.getSubject();
			
			ArrayList<Map<String,String>> roles = (ArrayList<Map<String , String>>) claims.get("roles");
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(r->{
				authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			});
					
			UsernamePasswordAuthenticationToken authenticationToken= 
					new UsernamePasswordAuthenticationToken(username, null,authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			filterChain.doFilter(request, response);
		}
		
	}
	
	

}
