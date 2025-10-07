package net.sacco.saccobackend.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import net.sacco.saccobackend.model.Approvals;
import net.sacco.saccobackend.repository.ApprovalRepository;

import java.util.Collections;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MaxApprovalController {

    @Autowired
    private ApprovalRepository approvalRepository;

    @GetMapping("/max-ct")
    public ResponseEntity<?> getMaxApprovalCount() {
        Optional<Approvals> optionalApproval = approvalRepository.findById(1L); // constant ID

        if (optionalApproval.isEmpty()) {
            return ResponseEntity.ok(Collections.singletonMap("maxcount", 0)); // default fallback
        }

        Approvals approval = optionalApproval.get();
        return ResponseEntity.ok(Collections.singletonMap("maxcount", approval.getMaxcount()));
    }
}
