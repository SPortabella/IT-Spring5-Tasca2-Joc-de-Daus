package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.f3.exceptions;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(Class type, Integer id) {
        super(type.getSimpleName() + " with id " + id + " not found");
    }
}
