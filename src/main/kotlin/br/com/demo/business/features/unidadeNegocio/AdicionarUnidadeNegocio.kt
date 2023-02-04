package br.com.demo.business.features.unidadeNegocio

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.springframework.stereotype.Service

@Service
class AdicionarUnidadeNegocio (private val unidadeNegocioRepository: UnidadeNegocioRepository
) : FunciolidadeExecutavel<UnidadeNegocio, Unit> {

    override fun executar(request: UnidadeNegocio){

        //verifica se ja existe uma unidade de negócio com o mesmo nome na vigência
        val un = unidadeNegocioRepository.obterPorNome(request.nome)
        if(un != null){
            throw BusinessException("Já existe uma unidade com o nome informado")
        }
        unidadeNegocioRepository.salvar(request)
        return
    }

}