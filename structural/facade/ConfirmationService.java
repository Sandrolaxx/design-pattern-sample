package structural.facade;

class ConfirmationService {

    public void sendConfirmation(String movie, int seatNumber) {
        System.out.println("E-mail de confirmação do filme " + movie + " no assento " + seatNumber);
    }

}
