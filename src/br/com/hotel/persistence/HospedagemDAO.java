package br.com.hotel.persistence;

import java.util.List;
import br.com.hotel.model.Hospedagem;

public interface HospedagemDAO{
    public String insert(Hospedagem hospedagem);
    public String alt(Hospedagem hospedagem);
    public String delete(Hospedagem hospedagem);
    public List<Hospedagem> listAll();
    public Hospedagem searchCod(Integer cod);
}