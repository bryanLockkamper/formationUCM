package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.SquareEntity;
import com.ucm.ucmempire.dal.repository.SquareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SquareDalServiceImpl implements SquareDalService {

    private SquareRepository squareRepository;

    @Autowired
    public SquareDalServiceImpl(SquareRepository squareRepository) {
        this.squareRepository = squareRepository;
    }

    @Override
    public List<SquareEntity> saveList(List<SquareEntity> squareEntities) {
        List<SquareEntity> list = squareEntities.stream()
                .map(data -> save(data))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public SquareEntity save(SquareEntity squareEntity) {

        System.out.println(squareEntity.getBiome());
        System.out.println(squareEntity.isBuildable());
        System.out.println(squareEntity.isWalkable());
        System.out.println(squareEntity.getPositionSquare());


        return this.squareRepository.save(squareEntity);
    }
}
