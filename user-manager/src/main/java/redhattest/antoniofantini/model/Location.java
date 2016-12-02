package redhattest.antoniofantini.model;

import java.io.Serializable;
import java.util.Objects;

public class Location implements Serializable{
	private static final long serialVersionUID = 5971224156717070242L;
	private String street;
	private String city;
	private String state;
	private String zip;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
        if (!(o instanceof Location)) {
            return false;
        }
        Location loc = (Location) o;
        return this.street.equalsIgnoreCase(loc.getStreet())
        		&& this.city.equalsIgnoreCase(loc.getCity())
        		&& this.state.equalsIgnoreCase(loc.getState())
        		&& this.zip.equalsIgnoreCase(loc.getState());
        
	}
	@Override
	public int hashCode() {
		return Objects.hash(this.street, this.city, this.state, this.zip);
	}
}
