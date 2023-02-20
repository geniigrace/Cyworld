package com.cyoworld.controller;

import com.cyoworld.Service.SettingMenuService;
import com.cyoworld.dto.SettingManageMenuDto;
import com.cyoworld.entity.SettingMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/setting")
public class SettingController {
    private final SettingMenuService settingMenuService;

    @GetMapping(value = "/menu")
    public String settingMenu(Model model, Principal principal){
        SettingMenu settingMenu = settingMenuService.findSettingMenuByUserId(principal.getName());

        SettingManageMenuDto smmd = new SettingManageMenuDto();
        smmd.setId(settingMenu.getId());
        smmd.setAlbumPhoto(settingMenu.getAlbumPhoto());
        smmd.setAlbumVideo(settingMenu.getAlbumVideo());
        smmd.setBoard(settingMenu.getBoard());
        smmd.setDiary(settingMenu.getDiary());
        smmd.setGuestbook(settingMenu.getGuestbook());
        smmd.setBookmark(settingMenu.getBookmark());
        model.addAttribute("settingManageMenuDto", smmd);

//        model.addAttribute("settingManageMenuDto", new SettingManageMenuDto());

//        SettingManageMenuDto smmd = new SettingManageMenuDto();
//        smmd.setAlbumPhoto(SettingStatus.ON);
//        smmd.setAlbumVideo(SettingStatus.ON);
//        smmd.setBoard(SettingStatus.OFF);
//        smmd.setDiary(SettingStatus.OFF);
//        smmd.setGuestbook(SettingStatus.ON);
//        smmd.setBookmark(SettingStatus.ON);
//        model.addAttribute("settingManageMenuDto", smmd);

        return "setting/settingMenu";
    }

    @PostMapping(value = "/saveMenuSetting")
    public String saveMenuSetting(SettingManageMenuDto settingManageMenuDto, Principal principal, Model model){
        try {
            SettingMenu settingMenu = settingMenuService.findSettingMenuByUserId(principal.getName());
            settingMenu.updateSettingMenu(settingManageMenuDto);
            model.addAttribute("successMessage", "수정했습니다.");
        } catch (Exception e) {
            model.addAttribute("successMessage", "수정에 실패했습니다. 다시 시도해주세요.");
        }
        return "redirect:/setting/menu";
    }

    @GetMapping(value = "/blocked")
    public String settingBlocked(Model model, Principal principal){

        return "setting/settingBlocked";
    }
}
