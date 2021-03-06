public class DoubleLinkedList<T> extends LinkedList<T> implements ILinkedList<T>
{
    @Override
    public void Add(T item) {
        if (firstNode == null)
        {
            firstNode = createNode(item);
            return;
        }
        else if (firstNode.NextNode == null)
        {
            firstNode.NextNode = createNode(item);
            firstNode.NextNode.PreviousNode = firstNode;
            return;
        }

        var tmpNode = firstNode;
        for (; tmpNode.NextNode != null; tmpNode = tmpNode.NextNode);

        tmpNode.NextNode = createNode(item);
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
}
