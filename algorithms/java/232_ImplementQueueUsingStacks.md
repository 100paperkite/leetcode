# Problem

큐 두개로 스택 구현하기

# My Solution

`push`를 `O(1)`으로 할 경우에 `pop`은 `push`했던 큐에서 다 빼서 나머지 한 큐에 다 넣은 후 `pop`했다가 다시 `push`한 큐로 되돌리는 방법이 있음.

하지만 해당 방법은 `pop`이 여러번 일어날 경우에 계속 넣었다 뺐다 하는 무분별한 연산이 진행된다.
어차피 구현하는 것은 큐이므로(선입선출) 옮겨둔 값들이 전부 pop될 때 까지는 push했던 값들을 pop하지 않으므로 `pop`이 수행될 때 한 번만 옮기면 된다.

```java
class MyQueue {
    private Stack<Integer> pushStack = new Stack<Integer>();
    private Stack<Integer> popStack = new Stack<Integer>();

    public MyQueue() {

    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        this.peek();
        return popStack.pop();
    }

    public int peek() {
        if (this.popStack.empty()){
            while(!pushStack.empty()){
                popStack.push(pushStack.pop());
            }
        }
        return this.popStack.peek();
    }

    public boolean empty() {
        return pushStack.empty() && popStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```
