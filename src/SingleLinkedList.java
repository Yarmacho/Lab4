public class SingleLinkedList<T> extends LinkedList<T> implements ILinkedList<T>
{
    @Override
    public void Add(T item) {
        if (firstNode == null)
        {
            firstNode = createNode(item);
            return;
        }

        var tmpNode = firstNode;
        for ( ;tmpNode.NextNode != null; tmpNode = tmpNode.NextNode);

        tmpNode.NextNode =  createNode(item);
    }

    @Override
    public boolean Remove(T item) {
        if (firstNode == null)
        {
            return false;
        }
        if (item == firstNode.Value)
        {
            firstNode = firstNode.NextNode;
            return true;
        }

        Node<T> prevNode = null;
        for (var tmpNode = firstNode; tmpNode != null; tmpNode = tmpNode.NextNode)
        {
            if (tmpNode.Value == item)
            {
                prevNode.NextNode = tmpNode.NextNode;
                return true;
            }

            prevNode = tmpNode;
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
        for (int i = 0; i < index - 1; i++)
        {
            tmpNode = tmpNode.NextNode;
        }

        tmpNode.NextNode = tmpNode.NextNode.NextNode;
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

    public void TaskA(T value)
    {
        var prevNode = firstNode;
        if (firstNode != value)
        {
            var currNode = firstNode;

            for (; currNode != null; currNode = currNode.NextNode)
            {
                if (currNode.Value == value)
                {
                    prevNode.NextNode = currNode.NextNode;
                    break;
                }

                prevNode = currNode;
            }
        }
        else
        {
            firstNode = firstNode.NextNode;
            prevNode = firstNode;
        }

        if (prevNode.NextNode == null || prevNode.NextNode.NextNode == null)
        {
            throw new NullPointerException("Невозможно перемешать следущие два елемента потому как их нет");
        }
        else
        {
            // Запоминаем елемент, что стоит после двух что перемешиваются
            var elementAfter = prevNode.NextNode.NextNode.NextNode;

            // Перемешиваем два елемента
            var tmpValue = prevNode.NextNode;
            prevNode.NextNode = prevNode.NextNode.NextNode;
            prevNode.NextNode.NextNode = createNode(tmpValue.Value);

            prevNode.NextNode.NextNode.NextNode  = elementAfter;
        }
    }
}
