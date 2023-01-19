# testes-sw
Projeto para exercitar a criação de testes de unidade e de integração

#### Contexto do Projeto

Empresa petrolífera fictícia que extrai petróleos de poças e armazena o petróleo extraído em tanques.
A medição da produção é aferida nos tanques, no entanto, cada poça tem um proprietário distinto e a empresa precisa identificar o quanto foi produzido por cada por poça para pagar os royalties aos proprietários.
Todo dia a empresa gera um relatório com a produção de cada poça.



#### Modus Operandi da Empresa

O petroleo jorra da terra formando poças, através de bombas esse petroleo é armazenado nos tanques, os tanques possuem uma fita metricas marcando a quantidade de litros, todo dia as 14hs um operador registra em uma cardeneta o volume do tanque e rateio o volume igualmente as poças vinculadas a ele.

![image](https://user-images.githubusercontent.com/67016005/213329488-e0e43b04-8d9c-4d76-9f7d-1e05c7448c91.png)

#### Pedido do Cliente

Construir um sistema para registrar a produção e que gere um relatorio diário com o que cada poço produziu.

#### Dominio modelado pelo Desenvolvedor em conjunto com o Cliente

![image](https://user-images.githubusercontent.com/67016005/213332715-e990b7e1-0fd5-4062-a1ab-6ef9bfa3e035.png)

##### Casos de Usos (Features)

* Cadastrar UN
* Cadastrar Tanque
* Cadastrar Poça
* Vincular Poça a Tanque
* Informar Produção do Tanque por Dia
* Gerar Relatório da Produç
