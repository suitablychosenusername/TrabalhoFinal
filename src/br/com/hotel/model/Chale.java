package br.com.hotel.model;

public class Chale{
    private String codChale;
    private String localizacao;
    private Integer capacidade;
    private Double valorAltaEstacao;
    private Double valorBaixaEstacao;
    // Constructor
    public Chale(){}

    // Setters
    public void setCodChale(String codChale) {
        this.codChale = codChale;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
    public void setValorAltaEstacao(Double valorAltaEstacao) {
        this.valorAltaEstacao = valorAltaEstacao;
    }
    public void setValorBaixaEstacao(Double valorBaixaEstacao) {
        this.valorBaixaEstacao = valorBaixaEstacao;
    }
    // Getters
    public String getCodChale(){
        return codChale;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public Double getValorAltaEstacao() {
        return valorAltaEstacao;
    }
    public Double getValorBaixaEstacao() {
        return valorBaixaEstacao;
    }
    public Integer getCapacidade() {
        return capacidade;
    }
}