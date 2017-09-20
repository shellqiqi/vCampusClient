$('#studentNoSelectedCourse').on('click', '.selectButton', function () {
    var dataItem = $.view(this).data;
    if (courseController.addCourse(dataItem.courseId)) {
        $('#courseBoard').load('course/student/student.html');
    }
});

$('#studentSelectedCourse').on('click', '.deleteButton', function () {
    var dataItem = $.view(this).data;
    if (courseController.deleteCourse(dataItem.courseId)) {
        $('#courseBoard').load('course/student/student.html');
    }
});

var noSelectedCourseJson = courseController.getNoSelectedCourse();
var noSelectedCourseObjs = jQuery.parseJSON(noSelectedCourseJson);
var template1 = $.templates('#noSelectedTemplate');
for (var i = 0; i < noSelectedCourseObjs.length; i++) {
    var teacherJson = studentRollController.getTeacherById(noSelectedCourseObjs[i].teacherId);
    noSelectedCourseObjs[i].teacherName = jQuery.parseJSON(teacherJson).teacherName;
}
var app1 = {
    course: noSelectedCourseObjs
};
template1.link('#studentNoSelectedCourse', app1);

var selectedCourseJson = courseController.getSelectedCourse();
var selectedCourseObjs = jQuery.parseJSON(selectedCourseJson);
var template2 = $.templates('#selectedTemplate');
for (var i = 0; i < selectedCourseObjs.length; i++) {
    var teacherJson = studentRollController.getTeacherById(selectedCourseObjs[i].teacherId);
    selectedCourseObjs[i].teacherName = jQuery.parseJSON(teacherJson).teacherName;
}
var app2 = {
    course: selectedCourseObjs
};
template2.link('#studentSelectedCourse', app2);
