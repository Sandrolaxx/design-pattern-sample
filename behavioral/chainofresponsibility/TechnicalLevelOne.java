package behavioral.chainofresponsibility;

public class TechnicalLevelOne extends Support {

    @Override
    public void solveProblem(String problemType) {
 
        if (problemType.equalsIgnoreCase("low")) {
            System.out.println("N1 resolveu o problema de baixa complexidade. Mais um pro pai😎.");
        } else {
            System.out.println("N1 não conseguiu resolver😢. Encaminhando para o N2...");
            if (nextLevel != null) {
                nextLevel.solveProblem(problemType);
            }
        }
        
    }
}