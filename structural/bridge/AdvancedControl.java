package structural.bridge;

class AdvancedRemoteControl extends RemoteControl {

    public AdvancedRemoteControl(IDevice device) {
        super(device);
    }

    public void mute() {
        System.out.println("Silenciando o dispositivo...🔇");
        
        device.setVolume(0);
    }
}
