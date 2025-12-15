package view;

import controller.VeiculoController;
import model.Veiculo;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner in = new Scanner(System.in);
    private VeiculoController controller = new VeiculoController();

    public void iniciar() {
        int op = -1;

        while (op != 0) {
            System.out.println("\n=== CAMEDDA VEÍCULOS ===");
            System.out.println("1 - Listar veículos");
            System.out.println("2 - Cadastrar veículo");
            System.out.println("3 - Editar veículo");
            System.out.println("4 - Excluir veículo");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            op = in.nextInt();
            in.nextLine();

            switch (op) {
                case 1:
                    listar();
                    break;
                case 2:
                    cadastrar();
                    break;
                case 3:
                    editar();
                    break;
                case 4:
                    excluir();
                    break;
            }
        }
    }

    private void listar() {
        ArrayList<Veiculo> lista = controller.listar();

        for (Veiculo v : lista) {
            System.out.println(
                    v.getId() + " | " +
                            v.getModelo() + " | " +
                            v.getMarca() + " | " +
                            v.getAno() + " | R$ " +
                            v.getPreco() + " | " +
                            (v.getDisponivel() == 1 ? "Disponível" : "Indisponível"));
        }
    }

    private void cadastrar() {
        Veiculo v = new Veiculo();

        System.out.print("Modelo: ");
        v.setModelo(in.nextLine());
        System.out.print("Marca: ");
        v.setMarca(in.nextLine());
        System.out.print("Ano: ");
        v.setAno(in.nextInt());
        System.out.print("Preço: ");
        v.setPreco(in.nextDouble());
        in.nextLine();
        System.out.print("Disponível (S/N): ");
        String resp = in.nextLine().toUpperCase();
        v.setDisponivel(resp.equals("S") ? 1 : 0);

        controller.cadastrar(v);
        System.out.println("Veículo cadastrado!");
    }

    private void editar() {
        System.out.print("ID: ");
        int id = in.nextInt();
        in.nextLine();

        Veiculo v = controller.buscar(id);
        if (v == null) {
            System.out.println("Não encontrado!");
            return;
        }

        System.out.print("Modelo (" + v.getModelo() + "): ");
        String m = in.nextLine();
        if (!m.isEmpty())
            v.setModelo(m);

        System.out.print("Marca (" + v.getMarca() + "): ");
        String ma = in.nextLine();
        if (!ma.isEmpty())
            v.setMarca(ma);

        System.out.print("Ano (" + v.getAno() + "): ");
        String a = in.nextLine();
        if (!a.isEmpty())
            v.setAno(Integer.parseInt(a));

        System.out.print("Preço (" + v.getPreco() + "): ");
        String p = in.nextLine();
        if (!p.isEmpty())
            v.setPreco(Double.parseDouble(p));

        System.out.print("Disponível (" + (v.getDisponivel() == 1 ? "S" : "N") + "): ");
        String d = in.nextLine().toUpperCase();
        if (!d.isEmpty()) {
            v.setDisponivel(d.equals("S") ? 1 : 0);
        }

        controller.editar(v);
        System.out.println("Atualizado!");
    }

    private void excluir() {
        System.out.print("ID: ");
        int id = in.nextInt();
        in.nextLine();
        controller.excluir(id);
        System.out.println("Excluído!");
    }
}
