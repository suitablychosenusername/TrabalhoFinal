package br.com.hotel.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.hotel.model.Chale;

public class ChaleDAOImp implements ChaleDAO{

    @Override
    public String insert(Chale chale){
        String sql = "insert into Chale(codChale, localizacao, capacidade, valorAltaEstacao, ValorBaixaEstacao) values (?, ?, ?, ?, ?)";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setString(1,chale.getCodChale());
            pstate.setString(2,chale.getLocalizacao());
            pstate.setInt(3,chale.getCapacidade());
            pstate.setDouble(4,chale.getValorAltaEstacao());
            pstate.setDouble(5,chale.getValorBaixaEstacao());
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
    public String alt(Chale chale){
        String sql = "update Chale set localizacao = ?, capacidade = ?, valorAltaEstacao = ?, ValorBaixaEstacao = ? where codChale = ?";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setString(1,chale.getLocalizacao());
            pstate.setInt(2,chale.getCapacidade());
            pstate.setDouble(3,chale.getValorAltaEstacao());
            pstate.setDouble(4,chale.getValorBaixaEstacao());
            pstate.setString(5,chale.getCodChale());
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
    public String delete(Chale chale){
        String sql = "delete from Chale where codChale = ?";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setString(1,chale.getCodChale());
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
    public List<Chale> listAll(){
        String sql = "select * from Chale";
        Connection con = Conexao.getConexao();
        List<Chale> chales = new ArrayList<>();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            ResultSet resp = pstate.executeQuery();
            if(resp != null){
                while (resp.next()){
                    Chale tupla = new Chale();
                    tupla.setCodChale(resp.getString(1));
                    tupla.setLocalizacao(resp.getString(2));
                    tupla.setCapacidade(resp.getInt(3));
                    tupla.setValorAltaEstacao(resp.getDouble(4));
                    tupla.setValorBaixaEstacao(resp.getDouble(5));
                    chales.add(tupla);
                }
                return chales;
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
    public Chale searchCod(String cod){
        String sql = "select * from Chale where codChale = ?";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setString(1, cod);
            ResultSet resp = pstate.executeQuery();
            if(resp.next()){
                Chale tupla = new Chale();
                tupla.setCodChale(resp.getString(1));
                tupla.setLocalizacao(resp.getString(2));
                tupla.setCapacidade(resp.getInt(3));
                tupla.setValorAltaEstacao(resp.getDouble(4));
                tupla.setValorBaixaEstacao(resp.getDouble(5));
                return tupla;
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