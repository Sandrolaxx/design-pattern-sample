package creatinonal.builder.directorbuilder;

public class TravelAgency {
    public static void main(String[] args) {

        TravelDirector diretor = new TravelDirector();
        TravelPackageBuilder builder = new TravelPackageBuilder();

        diretor.constructCheapTravel(builder);

        TravelPackage cheapPackage = builder.getResult();
        
        diretor.constructEntryLevelTravel(builder);
        
        TravelPackage entryLevelPackage = builder.getResult();
        
        diretor.constructPremiumTravel(builder);
        
        TravelPackage primiumPackage = builder.getResult();

        System.out.println(cheapPackage.toString());
        System.out.println(entryLevelPackage.toString());
        System.out.println(primiumPackage.toString());
    
    }
}
