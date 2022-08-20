package com.apitirage.FreeTirage.Others;
import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Repository.Postulants_repo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class InsertionExcel {


    public List<Postulants> insert(MultipartFile file) {

        List<Postulants> postulants = new ArrayList<>();



        //List<Postulants> str = new ArrayList<Postulants>();
        List<Liste> postulantList = new ArrayList<>();
        DataFormatter dformater = new DataFormatter();


        long debut = System.currentTimeMillis();//l'heure de fin

        try {
            //FileInputStream inputStrean = new FileInputStream(file.getInputStream());
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());

            Sheet firstSheet=workbook.getSheetAt(0);
            Iterator<Row> rowIterator=firstSheet.iterator();

            rowIterator.next();

            while (rowIterator.hasNext()){

                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator=nextRow.cellIterator();
                Postulants post = new Postulants();

                int numColum=0;
                while (cellIterator.hasNext()){
                    Cell nextCell = cellIterator.next();

                    //int columnIndex=nextCell.getColumnIndex();
                    switch (numColum){

                        case 0:
                            post.setNom(dformater.formatCellValue(nextCell));
                            //nom=nextCell.getStringCellValue();
                            System.out.println(dformater.formatCellValue(nextCell));
                            break;
                        case 1:
                            post.setPrenom(dformater.formatCellValue(nextCell));
                           // prenom=nextCell.getStringCellValue();
                            System.out.println(dformater.formatCellValue(nextCell));
                            break;
                        case 2:
                            post.setNumero(dformater.formatCellValue(nextCell));
                           // numero = nextCell.getStringCellValue();
                            System.out.println(dformater.formatCellValue(nextCell));
                            break;
                        case 3:
                            post.setEmail(dformater.formatCellValue(nextCell));
                            //email=nextCell.getStringCellValue();
                            System.out.println(dformater.formatCellValue(nextCell));
                            break;
                        default:
                            break;

                    }
                    numColum ++;

                    // postulants.add((Postulants) postRepo);
                }



                /* ...........................................*/

                postulants.add(post);
                //postRepo.saveAll(postulants);


                // postulants.add(new Postulants(nom,prenom,numero,email));

                //postulantList.add(new Postulants(id,nom, prenom, numero, email));
                // Sauvegarder dans la base de données
            }

            workbook.close();

            long fin = System.currentTimeMillis();//l'heure de fin

            Message.Response("Import donne "+(fin - debut)+"Secondes", HttpStatus.OK,null);
            //System.out.printf("Import done in %d ms\n", (fin - debut));
        } catch (Exception e) {
            Message.Response(e.getMessage(),HttpStatus.OK,null);
        }
        return postulants;
    }
}
