import org.junit.Test;

/**
 * @author yu yang
 * @date 2022/8/28 -19:46
 */
public class TestQuestion {
    @Test
    public void test(){
        String s = "/ssm/employee/1";
        String substring = s.substring(s.lastIndexOf("/ssm"));
        System.out.println(substring);
    }
}
