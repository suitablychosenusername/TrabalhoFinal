package br.com.hotel.model;

public class Hospedagem{
    private Integer codHospedagem;
    private String codChale;
    private String estado;
    private String dataInicio;
    private String dataFim;
    private Integer qtdPessoas;
    private Integer desconto;
    private Double valorFinal;

    public Hospedagem(){}

    // Setters
    public void setCodHospedagem(Integer codHospedagem) {
        this.codHospedagem = codHospedagem;
    }
    public void setCodChale(String codChale) {
        this.codChale = codChale;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    public void setQtdPessoas(Integer qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }
    public void setDesconto(Integer desconto) {
        this.desconto = desconto;
    }
    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }
    
    // Getters
    public Integer getCodHospedagem() {
        return codHospedagem;
    }
    public String getCodChale() {
        return codChale;
    }
    public String getEstado() {
        return estado;
    }
    public String getDataInicio() {
        return dataInicio;
    }
    public String getDataFim() {
        return dataFim;
    }
    public Integer getQtdPessoas() {
        return qtdPessoas;
    }
    public Integer getDesconto() {
        return desconto;
    }
    public Double getValorFinal() {
        return valorFinal;
    }
    
}