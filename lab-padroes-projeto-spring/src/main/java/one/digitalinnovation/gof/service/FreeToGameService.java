package one.digitalinnovation.gof.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinnovation.gof.model.Jogo;

@FeignClient(name = "freetogame", url = "https://www.freetogame.com/api")
public interface FreeToGameService {

	@GetMapping("/game?id={jogo_id}")
	Jogo consultarJogo(@PathVariable("jogo_id") Long jogo_id);
}
