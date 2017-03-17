package pe.com.gmd.jdbc.core.entity;

import java.math.BigDecimal;

public class Regions {
	
	//Declarar los atributos
	private BigDecimal regionId;
	private String regionName;
	
	//Declarar el constructor
	public Regions(){
		
	}
	
	public Regions(String regionName){
		this.regionName = regionName;
	}
	
	//Declarar los get y set
	public BigDecimal getRegionId() {
		return regionId;
	}
	
	public String getRegionName() {
		return regionName;
	}
	
	public void setRegionId(BigDecimal regionId) {
		this.regionId = regionId;
	}
	
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	

}
