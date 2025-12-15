package model;

import utils.Conn;
import utils.LogTransacoes;

import java.sql.*;
import java.util.ArrayList;

public class VeiculoDAO {

    public void inserir(Veiculo v) {
        String sql = "INSERT INTO veiculos (modelo, marca, ano, preco, disponivel) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = Conn.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getMarca());
            stmt.setInt(3, v.getAno());
            stmt.setDouble(4, v.getPreco());
            stmt.setBoolean(5, v.getDisponivel() == 1);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                LogTransacoes.registrar(rs.getInt(1), "INSERT");
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Veiculo> listar() {
        ArrayList<Veiculo> lista = new ArrayList<>();
        String sql = "SELECT * FROM veiculos";

        try {
            Connection conn = Conn.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Veiculo(
                        rs.getInt("id"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getInt("ano"),
                        rs.getDouble("preco"),
                        rs.getBoolean("disponivel") ? 1 : 0));
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(Veiculo v) {
        String sql = "UPDATE veiculos SET modelo=?, marca=?, ano=?, preco=?, disponivel=? WHERE id=?";

        try {
            Connection conn = Conn.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, v.getModelo());
            stmt.setString(2, v.getMarca());
            stmt.setInt(3, v.getAno());
            stmt.setDouble(4, v.getPreco());
            stmt.setBoolean(5, v.getDisponivel() == 1);
            stmt.setInt(6, v.getId());

            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM veiculos WHERE id=?";

        try {
            Connection conn = Conn.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();

            LogTransacoes.registrar(id, "DELETE");

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
