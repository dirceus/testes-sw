package br.com.dirceu.kotlinComSpringBoot.business.features.unidadeNegocio

import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.dirceu.kotlinComSpringBoot.business.domain.unidadeNegocio.UnidadeNegocioRepository
import br.com.dirceu.kotlinComSpringBoot.business.commons.FunciolidadeExecutavel
import br.com.dirceu.kotlinComSpringBoot.business.commons.exceptions.BusinessException
import org.springframework.stereotype.Service

@Service
class EditarUnidadeNegocio (private val unidadeNegocioRepository: UnidadeNegocioRepository
) : FunciolidadeExecutavel<UnidadeNegocio, Unit> {

    override fun executar(request: UnidadeNegocio): Unit{

        //verifica se codigo da un é valido
        request.codigo?: throw BusinessException("Não é possível editar uma unidade de negócio sem código")
        unidadeNegocioRepository.findByCodigo(request.codigo)
            ?: throw BusinessException("Unidade de Negócio possui um código inválido")

       //verifica se ja existe uma unidade de negócio com o mesmo nome na vigência
        val lista = unidadeNegocioRepository.findByNome(request.nome)
        lista.filter { it.codigo == request.codigo } //remove da verificação a un que será atualizada
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