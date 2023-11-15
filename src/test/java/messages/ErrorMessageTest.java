package messages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorMessageTest {

    @Test
    void testErrorMessageConstructorAndGetters() {
        String errorMessage = "Oops, Something went wrong";
        ErrorMessage message = new ErrorMessage(errorMessage);
        assertEquals(errorMessage, message.getMessage());
    }


}