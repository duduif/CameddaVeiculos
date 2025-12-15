package model;

public class Veiculo {

    private int id;
    private String modelo;
    private String marca;
    private int ano;
    private double preco;
    private int disponivel;

    public Veiculo() {
    }

    public Veiculo(int id, String modelo, String marca, int ano, double preco, int disponivel) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }
}
