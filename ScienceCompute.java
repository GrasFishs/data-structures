import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by GrasFish on 2017/9/20.
 */
public class ScienceCompute {

    private String infix = "";
    private String postfix = "";

    public ScienceCompute(String in) {
        infix = in;
        postfix = intToPostfix();
    }

    public String compute() {
        Stack<String> nums = new Stack<>();
        for (int i = 0; i < postfix.length(); i++) {
            String s = String.valueOf(postfix.charAt(i));
            if (Pattern.compile("[0-9]").matcher(s).find()) {
                nums.push(s);
            } else {
                switch (s) {
                    case "+":
                        nums.push(computeToString("+", nums.pop(), nums.pop()));
                        break;
                    case "-":
                        nums.push(computeToString("-", nums.pop(), nums.pop()));
                        break;
                    case "*":
                        nums.push(computeToString("*", nums.pop(), nums.pop()));
                        break;
                    case "/":
                        nums.push(computeToString("/", nums.pop(), nums.pop()));
                        break;
                }
            }
        }
        return nums.pop();
    }

    private String computeToString(String op, String i, String j) {
        switch (op) {
            case "+":
                return String.valueOf(Integer.parseInt(j) + Integer.parseInt(i));
            case "-":
                return String.valueOf(Integer.parseInt(j) - Integer.parseInt(i));
            case "*":
                return String.valueOf(Integer.parseInt(j) * Integer.parseInt(i));
            case "/":
                return String.valueOf(Integer.parseInt(j) / Integer.parseInt(i));
        }
        return "";
    }

    public String getInfix(){
        return infix;
    }
    public String getPostfix() {
        return postfix;
    }

    private String intToPostfix() {
        Stack<String> operations = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            String s = String.valueOf(infix.charAt(i));
            if (Pattern.compile("[0-9]|[a-z]").matcher(s).find()) {//遇到运算数输出
                postfix += s;
            } else {//遇到运算符
                switch (s) {
                    case "("://遇到左括号入栈
                        operations.push(s);
                        break;
                    case ")"://遇到左括号前栈顶元素全部弹出
                        if (!operations.isEmpty()) {
                            while (!operations.peek().equals("(")) {
                                postfix += operations.pop();
                            }
                            operations.pop();//弹出)
                        }
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/": {
                        if (!operations.empty()) {
                            if ((priority(s) > priority(operations.peek()))) {//运算符大于栈顶元素优先级
                                operations.push(s);
                            } else {
                                do {
                                    postfix += operations.pop();
                                } while (!operations.isEmpty() && priority(s) <= priority(operations.peek()));
                                operations.push(s);
                            }
                        } else operations.push(s);
                    }
                }
            }
        }
        while (!operations.empty()) {
            postfix += operations.pop();
        }
        return postfix;
    }

    private int priority(String s) {
        switch (s) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }
}
