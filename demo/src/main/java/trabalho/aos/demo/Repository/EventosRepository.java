package trabalho.aos.demo.Repository;

import trabalho.aos.demo.Model.Eventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Long> {

  // Método para buscar uma lista de eventos pelo título
  List<Eventos> findByTitulo(String titulo);

  List<Eventos> findByDescricao(String descricao);

  List<Eventos> findByArquivosMidia(String arquivosMidia);

  List<Eventos> findByDataEvento(String dataEvento);
}
