package behavioral.chainofresponsibility;

public class Application {

    public static void main(String[] args) {

        Support n1 = new TechnicalLevelOne();
        Support n2 = new TechnicalLevelTwo();
        Support n3 = new TechnicalLevelThree();

        n1.setNextLevel(n2);
        n2.setNextLevel(n3);

        System.out.println("Chamado 1: Problema simples");
        n1.solveProblem("low");

        System.out.println("\nChamado 2: Problema intermediário");
        n1.solveProblem("intermediate");

        System.out.println("\nChamado 3: Problema complexo");
        n1.solveProblem("complex");

        System.out.println("\nChamado 4: Problema desconhecido");
        n1.solveProblem("unknown");
        
    }
}
