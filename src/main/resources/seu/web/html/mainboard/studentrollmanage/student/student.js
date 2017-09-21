var studentObj = jQuery.parseJSON(studentRollController.getStudentById());
var classObj = jQuery.parseJSON(studentRollController.getClassById());
var teacherObj = jQuery.parseJSON(studentRollController.getTeacherById(classObj.teacherId));
app = {
    student: studentObj,
    clazz: classObj,
    teacher: teacherObj
};
var template = $.templates('#studentTemplate');
template.link('#studentRollManage', app);
