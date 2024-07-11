package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Jogador;

public interface JogadorService {

	Iterable<Jogador> buscarTodos();

	Jogador buscarPorId(Long id);

	void inserir(Jogador Jogador);

	void atualizar(Long id, Jogador Jogador);

	void deletar(Long id);
}
