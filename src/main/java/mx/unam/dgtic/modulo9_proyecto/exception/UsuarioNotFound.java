package mx.unam.dgtic.modulo9_proyecto.exception;

public class UsuarioNotFound extends RuntimeException {
    public UsuarioNotFound(String message) {
        super(message);
    }
}
