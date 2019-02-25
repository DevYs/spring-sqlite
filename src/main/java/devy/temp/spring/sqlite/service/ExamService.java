package devy.temp.spring.sqlite.service;

import devy.temp.spring.sqlite.domain.Exam;
import devy.temp.spring.sqlite.service.mapper.ExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamMapper examMapper;

    public List<Exam> selectExam() {
        return examMapper.selectExam();
    }

    public int insertExam() {
        return examMapper.insertExam();
    }

}
