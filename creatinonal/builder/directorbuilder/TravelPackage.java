package creatinonal.builder.directorbuilder;

public class TravelPackage {

    private String flight;
    
    private String hotel;
    
    private String carRental;
    
    private String tour;

    public TravelPackage(String flight, String hotel, String carRental, String tour) {
        this.flight = flight;
        this.hotel = hotel;
        this.carRental = carRental;
        this.tour = tour;
    }

    @Override
    public String toString() {
        return "TravelPackage [Flight=" + flight + ", Hotel=" + hotel +
                ", CarRental=" + carRental + ", Tour=" + tour + "]";
    }

}
