package behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<IProduct> products = new ArrayList<>();
        IProduct service = new Product("Frete municipal - Pedido#234653", 95.00);
        
        products.add(new Product("Placa de Vídeo RTX 4060 VENTUS", 1950.00));
        products.add(new Product("Fonte MSI MAG A650BN, 650W, 80 Plus Bronze", 294.50));
        products.add(new Product("Mouse Gamer HyperX Pulsefire Core RGB 6200 DPI", 149.00));

        IVisitor icmsCalculator = new ICMSCalculatorVisitor();
        IVisitor cofinsCalculator = new COFINSCalculatorVisitor();
        IVisitor issCalculator = new ISSCalculatorVisitor();

        for (IProduct product : products) {
            product.accept(icmsCalculator);
        }

        System.out.println();

        for (IProduct product : products) {
            product.accept(cofinsCalculator);
        }

        System.out.println();

        service.accept(issCalculator);
    }
}
