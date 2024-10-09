/*
 * DoublyLinkedList.java
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

public class DoublyLinkedList<E> extends AbsLinkedList<E> {

    // ===========================================================
    // Class attributes
    // ===========================================================

    private TwoWayNode<E> myHeadNode;
    private TwoWayNode<E> myTailNode;
    private int myListLength;

    // ===========================================================
    // Constructors
    // ===========================================================

    /**
     * <p>
     * This creates a new doubly-linked-list that is initially empty.
     * </p>
     */
    public DoublyLinkedList() {
        // You may modify the constructor if you need to add more
        // private class attributes, but do not alter the following lines.
        myHeadNode = null;
        myTailNode = null;
        myListLength = 0;
    }

    // ===========================================================
    // Public Methods
    // ===========================================================

    public TwoWayNode<E> getHeadOfList() {
        return myHeadNode;
    }


    public TwoWayNode<E> getTailOfList() {
        return myTailNode;
    }


    public void insertAtHead(E newData) {
        TwoWayNode<E> newNode = new TwoWayNode<>(newData, null, myHeadNode);
        if (myHeadNode != null) {
            myHeadNode.insertBefore(newNode);
        }
        myHeadNode = newNode;
        if (myTailNode == null) {
            myTailNode = newNode;
        }
        myListLength++;
    }


    public void insertAtTail(E newData) {
        TwoWayNode<E> newNode = new TwoWayNode<>(newData, myTailNode, null);
        if (myTailNode != null) {
            myTailNode.insertAfter(newNode);
        }
        myTailNode = newNode;
        if (myHeadNode == null) {
            myHeadNode = newNode;
        }
        myListLength++;
    }


    public boolean isEmpty() {
        return myListLength == 0;
    }


    public int getListLength() {
        return myListLength;
    }


    public void clearList() {
        myHeadNode = null;
        myTailNode = null;
        myListLength = 0;
    }


    public TwoWayNode<E> findFirstOccurrenceNode(E searchData) {
        TwoWayNode<E> currentNode = myHeadNode;
        while (currentNode != null) {
            if (currentNode.getDataVal().equals(searchData)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }


    public TwoWayNode<E> findLastOccurrenceNode(E searchData) {
        TwoWayNode<E> currentNode = myTailNode;
        while (currentNode != null) {
            if (currentNode.getDataVal().equals(searchData)) {
                return currentNode;
            }
            currentNode = currentNode.getPrevious();
        }
        return null;
    }


    public void replaceFirstOccurrenceNode(E searchData, E newData) {
        TwoWayNode<E> nodeToReplace = findFirstOccurrenceNode(searchData);
        if (nodeToReplace != null) {
            nodeToReplace.setDataVal(newData);
        }
    }


    public void replaceLastOccurrenceNode(E searchData, E newData) {
        TwoWayNode<E> nodeToReplace = findLastOccurrenceNode(searchData);
        if (nodeToReplace != null) {
            nodeToReplace.setDataVal(newData);
        }
    }


    public void insertAfterFirstOccurrence(E searchData, E newData) {
        TwoWayNode<E> node = findFirstOccurrenceNode(searchData);
        if (node != null) {
            TwoWayNode<E> newNode = new TwoWayNode<>(newData, node, node.getNext());
            if (node.getNext() != null) {
                node.getNext().insertBefore(newNode);
            } else {
                myTailNode = newNode;
            }
            node.insertAfter(newNode);
            myListLength++;
        }
    }


    public void insertAfterLastOccurrence(E searchData, E newData) {
        TwoWayNode<E> node = findLastOccurrenceNode(searchData);
        if (node != null) {
            TwoWayNode<E> newNode = new TwoWayNode<>(newData, node, node.getNext());
            if (node.getNext() != null) {
                node.getNext().insertBefore(newNode);
            } else {
                myTailNode = newNode;
            }
            node.insertAfter(newNode);
            myListLength++;
        }
    }


    public void insertBeforeFirstOccurrence(E searchData, E newData) {
        TwoWayNode<E> node = findFirstOccurrenceNode(searchData);
        if (node != null) {
            TwoWayNode<E> newNode = new TwoWayNode<>(newData, node.getPrevious(), node);
            if (node.getPrevious() != null) {
                node.getPrevious().insertAfter(newNode);
            } else {
                myHeadNode = newNode;
            }
            node.insertBefore(newNode);
            myListLength++;
        }
    }


    public void insertBeforeLastOccurrence(E searchData, E newData) {
        TwoWayNode<E> node = findLastOccurrenceNode(searchData);
        if (node != null) {
            TwoWayNode<E> newNode = new TwoWayNode<>(newData, node.getPrevious(), node);
            if (node.getPrevious() != null) {
                node.getPrevious().insertAfter(newNode);
            } else {
                myHeadNode = newNode;
            }
            node.insertBefore(newNode);
            myListLength++;
        }
    }


    public TwoWayNode<E> removeFirstOccurrenceNode(E searchData) {
        TwoWayNode<E> node = findFirstOccurrenceNode(searchData);
        if (node != null) {
            removeNodeHelper(node);
            return node;
        }
        return null;
    }


    public TwoWayNode<E> removeLastOccurrenceNode(E searchData) {
        TwoWayNode<E> node = findLastOccurrenceNode(searchData);
        if (node != null) {
            removeNodeHelper(node);
            return node;
        }
        return null;
    }


    private void removeNodeHelper(TwoWayNode<E> node) {
        if (node == myHeadNode) {
            myHeadNode = node.getNext();
        } else {
            node.getPrevious().insertAfter(node.getNext());
        }
        if (node == myTailNode) {
            myTailNode = node.getPrevious();
        } else {
            node.getNext().insertBefore(node.getPrevious());
        }
        myListLength--;
    }
}