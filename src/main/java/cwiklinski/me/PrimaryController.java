package cwiklinski.me;

import com.itextpdf.text.DocumentException;
import cwiklinski.me.model.SuperModel;
import cwiklinski.me.service.ApiService;
import cwiklinski.me.service.PdfCreator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PrimaryController {

    @FXML
    private TextField input;

    private PdfCreator pdfcreator;
    private ApiService apiService;
    private SuperModel supermodel;

    public PrimaryController() {
    }

    @FXML
    private void createPdfs(ActionEvent event) {
        apiService = new ApiService();

        try {
            pdfcreator = new PdfCreator();
        } catch (IOException | DocumentException e) {
            showError("Problem z plikiem czcionki");
        }

        try {
         supermodel = apiService.fetchSubjectInformation(input.getText());
        }catch (NullPointerException e) {
            showError("brak nipów!");
            System.out.println(e.getMessage());
        }catch (IOException e) {
            e.printStackTrace();
            showError("zwrócono kod błędu: ");

        }

        try {
            pdfcreator.createPdfFile(supermodel);
        } catch (IOException | DocumentException e) {
           showError("Problem z zapisem do pliku pdf!");
        }
    }

    private void showError(String error) {
        Alert alert = new Alert(Alert.AlertType.WARNING
                ,error
                ,ButtonType.CLOSE);
        alert.showAndWait();
    }


}
