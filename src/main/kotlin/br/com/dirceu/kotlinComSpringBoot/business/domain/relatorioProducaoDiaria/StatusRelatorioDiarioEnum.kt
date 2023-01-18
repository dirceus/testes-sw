package br.com.dirceu.kotlinComSpringBoot.business.domain.relatorioProducaoDiaria

enum class StatusRelatorioDiarioEnum(val codigo: String, val descricao: String) {
    NAO_PROCESSADA("N","Não processada"),
    PROCESSADA_SUCESSO("S","Processada com erro"),
    PROCESSADA_FALHA("F","Processada com falha")


}
