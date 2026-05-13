<html>
<body>
  <form action="/FileUploadDemo/FileUpload" method="post">
  
    <input type="file" name="file" class="input-file" multiple enctype="multipart/form-data">
    <input type="submit" class="input-submit">
  </form>
  
  <style>
    form{
      displat:flex;
      flex-direction: column;
      width: 200px;
      padding: 20px;
    }
    
    .input-file{
    
      background-color:#37ea61;
    
    }
    
    .input-submit{
      background-color:#fe461e;
    }
  
  </style>
</body>
</html>
