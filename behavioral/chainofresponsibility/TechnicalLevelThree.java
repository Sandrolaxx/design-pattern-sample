package behavioral.chainofresponsibility;

public class TechnicalLevelThree extends Support {

    @Override
    public void solveProblem(String problemType) {

        if (problemType.equalsIgnoreCase("complex")) {
            System.out.println("N3 resolveu o problema de alta complexidade🤓");
        } else {
            System.out.println("N3 não conseguiu resolver😭. Agora já era. Só os sênior de 16 anos de empresa para resolver🙏");
        }
        
    }

}
