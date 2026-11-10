package services;

import models.clients.Client;

public class CustomerManagement {

    GenericRepository<Integer, Client> clientRepository = new GenericRepository<>();

    public void addClient(Integer ID, Client client){
        if (ID != client.getID()){
            System.out.println("Addition did not take place because ID it does not exist or wrong");
            return;
        }
        clientRepository.addItem(ID, client);
        System.out.println("The client has been added successfully");
    }

    public void removeClient(Integer ID, Client client){
        if (ID != client.getID()){
            System.out.println("Deletion did not take place because ID it does not exist or wrong");
            return;
        }
        clientRepository.removeItem(ID);
        System.out.println("The client has been removed successfully");
    }

    public Client searchForAClientByID(Integer ID){
        Client client = clientRepository.searchItem(ID);
        if (client == null){
            System.out.println("client not found");
            return null;
        }
        System.out.println("The client was found successfully");
        return client;
    }

    public void ShowAllClient(){
        System.out.println("----- Show All Client -----");
        clientRepository.showAllItems();
    }

    public void editClient(){
        System.out.println("----- Edit Client -----");


    }



}