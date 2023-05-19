package com.xin.stack.evalRPN;

import java.util.Stack;

/**
 * @author Hu·YX
 * @Description 150. 逆波兰表达式求值
 * @Link <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/">150. 逆波兰表达式求值</a>
 * @Date 2023/03/22
 */
public class Solution150 {
    /**
     * 逆波兰表达式：
     *
     * <p>逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。</p>
     * <li>平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。</li>
     * <li>该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。</li>
     * <div>逆波兰表达式主要有以下两个优点：</div>
     * <li>去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。</li>
     * <li>适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中</li>
     * @param tokens    表达式数组
     * @return int
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    // 取出栈顶的第二个操作数
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                }
                case "-": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                }
                case "*": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                }
                case "/": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(token));
                    break;
                }
            }
        }
        return stack.pop();
    }
}
