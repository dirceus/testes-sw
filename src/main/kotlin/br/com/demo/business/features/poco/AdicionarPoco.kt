package br.com.demo.business.features.poco

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.poco.Poco
import br.com.demo.business.domain.poco.PocoDTO
import br.com.demo.business.domain.poco.PocoRepository
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository
import org.springframework.stereotype.Service

@Service
class AdicionarPoco (
    private val pocoRepository: PocoRepository,
    private val unidadeNegocioRepository: UnidadeNegocioRepository
) : FunciolidadeExecutavel<PocoDTO, Unit> {

    override fun executar(request: PocoDTO){

        val un = unidadeNegocioRepository.obterPorCodigo(request.codigoUnidadeNegocio)
            ?: throw BusinessException("Código da Unidade de negócio inválido")

        val poco = Poco(request.nome,request.descricao,un,request.dataCriacao)

        pocoRepository.salvar(poco)
        return
    }

}