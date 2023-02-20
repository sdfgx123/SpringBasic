package springStudy.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * URL /로 매핑을 잡아주면, 여기서 먼저 매핑 정보가 걸리기 때문에
     * index 페이지 호출 안하고 바로 home view 호출함
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
