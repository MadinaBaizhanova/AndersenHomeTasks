Homework: ticket services hierarchy
You have to extend your Ticket application with a new functionality.
1. Any class in your application should be able to have a numeric “ID” field and be able to get and set it. Think about a proper solution for that - abstract class
   or interface?
2. There should be a possibility to add an ability to .print() class content for every class. Also, there should be a possibility to override this function as well as
   use the default implementation, which is “print content in console”.
3. For your Ticket class from the previous lesson, there should be a possibility to change only “time” and “stadium sector” fields. Also, there should be a
   possibility to get all Ticket values.
4. A Ticket should be able to be .shared() by phone and by phone and email. Think about the type of polymorphism that you will use here. In the .main()
   method show the example of the chosen polymorphism approach.
5. In your application, there should be 2 Users - Client and Admin, both should be able to .printRole() and also have unique functions - getTicket() for User and
   checkTicket() - for Admin. Think about inheritance and the type of polymorphism that you will use here. In the .main() method show the example of the
   chosen polymorphism approach.
6. Override equals(), toString() and hashCode() in your Ticket class, so they will be able to return meaningful values that follow equals & hashCode contract.
   *** create your own custom annotation @NullableWarning that will print in console: “Variable [{variable_name}] is null in [{class}]!”, when stated above the field
   of a class and an instance of this class is created via new keyword.
   Like:

   @NullableWarning
   private int Id;

   Ticket ticket = new Ticket();
   Variable [id] is null in [Ticket]!