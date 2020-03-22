package com.stoom.fjarro.controller;

/**
 *
 * @author fabio
 */

import com.stoom.fjarro.model.Address;
import com.stoom.fjarro.service.AddressService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    
    private AddressService addressService;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }
    
    
    @GetMapping("/{id}")
    public Address getAdrress(@PathVariable("id") Integer id){
        return addressService.getBy(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address createAdrress(@Valid @RequestBody Address address){
        return addressService.save(address);
    }
    
    @PutMapping("/{id}")
    public Address updateAdrress(@Valid @RequestBody Address address, @PathVariable("id") Integer id){
        address.setId(id);
        return addressService.save(address);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdrress(@PathVariable("id") Integer id){
        addressService.removeBy(id);
    }
}
