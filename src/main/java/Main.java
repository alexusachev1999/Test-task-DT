import com.tsystems.javaschool.tasks.calculator.Calculator;

import javax.script.ScriptException;

public class Main {
    public static void main(String[] args) throws ScriptException {
        System.out.println(Calculator.RPNToAnswer(Calculator.ExpressionToRPN("10/(5-5)")));
    }
}
