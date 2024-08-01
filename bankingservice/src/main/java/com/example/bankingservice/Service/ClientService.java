package com.example.bankingservice.Service;

import com.example.bankingservice.Model.Client;
import com.example.bankingservice.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(int id){
        return clientRepository.findById(id);
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public Client updateClient(int id, Client client){
        Optional<Client> clientFound = clientRepository.findById(id);

        if(clientFound.isPresent()){
            Client updatedClient = clientFound.get();
            updatedClient.setName(client.getName());
            updatedClient.setEmail(client.getEmail());
            updatedClient.setPhone(client.getPhone());
            updatedClient.setAddress(client.getAddress());
            updatedClient.setAddress(client.getAddress());
            updatedClient.setGender(client.getGender());
            updatedClient.setNationality(client.getNationality());
            updatedClient.setOccupation(client.getOccupation());
            updatedClient.setAnnualIncome(client.getAnnualIncome());
            updatedClient.setMaritalStatus(client.getMaritalStatus());
            updatedClient.setCustomerSince(client.getCustomerSince());
            return clientRepository.save(updatedClient);
        }

        return null;
    }

    public void deleteClientById(int id){
        clientRepository.deleteById(id);
    }
}
