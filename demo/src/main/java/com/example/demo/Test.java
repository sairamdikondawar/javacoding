package com.example.demo;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        List<Employee> employees= new ArrayList<Employee>();
        BigDecimal
        OptionalDouble ave = employees.stream().mapToInt(e -> e.salary).average();

    }

    class Employee{
        private Integer salary;

        public void setSalary(int salary)
        { this.salary=salary;

        }

        public Integer getSalary()
        {
            return this.salary;
        }
    }
}
