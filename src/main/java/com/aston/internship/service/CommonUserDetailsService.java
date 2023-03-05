package com.aston.internship.service;

import com.aston.internship.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommonUserDetailsService implements UserDetailsService {
    private final DetailsRepository detailsRepository;

    @Autowired
    public CommonUserDetailsService(DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        return detailsRepository
                .findByUsername(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + login));
    }
}
