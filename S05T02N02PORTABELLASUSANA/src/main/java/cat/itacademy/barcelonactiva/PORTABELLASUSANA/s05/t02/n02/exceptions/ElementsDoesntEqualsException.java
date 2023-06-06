package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.exceptions;

public class ElementsDoesntEqualsException extends RuntimeException{

    public ElementsDoesntEqualsException(Class type, String id, String idDto) {
        super("Id's in " + type.getSimpleName() + " must be equals. Entered values " + id + " - "+ idDto);
    }
}
