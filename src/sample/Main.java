package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Ejemplo Ventanas de Diálogo");

        VBox pnlOpciones = new VBox();

        RadioButton rbAlertaInformacion = new RadioButton("Ventana de alerta de Información");
        RadioButton rbAlertaPrecaucion = new RadioButton("Ventana de alerta de precaución");
        RadioButton rbAlertaError = new RadioButton("Ventana de alerta de error");

        ToggleGroup radioGroup = new ToggleGroup();

        rbAlertaInformacion.setToggleGroup(radioGroup);
        rbAlertaPrecaucion.setToggleGroup(radioGroup);
        rbAlertaError.setToggleGroup(radioGroup);

        pnlOpciones.getChildren().addAll(rbAlertaInformacion,
                rbAlertaPrecaucion,
                rbAlertaError);

        primaryStage.setScene(new Scene(pnlOpciones, 400, 300));
        primaryStage.show();

        rbAlertaInformacion.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Look, an Information Dialog");
                        alert.setContentText("I have a great message for you!");

                        alert.initOwner(primaryStage);
                        alert.showAndWait();
                    }
                });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
