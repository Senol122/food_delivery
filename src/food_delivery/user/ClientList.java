package food_delivery.user;

import java.util.ArrayList;

public class ClientList {
    private ArrayList<Client> clientList = new ArrayList<>();

    public ClientList() {
    }

    public ClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }

    public void addClient(Client x){
        clientList.add(x);
    }

    public boolean authenticate(String email, String password){
        for(int i=0 ; i < clientList.size() ; i++){
            if(clientList.get(i).getEmail().equals(email) && clientList.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public Client findClient(String email){
        for(int i = 0 ; i < clientList.size(); i++){
            if(clientList.get(i).getEmail().equals(email)){
                return clientList.get(i);
            }
        }

        return null;
    }

    public Client findClientById(String clientId){
        for(int i = 0 ; i < clientList.size(); i++){
            if(clientList.get(i).getClient_id().equals(clientId)){
                return clientList.get(i);
            }
        }

        return null;
    }

    public void deleteClient(String id){
        for(int i = 0 ; i < clientList.size(); i++){
            if(clientList.get(i).getClient_id().equals(id)){
                clientList.remove(i);
            }
        }
    }

    public Client getClient(int n){
        return clientList.get(n);
    }

    @Override
    public String toString() {
        return "ClientList{" +
                "clientList=" + clientList +
                '}';
    }
}
