package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.BoardEntity;
import com.ucm.ucmempire.dal.entity.PlayerEntity;
import com.ucm.ucmempire.dal.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerDalServiceImpl implements PlayerDalService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerDalServiceImpl(PlayerRepository repository) {
        this.playerRepository = repository;
    }

    @Override
    public Optional<PlayerEntity> findByLoginAndPassword(String login, String password) {
        return playerRepository.findByLoginAndPassword(login,password);
    }

    @Override
    public List<PlayerEntity> saveBoard(List<Integer> idPlayersList, BoardEntity boardEntity) {

        List<PlayerEntity> playerEntities = playerRepository.findByIdIn(idPlayersList);
        playerEntities.stream().forEach(data -> System.out.println(data.getFirstName()));

        playerEntities.stream().forEach(data -> data.setBoardEntity(boardEntity));

        return (List<PlayerEntity>) playerRepository.saveAll(playerEntities);
    }
}
