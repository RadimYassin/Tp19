package com.SERVICE_VOITURE.SERVICE_VOITURE.Service;

import com.SERVICE_VOITURE.SERVICE_VOITURE.entities.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-CLIENT")
public interface ClientService {
    @GetMapping(path = "/client/{id}")
    Client clientById(@PathVariable Long id);
}