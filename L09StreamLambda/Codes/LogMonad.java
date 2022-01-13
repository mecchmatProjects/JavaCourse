

//imports

public final class LogMonad<T> {
    private final T value;

    private static final Logger LOGGER = 
      Logger.getLogger(LogMonad.class.getName());

    private LogMonad() {
        this.value = null;
    }

    private LogMonad(T value) {
        this.value = value;
    }
    static <T> LogMonad<T> of(T value) {
        Objects.requireNonNull(value, "value is null");
        return new LogMonad<>(value);
    }
    <U> LogMonad<U> flatMap(Function<T, LogMonad<U>> function) {
        Objects.requireNonNull(function, "function is null");
        try {
            return function.apply(value);
        } catch (Throwable t) {
            return new LogMonad<>();
        }
    }
    LogMonad<T> log() {
        LOGGER.log(Level.INFO, "{0}", value);
        return this;

    }

    LogMonad<T> log(Level loggingLevel) {

        Objects.requireNonNull(loggingLevel, "logging level is null");
        LOGGER.log(loggingLevel, "{0}", value);
        return this;
    }

//equals, hashCode & toString

}
