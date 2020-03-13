<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

<div class="uploadDiv">
    <input type = "file" name = "uploadFile" multiple>
</div>
<button id="uploadBtn">Upload</button>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
$(document).ready(function() {
  
  $("#uploadBtn").on("click", function(e){
    
    var formData = new FormData();
    
    var inputFile = $("input[name='uploadFile']");
    
    var files = inputFile[0].files;
    
    console.log(files);
    
    // add filedata to formdata
    for(var i =0; i< files.length; i++) {
      formData.append("uploadFile", files[i]);
    }
    
    $.ajax({
      url : '/uploadAjaxAction',
      processData: false,
      contentType: false,
      data: formData,
      type: 'POST',
      success: function(result) {
        alert("uploaded");
      }
    });
  });
});

</script>

</body>
</html>