$('#studentNoSelectedCourse').on('click', '.selectButton', function () {
    var dataItem = $.view(this).data;
    if (courseController.addCourseSelect(dataItem.courseId)) {
        $('#courseBoard').load('course/student/student.html');
    }
});

$('#studentSelectedCourse').on('click', '.deleteButton', function () {
    var dataItem = $.view(this).data;
    if (courseController.deleteCourseSelect(dataItem.courseId)) {
        $('#courseBoard').load('course/student/student.html');
    }
});

var noSelectedCourseObjs = jQuery.parseJSON(courseController.getNoSelectedCourse());
var template1 = $.templates('#noSelectedTemplate');
for (var i = 0; i < noSelectedCourseObjs.length; i++) {
    noSelectedCourseObjs[i].teacherName = jQuery.parseJSON(studentRollController.getTeacherById(noSelectedCourseObjs[i].teacherId)).teacherName;
}
var app1 = {
    course: noSelectedCourseObjs
};
template1.link('#studentNoSelectedCourse', app1);

var selectedCourseObjs = jQuery.parseJSON(courseController.getSelectedCourse());
var template2 = $.templates('#selectedTemplate');
for (var i = 0; i < selectedCourseObjs.length; i++) {
    selectedCourseObjs[i].teacherName = jQuery.parseJSON(studentRollController.getTeacherById(selectedCourseObjs[i].teacherId)).teacherName;
}
var app2 = {
    course: selectedCourseObjs
};
template2.link('#studentSelectedCourse', app2);
