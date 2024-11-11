package nyj001012.er_bal.controller;

import nyj001012.er_bal.domain.Question;
import nyj001012.er_bal.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question")
    public Long post(@RequestBody String questionA, @RequestBody String questionB) {
        Date date = new Date();
        Question question = new Question();
        question.setQuestionA(questionA);
        question.setQuestionB(questionB);
        question.setCreatedDate(date);
        question.setUpdatedDate(date);
        return questionService.post(question);
    }
}
