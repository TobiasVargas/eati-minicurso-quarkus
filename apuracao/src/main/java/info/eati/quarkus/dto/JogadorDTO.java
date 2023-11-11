package info.eati.quarkus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogadorDTO {
	private Long id;
	private String nome;
	private String time;
	private int camisa;
}
