package co.com.bancolombia.model.client.gateways;

import co.com.bancolombia.model.client.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> getClients();
    Client getClientByMDMId(String mdmKey);
}
