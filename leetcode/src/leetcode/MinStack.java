package leetcode;
import java.util.*;

public class MinStack {
	public Stack<Integer> stack;
    private int minValue = Integer.MAX_VALUE;
    public Stack<Integer> min_stack;
    //public int stack_size = 0;
    public Stack<Integer> min_stack_index;
    
    MinStack() {
        stack = new Stack<Integer>();
        min_stack = new Stack<Integer>();
        min_stack_index = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (x < minValue) {
        	min_stack.push(x);
        	min_stack_index.push(stack.size() - 1);
        	minValue = x;
        }
    }

    public void pop() {
        int value = stack.peek();
        if (value == minValue && (stack.size() - 1) == min_stack_index.peek()) {
            min_stack.pop();
            min_stack_index.pop();
            minValue = min_stack.peek();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] num = {-1, 0, 1, 2, -1, -4};
    	MinStack s = new MinStack();
    	s.push(2);
    	s.push(0);
    	s.push(3);
    	s.push(0);
    	System.out.println(s.stack);
    	//getMin,pop,getMin,pop,getMin,pop,getMin
    	System.out.println(s.min_stack);
    	System.out.println(s.getMin());
    	s.pop();
    	System.out.println(s.stack);
    	System.out.println(s.min_stack);
    	System.out.println(s.getMin());
    	s.pop();
    	System.out.println(s.stack);
    	System.out.println(s.min_stack);
    	System.out.println(s.getMin());
    	System.out.println(s.min_stack_index);
    	s.pop();
    	System.out.println(s.stack);
    	System.out.println(s.min_stack);
    	System.out.println(s.getMin());
	}
}
