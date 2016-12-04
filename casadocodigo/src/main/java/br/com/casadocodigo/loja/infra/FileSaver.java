/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author regis
 */
@Component
public class FileSaver {

    @Autowired
    private HttpServletRequest request;

    public String save(String toFolder, MultipartFile file) throws IOException, IllegalStateException {

        file.transferTo(new File(getPath(getRealPath(toFolder), file)));
        return getRelativePath(toFolder, file);
    }

    private String getRealPath(String toFolder) {
        return request.getServletContext().getRealPath("/" + toFolder);
    }

    private String getPath(String realPath, MultipartFile file) {
        return realPath + "/" + file.getOriginalFilename();
    }

    private String getRelativePath(String toFolder, MultipartFile file) {
        return toFolder + "/" + file.getOriginalFilename();
    }

}
