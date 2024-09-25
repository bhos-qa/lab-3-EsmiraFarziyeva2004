package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    
    @Test
    public void testMain() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; 

        System.setOut(new PrintStream(outputStream));

        Main.main(new String[]{});

        System.setOut(originalOut);

        String expectedOutput = "Hello world!\n"; 
        assertEquals(expectedOutput, outputStream.toString());
    }
}
