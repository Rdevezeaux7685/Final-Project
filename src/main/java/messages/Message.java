package messages;
import java.io.Serializable;

public class Message implements Serializable {
    public static Message createMessage() {
        return new Message();
    }
}
