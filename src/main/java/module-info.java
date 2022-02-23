module com.pmp.javafx101 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.pmp.javafx101 to javafx.fxml;
    exports com.pmp.javafx101;
}
