package pe.com.gmd.mybatis.core.entity;

import java.math.BigDecimal;

public class Regions {
    private BigDecimal regionId;

    private String regionName;

    public BigDecimal getRegionId() {
        return regionId;
    }

    public void setRegionId(BigDecimal regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }
}