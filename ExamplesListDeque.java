/*
 * ExamplesListDeque.java
 *
 * Author: Your Name
 * Submitted on: Insert Date
 *
 * Academic Honesty Declaration:
 *
 * The following code represents my own work and I have neither received nor given assistance
 * that violates the collaboration policy posted with this assignment. I have not copied or modified code
 * from any other source other than the homework assignment, course textbook, or course lecture slides.
 * Any unauthorized collaboration or use of materials not permitted will be subjected to academic integrity policies of
 * WPI and CS 2223.
 *
 * I acknowledge that this homework assignment is based upon an assignment created by WPI and that any publishing or
 * posting of this code is prohibited unless I receive written permission from WPI.
 */
package wpialgs.hw02;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wpialgs.hw01.IDeque;
import static org.junit.Assert.*;

/**
 * This class provides test cases for our homework 2's {@link ListDeque}.
 *
 * @version 1.0
 */
public class ExamplesListDeque {

    // Fields
    public List<String> EMPTY_LIST;
    public List<String> LIST1;

    /**
     * <p>
     * The max capacity to use for testing the deque.
     * </p>
     */
    private static final int MAX_LENGTH = 100;

    // Constructor
    public ExamplesListDeque() {
        EMPTY_LIST = Collections.emptyList();
        LIST1 = new ArrayList<>();
    }

    // ===========================================================
    // JUnit Test Methods
    // ===========================================================

    // -----------------------------------------------------------
    // Constructor (Given)
    // -----------------------------------------------------------

    /**
     * Testing the constructor and checking we have an empty deque.
     */
    @Test
    public void testConstructor() {
        IDeque<String> deque = new ListDeque<>();
        assertEquals(EMPTY_LIST.toString(), deque.toString());
        assertEquals(0, deque.length());
    }
    @Test
    public void testEnqueueEmptyDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        assertEquals(1, deque.length());
        assertEquals("A", deque.peek());
    }

    @Test
    public void testEnqueueNonEmptyDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        deque.enqueue("B");
        assertEquals(2, deque.length());
        assertEquals("A", deque.peek());
    }

    @Test
    public void testDequeueOneElementDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        assertEquals("A", deque.dequeue());
        assertEquals(0, deque.length());
    }

    @Test
    public void testDequeueMoreThanOneElementDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        deque.enqueue("B");
        assertEquals("A", deque.dequeue());
        assertEquals(1, deque.length());
        assertEquals("B", deque.peek());
    }

    @Test
    public void testInjectEmptyDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.inject("A");
        assertEquals(1, deque.length());
        assertEquals("A", deque.peek());
    }

    @Test
    public void testInjectNonEmptyDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("B");
        deque.inject("A");
        assertEquals(2, deque.length());
        assertEquals("A", deque.peek());
    }

    @Test
    public void testRemoveLastOneElementDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        assertEquals("A", deque.removeLast());
        assertEquals(0, deque.length());
    }

    @Test
    public void testRemoveLastMoreThanOneElementDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        deque.enqueue("B");
        assertEquals("B", deque.removeLast());
        assertEquals(1, deque.length());
        assertEquals("A", deque.peek());
    }

    @Test
    public void testPeekOneElementDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        assertEquals("A", deque.peek());
    }

    @Test
    public void testPeekMoreThanOneElementDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        deque.enqueue("B");
        assertEquals("A", deque.peek());
    }

    @Test
    public void testEndOfDequeOneElementDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        assertEquals("A", deque.endOfDeque());
    }

    @Test
    public void testEndOfDequeMoreThanOneElementDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        deque.enqueue("B");
        assertEquals("B", deque.endOfDeque());
    }

    @Test
    public void testLengthEmptyDeque() {
        IDeque<String> deque = new ListDeque<>();
        assertEquals(0, deque.length());
    }

    @Test
    public void testLengthNonEmptyDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        deque.enqueue("B");
        assertEquals(2, deque.length());
    }

    @Test
    public void testClearEmptyDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.clear();
        assertEquals(0, deque.length());
    }

    @Test
    public void testClearNonEmptyDeque() {
        IDeque<String> deque = new ListDeque<>();
        deque.enqueue("A");
        deque.enqueue("B");
        deque.clear();
        assertEquals(0, deque.length());
    }
}