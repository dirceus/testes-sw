package br.com.demo.business.features.poco

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.poco.NovoStatusDTO
import br.com.demo.business.domain.poco.PocoRepository
import br.com.demo.business.domain.poco.StatusPocoEnum
import org.springframework.stereotype.Service

@Service
class AlterarStatusPoco(private val pocoRepository: PocoRepository) : FunciolidadeExecutavel<NovoStatusDTO, Unit> {
    override fun executar(request: NovoStatusDTO) {

        var poco = pocoRepository.obter(request.codigoPoco) ?: throw BusinessException("Código do Poço inválido")
        poco.alterarStatus(StatusPocoEnum.fromCodigo(request.codigoStatus),request.dataInicio)
        pocoRepository.salvar(poco)

    }
}