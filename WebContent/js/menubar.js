

var main=function(){
  init();
  
}
$(document).ready(main);

function init(){
}

function cl(){
  $('.menu>ul>li').click(function(){
    $(this).css({'color':'#00bcd4'});
    $(this).siblings().css({'color':'#ffffff'});
  });
}
