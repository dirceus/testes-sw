package br.com.demo.business.features.unidadeNegocio

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocio
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.springframework.stereotype.Service

@Service
class EditarUnidadeNegocio (private val unidadeNegocioRepository: UnidadeNegocioRepository
) : FunciolidadeExecutavel<UnidadeNegocio, Unit> {

    override fun executar(request: UnidadeNegocio): Unit {

        //verifica se codigo da un é valido
        if (request.codigo == null){
            throw BusinessException("Não é possível editar uma unidade de negócio sem código")
        }
        val unPersistida = unidadeNegocioRepository.obterPorCodigo(request.codigo!!)
            ?: throw BusinessException("Unidade de Negócio possui um código inválido")

        /* verifca se o nome é valido */
        if(unPersistida.nome != request.nome){
            if(unidadeNegocioRepository.obterPorNome(request.nome) != null){
                throw BusinessException("Já existe uma UN o nome informado")
            }
        }
        unPersistida.nome = request.nome
        unPersistida.descricao = request.descricao
        unPersistida.ativa = request.ativa

        unidadeNegocioRepository.salvar(unPersistida)
        return
    }

}