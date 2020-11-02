package br.com.hotel.persistence;

import java.util.List;
import br.com.hotel.model.Cliente;

public interface ClienteDAO{
    public String insert(Cliente cliente);
    public String alt(Cliente cliente);
    public String delete(Cliente cliente);
    public List<Cliente> listAll();
    public Cliente searchCod(Integer cod);
}