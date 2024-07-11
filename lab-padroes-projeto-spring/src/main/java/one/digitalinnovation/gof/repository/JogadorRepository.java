package one.digitalinnovation.gof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.gof.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {}