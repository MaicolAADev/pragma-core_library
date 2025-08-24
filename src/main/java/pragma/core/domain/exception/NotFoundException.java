package pragma.core.domain.exception;

public class NotFoundException extends DomainException {
    public NotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }

    public NotFoundException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}