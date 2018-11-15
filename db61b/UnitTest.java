package db61b;
import org.junit.Test;
import static org.junit.Assert.*;

/** The suite of all JUnit tests for the qirkat package.
 *  @author P. N. Hilfinger
 */
public class UnitTest {

    @Test
    public void test() {
        String[] colNames = {"Name", "BirthYear"};
        String[] row1 = {"Adish", "1998"};
        String[] row2 = {"Suhas", "1998"};
        String[] row3 = {"Malik", "1999"};
        String[] row4 = {"Warren", "1997"};
        Table birth = new Table(colNames);
        birth.add(row1);
        birth.add(row2);
        birth.add(row3);
        birth.add(row4);

        String[] col2Names = {"University", "Name", "Year"};
        Table college = new Table(col2Names);
        String[] row21 = {"Berkeley", "Adish", "2020"};
        String[] row22 = {"Stanford", "Suhas", "2021"};
        String[] row23 = {"Harvard", "Malik", "2022"};
        String[] row24 = {"MIT", "Warren", "2020"};
        String[] row25 = {"MIT", "Gino", "2020"};
        college.add(row21);
        college.add(row22);
        college.add(row23);
        college.add(row24);
        college.add(row25);

        Column col = new Column("University", college);
        Column col2 = new Column("BirthYear", birth);
        Column col3 = new Column("Name", birth);
        Column col4 = new Column("Name", college);

        Condition cond = new Condition(col, "!=", col2);
        assertEquals(true, cond.test(1, 2, 3, 4));

        Condition cond2 = new Condition(col3, "=", col4);
        assertEquals(true, cond2.test(1, 2, 3, 4));

        Database db = new Database();
        db.put("Birth", birth);
        assertEquals(birth, db.get("Birth"));
        assertEquals(null, db.get("College"));

        assertEquals("Berkeley", college.get(0, 0));
        assertEquals("1998", birth.get(0, 1));
        assertNotEquals("1998", birth.get(2, 1));
        assertEquals(2, birth.columns());
        assertEquals(5, college.size());

    }

    /** Run the JUnit tests in this package. Add xxxTest.class entries to
     *  the arguments of runClasses to run other JUnit tests. */
    public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(UnitTest.class));
    }

}
