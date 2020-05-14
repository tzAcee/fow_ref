import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("joe");
        Movie m1 = new Movie("movie1", 1);
        Movie m2 = new Movie("movie2", 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);

        customer.addRental(r1);
        customer.addRental(r2);
    }


    @org.junit.jupiter.api.Test
    void statement() {
        String expected = "Rental Record for joe\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points";
        String result = customer.statement();
        Assertions.assertEquals(expected, result);
    }

    @org.junit.jupiter.api.Test
    void html_statement() {
        String expected = "<H1>Rental for <EM>joe</EM></H1><P>\n" +
                "movie1: 30.0<BR>\n" +
                "movie2: 4.5<BR>\n" +
                "<P>Amount owed is <EM>34.5</EM><P>\n" +
                "You earned <EM>3</EM> frequent renter points<P>";
        String result = customer.htmlStatement();
        Assertions.assertEquals(expected, result);
    }
}