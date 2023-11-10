package info.eati.quarkus.service;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;

import info.eati.quarkus.dto.VotoDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class VotoService {

	@Inject
	@Channel("voto-computado")
	@OnOverflow(value = OnOverflow.Strategy.UNBOUNDED_BUFFER)
	Emitter<VotoDTO> votoComputadoEmitter;
	
	public void registrarVoto(VotoDTO votoDTO) {
		votoComputadoEmitter.send(votoDTO);
	}
}
