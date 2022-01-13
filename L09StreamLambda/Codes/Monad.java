/**
 * A parametrized type Monad<T> with two additional operations
 */
interface Monad<T> {

    /**
     * Basic operation.
     * Takes a value and returns monad wrapping the value
     */
    Monad<T> unit(T value);

    /**
     * Basic operation.
     * Takes a function f: T -> Monad<U> and returns a Monad<U>
     */
    <U> Monad<U> bind(Function<? super T, Monad<U>> f);

    /**
     * Additional operation.
     * Takes a function f: T -> U and returns a Monad<U>
     * May be defined as combination of unit and flatMap
     */
    <U> Monad<U> map(Function<? super T, ? extends U> f);

    /**
     * Additional operation.
     * Returns the value back to the world
     */
    T get();
}
