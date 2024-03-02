# TODO-List Application

Uma aplicação para você organizar suas tarefas

## Como utilizar

Ao iniciar o programa, você terá as seguinte opções

> 0. Para finalizar o programa
				1. Criar uma nova tarefa
				2. Remover uma tarefa
				3. Listar todas as tarefas
				4. Filtrar tarefas
				
### Criar uma nova tarefa
Para criar uma nova tarefa basta entrar com os valores que serão pedidos

- Nome da tarefa: Entre com um nome **único** para sua tarefa. O Nome será utilizado para identificar as tarefas da sua lista

- Categoria: Identifique sua tarefa com uma categoria (p.e.: Trabalho, Mercado, Academia etc.).

-  Descrição: Faça uma breve descrição da tarefa.

	**Importante**: *Não utilize  "," nem "{ }"* 

- Prioridade: Utilize valores de 1 a 5 para priorizar suas tarefas. sendo **1** a de **maior** prioridade, e a **5** a de **menor** prioridade

- Status: Existem três status possíveis para suas tarefas:
	- TODO (A fazer)
	- DOING (Em andamento)
	- DONE (Feito)

- Data limite para finalizar a tarefa (opcional): Adicione um prazo para finalizar sua tarefa. O formato da data deverá ser "dia-mês-ano", utilizando apenas números. Por exemplo:

	> 05-06-2024

	Caso não queira atribuir um prazo, basta deixar o campo em branco e pressionar Enter.


### Remover uma tarefa

Para remover uma tarefa basta informar o nome dela. Qualquer erro no nome passado vai resultar na não remoção, ou até mesmo a remoção de uma tarefa diferente. Então confirme o nome antes de fazer a remoção.


### Listar tarefas

Aqui você pode listar todas as tarefas ordenadas por três diferentes opções: 

> 1. Ordenada por Categoria
			2. Ordenada por Prioridade
			3. Ordenada por Status

### Filtrar tarefas
Utilize um dos quatro filtros para visualizar tarefas específicas. As opções de filtro são: 

> 1. Categoria
			2. Prioridade
			3. Status
			4. Data 

Filtrar por **Categoria, Status ou Prioridade**: basta informar o valor desejado referente a opção selecionada.

Filtrar por **Data**: 
 o sistema irá pedir para informar dois valores, Data início e Data fim. Em seguida, serão retornadas as tarefas com datas iguais e as que estejam entre as datas informadas. Caso queira filtrar por apenas uma data, basta informar a mesma data duas vezes.


## Funcionalidades e Tecnologias utilizadas

### TarefaService

Classe que contém todas as funcionalidades para manipulação das tarefas

- Listar as tarefas
- Criar uma nova tarefa
- Ordenar as tarefas
- Filtrar tarefas
- Remover uma tarefa
- Funções auxiliares para funcionalidade dos recursos listados acima

Foram utilizadas classes da package *java.util*


### DTOs

- **TarefaDTO**: uma classe que espelha a entidade **Tarefa**, porém, com a diferença de variáveis serem todas do tipo String. Ela é responsável por receber diretamente o retorno das informações contidas no arquivo .csv .

- **TarefaMapper**: Uma classe com funções para converter um objeto **TarefaDTO** em um objeto **Tarefa** e vice-versa.



### MenuController

Classe responsável pelo frontend. É por ela que o usuário navega pelas opções da aplicação e entra com os dados necessários para ativar uma funcionalidade específica (criar, remover, listar etc.). Após receber os dados necessários, ela chama a função escolhida pelo usuário, passando todos os dados informados através de um objeto previamente instanciado do tipo **TarefaService**.

A única classe importada de um biblioteca de fora foi a *java.util.Scanner*  

### DateFormat

A classe DateFormat foi criada para facilitar a manipulação das variáveis do tipo data. 

Funções:

- **dateFormat(String date)**: função que trata uma String de data no formato "dia-mês-ano" utilizando a função *parse* da classe *SimpleDateFormat* do package *java.text*. 
A função retorna um objeto tipo *Date* da package *java.util*.

- **outPutToInputFormat(String date)**: Função criada para tratar as datas recuperadas do arquivo *.csv* . As datas são salvas como String no arquivo no padrão "dia_da_semana mês dia hora padrao_local ano". A função trata essa String e também retorna um tipo *Date*. 


### ToCSV

Classe com funcionalidade de leitura e gravação dos dados no arquivo CSV. Foram utilizadas  classes das packages *java.util* e *java.io* 

- **escapeSpecialCharacters()**: Uma função para tratar os dados que serão inseris no arquivo csv. Essa função utiliza *regex* para buscar e alterar caracteres específicos que poderiam causar uma alteração na estrutura dos dados ao serem salvos nesse tipo de arquivo.

