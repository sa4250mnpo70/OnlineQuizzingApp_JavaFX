/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.model.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 *
 * @author sohail.alam
 */
@Root(name = "Option")
public class OptionStructure {

    @Attribute(name = "option_number", required = true)
    private int option_number;
    @Attribute(name = "option", required = true)
    private String option;
    @Attribute(name = "option_image", required = false)
    private byte[] option_image;
    @Attribute(name = "correct_answer", required = false)
    private String correct_answer;
    @Attribute(name = "uuid", required = true)
    private String uuid;
    @Attribute(name = "uuid_quiz", required = true)
    private String uuid_quiz;
    @Attribute(name = "uuid_question", required = true)
    private String uuid_question;

    /**
     *
     */
    public OptionStructure() {
        super();
    }

    /**
     *
     * @param option_number
     * @param option
     * @param uuid
     * @param uuid_quiz
     * @param uuid_question
     */
    public OptionStructure(int option_number, String option, String uuid, String uuid_quiz, String uuid_question) {
        this.option_number = option_number;
        this.option = option;
        this.uuid = uuid;
        this.uuid_quiz = uuid_quiz;
        this.uuid_question = uuid_question;
    }

    /**
     *
     * @param option_number
     * @param option
     * @param option_image
     * @param uuid
     * @param uuid_quiz
     * @param uuid_question
     */
    public OptionStructure(int option_number, String option, byte[] option_image, String uuid, String uuid_quiz, String uuid_question) {
        this.option_number = option_number;
        this.option = option;
        this.option_image = option_image;
        this.uuid = uuid;
        this.uuid_quiz = uuid_quiz;
        this.uuid_question = uuid_question;
    }

    /**
     * @return the option_number
     */
    public int getNumber() {
        return option_number;
    }

    /**
     * @param option_number the option_number to set
     */
    public void setNumber(int option_number) {
        this.option_number = option_number;
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
     * @return the option
     */
    public String getText() {
        return option;
    }

    /**
     * @param option the option to set
     */
    public void setText(String option) {
        this.option = option;
    }

    /**
     * @return the option_image
     */
    public byte[] getImage() {
        return option_image;
    }

    /**
     * @param option_image the option_image to set
     */
    public void setImage(byte[] option_image) {
        this.option_image = option_image;
    }

    /**
     * @return the correct_answer
     */
    public String isCorrectAns() {
        return correct_answer;
    }

    /**
     * @param correct_answer the correct_answer to set
     */
    public void setCorrectAns(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public void removeCorrectAnsFlag() {
        this.correct_answer = null;
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

    /**
     * @return the uuid_question
     */
    public String getUuid_question() {
        return uuid_question;
    }

    /**
     * @param uuid_question the uuid_question to set
     */
    public void setUuid_question(String uuid_question) {
        this.uuid_question = uuid_question;
    }
}
