package com.stoom.fjarro.model;

import java.math.BigDecimal;
import javax.persistence.Column;

/**
 *
 * @author fabio
 */
public class GeoLocation {
    
    @Column(name = "LATITUDE")
    private BigDecimal latitude;
    
    @Column(name = "LONGITUDE")
    private BigDecimal longitude;

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.latitude != null ? this.latitude.hashCode() : 0);
        hash = 59 * hash + (this.longitude != null ? this.longitude.hashCode() : 0);
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
        final GeoLocation other = (GeoLocation) obj;
        if (this.latitude != other.latitude && (this.latitude == null || !this.latitude.equals(other.latitude))) {
            return false;
        }
        if (this.longitude != other.longitude && (this.longitude == null || !this.longitude.equals(other.longitude))) {
            return false;
        }
        return true;
    }    
}
