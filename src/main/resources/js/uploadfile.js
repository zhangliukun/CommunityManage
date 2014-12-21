/**
 * 
 */

$(document).ready(function() {
	$("#file_upload").uploadify({
		'buttonText' : '请选择',
		'height' : 30,
		'uploader' : '/',
		'width' : 120,
		'auto' : false,
		'fileObjName' : 'file',
		'onUploadSuccess' : function(file, data, response) {
			alert(file.name + ' 上传成功！ ');
		}
	});
});