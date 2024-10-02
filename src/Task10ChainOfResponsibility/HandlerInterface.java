package Task10ChainOfResponsibility;

public interface HandlerInterface {
    void handleMessage(MessageClass message);

    void setNextHandler(HandlerInterface nextHandler);
}
