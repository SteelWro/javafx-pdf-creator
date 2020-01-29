package cwiklinski.me.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import cwiklinski.me.config.PropertiesConfiguration;
import cwiklinski.me.enums.PdfEnum;
import cwiklinski.me.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PdfCreator {
    private PropertiesConfiguration propertiesConfiguration;
    private String pdfSubject;
    private String pdfCreator;
    private String extension;
    private String font;
    private File fontFile;
    private BaseFont unicodeFont;

    public PdfCreator() throws IOException, DocumentException {
        this.propertiesConfiguration = new PropertiesConfiguration();
        font = propertiesConfiguration.getProp().getProperty("file.font");
        pdfCreator = propertiesConfiguration.getProp().getProperty("file.creator");
        pdfSubject = propertiesConfiguration.getProp().getProperty("file.subject");
        extension = propertiesConfiguration.getProp().getProperty("file.extension");
        fontFile = new File(font);
        unicodeFont = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
    }

    public void createPdfFile(SuperModel superModel) throws FileNotFoundException, DocumentException {
        final String requestDateTime = superModel.getResult().getRequestDateTime();
        final String requestId = superModel.getResult().getRequestId();

        for (Subject subject : superModel.getResult().getSubjects()) {
            String fileName = subject.getName();

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName + extension));
            document.open();

            addMetaData(document, fileName, pdfSubject, pdfCreator);
            createTableHeader(document, subject);
            createTable(document, requestDateTime, subject, requestId);

            document.close();
        }
    }

    private void createTableHeader(Document document, Subject subject) throws DocumentException {

        com.itextpdf.text.Font titleFont = new com.itextpdf.text.Font(unicodeFont, 18);
        Paragraph title = new Paragraph(PdfEnum.TITLE.toString(), titleFont);

        com.itextpdf.text.Font subTitleFont = new com.itextpdf.text.Font(unicodeFont, 15);
        Paragraph subtitle = new Paragraph(PdfEnum.SUBTITLE.toString() + subject.getNip(), subTitleFont);

        com.itextpdf.text.Font infoPartyCounterFont = new com.itextpdf.text.Font(unicodeFont, 12);
        infoPartyCounterFont.setColor(BaseColor.BLUE);
        Paragraph infoPartyCounter = new Paragraph(PdfEnum.NAME + subject.getName() + " " + PdfEnum.NIP + subject.getNip(), infoPartyCounterFont);

        document.add(title);
        document.add(subtitle);
        document.add(infoPartyCounter);
    }

    private void createTable(Document document, String requestDateTime, Subject subject, String requestId) throws DocumentException {
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);

        table.setSpacingBefore(10);
        fillTable(table, requestDateTime, subject, requestId);
        document.add(table);
    }

    private void fillTable(PdfPTable table, String requestDateTime, Subject subject, String requestId) {
        com.itextpdf.text.Font tableFont = new com.itextpdf.text.Font(unicodeFont, 11);
        com.itextpdf.text.Font tableSpecialFontBold = new com.itextpdf.text.Font(unicodeFont, 13, Font.BOLD, BaseColor.RED);
        PdfPCell cell = new PdfPCell();
        cell.setPadding(10);

        cell.setPhrase(new Paragraph(PdfEnum.DAY_STATE.toString() + requestDateTime.substring(0, 10), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(PdfEnum.SEARCH_DATE.toString() + requestDateTime, tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.SUBJECT_NAME_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getName(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.SUBJECT_NUMBER_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getNip(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.SUBJECT_PESEL_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getPesel()));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.SUBJECT_STATUS_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getStatusVat(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.SUBJECT_REGON_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getRegon(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.SUBJECT_KRS_NUMBER_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getKrs(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.NATURAL_PERSON_ADDRESS_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getWorkingAddress(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.LEGAL_ENTITY_ADDRESS_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getResidenceAddress(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.AUTHORIZED_CLERKS_LIST_CELL.toString(), tableFont));
        table.addCell(cell);
        String authorizedClerks = getStringOfAuthorizedClerksList(subject.getAuthorizedClerks());
        cell.setPhrase(new Paragraph(authorizedClerks, tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.REPRESENTATIVES_NAMES_LIST_CELL.toString(), tableFont));
        table.addCell(cell);
        String representativeList = getStringOfRepresentativesList(subject.getRepresentatives());
        cell.setPhrase(new Paragraph(representativeList, tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.PARTNERS_CELL.toString(), tableFont));
        table.addCell(cell);
        String partnerList = getStringOfPartnersList(subject.getPartners());
        cell.setPhrase(new Paragraph(partnerList, tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.ACCOUNT_NUMBERS_CELL.toString(), tableFont));
        table.addCell(cell);
        String accountNumbersList = getStringOfAccountNumbersList(subject.getAccountNumbers());
        cell.setPhrase(new Paragraph(accountNumbersList, tableSpecialFontBold));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.REGISTRATION_TAXPAYER_DATE_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getRegistrationLegalDate(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.REGISTRATION_REJECT_TAXPAYER_DATE_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getRegistrationDenialDate(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.REGISTRATION_REMOVE_TAXPAYER_DATE_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getRemovalDate(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.REGISTRATION_RECOVER_TAXPAYER_DATE_CELL.toString(), tableFont));
        table.addCell(cell);
        cell.setPhrase(new Paragraph(subject.getRestorationDate(), tableFont));
        table.addCell(cell);

        cell.setPhrase(new Paragraph(PdfEnum.SEARCH_ID.toString() + requestId));
        cell.setColspan(2);
        table.addCell(cell);

    }

    private String getStringOfAccountNumbersList(List<String> accountNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        accountNumbers.forEach(element -> stringBuilder
                .append(element)
                .append(" "));

        return stringBuilder.toString();
    }

    private void addMetaData(Document document, String title, String subject, String creator) {
        document.addTitle(title);
        document.addSubject(subject);
        document.addCreator(creator);
    }

    private String getStringOfAuthorizedClerksList(List<AuthorizedClerk> authorizedClerkList) {
        StringBuilder stringBuilder = new StringBuilder();
        authorizedClerkList.forEach(element -> stringBuilder
                .append(element.getFirstName())
                .append(" ")
                .append(element.getLastName())
                .append(" - ")
                .append(element.getNip())
                .append(" "));
        return stringBuilder.toString();
    }

    private String getStringOfRepresentativesList(List<Representative> representativeList) {
        StringBuilder stringBuilder = new StringBuilder();
        representativeList.forEach(element -> stringBuilder
                .append(element.getFirstName())
                .append(" ")
                .append(element.getLastName())
                .append(" - ")
                .append(element.getNip())
                .append(" "));
        return stringBuilder.toString();
    }

    private String getStringOfPartnersList(List<Partner> partnersList) {
        StringBuilder stringBuilder = new StringBuilder();
        partnersList.forEach(element -> stringBuilder
                .append(element.getFirstName())
                .append(" ")
                .append(element.getLastName())
                .append(" - ")
                .append(element.getNip())
                .append(" "));
        return stringBuilder.toString();
    }

}
