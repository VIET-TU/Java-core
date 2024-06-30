package lambdaExpression;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Predicate;

@FunctionalInterface
interface MyFunction<T> {
    T accept(int num);
}

class MyUtils {
    public  int add(int a, int b) {
        return a + b;
    }
 
    public  int minus(int a, int b) {
        return 1;
    }

}

public class lambda {
	
	private String name;
    private int exp;
 
    public lambda(String name, int age) {
        super();
        this.name = name;
        this.exp = age;
    }
 
    public String getName() {
        return name;
    }
 
    public  int getExp() {
        return exp;
    }

	 public static void main(String args[]) {

	     
	            Integer []numbers = {1, 8, 3, 4, 5, 7, 9, 6}; 
	            List<Integer> listOfIntegers = Arrays.asList(numbers);
	     
	            // Max = 9
	            int ma12x2 = listOfIntegers.stream().max(Integer::compare).get();
	            System.out.println(ma12x2);
	            
	            int min = listOfIntegers.stream()
	                    .mapToInt(v -> v)
	                    .min()
	                    .getAsInt(); 
	            
	            List<lambda> students1 = Arrays.asList( //
	                    new lambda("Java", 5), //
	                    new lambda("PHP", 2), //
	                    new lambda("C#", 1) //
	            );
//	            students1.stream().flat
	            
	            
  
	            // Max = 5
	            int maxByExp = students1.stream()
	                    .map(v -> v.getExp()).max(Integer::compare).get();
	            System.out.println(maxByExp);
	            Stream<Object> maxByExp8 = students1.stream()
	                    .map(v -> v.getExp());
	            maxByExp8.forEach(s -> System.out.println("lalal   " +s));
	            
	            Stream<lambda> maxByExp7 = students1.stream()
	                    .filter(v -> v.getExp() > 0);
	           maxByExp7.forEach(s -> System.out.println("lalal   " +s.getName()));
	            
	            int maxByExp2 = students1.stream()
	                    .mapToInt(v -> v.getExp()).max().getAsInt();
	            System.out.println(maxByExp);
	             
	            // Min = 1
	            int minByExp = students1.stream()
	            		.flatMapToInt(v -> IntStream.of(v.getExp()))
	                    .min()
	                    .getAsInt(); 
	            int max4 = students1.stream()
	            		.flatMap(v -> Stream.of(v.getExp()))
	            		.max(Integer::compare)
	            		.get();
	            
	            
	            
	            
	            
	            
	            
	            
	         // Chuỗi mã hóa
	            List<String> enscriptLst = Arrays.asList("AABYAJWLZ","DDA"); 
	            List<Object[]> a = enscriptLst.stream().map( s-> Stream.of(s.split("")).distinct().toArray()).distinct().collect(Collectors.toList());
	            
	           a.forEach( v -> System.out.println(Arrays.toString(v)));
	           List <String> enscriptLst1 = Arrays.asList("AABYAJWLZ", "DDA");
	           List <String> enscriptLstAfterRemoveDup = enscriptLst1.stream()
	            .map(s -> s.split(""))
	            .flatMap(s -> Stream.of(s) )
	            .distinct()
	            .collect(Collectors.toList());
	           System.out.println(enscriptLstAfterRemoveDup);
	           
	           List<String[]> lala =  enscriptLst.stream().map( s-> s.split("")).distinct().collect(Collectors.toList());
	           
	           lala.forEach( v -> System.out.println(Arrays.toString(v)));      
	 }



	
	 
}
