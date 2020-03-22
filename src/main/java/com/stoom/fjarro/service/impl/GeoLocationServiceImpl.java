package com.stoom.fjarro.service.impl;

import com.stoom.fjarro.model.Address;
import com.stoom.fjarro.model.GeoLocation;
import com.stoom.fjarro.service.GeoLocationService;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONObject;

/**
 *
 * @author fabio
 */
@Service
public class GeoLocationServiceImpl implements GeoLocationService{

    private static final String URL_API_MAPS = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String KEY_PARAM = "key";
    private static final String ADDRESS_PARAM = "address";
    private static final String KEY = "AIzaSyBm3xh9oZP1ksMWcMzVaZQevWlrtb8tIgc";
    
    Logger logger = LoggerFactory.getLogger(GeoLocationServiceImpl.class);
    
    @Override
    public GeoLocation getGeoLocation(Address address) {
        GeoLocation geoLocation = new GeoLocation();
        try{
            RestTemplate clientHttp = new RestTemplate();
        
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL_API_MAPS)
                        .queryParam(KEY_PARAM,KEY)
                        .queryParam(ADDRESS_PARAM, address.toString());
            
            String json = clientHttp.getForObject(builder.toUriString(), String.class);
            JSONObject response = new JSONObject(json);
            JSONArray results = response.getJSONArray("results");
            JSONObject geometry = results.getJSONObject(0).getJSONObject("geometry");
            JSONObject location = geometry.getJSONObject("location");
            
            geoLocation.setLatitude(location.getBigDecimal("lat"));
            geoLocation.setLongitude(location.getBigDecimal("lng"));
            
        }catch(Exception e){
            logger.error("Error to get GeoLocation",e);
        }   
        return geoLocation;
    }
}
