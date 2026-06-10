package com.codecodence.admin_panel_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codecodence.admin_panel_backend.dto.TrainerDTO;
import com.codecodence.admin_panel_backend.service.TrainerService;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {
    
    @Autowired
    private TrainerService trainerService;
    
    // CREATE
    @PostMapping
    public TrainerDTO createTrainer(@RequestBody TrainerDTO dto) {
        return trainerService.saveTrainerDTO(dto);
    }
    
    // BULK CREATE
    @PostMapping("/bulk")
    public List<TrainerDTO> createMultipleTrainers(@RequestBody List<TrainerDTO> dtos) {
        return trainerService.saveMultipleTrainer(dtos);
    }
    
    // GET ALL
    @GetMapping
    public List<TrainerDTO> getAllTrainers() {
        return trainerService.getAllTrainers();
    }
    
    // GET BY ID
    @GetMapping("/{id}")
    public TrainerDTO getTrainerById(@PathVariable Long id) {
        return trainerService.getTrainerById(id);
    }
    
    // UPDATE
    @PutMapping("/{id}")
    public TrainerDTO updateTrainer(
            @PathVariable Long id,
            @RequestBody TrainerDTO dto) {
        return trainerService.updateTrainer(id, dto);
    }
    
    // DELETE
    @DeleteMapping("/{id}")
    public String deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        return "Trainer deleted successfully";
    }
}