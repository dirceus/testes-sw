package br.com.demo.infra.db.repositorios

import br.com.demo.infra.db.entities.BoletimMedicaoDiariaEntity
import org.springframework.data.jpa.repository.JpaRepository


interface BoletimMedicaoDiariaJpaRepository: JpaRepository<BoletimMedicaoDiariaEntity, Long> {



}