package behavioral.memento;

public class Application {
    public static void main(String[] args) {
        Document documento = new Document();
        History historico = new History();

        documento.write("Primeiro rascunho");
        historico.save(documento.save());

        documento.write("Segundo rascunho");
        historico.save(documento.save());

        documento.write("Terceiro rascunho");
        historico.save(documento.save());

        System.out.println("Conteúdo atual: " + documento.getContent());

        documento.restore(historico.undo());
        System.out.println("Após desfazer: " + documento.getContent());

        documento.restore(historico.undo());
        System.out.println("Após desfazer novamente: " + documento.getContent());

        documento.restore(historico.undo());
        System.out.println("Após desfazer novamente: " + documento.getContent());
    }

}
