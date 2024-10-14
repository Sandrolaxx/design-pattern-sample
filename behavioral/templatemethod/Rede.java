package behavioral.templatemethod;

public class Rede extends IAcquirer {

    @Override
    protected void validateCard() {
        System.out.println("Validando o cartão no Rede.");
    }

    @Override
    protected void authorizeTransaction() {
        System.out.println("Autorizando transação no Rede.");
    }
    
}
