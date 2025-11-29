package com.SERVICE_VOITURE.SERVICE_VOITURE.Controller;

import com.SERVICE_VOITURE.SERVICE_VOITURE.Repository.VoitureRepository;
import com.SERVICE_VOITURE.SERVICE_VOITURE.Service.ClientService;
import com.SERVICE_VOITURE.SERVICE_VOITURE.entities.Voiture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VoitureController {

    private final VoitureRepository voitureRepository;
    private final ClientService clientService;

    public VoitureController(VoitureRepository voitureRepository, ClientService clientService) {
        this.voitureRepository = voitureRepository;
        this.clientService = clientService;
    }

    @GetMapping("/voitures")
    public List<Voiture> findAll() {
        List<Voiture> voitures = voitureRepository.findAll();
        voitures.forEach(v -> {
            v.setClient(clientService.clientById(v.getId_client()));
        });
        return voitures;
    }

    @GetMapping("/voitures/{id}")
    public Voiture findById(@PathVariable Long id) throws Exception {
        Voiture voiture = voitureRepository.findById(id)
                .orElseThrow(() -> new Exception("Voiture introuvable"));
        voiture.setClient(clientService.clientById(voiture.getId_client()));
        return voiture;
    }
}
