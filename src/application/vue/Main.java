package application.vue;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(
					"Sample.fxml"));
			Parent root = loader.load();
			Controller controller = loader.getController();

			primaryStage.setTitle("Gestion de pharmacies");
			primaryStage.setScene(new Scene(root, 800, 600));
			primaryStage.setResizable(false);
			primaryStage.show();

			//splitpanebase.lookupAll(".split-pane-divider").stream()
			//		.forEach(div ->  div.setMouseTransparent(true) );
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
