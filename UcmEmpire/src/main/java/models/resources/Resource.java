package models.resources;

public class Resource {
    private ResourceName name;
    private int number;

    public Resource(ResourceName name, int number) {
        this.name = name;
        this.number = number;
    }

    public ResourceName getName() {
        return name;
    }

    public void setName(ResourceName name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
