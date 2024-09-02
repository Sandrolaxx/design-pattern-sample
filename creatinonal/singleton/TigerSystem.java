package creatinonal.singleton;

public class TigerSystem {

    public static void main(String[] args) {

        Logger logger = Logger.getInstance();

        try {
            hanldeBet(1000d);
            // hanldeBet(null); //Simular utilização
        } catch (Exception ex) {
            logger.log("Erro ao realizar transação: " + ex);
        }
    }

    public static void hanldeBet(Double amount) throws Exception {
        if (amount == null) {
            throw new Exception("Valor inválido!");
        }

        if (amount <= 20) {
            System.out.println("Parabéns você ganhou!");

            return;
        }

        // A banca sempre vence🤡
        System.out.println("Infelizmente você perdeu! Tente novamente.");
    }

}
