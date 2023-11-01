package com.airiea.ability.repository;

import com.airiea.ability.model.dao.AbilityDAO;
import com.airiea.ability.model.dto.AbilityDTO;

import java.util.List;

/**
 * Data Access Object (DAO) interface for tasks.
 * This provides methods to perform operations on tasks.
 */
public interface AbilityRepository {
    AbilityDTO getAbilityDTOByName(String abilityName);
    AbilityDTO createAbilityDTO(AbilityDTO abilityDTO);
    AbilityDTO updateAbilityDTO(AbilityDTO abilityDTO);
    List<AbilityDTO> getAllAbilityDTOs();

    AbilityDAO getAbilityDAOByName(String abilityName);
    AbilityDAO createAbilityDAO(AbilityDAO abilityDAO);
    AbilityDAO updateAbilityDAO(AbilityDAO abilityDAO);
    List<AbilityDAO> getAllAbilityDAOs();
}
