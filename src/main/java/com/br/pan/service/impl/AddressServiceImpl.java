package com.br.pan.service.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.br.pan.model.Address;
import com.br.pan.repository.AddressRepository;
import com.br.pan.service.AddressService;
import com.br.pan.vo.EnderecoRequestResponse;
import com.br.pan.vo.EstadosRequestResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AddressServiceImpl extends ExternalService implements AddressService {

    private AddressRepository addressRepository;

    Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address addressDTO) {
        return addressRepository.save(addressDTO);
    }

    @Override
    public Address update(Address addressDTO) {
        return addressRepository.save(addressDTO);
    }

    @Override
    public void delete(Address addressDTO) {
        addressRepository.delete(addressDTO);
    }

    @Override
    public Address search(String CEP) throws URISyntaxException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ResponseEntity<String> states = super.getAddressCEP(CEP);
        String convert = states.getBody();
        Address address = null;
        EnderecoRequestResponse stateResponse = null;
        try {
            stateResponse = objectMapper.readValue(convert, EnderecoRequestResponse.class);
            logger.info(stateResponse.getBairro());
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        address = new Address(null, null, null, stateResponse.getLogradouro(), stateResponse.getBairro(), null,
                0);
        return address;
    }

    @Override
    public ResponseEntity<String> searchCity(String id) throws URISyntaxException, InterruptedException {
        return super.getAddressCity(id);
    }

    @Override
    public EstadosRequestResponse[] searchAllState() throws InterruptedException, URISyntaxException {
        ResponseEntity<String> states = super.getAddresState();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String convert = states.getBody();

        EstadosRequestResponse[] stateResponse = null;
        try {
            stateResponse = objectMapper.readValue(convert, EstadosRequestResponse[].class);
            logger.info(stateResponse[0].getNome());
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return orderState(stateResponse);

    }

    private EstadosRequestResponse[] orderState(EstadosRequestResponse[] stateResponse) {
        List<EstadosRequestResponse> collectState = new ArrayList<EstadosRequestResponse>();
        for (EstadosRequestResponse stateResponseTemp : stateResponse) {
            collectState.add(stateResponseTemp);
        }
        Collections.sort(collectState, new Comparator<EstadosRequestResponse>() {

            @Override
            public int compare(EstadosRequestResponse intaceState1, EstadosRequestResponse intaceState2) {
                String state1 = intaceState1.getNome();
                String state2 = intaceState2.getNome();
                return state1.compareToIgnoreCase(state2);
            }

        });
        return stateResponse(collectState);
    }

    private EstadosRequestResponse[] stateResponse(List<EstadosRequestResponse> collectState) {
        EstadosRequestResponse[] newStateResponse = new EstadosRequestResponse[collectState.size() - 1];
        int countStateArray = 0;
        int countPositionStateArray = 2;
        while (countStateArray < collectState.size()) {
            EstadosRequestResponse stateResponseTemp = collectState.get(countStateArray);
            if (stateResponseTemp.getSigla().equals("SP")) {
                newStateResponse[0] = stateResponseTemp;
                collectState.remove(countStateArray);
            } else {
                if (stateResponseTemp.getSigla().equals("RJ")) {
                    newStateResponse[1] = stateResponseTemp;
                    collectState.remove(countStateArray);
                } else {
                    newStateResponse[countPositionStateArray] = stateResponseTemp;
                }
            }
            countStateArray++;
            countPositionStateArray++;
        }
        logger.info(newStateResponse[0].getNome());
        logger.info(newStateResponse[1].getNome());
        return newStateResponse;
    }

}
