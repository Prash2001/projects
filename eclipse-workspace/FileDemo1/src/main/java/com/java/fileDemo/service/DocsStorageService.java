package com.java.fileDemo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.java.fileDemo.model.Doc;
import com.java.fileDemo.repository.DocRepository;
@Service
public class DocsStorageService {
@Autowired
private DocRepository docRepo;
public Doc saveFile(MultipartFile file) {
  String docName = file.getOriginalFilename();
  try {
    Doc doc = new Doc(docName,file.getContentType(), file.getBytes());
    return docRepo.save(doc);
  } catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
  }
  return null;
}

public Optional<Doc> getFile(Integer fileId) {
  return docRepo.findById(fileId);
}

public List<Doc> getFiles(){
  return docRepo.findAll();
}
}
