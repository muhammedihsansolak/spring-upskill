package com.cydeo.service.impl;

import com.cydeo.client.WeatherApiClient;
import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.WeatherDTO;
import com.cydeo.entity.Address;
import com.cydeo.util.MapperUtil;
import com.cydeo.repository.AddressRepository;
import com.cydeo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final WeatherApiClient weatherApiClient;

    @Value("${access_key}")
    private String access_key;

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }


    @Override
    public AddressDTO findById(Long id) throws Exception {

        Address foundAddress = addressRepository.findById(id)
                .orElseThrow(() -> new Exception("No Address Found!"));

        AddressDTO addressDTO = mapperUtil.convert(foundAddress, new AddressDTO());

        addressDTO.setCurrentTemperature(getCurrentWeather(addressDTO.getCity()).getCurrent().getTemperature());

        return addressDTO;

    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) throws Exception {

        addressRepository.findById(addressDTO.getId())
                .orElseThrow(() -> new Exception("No Address Found!"));

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        AddressDTO updatedAddress = mapperUtil.convert(addressToSave, new AddressDTO());
        updatedAddress.setCurrentTemperature(getCurrentWeather(updatedAddress.getCity()).getCurrent().getTemperature());

        return updatedAddress;
    }

    private WeatherDTO getCurrentWeather(String city) {
        return weatherApiClient.getCurrentWeather( access_key ,city);
    }
}