package br.com.hotel.controller;

import java.util.List;

import br.com.hotel.model.Cliente;
import br.com.hotel.persistence.ClienteDAOImp;

public class ClienteController{
    public String insert(Cliente cliente){
        ClienteDAOImp clienteDao = new ClienteDAOImp();
        return clienteDao.insert(cliente);
    }
    public String alt(Cliente cliente){
        ClienteDAOImp clienteDao = new ClienteDAOImp();
        return clienteDao.alt(cliente);
    }
    public String delete(Cliente cliente){
        ClienteDAOImp clienteDao = new ClienteDAOImp();
        return clienteDao.delete(cliente);
    }
    public List<Cliente> listAll(){
        ClienteDAOImp clienteDao = new ClienteDAOImp();
        return clienteDao.listAll();
    }
    public List<Cliente> search(Cliente cliente){
        ClienteDAOImp clienteDao = new ClienteDAOImp();
        return clienteDao.search(cliente);
    }
}