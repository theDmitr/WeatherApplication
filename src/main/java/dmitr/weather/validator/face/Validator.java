package dmitr.weather.validator.face;

/**
 * Custom validator
 * @param <T> The class that will be validated
 */
public abstract class Validator<T> {

    public abstract void validate(T value);

    @SafeVarargs
    public final void validate(T... values) {
        for (var t : values) {
            validate(t);
        }
    }
}
