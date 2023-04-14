# Detalhamento

A empresa possui diversos departamentos. Para cada um de seus funcionários deseja-se saber o id,
nome e o departamento onde está alocado. Parte dos funcionários compõe a equipe de suporte.
Somente funcionários da equipe de suporte podem atender a chamados. Cada equipamento possui um
identificador, uma descrição, a data de aquisição e o setor da empresa onde está instalado. Qualquer
funcionário poderá abrir um novo chamado de suporte a um equipamento. Um chamado registra qual
funcionário o abriu, qual o equipamento que necessita de suporte, a data da solicitação e uma descrição
(o texto da solicitação). Além disso, cada chamado possui um status (aberto -> em andamento ->
concluído). Quando um funcionário da equipe de suporte atende um chamado, o status muda para “em
andamento” e ele é associado ao chamado. Posteriormente, quando o chamado é concluído, o status
muda para “concluído” e o funcionário digita o que foi feito para resolver (texto de resolução).


# Funcionalidades desejadas

 - [ ] O sistema deverá permitir escolher de uma lista qual o funcionário que está usando o sistema
naquele momento (facilitando para não precisar implementar mecanismos de login).

 - [ ] O sistema deverá permitir abrir um novo chamado. Cada chamado deve conter os dados descritos
na seção de detalhamento acima. O status de um chamado flui apenas em uma direção: aberto ->
em andamento -> concluído.

 - [ ] O sistema deverá permitir que um funcionário da equipe de suporte atualize o status de um
chamado, mudando-o para “em andamento” ou para “concluído”.

 - [ ] O sistema deverá permitir mover um equipamento de um setor para outro. Somente funcionários da
equipe de suporte poderão mover equipamentos.

 - [ ] O sistema deverá permitir pesquisar equipamentos pela descrição (Ex. pesquisar por “impressora”).

 - [ ] O sistema deverá permitir listar todos os chamados de um determinado equipamento. A listagem
deverá ocorrer da mais antiga à mais recente. Todos os detalhes dos chamados deverão ser exibidos.

 - [ ] O sistema deverá permitir localizar chamados por uma palavra-chave. A busca deverá ocorrer sobre
os campos de nome do funcionário, descrição do equipamento, nome do setor, texto da solicitação,
texto da resolução.

 - [ ] O sistema deverá permitir ao usuário visualizar um painel com os seguintes dados: (a) total de
chamados registrados; (b) nro e percentual de chamados atualmente no status de “aberto”; (c) idem
para status de “em andamento”; (d) idem para o status de “concluído”; (e) número médio de
chamados concluídos por dia.

 - [ ] Duas funcionalidades a mais, à escolha do grupo.
