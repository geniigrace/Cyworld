package com.cyoworld.dto;

import com.cyoworld.entity.PhotoImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class PhotoImgDto {

    private Long id;

    private String category;

    private String imgName;

    private String oriImgName;

    private String imgUrl;

    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper();

    public static PhotoImgDto of(PhotoImg photoImg){
        return modelMapper.map(photoImg, PhotoImgDto.class);
    }

}
