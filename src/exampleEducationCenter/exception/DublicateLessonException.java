package exampleEducationCenter.exception;

public class DublicateLessonException extends  Exception{
    public DublicateLessonException() {
    }

    public DublicateLessonException(String message) {
        super(message);
    }

    public DublicateLessonException(String message, Throwable cause) {
        super(message, cause);
    }

    public DublicateLessonException(Throwable cause) {
        super(cause);
    }

    public DublicateLessonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
