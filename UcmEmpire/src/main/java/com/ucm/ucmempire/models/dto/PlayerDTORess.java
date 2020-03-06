package com.ucm.ucmempire.models.dto;

import com.ucm.ucmempire.dal.entity.ResourceEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PlayerDTORess {

    private Integer user_id;
    private List<ResourceEntity> resources;


}
