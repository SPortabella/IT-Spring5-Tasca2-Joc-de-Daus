package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n02.exceptions;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(Class type, String id) {
        super(type.getSimpleName() + " with id " + id + " not found");
    }
}
