import java.lang.annotation.*;

/**
 * Annotation describes the required length of a String value
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ProperLength {
    int minLength() default 1;
    int maxLength() default 255;
}
