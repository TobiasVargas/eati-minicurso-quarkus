package info.eati.quarkus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(schema = "apuracao", name = "votos")
public class Voto extends PanacheEntityBase {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "id_jogador")
	private Long idJogador;
	@Column(name = "nome_jogador")
	private String nomeJogador;
	@Column(name = "time_jogador")
	private String timeJogador;
	@Column(name = "camisa_jogador")
	private int camisaJogador;
}
