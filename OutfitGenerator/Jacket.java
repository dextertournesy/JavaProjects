package OutfitGenerator;

public class Jacket extends ClothingItem {
    private String jacketType;

    public Jacket(String occasion, String color, String name, String jacketType) {
        super(occasion, color, name);
        this.jacketType = jacketType;
    }

    public Jacket() {
        super();
        this.jacketType = null;
    }

    public String getJacketType() {
        return jacketType;
    }

    public void setJacketType(String jacketType) {
        this.jacketType = jacketType;
    }

    
    
}
