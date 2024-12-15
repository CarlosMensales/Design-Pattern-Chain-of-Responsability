package handler;

public abstract class ValidationHandler {
    protected ValidationHandler next;

    public void setNext(ValidationHandler next) {
        this.next = next;
    }

    public abstract boolean handleRequest(String username, String password);
}
