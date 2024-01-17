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
    private long seedName;
    private long seedSoil;
    private long seedFertilizer;
    private long seedWater;
    private long seedLight;
    private long seedTemperature;
    private long seedHumidity;
    private long seedLocation;

    public SeedEspesification(long seedName) {
        this.seedName = seedName;
    }

    public long getSeedName() {
        return seedName;
    }

    public long getSeedSoil() {
        return seedSoil;
    }

    public long getSeedFertilizer() {
        return seedFertilizer;
    }

    public long getSeedWater() {
        return seedWater;
    }

    public long getSeedLight() {
        return seedLight;
    }

    public long getSeedTemperature() {
        return seedTemperature;
    }

    public long getSeedHumidity() {
        return seedHumidity;
    }

    public long getSeedLocation() {
        return seedLocation;
    }

    public void setSeedName(long seedName) {
        this.seedName = seedName;
    }

    public void setSeedSoil(long seedSoil) {
        this.seedSoil = seedSoil;
    }

    public void setSeedFertilizer(long seedFertilizer) {
        this.seedFertilizer = seedFertilizer;
    }

    public void setSeedWater(long seedWater) {
        this.seedWater = seedWater;
    }

    public void setSeedLight(long seedLight) {
        this.seedLight = seedLight;
    }

    public void setSeedTemperature(long seedTemperature) {
        this.seedTemperature = seedTemperature;
    }

    public void setSeedHumidity(long seedHumidity) {
        this.seedHumidity = seedHumidity;
    }

    public void setSeedLocation(long seedLocation) {
        this.seedLocation = seedLocation;
    }
    
    
    
    public boolean itsInRange (int source, int rangeValue){
        int firstValue = source;
        int lastValue = source+rangeValue-1;
        return (firstValue <= seedName && seedName<=lastValue);
    }
    public boolean itsInRange (long source, long rangeValue, String lettersReference){
        long firstValue = source;
        long lastValue = source+rangeValue;
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
               return (firstValue <= seedName && seedName<=lastValue); 
        }
    }
}
