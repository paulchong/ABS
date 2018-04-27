public abstract class Transport {
    private String fuelType;

    public String getFuelType(){
        return fuelType;
    }

    abstract String getDepartureStatus();
}
