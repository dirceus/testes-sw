package br.com.demo.business.features.poco

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.poco.Poco
import br.com.demo.business.domain.poco.PocoDTO
import br.com.demo.business.domain.poco.PocoRepository
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository

class AdicionarPoco (private val unidadeNegocioRepository: UnidadeNegocioRepository,
                     private val pocoRepository: PocoRepository
) : FunciolidadeExecutavel<PocoDTO, Unit> {
    override fun executar(request: PocoDTO) {
        //verifica se a instalacao é valida
        val unidadeNegocio = unidadeNegocioRepository.obterPorCodigo(request.codigoUnidadeNegocio)
            ?: throw BusinessException("Código da Unidade de Negócio é inválido")

        val poco = Poco(request.nome,request.descricao,unidadeNegocio,request.dataCriacao)
        pocoRepository.salvarPoco(poco)
    }

}