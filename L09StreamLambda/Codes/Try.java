

import java.util.function.Function;

interface Try<T> {
    <U> Try<U> map(Function<? super T, ? extends U> fun);
    <U> Try<U> bind(Function<? super T, Try<U>> fun);
    boolean isSuccess();
    Exception getError();
    T getValue();

    static <T> Try<T> value(T value) {
        return new Success<>(value);
    }

    static <T> Try<T> error(Exception e) {
        return new Error<>(e);
    }

}

class Success<T> implements Try<T> {
    final T value;

    Success(T value) {
        this.value = value;
    }

    @Override
    public <U> Try<U> map(Function<? super T, ? extends U> fun) {
        try {
            return Try.value(fun.apply(value));
        }
        catch (Exception e) {
            return Try.error(e);
        }
    }

    @Override
    public <U> Try<U> bind(Function<? super T, Try<U>> fun) {
        try {
            return fun.apply(value);
        }
        catch (Exception e) {
            return Try.error(e);
        }
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public Exception getError() {
        return null;
    }

    @Override
    public T getValue() {
        return value;
    }
}

class Error<T> implements Try<T> {
    Exception e;

    Error(Exception e) {
        this.e = e;
    }

    @Override
    public <U> Try<U> map(Function<? super T, ? extends U> fun) {
        return Try.error(e);
    }

    @Override
    public <U> Try<U> bind(Function<? super T, Try<U>> fun) {
        return Try.error(e);
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public Exception getError() {
        return e;
    }

    @Override
    public T getValue() {
        return null;
    }
}
