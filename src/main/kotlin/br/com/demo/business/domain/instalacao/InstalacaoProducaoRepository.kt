package br.com.demo.business.domain.instalacao

import br.com.demo.business.commons.ListaPaginada

interface InstalacaoProducaoRepository {
    abstract fun consultarInstalacoes(filtroDTO: InstalacaoProducaoFiltroDTO): ListaPaginada<InstalacaoProducao>
    abstract fun salvar(instalcao: InstalacaoProducao) : InstalacaoProducao
    abstract fun listaInstalacoesPorUn(codigoUn: Int) : List<InstalacaoProducaoDTO>
    abstract fun quantidadeInstalacoesAtivas(codigoUn: Int) : Int
}