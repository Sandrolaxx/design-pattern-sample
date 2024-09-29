package behavioral.interpreter;

public class Calculator {
    public static void main(String[] args) {

        Expression expressao = new Sub(
                new Sum(new Number(10), new Number(5)),
                new Number(3)
        );

        int resultado = expressao.interpret();

        System.out.println("Resultado: " + resultado);
    }
}
