package br.com.hotel.persistence;

import java.util.List;
import br.com.hotel.model.Chale;

public interface ChaleDAO{
    public String insert(Chale chale);
    public String alt(Chale chale);
    public String delete(Chale chale);
    public List<Chale> listAll();
    public Chale searchCod(String cod);
}