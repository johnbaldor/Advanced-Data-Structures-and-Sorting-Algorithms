/*
 * ExamplesLinkedList.java
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

import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class provides test cases for our homework 2's {@link DoublyLinkedList} and {@link MoreListMethods}.
 *
 * @version 1.0
 */
public class ExamplesLinkedList {

    // Fields
    public List<String> EMPTY_LIST;

    // Constructor
    public ExamplesLinkedList() {
        EMPTY_LIST = Collections.emptyList();
    }

    // ===========================================================
    // Private Helper Methods
    // ===========================================================

    /**
     * A helper method that gets the string representation of the chained {@link TwoWayNode}s.
     *
     * @param start
     *            The starting node
     *
     * @return A string representation of the {@link TwoWayNode} list. The list remains the same.
     */
    private String nodeListAsString(TwoWayNode<String> start) {
        StringBuilder sb = new StringBuilder();

        // Traverse doubly-linked list and build a string
        sb.append("[");
        TwoWayNode<String> travNode = start;
        while (travNode != null) {
            sb.append(travNode.getDataVal());
            if (travNode.getNext() != null) {
                sb.append(", ");
            }

            travNode = travNode.getNext();
        }
        sb.append("]");

        return sb.toString();
    }

    // ===========================================================
    // JUnit Test Methods
    // ===========================================================

    // -----------------------------------------------------------
    // Constructor (Given)
    // -----------------------------------------------------------

