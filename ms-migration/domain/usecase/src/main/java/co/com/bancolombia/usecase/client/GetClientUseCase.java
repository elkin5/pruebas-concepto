package co.com.bancolombia.usecase.client;

import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.client.gateways.ClientRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetClientUseCase {
    private final ClientRepository clientRepository;

    public List<Client> getClientList(){
        return this.clientRepository.getClients();
    }

    public Client getClientByMdmKey(String mdmKey) {
        return this.clientRepository.getClientByMDMId(mdmKey);
    }
}
