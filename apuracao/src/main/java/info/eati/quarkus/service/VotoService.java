package info.eati.quarkus.service;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.eati.quarkus.client.JogadoresClient;
import info.eati.quarkus.dto.JogadorDTO;
import info.eati.quarkus.dto.VotoDTO;
import info.eati.quarkus.entity.Voto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class VotoService {
	@Inject
	@RestClient
	JogadoresClient jogadoresClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VotoService.class);
	
	@Transactional
	@Incoming("voto-computado")
	public void computarVoto(VotoDTO votoDTO) {
		try {
			JogadorDTO jogadorDTO = jogadoresClient.consultarJogadorPeloId(votoDTO.getIdJogador());
			Voto voto = new Voto();
			voto.setIdJogador(jogadorDTO.getId());
			voto.setCamisaJogador(jogadorDTO.getCamisa());
			voto.setTimeJogador(jogadorDTO.getTime());
			voto.setNomeJogador(jogadorDTO.getNome());
			voto.persist();
		} catch (ClientWebApplicationException e) {
			if (e.getResponse().getStatus() != Response.Status.NOT_FOUND.getStatusCode()) {
				throw e;
			}
			LOGGER.info("VOTO INVALIDO - ID NÃO ENCONTRADO NO MS JOGADOR {}", votoDTO);
		}
	}
}
