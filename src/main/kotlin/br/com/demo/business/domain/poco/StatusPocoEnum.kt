package br.com.demo.business.domain.poco

enum class StatusPocoEnum(val codigo: String, val descricao: String) {

    NAO_OPERANDO("NO", "Não Operando"),
    OPERANDO("OP", "Em operação"),
    MANUTENCAO("MA","Em manutenção")

}
