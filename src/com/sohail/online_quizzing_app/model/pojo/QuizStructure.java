/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author sohail.alam
 */
@Root(name = "Quiz")
public class QuizStructure implements Serializable {

    private static final long serialVersionUID = 3443757615530896340L;
    @ElementList(required = false, empty = false, inline = true, type = QuestionStructure.class)
    private ArrayList<QuestionStructure> question;
    @ElementList(required = false, empty = false, inline = true, type = OptionStructure.class)
    private ArrayList<OptionStructure> option;
    @Attribute(name = "subject", required = true)
    private String subject;
    @Attribute(name = "topic", required = true)
    private String topic;
    @Attribute(name = "time_limit", required = true)
    private String time_limit;
    @Attribute(name = "due_date", required = false)
    private String due_date;
    @Attribute(name = "description", required = false)
    private String description;
    @Attribute(name = "total_questions", required = true)
    private String total_questions;
    @Attribute(name = "total_questions_to_solve", required = true)
    private String total_questions_to_solve;
    @Attribute(name = "submission_date", required = true)
    private String submission_date;
    @Attribute(name = "uuid", required = true)
    private String uuid;

    /**
     *
     */
    public QuizStructure() {
        question = new ArrayList<QuestionStructure>();
    }

    /**
     *
     * @param question
     * @param subject
     * @param topic
     * @param timeLimit
     * @param due_date
     * @param description
     * @param total_questions_in_quiz
     * @param total_questions_to_solve
     * @param uuid
     */
    public QuizStructure(ArrayList<QuestionStructure> question,
            String subject, String topic, String timeLimit, String due_date, String description, String total_questions_in_quiz, String total_questions_to_solve, String submission_date, String uuid) {
        this.question = question;
        this.subject = subject;
        this.topic = topic;
        this.time_limit = timeLimit;
        this.due_date = due_date;
        this.description = description;
        this.total_questions = total_questions_in_quiz;
        this.total_questions_to_solve = total_questions_to_solve;
        this.submission_date = submission_date;
        this.uuid = uuid;
    }

    /**
     *
     * @param question
     */
    public void addAllQuestions(ArrayList<QuestionStructure> question) {
        this.question.addAll(question);
    }

    /**
     *
     * @param question
     */
    public void addToQuestionList(QuestionStructure question) {
        this.question.add(question);
    }

    /**
     *
     * @return
     */
    public ArrayList<QuestionStructure> getQuestions() {
        return this.question;
    }

    /**
     *
     */
    public void clearQuestions() {
        this.question.clear();
    }

    /**
     * @param paramList the paramList to set
     */
    public void setOptionList(ArrayList<OptionStructure> option) {
        this.option = option;
    }

    /**
     * @return the paramList
     */
    public ArrayList<OptionStructure> getOptionList() {
        return option;
    }

    /**
     * @return the question
     */
    public ArrayList<QuestionStructure> getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(ArrayList<QuestionStructure> question) {
        this.question = question;
    }

    /**
     * @return the option
     */
    public ArrayList<OptionStructure> getOption() {
        return option;
    }

    /**
     * @param option the option to set
     */
    public void setOption(ArrayList<OptionStructure> option) {
        this.option = option;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * @return the timeLimit
     */
    public String getTimeLimit() {
        return time_limit;
    }

    /**
     * @param timeLimit the timeLimit to set
     */
    public void setTimeLimit(String timeLimit) {
        this.time_limit = timeLimit;
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
     * @return the due_date
     */
    public String getDue_date() {
        return due_date;
    }

    /**
     * @param due_date the due_date to set
     */
    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the total_questions_in_quiz
     */
    public String getTotal_questions_in_quiz() {
        return total_questions;
    }

    /**
     * @param total_questions_in_quiz the total_questions_in_quiz to set
     */
    public void setTotal_questions_in_quiz(String total_questions_in_quiz) {
        this.total_questions = total_questions_in_quiz;
    }

    /**
     * @return the total_questions_to_solve
     */
    public String getTotal_questions_to_solve() {
        return total_questions_to_solve;
    }

    /**
     * @param total_questions_to_solve the total_questions_to_solve to set
     */
    public void setTotal_questions_to_solve(String total_questions_to_solve) {
        this.total_questions_to_solve = total_questions_to_solve;
    }

    /**
     * @return the submission_date
     */
    public String getSubmission_date() {
        return submission_date;
    }

    /**
     * @param submission_date the submission_date to set
     */
    public void setSubmission_date(String submission_date) {
        this.submission_date = submission_date;
    }
}
