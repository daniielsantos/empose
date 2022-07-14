package com.empose.services;

import com.empose.models.Client;
import com.empose.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
//    @Autowired
//    private OrderRepository orderRepository;

    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        Optional<Client> optClient = clientRepository.findClientByCpf(client.getCpf(), 0);

        if (!optClient.isPresent()) {
            return clientRepository.save(client);
        }
        return new Client();
    }

    public Client update(Client client) {
        Optional<Client> optClient = clientRepository.findById(client.getId());
        Client clientUpdate = new Client();

        if (optClient.isPresent() &&
            !clientRepository.findClientByCpf(client.getCpf(), client.getId()).isPresent()) {
            clientUpdate = clientRepository.save(client);
        }

        return clientUpdate;
    }

    public String remove(Client client) {
        Optional<Client> optClient = clientRepository.findById(client.getId());

        if (optClient.isPresent()) {
            //ResponseOrdersByCpf responseOrdersByCpf = orderItemService.findOrderItemsByCpf(client.getCpf());
            //descomentar
//            List<Order> listOrder = orderRepository.findByclient_id(client.getId());
//            if (listOrder.size() == 0) {
                clientRepository.delete(client);
                return "";
            } else {
                return "Cliente não pode ser removido pois há pedidos vinculados ao mesmo.";
            }
//        }
//        return "Erro ao encontrar o cliente: " + client.getName();
    }

    public List<Client> findClientByText(String text){
        return clientRepository.findClientByText(text);
    }
}
