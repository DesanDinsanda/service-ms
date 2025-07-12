package com.example.ServiceManagement.service.interservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WorkerService {
    private WebClient webClient;

    public WorkerService(WebClient.Builder builder, @Value("${service.worker.url}") String url){
        this.webClient = builder.baseUrl(url).build();
    }

    public void deleteSkillsByDeletedServiceId(int id){
        webClient.delete()
                .uri("/skills/services/"+id)
                .retrieve()
                .toBodilessEntity()
                .subscribe();
    }
}
