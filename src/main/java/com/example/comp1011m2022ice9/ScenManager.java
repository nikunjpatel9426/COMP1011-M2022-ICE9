package com.example.comp1011m2022ice9;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScenManager
{
    /******************singleton*****************/
        // Step 1. private static instance member variable
        private static ScenManager m_instance = null;

        // Step 2. make the default constructor private
        private ScenManager() {}

        // Step 3. Create a public static entry point / instance method
        public static ScenManager Instance() {

            //Step 4. Check if the private instance member variable is null
            if (m_instance == null) {

                //Step 5. Initiate a new ScenManager instance
                m_instance = new ScenManager();
            }
            return m_instance;
        }

        /*************************/

        public void changeScene(ActionEvent event, String FXMLFileName) throws IOException
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(FXMLFileName));
            Scene scene = new Scene(fxmlLoader.load());

            // derive the stage (window) from the action event (button press)
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
}