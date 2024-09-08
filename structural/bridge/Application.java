package structural.bridge;

public class Application {

    public static void main(String[] args) {

        IDevice tv = new TV();
        RemoteControl tvRemote = new RemoteControl(tv);

        tvRemote.togglePower();
        tvRemote.volumeUp();

        IDevice radio = new Radio();
        AdvancedRemoteControl radioRemote = new AdvancedRemoteControl(radio);

        radioRemote.togglePower();
        radioRemote.mute();
    }

}
