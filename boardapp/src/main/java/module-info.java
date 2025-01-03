module com.wi {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires lombok;
    requires java.sql;

    opens com.wi to javafx.graphics, javafx.fxml, java.sql;
    opens com.wi.Controller to javafx.fxml;
    opens com.wi.DTO to javafx.base;
    exports com.wi;
}
