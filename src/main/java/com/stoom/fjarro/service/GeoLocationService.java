/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stoom.fjarro.service;

import com.stoom.fjarro.model.Address;
import com.stoom.fjarro.model.GeoLocation;

/**
 *
 * @author fabio
 */
public interface GeoLocationService {
    public GeoLocation getGeoLocation(Address address);
}
