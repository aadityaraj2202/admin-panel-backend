package com.codecodence.admin_panel_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.codecodence.admin_panel_backend.entity")
@EnableJpaRepositories("com.codecodence.admin_panel_backend.repository")
public class AdminPanelBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminPanelBackendApplication.class, args);
	}

}