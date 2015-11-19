<!--
$(document).ready(function(){


   // length slider function.
   $(function() {
      $("#length-slider").slider({
         range: "max",
         value: slider_opts.length_start,
         min: slider_opts.length_min,
         max: slider_opts.length_max,
         slide: function(event, ui) {
            $("input[name=length]").val(ui.value);
            $("#length-amount").text(ui.value);
         }
      });
   });


   // quantity slider function.
   $(function() {
      $("#quantity-slider").slider({
         range: "max",
         value: slider_opts.quantity_start,
         min: slider_opts.quantity_min,
         max: slider_opts.quantity_max,
         slide: function(event, ui) {
            $("input[name=quantity]").val(ui.value);
            $("#quantity-amount").text(ui.value);
         }
      });
   });


   // main form function.
   $("#main").on("submit", function(e) {
      var output = $("input[name=output]:checked").val();
      if (output == "1") {
         e.preventDefault();
         $("button[name=generate]").addClass("loading");
         $.ajax({
            type: "POST",
            url: "ajax.php",
            data: $("#main").serialize(),
            success: function(data) {
               if (data.slice(0,6) == "error:") {
                  $("#error-message").html("<span>" + data + "</span>");
                  $("#error-message").fadeIn("slow").delay(3000).fadeOut("slow");
               }
               else {
                  $("#password-textarea").text(data);
                  $("#password-model").fadeIn("slow");
               }
               $("button[name=generate]").removeClass("loading");
            }
         });
      }
   });


   // password model select all function.
   $("#select-all").click(function() {
      $("#password-textarea").select();
   });


   // password model close function.
   $("#close").click(function() {
      $("#password-model").fadeOut("slow");
   });


});
//-->