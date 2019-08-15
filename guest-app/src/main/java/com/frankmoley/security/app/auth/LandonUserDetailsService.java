package com.frankmoley.security.app.auth;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LandonUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if(null == user){
          throw new UsernameNotFoundException("cannot find username :"+ username);
        }
        List<AuthGroup> authGroups = this.authGroupRepository.findByUsername(username);
        return new LandonUserPrinciple(user,authGroups);
    }
}