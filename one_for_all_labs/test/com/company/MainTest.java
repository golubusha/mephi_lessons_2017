package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Optional;

/**
 * Created by Настя on 18.10.2017.
 */
public class MainTest {

    @Test
    public void testSequence() {
        Optional<Main.Result> resultOpt = new Main.Sequence().indexOf("123133");
        Main.Result result = resultOpt.orElseThrow(IllegalStateException::new);
        Assert.assertEquals(312, result.firstNumber().intValue());
    }

}
