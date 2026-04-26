package com.management.golf_management.mapper;

import com.management.golf_management.model.dto.Player;
import com.management.golf_management.model.request.PlayerRegisterRequest;
import com.management.golf_management.model.response.PlayerRegisterResponse;
import com.management.golf_management.utils.PlayerNormalizer;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PlayerMapper {

    private final PlayerNormalizer normalizer;

    public PlayerMapper(PlayerNormalizer normalizer) {
        this.normalizer = normalizer;
    }


    public Player toEntity(PlayerRegisterRequest request) {

        Objects.requireNonNull(request, "PlayerRegisterRequest cannot be null");

        Player p = new Player();
        p.setFirstName(normalizer.name(request.getFirstName()));
        p.setLastName(normalizer.name(request.getLastName()));
        p.setEmail(normalizer.email(request.getEmail()));
        p.setPhone(normalizer.phone(request.getPhone()));
        p.setState(normalizer.optional(request.getState()));
        p.setCountry(normalizer.optional(request.getCountry()));
        p.setAge(request.getAge());
        p.setGender(request.getGender() != null ? request.getGender() : p.getGender());
        p.setSkillLevel(request.getSkillLevel());
        p.setHandicap(request.getHandicap());
        return p;
    }

    public PlayerRegisterResponse toRegisterResponse(Player player) {

        Objects.requireNonNull(player, "Player cannot be null");

        PlayerRegisterResponse response = new PlayerRegisterResponse();
        response.setId(Long.valueOf(player.getId()));
        response.setFirstName(player.getFirstName());
        response.setLastName(player.getLastName());
        response.setEmail(player.getEmail());
        response.setSkillLevel(player.getSkillLevel());
        response.setMessage("Player registered successfully");
        return response;
    }
}

