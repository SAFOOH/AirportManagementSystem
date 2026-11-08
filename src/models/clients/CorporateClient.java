package models.clients;

public class CorporateClient extends Client{

    int commercialRegistrationNumber;
    double discountRateGrantedToTheOrganization; //  ﻧﺳﺑﺔ اﻟﺧﺻم اﻟﻣﻣﻧوﺣﺔ ﻟﻠﻣؤﺳﺳﺔ

    public CorporateClient(int ID, String name, String address, String email, String phoneNumber) {
        super(ID, name, address, email, phoneNumber);
        setCommercialRegistrationNumber(commercialRegistrationNumber);
        setDiscountRateGrantedToTheOrganization(discountRateGrantedToTheOrganization);
    }

    public int getCommercialRegistrationNumber(){return this.commercialRegistrationNumber;}
    public void setCommercialRegistrationNumber(int commercialRegistrationNumber){
        if (commercialRegistrationNumber < 300 || commercialRegistrationNumber > 999999)
            throw new IllegalArgumentException("The commercial registration number should be between 300 and 999999");
        this.commercialRegistrationNumber = commercialRegistrationNumber;
    }

    public double getDiscountRateGrantedToTheOrganization(){return this.discountRateGrantedToTheOrganization;}
    public void setDiscountRateGrantedToTheOrganization(double discountRateGrantedToTheOrganization){
        if (discountRateGrantedToTheOrganization < 0 || commercialRegistrationNumber > 25)
            throw new IllegalArgumentException("The discount rate granted to the organization should be between 0 and 25 %");
        this.discountRateGrantedToTheOrganization = discountRateGrantedToTheOrganization;
    }

    @Override
    public String toString() {
        return super.toString() +
                "commercial Registration Number: " + getCommercialRegistrationNumber() +
                "Discount Rate Granted To The Organization: " + getDiscountRateGrantedToTheOrganization();
    }
}