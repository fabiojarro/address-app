package com.stoom.fjarro.service;

import com.stoom.fjarro.model.Address;

/**
 *
 * @author fabio
 */
public interface AddressService {

    public Address save(Address address);
    
    public Address getBy(Integer id);
    
    public void removeBy(Integer id);
}
