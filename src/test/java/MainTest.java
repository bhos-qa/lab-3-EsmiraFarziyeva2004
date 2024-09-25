package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testMainOutput() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out; 
        System.setOut(new PrintStream(outputStream)); 

        // Act
        Main.main(new String[]{});

        // Assert
        assertEquals("Hello, world!\n", outputStream.toString()); 

        // Restore original System.out
        System.setOut(originalOut);
    }
}
