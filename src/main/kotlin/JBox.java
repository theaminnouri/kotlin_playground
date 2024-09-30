import org.jetbrains.annotations.NotNull;

public interface JBox<T> {
    /**
     * Puts a non-null value into the box.
     */
    void put(@NotNull T t);

    /**
     * Puts a value into the box if it is not null,
     * doesn't do anything for null values.
     */
    void putIfNotNull(T t);
}