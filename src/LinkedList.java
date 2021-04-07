public abstract class LinkedList<T>
{
    protected Node<T> firstNode;

    public void PrintList() {
        System.out.println();
        for (var tmpNode = firstNode; tmpNode != null; tmpNode = tmpNode.NextNode)
        {
            System.out.printf("%s ", tmpNode.Value.toString());
        }
        System.out.println();
    }

    public int Count()
    {
        if (firstNode == null)
        {
            return 0;
        }
        var counter = 1;

        var tmpNode = firstNode;
        while ((tmpNode = tmpNode.NextNode) != null)
        {
            counter++;
        }

        return counter;
    }

    protected Node<T> createNode(T value)
    {
        return new ListNode<T>(value);
    }

    private class ListNode<T> extends Node<T>
    {
        public ListNode(T value)
        {
            Value = value;
        }
    }
}
