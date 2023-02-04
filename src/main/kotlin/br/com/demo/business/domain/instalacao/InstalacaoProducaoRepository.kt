package br.com.demo.business.domain.instalacao

import br.com.demo.business.commons.ListaPaginada
import java.time.LocalDate

interface InstalacaoProducaoRepository {
    abstract fun consultarInstalacoes(filtroDTO: InstalacaoProducaoFiltroDTO): ListaPaginada<InstalacaoProducao>
    abstract fun salvar(instalcao: InstalacaoProducao) : Unit
    abstract fun listaInstalacoesPorUn(codigoUn: Int) : List<InstalacaoProducao>
    abstract fun quantidadeInstalacoesAtivas(codigoUn: Int) : Int
    abstract fun obter(codInstalacao : Int): InstalacaoProducao?
    fun obterPeloVinculo(codPoco: Int, dataInicio: LocalDate, dataFim: LocalDate): InstalacaoProducao?
}