package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.CharacterEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CharacterDalService {

    Optional<List<CharacterEntity>> findCharacterEntitiesById(Integer id_player);

}
