package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Jogador;
import one.digitalinnovation.gof.model.Jogo;
import one.digitalinnovation.gof.repository.JogadorRepository;
import one.digitalinnovation.gof.repository.JogoRepository;
import one.digitalinnovation.gof.service.FreeToGameService;
import one.digitalinnovation.gof.service.JogadorService;

@Service
public class JogadorServiceImpl implements JogadorService {
	@Autowired
	private JogadorRepository jogadorRepository;
	
	@Autowired
	private JogoRepository jogoRepository;
	
	@Autowired
	private FreeToGameService freeToGameService;

	@Override
	public Iterable<Jogador> buscarTodos() {
		return jogadorRepository.findAll();
	}

	@Override
	public Jogador buscarPorId(Long id) {
		Optional<Jogador> jogador = jogadorRepository.findById(id);
		return jogador.get();
	}

	@Override
	public void inserir(Jogador jogador) {
		salvarJogadorComJogos(jogador);
	}

	@Override
	public void atualizar(Long id, Jogador jogador) {
		Optional<Jogador> jogadorBd = jogadorRepository.findById(id);
		if (jogadorBd.isPresent())
			salvarJogadorComJogos(jogador);
	}

	@Override
	public void deletar(Long id) {
		jogadorRepository.deleteById(id);
	}
	
	private void salvarJogadorComJogos(Jogador jogador) {
		Long id = jogador.getJogo().getId();
		Jogo jogo = jogoRepository.findById(id).orElseGet(() -> {
			Jogo novoJogo = freeToGameService.consultarJogo(id);
			jogoRepository.save(novoJogo);
			return novoJogo;
		});
		jogador.setJogo(jogo);
		jogadorRepository.save(jogador);
	}

}
