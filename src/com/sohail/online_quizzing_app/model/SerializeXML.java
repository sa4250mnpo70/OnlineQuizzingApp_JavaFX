/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sohail.online_quizzing_app.model;

import com.sohail.online_quizzing_app.model.pojo.OptionStructure;
import com.sohail.online_quizzing_app.model.pojo.QuestionStructure;
import com.sohail.online_quizzing_app.model.pojo.QuizStructure;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author sohail.alam
 */
public class SerializeXML {

    private static SerializeXML instance;

    public static SerializeXML getInstance() {
        if (instance == null) {
            return instance = new SerializeXML();
        } else {
            return instance;
        }
    }
    private HashMap<Integer, HashMap<String, String>> option_set = null;
    private HashMap<Integer, HashMap<String, String>> question_set = null;
    private ArrayList<OptionStructure> optionsList = null;
    private ArrayList<ArrayList<OptionStructure>> array_of_option_lists = null;
    private ArrayList<QuestionStructure> questionsList = null;

    private SerializeXML() {
        option_set = new HashMap<>();
        question_set = new HashMap<>();
        optionsList = new ArrayList<OptionStructure>();
        questionsList = new ArrayList<QuestionStructure>();
        array_of_option_lists = new ArrayList<>();
    }

    public void clearOptionList() {
        optionsList = new ArrayList<OptionStructure>();
        //Reset the Options Counter
        Metadata metadata = Metadata.getInstance();
        metadata.getOptionMetadata().put("option_number", "0");
    }

    public void AddOptionsToQuestion(HashMap<String, String> map) {

        String option = map.get("option");
        String option_image = map.get("option_image");
        String correct_answer = map.get("correct_answer");
        int option_number = Integer.parseInt(map.get("option_number"));
        String uuid = map.get("uuid");
        String uuid_quiz = map.get("uuid_quiz");
        String uuid_question = map.get("uuid_question");

        OptionStructure option_structure = new OptionStructure(option_number, option, option_image, uuid, uuid_quiz, uuid_question);
        optionsList.add(option_structure);

        ArrayList<OptionStructure> localOptionsList = new ArrayList<>();
        localOptionsList = optionsList;
        Metadata metadata = Metadata.getInstance();
        HashMap<String, String> metadata_question = metadata.getQuestionMetadata();
        int question_number = Integer.parseInt(metadata_question.get("question_number"));
        array_of_option_lists.add(question_number - 1, localOptionsList);
    }

    public void AddQuestionsToQuiz(HashMap<String, String> map) {

        String question = map.get("question");
        String question_image = map.get("question_image");
        String difficulty = map.get("difficulty");
        int question_number = Integer.parseInt(map.get("question_number"));
        String uuid = map.get("uuid");
        String uuid_quiz = map.get("uuid_quiz");

        QuestionStructure question_structure = new QuestionStructure(array_of_option_lists.get(question_number - 1), question_number, difficulty, question, question_image, uuid, uuid_quiz);
        questionsList.add(question_structure);

        clearOptionList();
    }

    /**
     * Serialize the Options
     *
     * @return
     * @throws Exception
     */
    public String doOptionsSerialize() throws Exception {
        Serializer serializer = new Persister();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                byteArrayOutputStream);

        //Format the Question
        Metadata metadata = Metadata.getInstance();
        HashMap<String, String> metadata_option = metadata.getOptionMetadata();
        OptionStructure option = new OptionStructure();
        option.setCorrectAns(metadata_option.get("correct_answer"));
        option.setOptionImage(metadata_option.get("option_image"));
        option.setOption(metadata_option.get("option"));
        option.setOptionNumber(Integer.parseInt(metadata_option.get("option_number")));
        option.setUuid(metadata_option.get("uuid"));
        option.setUuid_question(metadata_option.get("uuid_question"));
        option.setUuid_quiz(metadata_option.get("uuid_quiz"));

        try {
            serializer.write(option, outputStreamWriter);
            String optionXML = byteArrayOutputStream.toString();
            return optionXML;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Serialize the Questions
     *
     * @return
     * @throws Exception
     */
    public String doQuestionsSerialize() throws Exception {
        Serializer serializer = new Persister();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                byteArrayOutputStream);

        //Format the Question
        Metadata metadata = Metadata.getInstance();
        HashMap<String, String> metadata_question = metadata.getQuestionMetadata();
        QuestionStructure question = new QuestionStructure();
        question.setDifficulty(metadata_question.get("difficulty"));
        question.setQuestionImage(metadata_question.get("question_image"));
        question.setQuestion(metadata_question.get("question"));
        question.setQuestionNumber(Integer.parseInt(metadata_question.get("question_number")));
        question.setUuid(metadata_question.get("uuid"));
        question.setUuid_quiz(metadata_question.get("uuid_quiz"));

        try {
            serializer.write(question, outputStreamWriter);
            String questionXML = byteArrayOutputStream.toString();
            return questionXML;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Serialize the Quiz
     *
     * @return
     * @throws Exception
     */
    public String doQuizSerialize() throws Exception {
        Serializer serializer = new Persister();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                byteArrayOutputStream);

        //Format the Quiz
        Metadata metadata = Metadata.getInstance();
        HashMap<String, String> metadata_quiz = metadata.getQuizMetadata();

        String description = metadata_quiz.get("description");
        String due_date = metadata_quiz.get("due_date");
        String subject = metadata_quiz.get("subject");
        String time_limit = metadata_quiz.get("time_limit");
        String topic = metadata_quiz.get("topic");
        String total_questions = metadata_quiz.get("total_questions");
        String total_questions_to_solve = metadata_quiz.get("total_questions_to_solve");
        String submission_date = metadata_quiz.get("submission_date");
        String uuid = metadata_quiz.get("uuid");

        QuizStructure quiz = new QuizStructure(questionsList, subject, topic, time_limit, due_date, description, total_questions, total_questions_to_solve, submission_date, uuid);

        try {
            serializer.write(quiz, outputStreamWriter);
            String quizXML = byteArrayOutputStream.toString();

            questionsList.clear();

            //TEST 
            System.out.println(quizXML);

            return quizXML;
        } catch (Exception e) {
            throw e;
        }
    }
}
