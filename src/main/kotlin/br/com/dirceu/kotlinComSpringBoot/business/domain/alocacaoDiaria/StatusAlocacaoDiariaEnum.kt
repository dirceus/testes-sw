package br.com.dirceu.kotlinComSpringBoot.business.domain.alocacaoDiaria

enum class StatusAlocacaoDiariaEnum(val codigo: String, val descricao: String) {
    NAO_PROCESSADA("N","Não processada"),
    PROCESSADA_SUCESSO("S","Processada com erro"),
    PROCESSADA_FALHA("F","Processada com falha")


}
