module cwiklinski.me {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires itextpdf;

    opens cwiklinski.me to javafx.fxml;
    opens cwiklinski.me.model to com.fasterxml.jackson.databind;
    exports cwiklinski.me;
}