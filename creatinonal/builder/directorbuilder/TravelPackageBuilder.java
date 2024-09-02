package creatinonal.builder.directorbuilder;

public class TravelPackageBuilder implements ITravelPackageBuilder {

    private String flight;

    private String hotel;

    private String carRental;

    private String tour;

    @Override
    public void setFlight(String flight) {
        this.flight = flight;
    }

    @Override
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    @Override
    public void setCarRental(String carRental) {
        this.carRental = carRental;
    }

    @Override
    public void setTour(String tour) {
        this.tour = tour;
    }

    public TravelPackage getResult() {
        return new TravelPackage(flight, hotel, carRental, tour);
    }

}
