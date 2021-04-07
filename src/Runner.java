public class Runner
{
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        list.Add(1);
        list.Add(2);
        list.Add(3);
        list.Add(4);
        list.Add(5);
        list.Add(6);
        list.Add(7);
        list.Add(8);

        list.PrintList();
        list.TaskA(2);
        list.PrintList();

        var swapped = swapEveryThreeElements(list);

        swapped.PrintList();

        var doubleLinkedList = new DoubleLinkedList<Integer>();
        doubleLinkedList.Add(10);
        doubleLinkedList.Add(11);
        doubleLinkedList.Add(12);
        doubleLinkedList.Add(13);
        doubleLinkedList.Add(14);

        System.out.println();
        System.out.println("Double Linked List");
        doubleLinkedList.PrintList();
        doubleLinkedList.Remove((Integer)12);
        doubleLinkedList.PrintList();
    }

    private static <T> ILinkedList<T> swapEveryThreeElements(ILinkedList<T> list)
    {
        var res = new SingleLinkedList<T>();

        var length = list.Count();
        for (int i = 0; i < length; i += 3)
        {
            if (i + 3 <= length)
            {
                res.Add(list.GetNode(i + 2));
                res.Add(list.GetNode(i + 1));
                res.Add(list.GetNode(i));
            }
        }

        if (res.Count() < list.Count())
        {
            for (int i = res.Count(); i < length; i++)
            {
                res.Add(list.GetNode(i));
            }
        }

        return res;
    }
}
