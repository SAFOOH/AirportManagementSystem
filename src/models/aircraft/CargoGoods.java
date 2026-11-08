package models.aircraft;

public class CargoGoods {
    private int ID;
    private String name;

    public CargoGoods(int ID, String name){
        setID(ID);
        setName(name);
    }

    int getID(){return this.ID;}
    void setID(int ID){
        if (ID <= 0 || ID > 99999)
            throw new IllegalArgumentException("It must ID Number between 1 and 99999");
        this.ID = ID;
    }

    public String getName(){return this.name;}
    public void setName(String name){
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Error: The name cannot be null or empty");
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + getID() +
               " -> Name: " + getName();
    }
}