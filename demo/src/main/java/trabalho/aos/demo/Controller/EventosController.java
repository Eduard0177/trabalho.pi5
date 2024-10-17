package trabalho.aos.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trabalho.aos.demo.Model.Eventos;
import trabalho.aos.demo.Exception.EventoNaoEncontradoException;
import trabalho.aos.demo.Service.EventosService;

@RestController
@RequestMapping(value = "/api/eventos") // Mapeia as requisições para a URL base "/api/eventos"
public class EventosController {

  @Autowired // Injeção de dependência do serviço de eventos
  private EventosService eventosService;

  // Método para adicionar um novo evento
  @PostMapping("/add")
  public Eventos inserirEvento(@RequestBody Eventos evento) {
    try {
      return eventosService.criarEvento(evento); // Chama o método do serviço para criar um evento
    } catch (EventoNaoEncontradoException e) {
      throw new RuntimeException(e.getMessage()); // Lança uma exceção em caso de erro
    }
  }

  // lista todos os eventos
  @GetMapping("/list")
  public List<Eventos> getAllEventos() {
    try {
      return eventosService.listarTodosEventos(); // Retorna a lista de eventos do serviço
    } catch (EventoNaoEncontradoException e) {
      throw new RuntimeException(e.getMessage()); // Lança uma exceção em caso de erro
    }
  }

  // Método para buscar um evento pelo título
  @GetMapping("/list/titulo/{titulo}")
  public Eventos getEventoByTitulo(@PathVariable String titulo) {
    try {
      return eventosService.buscarEventoPorTitulo(titulo); // Chama o método do serviço para buscar evento pelo título
    } catch (EventoNaoEncontradoException e) {
      throw new RuntimeException(e.getMessage()); // Lança uma exceção em caso de erro
    }
  }

  // Método para deletar um evento pelo ID
  @DeleteMapping("/delete/{id}")
  public void deleteEvento(@PathVariable Long id) {
    try {
      eventosService.excluirEvento(id); // Chama o método do serviço para excluir um evento
    } catch (EventoNaoEncontradoException e) {
      throw new RuntimeException(e.getMessage()); // Lança uma exceção em caso de erro
    }
  }

  // Método para atualizar um evento pelo ID
  @PutMapping("/update/{id}")
  public ResponseEntity<?> updateEvento(@PathVariable Long id, @RequestBody Eventos eventoDetails) {
    try {
      Eventos updateEvento = eventosService.atualizarEvento(id, eventoDetails); // Atualiza o evento através do serviço
      return ResponseEntity.ok(updateEvento); // Retorna o evento atualizado
    } catch (EventoNaoEncontradoException e) {
      return ResponseEntity.badRequest().body(e.getMessage()); // Retorna mensagem de erro
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro inesperado."); // Retorna um
                                                                                                          // erro

    }
  }
}
