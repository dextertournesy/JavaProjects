package OutfitGenerator;

public class ClothingItem {
    private String occasion;
    private String color;
    private String name;


    public ClothingItem(String occasion, String color, String name) {
        this.occasion = occasion;
        this.color = color;
        this.name = name;
    }

     public ClothingItem() {
        this.occasion = null;
        this.color = null;
        this.name = null;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
