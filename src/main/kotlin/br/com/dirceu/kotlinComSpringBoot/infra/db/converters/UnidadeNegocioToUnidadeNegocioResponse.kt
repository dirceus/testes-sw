package br.com.dirceu.kotlinComSpringBoot.infra.db.converters

import br.com.dirceu.kotlinComSpringBoot.commons.dto.unidadeNegocio.UnidadeNegocioDTO
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import org.springframework.core.convert.converter.Converter

class UnidadeNegocioConverter : Converter<UnidadeNegocio, UnidadeNegocioDTO>{

    override fun convert(source: UnidadeNegocio): UnidadeNegocioDTO {
        return UnidadeNegocioDTO(source)
    }


}