package com.cheng;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFlattener {

    private static String testFolderName = "src/test/resources";

    private String scan(String fileName) throws IOException {

        Scanner scanner = new Scanner(new File(testFolderName + "/" + fileName));
        StringBuilder strb = new StringBuilder();
        while(scanner.hasNext()) {
            strb.append(scanner.next());
        }
        return strb.toString().replaceAll("[ \t\n]", "");
    }

    @Test
    public void testSample() throws IOException {
        String json = scan("json1");
        String expected = scan("expected1");
        assertEquals(expected, Flattener.flat(json));
    }

    @Test
    public void testNegativeAndDoubles() throws IOException {
        String json = scan("json2");
        String expected = scan("expected2");
        assertEquals(expected, Flattener.flat(json));
    }

    @Test
    public void testMoreNestedJson() throws IOException {
        String json = scan("json3");
        String expected = scan("expected3");
        assertEquals(expected, Flattener.flat(json));
    }

    @Test
    public void testEmptyJson() throws IOException {
        String json = scan("json4");
        String expected = scan("expected4");
        assertEquals(expected, Flattener.flat(json));
    }

    @Test
    public void testJsonWithEmptyElements() throws IOException {
        String json = scan("json5");
        String expected = scan("expected5");
        assertEquals(expected, Flattener.flat(json));
    }
}
