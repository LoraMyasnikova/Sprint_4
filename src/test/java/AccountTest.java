import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][] {
                {"Ая", false},
                {"А я", true},
                {"Ая ", false},
                {" Ая", false},
                {"Илья Ткачев", true}, // 11 символов
                {"ИльяТкачев", false },
                {" ИльяТкачев", false },
                {"Илья  Ткачев", false },
                {"Илья Ткачев ", false },
                {"Владислава Соколова", true}, // 19 символов
                {"АлександрОвчинников", false},
                {"Александр Овчинников", false}, // 20 символов
                {" ", false},
                {"", false},
                {null, false}
        };
    }

    @Test
    public void checkNameToEmbossTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}