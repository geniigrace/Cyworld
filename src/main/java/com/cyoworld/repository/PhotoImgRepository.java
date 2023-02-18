package com.cyoworld.repository;

import com.cyoworld.entity.PhotoImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PhotoImgRepository extends JpaRepository<PhotoImg, Long>{
//        List<PhotoImg> findByItemIdOrderByIdAsc(Long PhotoId);

    @Override
    Optional<PhotoImg> findById(Long photoImgId);
}