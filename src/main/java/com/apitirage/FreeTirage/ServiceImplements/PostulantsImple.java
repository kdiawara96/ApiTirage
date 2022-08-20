package com.apitirage.FreeTirage.ServiceImplements;
import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Others.InsertionExcel;
import com.apitirage.FreeTirage.Others.Message;
import com.apitirage.FreeTirage.Repository.Postulants_repo;
import com.apitirage.FreeTirage.Services.ServicePostulants;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class PostulantsImple implements ServicePostulants {
private final Postulants_repo post_repo;

    @Override
    public List<Postulants> insererPostulant(List<Postulants> listInser) {
        return post_repo.saveAll(listInser);
    }


    @Override
    public List<Postulants> read(MultipartFile file) {

        return null;
    }
}
