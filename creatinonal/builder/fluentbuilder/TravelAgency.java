package creatinonal.builder.fluentbuilder;

public class TravelAgency {
    public static void main(String[] args) {

        TravelPackage basicPackage = new TravelPackage.Builder()
            .setFlight("Classe econômica😞")
            .setHotel("Hotel da antiga rodoviária🚌")
            .build();

        System.out.println(basicPackage);

        TravelPackage premiumPackage = new TravelPackage.Builder()
            .setFlight("Primeira classe papai💸")
            .setHotel("Hotel Copas Verdes🌴")
            .setCarRental("Honda Civic 2010 tunado")
            .setTour("Tour pelas maravilhas de Cascavel - PR")
            .build();

        System.out.println(premiumPackage);
    }
}
