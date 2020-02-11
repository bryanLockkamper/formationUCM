package com.ucm.ucmempire.dal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Board")
public class BoardEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_board")
    private Integer id;

    @Column(name = "name_board")
    private String name;

    @OneToMany(targetEntity = SquareEntity.class)
    private List<SquareEntity> squareEntityList;

    public BoardEntity() {
    }
}
