package OutfitGenerator;

public class Shirt extends ClothingItem{
    private String shirtType;

    public Shirt(String occasion, String color, String name, String shirtType) {
        super(occasion, color, name);
        this.shirtType = shirtType;
    }

    public Shirt() {
        super();
        this.shirtType = null;
    }

    public String getShirtType() {
        return shirtType;
    }

    public void setShirtType(String shirtType) {
        this.shirtType = shirtType;
    }
    
    
}
