package akm.apiPlayOnWords.one.exceptions;

public class CalculationsGeneralException extends RuntimeException {
    public CalculationsGeneralException() {
        super("CalculationsGeneralException!");
    }

    public CalculationsGeneralException(String arg) {
        super("CalculationsGeneralException! [" + arg +"] was ZERO ! NOT COOL");
    }
}
