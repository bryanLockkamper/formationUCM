package models.resources;

public enum ResourceName {

        WOOD("wood"),
        STONE("stone"),
        FOOD("food"); //TODO : quantity set to a number and not infinity

        private String type;

        ResourceName(String type) {
                this.type = type;
        }

        public String getType() {
                return type;
        }
}
