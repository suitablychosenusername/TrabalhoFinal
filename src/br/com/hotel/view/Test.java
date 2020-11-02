package br.com.hotel.view;

import java.sql.Connection;

import br.com.hotel.controller.ChaleController;
import br.com.hotel.controller.ClienteController;
import br.com.hotel.controller.HospedagemController;
import br.com.hotel.model.Chale;
import br.com.hotel.model.Cliente;
import br.com.hotel.model.Hospedagem;
import br.com.hotel.persistence.Conexao;
import java.util.List;

public class Test{
    public static void main(String[] args) {
        Connection con = Conexao.getConexao();
        if(con != null){
            System.out.println("OK");
            Conexao.close(con);
        }

        /* OBJETOS */

        Chale chale = new Chale();
        ChaleController control = new ChaleController();

        Cliente cliente = new Cliente();
        ClienteController controlCliente = new ClienteController();

        Hospedagem hospedagem = new Hospedagem();
        HospedagemController controlHospedagem = new HospedagemController();
        
        Double total;

        /* INSERT */

        // chale.setCodChale("001");
        // chale.setLocalizacao("Finlandia");
        // chale.setCapacidade(2);
        // chale.setValorAltaEstacao(1200.00);
        // chale.setValorBaixaEstacao(800.00);
        // System.out.println(control.insert(chale));

        // cliente.setCodCliente(1);
        // cliente.setNomeCliente("Juliano Santos Almeida");
        // cliente.setRgCliente("25789461SSP/SP");
        // cliente.setEnderecoCliente("Av. Tamoaí Numero 412");
        // cliente.setBairroCliente("Tudojunto");
        // cliente.setCidadeCliente("Townsville");
        // cliente.setEstadoCliente("SP");
        // cliente.setCepCliente("71000-879");
        // cliente.setNascimentoCliente("1970/01/01");
        // System.out.println(controlCliente.insert(cliente));

        // chale = control.searchCod("001");
        // hospedagem.setCodHospedagem(1);
        // hospedagem.setCodChale(chale.getCodChale());
        // hospedagem.setEstado("SP");
        // hospedagem.setDataInicio("2020-11-25");
        // hospedagem.setDataFim("2020-12-25");
        // hospedagem.setQtdPessoas(2);
        // hospedagem.setDesconto(20);
        // total = chale.getValorAltaEstacao();
        // total = total * (1 - (hospedagem.getDesconto() / 100.0));
        // hospedagem.setValorFinal(total);
        // System.out.println(controlHospedagem.insert(hospedagem));

        /* ALT */

        // chale.setCodChale("001");
        // chale.setLocalizacao("Uruguai yes");
        // chale.setCapacidade(5);
        // chale.setValorAltaEstacao(1300.00);
        // chale.setValorBaixaEstacao(750.00);
        // System.out.println(control.alt(chale));

        // cliente.setCodCliente(1);
        // cliente.setNomeCliente("Judite Santos Almeida");
        // cliente.setRgCliente("7891SSP/PE");
        // cliente.setEnderecoCliente("Av. Podecre Numero 18");
        // cliente.setBairroCliente("Oi");
        // cliente.setCidadeCliente("Peoplesville");
        // cliente.setEstadoCliente("AM");
        // cliente.setCepCliente("71051-879");
        // cliente.setNascimentoCliente("1980/12/31");
        // System.out.println(controlCliente.alt(cliente));

        // chale = control.searchCod("001");
        // hospedagem.setCodHospedagem(1);
        // hospedagem.setCodChale(chale.getCodChale());
        // hospedagem.setEstado("RJ");
        // hospedagem.setDataInicio("2020-12-25");
        // hospedagem.setDataFim("2021-01-25");
        // hospedagem.setQtdPessoas(1);
        // hospedagem.setDesconto(15);
        // total = chale.getValorAltaEstacao();
        // total = total * (1 - (hospedagem.getDesconto() / 100.0));
        // hospedagem.setValorFinal(total);
        // System.out.println(controlHospedagem.alt(hospedagem));

        /* DELETE */

        // chale.setCodChale("001");
        // System.out.println(control.delete(chale));

        // cliente.setCodCliente(1);
        // System.out.println(controlCliente.delete(cliente));

        // hospedagem.setCodHospedagem(1);
        // System.out.println(controlHospedagem.delete(hospedagem));

        /* LISTALL */

        // List<Chale> lista = control.listAll();
        // if(lista != null){
        //     for (Chale i : lista){
        //         System.out.print("Codigo: " + i.getCodChale() + " | ");
        //         System.out.print("Localização: " + i.getLocalizacao() + " | ");
        //         System.out.print("Capacidade: " + i.getCapacidade() + " | ");
        //         System.out.print("Valor Alta Estação: " + i.getValorAltaEstacao() + " | ");
        //         System.out.println("Valor Baixa Estação: " + i.getValorBaixaEstacao());
        //     }
        // }

        // List<Cliente> listaCliente = controlCliente.listAll();
        // if(listaCliente != null){
        //     for(Cliente x : listaCliente){
        //         System.out.print("Codigo: " + x.getCodCliente() + " | ");
        //         System.out.print("Nome: " + x.getNomeCliente() + " | ");
        //         System.out.println("RG: " + x.getRgCliente());
        //         System.out.println("Nascimento: " + x.getNascimentoCliente());
        //         System.out.println("Endereço: " + x.getEnderecoCliente());
        //         System.out.print("Bairro: " + x.getBairroCliente() + " | ");
        //         System.out.print("Cidade: " + x.getCidadeCliente() + " | ");
        //         System.out.print("Estado: " + x.getEstadoCliente() + " | ");
        //         System.out.println("CEP: " + x.getCepCliente());
        //     }
        // }
        
        List<Hospedagem> listaHosp = controlHospedagem.listAll();
        if(listaHosp != null){
            for(Hospedagem y : listaHosp){
                System.out.print("Codigo: " + y.getCodHospedagem() + " | ");
                System.out.print("Codigo Chale: " + y.getCodChale() + " | ");
                System.out.println("Estado: " + y.getEstado());
                System.out.print("Data de Inicio: " + y.getDataInicio() + " | ");
                System.out.print("Data de Fim: " + y.getDataFim() + " | ");
                System.out.println("Qtd pessoas: " + y.getQtdPessoas());
                System.out.print("Desconto: " + y.getDesconto() + "% | ");
                System.out.println("Valor Final: " + y.getValorFinal());
            }
        }
        /* SEARCHCOD */

        chale = control.searchCod("001");
        if(chale != null){
            System.out.print("Codigo: " + chale.getCodChale() + " | ");
            System.out.print("Localização: " + chale.getLocalizacao() + " | ");
            System.out.print("Capacidade: " + chale.getCapacidade() + " | ");
            System.out.print("Valor Alta Estação: " + chale.getValorAltaEstacao() + " | ");
            System.out.println("Valor Baixa Estação: " + chale.getValorBaixaEstacao());
        }

        cliente = controlCliente.searchCod(1);
        if(cliente != null){
            System.out.print("Codigo: " + cliente.getCodCliente() + " | ");
            System.out.print("Nome: " + cliente.getNomeCliente() + " | ");
            System.out.println("RG: " + cliente.getRgCliente());
            System.out.println("Nascimento: " + cliente.getNascimentoCliente());
            System.out.println("Endereço: " + cliente.getEnderecoCliente());
            System.out.print("Bairro: " + cliente.getBairroCliente() + " | ");
            System.out.print("Cidade: " + cliente.getCidadeCliente() + " | ");
            System.out.print("Estado: " + cliente.getEstadoCliente() + " | ");
            System.out.println("CEP: " + cliente.getCepCliente());
        }

        hospedagem = controlHospedagem.searchCod(1);
        if(hospedagem != null){
            System.out.print("Codigo: " + hospedagem.getCodHospedagem() + " | ");
            System.out.print("Codigo Chale: " + hospedagem.getCodChale() + " | ");
            System.out.println("Estado: " + hospedagem.getEstado());
            System.out.print("Data de Inicio: " + hospedagem.getDataInicio() + " | ");
            System.out.print("Data de Fim: " + hospedagem.getDataFim() + " | ");
            System.out.println("Qtd pessoas: " + hospedagem.getQtdPessoas());
            System.out.print("Desconto: " + hospedagem.getDesconto() + "% | ");
            System.out.println("Valor Final: " + hospedagem.getValorFinal());
        }
    }
}