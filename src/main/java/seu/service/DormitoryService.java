package seu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.domain.Dormitory;
import seu.socket.Client;
import seu.socket.ClientRequest;

import java.util.List;

@Service
public class DormitoryService {

    private Client client;

    @Autowired
    public void setClient(Client client) {
        this.client = client;
    }

    private String serviceName;

    public DormitoryService() {
        serviceName = "dormitoryService";
    }

    //通过学生宿舍查询学生成绩
    public int queryScoreByDormitoryID(int DormitoryID) {
        return (int) client.send(new ClientRequest(serviceName, "insertCourse", new Class[]{int.class}, new Object[]{DormitoryID})).getData();
    }

    //通过学生id查询学生宿舍
    public Dormitory getDormitoryByStudentId(int studentId) {
        return (Dormitory) client.send(new ClientRequest(serviceName, "getDormitoryByStudentId", new Class[]{int.class}, new Object[]{studentId})).getData();
    }

    //学生查询所有学生成绩及宿舍信息
    public List<Dormitory> getDormitoryAll() {
        return (List<Dormitory>) client.send(new ClientRequest(serviceName, "getDormitoryAll")).getData();
    }

    //管理员增加宿舍
    public int insertDormitory(Dormitory dormitory) {
        return (int) client.send(new ClientRequest(serviceName, "insertDormitory", new Class[]{Dormitory.class}, new Object[]{dormitory})).getData();
    }

    //管理员删除宿舍
    public int deleteDormitoryByID(int dormitoryID) {
        return (int) client.send(new ClientRequest(serviceName, "deleteDormitoryByID", new Class[]{int.class}, new Object[]{dormitoryID})).getData();
    }

    //管理员更新学生分数与宿舍信息
    public int updateScoreByID(int dormitoryID, int score) {
        return (int) client.send(new ClientRequest(serviceName, "updateScoreByID", new Class[]{int.class, int.class}, new Object[]{dormitoryID, score})).getData();
    }
}
