package com.runlow.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.runlow.constants.RoleConstant;
import com.runlow.model.Role;
import com.runlow.model.User;
import com.runlow.repository.RoleRepository;
import com.runlow.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findByFirstName(String firstName) {		
		return userRepository.findByFirstName(firstName);
	}
	
	/**
	 * This method saves user records with role
	 * @param user user instance to be saved
	 * @param role role of user to be assigned to user
	 * */
	@Override
	public User saveUser(User user, String role) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		Role userRole = roleRepository.findById(user.roleId);
		// if roleId is null then if the request is from driver then create driver role by default and so on.
		if (userRole == null) {
			if (role == RoleConstant.ROLE_DRIVER) {
				userRole = createRole(role);
			} else if (role == RoleConstant.ROLE_PASSENGER) {
				userRole = createRole(role);
			}
		}
		user.setRole(userRole);
		return userRepository.saveAndFlush(user);
		
	}
	
	/**
	 * Private method to create Role record and returns it.
	 * @param roleValue name of role
	 * */
	private Role createRole(String roleName) {
		// save role
		Role role = new Role();
		role.setRoleName(roleName);
		roleRepository.save(role);
		return role;
	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByFirstName(username);
		List<GrantedAuthority> authorities = getUserAuthority((Set.of(user.getRole()))); // or new HashSet<Role>(Arrays.asList(user.getRole()))
		return buildUserForAuthentication(user, authorities);
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRoleName()));
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, authorities);
	}
}
