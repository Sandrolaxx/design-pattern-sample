package behavioral.observer.secondsample;

import java.util.ArrayList;
import java.util.List;

public class AulaBala implements ISujeito {

    List<IObservador> observadores = new ArrayList<>();

    private String informacoesAula;

    @Override
    public void registrarObservador(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObeservadores() {
        for (IObservador iObservador : observadores) {
            iObservador.receber(informacoesAula);
        }
    }

    public void atualizarInformacoesAula(String novasInformacoes) {
        this.informacoesAula = novasInformacoes;

        notificarObeservadores();
    }

}
