var role = getUrlParam('role');
if (role === '1') {
    var studentJson = studentRollController.getStudentById();
    var studentObj = jQuery.parseJSON(studentJson);
    var classJson = studentRollController.getClassById();
    var classObj = jQuery.parseJSON(classJson);
    var teacherJson = studentRollController.getTeacherById(classObj.teacherId);
    var teacherObj = jQuery.parseJSON(teacherJson);
    app = {
        student: studentObj,
        clazz: classObj,
        teacher: teacherObj
    };
    var html = $.templates('#studentTemplate').render(app);
    $("#studentRollManage").html(html);
} else if (role === '2') {
    var classJson = studentRollController.getClassByTeacherId();
    var classObjs = jQuery.parseJSON(classJson);
    for (var i = 0; i < classObjs.length; i++) {
        var studentJson = studentRollController.getStudentByClassId(classObjs[i].classId);
        var studentObjs = jQuery.parseJSON(studentJson);
        app = {
            clazz: classObjs[i],
            student: studentObjs,
        }
        var html = $.templates('#teacherTemplate').render(app);
        $("#studentRollManage").append(html);
    }
}
