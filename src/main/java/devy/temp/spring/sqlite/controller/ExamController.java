package devy.temp.spring.sqlite.controller;

import devy.temp.spring.sqlite.service.ExamService;
import devy.temp.spring.sqlite.service.domain.Exam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExamController {

    private final Logger logger = LoggerFactory.getLogger(ExamController.class);

    @Autowired
    private ExamService examService;

    @ResponseBody
    @GetMapping("/exam")
    public Object exam() {
        List<Exam> exams = examService.selectExam();
        for(Exam exam : exams) {
            logger.info(exam.toString());
        }
        return exams;
    }

    @ResponseBody
    @GetMapping("/insert")
    public Object insert() {
        int i = examService.insertExam();
        logger.info("i = " + i);
        return i;
    }

}