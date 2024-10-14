package behavioral.templatemethod;

public class Stone extends IAcquirer {
 
    @Override
    protected void validateCard() {
        System.out.println("Validando o cartão na Stone.");
    }

    @Override
    protected void authorizeTransaction() {
        System.out.println("Autorizando transação na Stone.");
    }

    @Override
    protected boolean supportsPaymentLink() {
        return true;
    }

    @Override
    protected void generatePaymentLink() {
        System.out.println("Gerando link de pagamento na Stone.");
    }
    
}
