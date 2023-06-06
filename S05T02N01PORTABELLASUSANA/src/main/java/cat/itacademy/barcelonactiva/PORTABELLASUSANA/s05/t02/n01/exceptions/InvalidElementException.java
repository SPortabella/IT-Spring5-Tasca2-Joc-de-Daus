package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.exceptions;

public class InvalidElementException extends RuntimeException{

    public InvalidElementException(Class type) {
        super("Id from " + type.getSimpleName() + " is invalid");
    }
}
