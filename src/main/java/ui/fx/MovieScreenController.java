package ui.fx;
import java.net.URL;
import java.util.ResourceBundle;

import domain.Review;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import domain.Movie;
import domain.MovieService;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.MovieException;


public class MovieScreenController {

    private  MovieService service = new MovieService();

    public void setService(MovieService service){
        this.service = service;
        showReview();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imgCover;

    @FXML
    private ListView<Movie> lstResults;

    @FXML
    private Spinner<Integer> spnScore;

    @FXML
    private TextField txtReviewText;

    @FXML
    private TextField txtSearch;

    @FXML
    private ListView<Review> lstReview;



    @FXML
    void onAddReview(ActionEvent event) {
       try {
           service.addReview(lstResults.getSelectionModel().getSelectedItem(), txtReviewText.getText(), spnScore.getValue());

           Alert a = new Alert(Alert.AlertType.INFORMATION, "Send");
           a.show();
       }
       catch (MovieException ex){
           Alert a = new Alert(Alert.AlertType.ERROR, ex.getMessage());
           a.show();
       }
        showReview();
    }

    @FXML
    void onDisplayMovie(ActionEvent event) {
        Movie movie = lstResults.getSelectionModel().getSelectedItem();
        imgCover.setImage(new Image(movie.getCoverUrl()));
    }

    @FXML
    void onSearch(ActionEvent event) {
        lstResults.setItems(FXCollections.observableArrayList(
                service.getMovies(txtSearch.getText())
        ));
    }

    @FXML
    void initialize() {
        assert imgCover != null : "fx:id=\"imgCover\" was not injected: check your FXML file 'MovieReview.fxml'.";
        assert lstResults != null : "fx:id=\"lstResults\" was not injected: check your FXML file 'MovieReview.fxml'.";
        assert lstReview != null : "fx:id=\"lstReview\" was not injected: check your FXML file 'MovieReview.fxml'.";
        assert spnScore != null : "fx:id=\"spnScore\" was not injected: check your FXML file 'MovieReview.fxml'.";
        assert txtReviewText != null : "fx:id=\"txtReviewText\" was not injected: check your FXML file 'MovieReview.fxml'.";
        assert txtSearch != null : "fx:id=\"txtSearch\" was not injected: check your FXML file 'MovieReview.fxml'.";
    }

    void showReview(){
        lstReview.setItems(FXCollections.observableArrayList(service.getReviews()));
    }
}

