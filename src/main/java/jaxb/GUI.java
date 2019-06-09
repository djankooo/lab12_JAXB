package jaxb;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    private Button addInvoice = new Button("Add invoice");
    private Button editInvoice = new Button("Edit invoice");

    private GridPane createPane() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setHgap(10);
        pane.setVgap(10);
        return pane;
    }

    private void setUIControls(GridPane pane, Stage primaryStage) throws Exception {
        pane.add(addInvoice, 0,0);
        pane.add(editInvoice, 0,1);

        addInvoice.setOnAction(event -> {
            try {
                Stage addingStage = new Stage();
                AddInvoiceWindow add = new AddInvoiceWindow();
                add.start(addingStage);
                addingStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        editInvoice.setOnAction(event -> {
            try {
                Stage addingStage = new Stage();
                EditInvoiceWindow add = new EditInvoiceWindow();
                add.start(addingStage);
                addingStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        GridPane gridPane = createPane();
        setUIControls(gridPane, primaryStage);
        primaryStage.setScene(new Scene(gridPane, 1000, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
