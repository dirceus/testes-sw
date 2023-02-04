package br.com.demo.business.domain.poco

import java.time.LocalDate

data class PocoDTO (
    val codigo: Int?,
    val nome: String,
    val codigoUnidadeNegocio: Int,
    var descricao: String?,
    var dataCriacao: LocalDate,
    var status: StatusPocoEnum?,
    var nomeUnidadeNegocio: String?,
    var codInstalacao: Int?,
    var nomeInstalcao: String?
) {
    constructor(poco: Poco) :
            this(poco.codigo,
                 poco.nome,
                 poco.unidadeNegocio.codigo!!,
                 poco.descricao,
                 poco.dataCriacao,
                 poco.status,
                 poco.unidadeNegocio.nome,
                 poco.instalacaoPoco?.codigo,
                 poco.instalacaoPoco?.nome)
}