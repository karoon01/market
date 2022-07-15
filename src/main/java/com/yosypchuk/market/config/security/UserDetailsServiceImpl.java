package com.yosypchuk.market.config.security;

import com.yosypchuk.market.config.security.UserDetailsImpl;
import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.model.entity.User;
import com.yosypchuk.market.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new EntityNotFoundException("User is not found"));
        return new UserDetailsImpl(user);
    }
}
