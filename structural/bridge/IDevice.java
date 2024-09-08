package structural.bridge;

public interface IDevice {
    
    void powerOn();

    void powerOff();

    void setVolume(int percent);

    boolean isPoweredOn();

}
