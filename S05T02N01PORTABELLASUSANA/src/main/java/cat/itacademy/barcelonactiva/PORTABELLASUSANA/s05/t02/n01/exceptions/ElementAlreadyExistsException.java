package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s05.t02.n01.exceptions;

public class ElementAlreadyExistsException extends RuntimeException{

    public ElementAlreadyExistsException(Class type, String name) {
        super("Element of " + type.getSimpleName() + " with name " + name + " already exists");
    }
}
