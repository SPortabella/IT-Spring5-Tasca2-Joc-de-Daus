package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.exceptions;

public class ElementsDoesntEqualsException extends RuntimeException{

    public ElementsDoesntEqualsException(Class type, Integer id, Integer idDto) {
        super("Id's in " + type.getSimpleName() + " must be equals. Entered values " + id + " - "+ idDto);
    }
}
