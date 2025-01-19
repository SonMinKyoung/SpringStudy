package study.mini01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("welcome")
    public String hello(Model model){
        model.addAttribute("data","Nice to meet you");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")/*default:(value = "name", required = true)*/ String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
