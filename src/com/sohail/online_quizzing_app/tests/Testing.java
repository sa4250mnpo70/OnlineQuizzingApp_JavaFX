/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.tests;

import com.sohail.online_quizzing_app.methods.Images;
import com.sohail.online_quizzing_app.model.Metadata;
import com.sohail.online_quizzing_app.model.pojo.OptionStructure;
import com.sohail.online_quizzing_app.model.pojo.QuestionStructure;
import com.sohail.online_quizzing_app.model.pojo.QuizStructure;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author sohail.alam
 */
public class Testing extends Application {

    @Override
    public void stop() throws Exception {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }

    private static Testing instance;
    private Stage stage;

    public Testing() {
        instance = this;
    }

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        System.out.println("****************************** Testing XML Serialization ******************************");
//        testXMLSerialization();
//        System.out.println("**************************** Testing Model HashMap Entries ****************************");
//        testModelHashMapEntries();
//        System.out.println("**************************** Testing FileChooser ****************************");
//        testFileChooser();
        System.out.println("**************************** Testing Image Read/Write ****************************");
        testImageReadWrite();
        
        stop();
    }

    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /*
     * Test XML Serialization
     * All data are hardcoded here
     */
    public static void testXMLSerialization() {
        OptionStructure option1 = new OptionStructure(1, "This is option 1.", UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
        option1.removeCorrectAnsFlag();
        OptionStructure option2 = new OptionStructure(2, "This is option 2.", UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
        option2.removeCorrectAnsFlag();

        ArrayList<OptionStructure> optionsList = new ArrayList<OptionStructure>();
        optionsList.add(option1);
        optionsList.add(option2);

        QuestionStructure question1 = new QuestionStructure(optionsList, 1, "Kid's Level", "This is question 1", UUID.randomUUID().toString(), UUID.randomUUID().toString());
        QuestionStructure question2 = new QuestionStructure(optionsList, 2, "Mind Boggling!", "This is question 2", UUID.randomUUID().toString(), UUID.randomUUID().toString());

        ArrayList<QuestionStructure> questionList = new ArrayList<QuestionStructure>();
        questionList.add(question1);
        questionList.add(question2);

        QuizStructure quiz = new QuizStructure(questionList, "Test", "Test1", "timeLimit", "duedate", "description", "totalQ", "solveQ", String.valueOf(UUID.randomUUID()));

        Serializer serialize = new Persister();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                byteArrayOutputStream);

        try {
            serialize.write(quiz, outputStreamWriter);
        } catch (Exception e) {
        }

        String xmlMsg = byteArrayOutputStream.toString();
        System.out.println(xmlMsg);
    }

    /*
     * Test Model HashMap Entries
     * You need to run the OnlineQuizzingApp and create a new quiz, question and option in 
     * order to test it!!
     */
    public static void testModelHashMapEntries() {
        Metadata metadata = Metadata.getInstance();
        Iterator<String> iterator = null;

        // TEST
        System.out.println("***** QUIZ *****");
        HashMap<String, String> metadata_quiz = metadata.getQuizMetadata();
        iterator = metadata_quiz.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = metadata_quiz.get(key).toString();
            System.out.println(key + ": " + value);
        }

        // TEST
        System.out.println("***** QUESTION *****");
        HashMap<String, String> metadata_question = metadata.getQuestionMetadata();
        iterator = metadata_question.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = metadata_question.get(key).toString();
            System.out.println(key + ": " + value);
        }

        // TEST
        System.out.println("***** OPTION *****");
        HashMap<String, String> metadata_option = metadata.getOptionMetadata();
        iterator = metadata_option.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = metadata_option.get(key).toString();
            System.out.println(key + ": " + value);
        }
    }

    /*
     * Testing File Chooser with Image Filters
     */
    public static void testFileChooser() {
        FileChooser fileChooser = new FileChooser();
        //Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Images Only (JPEG, JPG, GIF, BMP)", "*.jpeg", "*.jpg", "*.gif", "*.bmp");
        fileChooser.getExtensionFilters().add(extFilter);
        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        System.out.println("Selected Image Path: " + file.getPath());
    }
    
    public static void testImageReadWrite(){
        String image_data = Images.getInstance().read();
        System.out.println("IMAGE DATA: " + image_data);
        
        Images.getInstance().write(image_data);
    }
}
