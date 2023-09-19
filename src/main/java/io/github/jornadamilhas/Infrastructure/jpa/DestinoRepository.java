package io.github.jornadamilhas.Infrastructure.jpa;

import io.github.jornadamilhas.domain.model.Destino;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {

    @Query("SELECT d FROM Destino d WHERE (:nomeDestino is null or lower(d.nomeDestino) like lower(concat('%', :nomeDestino,'%')))")
    Page<Destino> findByNomeDestino(@Param("nomeDestino") String nomeDestino, Pageable pageable);
}
