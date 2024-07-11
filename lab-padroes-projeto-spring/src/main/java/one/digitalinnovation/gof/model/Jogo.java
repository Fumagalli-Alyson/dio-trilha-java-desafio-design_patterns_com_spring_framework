package one.digitalinnovation.gof.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@JsonInclude(Include.NON_NULL)
public class Jogo {
	@Id
	private Long id;
	private String title;
	private String status;
	private String shortDescription;
	private String gameUrl;
	private String genre;
	private String platform;
	private String publisher;
	private String developer;
	private String releaseDate;
	private String freetogameProfileUrl;
}
