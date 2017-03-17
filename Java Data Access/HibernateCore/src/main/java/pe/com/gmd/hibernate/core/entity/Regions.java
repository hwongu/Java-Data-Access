package pe.com.gmd.hibernate.core.entity;
// Generated 12/03/2017 12:34:57 PM by Hibernate Tools 5.2.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Regions generated by hbm2java
 */
@Entity
@Table(name = "REGIONS", schema = "HR")
public class Regions implements java.io.Serializable {

	private BigDecimal regionId;
	private String regionName;
	private Set<Countries> countrieses = new HashSet<Countries>(0);

	public Regions() {
	}

	public Regions(BigDecimal regionId) {
		this.regionId = regionId;
	}

	public Regions(BigDecimal regionId, String regionName, Set<Countries> countrieses) {
		this.regionId = regionId;
		this.regionName = regionName;
		this.countrieses = countrieses;
	}

	@Id
	@SequenceGenerator(name = "REGIONS_SEQ", sequenceName = "REGIONS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REGIONS_SEQ")
	@Column(name = "REGION_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getRegionId() {
		return this.regionId;
	}

	public void setRegionId(BigDecimal regionId) {
		this.regionId = regionId;
	}

	@Column(name = "REGION_NAME", length = 25)
	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "regions")
	public Set<Countries> getCountrieses() {
		return this.countrieses;
	}

	public void setCountrieses(Set<Countries> countrieses) {
		this.countrieses = countrieses;
	}

}
