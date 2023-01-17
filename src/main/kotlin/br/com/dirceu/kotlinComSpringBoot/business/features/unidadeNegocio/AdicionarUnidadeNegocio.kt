package br.com.dirceu.kotlinComSpringBoot.business.features.unidadeNegocio

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocioRepository
import br.com.dirceu.kotlinComSpringBoot.commons.FunciolidadeExecutavel
import br.com.dirceu.kotlinComSpringBoot.commons.exceptions.BusinessException
import org.springframework.stereotype.Service

@Service
class AdicionarUnidadeNegocio (private val unidadeNegocioRepository: UnidadeNegocioRepository
) : FunciolidadeExecutavel<UnidadeNegocio, Unit> {

    override fun executar(request: UnidadeNegocio): Unit{

        //verifica se ja existe uma unidade de negócio com o mesmo nome na vigência
        val lista = unidadeNegocioRepository.findByNome(request.nome)
        if(lista.isNotEmpty()){
            for (unidade in lista){
                if(unidade.emVigenciaNoPeriodo(request.inicioVigencia, request.fimVigencia)){
                    throw BusinessException("Não é possível cadastrar a unidade negócio, pois já existe uma unidade com o mesmo nome conflitando o periodo de vigência")
                }
            }
        }

        unidadeNegocioRepository.salvar(request)
        return
    }

}