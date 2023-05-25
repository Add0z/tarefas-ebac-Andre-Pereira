package Dao;

import DataBaseConnection.ConnectionFactory;
import Domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao implements IProdutoDao {


    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adicionarParametrosInsert(stm, produto);
            return stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection,stm,null);
        }
    }


    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO PRODUTO2 (Id,CODIGO,NOME) ");
        sb.append("VALUES (nextval('sq_Produto2'),?,?) ");
        return sb.toString();
    }

    private void adicionarParametrosInsert(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getCodigo());
        stm.setString(2, produto.getNome());
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
       Connection connection = null;
       PreparedStatement stm = null;
       try {
           connection = ConnectionFactory.getConnection();
           String sql = getSqlUpdate();
           stm = connection.prepareStatement(sql);
           adicionarParametrosUpdate(stm, produto);
           return stm.executeUpdate();
       } catch (Exception e){
           throw e;

       }finally {
           closeConnection(connection,stm,null);
       }
    }

    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE PRODUTO2 SET ");
        sb.append("CODIGO = ?, NOME = ? WHERE ID = ? ");
        return sb.toString();
    }

    private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException{
        stm.setString(1, produto.getCodigo());
        stm.setString(2, produto.getNome());
        stm.setLong(3, produto.getId());
    }

    @Override
    public Produto buscar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adicionarParametrosSelect(stm, codigo);
            rs = stm.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("ID");
                String cd = rs.getString("CODIGO");
                String nome = rs.getString("NOME");
                produto.setId(id);
                produto.setNome(nome);
                produto.setCodigo(cd);
            }
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(connection,stm,rs);
        }
        return produto;
    }

    private void adicionarParametrosSelect(PreparedStatement stm, String codigo) throws SQLException {
        stm.setString(1, codigo);
    }

    private String getSqlSelect(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM PRODUTO2 ");
        sb.append(" WHERE codigo = ? ");
        return sb.toString();
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adicionarParametrosDelete(stm, produto);
            return stm.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(connection,stm,null);
        }
    }

    private void adicionarParametrosDelete(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getCodigo());
    }

    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM PRODUTO2 ");
        sb.append("WHERE CODIGO = ? ");
        return sb.toString();
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> list = new ArrayList<>();
        Produto produto = null;
        try {
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()){
                produto = new Produto();
                Long id = rs.getLong("ID");
                String cd = rs.getString("CODIGO");
                String nome = rs.getString("NOME");
                produto.setId(id);
                produto.setCodigo(cd);
                produto.setNome(nome);
                list.add(produto);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection,stm,rs);
        }return list;
    }

    private String getSqlSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM PRODUTO2");
        return sb.toString();
    }

    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try{
            if (rs != null && !rs.isClosed()){
                rs.close();
            }
            if (stm != null && !stm.isClosed()){
                stm.close();
            }
            if (connection!=null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}






























