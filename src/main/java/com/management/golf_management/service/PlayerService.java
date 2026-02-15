package com.management.golf_management.service;

import com.management.golf_management.exception.DuplicateRegistrationException;
import com.management.golf_management.model.dto.Player;
import com.management.golf_management.model.request.PlayerRegisterRequest;
import com.management.golf_management.model.response.PlayerRegisterResponse;
import com.management.golf_management.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerRegisterResponse registerPlayer(PlayerRegisterRequest request) {
        validateUniqueConstraints(request);

        Player player = playerMapper.toEntity(request);
        Player savedPlayer = playerRepository.save(player);

        return playerMapper.toRegisterResponse(savedPlayer);
    }

    private void validateUniqueConstraints(PlayerRegisterRequest request) {
        if (playerRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateRegistrationException("Email already registered");
        }
        if (playerRepository.existsByPhone(request.getPhone())) {
            throw new DuplicateRegistrationException("Phone already registered");
        }
    }
}