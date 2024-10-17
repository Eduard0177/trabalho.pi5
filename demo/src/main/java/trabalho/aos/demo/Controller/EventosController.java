package trabalho.aos.demo.Controller;

import trabalho.aos.demo.Model.Eventos;
import trabalho.aos.demo.Service.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventosController {

  @Autowired
  private EventosService eventosService;

  // Buscar evento por título
  @GetMapping("/{titulo}")
  public ResponseEntity<Eventos> buscarEventoPorTitulo(@PathVariable String titulo) {
    Eventos evento = eventosService.buscarEventoPorTitulo(titulo);
    return ResponseEntity.ok(evento);
  }

  // Listar todos os eventos
  @GetMapping
  public ResponseEntity<List<Eventos>> listarTodosEventos() {
    List<Eventos> eventos = eventosService.listarTodosEventos();
    return ResponseEntity.ok(eventos);
  }

  // Criar novo evento
  @PostMapping
  public ResponseEntity<Eventos> criarEvento(@RequestBody Eventos novoEvento) {
    eventosService.criarEvento(novoEvento);
    return ResponseEntity.ok(novoEvento);
  }

  // Editar um evento existente
  @PutMapping("/{titulo}")
  public ResponseEntity<Eventos> editarEvento(@PathVariable String titulo, @RequestBody Eventos infosAtualizadas) {
    eventosService.editarEvento(titulo, infosAtualizadas);
    return ResponseEntity.ok(infosAtualizadas);
  }

  // Excluir um evento por título
  @DeleteMapping("/{titulo}")
  public ResponseEntity<Void> excluirEvento(@PathVariable String titulo) {
    eventosService.excluirEvento(titulo);
    return ResponseEntity.noContent().build();
  }
}
