package A1;

public class LinkedList<E> { // singly linked list with header, and generic element type E

    private static class Node<E> { // -------- nested node class ---------
        private E element;       // field
        private Node<E> next;    // field

        public Node(E e)         // constructor
        {
            element = e;
            next = null;
        }
    } // ------------------------------------- end of nested class -------

     // field: head of linked list

    public static void main(String[] args) {
        Node head = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        Node f = new Node(5);
        Node g = new Node(6);
//        Node h = new Node(7);
//        Node i = new Node(8);
        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
//        g.next = h;
//        h.next = i;

        Node p = head;
        if (p == null)  System.out.println("NULL");
        Node q = p;
        while (q != null && q.next != null) {
            q = q.next.next;
            p = p.next;
        }
        System.out.println(p.element);


    }

}
