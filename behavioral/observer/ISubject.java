package behavioral.observer;

public interface ISubject {
 
    void registerObserver(IObserver o);
 
    void removeObserver(IObserver o);
 
    void notifyObservers();
    
}
