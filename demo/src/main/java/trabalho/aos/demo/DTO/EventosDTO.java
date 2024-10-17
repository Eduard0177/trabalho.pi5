package trabalho.aos.demo.DTO;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class EventosDTO {

  @NotNull(message = "O título do evento é obrigatório.")
  @Size(min = 3, max = 100, message = "O título deve ter entre 3 e 100 caracteres.")
  private String titulo;

  @Size(max = 1500, message = "A descrição pode ter até 1500 caracteres.")
  private String descricao;

  private String arquivosMidia;

  @NotNull(message = "A data do evento é obrigatória.")
  private String dataEvento;

  private LocalDateTime dataPublicado;

  // Caso precise de interação com o Membro, adicione o id do membro
  // @NotNull(message = "O id do membro é obrigatório.")
  // private Long membroId; // Ou você pode usar um MembroDTO

}
