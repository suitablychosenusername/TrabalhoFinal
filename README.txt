Antes de compilar:

1. Feito com o MySQL.
2. Driver se encontra na pasta lib.
3. Inserir username e senha nas linhas 10 e 11, respectivamente, no arquivo: br.com.hotel.persistence.Conexao.java


Durante a Execu��o:

	As abas no topo trocam entre as diferentes tabelas do bando de dados.
	Utilize os campos de inser��o e os bot�es para interagir com a respectiva tabela.

Sobre os bot�es:

	INSERIR:
		Insere elemento na tabela.
	PESQUISAR:
		Pesquisa elemento na tabela.
	LISTAR TODOS:
		Lista todos os elementos da tabela.
	LIMPAR:
		Limpa a �rea da tabela.
	ALTERAR:
		Altera um elemento da tabela.
	DELETAR:
		Deleta um elemento da tabela.

How-to:

	* Para INSERIR:
		1. Insira os dados nos respectivos campos de inser�ao;
		2. Clique em Inserir.

	* Para ALTERAR:
		1. Clique em Listar todos;
		2. Selecione a linha que deseja alterar;
		3. Insira os dados que deseja alterar nos respectivos campos de inser��o;
		4. Clique em Alterar.

	* Para DELETAR:
		1. Clique em Listar todos;
		2. Selecione a linha que deseja excluir;
		3. Clique em Deletar;

	* Para PESQUISAR:
		1. Insira os dados pelos quais deseja pesquisar;
		2. Clique em PESQUISAR.

		OBS: Alguns campos utilizam o comando LIKE do MySQL para a busca, possibilitando a busca
		     atrav�s de parte do elemento com os simbolos _ e %. Estes campos S�o:
			Em Clientes:
				Nome,
				Endere�o,
				Bairro,
				Cidade,
				Estado,
				Nascimento.

			Em Hospedagens:
				CodChale,
				Estado,
				Data Inicio,
				Data Fim

			Em Chal�s:
				CodChale,
				Localiza��o