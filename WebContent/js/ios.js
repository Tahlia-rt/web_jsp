


var $pfimgs=null;

var main=function(){
  init();
  pfimgs();
}
$(document).ready(main);

function init(){
  $pf=$('div.pfimgs>ul>li');
}


function pfimgs(){
var arr_Pf=[];
var size_Pf=$pf.size();
for(i=0;i<size_Pf;i++){
  arr_Pf.push('url(./imgs/ios/a'+i+'.jpg)');
  $pf.eq(i).css({'background': arr_Pf[i]+' no-repeat fixed center', 'background-size':'contain'});
}
}
