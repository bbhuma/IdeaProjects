package com.example.demo;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class SteamPurityChart {
    public static void main(String[] args) {
        try {
            createWordDocument("Recommended_Steam_Purity_Limits.docx");
            System.out.println("Steam Purity Chart created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating Steam Purity Chart: " + e.getMessage());
        }
    }

    public static void createWordDocument(String filePath) throws IOException {
        XWPFDocument document = new XWPFDocument();

        // Title
        XWPFParagraph titleParagraph = document.createParagraph();
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText("A.3 Recommended Steam Purity Chart");
        titleRun.setBold(true);
        titleRun.setFontSize(16);
        titleRun.addBreak();

        // Main content
        addParagraph(document,
                "Technically pure steam is of such quality, that it does not cause deposits in the steam pre-heaters, in the fittings, heaters as well as in the turbine, which might require the intentional shut-down of the boiler or some part of the equipment, for their cleaning, outside of the normal equipment maintenance program. The recommended or limit values of the purity of steam are stated in the following table. The values are given in the maximal allowable day average concentrations. The concentration of the chlorine ions may be max. 20 µg/kg.");
        addParagraph(document, "NOTE: THE DATA IS ADAPTED FROM NEMA SM23-1991. (PAGE 52, SECTION 9.7)");

        // Add a break before the table
        document.createParagraph().createRun().addBreak();

        // Table
        XWPFTable table = document.createTable();
        table.setWidth(1024);

        // Set table alignment to center
        CTTblPr tblPr = table.getCTTbl().getTblPr();
        CTJc jc = tblPr.addNewJc();
        jc.setVal(STJc.CENTER);

        // First row (header)
        XWPFTableRow row = table.getRow(0);
        setCellTextAndStyle(row.getCell(0), "", 5000, true);
        setCellTextAndStyle(row.addNewTableCell(), "Units", 2000, true);
        setCellTextAndStyle(row.addNewTableCell(), "Recommended values/ Continuous", 3000, true);
        setCellTextAndStyle(row.addNewTableCell(), "Start Up", 2000, true);

        // Add other rows
        addTableRow(table, "Conductivity, (µS / cm at 25°C)", "µS / cm", "0.2", "0.3");
        addTableRow(table, "Drum", "µS / cm", "0.3", "1.0");
        addTableRow(table, "Once Through", "", "0.2", "0.5");
        addTableRow(table, "Ammonia (NH₃)", "µg.l-¹", "1", "1");
        addTableRow(table, "Silicon dioxide, SiO2", "µg.l-¹", "20", "50");
        addTableRow(table, "Fe Contents", "µg.l-¹", "20", "50");
        addTableRow(table, "Copper, Cu.", "µg/kg", "3", "10");
        addTableRow(table, "Sodium & Potassium (NA + K)", "µg.l-¹", "", "");
        addTableRow(table, "Up to 800 PSIG (56 Bara)", "", "20", "20");
        addTableRow(table, "801 to 1450 PSIG (56 Bara to 101 Bara)", "", "10", "10");
        addTableRow(table, "1451 to 2400 PSIG(101 Bara to 166 Bara)", "", "5", "5");
        addTableRow(table, "Over 2400 PSIG (166 Bara)", "", "3", "3");

        // Add a break after the table
        document.createParagraph().createRun().addBreak();

        // Footer note
        addParagraph(document,
                "NOTE: The measurement of the electrical conductivity ƴ at 25⁰C (µS/cm-¹) must be done without the presence of operational chemical agents, e.g. ammonia or hydrazine, which tends to increase the conductivity. This is why the measurement of specific electrical conductivity has to be done after the flow of the sample through the strong acidic H-katex, which is the filter that keeps all cat-ions of the chemical compounds. By the filtration chemically pure water can be obtained.");

        // Write the document to a file
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            document.write(out);
        }
    }

    private static void addParagraph(XWPFDocument document, String text) {
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        run.addBreak();
    }

    private static void addTableRow(XWPFTable table, String cell1Text, String cell2Text, String cell3Text, String cell4Text) {
        XWPFTableRow row = table.createRow();
        setCellTextAndStyle(row.getCell(0), cell1Text, 5000, false);
        setCellTextAndStyle(row.getCell(1), cell2Text, 2000, false);
        setCellTextAndStyle(row.getCell(2), cell3Text, 3000, false);
        setCellTextAndStyle(row.getCell(3), cell4Text, 2000, false);
    }

    private static void setCellTextAndStyle(XWPFTableCell cell, String text, int width, boolean isHeader) {
        XWPFParagraph paragraph = cell.getParagraphs().get(0);
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setText(text);
        if (isHeader) {
            run.setBold(true);
        }
        //cell.setWidth(width);
    }
}
