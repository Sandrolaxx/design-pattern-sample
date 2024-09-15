package structural.facade;

public class Application {

    public static void main(String[] args) {
        CinemaFacade cinemaFacade = new CinemaFacade();

        cinemaFacade.bookTicket("Interestelar", 42, "Cartão de Crédito");
    }

}
