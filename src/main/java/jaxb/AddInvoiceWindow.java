package jaxb;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jaxb_invoice.*;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;

public class AddInvoiceWindow extends Application {

    private TextArea payerNameTextArea = new TextArea(), payerSurnameTextArea = new TextArea(), payerNumberTextArea = new TextArea(),
            payerStreetTextArea = new TextArea(), payerCityTextArea = new TextArea(), sellerNameTextArea = new TextArea(),
            sellerSurnameTextArea = new TextArea(), sellerNumberTextArea = new TextArea(), sellerStreetTextArea = new TextArea(),
            sellerCityTextArea = new TextArea(), QuantityTextArea = new TextArea(), DescriptionTextArea = new TextArea(),
            TaxTextArea = new TextArea(), NetTextArea = new TextArea(), unitsTextArea = new TextArea();

    private Label NameLabel = new Label("Name"), surnameLabel = new Label("Surname"), NumberLabel = new Label("Number"),
            StreetLabel = new Label("Street"), CityLabel = new Label("City"), QuantityLabel = new Label("Quantity"),
            DescriptionLabel = new Label("Description"), TaxLabel = new Label("Tax"), NetLabel = new Label("Net"),
            unitsLabel = new Label("Units"), payerLabel = new Label("Payer"),
            sellerLabel = new Label("Seller"),  newInvoiceLabel = new Label("New invoice"),
            productLabel = new Label("Product"), contactDetailsLabel = new Label("Contact details");

    private TableView<Product> tableView = new TableView();

    private final ObservableList<Product> data = FXCollections.observableArrayList();

    private TableColumn quantityCol = new TableColumn("Quantity");
    private TableColumn descriptionCol = new TableColumn("Description");
    private TableColumn taxCol = new TableColumn("Tax");
    private TableColumn netCol = new TableColumn("Net");
    private TableColumn grossCol = new TableColumn("Gross");
    private TableColumn amountCol = new TableColumn("Amount");

    private Separator separator = new Separator();
    private Separator separator2 = new Separator();

    private Button submitButton = new Button("Submitt!");
    private Button addButton = new Button("Add");

    private double prefColumnHeight = 20;
    private double prefColumnWidth = 200;

    private int invoiceIterator = 1;

    private void setTables(){
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        taxCol.setCellValueFactory(new PropertyValueFactory<>("tax"));
        netCol.setCellValueFactory(new PropertyValueFactory<>("net"));
        grossCol.setCellValueFactory(new PropertyValueFactory<>("gross"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        tableView.setItems(data);
        tableView.getColumns().addAll(quantityCol, descriptionCol, taxCol, netCol, grossCol, amountCol);
    }

    private GridPane createPane() {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setHgap(10);
        pane.setVgap(10);
        return pane;
    }

    private void setUIControls(GridPane pane, Stage primaryStage) {

        setTables();

        pane.add(contactDetailsLabel, 0,0);


        NameLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        surnameLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        NumberLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        StreetLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        CityLabel.setMaxSize(prefColumnWidth,prefColumnHeight);

        sellerLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        sellerNameTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        sellerSurnameTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        sellerNumberTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        sellerStreetTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        sellerCityTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);

        payerLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        payerNameTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        payerSurnameTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        payerNumberTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        payerStreetTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        payerCityTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);

        pane.add(NameLabel,0,2);
        pane.add(surnameLabel,0,3);
        pane.add(NumberLabel,0,4);
        pane.add(StreetLabel,0,5);
        pane.add(CityLabel,0,6);

        pane.add(sellerLabel,1,1);
        pane.add(sellerNameTextArea,1,2);
        pane.add(sellerSurnameTextArea,1,3);
        pane.add(sellerNumberTextArea,1,4);
        pane.add(sellerStreetTextArea,1,5);
        pane.add(sellerCityTextArea,1,6);

        pane.add(payerLabel,2,1);
        pane.add(payerNameTextArea,2,2);
        pane.add(payerSurnameTextArea,2,3);
        pane.add(payerNumberTextArea,2,4);
        pane.add(payerStreetTextArea,2,5);
        pane.add(payerCityTextArea,2,6);

        separator.setOrientation(Orientation.HORIZONTAL);

        pane.add(separator, 0,7, 3, 1);

        pane.add(productLabel,0,8 );
        pane.add(DescriptionLabel,0,9);
        pane.add(TaxLabel,0,10);
        pane.add(NetLabel,0,11);
        pane.add(unitsLabel,0,12);


        pane.add(DescriptionTextArea,1,9);
        pane.add(TaxTextArea,1,10);
        pane.add(NetTextArea,1,11);
        pane.add(unitsTextArea,1,12);

        pane.add(addButton, 2, 13);
        addButton.setMaxSize(prefColumnWidth,prefColumnHeight);

        QuantityTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        DescriptionTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        TaxTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        NetTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);
        unitsTextArea.setMaxSize(prefColumnWidth,prefColumnHeight);

        QuantityLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        productLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        DescriptionLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        TaxLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        NetLabel.setMaxSize(prefColumnWidth,prefColumnHeight);
        unitsLabel.setMaxSize(prefColumnWidth,prefColumnHeight);

        separator2.setOrientation(Orientation.HORIZONTAL);

        pane.add(separator2, 0,14, 3, 1);

        pane.add(tableView, 0,15, 3, 2);

        pane.add(submitButton, 2 ,17);

        submitButton.setMaxSize(prefColumnWidth,prefColumnHeight);

        addButton.setOnAction(e -> addProduct());

        submitButton.setOnAction(e -> {
            try {
                addInvoice();
            } catch (JAXBException e1) {
                e1.printStackTrace();
            }
        });
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        GridPane gridPane = createPane();
        setUIControls(gridPane, primaryStage);
        primaryStage.setScene(new Scene(gridPane, 600, 900));
        primaryStage.show();
        primaryStage.setTitle(String.valueOf(newInvoiceLabel.getText()));
    }

    private void addProduct() {

        Product p = new Product();

        p.setQuantity(BigDecimal.valueOf(invoiceIterator++));
        p.setDescription(DescriptionTextArea.getText());
        p.setNet(BigDecimal.valueOf(Long.parseLong(NetTextArea.getText())));
        p.setGross(BigDecimal.valueOf(Long.parseLong(unitsTextArea.getText())));
        p.setTax(BigDecimal.valueOf(Long.parseLong(TaxTextArea.getText())));

        p.setAmount(p.getNet().add(p.getGross().multiply(p.getNet().divide(BigDecimal.valueOf(100))).multiply(p.getTax())));

        data.add(p);

    }

    private void addInvoice() throws JAXBException {

        Invoice i = new Invoice();

        Address sAddress = new Address();
        sAddress.setStreet(sellerStreetTextArea.getText());
        sAddress.setCity(sellerCityTextArea.getText());

        Seller s = new Seller();
        s.setFirstName(sellerNameTextArea.getText());
        s.setLastName(sellerSurnameTextArea.getText());
        s.setContactNo(sellerNumberTextArea.getText());
        s.setAddress(sAddress);

        Address pAddress = new Address();
        pAddress.setStreet(payerStreetTextArea.getText());
        pAddress.setCity(payerCityTextArea.getText());

        Payer p = new Payer();
        p.setFirstName(payerNameTextArea.getText());
        p.setLastName(payerSurnameTextArea.getText());
        p.setContactNo(payerNumberTextArea.getText());
        p.setAddress(pAddress);


        i.setInvoiceID("invoice_" + invoiceIterator);
        i.setSeller(s);
        i.setPayer(p);

        for(Product product : data){
            i.setProduct(product);
        }

        Marshaller invoiceMarshaller = new Marshaller(i);

        invoiceMarshaller.createXML("data/invoice_" + invoiceIterator++);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
