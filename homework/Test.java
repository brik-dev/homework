package lesson_g.homework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // когда будет применяться аннотация . здесь в runtime . в моомен выполнения
@Target({ElementType.METHOD})
public @interface Test {
    int priority();
}
