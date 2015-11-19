<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <title>Gestão de Senhas</title>
      <meta name="description" content="Gestão de Senhas." />
      <meta name="keywords" content="senhas, gestao, ivan" />

      <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico" />
      <link rel="icon" type="image/x-icon" href="img/favicon.ico" />

      <link href="./css/jquery-ui.css" rel="stylesheet" type="text/css" />
      <link href="./css/styles.css" rel="stylesheet" type="text/css" />
      <link href="./css/skin1.css" rel="stylesheet" type="text/css" />
      
   </head>
   <body>
   <div id="error-message"></div>
   <div class="container">

<div id="header">
   <div class="pull-left">
      <i id="logo-icon"></i>
      <span>Gestão de Senhas - Teste Analista Ivan Amorim</span>
   </div>
</div>
      
<form method="post" id="main">

   <div class="content">
      <h4>Senha chamada pelo Gerente:</h4>
	  <h1 style="color:#FE2E2E;font-size: x-large;">${senhaAtualChamadaGerente}</h1>
   </div>


   <div class="content">
      <h4>Senha retirada:</h4>
      <h1 style="color:#01DF01;font-size: x-large;">${senhaGeradaCliente}</h1>
   </div>

   <div class="content">
      <button type="submit" value="normal" name="normal">Gerar senha NORMAL</button>
   </div>
   
   <div class="content">
      <button type="submit" value="preferencial" name="preferencial">Gerar senha PREFERENCIAL</button>
   </div>

</form>

<div id="password-model">
   <div class="container">
      <textarea id="password-textarea"></textarea>
      <div>
         <button id="select-all">select all</button>
         <button id="close">close</button>
      </div>
   </div>
</div>

<div id="footer">
   <span class="pull-left">&#169; 2015 <a target="blank" href="http://www.ivanamorim.com.br/">Ivan Amorim</a> all rights reserved.</span>
   <span class="pull-right">Gestão de Senhas - Teste Analista Ivan Amorim.</span>
</div>

<script type="text/javascript">

var slider_opts = {
   length_min: 4,
   length_max: 40,
   length_start: 8,
   quantity_min: 1,
   quantity_max: 1000,
   quantity_start: 1
};
</script>
<script src="./js/jquery.js" type="text/javascript"></script>
<script src="./js/jquery-ui.js" type="text/javascript"></script>
<script src="./js/javascript.js" type="text/javascript"></script>

   </div>
   </body>
</html>