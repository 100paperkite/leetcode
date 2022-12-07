# Problem

`push`, `pop`, `top`, `getMin` 동작이 `O(1)` 으로 수행되는 스택 구현하기.
빈 스택에 `pop`, `top`, `getMin` 을 수행하지는 않음.

# My Solution

```java
import java.util.Stack;

class MinStack {
    class Node {
        public int value;
        public int minValue;

        public Node(int value, int minValue) {
            this.value=value;
            this.minValue=minValue;
        }
    }

    private Stack<Node> stack = new Stack<Node>();

    public MinStack() {

    }

    public void push(int val) {
        if (this.stack.empty()){
            this.stack.push(new Node(val,val));
        }
        else {
            var prev = this.stack.peek();
            var minValue = Math.min(prev.minValue, val);
            this.stack.push(new Node(val, minValue));
        }
    }

    public void pop() {
        this.stack.pop();
    }

    public int top() {
        return this.stack.peek().value;
    }

    public int getMin() {
        return this.stack.peek().minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```

# Top Rated Solution

진짜 스택을 구현. (4ms)

```java

import java.util.Stack;

class MinStack {
    class Node {
        public int value;
        public int minValue;
        public Node next;

        public Node(int value, int minValue) {
            this.value=value;
            this.minValue=minValue;
            this.next = null;
        }
    }

    private Node head;
    public MinStack() {
    }

    public void push(int val) {
        if (this.empty()){
            this.head = new Node(val, val);
        }
        else {
            var minValue = Math.min(this.head.minValue, val);
            var item = new Node(val, minValue);
            item.next = this.head;
            this.head = item;
        }
    }

    public void pop() {
        this.head = head.next;
    }

    public int top() {
        return this.head.value;
    }

    public int getMin() {
        return this.head.minValue;
    }

    public boolean empty(){
        return this.head == null;
    }
}

```

# 📍 What I Learned

- 수행시간이 O(1)이 가능하려면 메모리를 추가로 써야 될 수 있음을 생각하며 풀어보기.
- 내장 자료구조를 래핑하지 말고 직접 구현해서 쓰기도 해볼 것.
