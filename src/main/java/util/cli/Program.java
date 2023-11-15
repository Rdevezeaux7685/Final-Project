package util.cli;
import util.Crypto;
import util.Generated;

import java.util.logging.Level;
import java.util.logging.Logger;

@Generated
public class Program {
    private static final Logger LOGGER = Logger.getLogger(Program.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.INFO, Crypto.getInstance().encrypt("romane")) ;
        LOGGER.log(Level.INFO, Crypto.getInstance().encrypt("romane"));
        LOGGER.log(Level.INFO, Crypto.getInstance().encrypt("helloworld"));

    }
}
