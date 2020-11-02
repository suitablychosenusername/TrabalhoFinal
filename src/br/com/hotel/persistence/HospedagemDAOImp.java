package br.com.hotel.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.hotel.model.Hospedagem;

public class HospedagemDAOImp implements HospedagemDAO{

    @Override
    public String insert(Hospedagem hospedagem){
        String sql = "insert into Hospedagem(codHospedagem, codChale, estado, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) values (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setInt(1,hospedagem.getCodHospedagem());
            pstate.setString(2,hospedagem.getCodChale());
            pstate.setString(3,hospedagem.getEstado());
            pstate.setString(4,hospedagem.getDataInicio());
            pstate.setString(5,hospedagem.getDataFim());
            pstate.setInt(6,hospedagem.getQtdPessoas());
            pstate.setInt(7,hospedagem.getDesconto());
            pstate.setDouble(8,hospedagem.getValorFinal());
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
    public String alt(Hospedagem hospedagem){
        String sql = "update Hospedagem set codChale = ?, estado = ?, dataInicio = ?, dataFim = ?, qtdPessoas = ?, desconto = ?, valorFinal = ? where codHospedagem = ?";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setString(1,hospedagem.getCodChale());
            pstate.setString(2,hospedagem.getEstado());
            pstate.setString(3,hospedagem.getDataInicio());
            pstate.setString(4,hospedagem.getDataFim());
            pstate.setInt(5,hospedagem.getQtdPessoas());
            pstate.setInt(6,hospedagem.getDesconto());
            pstate.setDouble(7,hospedagem.getValorFinal());
            pstate.setInt(8,hospedagem.getCodHospedagem());
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
    public String delete(Hospedagem hospedagem){
        String sql = "delete from Hospedagem where codHospedagem = ?";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setInt(1,hospedagem.getCodHospedagem());
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
    public List<Hospedagem> listAll(){
        String sql = "select * from Hospedagem";
        Connection con = Conexao.getConexao();
        List<Hospedagem> Hospedagens = new ArrayList<>();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            ResultSet resp = pstate.executeQuery();
            if(resp != null){
                while (resp.next()){
                    Hospedagem tupla = new Hospedagem();
                    tupla.setCodHospedagem(resp.getInt(1));
                    tupla.setCodChale(resp.getString(2));
                    tupla.setEstado(resp.getString(3));
                    tupla.setDataInicio(resp.getString(4));
                    tupla.setDataFim(resp.getString(5));
                    tupla.setQtdPessoas(resp.getInt(6));
                    tupla.setDesconto(resp.getInt(7));
                    tupla.setValorFinal(resp.getDouble(8));
                    Hospedagens.add(tupla);
                }
                return Hospedagens;
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
    public Hospedagem searchCod(Integer cod){
        String sql = "select * from Hospedagem where codHospedagem = ?";
        Connection con = Conexao.getConexao();
        try{
            PreparedStatement pstate = con.prepareStatement(sql);
            pstate.setInt(1, cod);
            ResultSet resp = pstate.executeQuery();
            if(resp.next()){
                Hospedagem tupla = new Hospedagem();
                tupla.setCodHospedagem(resp.getInt(1));
                tupla.setCodChale(resp.getString(2));
                tupla.setEstado(resp.getString(3));
                tupla.setDataInicio(resp.getString(4));
                tupla.setDataFim(resp.getString(5));
                tupla.setQtdPessoas(resp.getInt(6));
                tupla.setDesconto(resp.getInt(7));
                tupla.setValorFinal(resp.getDouble(8));
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