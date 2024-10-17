package trabalho.aos.demo.Exception;

public class EventoNaoEncontradoException extends RuntimeException {
  public EventoNaoEncontradoException(String message) {
    super(message);
  }

  // mensagem de erro
  public EventoNaoEncontradoException() {
    super("O evento cadastrado não foi encontrado.");
  }

}