package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.exceptions;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(Class type, Integer id) {
        super(type.getSimpleName() + " with id " + id + " not found");
    }
}
