public class International<E> {
    private String passportNumber;
    private E transportType;

    public International(E transportType, String passportNumber) {
        this.passportNumber = passportNumber;
        this.transportType = transportType;
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

}
