package net.sacco.saccobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.sacco.saccobackend.model.Requests;

public interface RequestRepository extends JpaRepository<Requests, Long> {
    // Manage all the crud routes
}
