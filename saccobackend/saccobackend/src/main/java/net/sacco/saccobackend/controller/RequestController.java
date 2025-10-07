package net.sacco.saccobackend.controller;

import org.springframework.web.bind.annotation.*;
 

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
 
import net.sacco.saccobackend.model.Requests;
import net.sacco.saccobackend.repository.RequestRepository;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/api/requests")

public class RequestController {
 
    @Autowired
    private RequestRepository requestRepository;
     

    @GetMapping
    public List<Requests> getAllRequests() {
        return requestRepository.findAll();
    }
}

