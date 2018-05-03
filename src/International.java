public class International<E> extends Transport {
    private String passportNumber;
    private E transportType;
    private String departureStatus;

    public International(E transportType, String passportNumber, String departureStatus) {
        this.passportNumber = passportNumber;
        this.transportType = transportType;
        this.departureStatus = departureStatus;
    }

    public String getPassport()
    {
        return passportNumber;
    }

    public void setTransportType(E newTransportType) {
        this.transportType = newTransportType;
    }
    public E getTransportType() {
        return transportType ;
    }

    @Override
    public String getDepartureStatus(){
        return departureStatus;
    }

}
