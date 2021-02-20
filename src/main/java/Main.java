import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.tsystems.javaschool.tasks.calculator.Calculator;
import com.tsystems.javaschool.tasks.pyramid.PyramidBuilder;
import com.tsystems.javaschool.tasks.subsequence.Subsequence;

import javax.script.ScriptException;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws ScriptException {
        List x = Stream.of("A", "B", "C", "D").collect(toList());
        List y = Stream.of("A", "B", "D", "E", "C").collect(toList());
        Subsequence subsequence = new Subsequence();

        System.out.println(subsequence.find(x,y));
    }
}

