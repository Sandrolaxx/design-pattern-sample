package behavioral.templatemethod;

public class Application {
    public static void main(String[] args) {
        
        IAcquirer stone = new Stone();
        IAcquirer cielo = new Cielo();
        IAcquirer rede = new Rede();

        System.out.println("Processando transação na Stone:");
        stone.processTransaction();

        System.out.println("\nProcessando transação na Cielo:");
        cielo.processTransaction();

        System.out.println("\nProcessando transação na Rede:");
        rede.processTransaction();

    }

}
