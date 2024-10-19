package behavioral.observer.secondsample;

public interface ISujeito {
    
    void registrarObservador(IObservador observador);

    void removerObservador(IObservador observador);

    void notificarObeservadores();
    
}
