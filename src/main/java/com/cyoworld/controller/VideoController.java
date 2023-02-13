package com.cyoworld.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class VideoController {
    @GetMapping(value = "/video")
    public String video(){
        return "video/video";
    }


}
