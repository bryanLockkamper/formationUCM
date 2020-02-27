package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.CharacterEntity;
import com.ucm.ucmempire.dal.repository.CharacterRepository;

import java.util.List;
import java.util.Optional;

public class CharacterDalServiceImpl implements CharacterDalService {
    private CharacterRepository characterRepository;

    public CharacterDalServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Optional<List<CharacterEntity>> findCharacterEntitiesById(Integer id_player) {
        return this.characterRepository.findCharacterEntitiesById(id_player);
    }
}
