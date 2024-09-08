package structural.bridge;

class TV implements IDevice {

    private boolean on = false;

    private int volume = 50;

    @Override
    public void powerOn() {
        on = true;
        System.out.println("TV ligada.📺");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("TV desligada.⛔📺");
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
        System.out.println("Volume da TV ajustado para: " + volume + "%");
    }

    @Override
    public boolean isPoweredOn() {
        return on;
    }
    
}
