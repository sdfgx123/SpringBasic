package springStudy.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";
    }

    /**
     * requestParam : 함수 실행시 파라미터를 받을 때 사용
     *  >> 즉, name 이라는 파리미터로 이 함수 실행 시 인자를 받아와서,
     *  >> name 이라는 파라미터를 String name 이라는 지역변수로 선언
     * Model : model에 담아서 View한테 넘길 때 사용하기 위해 선언
     */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-templates";
    }

    /**
     * ResponseBody : return 시 String을 그대로 반환함
     */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    /**
     * static 쓰면 클래스 안에서 클래스를 또 쓸 수 있음
     * helloApi > 객체를 넘긴 메서드 > 객체를 return으로 넘기면 json 값으로 반환됨
     * responseBody > 객체를 넘기면 > default로 객체를 json화 해서 넘긴다
     */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
