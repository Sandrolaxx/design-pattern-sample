package behavioral.templatemethod;

public abstract class IAcquirer {

    public final void processTransaction() {
        validateCard();
        authorizeTransaction();
        
        if (supportsPaymentLink()) {
            generatePaymentLink();
        }

        if (supportsRecurringPayment()) {
            setupRecurringPayment();
        }

        finishTransaction();
    }

    protected abstract void validateCard();
    
    protected abstract void authorizeTransaction();

    protected boolean supportsPaymentLink() { 
        return false; 
    }

    protected boolean supportsRecurringPayment() { 
        return false; 
    }

    protected void generatePaymentLink() {}

    protected void setupRecurringPayment() {}

    protected void finishTransaction() {
        System.out.println("Finalizando a transação.");
    }
}
