package com.audax.AudaxTimeSheet.services;
import com.audax.AudaxTimeSheet.entities.Resource;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class PDFExportService {

    public static ByteArrayInputStream resourcePDFReport(List<Resource> resources) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Add Content to PDF file
            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Resource Structure", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(7);

            // Add PDF Table Header
            String[] headers = {"ID", "Name", "Type", "Designation", "Joining Date", "Separation Date", "Manager Name"};
            for (String headerTitle : headers) {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(BaseColor.CYAN);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            }

            // Add Resource data to the table
            for (Resource resource : resources) {
                PdfPCell idCell = new PdfPCell(new Phrase(resource.getResourceId().toString()));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell nameCell = new PdfPCell(new Phrase(resource.getResourceName()));
                nameCell.setPaddingLeft(4);
                nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(nameCell);

                PdfPCell typeCell = new PdfPCell(new Phrase(resource.getResourceType()));
                typeCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                typeCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(typeCell);

                PdfPCell designationCell = new PdfPCell(new Phrase(resource.getResourceDesignation()));
                designationCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                designationCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(designationCell);

                PdfPCell joiningDateCell = new PdfPCell(new Phrase(resource.getResourceJoiningDate().toString()));
                joiningDateCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                joiningDateCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(joiningDateCell);

                PdfPCell separationDateCell = new PdfPCell(new Phrase(resource.getResourceSeparationDate().toString()));
                separationDateCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                separationDateCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(separationDateCell);

                PdfPCell managerNameCell = new PdfPCell(new Phrase(resource.getResourceManagerName()));
                managerNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                managerNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(managerNameCell);
            }

            document.add(table);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
