package net.sacco.saccobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sacco.saccobackend.model.Approvals;
import net.sacco.saccobackend.model.Requests;

public interface ApprovalRepository extends JpaRepository<Approvals, Long> {
    // Manage all the crud routes
}