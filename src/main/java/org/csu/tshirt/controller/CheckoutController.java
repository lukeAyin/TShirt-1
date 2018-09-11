package org.csu.tshirt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {
    @GetMapping("/checkout")
    public String viewcheckout()
    {
        return "checkout";
    }
}
