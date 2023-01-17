package br.com.dirceu.kotlinComSpringBoot.infra.db.repositorios

import br.com.dirceu.kotlinComSpringBoot.infra.db.entities.UnidadeNegocioEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface UnidadeNegocioJpaRepository: JpaRepository<UnidadeNegocioEntity, Int>{

    @Query("from UnidadeNegocioEntity un where un.nome like %:nome% and un.descricao like %:descricao%")
    fun findByFiltro(@Param("nome") nome: String, @Param("descricao") descricao:String, pageable : Pageable) : Page<UnidadeNegocioEntity>

    @Query("from UnidadeNegocioEntity un where un.nome = :nome")
    fun findByNome(@Param("nome") nome: String) : List<UnidadeNegocioEntity>

}

