package br.com.hotel.controller;

import java.util.List;

import br.com.hotel.model.Hospedagem;
import br.com.hotel.persistence.HospedagemDAOImp;

public class HospedagemController{
    public String insert(Hospedagem hospedagem){
        HospedagemDAOImp hospedagemDao = new HospedagemDAOImp();
        return hospedagemDao.insert(hospedagem);
    }
    public String alt(Hospedagem hospedagem){
        HospedagemDAOImp hospedagemDao = new HospedagemDAOImp();
        return hospedagemDao.alt(hospedagem);
    }
    public String delete(Hospedagem hospedagem){
        HospedagemDAOImp hospedagemDao = new HospedagemDAOImp();
        return hospedagemDao.delete(hospedagem);
    }
    public List<Hospedagem> listAll(){
        HospedagemDAOImp hospedagemDao = new HospedagemDAOImp();
        return hospedagemDao.listAll();
    }
    public Hospedagem searchCod(Integer cod){
        HospedagemDAOImp hospedagemDao = new HospedagemDAOImp();
        return hospedagemDao.searchCod(cod);
    }
}