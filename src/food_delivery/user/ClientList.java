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

    public boolean checkEmail(String x){
        for(int i=0 ; i < clientList.size() ; i++){
            if(clientList.get(i).getEmail().equals(x)){
                return true;
            }
        }
        return false;
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
