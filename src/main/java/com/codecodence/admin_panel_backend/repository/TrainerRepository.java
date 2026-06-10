package com.codecodence.admin_panel_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codecodence.admin_panel_backend.entity.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

}
