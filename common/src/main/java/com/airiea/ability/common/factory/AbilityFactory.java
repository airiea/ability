package com.airiea.ability.common.factory;

import com.airiea.ability.model.dao.AbilityDAO;
import com.airiea.ability.model.dto.AbilityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AbilityFactory {
    AbilityFactory INSTANCE = Mappers.getMapper(AbilityFactory.class);
    AbilityDTO daoToDto(AbilityDAO abilityDAO);
    AbilityDAO dtoToDao(AbilityDTO abilityDTO);
}
