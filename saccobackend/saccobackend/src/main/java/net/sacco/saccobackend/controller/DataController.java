
package net.sacco.saccobackend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import net.sacco.saccobackend.model.Requests;
import net.sacco.saccobackend.model.PaymentType;
import net.sacco.saccobackend.repository.RequestRepository;

import java.sql.Timestamp;
import java.time.Instant;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/new/request")

public class DataController {

    @Autowired
    private RequestRepository requestRepository;

    // DTO to receive data from frontend
    public static class NewLoanRequest {
        public String member;
        public double amount;
        public PaymentType paymentType;
        public int requiredApprovals;
    }

    @PostMapping
    public ResponseEntity<String> createLoanRequest(@RequestBody NewLoanRequest request) {
        Requests newRequest = new Requests();

        newRequest.setMember(request.member); 
        newRequest.setAmount((float) request.amount);
        newRequest.setPaymentType(request.paymentType);
        newRequest.setRequiredApprovals(request.requiredApprovals);
        newRequest.setApproval(0); // initial approval count
        newRequest.setStatus("pending approval");
        newRequest.setCreatedate(Timestamp.from(Instant.now())); // current timestamp

        requestRepository.save(newRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("Loan request submitted successfully.");
    }
}