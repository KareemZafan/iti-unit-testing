package org.iti.app_tests;

import org.iti.app.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTests {
    private MyStack myStack;

    @BeforeEach
    void setUp() {
        myStack = new MyStack();
    }

    @Test
    void testPushElementsToStack() {
        assertTrue(myStack.isEmpty(), "Satck is not empty");
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(50);


        assertEquals(4, myStack.getSize());
        assertEquals(50, myStack.getPeek());
        assertFalse(myStack.isEmpty());
        assertEquals(List.of(1, 2, 3, 50), myStack.getCurrentStack());

    }

    @Test
    void testPopElementsFromStack() {
        var ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.pop());
        assertEquals("Stack is empty!", ex.getMessage(), "Exception message is not the same");

        myStack.push(100);
        myStack.push(2);
        myStack.push(50);

        int poppedItem = myStack.pop();
        assertEquals(50, poppedItem);
        poppedItem = myStack.pop();
        assertEquals(2, poppedItem);

        assertEquals(1, myStack.getSize());
        assertEquals(100, myStack.getPeek());
        assertFalse(myStack.isEmpty());
        assertEquals(List.of(100), myStack.getCurrentStack());

    }

    @Test
    void testPeekElementFromStack() {
        var ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.pop());
        assertEquals("Stack is empty!", ex.getMessage(), "Exception message is not the same");

        ex = assertThrowsExactly(IllegalStateException.class, () -> myStack.getPeek());
        assertNotEquals("Stack is empty!", ex.getMessage(), "Exception message is not the same");


        myStack.push(100);
        myStack.push(2);
        myStack.push(50);


        assertEquals(50, myStack.getPeek());
        assertFalse(myStack.isEmpty());
        assertEquals(List.of(100,2,50), myStack.getCurrentStack());

    }
}
