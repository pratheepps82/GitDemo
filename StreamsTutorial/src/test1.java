import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {

@Test
public void regular() {
		ArrayList<String> names =new ArrayList<String>();
		names.add("pratheep");
		names.add("Ambika");
		names.add("Amma");
		names.add("Appa");
		names.add("son");
		names.add("daughter");
		int count=0;
for(int i=0;i<names.size();i++)
{
	String name=names.get(i);
	if(name.startsWith("A"))
	{
		count++;
	}
	System.out.println(count);
}
		
	}
@Test
public void StreamsFilter() {
	ArrayList<String> names =new ArrayList<String>();
	names.add("pratheep");
	names.add("Ambika");
	names.add("Amma");
	names.add("Appa");
	long s=names.stream().filter(a ->a.startsWith("A")).count();
	System.out.println(s);
	
	long f=Stream.of("pratheep","Ambika","Amma","Appa").filter(fs ->fs.startsWith("A")).count();
	System.out.println(f);
	
	//print all the names of arraylist
	names.stream().filter(s1->s1.length()>4).forEach(s1->System.out.println(s1));
	names.stream().filter(sl1->sl1.length()>4).limit(2).forEach(sl1->System.out.println(sl1));
	
}
@Test
public void streamMap() {
	//print names of length>4 with uppercase
	Stream.of("Pratheep","Ambika","Nitheesh","Taarini","Amma","Appa").filter(a->a.endsWith("a")).map(a->a.toUpperCase())
	.forEach(a->System.out.println(a));
	
	//print names which have first letter as a with uppercase and sorted
	Stream.of("APratheep","Ambika","Nitheesh","Taarini","Amma","Appa").filter(b->b.startsWith("A")).sorted().map(b->b.toUpperCase())
	.forEach(b->System.out.println(b));
	
	List<String> names2=Arrays.asList("APratheep","Ambika","Nitheesh","Taarini","Amma","Appa");
	
	ArrayList<String> names1 =new ArrayList<String>();
	names1.add("Senthur");
	names1.add("Nandhini");
	names1.add("Kala");
	names1.add("Panneer");
	Stream<String> newStream =Stream.concat(names2.stream(), names1.stream());
	//newStream.sorted().forEach(s->System.out.println(s));
	boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Taarini"));
	System.out.println(flag);
	Assert.assertTrue(flag);
	
}
@Test
public void StreamCollect() {
	
	List<String> ls=Stream.of("APratheep","Ambika","Nitheesh","Taarini","Amma","Appa").filter(b->b.startsWith("A")).sorted().map(b->b.toUpperCase())
			.collect(Collectors.toList());
	System.out.println(ls.get(0));
	
	List<Integer> values =Arrays.asList(3,2,2,6,6,3,4,4,5,7,1);
	//print unique number for this array
	//sort the array and print 3rd index
	values.stream().distinct().forEach(s->System.out.println(s));
	List<Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
	System.out.println(li);
	System.out.println(li.get(5));
	
}
}
