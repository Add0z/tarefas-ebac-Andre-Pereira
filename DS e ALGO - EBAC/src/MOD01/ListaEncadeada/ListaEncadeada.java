package MOD01.ListaEncadeada;

public class ListaEncadeada {
    private Node head;

    public ListaEncadeada(){
        this.head = null;
    }

    public void push(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public Node pop() {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            Node node = head;
            head = null;
            return node;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            Node node = current.next;
            current.next = null;
            return node;
        }
    }

    public void insert(int index, Node node) {
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current.next != null) {
                    current = current.next;
                } else {
                    throw new IndexOutOfBoundsException("Index out of range");
                }
            }
            node.next = current.next;
            current.next = node;
        }
    }

    public void remove(int index) {
        if (index == 0) {
            if (head != null) {
                head = head.next;
            } else {
                throw new IndexOutOfBoundsException("Index out of range");
            }
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current.next != null) {
                    current = current.next;
                } else {
                    throw new IndexOutOfBoundsException("Index out of range");
                }
            }
            if (current.next != null) {
                current.next = current.next.next;
            } else {
                throw new IndexOutOfBoundsException("Index out of range");
            }
        }
    }

    public Node elementAt(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current != null) {
                current = current.next;
            } else {
                throw new IndexOutOfBoundsException("Index out of range");
            }
        }
        if (current != null) {
            return current;
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }


    public void printList() {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 4);
        }
        System.out.println(sb.toString());
    }
}
