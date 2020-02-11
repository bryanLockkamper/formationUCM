package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.ResourceEntity;
import com.ucm.ucmempire.dal.repository.ResourceRepository;

import java.util.List;
import java.util.Optional;

public class ResourceDalServiceImpl implements ResourceDalService {
    private ResourceRepository resourceRepository;

    public ResourceDalServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Optional<List<ResourceEntity>> findResourceEntitiesById(Integer player_id) {
        return this.resourceRepository.findResourceEntitiesById(player_id);
    }
}
