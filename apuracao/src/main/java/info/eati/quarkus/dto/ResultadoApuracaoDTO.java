package info.eati.quarkus.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultadoApuracaoDTO {
	private Long quantidadeVotos;
	private Long idJogador;
	private String nomeJogador;
	private int camisaJogador;
	private String timeJogador;
	
	public ResultadoApuracaoDTO(Long quantidadeVotos, Long idJogador, String nomeJogador, int camisaJogador,
			String timeJogador) {
		super();
		this.quantidadeVotos = quantidadeVotos;
		this.idJogador = idJogador;
		this.nomeJogador = nomeJogador;
		this.camisaJogador = camisaJogador;
		this.timeJogador = timeJogador;
	}
	
	
}
