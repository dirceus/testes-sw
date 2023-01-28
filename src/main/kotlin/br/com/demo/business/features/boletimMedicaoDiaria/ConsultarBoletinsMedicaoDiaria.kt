package br.com.demo.business.features.boletimMedicaoDiaria

import br.com.demo.business.commons.FunciolidadeExecutavel
import br.com.demo.business.commons.ListaPaginada
import br.com.demo.business.commons.exceptions.BusinessException
import br.com.demo.business.domain.boletimMedicaoDiaria.BoletimMedicaoDiariaDTO
import br.com.demo.business.domain.boletimMedicaoDiaria.BoletimMedicaoDiariaFiltroDTO
import br.com.demo.business.domain.boletimMedicaoDiaria.BoletimMedicaoDiariaRepository
import br.com.demo.business.domain.unidadeNegocio.UnidadeNegocioRepository

class ConsultarBoletinsMedicaoDiaria (private val boletimMedicaoDiariaRepository: BoletimMedicaoDiariaRepository,
                                      private val unidadeNegocioRepository: UnidadeNegocioRepository
) : FunciolidadeExecutavel<BoletimMedicaoDiariaFiltroDTO, ListaPaginada<BoletimMedicaoDiariaDTO>> {
    override fun executar(request: BoletimMedicaoDiariaFiltroDTO) : ListaPaginada<BoletimMedicaoDiariaDTO>{

        val unidadeNegocio = unidadeNegocioRepository.obterPorCodigo(request.codUnidadeNegocio)
            ?: throw BusinessException("Código da unidade de negócio inválido")

        val listaPaginada = boletimMedicaoDiariaRepository.consultarBoletins(fitroDto = request)

        return ListaPaginada(
            total = listaPaginada.total,
            tamanho = listaPaginada.tamanho,
            pagina = listaPaginada.pagina,
            itens = listaPaginada.itens.map { BoletimMedicaoDiariaDTO(it) }
        )

    }
}