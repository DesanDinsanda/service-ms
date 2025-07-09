package com.example.ServiceManagement.Service.interservice;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WorkerService {
    private WebClient webClient;

    public WorkerService(WebClient.Builder builder){
        this.webClient = builder.baseUrl("http://localhost:8087/worker-app").build();
    }

    public void deleteSkillsByDeletedServiceId(int id){
        webClient.delete()
                .uri("/skills/services/"+id)
                .retrieve()
                .toBodilessEntity()
                .subscribe();
    }
}
