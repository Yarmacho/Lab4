public class DoubleLinkedList<T> implements ILinkedList<T>
{
    DoubleNode<T> firstNode;

    @Override
    public void Add(T item) {
        if (firstNode == null)
        {
            firstNode = new DoubleNode<>(item);
            return;
        }
        else if (firstNode.NextNode == null)
        {
            firstNode.NextNode = new DoubleNode<>(item);
            firstNode.NextNode.PreviousNode = firstNode;
            return;
        }

        var tmpNode = firstNode;
        for (; tmpNode.NextNode != null; tmpNode = tmpNode.NextNode);

        tmpNode.NextNode = new DoubleNode<>(item);
        tmpNode.NextNode.PreviousNode = tmpNode;
    }

    @Override
    public boolean Remove(T item) {
        if (firstNode == null)
        {
            return false;
        }
        if (firstNode.Value == item)
        {
            firstNode = firstNode.NextNode;
            return true;
        }

        for (var tmpNode = firstNode; tmpNode != null; tmpNode = tmpNode.NextNode)
        {
            if (tmpNode.Value == item)
            {
                tmpNode.PreviousNode.NextNode = tmpNode.NextNode;
                tmpNode.NextNode.PreviousNode = tmpNode.PreviousNode;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean Remove(int index) {
        if (index < 0 || index >= Count())
        {
            return false;
        }
        if (index == 0)
        {
            firstNode = firstNode.NextNode;
            return true;
        }

        var tmpNode = firstNode;
        for (int i = 0; i < index; i++)
        {
            tmpNode = tmpNode.NextNode;
        }

        tmpNode.PreviousNode.NextNode = tmpNode.NextNode;
        tmpNode.NextNode.PreviousNode = tmpNode.PreviousNode;
        return true;
    }

    @Override
    public T GetNode(int index) {
        if (index < 0 || index >= Count())
        {
            throw new IndexOutOfBoundsException();
        }

        var tmpNode = firstNode;
        for (int i = 0; i < index; i++)
        {
            tmpNode = tmpNode.NextNode;
        }

        return tmpNode.Value;
    }

    @Override
    public void PrintList() {
        System.out.println();
        for (var tmpNode = firstNode; tmpNode != null; tmpNode = tmpNode.NextNode)
        {
            System.out.printf("%s ", tmpNode.Value.toString());
        }
        System.out.println();
    }

    @Override
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

    private class DoubleNode<T> extends Node<T>
    {
        public DoubleNode<T> NextNode;
        public DoubleNode<T> PreviousNode;

        public DoubleNode(T value) {
            PreviousNode = null;
            NextNode = null;
            Value = value;
        }
    }
}
