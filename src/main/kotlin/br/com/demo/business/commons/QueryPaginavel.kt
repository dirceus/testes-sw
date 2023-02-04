package br.com.demo.business.commons

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort


open class QueryPaginavel(
    open val pagina: Int,
    open val tamanho : Int,
    open val ordenacaoProp: String,
    open val ordenacaoAsc: Boolean
){

    fun toPageable() : Pageable {
        return if(ordenacaoAsc){
            PageRequest.of(pagina, tamanho, Sort.by(ordenacaoProp).ascending())
        }else{
            PageRequest.of(pagina, tamanho, Sort.by(ordenacaoProp).descending())
        }
    }
}

