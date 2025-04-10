package mx.unam.dgtic.modulo9_proyecto.exception;

public class ProductoNotFound extends RuntimeException {
    public ProductoNotFound(String message) {
        super(message);
    }
}
