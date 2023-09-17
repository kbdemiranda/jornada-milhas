package io.github.jornadamilhas.Infrastructure.jpa;

import io.github.jornadamilhas.domain.model.Depoimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {
}
