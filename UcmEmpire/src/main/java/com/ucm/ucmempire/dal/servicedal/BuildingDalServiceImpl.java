package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.BuildingEntity;
import com.ucm.ucmempire.dal.repository.BuildingRepository;

import java.util.List;
import java.util.Optional;

public class BuildingDalServiceImpl implements BuildingDalService {
    private BuildingRepository buildingRepository;

    public BuildingDalServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public Optional<List<BuildingEntity>> findBuildingEntitiesById(Integer id_player) {
        return this.buildingRepository.findBuildingEntitiesById(id_player);
    }
}
