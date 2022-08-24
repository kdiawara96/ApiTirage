package com.apitirage.FreeTirage.Others;
import com.apitirage.FreeTirage.Models.Liste;
import com.apitirage.FreeTirage.Models.Postulants;
import com.apitirage.FreeTirage.Repository.Postulants_repo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class InsertionExcel {


    public List<Postulants> insert(MultipartFile file) {


        List<Postulants> postulants = new ArrayList<>(); //Variable permettant de prendre toutes les donnes du tableau



        //List<Postulants> str = new ArrayList<Postulants>();
        List<Liste> postulantList = new ArrayList<>();
        DataFormatter dformater = new DataFormatter();


          String fe = "";
          if (file.getOriginalFilename().contains(".")) {
            int i = file.getOriginalFilename().lastIndexOf('.');
            fe = i > 0 ? file.getOriginalFilename().substring(i + 1) : "";


            if (fe.equals("xls")){



                DataFormatter formatter=new DataFormatter();
               // ArrayList<Postulants> values = new ArrayList<Postulants>();  Variable permettant de prendre toutes les donnes du tableau

                // Bloque permettant de lever les exception lors de l'importation du fichier excel
                try{
                    //InputStream fichier = new FileInputStream("fichier.xls"); // Recuperation du fichier Execl sous forme de fichier simple

                    POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream()); // conversion du fichier simple sous forme d'un fichier POI

                    HSSFWorkbook wb = new HSSFWorkbook(fs); // Conversion du fichier POI sous format Workbook

                    HSSFSheet sheet = wb.getSheetAt(0); // Recuperation du Premier page du fichier excel

                    Iterator<Row> rows = sheet.rowIterator(); // Recuperation de tous les lignes de la page du fichier
                    // Boucle permettant de parcours toutes lignes de la page

                      rows.next();

                    while (rows.hasNext()){

                        HSSFRow row = (HSSFRow) rows.next(); // Recuperation d'une ligne du tableau

                        Iterator<Cell> cells = row.cellIterator(); // Recuperation de toutes toutes les colonnes de chaque ligne
                        Postulants p=new Postulants();

                        int numColun=0;

                        // Boucle permettant de parcourut toutes les colonnes de chaque ligne
                        while (cells.hasNext()){

                            HSSFCell cell = (HSSFCell) cells.next(); // Recuperation d'une colonne

                            switch (numColun){

                                case 0:
                                    p.setNom(formatter.formatCellValue(cell));
                                    break;
                                case 1:

                                    p.setPrenom(formatter.formatCellValue(cell));
                                    break;
                                case 2:
                                    p.setNumero(formatter.formatCellValue(cell));
                                    break;
                                case 3:
                                    p.setEmail(formatter.formatCellValue(cell));
                                    break;
                                default:
                                    break;
                            }
                            numColun++;

                            // Condition permettant de verifier le type de la colonne et effectuer une convesion si c'est type int
                            // if (cell.getCellType() == CellType.NUMERIC){
                            //   values.add(Integer.toString((int) cell.getNumericCellValue()));
                            // }
                            //else{
                            //  values.add(cell.getStringCellValue());
                            // }
                        }

                        //postulantRepository.INSERTPOSTULANT (values.get(3),values.get(1),values.get(2),values.get(0));
                        postulants.add(p);
                    }
                    return postulants;

                }catch (Exception e){

                    e.printStackTrace();
                    return null;

                }

            }
            //Fichier xlsx

            if (fe.equals("xlsx")){
                long debut = System.currentTimeMillis();//l'heure de fin

                try {
                    // FileInputStream inputStrean = new FileInputStream("classeur1.xlsx");
                    XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
                    //XSSFWorkbook workbook = new XSSFWorkbook(inputStrean);

                    Sheet firstSheet=workbook.getSheetAt(0);
                    Iterator<Row> rowIterator= firstSheet.iterator();

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
        }else{
            System.out.println("Bad file!");
        }


     return null;

    }
}
