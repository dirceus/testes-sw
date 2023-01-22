package br.com.demo.business.domain.poco

data class PocoDTO (
    val codigo: Int,
    val nome: String,
    var descricao: String,
    var status: StatusPocoEnum,
)