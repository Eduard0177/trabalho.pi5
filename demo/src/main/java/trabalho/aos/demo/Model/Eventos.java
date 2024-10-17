package trabalho.aos.demo.Model;

//import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Eventos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Eventos {

  // id como chave primária
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;

  // Lista de membros associados a ''Evento''
  // private List<Membro> publicador;

  private String descricao;

  private String arquivosMidia; // Arquivos de mídia relacionados ao evento

  private String dataEvento;

  private String dataPublicado;
}