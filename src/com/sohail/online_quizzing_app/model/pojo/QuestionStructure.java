/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.model.pojo;

import java.util.ArrayList;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author sohail.alam
 */
@Root(name = "Question")
public class QuestionStructure {

    @ElementList(required = true, empty = false, inline = true, type = OptionStructure.class)
    private ArrayList<OptionStructure> optionList;
    @Attribute(name = "question_number", required = true)
    private int question_number;
    @Attribute(name = "difficulty", required = true)
    private String difficulty;
    @Attribute(name = "question", required = true)
    private String question;
    @Attribute(name = "question_image", required = false)
    private byte[] question_image;
    @Attribute(name = "uuid", required = true)
    private String uuid;
    @Attribute(name = "uuid_quiz", required = true)
    private String uuid_quiz;

    /**
     *
     */
    public QuestionStructure() {
        optionList = new ArrayList<OptionStructure>();
    }

    /**
     *
     * @param question_number 
     * @param difficulty
     * @param question
     * @param uuid
     * @param uuid_quiz  
     */
    public QuestionStructure(int question_number, String difficulty, String question, String uuid, String uuid_quiz) {

        this.question_number = question_number;
        this.difficulty = difficulty;
        this.question = question;
        this.uuid = uuid;
        this.uuid_quiz = uuid_quiz;
    }

    /**
     *
     * @param optionList
     * @param question_number 
     * @param difficulty
     * @param question
     * @param uuid
     * @param uuid_quiz  
     */
    public QuestionStructure(ArrayList<OptionStructure> optionList,
            int question_number, String difficulty, String question, String uuid, String uuid_quiz) {

        this.optionList = optionList;
        this.question_number = question_number;
        this.difficulty = difficulty;
        this.question = question;
        this.uuid = uuid;
        this.uuid_quiz = uuid_quiz;
    }

    /**
     *
     * @param optionList
     * @param question_number 
     * @param uuid
     * @param difficulty
     * @param question
     * @param image
     */
    public QuestionStructure(ArrayList<OptionStructure> optionList,
            int question_number, String difficulty, String question, byte[] image, String uuid) {

        this.optionList = optionList;
        this.question_number = question_number;
        this.difficulty = difficulty;
        this.question = question;
        this.question_image = image;
        this.uuid = uuid;
    }

    /**
     * @return the optionList
     */
    public ArrayList<OptionStructure> getOptionList() {
        return optionList;
    }

    /**
     *
     * @param optionList
     */
    public void setOptionList(ArrayList<OptionStructure> optionList) {
        this.optionList = optionList;
    }

    /*
     * 
     */
    public void addAllToOptionList(ArrayList<OptionStructure> optionList) {
        this.optionList.addAll(optionList);
    }

    /**
     *
     * @param option
     */
    public void addToOptionList(OptionStructure option) {
        this.optionList.add(option);
    }

    /**
     *
     * @param question_number
     * @param question
     */
    public void addToOptionList(int question_number, String question, String uuid) {
        this.optionList.add(new OptionStructure(question_number, question, uuid));
    }

    /**
     *
     * @param question_number
     * @param uuid
     * @param question
     * @param image
     */
    public void addToOptionList(int question_number, String question, byte[] image, String uuid) {
        this.optionList.add(new OptionStructure(question_number, question, image, uuid));
    }

    /**
     *
     */
    public void clearOptionList() {
        this.optionList.clear();
    }

    /**
     * @return the question_number
     */
    public int getQuestionNumber() {
        return question_number;
    }

    /**
     * @param question_number 
     */
    public void setQuestionNumber(int question_number) {
        this.question_number = question_number;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the difficulty
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * @return the image
     */
    public byte[] getImage() {
        return question_image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.question_image = image;
    }

    /**
     * @return the uuid_quiz
     */
    public String getUuid_quiz() {
        return uuid_quiz;
    }

    /**
     * @param uuid_quiz the uuid_quiz to set
     */
    public void setUuid_quiz(String uuid_quiz) {
        this.uuid_quiz = uuid_quiz;
    }
}
