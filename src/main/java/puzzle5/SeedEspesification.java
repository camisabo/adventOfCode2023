/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle5;

/**
 *
 * @author Omar Nicolas Guerrero
 */
public class SeedEspesification {
    private Integer seedName;
    private Integer seedSoil;
    private Integer seedFertilizer;
    private Integer seedWater;
    private Integer seedLight;
    private Integer seedTemperature;
    private Integer seedHumidity;
    private Integer seedLocation;

    public SeedEspesification(Integer seedName) {
        this.seedName = seedName;
    }

    public Integer getSeedName() {
        return seedName;
    }

    public Integer getSeedSoil() {
        return seedSoil;
    }

    public Integer getSeedFertilizer() {
        return seedFertilizer;
    }

    public Integer getSeedWater() {
        return seedWater;
    }

    public Integer getSeedLight() {
        return seedLight;
    }

    public Integer getSeedTemperature() {
        return seedTemperature;
    }

    public Integer getSeedHumidity() {
        return seedHumidity;
    }

    public Integer getSeedLocation() {
        return seedLocation;
    }

    public void setSeedName(Integer seedName) {
        this.seedName = seedName;
    }

    public void setSeedSoil(Integer seedSoil) {
        this.seedSoil = seedSoil;
    }

    public void setSeedFertilizer(Integer seedFertilizer) {
        this.seedFertilizer = seedFertilizer;
    }

    public void setSeedWater(Integer seedWater) {
        this.seedWater = seedWater;
    }

    public void setSeedLight(Integer seedLight) {
        this.seedLight = seedLight;
    }

    public void setSeedTemperature(Integer seedTemperature) {
        this.seedTemperature = seedTemperature;
    }

    public void setSeedHumidity(Integer seedHumidity) {
        this.seedHumidity = seedHumidity;
    }

    public void setSeedLocation(Integer seedLocation) {
        this.seedLocation = seedLocation;
    }
    
    
    
    public boolean itsInRange (int source, int rangeValue){
        int firstValue = source;
        int lastValue = source+rangeValue-1;
        return (firstValue <= seedName && seedName<=lastValue);
    }
    public boolean itsInRange (int source, int rangeValue, String lettersReference){
        int firstValue = source;
        int lastValue = source+rangeValue;
        switch (lettersReference){
                
            case "fe": //fertilizer 
                return (firstValue <= seedSoil && seedSoil <=lastValue);
                
            case "wa": //water
                return (firstValue <= seedFertilizer && seedFertilizer <=lastValue);
                
            case "li": //light
                return (firstValue <= seedWater && seedWater <=lastValue);
                
            case "te": //temperature
                return (firstValue <= seedLight && seedLight <=lastValue);
                
            case "hu": //humidity
                return (firstValue <= seedTemperature && seedTemperature <=lastValue);
                
            case "lo": //responce or locaion
                return (firstValue <= seedHumidity && seedHumidity <=lastValue);
                
            default:
               return (firstValue <= seedName && seedName <=lastValue); 
        }
    }
}
