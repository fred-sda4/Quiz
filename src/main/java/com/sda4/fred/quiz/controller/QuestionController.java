package com.sda4.fred.quiz.controller;

import com.sda4.fred.quiz.model.GivenAnswer;
import com.sda4.fred.quiz.model.Question;
import com.sda4.fred.quiz.model.Quiz;
import com.sda4.fred.quiz.service.GivenAnswerService;
import com.sda4.fred.quiz.service.QuestionService;
import com.sda4.fred.quiz.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(value = "/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private GivenAnswerService givenAnswerService;

    @Autowired
    private ResultService resultService;

    @RequestMapping(value ="/all", method = RequestMethod.GET)
    public ResponseEntity <List<Question>> getQuestions(){
        List<Question> questions = questionService.findAll();
        if (questions.isEmpty()){

            return new ResponseEntity<List<Question>>(HttpStatus.NO_CONTENT);
        }else {

            return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
        }
    }


    @PostMapping("/nextQuestion")
    public ModelAndView authenticateUser(@SessionAttribute("quiz")Quiz quiz , @ModelAttribute("question") Question question , ModelMap model , HttpServletRequest request){

        try{

            String actionParam = request.getParameter("action");
            String questionId = request.getParameter("questionId");
            String [] select = request.getParameterValues("answer");

            /*
             * String aberatieParam = request.getParameter("aberatie");
             * System.out.println("ABERATIE PARAM" + aberatieParam.toString());
             **/

            Object ceva = model.get("question");

            if (select != null && select.length != 0) {
                System.out.println("You have selected: ");
                for (int i = 0; i < select.length; i++) {
                    System.out.println(select[i]);
                    //TODO Check if record already exists, if not then create it

                   GivenAnswer existingAnswer = (GivenAnswer) givenAnswerService.getAllByQuizIdAndQuestionIdAndAnswerId(quiz.getId(), Long.parseLong(questionId), Long.parseLong(select[i]));
                    if(null == existingAnswer){
                        givenAnswerService.create(quiz.getId(), Long.parseLong(questionId), Long.parseLong(select[i]));
                    } else {
                        //update
                        givenAnswerService.update(existingAnswer, select[i]);
                    }

                }
            }

            long lastQuestionId = quiz.getQuestions().size() ;

            Question q = null ;

            if ("FinishQuiz".equals(actionParam)){

                // actionParam == Finish Quiz
                // calculate score
                // redirect to score page

                double result = resultService.calculateResult(quiz);

                model.put("result",result);

                return new ModelAndView("result",model);
            } else if ("Next".equals(actionParam)){

                q = questionService.getById(lastQuestionId + 1 ) ;

                quiz.getQuestions().add(q);

            } else if ("Previous".equals(actionParam)) {

                Question lastQuestion = questionService.getById(lastQuestionId);

                Iterator<Question> it = quiz.getQuestions().iterator();

                while (it.hasNext()) {

                    Question question2 = (Question) it.next() ;

                    if (question2.getId() == lastQuestion.getId()) {

                        it.remove();
                    }
                }

                q = questionService.getById(lastQuestionId - 1 ) ;
            }

            model.put("question", q) ;

            model.put("quiz" , quiz);


        } catch (Exception e) {

            e.printStackTrace();
        }

        return new ModelAndView("result",model);
    }

}
