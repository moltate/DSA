class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String i : tokens){      
               if(i.equals("+")) {         
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second + first);
                }else if(i.equals("-")) {         
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second - first);
                }else if(i.equals("*")) {         
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second * first);
                }else if(i.equals("/")){         
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second / first);
                }else {
                stack.push(Integer.parseInt(i));
            }
        }
        return stack.peek();
    }
}