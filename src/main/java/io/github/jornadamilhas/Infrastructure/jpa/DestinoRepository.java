package io.github.jornadamilhas.Infrastructure.jpa;

import io.github.jornadamilhas.domain.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {
}
