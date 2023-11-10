package info.eati.quarkus.resource;

import java.util.List;

import info.eati.quarkus.entity.Jogador;
import info.eati.quarkus.service.JogadorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/jogadores")
public class JogadorResource {

	@Inject
	JogadorService jogadorService;
	
	@Path("/")
	@GET
	public Response consultarJogadores() {
		List<Jogador> jogadores = jogadorService.consultarJogadores();
		return Response.ok().entity(jogadores).build();
	}
	
	@Path("/{id}")
	@GET
	public Response consultarJogadorPeloId(Long id) {
		Jogador jogador = jogadorService.consultarPeloId(id);
		return Response.ok().entity(jogador).build();
	}
}
