var $contentsa=null;
var $contentsb=null;
var $crts=null;


var main = function(){
  init();
  characters();
}
$(document).ready(main);

function init(){
  $lighting=$('div.lighting');
  $crts=$('#crts');
  $crtsmouse=$('div.light>div.crts');
  $contentsa=$('li.a');
  $contentsb=$('li.b');
}

function characters(){

  $crts.ready(function(){

   var arr_Crts=[];
   var crtsSize=$crts.children().size();
   for(i=0;i<crtsSize;i++){
     arr_Crts.push('url(./imgs/web/crt'+i+'.png)');
     $crts.children().eq(i).css({'background': arr_Crts[i]});
   }


   $crts.children().on('click', function(){
    $(this).css({"border":"0.5px solid #ff9900"});
    $(this).siblings().css({'box-shadow': 'none', 'border-style': 'none'});

    var x=$(this).offset().left;
    $lighting.animate({left:x-100}, 300).css({
       'transform':'translate rotate(300deg)',
       'transition':'1000ms cubic-bezier(0, 0.64, 0.53, 1.15)'});


    $(this).delay(1100).fadeIn(function(){
      $(this).css({'box-shadow':'5px 5px 15px #ff9900'});
       });


   });


});
}
