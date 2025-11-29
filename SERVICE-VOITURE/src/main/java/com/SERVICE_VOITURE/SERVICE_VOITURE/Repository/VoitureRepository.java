package com.SERVICE_VOITURE.SERVICE_VOITURE.Repository;

import com.SERVICE_VOITURE.SERVICE_VOITURE.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture,Long> {
}
