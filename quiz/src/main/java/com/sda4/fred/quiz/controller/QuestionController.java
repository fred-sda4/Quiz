package com.sda4.fred.quiz.controller;

import javax.servlet.http.HttpServletRequest;

import com.sda4.fred.quiz.model.GivenAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.model.Quiz;
import com.sda4.fred.quiz.service.GivenAnswerService;
import com.sda4.fred.quiz.service.QuestionService;
import com.sda4.fred.quiz.service.ResultService;

import java.util.Iterator;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private GivenAnswerService givenAnswerService;

    @Autowired
    private ResultService resultService;

    @PostMapping("/nextQuestion")
    public ModelAndView authenticateUser(@SessionAttribute("quiz") Quiz quiz, @ModelAttribute("question") Question question, ModelMap model, HttpServletRequest request) {

        try {

            String actionParam = request.getParameter("action");
            String questionId = request.getParameter("questionId");
            String select[] = request.getParameterValues("answer");
            //String select = request.getParameter("answer");

            Object ceva = model.get("question");

            if (select != null && select.length != 0) {
                System.out.println("You have selected: ");
                for (int i = 0; i < select.length; i++) {
                    System.out.println(select[i]);
                    //TODO Check if record already exists, if not then create it
                    GivenAnswer existingAnswer = givenAnswerService.getOneByQuizIdAndQuestionId(quiz.getId(), Long.parseLong(questionId));
                    if(null == existingAnswer){
                        givenAnswerService.create(quiz.getId(), Long.parseLong(questionId), select[i]);
                    } else {
                        //update
                        givenAnswerService.update(existingAnswer, questionId, quiz.getId(), select[i]);
                    }

                }
            }

            long lastQuestionId = quiz.getQuestions().size();
            Question q = null;
            if("Finish Quiz".equals(actionParam)) {
                // actionParam == Finish Exam
                // calculate score
                // redirect to score page

                double result = resultService.calculateResult(quiz);
                model.put("result", result);
                //request.getSession().invalidate();

                return new ModelAndView("result", model);
            } else if ("Next".equals(actionParam)) {
                q = questionService.getById(lastQuestionId + 1);
                quiz.getQuestions().add(q);
            } else if ("Previous".equals(actionParam)) {
                Question lastQuestion = questionService.getById(lastQuestionId);
                Iterator<Question> it = quiz.getQuestions().iterator();
                while (it.hasNext()) {
                    Question quest = (Question)it.next();
                    if (quest.getId() == lastQuestion.getId()) {
                        it.remove();
                    }
                }
                //quiz.getQuestions().remove(lastQuestion);
                q = questionService.getById(lastQuestionId - 1);
            }


            model.put("question", q);
            model.put("quiz", quiz);

        } catch (Exception ex ){
            ex.printStackTrace();
        }

        return new ModelAndView("question", model);
    }

//	@ModelAttribute("question")
//	public Question getById(Long id) {
//		return questionService.getById(id);
//	}
}
