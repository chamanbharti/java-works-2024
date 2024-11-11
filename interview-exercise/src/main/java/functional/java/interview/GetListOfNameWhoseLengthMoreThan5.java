package functional.java.interview;

import java.util.List;
import java.util.stream.Collectors;

public class GetListOfNameWhoseLengthMoreThan5 {
	public static void main(String[] args) {
		List<String>list = List.of("chaman","bharti","rahi","akela","sahil","bharti","aman","bharti","naman","bharti");
		List<String>list1 = list.stream().filter(s->s.length()>=5).collect(Collectors.toList());
		System.out.println(list1);
	}

}
