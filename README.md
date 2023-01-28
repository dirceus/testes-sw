# testes-sw
Projeto para exercitar a criação de testes de unidade e de integração

#### Contexto do Projeto

Empresa petrolífera fictícia que divide suas operações por unidades de negócio, cada unidade possui um conjunto de instalações de produção, essas instalações são conectadas a um ou mais poços de onde são extraído o petróleo.

A medição da produção é realizada na instalação de produção, nelas existe um único registro de medição que informa o quanto de óleo chegaram de todos os poços conectados a instalação nas últimas 24 horas, essa informação é registrada em um boletim diário de medição.

Além da produção da instalação que está no boletim, a empresa precisa de relatórios diários da produção para cada poço, para calcular a produção dos poços, a empresa verifica quantos poços conectados a instalação estavam produzinho na data do relatório e divide igualmente a produção da instalação por esses poços.

![image](https://user-images.githubusercontent.com/67016005/215276093-719e5de6-363a-458a-9e92-f703dd98b772.png)


#### Pedido do Cliente

Construir um sistema para registrar a produção diária das plataformas e que gere um relatorio diário com o que cada poço produziu.

#### Dominio modelado pelo Desenvolvedor em conjunto com o Cliente

![image](https://user-images.githubusercontent.com/67016005/215274390-8433fbc8-1d40-4a7c-ab6a-7440cdd5f059.png)

##### Casos de Usos (Features)

![image](https://user-images.githubusercontent.com/67016005/215274116-0987ece7-0f87-4028-bfa8-54954c960376.png)

