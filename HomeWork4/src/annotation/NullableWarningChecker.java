package annotation;

import java.lang.reflect.Field;

public class NullableWarningChecker {
    public static void checkForNullableWarnings(Object obj) {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(NullableWarning.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    if (value == null) {
                        System.out.printf("Variable [%s] is null in [%s]!%n", field.getName(), clazz.getSimpleName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}