package com.hiczp.boxDrawingArt.test;

import com.hiczp.boxDrawingArt.BoxDrawingArt;
import org.junit.After;
import org.junit.Test;

public class JavaTest {
    @Test
    public void normal() {
        System.out.println(BoxDrawingArt.convert("Box Drawing Art"));
    }

    @After
    public void printNonEmptyLine() {
        System.out.println("!");
    }
}
