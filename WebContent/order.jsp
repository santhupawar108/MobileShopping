<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Orders</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  option {
  margin: 0.5em;
}
  
  </style>
</head>
<body>
<!--  <div class="col-xs-6">
  <select class="form-control" name="select1" id="select1">
    <option value="1">Laptops</option>
    <option value="2">Mobiles</option>
    <option value="3">Tablet</option>
  </select>
</div>
<div class="col-xs-6">
  <select class="form-control" name="select2" id="select2">
    <option value="1">lenovo</option>
    <option value="1">Dell</option>
    <option value="1">HP</option>
    <option value="2">Oppo</option>
    <option value="2">Samsung</option>
    <option value="2">Vivo</option>
    <option value="3">Ipad</option>
    <option value="3">Samsung</option>
    <option value="3">Micromax<option>
</select>
</div> -->
<div class="container" style="width:600px;">
   <h2 align="center">JSON - Dynamic Dependent Dropdown List using Jquery and Ajax</h2><br /><br />
   <select name="country" id="country" class="form-control input-lg">
    <option value="">Select country</option>
   </select>
   <br />
   <select name="state" id="state" class="form-control input-lg">
    <option value="">Select state</option>
   </select>
   <br />
   <select name="city" id="city" class="form-control input-lg">
    <option value="">Select city</option>
   </select>
  </div>

</body>
</html>
<script type="text/javascript">
<!--

//-->

var $select1 = $( '#select1' ),
		$select2 = $( '#select2' ),
    $options = $select2.find( 'option' );
    
$select1.on( 'change', function() {
	$select2.html( $options.filter( '[value="' + this.value + '"]' ) );
} ).trigger( 'change' );
</script>

<!--

//-->

<script>
$(document).ready(function(){

 load_json_data('country');

 function load_json_data(id, parent_id)
 {
  var html_code = '';
  $.getJSON('select.json', function(data){

   html_code += '<option value="">Select '+id+'</option>';
   $.each(data, function(key, value){
    if(id == 'country')
    {
     if(value.parent_id == '0')
     {
      html_code += '<option value="'+value.id+'">'+value.name+'</option>';
     }
    }
    else
    {
     if(value.parent_id == parent_id)
     {
      html_code += '<option value="'+value.id+'">'+value.name+'</option>';
     }
    }
   });
   $('#'+id).html(html_code);
  });

 }

 $(document).on('change', '#country', function(){
  var country_id = $(this).val();
  if(country_id != '')
  {
   load_json_data('state', country_id);
  }
  else
  {
   $('#state').html('<option value="">Select state</option>');
   $('#city').html('<option value="">Select city</option>');
  }
 });
 $(document).on('change', '#state', function(){
  var state_id = $(this).val();
  if(state_id != '')
  {
   load_json_data('city', state_id);
  }
  else
  {
   $('#city').html('<option value="">Select city</option>');
  }
 });
});
</script>