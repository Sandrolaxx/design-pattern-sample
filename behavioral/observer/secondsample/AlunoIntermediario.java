package behavioral.observer.secondsample;

import java.util.ArrayList;
import java.util.List;

public class AlunoIntermediario implements IObservador {

    List<String> anotacoes = new ArrayList<>();

    @Override
    public void receber(String informacoesAula) {
        System.out.println("[ALUNO INTERMEDIÁRIO]");
        
        if (informacoesAula.contains("prova")) {
            System.out.println("Eita🥶, vou estudar para a prova...");
        }

        System.out.println("Realizando anotações...");
        anotacoes.add(informacoesAula);
    }

}
