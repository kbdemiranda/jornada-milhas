package io.github.jornadamilhas.application.service;

import org.springframework.web.multipart.MultipartFile;

public interface FotoService {

    String salvarFoto(MultipartFile foto);

}
