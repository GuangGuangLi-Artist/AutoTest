package depend;

import org.testng.annotations.Test;

public class DependTest {


    @Test
    public void dependTest1(){
        System.out.println("dependTest1");
        throw new RuntimeException();
    }


    @Test(dependsOnMethods = {"dependTest1"})
    public void dependTest2(){
        System.out.println("dependTest2");
    }
}
