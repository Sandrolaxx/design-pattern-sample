package structural.bridge;

class Radio implements IDevice {

    private boolean on = false;

    private int volume = 50;

    @Override
    public void powerOn() {
        on = true;
        System.out.println("Rádio ligado.📻");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("Rádio desligado.⛔📻");
    }

    @Override
    public void setVolume(int percent) {
        this.volume = percent;
        System.out.println("Volume do rádio ajustado para: " + volume + "%");
    }

    @Override
    public boolean isPoweredOn() {
        return on;
    }
}
