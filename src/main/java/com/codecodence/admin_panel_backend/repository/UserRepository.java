package com.codecodence.admin_panel_backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.codecodence.admin_panel_backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	 Optional<User> findByUserName(String username);
	 Optional<User> findByUserEmail(String email);
	  Boolean existsByUserEmail(String email);

}
