package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.BuildingEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BuildingDalService {

    Optional<List<BuildingEntity>> findBuildingEntitiesById(Integer id_player);

}
