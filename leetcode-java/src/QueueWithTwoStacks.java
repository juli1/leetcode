/*
 *  40. Implement Queue by Two Stacks
 *
 * As the title described, you should only use two 
 * stacks to implement a queue's actions.
 *
 * The queue should support push(element), pop() 
 * and top() where pop is pop the first(a.k.a front) 
 * element in the queue.
 *
 * Both pop and top methods should return the 
 * value of first element.
 *
 * Lintcode: http://lintcode.com/en/problem/implement-queue-by-two-stacks/
 * 
 */
import java.util.*;
class MyQueue {
	private Stack<Integer> pushStack;
	private Stack<Integer> popStack;
    public MyQueue() {
        pushStack = new Stack<Integer>();
        popStack = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        pushStack.push(element);
    }

    private void flipPush()
    {
    	if (popStack.size() == 0)
    	{
    		while (pushStack.size() > 0)
    		{
    			popStack.push(pushStack.pop());
    		}
    	}
    }
    
    /*
     * @return: An integer
     */
    public int pop() {
    	this.flipPush();
    	return popStack.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
    	this.flipPush();
    	return popStack.peek();
    }
}

public class QueueWithTwoStacks {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		System.out.println(queue.pop());     // return 1
		queue.push(2);
		queue.push(3);
		System.out.println(queue.top());     // return 2
		System.out.println(queue.pop());     // return 2

	}

}
