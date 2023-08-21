import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestJava8 {

    /**
     * Lambda表达式示例
     */
    @Test
    public void testLambda(){
        List<String> names = Arrays.asList("Alice", "Qcc", "Bob", "Charlie");
        // 使用Lambda表达式对列表进行排序
        Collections.sort(names,String::compareTo);
        // 使用Lambda表达式遍历列表
        names.forEach(name -> System.out.println(name));
    }

    /**
     * 函数式接口示例
     */
    @FunctionalInterface
    interface Calculator {
        int calculate(int a, int b);
    }

    @Test
    public void fuctionInterface(){
        // 使用函数式接口进行加法运算
        Calculator addition = (a, b) -> a + b;
        int result = addition.calculate(5, 3); // 结果为8
        System.out.println("result = " + result);
    }

    /**
     * 方法引用示例
     */
    @Test
    public void testMethodReference(){
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        // 使用方法引用对列表进行排序
        Collections.sort(names, String::compareToIgnoreCase);
        // 使用方法引用遍历列表
        names.forEach(System.out::println);
    }

    /**
     * Stream API示例
     */
    @Test
    public void testStream(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // 使用Stream API对列表进行过滤和映射
        List<Integer> squaredNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        // 使用Stream API计算列表中的元素总和
        int sum = numbers.stream()
                        .reduce(0, (a, b) -> a + b);
        System.out.println("sum = " + sum);
        System.out.println("squaredNumbers = " + squaredNumbers);
    }
}
