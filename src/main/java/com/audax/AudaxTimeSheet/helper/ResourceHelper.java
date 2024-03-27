package com.audax.AudaxTimeSheet.helper;
import com.audax.AudaxTimeSheet.entities.Resource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResourceHelper {

    // Check if the file is of Excel type
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    // Convert Excel to a list of Resource objects
    public static List<Resource> convertExcelToListOfResource(InputStream is) {
        List<Resource> list = new ArrayList<>();
        try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                Resource resource = new Resource();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    int cid = cell.getColumnIndex();
                    switch (cid) {
                        case 0:
                            resource.setResourceId((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            resource.setResourceName(cell.getStringCellValue());
                            break;
                        case 2:
                            resource.setResourceType(cell.getStringCellValue());
                            break;
                        case 3:
                            resource.setResourceDesignation(cell.getStringCellValue());
                            break;
                        case 4:
                            // Assuming date cells are formatted as strings
                            resource.setResourceJoiningDate(DateUtil.getJavaDate(cell.getNumericCellValue()));
                            break;
                        case 5:
                            // Assuming date cells are formatted as strings
                            resource.setResourceSeparationDate(DateUtil.getJavaDate(cell.getNumericCellValue()));
                            break;
                        case 6:
                            resource.setResourceManagerName(cell.getStringCellValue());
                            break;
                        case 7:
                            resource.setCreatedBy(cell.getStringCellValue());
                            break;
                        case 8:
                            // Assuming date cells are formatted as strings
                            resource.setCreationDate(DateUtil.getJavaDate(cell.getNumericCellValue()));
                            break;
                        case 9:
                            resource.setUpdatedBy(cell.getStringCellValue());
                            break;
                        case 10:
                            // Assuming date cells are formatted as strings
                            resource.setUpdationDate(DateUtil.getJavaDate(cell.getNumericCellValue()));
                            break;
                        case 11:
                            resource.setVersion((long) cell.getNumericCellValue());
                            break;
                        case 12:
                            resource.setIsActive((long) cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                }
                list.add(resource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
