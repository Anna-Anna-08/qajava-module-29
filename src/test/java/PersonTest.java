import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class PersonTest {

    {
    }
    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
    @BeforeClass
    void beforeClass() {
        System.out.println("Start");
        currentTime();
    }
    @AfterClass
    void afterClass() {
        System.out.println("Finish");
        currentTime();
    }
    @DataProvider(name = "Age")
    Object [][]Age() {
        return new Object[][] {
                {-1, false},
                {0, false},
                {12, false},
                {13, true},
                {18, true},
                {19, true},
                {20, false}
        };
    }
    @Test(dataProvider = "Age")
    void personTestIsTeenager(int age, boolean expected){
        boolean result = Person.isTeenager(age);
        System.out.println("For age" + age +":" +"Actual result:" + result +"/" +"Expected result:" + expected);
        assertEquals(result,expected);
    }
}