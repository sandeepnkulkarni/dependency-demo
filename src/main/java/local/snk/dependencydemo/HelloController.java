package local.snk.dependencydemo;

import org.apache.commons.lang3.text.StrMatcher;
import org.apache.commons.lang3.text.StrTokenizer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Greetings from Spring boot!";
    }

    @RequestMapping("/hello/multiple")
    public List<String> sayHelloMultiple() {
        String test = "Sandeep, Piyush, Neha";
        List<String> results = new ArrayList<>();

        List<String> tokens = new StrTokenizer(test, ",").setTrimmerMatcher(StrMatcher.spaceMatcher()).getTokenList();
        for (String token : tokens)
        {
            results.add(String.format("Greetings to %s from Spring boot!", token));
        }

        return results;
    }
}
