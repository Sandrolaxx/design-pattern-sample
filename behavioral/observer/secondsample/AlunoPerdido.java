package behavioral.observer.secondsample;

public class AlunoPerdido implements IObservador {

    @Override
    public void receber(String informacoesAula) {
        System.out.println("[ALUNO PERDIDO]");

        if (informacoesAula.contains("prova")) {
            System.out.println("Prova??😱");
        }

    }
    
}
