package com.ucm.ucmempire.dal.servicedal;

import com.ucm.ucmempire.dal.entity.SquareEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SquareDalService {
    List<SquareEntity> saveList (List<SquareEntity> squareEntities);
    SquareEntity save (SquareEntity squareEntity);
}
