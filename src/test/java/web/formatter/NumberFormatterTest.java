package web.formatter;

import domain.*;
import domain.Number;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by john on 15-11-11.
 */
//@RunWith(SpringJUnit4ClassRunner.class)

public class NumberFormatterTest {
    private NumberFormatter numberFormatter = new NumberFormatter();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testParse() throws Exception {
        domain.Number number = new Number();
        number.setPrefix("1234567");
        number.setSuffix("123");
        assertThat(numberFormatter.parse("1234567-123", null), is(number));
    }

    @Test
    public void testPrint() throws Exception {

    }
}