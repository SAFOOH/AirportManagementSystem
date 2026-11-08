package models.clients;

import java.time.LocalDate;

public class IndividualPassenger extends Client{

    int passportNumber;
    LocalDate dateOfBirth;
    LocalDate passportExpiryDate;

    public IndividualPassenger(int ID, String name, String address, String email, String phoneNumber,
                        int passportNumber, LocalDate dateOfBirth, LocalDate passportExpiryDate){
        super(ID, name, address, email, phoneNumber);
        setPassportNumber(passportNumber);
        setDateOfBirth(dateOfBirth);
        setPassportExpiryDate(passportExpiryDate);
    }

    public int getPassportNumber(){return this.passportNumber;}
    public void setPassportNumber(int passportNumber){
        if (passportNumber < 10000000 || passportNumber > 99999999)
            throw new IllegalArgumentException("The passport number must consist of eight digits");
        this.passportNumber = passportNumber;
    }

    public LocalDate getDateOfBirth(){return this.dateOfBirth;}
    public void setDateOfBirth(LocalDate dateOfBirth){
        if (dateOfBirth == null)
            throw new IllegalArgumentException("Error: The date of birth cannot be null");
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getPassportExpiryDate(){return this.passportExpiryDate;}
    public void setPassportExpiryDate(LocalDate passportExpiryDate){
        if (passportExpiryDate == null)
            throw new IllegalArgumentException("Error: The passport expiry date cannot be null");
        this.passportExpiryDate = passportExpiryDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Passport Number: " + getPassportNumber() +
                "Date Of Birth: " + getDateOfBirth() +
                "Passport Expiry Date: " + getPassportExpiryDate();
    }
}