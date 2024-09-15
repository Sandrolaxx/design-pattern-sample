package structural.facade;

class CinemaFacade {

    private MovieService movieService;

    private SeatService seatService;

    private PaymentService paymentService;

    private ConfirmationService confirmationService;

    public CinemaFacade() {
        movieService = new MovieService();
        seatService = new SeatService();
        paymentService = new PaymentService();
        confirmationService = new ConfirmationService();
    }

    public void bookTicket(String movie, int seatNumber, String paymentMethod) {
        movieService.chooseMovie(movie);
        seatService.selectSeat(seatNumber);
        paymentService.makePayment(paymentMethod);
        confirmationService.sendConfirmation(movie, seatNumber);

        System.out.println("Reserva de ingresso concluída com sucesso!");
    }
    
}
