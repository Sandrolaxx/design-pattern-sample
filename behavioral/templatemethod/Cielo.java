package behavioral.templatemethod;

public class Cielo extends IAcquirer {

    @Override
    protected void validateCard() {
        System.out.println("Validando o cartão na Cielo.");
    }

    @Override
    protected void authorizeTransaction() {
        System.out.println("Autorizando transação na Cielo.");
    }

    @Override
    protected boolean supportsRecurringPayment() {
        return true;
    }

    @Override
    protected void setupRecurringPayment() {
        System.out.println("Configurando pagamento recorrente na Cielo.");
    }

}
