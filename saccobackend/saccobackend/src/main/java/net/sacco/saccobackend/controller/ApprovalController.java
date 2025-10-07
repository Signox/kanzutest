package net.sacco.saccobackend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.sacco.saccobackend.model.Approvals;
import net.sacco.saccobackend.repository.ApprovalRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/maxapproval")
public class ApprovalController {

    @Autowired
    private ApprovalRepository approvalRepository;

    // DTO to receive requiredApprovals from frontend
    public static class ApprovalRequest {
        public Integer requiredApprovals;
    }

    @PatchMapping
    public ResponseEntity<String> updateRequiredApprovals(@RequestBody ApprovalRequest request) {
        Optional<Approvals> optionalApproval = approvalRepository.findById(1L); // constant ID

        if (optionalApproval.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Approval record with ID 1 not found.");
        }

        Approvals approvo = optionalApproval.get();
        approvo.setMaxcount(request.requiredApprovals); // assuming maxcount is the field you're updating
        approvalRepository.save(approvo);

        return ResponseEntity.ok("Required approvals updated to: " + request.requiredApprovals);
    }
}