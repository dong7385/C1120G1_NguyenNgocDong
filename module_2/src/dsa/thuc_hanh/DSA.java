import java.util.*;

public class DSA {
    public	static	void	main(String[]	args)	{

//        Set<String>set=new TreeSet<>()
//        set.add("VietNam");
//        set.add("London");
//        set.add("Paris");
//        set.add("New	York");
//        set.add("San	Francisco");
//        set.add("Beijing");
//        set.add("New	York");
//        System.out.println(set);
//        for	(String	s:	set)	{
//        System.out.print(s.toUpperCase()	+	"	");
//    }
        List<String> linkedList	=	new	LinkedList<>();
//        List<String> a=new LinkedList<>();
        linkedList.add("New	York");
        linkedList.add("Atlanta");
        linkedList.add("Dallas");
        linkedList.add("Madison");
        ListIterator<String>	listIterator	=	linkedList.listIterator();
        while	(listIterator.hasNext())	{
            System.out.print(listIterator.next()	+	"	");
        }
}
}
