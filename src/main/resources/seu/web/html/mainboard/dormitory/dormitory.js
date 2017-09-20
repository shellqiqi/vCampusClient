// $('#teacherCourseBoard').on('click', '.deleteStudent', function () {
//     var view = $.view(this);
//     var dataItem = view.data;
//     var parentDataItem = view.parent.parent.data;
//     if (courseController.teacherDelectCourseSelect(dataItem.studentId, parentDataItem.courseId)) {
//         $('#courseBoard').load('course/teacher/teacher.html');
//     }
// });

var dormitoryJson = dormitoryController.getAllDormitory();
var dormitoryObjs = jQuery.parseJSON(dormitoryJson);
var template = $.templates('#dormitoryTemplate');
for (var i = 0; i < dormitoryObjs.length; i++) {
    dormitoryObjs[i].studentObjs = jQuery.parseJSON(dormitoryController.getStudentByDormitoryId(dormitoryObjs[i].dormitoryId));
}
var app = {
    course: dormitoryObjs
};
template.link('#dormitoryBoard', app);
