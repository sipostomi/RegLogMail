package com.gyakorlas.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gyakorlas.entity.Role;
import com.gyakorlas.entity.User;
import com.gyakorlas.repository.RoleRepository;
import com.gyakorlas.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService  {
	
	private UserRepository userRepository;
	
	private final String USER_ROLE = "USER";
	
	private RoleRepository roleRepository;
	
	private final String KEY = generateKey();
	
	private EmailService emailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(EmailService emailService, UserRepository userRepository, RoleRepository roleRepository) {
		this.emailService = emailService;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByEmail(username);
		
		if( user == null ){
			throw new UsernameNotFoundException(username);
		}
		
		return new UserDetailsImpl(user);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}


	public String registerUser(User user) {
		User userCheck = userRepository.findByEmail(user.getEmail());
		
		if(userCheck!=null) {
			return "alreadyExists";
		}
		
		Role userRole = roleRepository.findByRole(USER_ROLE);
		if (userRole != null) {
			user.getRoles().add(userRole);
		}else{
			user.addRoles(USER_ROLE);
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(false);
		user.setActivation(KEY);
		userRepository.save(user);
		emailService.sendMessage(user.getEmail(), KEY);
		
		return "ok";
	}
	
	public String generateKey(){
		Random random = new Random();
		char[] word = new char[16]; 
		for (int j = 0; j < word.length; j++) {
			word[j] = (char) ('a' + random.nextInt(26));
		}//
		return new String(word);
    }
	
	public String userActivation(String code) {
		User user = userRepository.findByActivation(code);
		if (user == null)
		    return "noresult";
		
		user.setEnabled(true);
		user.setActivation("");
		userRepository.save(user);
		return "ok";
	}

}