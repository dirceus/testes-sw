package br.com.dirceu.kotlinComSpringBoot.commons

data class ListaPaginada<T>(
    val total: Long,
    val tamanho: Int,
    val pagina: Int,
    var itens: Collection<T>
)