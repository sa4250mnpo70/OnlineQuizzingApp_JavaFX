/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.model;

import java.util.HashMap;

/**
 *
 * @author SOHAIL
 */
public class Metadata {
    private static Metadata instance = new Metadata();

    public static Metadata getInstance() {
        return instance;
    }

    private HashMap<String, String> quizMetadata = new HashMap<>(8);
    private HashMap<String, String> questionMetadata = new HashMap<>();
    private HashMap<String, String> optionMetadata = new HashMap<>();

    private Metadata() {
        questionMetadata.put("question_number", "0");
        optionMetadata.put("option_number", "0");
    }
    
    public void addToQuizMetadata(String key, String value){
        quizMetadata.put(key, value);
    }
    
    public void addToQuestionMetadata(String key, String value){
        questionMetadata.put(key, value);
    }
    
    public void addToOptionMetadata(String key, String value){
        
    }

    /**
     * @return the quizMetadata
     */
    public HashMap<String, String> getQuizMetadata() {
        return quizMetadata;
    }

    /**
     * @param quizMetadata the quizMetadata to set
     */
    public void setQuizMetadata(HashMap<String, String> quizMetadata) {
        this.quizMetadata = quizMetadata;
    }

    /**
     * @return the questionMetadata
     */
    public HashMap<String, String> getQuestionMetadata() {
        return questionMetadata;
    }

    /**
     * @param questionMetadata the questionMetadata to set
     */
    public void setQuestionMetadata(HashMap<String, String> questionMetadata) {
        this.questionMetadata = questionMetadata;
    }

    /**
     * @return the optionMetadata
     */
    public HashMap<String, String> getOptionMetadata() {
        return optionMetadata;
    }

    /**
     * @param optionMetadata the optionMetadata to set
     */
    public void setOptionMetadata(HashMap<String, String> optionMetadata) {
        this.optionMetadata = optionMetadata;
    }
}
