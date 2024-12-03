package com.boot.novel.Security;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.novel.models.Role;
import com.boot.novel.models.User;

import com.boot.novel.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isPresent()) {
                return org.springframework.security.core.userdetails.User
                    .builder()
                    .username(username)
                    .password(user.get().getPassword())
                    .roles(getRoles(user.get()).toArray(new String[0]))
                    .build();
            } else {
                throw new UsernameNotFoundException("User not found");
            }
        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException("Username not found");
        }
    }

    private List<String> getRoles(User user) {
        if (user.getRoles().isEmpty()) {
            List.of(new Role("USER"));
        }
        return user.getRoles().stream().map(Role::getName).collect(Collectors.toList());
    }

}
