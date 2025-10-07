package net.sacco.saccobackend.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.sacco.saccobackend.repository.RequestRepository;
import net.sacco.saccobackend.model.PaymentType;
import net.sacco.saccobackend.model.Requests; 

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private RequestRepository requestRepository;

    // DTO to receive paymentType from frontend
    public static class ApprovalRequest {
        public PaymentType paymentType;
    }

    @PostMapping("/{loanId}")
    public ResponseEntity<String> approveLoan(
            @PathVariable Long loanId,
            @RequestBody ApprovalRequest request
    ) {
        Optional<Requests> optionalRequest = requestRepository.findById(loanId);

        if (optionalRequest.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Loan with ID " + loanId + " not found.");
        }

        Requests loanRequest = optionalRequest.get();

        // Update fields
        loanRequest.setApproval(loanRequest.getApproval() + 1);
        loanRequest.setPaymentType(request.paymentType);

        // Save to database
        requestRepository.save(loanRequest);

        return ResponseEntity.ok("Loan approved. Current approvals: " + loanRequest.getApproval());
    }
}

