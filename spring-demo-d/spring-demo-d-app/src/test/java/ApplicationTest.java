import com.codingapi.txlcn.tc.core.DTXLocalContext;
import org.junit.jupiter.api.Test;

/**
 * @author ：黑洞里的光
 * @date ：Created in 2021/5/27 13:23
 * @description：
 */
public class ApplicationTest {

    @Test
    public void test1(){
        String groupId = DTXLocalContext.getOrNew().getGroupId();
        System.out.println(groupId);
    }
}
