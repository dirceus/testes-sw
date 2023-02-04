package br.com.demo.business.domain.boletimMedicaoDiaria

import br.com.demo.business.commons.ListaPaginada
import java.time.LocalDate

interface BoletimMedicaoDiariaRepository {

    abstract fun obterBoletimMedicao(codInstalacao: Int,
                                     data: LocalDate) : BoletimMedicaoDiaria?

    abstract fun obterBoletinsMedicao(codUn:Int, data : LocalDate) : List<BoletimMedicaoDiaria>

    abstract fun salvar(boletim: BoletimMedicaoDiaria) : BoletimMedicaoDiaria

    abstract fun consultarBoletins(fitroDto: BoletimMedicaoDiariaFiltroDTO) : ListaPaginada<BoletimMedicaoDiaria>

}