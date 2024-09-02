package creatinonal.builder.directorbuilder;

public class TravelDirector {

    public void constructPremiumTravel(ITravelPackageBuilder builder) {
        builder.setFlight("Primeira classe papai💸");
        builder.setHotel("Hotel Copas Verdes🌴");
        builder.setCarRental("Honda Civic 2010 tunado");
        builder.setTour("Tour pelas maravilhas de Cascavel - PR");
    }

    public void constructEntryLevelTravel(ITravelPackageBuilder builder) {
        builder.setFlight("Classe executiva🤵");
        builder.setHotel("Ibis Hotel");
        builder.setCarRental("HB20 Branco");
        builder.setTour("Sem cobertura.");
    }

    public void constructCheapTravel(ITravelPackageBuilder builder) {
        builder.setFlight("Classe econômica😞");
        builder.setHotel("Hotel da antiga rodoviária🚌");
        builder.setCarRental("Sem cobertura.");
        builder.setTour("Sem cobertura.");
    }

}
