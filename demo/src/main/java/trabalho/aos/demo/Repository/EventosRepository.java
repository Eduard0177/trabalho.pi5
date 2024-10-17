package trabalho.aos.demo.Repository;

import trabalho.aos.demo.Model.Eventos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, Long> {

  // (busca evento pelo título)
  Eventos findByTitulo(String titulo);

  Optional<Eventos> findById(String Id);

}
