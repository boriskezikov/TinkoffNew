package tihkoff.taxi.controller;

public class BadRequesrException extends  RuntimeException {
    public BadRequesrException(){
        super();
    }
    public BadRequesrException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadRequesrException (String message) {
        super(message);
    }
    public BadRequesrException (Throwable cause) {
        super(cause);
    }
}
