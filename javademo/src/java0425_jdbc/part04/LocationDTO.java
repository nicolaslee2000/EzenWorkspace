package java0425_jdbc.part04;

public class LocationDTO {
	private int location_id;
	private String address;
	private String postal_code;
	private String city;
	private String province;
	private String country_id;
	public LocationDTO() {
		
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	@Override
	public String toString() {
		return "LocationDTO [location_id=" + location_id + ", address=" + address + ", postal_code=" + postal_code
				+ ", city=" + city + ", province=" + province + ", country_id=" + country_id + "]";
	}
	
}
