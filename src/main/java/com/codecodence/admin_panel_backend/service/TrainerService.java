package com.codecodence.admin_panel_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecodence.admin_panel_backend.dto.TrainerDTO;
import com.codecodence.admin_panel_backend.entity.Trainer;
import com.codecodence.admin_panel_backend.repository.TrainerRepository;

@Service
public class TrainerService {
    
    @Autowired
    public TrainerRepository trainerRepository;
    
    public TrainerDTO saveTrainerDTO(TrainerDTO dto) {
        Trainer trainer = new Trainer();
        trainer.setTrainerName(dto.getTrainerName());
        trainer.setTrainerEmail(dto.getTrainerEmail());
        trainer.setTrainerPhoneNumber(dto.getTrainerPhoneNumber());
        trainer.setTrainerAddress(dto.getTrainerAddress());

        return new TrainerDTO(trainerRepository.save(trainer));
    }
    
    public List<TrainerDTO> saveMultipleTrainer(List<TrainerDTO> dtos) {
        List<Trainer> trainers = dtos.stream().map(dto -> {
            Trainer trainer = new Trainer();
            trainer.setTrainerName(dto.getTrainerName());
            trainer.setTrainerEmail(dto.getTrainerEmail());
            trainer.setTrainerPhoneNumber(dto.getTrainerPhoneNumber());
            trainer.setTrainerAddress(dto.getTrainerAddress());
            return trainer;
        }).toList();

        return trainerRepository.saveAll(trainers)
                .stream()
                .map(TrainerDTO::new)
                .toList();
    }
    
    // GET ALL
    public List<TrainerDTO> getAllTrainers() {
        return trainerRepository.findAll()
                .stream()
                .map(TrainerDTO::new)
                .toList();
    }
    
    // GET BY ID
    public TrainerDTO getTrainerById(Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trainer not found"));
        return new TrainerDTO(trainer);
    }

    // UPDATE
    public TrainerDTO updateTrainer(Long id,  TrainerDTO dto) {
        Trainer trainer = trainerRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));

        trainer.setTrainerName(dto.getTrainerName());
        trainer.setTrainerEmail(dto.getTrainerEmail());
        trainer.setTrainerPhoneNumber(dto.getTrainerPhoneNumber());
        trainer.setTrainerAddress(dto.getTrainerAddress());

        return new TrainerDTO(trainerRepository.save(trainer));
    }

    // DELETE
    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }
}