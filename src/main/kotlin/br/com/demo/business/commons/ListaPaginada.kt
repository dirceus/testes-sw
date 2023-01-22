package br.com.demo.business.commons

data class ListaPaginada<T>(
    val total: Long,
    val tamanho: Int,
    val pagina: Int,
    var itens: Collection<T>
)