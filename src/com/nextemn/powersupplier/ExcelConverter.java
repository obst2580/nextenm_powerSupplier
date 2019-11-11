package com.nextemn.powersupplier;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;



public class ExcelConverter {

    public String readExcel(String filePath) {
        String results = "";
        try {
            FileInputStream file = new FileInputStream("filePath");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            int rowindex=0;
            int columnindex=0;
            XSSFSheet sheet=workbook.getSheetAt(0);
            int rows=sheet.getPhysicalNumberOfRows();

            for(rowindex=0;rowindex<rows;rowindex++){
                XSSFRow row=sheet.getRow(rowindex);
                if(row !=null){
                    int cells=row.getPhysicalNumberOfCells();
                    for(columnindex=0; columnindex<=cells; columnindex++){
                        XSSFCell cell=row.getCell(columnindex);
                        String value="";
                        if(cell==null){
                            continue;
                        }else{
                            switch (cell.getCellType()){
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    value=cell.getCellFormula();
                                    break;
                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    value=cell.getNumericCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_STRING:
                                    value=cell.getStringCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:
                                    value=cell.getBooleanCellValue()+"";
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR:
                                    value=cell.getErrorCellValue()+"";
                                    break;
                            }
                        }
                        results += rowindex + " : " + columnindex + " : " + value;
                    }

                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return results;
    }

}
