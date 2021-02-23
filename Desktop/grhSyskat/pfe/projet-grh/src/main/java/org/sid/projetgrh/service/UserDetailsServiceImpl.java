package org.sid.projetgrh.service;

import org.sid.projetgrh.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employe u = accountService.findUserByUsername(username);

        if (u == null) throw new UsernameNotFoundException("user not found ici user details service " + username);

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        u.getRoles().forEach(r -> {
            System.out.println(r.getRole());
            authorities.add(new SimpleGrantedAuthority(r.getRole()));

        });


        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(u.getPassword())//
                .authorities(authorities)//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();
		/*
		MyUserPrincipal muser = new MyUserPrincipal();
		muser.setUser(u);
		muser.setAuthorities(authorities);
		
		System.out.println(muser.getAuthorities().toString());
		return muser;
		//return  (UserDetails) new Users(u.getUsername(),u.getPassword(),authorities); 
	*/
    }


}
