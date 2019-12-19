package models.ressources;

public enum RessourceName {

        BOIS("bois"),
        PIERRE("pierre"),
        NOURRITURE("nourriture"); //TODO : quantity set to a number and not infinity

        private String type;

        RessourceName(String type) {
                this.type = type;
        }

        public String getType() {
                return type;
        }
}
