package com.management.golf_management.repository;

import com.management.golf_management.model.dto.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}
