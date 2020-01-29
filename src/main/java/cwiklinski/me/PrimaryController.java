package cwiklinski.me;

import com.itextpdf.text.DocumentException;
import cwiklinski.me.model.SuperModel;
import cwiklinski.me.service.ApiService;
import cwiklinski.me.service.PdfCreator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PrimaryController {

    @FXML
    private TextField input;

    private PdfCreator pdfcreator;
    private ApiService apiService;

    public PrimaryController() {
    }

    @FXML
    private void createPdfs(ActionEvent event) throws IOException, DocumentException, IllegalArgumentException {
        pdfcreator = new PdfCreator();
        apiService = new ApiService();

        SuperModel supermodel = apiService.fetchSubjectInformation(input.getText());
        pdfcreator.createPdfFile(supermodel);
    }


}
