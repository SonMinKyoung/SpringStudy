package study.mini01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("welcome")
    public String hello(Model model){
        model.addAttribute("data","Nice to meet you");
        return "hello";
    }
}
