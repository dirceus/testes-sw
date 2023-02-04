package br.com.demo.business.features.poco

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.poco.Poco
import br.com.demo.business.domain.poco.PocoRepository
import org.springframework.stereotype.Service

@Service
class ObterPoco(private val pocoRepository: PocoRepository)
    : FunciolidadeExecutavel<Int, Poco> {
    override fun executar(request: Int): Poco {
        return pocoRepository.obter(request) ?: throw BusinessException("Código do Poço inválido")
    }
}