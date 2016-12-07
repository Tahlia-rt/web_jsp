
var $contentsa=null;
var $contentsb=null;
var $crts=null;


var main = function(){
    init();
    characters();

}
$(document).ready(main);

function init(){
  $lighting=$('section.people>div.light>div.lighting');
  $crts=$('secton.people>div.light>div.crts>ul#crts');
  $crtsmouse=$('section.people>div.light>div.crts');
  $contentsa=$('section.place>nav.contents>ul>li.a');
  $contentsb=$('section.place>nav.contents>ul>li.b');

}



function characters(){
   $crtsmouse.mCustomScrollbar({
     axis:"x", theme:"light"
   });

  $contentsa.ready(function(){
    var arr_Crts=[];
    var crtsSize=$crts.children().size();
    for(i=0;i<crtsSize;i++){
      arr_Crts.push('url(../imgs/web/crt'+i+'.png) 60%');
      $crts.children().eq(i).css({'background':arr_Crts[i], 'background-size':'100% 100%'});
    }
  });

  $crts.children().on('click', function(){
    $(this).css({"border":"0.5px solid #ff9900"});
    var x=$(this).offset().left;

    $lighting.animate({left:x-100},300).css({'transform':'translate rotate(300deg)','transition':'1000ms cubic-bezier(0, 0.64, 0.53, 1.15)'});
      $(this).delay(1100).fadeIn(function(){
        $(this).css({'box-shadow':'5px 5px 15px #ff9900'});
      });
      $(this).siblings().css({'box-shadow': '0px 0px 0px #fff', 'border': '0px'});
    });

}

function ost() {
  $ostmouse.mCustomScrollbar({
    axis:"x", theme:"inset-3"
  });

}
