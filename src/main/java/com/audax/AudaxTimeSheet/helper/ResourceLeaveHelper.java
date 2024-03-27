package com.audax.AudaxTimeSheet.helper;

import com.audax.AudaxTimeSheet.entities.ResourceLeave;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ResourceLeaveHelper {

    // Check if the file is of Excel type
    public static boolean checkExcelFormat(MultipartFile file) {
        String contentType = file.getContentType();
        return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    // Convert Excel to a list of ResourceLeave objects
    public static List<ResourceLeave> convertExcelToListOfResourceLeave(InputStream is) {
        List<ResourceLeave> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("data");
            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row row = iterator.next();
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                ResourceLeave resourceLeave = new ResourceLeave();
                while (cells.hasNext()) {
                    Cell cell = cells.next();
                    int cid = cell.getColumnIndex();
                    switch (cid) {
                        case 0:
                            resourceLeave.setResourceLeaveId((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            resourceLeave.setLeaveMonth(cell.getStringCellValue());
                            break;
                        case 2:
                            resourceLeave.setLeaveType(cell.getStringCellValue());
                            break;
                        case 3:
                            // Assuming the Resource ID is also numeric
                           // resourceLeave.setResource(new Resource((long) cell.getNumericCellValue()));
                            break;
                        case 4:
                            resourceLeave.setNoOfDays((long) cell.getNumericCellValue());
                            break;
                        case 5:
                            // Assuming date cells are formatted as strings
                            resourceLeave.setLeaveStartDate(DateHelper.convertStringToDate(cell.getStringCellValue()));
                            break;
                        case 6:
                            resourceLeave.setLeaveEndDate(DateHelper.convertStringToDate(cell.getStringCellValue()));
                            break;
                        case 7:
                            resourceLeave.setCreatedBy(cell.getStringCellValue());
                            break;
                        case 8:
                            // Assuming date cells are formatted as strings
                            resourceLeave.setCreationDate(DateHelper.convertStringToDate(cell.getStringCellValue()));
                            break;
                        case 9:
                            resourceLeave.setUpdatedBy(cell.getStringCellValue());
                            break;
                        case 10:
                            // Assuming date cells are formatted as strings
                            resourceLeave.setUpdationDate(DateHelper.convertStringToDate(cell.getStringCellValue()));
                            break;
                        case 11:
                            resourceLeave.setVersion((long) cell.getNumericCellValue());
                            break;
                        case 12:
                            resourceLeave.setIsActive(cell.getBooleanCellValue());
                            break;
                        default:
                            break;
                    }
                }
                list.add(resourceLeave);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
