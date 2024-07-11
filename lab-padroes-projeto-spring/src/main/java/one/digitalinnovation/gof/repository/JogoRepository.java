package one.digitalinnovation.gof.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.gof.model.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {}