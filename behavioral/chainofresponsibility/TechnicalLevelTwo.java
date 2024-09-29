package behavioral.chainofresponsibility;

public class TechnicalLevelTwo extends Support {

    @Override
    public void solveProblem(String problemType) {

        if (problemType.equalsIgnoreCase("intermediate")) {
            System.out.println("N2 resolveu o problema de complexidade intermediária. Easy🚀");
        } else {
            System.out.println("N2 não conseguiu resolver😞. Encaminhando para o N3...");
            if (nextLevel != null) {
                nextLevel.solveProblem(problemType);
            }
        }

    }
}
