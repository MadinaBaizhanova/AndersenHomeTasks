package util;

public interface Printable {
    default void print() {
        System.out.println(this.toString());
    }
}

/*
Task #2

There should be a possibility to add an ability to .print() class content for every class.

Also, there should be a possibility to override this function as well as use the default implementation,

which is “print content in console”.
 */