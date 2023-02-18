package com.cyoworld.Service;

import com.cyoworld.entity.PhotoImg;
import com.cyoworld.repository.PhotoImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class PhotoService {


    @Value("${itemImgLocation}")
    private String photoImgLocation;

    private final PhotoImgRepository photoImgRepository;

    private final PhotoFileService photoFileService;

    public void savePhotoImg(PhotoImg photoImg, MultipartFile photoImgFile) throws Exception {
        String oriImgName = photoImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        //파일 업로드
        if (!StringUtils.isEmpty(oriImgName)) {
            imgName = photoFileService.uploadFile(photoImgLocation, oriImgName,
                    photoImgFile.getBytes());
            imgUrl = "/images/photo/" + imgName;
        }

        //상품 이미지 정보 저장
        photoImg.updatePhotoImg(oriImgName, imgName, imgUrl);
            photoImgRepository.save(photoImg);
    }

    public void updatePhotoImg(Long photoImgId, MultipartFile photoImgFile) throws Exception {
        if (!photoImgFile.isEmpty()) {
            PhotoImg savedPhotoImg = photoImgRepository.findById(photoImgId)
                    .orElseThrow(EntityNotFoundException::new);

            //기존 이미지 파일 삭제
            if (!StringUtils.isEmpty(savedPhotoImg.getImgName())) {
                photoFileService.deleteFile(photoImgLocation + "/" +
                        savedPhotoImg.getImgName());
            }

            String oriImgName = photoImgFile.getOriginalFilename();
            String imgName = photoFileService.uploadFile(photoImgLocation, oriImgName, photoImgFile.getBytes());
            String imgUrl = "/images/photo/" + imgName;
            savedPhotoImg.updatePhotoImg(oriImgName, imgName, imgUrl);
        }
    }
}
