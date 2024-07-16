package com.ER.tier

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TestController {

    @GetMapping("/blog")
    fun blog(): String {
        return "blog"
    }
}