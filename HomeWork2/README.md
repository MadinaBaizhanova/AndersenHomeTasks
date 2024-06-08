Homework: concert tickets
Create 2 Java classes - "Ticket" and "TicketService".

The "Ticket" class should have the following variables:
1. ID (max 4 digits and/or chars)
2. concert hall (max 10 chars)
3. event code (3 digits)
4. time (Unix timestamp)
5. is promo
6. stadium sector (from ‘A’ to ‘C’)
7. max allowed backpack weight in kg (with grams precision)

Choose [name], [data type], [access modifier], and [variable type] carefully, depending on the [variable] purpose.

There should be the ability to create a Ticket instance with all parameters initialised and also a limited 
one - [concert hall], [event code] and [time].

The "TicketService" class should contain main function. 3 tickets should be created - empty, full and limited.

Add an ability to automatically detect and save Ticket creation time.
Add the ability to save ticket price. This should be a new variable, think carefully about the type.