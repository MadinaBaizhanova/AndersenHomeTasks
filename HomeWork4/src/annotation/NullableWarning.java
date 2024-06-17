package annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NullableWarning {
}

/*
***

Create your own custom annotation @NullableWarning that will print in console:

“Variable [{variable_name}] is null in [{class}]!”, when stated above the field of a class and an instance of
this class is created via new keyword.

Like:
@NullableWarning
private int Id;
Ticket ticket = new Ticket();
Variable [id] is null in [Ticket]!
 */