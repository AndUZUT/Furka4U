
package wizut.tpsi.ogloszenia.jpa;


public class OfferFilter {
    
    public Integer manufacturerId;
    public Integer modelId;
    public Integer yearMin;
    public Integer yearMax;
    public Integer fuelTypeId;

    
    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }
    
    public void setYearMin(Integer yearMin) {
        this.yearMin = yearMin;
    }

    public void setYearMax(Integer yearMax) {
        this.yearMax = yearMax;
    }

    public void setFuelTypeId(Integer fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public Integer getYearMin() {
        return yearMin;
    }

    public Integer getYearMax() {
        return yearMax;
    }

    public Integer getFuelTypeId() {
        return fuelTypeId;
    }
    
    
}
