package structural.bridge;

class RemoteControl {

    protected IDevice device;

    public RemoteControl(IDevice device) {
        this.device = device;
    }

    public void togglePower() {
        if (device.isPoweredOn()) {
            device.powerOff();

            return;
        }
        
        device.powerOn();
    }

    public void volumeUp() {
        System.out.println("Aumentando o volume...");
    }

    public void volumeDown() {
        System.out.println("Diminuindo o volume...");
    }
}
