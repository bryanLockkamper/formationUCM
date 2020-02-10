package com.ucm.ucmempire.models.resources;

public enum ResourceName{

        WOOD(1),
        STONE(2),
        FOOD(3); //TODO : quantity set to a number and not infinity

        private Integer type;

        ResourceName(Integer type) {
                this.type = type;
        }

        public Integer getType() {
                return type;
        }
}
