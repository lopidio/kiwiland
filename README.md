# kiwiland

# Para compilar:
	$mvn compile

# Para executar, por meio da linha de comando, digite:
	$ mvn exec:java # AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
	ou
	$ echo "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7" | mvn exec:java


# Descrições dos pacotes:
	algorithm: agrupa o conjunto de algoritmos propostos pelo problema. Todos esses algoritmos implementam a interface RailRoadAlgorithm e produzem um objeto da classe RailRoadAlgorithmResult, classes essas que também pertencem ao mesmo pacote. A solução foi assim arquitetada para que caso seja necessário adicionar um novo algoritmo (por exemplo: o caminho mais longo cuja distância total seja menor do que 50) basta criar uma nova implementação da interface. Um detalhe vale ser destacado, os algoritmos de melhor caminho (4 dos 5 implementados) são bastante semelhante entre si, portanto, foi criada uma superclasse comum que implementa RailRoadAlgorithm, e os algoritmos, por sua vez, extendem essa classe.
	algorithmresultdisplay: contém as classes cuja responsabilidade é traduzir o resultado do algoritmo. Assim como o pacote anterior, possui uma interface que dita como o contrato com os clientes. Se for necessário criar uma nova forma de revelar o resultado de um algoritmo (por exemplo: responder se o caminho é cíclico), essa interface deve ser implementada.
	builder: classes que constroem o grafo. Se for preciso criar um grafo a partir da internet, ou de um banco de dados, ou de um arquivo, basta implementar a interface RailRoadBuilder.
	railroad: classes que definem o grafo. Nesse pacote em especial, foi reforçado o aspecto ubíquo da linguagem. Esse pacote possui quatro classes: Town (vértice), Track (aresta), RailRoad (grafo) e Path (conjunto de arestas "sequenciais", ou seja, a origem da próxima aresta deve coincidir com o destino da aresta atual)
	runner: coleção de classes cujo intuito é facilitar a execução e a solução dos algoritmos. A única classe capaz de ser instanciada de fora do pacote é a classe AlgorithmRunner. As demais classes apenas fornecem uma DSL que aprimora a legibilidade do código.


# Fluxo de execução:
	1 - O grafo é criado através de um Builder, o Builder recebe um InputStreamReader como argumento. Essa solução permitiu acelerar o desenvolvimento uma vez é passar uma cadeia de caracteres e evitar que fossem digitado os inputs a cada execução do programa.
	2 - Na instância da classe Runner, são adicionados 
