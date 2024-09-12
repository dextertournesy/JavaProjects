package OutfitGenerator;

public class Pants extends ClothingItem{
    private String pantType;

    public Pants(String occasion, String color, String name, String pantType) {
        super(occasion, color, name);
        this.pantType = pantType;
    }

    public Pants() {
        super();
        this.pantType = null;
    }

    public String getPantType() {
        return pantType;
    }

    public void setPantType(String pantType) {
        this.pantType = pantType;
    }
    
}
