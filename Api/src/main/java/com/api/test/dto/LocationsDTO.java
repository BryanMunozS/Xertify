/**
 * 
 */
package com.api.test.dto;

import java.io.Serializable;

/**
 * @author Bryan Muñoz
 *
 */
public class LocationsDTO extends ResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Double latitude;
	private Double longitude;
	private String citName;
	private String name;
	private String id;
	private String uuid;
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getCitName() {
		return citName;
	}
	public void setCitName(String citName) {
		this.citName = citName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	

	
	
	
}
