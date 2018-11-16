package hello;

import hello.model.SeekerDescription;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/resume")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        SeekerDescription seekerDescription;
        model.addAttribute("seekerDescription", seekerDescription);
        return "greeting";
    }

}
