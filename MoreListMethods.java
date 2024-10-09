/*
 * MoreListMethods.java
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

/**
 * <p>
 * This class provides more helpful methods for {@link ILinkedList}. Note that you don't have direct access to the
 * private data in {@link DoublyLinkedList}, so you will have to use the methods from the interface to complete this
 * class!
 * </p>
 *
 * @version 2.0
 */
public class MoreListMethods {

    // ===========================================================
    // Public Methods
    // ===========================================================

    // This method returns the smallest element in the list
    // HINT: Use the "compareTo" method!
    public static String findMin(ILinkedList<String> l) {
        if (l.isEmpty()) {
            return null;
        }

        TwoWayNode<String> current = l.getHeadOfList();
        String min = current.getDataVal();

        while (current != null) {
            if (current.getDataVal().compareTo(min) < 0) {
                min = current.getDataVal();
            }
            current = current.getNext();
        }
        return min;
    }


    // This method returns the smallest element in the list
    // HINT: Use the "compareTo" method!
    public static String findMax(ILinkedList<String> l) {
        if (l.isEmpty()) {
            return null;
        }

        TwoWayNode<String> current = l.getHeadOfList();
        String max = current.getDataVal();

        while (current != null) {
            if (current.getDataVal().compareTo(max) > 0) {
                max = current.getDataVal(); // Update max if current node has larger data
            }
            current = current.getNext();
        }
        return max;
    }


    // This method returns the middle node of the list. If the list size is an even number,
    // you may return either middle nodes.
    public static TwoWayNode<String> findMiddleNode(ILinkedList<String> l) {
        if (l.isEmpty()) {
            return null;
        }
        int length = l.getListLength();
        int middleIndex = length / 2;

        TwoWayNode<String> current = l.getHeadOfList();

        for (int i = 0; i < middleIndex; i++) {
            current = current.getNext();
        }
        return current;
    }


    // This method returns a duplicate copy of the list. Note that this problem requires you to make a
    // "deep copy" of all the elements in the list!
    public static ILinkedList<String> createDuplicateList(ILinkedList<String> l) {
        ILinkedList<String> newList = new DoublyLinkedList<>();

        TwoWayNode<String> current = l.getHeadOfList();

        while (current != null) {
            newList.insertAtTail(current.getDataVal());
            current = current.getNext();
        }
        return newList;
    }


    // This method returns a new list that is the concatenation of two lists.
    // Note that this problem requires you to make a "deep copy" of all the elements in both of the list!
    public static ILinkedList<String> concatenateLists(ILinkedList<String> l1, ILinkedList<String> l2) {
        ILinkedList<String> concatenatedList = new DoublyLinkedList<>();

        TwoWayNode<String> current = l1.getHeadOfList();
        while (current != null) {
            concatenatedList.insertAtTail(current.getDataVal());
            current = current.getNext();
        }

        current = l2.getHeadOfList();
        while (current != null) {
            concatenatedList.insertAtTail(current.getDataVal());
            current = current.getNext();
        }

        return concatenatedList;

    }


    // This method returns a new list that merges two sorted lists.
    // Note that this problem requires you to make a "deep copy" of all the elements in both of the list!
    public static ILinkedList<String> mergeSortedLists(ILinkedList<String> l1, ILinkedList<String> l2) {
        ILinkedList<String> mergedList = new DoublyLinkedList<>();

        TwoWayNode<String> node1 = l1.getHeadOfList();
        TwoWayNode<String> node2 = l2.getHeadOfList();

        while (node1 != null && node2 != null) {
            if (node1.getDataVal().compareTo(node2.getDataVal()) <= 0) {
                mergedList.insertAtTail(node1.getDataVal());
                node1 = node1.getNext();
            } else {
                mergedList.insertAtTail(node2.getDataVal());
                node2 = node2.getNext();
            }
        }

        // Insert the rest of the nodes into the list
        while (node1 != null) {
            mergedList.insertAtTail(node1.getDataVal());
            node1 = node1.getNext();
        }
        while (node2 != null) {
            mergedList.insertAtTail(node2.getDataVal());
            node2 = node2.getNext();
        }

        return mergedList;
    }



    // This method returns a new list that is the reverse of the original list
    // Note that this problem requires you to make a "deep copy" of all the elements in the list!
    public static ILinkedList<String> reverseList(ILinkedList<String> origList) {
        ILinkedList<String> reversedList = new DoublyLinkedList<>();

        TwoWayNode<String> current = origList.getHeadOfList();

        while (current != null) {
            reversedList.insertAtHead(current.getDataVal());
            current = current.getNext();
        }

        return reversedList;
    }
}