package seu.service;

import org.springframework.stereotype.Service;
import seu.domain.Dormitory;

import java.util.List;
@Service
public class DormitoryService{

    //学生通过学生宿舍查询学生成绩
    public int queryScoreByDormitoryID(int DormitoryID) {
return 0;
    }

    //学生通过学生id查询学生宿舍
    public Dormitory getDormitoryByStudentId(int studentId) {
return null;
    }

    //学生查询所有学生成绩及宿舍信息
    public List<Dormitory> getDormitoryAll() {
return null;
    }
}
