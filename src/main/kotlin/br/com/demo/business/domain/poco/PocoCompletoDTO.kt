package br.com.demo.business.domain.poco

import java.time.LocalDate

data class PocoCompletoDTO(
    val codigo: Int,
    val nome: String,
    var descricao: String,
    val dataCriacao: LocalDate,
    var status: StatusPocoEnum,
    var historicoStatus : MutableList<HistoricoStatusPoco>
)