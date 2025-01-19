package study.mini01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("hello-string")
    @ResponseBody //http protocol의 body부
    public String helloString(@RequestParam("name") String name){
        return "hello"+name; // "hello spring"이 응답
    }

    @GetMapping("hello-api")
    @ResponseBody
   public Hello helloApi(@RequestParam("name") String name){

    Hello hello = new Hello();
    hello.setName(name);
    return hello;
    }
    //객체 class Hello 생성
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
