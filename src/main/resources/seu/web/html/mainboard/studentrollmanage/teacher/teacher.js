var classObjs = jQuery.parseJSON(studentRollController.getClassByTeacherId());
for (var i = 0; i < classObjs.length; i++) {
    classObjs[i].student = jQuery.parseJSON(studentRollController.getStudentByClassId(classObjs[i].classId));
}
var app = {
    clazz: classObjs
};
var template = $.templates('#teacherTemplate');
template.link('#studentRollManage', app);
