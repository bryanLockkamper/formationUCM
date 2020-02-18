package com.ucm.ucmempire.models.resources;

import com.ucm.ucmempire.models.Constants;
import lombok.EqualsAndHashCode;

public enum ResourceName{

        WOOD("wood", Constants.NB_RESSOURCE_INIT),
        STONE("stone",Constants.NB_RESSOURCE_INIT),
        FOOD("food",Constants.NB_RESSOURCE_INIT);

        private String type;
        private Integer quantity;

        ResourceName(String type) {
                this.type = type;
        }

        ResourceName(String type,Integer quantity) {
                this.type = type;
                this.quantity = quantity;
        }

        public String getType() {
                return type;
        }
        public Integer getQuantity() {return quantity;}
}
