package com.stoom.fjarro.service.impl;

import com.stoom.fjarro.model.Address;
import com.stoom.fjarro.model.GeoLocation;
import com.stoom.fjarro.repostory.AddressRepository;
import com.stoom.fjarro.service.AddressService;
import com.stoom.fjarro.service.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabio
 */
@Service
public class AddressServiceImpl implements  AddressService{
    
    private AddressRepository addressRepository;
    
    private GeoLocationService geoLocationService;

    @Autowired
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Autowired
    public void setGeoLocationService(GeoLocationService geoLocationService) {
        this.geoLocationService = geoLocationService;
    }
    
    @Override
    public Address save(Address address) {
        if(!address.containsGeoLocation()){
            GeoLocation geoLocation = geoLocationService.getGeoLocation(address);
            address.setGeoLocation(geoLocation);
        }
        return addressRepository.save(address);
    }

    @Override
    public Address getBy(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public void removeBy(Integer id) {
        addressRepository.deleteById(id);
    }

}
