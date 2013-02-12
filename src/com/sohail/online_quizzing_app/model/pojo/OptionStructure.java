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

    @Attribute(name = "number", required = true)
    private int number;
    @Attribute(name = "text", required = true)
    private String text;
    @Attribute(name = "image", required = false)
    private byte[] image;
    @Attribute(name = "correctAns", required = false)
    private Boolean correctAns;
    @Attribute(name = "uuid", required = true)
    private String uuid;

    /**
     *
     */
    public OptionStructure() {
        super();
    }

    /**
     *
     * @param number
     * @param text
     * @param uuid
     */
    public OptionStructure(int number, String text, String uuid) {
        this.number = number;
        this.text = text;
        this.uuid = uuid;
    }

    /**
     *
     * @param number
     * @param text
     * @param image
     * @param uuid
     */
    public OptionStructure(int number, String text, byte[] image, String uuid) {
        this.number = number;
        this.text = text;
        this.image = image;
        this.uuid = uuid;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
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
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * @return the correctAns
     */
    public boolean isCorrectAns() {
        return correctAns;
    }

    /**
     * @param correctAns the correctAns to set
     */
    public void setCorrectAns(boolean correctAns) {
        this.correctAns = correctAns;
    }

    public void removeCorrectAnsFlag() {
        this.correctAns = null;
    }
}
