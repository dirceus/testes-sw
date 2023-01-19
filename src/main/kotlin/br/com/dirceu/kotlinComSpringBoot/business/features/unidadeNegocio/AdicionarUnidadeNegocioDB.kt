package br.com.dirceu.kotlinComSpringBoot.business.features.unidadeNegocio

import br.com.dirceu.kotlinComSpringBoot.business.commons.FunciolidadeExecutavel
import br.com.dirceu.kotlinComSpringBoot.business.commons.exceptions.BusinessException
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AdicionarUnidadeNegocioDB (private val unidadeNegocioRepository: UnidadeNegocioRepository
) : FunciolidadeExecutavel<UnidadeNegocio, Unit> {

    override fun executar(request: UnidadeNegocio): Unit{

        val dataFim = request.fimVigencia ?: Date(2382, 1, 1 )

        //verifica se ja existe uma unidade de negócio com o mesmo nome na vigência
        val lista = unidadeNegocioRepository.findVigentesNoPeriodo(request.inicioVigencia, dataFim)

        val unidadeEncontrada = lista.find { it.nome == request.nome }
        if(unidadeEncontrada != null){
            throw BusinessException("Não é possível cadastrar a unidade negócio, pois já existe uma unidade com o mesmo nome conflitando o periodo de vigência")
         }


        unidadeNegocioRepository.salvar(request)
        return
    }

}