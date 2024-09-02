package creatinonal.builder.fluentbuilder;

import creatinonal.builder.fluentbuilder.TravelPackage;

public class TravelPackage {

    private String flight;

    private String hotel;
    
    private String carRental;
    
    private String tour;

    private TravelPackage(Builder builder) {
        this.flight = builder.flight;
        this.hotel = builder.hotel;
        this.carRental = builder.carRental;
        this.tour = builder.tour;
    }

    @Override
    public String toString() {
        return "TravelPackage [Flight=" + flight + ", Hotel=" + hotel +
                ", CarRental=" + carRental + ", Tour=" + tour + "]";
    }

    public static class Builder {

        private String flight;
        
        private String hotel;
        
        private String carRental;
        
        private String tour;

        public Builder() {
        }

        public Builder setFlight(String flight) {
            this.flight = flight;
            return this;
        }

        public Builder setHotel(String hotel) {
            this.hotel = hotel;
            return this;
        }

        public Builder setCarRental(String carRental) {
            this.carRental = carRental;
            return this;
        }

        public Builder setTour(String tour) {
            this.tour = tour;
            return this;
        }

        public TravelPackage build() {
            return new TravelPackage(this);
        }
    }

}
