package com.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: hataki
 * @Date: 2020/8/25
 * Time: 16:36
 * description:
 */
public class SteamTest {

    public static void main(String[] args) {
//        generate();

        /**
         * 输出流求偶数的个数  和  sum和
         */
        long count = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).count();
        System.out.println("count = " + count);
        long sum = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println("count = " + sum);
        /**
         * 求最大值
         * max((a, b) -> a - b) 相当于 传入一个表达式a-b和0作比较，如果a-b大于0说明a比b大，反之亦然；
         */
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
//        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        Optional<Integer> max = list.stream().max(Comparator.comparingInt(a -> a));
        System.out.println("max = " + max.get());

        Optional<Integer> min = list.stream().max((a, b) -> b-a);
        System.out.println("min = " + min.get());

        System.out.println("-----------------------------");

        /**
         * 不使用min,max进行比较（使用sorted）
         * 自然排序；
         * 取最大值，进行自定义comparator
         */
        Optional<Integer> min2 = list.stream().sorted().findFirst();
        System.out.println("min2 = " + min2.get());
        Optional<Integer> max2 = list.stream().sorted((a,b)->b-a).findFirst();
        System.out.println("max2 = " + max2.get());

        /**
         * 将集合中的对象过滤并返回一个集合
         *
         */
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("*****************************");
        String str = "11,22,33,44,55,66" ;
        System.out.println(Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println(Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println(Stream.of(str.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());

        /**
         * 创建一组自定义对象
         */
        String str2 = "java,scala,pyhton" ;
        Stream.of(str2.split(",")).map(x -> new Person(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::new ).forEach(System.out::println);
        Stream.of(str2.split(",")).map(x -> Person.build(x)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);

        /**
         * 将str中的每一个数值打印，同时计算最终求和结果
         */
        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());
        System.out.println(list.stream().allMatch(x -> x >= 0));

    }

    public static void generate(){

        /**
         * generate()方法里面是一个supplier
         */
        Stream<Integer> gen = Stream.generate(()->{
            int i = 0 ;
            System.out.println(i++);
            return i ;
        });
        gen.limit(11).forEach(System.out::println);

        /**
         * 迭代器循环输出
         * iterate(final T seed, final UnaryOperator<T> f)
         * UnaryOperator 输入输出相同类型
         */
        Stream<Integer> iterator = Stream.iterate(1, (x) -> x + 1);
        iterator.limit(11).forEach(System.out::println);
    }
}
