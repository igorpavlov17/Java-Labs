package test.java.ru.rsatu.app;

import org.junit.Assert;
import org.junit.Test;
import ru.rsatu.app.GoTest;
import ru.rsatu.dep.Dep;

import java.util.Objects;

public class GoTestTest {
    @Test
    public void testJson() {
        String input = "{\"name\":\""+Dep.getString()+"\"}";
        String result = "{\"name\":\"dep\"}";
        Assert.assertEquals(result, GoTest.jsonToString(Objects.requireNonNull(GoTest.stringToJson(input))));
    }
}

