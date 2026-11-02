package pro.sky.employeebookstreamapi.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public EmployeeAlreadyAddedException(Throwable cause) {
        super(cause);
    }
    public EmployeeAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
    public EmployeeAlreadyAddedException() {
    }
}
