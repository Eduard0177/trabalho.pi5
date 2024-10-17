package trabalho.aos.demo.Service;

import trabalho.aos.demo.Exception.EventoNaoEncontradoException;
import trabalho.aos.demo.Model.Eventos;
import trabalho.aos.demo.Repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventosService {

  @Autowired
  private EventosRepository eventosRepository;

  // Busca um evento pelo título
  public Eventos buscarEventoPorTitulo(String titulo) {
    return eventosRepository.findByTitulo(titulo)
        .orElseThrow(() -> new EventoNaoEncontradoException("Evento com título: " + titulo + " não encontrado."));
  }

  // Cria um novo evento
  public void criarEvento(Eventos novoEvento) {
    eventosRepository.save(novoEvento);
  }

  // Exclui um evento pelo título
  public void excluirEvento(String titulo) {
    Eventos evento = buscarEventoPorTitulo(titulo); // Verifica se o evento existe antes de excluir
    eventosRepository.deleteById(evento.getId());
  }

  // Edita um evento existente pelo título
  public void editarEvento(String titulo, Eventos infosAtualizadas) {
    Eventos eventoExistente = buscarEventoPorTitulo(titulo); // Busca o evento existente

    // Atualiza os campos do evento existente com as informações fornecidas
    eventoExistente.setTitulo(infosAtualizadas.getTitulo());
    eventoExistente.setDescricao(infosAtualizadas.getDescricao());
    eventoExistente.setArquivosMidia(infosAtualizadas.getArquivosMidia());
    eventoExistente.setDataEvento(infosAtualizadas.getDataEvento());
    eventoExistente.setDataPublicado(infosAtualizadas.getDataPublicado());
    eventosRepository.save(eventoExistente);
  }

  // Lista todos os eventos
  public List<Eventos> listarTodosEventos() {
    return eventosRepository.findAll();
  }
}
