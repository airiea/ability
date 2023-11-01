package com.airiea.ability.repository.impl;

import com.airiea.ability.common.factory.AbilityFactory;
import com.airiea.ability.model.dao.AbilityDAO;
import com.airiea.ability.model.dto.AbilityDTO;
import com.airiea.ability.repository.AbilityRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AbilityRepositoryImpl implements AbilityRepository {
    private final DynamoDBMapper dynamoDBMapper;
    private final AbilityFactory abilityFactory;


    public AbilityRepositoryImpl(final DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = Objects.requireNonNull(dynamoDBMapper, "Mapper cannot be null");
        this.abilityFactory = AbilityFactory.INSTANCE;
    }

    @Override
    public AbilityDTO getAbilityDTOByName(String abilityName) {
        final AbilityDAO abilityDAO = this.getAbilityDAOByName(abilityName);

        return abilityFactory.daoToDto(abilityDAO);
    }

    @Override
    public AbilityDTO createAbilityDTO(AbilityDTO abilityDTO) {
        final AbilityDAO abilityDAO = abilityFactory.dtoToDao(abilityDTO);
        this.createAbilityDAO(abilityDAO);

        return abilityDTO;
    }

    @Override
    public AbilityDTO updateAbilityDTO(AbilityDTO abilityDTO) {
        final AbilityDAO abilityDAO = abilityFactory.dtoToDao(abilityDTO);
        this.updateAbilityDAO(abilityDAO);

        return abilityDTO;
    }

    @Override
    public List<AbilityDTO> getAllAbilityDTOs() {
        List<AbilityDAO> abilityDAOList = this.getAllAbilityDAOs();

        return abilityDAOList.stream()
                .map(abilityFactory::daoToDto)
                .collect(Collectors.toList());
    }



    @Override
    public AbilityDAO getAbilityDAOByName(String abilityId) {
        return dynamoDBMapper.load(AbilityDAO.class, abilityId);
    }

    @Override
    public AbilityDAO createAbilityDAO(AbilityDAO abilityDAO) {
        if (!Objects.isNull(dynamoDBMapper.load(abilityDAO))) {
            throw new IllegalArgumentException("Failed to create abilityDAO " + abilityDAO + ", item already exists.");
        }

        dynamoDBMapper.save(abilityDAO);
        return abilityDAO;
    }

    @Override
    public AbilityDAO updateAbilityDAO(AbilityDAO abilityDAO) {
        if (Objects.isNull(dynamoDBMapper.load(abilityDAO))) {
            throw new IllegalArgumentException("Failed to update abilityDAO " + abilityDAO + ", item not found.");
        }

        dynamoDBMapper.save(abilityDAO);
        return abilityDAO;
    }

    @Override
    public List<AbilityDAO> getAllAbilityDAOs() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        return dynamoDBMapper.scan(AbilityDAO.class, scanExpression);
    }
}
