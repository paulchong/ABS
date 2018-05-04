public class International<E> {
    private E transportType;
    private String passportNumber;

    public International(E transportType, String passportNumber) {
        this.transportType = transportType;
        this.passportNumber = passportNumber;
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
