package br.com.hotel.persistence;

import java.util.List;
import br.com.hotel.model.Hospedagem;
import br.com.hotel.model.Chale;

public interface HospedagemDAO{
    public String insert(Hospedagem hospedagem);
    public String alt(Hospedagem hospedagem);
    public String delete(Hospedagem hospedagem);
    public String delete(Chale chale);
    public List<Hospedagem> listAll();
    public List<Hospedagem> search(Hospedagem hospedagem);
}