package com.java.bankingApplication0.service;

import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.java.bankingApplication0.entity.ImageData;
import com.java.bankingApplication0.repository.StorageRepository;
import com.java.bankingApplication0.util.ImageUtils;

@Service
public class StorageService {

  @Autowired
  private StorageRepository repository;
  
  public String uploadImage(MultipartFile file) throws IOException {
    ImageData imageData = repository.save(ImageData.builder().name(file.getOriginalFilename()).type(file.getContentType()).imageData(ImageUtils.compressImage(file.getBytes())).build());//save(ImageData.builder()).name(file.getOriginalFilename()).type(file.getContentType()).imageData(ImageUtils.compressImage(file.getBytes()).getBytes().build());
    if(imageData != null) {
      return "File Uploaded Successfully : " + file.getOriginalFilename();
    }
    return null;
  }
  
  public byte[] downloadImage(String fileName) {
    Optional<ImageData> dbImageData = repository.findByName(fileName);
    byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
    return images;
  }

}
