# testes-sw
Projeto para exercitar a criação de testes de unidade e de integração

#### Contexto do Projeto

Empresa petrolífera fictícia que divide suas operações por unidades de negócio, cada unidade possui um conjunto de instalações de produção, essas instalações são conectadas a um ou mais poços de onde são extraído o petróleo.

A medição da produção é realizada na instalação de produção, nelas existe um único registro de medição que informa o quanto de óleo chegaram de todos os poços conectados a instalação nas últimas 24 horas, essa informação é registrada em um boletim diário de medição.

Além da produção da instalação que está no boletim, a empresa precisa de relatórios diários da produção para cada poço, para calcular a produção dos poços, a empresa verifica quantos poços conectados a instalação estavam produzinho na data do relatório e divide igualmente a produção da instalação por esses poços.

#### Pedido do Cliente

Construir um sistema para registrar a produção e que gere um relatorio diário com o que cada poço produziu.

#### Dominio modelado pelo Desenvolvedor em conjunto com o Cliente

![image](https://user-images.githubusercontent.com/67016005/215272058-b306cc1a-c708-4234-9245-b10f4b9d8e07.png)

##### Casos de Usos (Features)

* Cadastrar UN
* Cadastrar Tanque
* Cadastrar Poça
* Vincular Poça a Tanque
* Informar Produção do Tanque por Dia
* Gerar Relatório da Produç
