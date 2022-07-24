package com.example.comp1011m2022ice9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable
{

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<Movie> resultsListView;

    @FXML
    private TextField searchTextField;

    @FXML
    void searchButtonClicked(ActionEvent event)
    {
        String val = searchTextField.getText();
        var searchResults = APIManager.Instance().getMovieFromOMDBBySearchTerm(val);
        resultsListView.getItems().clear();
        if(searchResults.getMovies() != null){
            resultsListView.getItems().addAll(searchResults.getMovies());

            resultsListView.getSelectionModel().select(0);
        }
        else
        {
            // movie was not found - maybe output to a message label of some kind
        }
    }

    @FXML
    void searchTextFieldSubmitted(ActionEvent event)
    {
        searchButtonClicked(event);
        resultsListView.requestFocus();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        resultsListView.getSelectionModel().selectedItemProperty().addListener((obs, oldMovieSelected, newMovieSelected) ->{
            System.out.println(newMovieSelected);
            try
            {
                if(newMovieSelected.getPoster()!=null)
                {
                    imageView.setImage(new Image(newMovieSelected.getPoster()));
                }
                else {
                    imageView.setImage(new Image("https://trailerfailure.com/img/images/missingConverPhoto.jpg"));
                }

                }catch(Exception exception)
            {

            }
        });
        }
    }


