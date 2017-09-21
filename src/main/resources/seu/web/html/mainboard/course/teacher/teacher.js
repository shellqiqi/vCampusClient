$('#teacherCourseBoard').on('click', '.deleteStudent', function () {
    var view = $.view(this);
    var dataItem = view.data;
    var parentDataItem = view.parent.parent.data;
    if (courseController.teacherDelectCourseSelect(dataItem.studentId, parentDataItem.courseId)) {
        $('#courseBoard').load('course/teacher/teacher.html');
    }
});

var teacherCourseObjs = jQuery.parseJSON(courseController.getAllCourseByTeacherId());
var template = $.templates('#teacherCourseTemplate');
for (var i = 0; i < teacherCourseObjs.length; i++) {
    teacherCourseObjs[i].studentObjs = jQuery.parseJSON(courseController.getStudentByCourseId(teacherCourseObjs[i].courseId));
}
var app = {
    course: teacherCourseObjs
};
template.link('#teacherCourseBoard', app);
