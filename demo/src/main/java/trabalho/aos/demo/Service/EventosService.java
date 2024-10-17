package trabalho.aos.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabalho.aos.demo.Exception.EventoNaoEncontradoException;
import trabalho.aos.demo.Model.Eventos;
import trabalho.aos.demo.Repository.EventosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventosService {

  @Autowired
  private EventosRepository eventosRepository;

  // Método para criar um novo evento
  public Eventos criarEvento(Eventos evento) {
    validarEvento(evento);
    return eventosRepository.save(evento);
  }

  // Método para listar todos os eventos
  public List<Eventos> listarTodosEventos() {
    List<Eventos> eventos = eventosRepository.findAll();
    if (eventos.isEmpty()) {
      throw new EventoNaoEncontradoException("Nenhum evento encontrado no sistema.");
    }
    return eventos;
  }

  // Método para buscar um evento pelo título
  public Eventos buscarEventoPorTitulo(String titulo) {
    return eventosRepository.findByTitulo(titulo)
        .stream()
        .findFirst()
        .orElseThrow(() -> new EventoNaoEncontradoException("Evento com título: " + titulo + " não encontrado."));
  }

  // Método para excluir um evento por ID
  public void excluirEvento(Long id) {
    if (!eventosRepository.existsById(id)) {
      throw new EventoNaoEncontradoException("O evento com este ID não foi encontrado no sistema.");
    }
    eventosRepository.deleteById(id);
    System.out.println("O evento foi deletado com sucesso!");
  }

  // Método para atualizar um evento existente
  public Eventos atualizarEvento(Long id, Eventos eventoDetails) {
    if (eventoDetails == null) {
      throw new EventoNaoEncontradoException("Os detalhes do evento não podem ser nulos.");
    }

    // Buscando o evento pelo ID
    Optional<Eventos> optionalEvento = eventosRepository.findById(id);
    if (optionalEvento.isEmpty()) {
      throw new EventoNaoEncontradoException("Evento não encontrado com id: " + id);
    }

    validarEvento(eventoDetails);
    Eventos evento = optionalEvento.get();

    evento.setTitulo(eventoDetails.getTitulo());
    evento.setDescricao(eventoDetails.getDescricao());
    evento.setArquivosMidia(eventoDetails.getArquivosMidia());
    evento.setDataEvento(eventoDetails.getDataEvento());
    evento.setDataPublicado(eventoDetails.getDataPublicado());

    return eventosRepository.save(evento);
  }

  private void validarEvento(Eventos evento) {
    if (evento.getTitulo() == null || evento.getTitulo().isEmpty() || evento.getTitulo().length() > 80) {
      throw new EventoNaoEncontradoException(
          "O título do evento não pode ser nulo, vazio ou ter mais que 80 caracteres.");
    }
    if (evento.getDataEvento() == null || evento.getDataEvento().isEmpty()) {
      throw new EventoNaoEncontradoException("A data do evento não pode ser nula ou vazia.");
    }
  }
}
