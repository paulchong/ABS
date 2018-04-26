public abstract class Transport {
    private String departureStatus; //whether transport is scheduled or departed
    private String fuel;

    abstract String getFuelType();

    public String getDepartureStatus(){
        return departureStatus;
    }

}
