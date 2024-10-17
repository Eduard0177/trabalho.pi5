package trabalho.aos.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Eventos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Eventos {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String titulo;

  @Column
  private String descricao;

  @Column
  private String arquivosMidia; // arquivos de mídia relacionados ao evento

  @Column
  private String dataEvento; // Data do evento

  @Column
  private LocalDateTime dataPublicado; // Data e hora de publicação do evento

  // @ManyToOne
  // @JoinColumn(name = "membro_id", nullable = false) // Relacionamento com
  // Membro
  // private Membro membro; // O membro responsável pelo evento
}
