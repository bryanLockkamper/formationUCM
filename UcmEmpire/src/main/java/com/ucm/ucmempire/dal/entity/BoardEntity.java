package com.ucm.ucmempire.dal.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "board")
public class BoardEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_board")
    private Integer id;

    @Column(name = "name_board")
    private String name;

    @OneToMany (targetEntity = SquareEntity.class,mappedBy = "board",fetch = FetchType.LAZY)
    private List<SquareEntity> squareEntity;

    public BoardEntity() {
    }

    public BoardEntity(String name) {
        this();
        this.name = name;
    }


    //TODO : Relation square-Board


}
