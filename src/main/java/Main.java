import com.tsystems.javaschool.tasks.calculator.Calculator;
import com.tsystems.javaschool.tasks.pyramid.PyramidBuilder;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ScriptException {
        PyramidBuilder pyramidBuilder = new PyramidBuilder();
        List<Integer> input = Arrays.asList(1, 3, 2, 9, 4, 5);
        System.out.println(input.lastIndexOf(null));
    }
}

