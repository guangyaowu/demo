package com.example.demo;

import com.example.common.ActionResult;
import com.example.common.CommonActionResults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("democontroller")
public class DemoController {

    @GetMapping("/hello")
    public ActionResult getAll() {
        return CommonActionResults.success("DemoController : hello world !");
    }

}
