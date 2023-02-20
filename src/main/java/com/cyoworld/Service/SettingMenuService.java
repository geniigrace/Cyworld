package com.cyoworld.Service;

import com.cyoworld.entity.Member;
import com.cyoworld.entity.SettingMenu;
import com.cyoworld.repository.SettingMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SettingMenuService {

    private final SettingMenuRepository settingMenuRepository;

    public SettingMenu findSettingMenuByUserId(String userId){
        SettingMenu settingMenu = settingMenuRepository.findByUserId(userId);
        return settingMenu;
    }

    public SettingMenu saveSettingMenu(SettingMenu settingMenu){
        return settingMenuRepository.save(settingMenu);
    }
}