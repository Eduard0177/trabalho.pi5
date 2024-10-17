package trabalho.aos.demo.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Eventos {
  private Long id; // Pra idetificar o evento

  private String titulo; // Título do evento

  private String descricao; // Descrição do evento

  private String arquivosMidia; // arquivos de mídia relacionados ao evento

  private String dataEvento; // Data do evento

  private LocalDateTime dataPublicado; // Data e hora de publicação do evento

}