package br.salaoEveris.app.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.salaoEveris.app.model.Agendamento;
import br.salaoEveris.app.model.RelatorioAgendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
	
	@Query(value = "EXEC SP_BuscarAgendamentos :dataInicio, :dataFim", nativeQuery = true)
    List<RelatorioAgendamento> findBuscarAgendamentos(@Param("dataInicio") Calendar dataInicio,
            @Param("dataFim") Calendar dataFim);

}
