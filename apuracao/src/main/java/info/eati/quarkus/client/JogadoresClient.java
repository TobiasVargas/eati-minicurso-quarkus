package info.eati.quarkus.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import info.eati.quarkus.dto.JogadorDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/jogadores")
@RegisterRestClient(configKey = "clients.jogadores")
public interface JogadoresClient {
	@GET
	@Path("/{id}")
	JogadorDTO consultarJogadorPeloId(Long id);
}