    /**
     * Testing the constructor and checking we have an empty list.
     */
    @Test
    public void testConstructor() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        assertEquals(EMPTY_LIST.toString(), linkedList.toString());
        assertEquals(0, linkedList.getListLength());
    }

    // -----------------------------------------------------------
    // getHeadOfList (Given)
    // -----------------------------------------------------------

    /**
     * Testing {@link ILinkedList#getHeadOfList()} and checking that it returns {@code null} when the list is empty.
     */
    @Test
    public void testGetHeadOfListEmpty() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        assertNull(linkedList.getHeadOfList());
        assertEquals(EMPTY_LIST.toString(), linkedList.toString());
        assertEquals(0, linkedList.getListLength());
    }

    /**
     * Testing {@link ILinkedList#getHeadOfList()} and checking we have the correct node when the list is not empty.
     */
    @Test
    public void testGetHeadOfListNonEmpty() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail("A");
        linkedList.insertAtTail("B");
        linkedList.insertAtTail("C");

        // Building expected output
        // 1. Create all 3 nodes
        TwoWayNode<String> node1 = new TwoWayNode<>("A");
        TwoWayNode<String> node2 = new TwoWayNode<>("B");
        TwoWayNode<String> node3 = new TwoWayNode<>("C");

        // 2. Link by next node
        node1.insertAfter(node2);
        node2.insertAfter(node3);

        // 3. Link by prev node
        node2.insertBefore(node1);
        node3.insertBefore(node2);

        assertEquals(node1, linkedList.getHeadOfList());
        assertEquals(nodeListAsString(node1), linkedList.toString());
        assertEquals(3, linkedList.getListLength());
    }

    // -----------------------------------------------------------
    // getTailOfList (Given)
    // -----------------------------------------------------------

    /**
     * Testing {@link ILinkedList#getTailOfList()} and checking that it returns {@code null} when the list is empty.
     */
    @Test
    public void testGetTailOfListEmpty() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        assertNull(linkedList.getTailOfList());
        assertEquals(EMPTY_LIST.toString(), linkedList.toString());
        assertEquals(0, linkedList.getListLength());
    }

    /**
     * Testing {@link ILinkedList#getTailOfList()} and checking we have the correct node when the list is not empty.
     */
    @Test
    public void testGetTailOfListNonEmpty() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail("A");
        linkedList.insertAtTail("B");
        linkedList.insertAtTail("C");

        // Building expected output
        // 1. Create all 3 nodes
        TwoWayNode<String> node1 = new TwoWayNode<>("A");
        TwoWayNode<String> node2 = new TwoWayNode<>("B");
        TwoWayNode<String> node3 = new TwoWayNode<>("C");

        // 2. Link by next node
        node1.insertAfter(node2);
        node2.insertAfter(node3);

        // 3. Link by prev node
        node2.insertBefore(node1);
        node3.insertBefore(node2);

        assertEquals(node3, linkedList.getTailOfList());
        assertEquals(nodeListAsString(node1), linkedList.toString());
        assertEquals(3, linkedList.getListLength());
    }

    // -----------------------------------------------------------
    // isEmpty (Given)
    // -----------------------------------------------------------

    /**
     * Testing {@link ILinkedList#isEmpty()} and checking that it returns {@code true} when the list is empty.
     */
    @Test
    public void testIsEmptyListEmpty() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        assertTrue(linkedList.isEmpty());
        assertEquals(EMPTY_LIST.toString(), linkedList.toString());
        assertEquals(0, linkedList.getListLength());
    }

    /**
     * Testing {@link ILinkedList#isEmpty()} and checking that it returns {@code false} when the list is not empty.
     */
    @Test
    public void testIsEmptyListNonEmpty() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail("A");
        linkedList.insertAtTail("B");
        linkedList.insertAtTail("C");

        // Building expected output
        // 1. Create all 3 nodes
        TwoWayNode<String> node1 = new TwoWayNode<>("A");
        TwoWayNode<String> node2 = new TwoWayNode<>("B");
        TwoWayNode<String> node3 = new TwoWayNode<>("C");

        // 2. Link by next node
        node1.insertAfter(node2);
        node2.insertAfter(node3);

        // 3. Link by prev node
        node2.insertBefore(node1);
        node3.insertBefore(node2);

        assertFalse(linkedList.isEmpty());
        assertEquals(nodeListAsString(node1), linkedList.toString());
        assertEquals(3, linkedList.getListLength());
    }

    // -----------------------------------------------------------
    // getListLength (Given)
    // -----------------------------------------------------------

    /**
     * Testing {@link ILinkedList#getListLength()} and checking that it returns {@code 0} when the list is empty.
     */
    @Test
    public void testGetListLengthEmpty() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        assertEquals(EMPTY_LIST.toString(), linkedList.toString());
        assertEquals(0, linkedList.getListLength());
    }

    /**
     * Testing {@link ILinkedList#getListLength()} and checking that it returns {@code 3} when the list has 3 items.
     */
    @Test
    public void testGetListLengthNonEmpty() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail("A");
        linkedList.insertAtTail("B");
        linkedList.insertAtTail("C");

        // Building expected output
        // 1. Create all 3 nodes
        TwoWayNode<String> node1 = new TwoWayNode<>("A");
        TwoWayNode<String> node2 = new TwoWayNode<>("B");
        TwoWayNode<String> node3 = new TwoWayNode<>("C");

        // 2. Link by next node
        node1.insertAfter(node2);
        node2.insertAfter(node3);

        // 3. Link by prev node
        node2.insertBefore(node1);
        node3.insertBefore(node2);

        assertEquals(nodeListAsString(node1), linkedList.toString());
        assertEquals(3, linkedList.getListLength());
    }

    @Test
    public void testInsertAtHeadEmptyList() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtHead("A");
        assertEquals("[A]", list.toString());
        assertEquals(1, list.getListLength());
    }

    @Test
    public void testInsertAtHeadNonEmptyList() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtHead("B");
        list.insertAtHead("A");
        assertEquals("[A, B]", list.toString());
        assertEquals(2, list.getListLength());
    }

    @Test
    public void testInsertAtTailEmptyList() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        assertEquals("[A]", list.toString());
        assertEquals(1, list.getListLength());
    }

    @Test
    public void testInsertAtTailNonEmptyList() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        assertEquals("[A, B]", list.toString());
        assertEquals(2, list.getListLength());
    }


    @Test
    public void testClearListEmpty() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.clearList();
        assertEquals("[]", list.toString());
        assertEquals(0, list.getListLength());
    }

    @Test
    public void testClearListNonEmpty() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtHead("A");
        list.insertAtTail("B");
        list.clearList();
        assertEquals("[]", list.toString());
        assertEquals(0, list.getListLength());
    }


    @Test
    public void testFindFirstOccurrenceNodeFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        TwoWayNode<String> node = list.findFirstOccurrenceNode("B");
        assertNotNull(node);
        assertEquals("B", node.getDataVal());
    }

    @Test
    public void testFindFirstOccurrenceNodeNotFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        TwoWayNode<String> node = list.findFirstOccurrenceNode("C");
        assertNull(node);
    }


    @Test
    public void testFindLastOccurrenceNodeFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertAtTail("A");
        TwoWayNode<String> node = list.findLastOccurrenceNode("A");
        assertNotNull(node);
        assertEquals("A", node.getDataVal());
    }

    @Test
    public void testFindLastOccurrenceNodeNotFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        TwoWayNode<String> node = list.findLastOccurrenceNode("C");
        assertNull(node);
    }


    @Test
    public void testReplaceFirstOccurrenceNodeFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.replaceFirstOccurrenceNode("A", "C");
        assertEquals("[C, B]", list.toString());
    }

    @Test
    public void testReplaceFirstOccurrenceNodeNotFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.replaceFirstOccurrenceNode("C", "D");
        assertEquals("[A, B]", list.toString());
    }


    @Test
    public void testReplaceLastOccurrenceNodeFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.replaceLastOccurrenceNode("B", "C");
        assertEquals("[A, C]", list.toString());
    }

    @Test
    public void testReplaceLastOccurrenceNodeNotFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.replaceLastOccurrenceNode("C", "D");
        assertEquals("[A, B]", list.toString());
    }


    @Test
    public void testInsertAfterFirstOccurrenceEmptyList() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAfterFirstOccurrence("A", "B");
        assertEquals("[]", list.toString());
    }

    @Test
    public void testInsertAfterFirstOccurrenceHead() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAfterFirstOccurrence("A", "B");
        assertEquals("[A, B]", list.toString());
    }

    @Test
    public void testInsertAfterFirstOccurrenceTail() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertAfterFirstOccurrence("B", "C");
        assertEquals("[A, B, C]", list.toString());
    }

    @Test
    public void testInsertAfterFirstOccurrenceMiddle() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertAtTail("C");
        list.insertAfterFirstOccurrence("B", "D");
        assertEquals("[A, B, D, C]", list.toString());
    }


    @Test
    public void testInsertAfterLastOccurrenceEmptyList() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAfterLastOccurrence("A", "B");
        assertEquals("[]", list.toString());
    }

    @Test
    public void testInsertAfterLastOccurrenceHead() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertAfterLastOccurrence("A", "C");
        assertEquals("[A, C, B]", list.toString());
    }

    @Test
    public void testInsertAfterLastOccurrenceTail() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertAfterLastOccurrence("B", "C");
        assertEquals("[A, B, C]", list.toString());
    }

    @Test
    public void testInsertAfterLastOccurrenceMiddle() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertAtTail("C");
        list.insertAfterLastOccurrence("B", "D");
        assertEquals("[A, B, D, C]", list.toString());
    }


    @Test
    public void testInsertBeforeFirstOccurrenceEmptyList() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertBeforeFirstOccurrence("A", "B");
        assertEquals("[]", list.toString());
    }

    @Test
    public void testInsertBeforeFirstOccurrenceHead() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertBeforeFirstOccurrence("A", "B");
        assertEquals("[B, A]", list.toString());
    }

    @Test
    public void testInsertBeforeFirstOccurrenceTail() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertBeforeFirstOccurrence("B", "C");
        assertEquals("[A, C, B]", list.toString());
    }

    @Test
    public void testInsertBeforeFirstOccurrenceMiddle() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertAtTail("C");
        list.insertBeforeFirstOccurrence("B", "D");
        assertEquals("[A, D, B, C]", list.toString());
    }


    @Test
    public void testInsertBeforeLastOccurrenceEmptyList() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertBeforeLastOccurrence("A", "B");
        assertEquals("[]", list.toString());
    }

    @Test
    public void testInsertBeforeLastOccurrenceHead() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertBeforeLastOccurrence("A", "B");
        assertEquals("[B, A]", list.toString());
    }

    @Test
    public void testInsertBeforeLastOccurrenceTail() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertBeforeLastOccurrence("B", "C");
        assertEquals("[A, C, B]", list.toString());
    }

    @Test
    public void testInsertBeforeLastOccurrenceMiddle() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertAtTail("C");
        list.insertBeforeLastOccurrence("B", "D");
        assertEquals("[A, D, B, C]", list.toString());
    }


    @Test
    public void testRemoveFirstOccurrenceNodeFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.removeFirstOccurrenceNode("A");
        assertEquals("[B]", list.toString());
    }

    @Test
    public void testRemoveFirstOccurrenceNodeNotFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.removeFirstOccurrenceNode("C");
        assertEquals("[A, B]", list.toString());
    }


    @Test
    public void testRemoveLastOccurrenceNodeFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.insertAtTail("A");
        list.removeLastOccurrenceNode("A");
        assertEquals("[A, B]", list.toString());
    }

    @Test
    public void testRemoveLastOccurrenceNodeNotFound() {
        ILinkedList<String> list = new DoublyLinkedList<>();
        list.insertAtTail("A");
        list.insertAtTail("B");
        list.removeLastOccurrenceNode("C");
        assertEquals("[A, B]", list.toString());
    }


    @Test
    public void testFindMin() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail("B");
        linkedList.insertAtTail("C");
        linkedList.insertAtTail("A");

        assertEquals("A", MoreListMethods.findMin(linkedList));
    }

    @Test
    public void testFindMax() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail("A");
        linkedList.insertAtTail("C");
        linkedList.insertAtTail("B");

        assertEquals("C", MoreListMethods.findMax(linkedList));
    }

    @Test
    public void testFindMiddleNodeOdd() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail("A");
        linkedList.insertAtTail("B");
        linkedList.insertAtTail("C");

        assertEquals("B", MoreListMethods.findMiddleNode(linkedList).getDataVal());
    }

    @Test
    public void testFindMiddleNodeEven() {
        ILinkedList<String> linkedList = new DoublyLinkedList<>();
        linkedList.insertAtTail("A");
        linkedList.insertAtTail("B");
        linkedList.insertAtTail("C");
        linkedList.insertAtTail("D");

        String middleNode = MoreListMethods.findMiddleNode(linkedList).getDataVal();
        assertTrue(middleNode.equals("B") || middleNode.equals("C"));
    }

    @Test
    public void testCreateDuplicateList() {
        ILinkedList<String> originalList = new DoublyLinkedList<>();
        originalList.insertAtTail("A");
        originalList.insertAtTail("B");
        originalList.insertAtTail("C");

        ILinkedList<String> duplicateList = MoreListMethods.createDuplicateList(originalList);

        assertEquals(originalList.toString(), duplicateList.toString());

        originalList.insertAtTail("D");
        assertNotEquals(originalList.toString(), duplicateList.toString());
    }

    @Test
    public void testConcatenateLists() {
        ILinkedList<String> list1 = new DoublyLinkedList<>();
        list1.insertAtTail("A");
        list1.insertAtTail("B");

        ILinkedList<String> list2 = new DoublyLinkedList<>();
        list2.insertAtTail("C");
        list2.insertAtTail("D");

        ILinkedList<String> concatenatedList = MoreListMethods.concatenateLists(list1, list2);

        assertEquals("[A, B, C, D]", concatenatedList.toString());

        list1.insertAtTail("E");
        list2.insertAtTail("F");
        assertNotEquals(concatenatedList.toString(), list1.toString());
        assertNotEquals(concatenatedList.toString(), list2.toString());
    }

    @Test
    public void testMergeSortedLists() {
        ILinkedList<String> sortedList1 = new DoublyLinkedList<>();
        sortedList1.insertAtTail("A");
        sortedList1.insertAtTail("C");

        ILinkedList<String> sortedList2 = new DoublyLinkedList<>();
        sortedList2.insertAtTail("B");
        sortedList2.insertAtTail("D");

        ILinkedList<String> mergedList = MoreListMethods.mergeSortedLists(sortedList1, sortedList2);

        assertEquals("[A, B, C, D]", mergedList.toString());

        sortedList1.insertAtTail("E");
        sortedList2.insertAtTail("F");
        assertNotEquals(mergedList.toString(), sortedList1.toString());
        assertNotEquals(mergedList.toString(), sortedList2.toString());
    }

    @Test
    public void testReverseList() {
        ILinkedList<String> originalList = new DoublyLinkedList<>();
        originalList.insertAtTail("A");
        originalList.insertAtTail("B");
        originalList.insertAtTail("C");

        ILinkedList<String> reversedList = MoreListMethods.reverseList(originalList);

        assertEquals("[C, B, A]", reversedList.toString());

        originalList.insertAtTail("D");
        assertNotEquals(originalList.toString(), reversedList.toString());
    }

}