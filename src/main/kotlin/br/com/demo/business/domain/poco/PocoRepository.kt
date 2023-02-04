package br.com.demo.business.domain.poco

import br.com.demo.business.commons.ListaPaginada

interface PocoRepository {

    abstract fun consultar(filtroDTO: PocoFiltroDTO): ListaPaginada<Poco>

    abstract fun obter(id: Int): Poco?

    abstract fun salvar(poco: Poco)

    abstract fun alterarStatusPoco(poco: Poco, statusNovo: StatusPocoEnum)
    fun salvarVinculo(vinculoInstalacaoPoco: VinculoInstalacaoPoco)

}