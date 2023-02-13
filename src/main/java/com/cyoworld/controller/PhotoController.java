package com.cyoworld.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PhotoController {

    @GetMapping(value = "/photo")
    public String photo() {
        return "photos/photo";
    }

    @GetMapping(value = "/photo/photoUpload")
    public String photoUpload(){
        return "photos/photoUpload";
    }

}