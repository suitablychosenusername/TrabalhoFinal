package br.com.hotel.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.hotel.model.Cliente;

public class ClienteDAOImp implements ClienteDAO{

    @Override
    public String insert(Cliente cliente){
        String sql = "insert into Cliente(codCliente, nomeCliente, rgCliente, enderecoCliente, bairroCliente, cidadeCliente, estadoCliente, cepCliente, nascimentoCliente) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setInt(1,cliente.getCodCliente());
            pstate.setString(2,cliente.getNomeCliente());
            pstate.setString(3,cliente.getRgCliente());
            pstate.setString(4,cliente.getEnderecoCliente());
            pstate.setString(5,cliente.getBairroCliente());
            pstate.setString(6,cliente.getCidadeCliente());
            pstate.setString(7,cliente.getEstadoCliente());
            pstate.setString(8,cliente.getCepCliente());
            pstate.setString(9,cliente.getNascimentoCliente());
            int resp = pstate.executeUpdate();
            if(resp != 0){
                return "SUCESSO NA INSERCAO.";
            }else{
                return "ERRO NA INSERCAO.";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            Conexao.close(con);
        }
    }

    @Override
    public String alt(Cliente cliente){
        String sql = "update Cliente set nomeCliente = ?, rgCliente = ?, enderecoCliente = ?, bairroCliente = ?, cidadeCliente = ?, estadoCliente = ?, cepCliente = ?, nascimentoCliente = ? where codCliente = ?";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setString(1,cliente.getNomeCliente());
            pstate.setString(2,cliente.getRgCliente());
            pstate.setString(3,cliente.getEnderecoCliente());
            pstate.setString(4,cliente.getBairroCliente());
            pstate.setString(5,cliente.getCidadeCliente());
            pstate.setString(6,cliente.getEstadoCliente());
            pstate.setString(7,cliente.getCepCliente());
            pstate.setString(8,cliente.getNascimentoCliente());
            pstate.setInt(9,cliente.getCodCliente());
            int resp = pstate.executeUpdate();
            if(resp != 0){
                return "SUCESSO NA ALTERACAO.";
            }else{
                return "ERRO NA ALTERACAO.";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            Conexao.close(con);
        }
    }
    @Override
    public String delete(Cliente cliente){
        String sql = "delete from Cliente where codCliente = ?";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setInt(1,cliente.getCodCliente());
            int resp = pstate.executeUpdate();
            if(resp != 0){
                return "SUCESSO NA REMOCAO.";
            }else{
                return "ERRO NA REMOCAO.";
            }
        }catch(SQLException e){
            return e.getMessage();
        }finally{
            Conexao.close(con);
        }
    }
    @Override
    public List<Cliente> listAll(){
        String sql = "select * from Cliente";
        Connection con = Conexao.getConexao();
        List<Cliente> clientes = new ArrayList<>();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            ResultSet resp = pstate.executeQuery();
            if(resp != null){
                while (resp.next()){
                    Cliente tupla = new Cliente();
                    tupla.setCodCliente(resp.getInt(1));
                    tupla.setNomeCliente(resp.getString(2));
                    tupla.setRgCliente(resp.getString(3));
                    tupla.setEnderecoCliente(resp.getString(4));
                    tupla.setBairroCliente(resp.getString(5));
                    tupla.setCidadeCliente(resp.getString(6));
                    tupla.setEstadoCliente(resp.getString(7));
                    tupla.setCepCliente(resp.getString(8));
                    tupla.setNascimentoCliente(resp.getString(9));
                    clientes.add(tupla);
                }
                return clientes;
            }else{
                return null;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            Conexao.close(con);
        }
    }
    @Override
    public List<Cliente> search(Cliente cliente){
        String sql = "select * from Cliente where 1=1";
        if(cliente.getCodCliente() != null) {
        	sql = sql + " and codCliente = " + String.valueOf(cliente.getCodCliente());
        }
        if(cliente.getNomeCliente() != null) {
        	sql = sql + " and nomeCliente like \"" + cliente.getNomeCliente() + "\"";
        }
        if(cliente.getRgCliente() != null) {
        	sql = sql + " and rgCliente like \"" + cliente.getRgCliente() + "\"";
        }
        if(cliente.getEnderecoCliente() != null) {
        	sql = sql + " and enderecoCliente like \"" + cliente.getEnderecoCliente() + "\"";
        }
        if(cliente.getBairroCliente() != null) {
        	sql = sql + " and bairroCliente like \"" + cliente.getBairroCliente() + "\"";
        }
        if(cliente.getCidadeCliente() != null) {
        	sql = sql + " and cidadeCliente like \"" + cliente.getCidadeCliente() + "\"";
        }
        if(cliente.getEstadoCliente() != null) {
        	sql = sql + " and estadoCliente like \"" + cliente.getEstadoCliente() + "\"";
        }
        if(cliente.getCepCliente() != null) {
        	sql = sql + " and cepCliente like \"" + cliente.getCepCliente() + "\"";
        }
        if(cliente.getNascimentoCliente() != null) {
        	sql = sql + " and nascimentoCliente like \"" + cliente.getNascimentoCliente() + "\"";
        }
        Connection con = Conexao.getConexao();
        List<Cliente> clientes = new ArrayList<>();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            ResultSet resp = pstate.executeQuery();
            if(resp != null){
                while (resp.next()){
                    Cliente tupla = new Cliente();
                    tupla.setCodCliente(resp.getInt(1));
                    tupla.setNomeCliente(resp.getString(2));
                    tupla.setRgCliente(resp.getString(3));
                    tupla.setEnderecoCliente(resp.getString(4));
                    tupla.setBairroCliente(resp.getString(5));
                    tupla.setCidadeCliente(resp.getString(6));
                    tupla.setEstadoCliente(resp.getString(7));
                    tupla.setCepCliente(resp.getString(8));
                    tupla.setNascimentoCliente(resp.getString(9));
                    clientes.add(tupla);
                }
                return clientes;
            }else{
                return null;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }finally{
            Conexao.close(con);
        }
    }
}