public interface ILinkedList<T>
{
    void Add(T item);
    boolean Remove(T item);
    boolean Remove(int index);
    T GetNode(int index);
    void PrintList();
    int Count();
}
