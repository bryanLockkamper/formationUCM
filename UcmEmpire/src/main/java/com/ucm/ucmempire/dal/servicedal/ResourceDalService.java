package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.ResourceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ResourceDalService {

    Optional<List<ResourceEntity>> findResourceEntitiesById(Integer player_id);
}
