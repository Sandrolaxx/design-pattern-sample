package behavioral.observer.secondsample;

public class SegundoBimestre {
    
    public static void main(String[] args) {
        
        AulaBala aulaBala = new AulaBala();

        IObservador alunoShow = new AlunoLigado();
        IObservador alunoIntermediario = new AlunoIntermediario();
        IObservador alunoPerdido = new AlunoPerdido();
        AlunoPresente alunoPresente = new AlunoPresente();

        aulaBala.registrarObservador(alunoShow);
        aulaBala.registrarObservador(alunoIntermediario);
        aulaBala.registrarObservador(alunoPerdido);

        System.out.println("Hoje veremos sobre observer!");
        System.out.println("--==========================================");
        aulaBala.atualizarInformacoesAula("Hoje veremos sobre observer!");
        
        System.out.println("observer é similar a mediator");
        System.out.println("--==========================================");
        aulaBala.atualizarInformacoesAula("observer é similar a mediator");
        
        System.out.println("imagina se tiver prova");
        System.out.println("--==========================================");
        aulaBala.atualizarInformacoesAula("imagina se tiver prova");

    }

}
