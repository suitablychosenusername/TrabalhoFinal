package br.com.hotel.controller;

import java.util.List;

import br.com.hotel.model.Chale;
import br.com.hotel.persistence.ChaleDAOImp;

public class ChaleController{
    public String insert(Chale chale){
        ChaleDAOImp chaleDao = new ChaleDAOImp();
        return chaleDao.insert(chale);
    }
    public String alt(Chale chale){
        ChaleDAOImp chaleDao = new ChaleDAOImp();
        return chaleDao.alt(chale);
    }
    public String delete(Chale chale){
        ChaleDAOImp chaleDao = new ChaleDAOImp();
        return chaleDao.delete(chale);
    }
    public List<Chale> listAll(){
        ChaleDAOImp chaleDao = new ChaleDAOImp();
        return chaleDao.listAll();
    }
    public List<Chale> search(Chale chale){
        ChaleDAOImp chaleDao = new ChaleDAOImp();
        return chaleDao.search(chale);
    }
    public Chale search(String cod) {
    	ChaleDAOImp chaleDao = new ChaleDAOImp();
        return chaleDao.search(cod);
    }
}