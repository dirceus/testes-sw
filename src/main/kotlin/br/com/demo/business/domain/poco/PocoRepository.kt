package br.com.demo.business.domain.poco

import br.com.demo.business.commons.ListaPaginada

interface PocoRepository {

    abstract fun consultar(filtroDTO: PocoFiltroDTO): ListaPaginada<Poco>

    abstract fun obterPoco(id: Int): Poco?

    abstract fun salvarPoco(poco: Poco): Poco

    abstract fun alterarStatusPoco(poco: Poco, statusNovo: StatusPocoEnum)
    fun salvarVinculo(vinculoInstalacaoPoco: VinculoInstalacaoPoco)

}