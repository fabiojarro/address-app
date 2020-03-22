package com.stoom.fjarro.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/**
 *
 * @author fabio
 */
@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {
    
    @Id
    @Column(name = "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message = "streetName is mandatory")
    @Column(name = "STREET_NAME",nullable = false)
    private String streetName;
    
    @Column(name = "NUMBER",nullable = false)
    @NotNull(message = "number is mandatory")
    private Integer number;
    
    @Column(name = "COMPLEMENT")
    private String complement;
    
    @Column(name = "NEIGHBOURHOOD",nullable = false)
    @NotBlank(message = "neighbourhood is mandatory")
    private String neighbourhood;
    
    @Column(name = "CITY",nullable = false)
    @NotBlank(message = "city is mandatory")
    private String city;
    
    @Column(name = "STATE",nullable = false)
    @NotBlank(message = "state is mandatory")
    private String state;
    
    @Column(name = "COUNTRY",nullable = false)
    @NotBlank(message = "country is mandatory")
    private String country;
    
    @Column(name = "ZIP_CODE",nullable = false)
    @NotBlank(message = "zipcode is mandatory")
    private String zipcode;
    
    @Embedded
    private GeoLocation geoLocation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }
    
    
    public boolean containsGeoLocation() {
        return geoLocation != null 
                && geoLocation.getLatitude() != null 
                && geoLocation.getLatitude() != null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 53 * hash + (this.streetName != null ? this.streetName.hashCode() : 0);
        hash = 53 * hash + (this.number != null ? this.number.hashCode() : 0);
        hash = 53 * hash + (this.neighbourhood != null ? this.neighbourhood.hashCode() : 0);
        hash = 53 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 53 * hash + (this.state != null ? this.state.hashCode() : 0);
        hash = 53 * hash + (this.country != null ? this.country.hashCode() : 0);
        hash = 53 * hash + (this.zipcode != null ? this.zipcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if ((this.streetName == null) ? (other.streetName != null) : !this.streetName.equals(other.streetName)) {
            return false;
        }
        if ((this.neighbourhood == null) ? (other.neighbourhood != null) : !this.neighbourhood.equals(other.neighbourhood)) {
            return false;
        }
        if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city)) {
            return false;
        }
        if ((this.state == null) ? (other.state != null) : !this.state.equals(other.state)) {
            return false;
        }
        if ((this.country == null) ? (other.country != null) : !this.country.equals(other.country)) {
            return false;
        }
        if ((this.zipcode == null) ? (other.zipcode != null) : !this.zipcode.equals(other.zipcode)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.number != other.number && (this.number == null || !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder(streetName).append(",")
                    .append(number).append(",")
                    .append(neighbourhood).append(",")
                    .append(city).append(",")
                    .append(state).append(",")
                    .append(country).toString();
    }
}
