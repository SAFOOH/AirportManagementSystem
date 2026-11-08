package models.clients;

public abstract class Client {

    private int ID;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;

    Client(int ID, String name, String address, String email, String phoneNumber){
        setID(ID);
        setName(name);
        setAddress(address);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public int getID(){return this.ID;}
    public void setID(int ID){
        if (ID < 0 || ID > 9999999)
            throw new IllegalArgumentException("The number of ID should be between 1 and 9999999");
        this.ID = ID;
    }

    public String getName(){return this.name;}
    public void setName(String name){
        if(name == null || name.isBlank())
            throw new IllegalArgumentException("Error: The name of client cannot be null or empty");
        this.name = name;
    }

    public String getAddress(){return this.address;}
    public void setAddress(String address){
        if(address == null || address.isBlank())
            throw new IllegalArgumentException("Error: The address of client cannot be null or empty");
        this.address = address;
    }

    public String getEmail(){return this.email;}
    public void setEmail(String email){
        if(email == null || email.isBlank())
            throw new IllegalArgumentException("Error: The email cannot be null or empty");
        this.email = email;
    }

    public String getPhoneNumber(){return this.phoneNumber;}
    public void setPhoneNumber(String phoneNumber){
        if(phoneNumber == null || phoneNumber.isBlank())
            throw new IllegalArgumentException("Error: The phone number cannot be null or empty");
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ID: " + getID() +
               "Name: " + getName() +
               "Address: " + getAddress() +
               "Email: " + getEmail() +
               "Phone Number: " + getPhoneNumber();
    }
}