package devy.temp.spring.sqlite.service.mapper;

import devy.temp.spring.sqlite.domain.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamMapper {

    List<Exam> selectExam();

    int insertExam();

}
