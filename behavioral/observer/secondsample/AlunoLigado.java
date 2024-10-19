package behavioral.observer.secondsample;

import java.util.ArrayList;
import java.util.List;

public class AlunoLigado implements IObservador {
    
    List<String> anotacoes = new ArrayList<>();

    @Override
    public void receber(String informacoesAula) {
        System.out.println("[ALUNO LIGADO]");

        if (anotacoes.stream().filter(info -> info.contains(informacoesAula)).findFirst().isPresent()) {
            System.out.println("Mas professor isso não é o mesmo que tal conceito?...");
        }

        if (informacoesAula.contains("prova")) {
            System.out.println("Prova sossegado🙏...");
        }

        System.out.println("Realizando anotações...");
        anotacoes.add(informacoesAula);
    }

}
