package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	// 서버로부터 포스트 가져오기
	
	// 서버로 포스트 추가하기
	
	// 관람시간 반영
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// stage > scene > container(pane) > node
			
			Image image1 = new Image("file:seadog.png");
			Image image2 = new Image("file:default.png");
			ImageView iv = new ImageView();
			iv.setImage(image1);
			iv.setPreserveRatio(true);
			iv.setFitWidth(500);
			iv.setFitHeight(600);
			
			
			// 각 버튼마다 이벤트 추가해야함
			Button btn1 = new Button();
			btn1.setText("<");
			btn1.setStyle("-fx-font-size: 20;");
			btn1.setLayoutY(350);
			btn1.setOnAction(event -> {
				Platform.runLater(() -> {
					iv.setImage(image1);
				});
			});
			
			Button btn2 = new Button();
			btn2.setText(">");
			btn2.setStyle("-fx-font-size: 20;");
			btn2.setLayoutY(350);
			btn2.setOnAction(event -> {
				Platform.runLater(() -> {
					iv.setImage(image2);
				});
			});
			
			Button btnAdd = new Button();
			//"Upload"글자 크기 키우는 방법?
			btnAdd.setText("Upload");
			
			Pane lft = new Pane();
			// Pane의 공간이 어떻게 되는지 보려고 추가한 테두리 나중에 없애야함
			lft.setStyle("-fx-border-color: red;");
			lft.getChildren().add(btn1);
			
			Pane rgt = new Pane();
			rgt.getChildren().add(btn2);
			
			BorderPane bottom = new BorderPane();
			bottom.setPadding(new Insets(10));
			bottom.setCenter(btnAdd);
			
			BorderPane root = new BorderPane();
			BorderPane pane = new BorderPane();
			
			
			pane.setLeft(lft);
			pane.setRight(rgt);
			pane.setCenter(iv);
			pane.setBottom(bottom);
			
			root.setCenter(pane);
			
			Scene scene = new Scene(root, 600, 800);
			primaryStage.setTitle("[클라이언트]");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
