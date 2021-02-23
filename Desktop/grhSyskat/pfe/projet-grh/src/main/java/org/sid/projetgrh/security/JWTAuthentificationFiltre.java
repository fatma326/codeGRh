package org.sid.projetgrh.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.sid.projetgrh.Employe;
import org.sid.projetgrh.dao.EmployeRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTAuthentificationFiltre extends UsernamePasswordAuthenticationFilter {

    private EmployeRepository employeRepository;
    private AuthenticationManager authenticationManager;

    public JWTAuthentificationFiltre(AuthenticationManager authenticationManager, EmployeRepository userRepository) {
        super();
        this.authenticationManager = authenticationManager;
        this.employeRepository = userRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse reponse) {

        Employe user = null;
        try {
            user = new ObjectMapper().readValue(request.getInputStream(), Employe.class);


        } catch (Exception e) {

            throw new RuntimeException(e);

        }

        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                ));
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse reponse, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String username;
        List<GrantedAuthority> roles = new ArrayList<>();
        String jwtToken;
        if (authResult.getCredentials() != null) {
            roles.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "CLIENT";
                }
            });
            username = (String) authResult.getPrincipal();
            jwtToken = Jwts.builder()
                    .setSubject(username)
                    .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                    .claim("roles", roles)
                    .compact();
        } else {
            User springUser = (User) authResult.getPrincipal();
            jwtToken = Jwts.builder()
                    .setSubject(springUser.getUsername())
                    .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                    .claim("roles", authResult.getAuthorities())
                    .compact();
        }


        System.out.println("***********ajout header token ******* ");
        System.out.println(authResult.getName());
        System.out.println(jwtToken);

        reponse.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + jwtToken);


        System.out.println("************ ici fin seccessf**********");
    }


    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
