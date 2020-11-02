package br.com.hotel.model;

public class Cliente{
    private Integer codCliente;
    private String nomeCliente;
    private String rgCliente;
    private String enderecoCliente;
    private String bairroCliente;
    private String cidadeCliente;
    private String estadoCliente;
    private String cepCliente;
    private String nascimentoCliente;

    public Cliente(){

    }

    // Setters
    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }
    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }
    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }
    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }
    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }
    public void setNascimentoCliente(String nascimentoCliente) {
        this.nascimentoCliente = nascimentoCliente;
    }
    
    // Getters
    public Integer getCodCliente() {
        return codCliente;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public String getRgCliente() {
        return rgCliente;
    }
    public String getEnderecoCliente() {
        return enderecoCliente;
    }
    public String getBairroCliente() {
        return bairroCliente;
    }
    public String getCidadeCliente() {
        return cidadeCliente;
    }
    public String getEstadoCliente() {
        return estadoCliente;
    }
    public String getCepCliente() {
        return cepCliente;
    }
    public String getNascimentoCliente() {
        return nascimentoCliente;
    }
}