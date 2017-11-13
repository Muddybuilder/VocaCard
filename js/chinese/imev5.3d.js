  browser = 
    (navigator.appName.indexOf('Microsoft') != -1) ? 1 :
    (navigator.appName.indexOf('Netscape')  != -1) ? 2 :
    (navigator.appName.indexOf('Opera')     != -1) ? 3 :
    4;
  if(navigator.userAgent.indexOf('Safari') != -1) browser =5;
  if(navigator.userAgent.indexOf('Chrome') != -1) browser =6;


var LastNo=0;
var LastWNo=0;
var chosenCand=0;
var SPACECHAR=" "; 
var CandChinesePart=new Array("","","","","","","","","",""); 
var CandCompPart=new Array(); 
var AsciiStr="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z"; 
AsciiStr=AsciiStr.split(',');
var CodeList="";
var puncts="";
var boxsize="65px";
var CtrlDown=false;
var CancelKey=false;
var passNextKeyPress = true;
var browser;
var IME;
var MacCommand=false;

var Punct2 =  new Array('；','＝','，','－','。','／','?');
var Punct3 =  new Array('?','、','?','?');

var SPunct1 = new Array('）','！','＠','＃','＄','％','?','＆','＊','（');
var SPunct2 = new Array('：','＋','＜','＿','＞','？','～');
var SPunct3 = new Array('｛','｜','｝','?');
var FullShape_No=new Array("0","1","2","3","4","5","6","7","8","9");
var FullShape_BigAZ=new Array("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
var FullShape_SmallAZ=new Array('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');

function parsecl(num){
Code =Code.split(',');
Code.push('# #');
Code.splice(0,0,'* *');
for ( var i=0;i<Code.length; ++i ){
var indexcl = Code[i].substring(0,Code[i].indexOf(' '));
Code[i] = Code[i].replace(indexcl, '').replace(/ /g, ','+indexcl+' ');
}
Code[0]=Code[0].substring(1);
}
parsecl();
Code = Code.join('').split(',');

function parsecw(num){
ChiWords = ChiWords.split(',');
for ( var i=0;i<ChiWords.length; ++i ){
var indexchar = ChiWords[i].substring(0,1);
ChiWords[i] = ChiWords[i].replace(/ /g, ','+indexchar);
}
}
parsecw();
ChiWords = ChiWords.join(',').split(',');

function parseew(num){
EngWords =EngWords.split(',');
for ( var i=0;i<EngWords.length; ++i ){
var indexew = EngWords[i].substring(0,EngWords[i].indexOf(' '));
EngWords[i] = EngWords[i].replace(indexew, '').replace(/ /g, ','+indexew+' ');
}
EngWords[0]=EngWords[0].substring(1);
}
parseew();
EngWords = EngWords.join('').split(',');

var TotalLength=Code.length + EngWords.length;
var NewCode=[];


var sw=0;
function swapswitch(){
if(sw==1){sw=0;}
else {sw=1;}
}

function mergeengwords()
{
var i=0, e=0, c=0, v=0, max=0, sc=1;
for(i=0;i<TotalLength-1;i++)
	{if(c!='max' && e!='max')
		{
		if(Code[c].substring(0,Code[c].indexOf(' '))<EngWords[e].substring(0,EngWords[e].indexOf(' ')))
			{NewCode[i]=Code[c];
			sc=1;
			if (c<(Code.length-1))
				{c=c+1;
				}else 
				{c='max';
				}
			}
			else if(Code[c].substring(0,Code[c].indexOf(' '))==EngWords[e].substring(0,EngWords[e].indexOf(' ')))
			{if(sw==0)
				{NewCode[i]=Code[c];
				sc=sc+1;
				if (sc==7){swapswitch();c=c-1;sc=1;}
				if (c<(Code.length-1))
				{c=c+1;
				}else 
				{c='max';
				}
				}
			if(sw==1)
			{NewCode[i]=EngWords[e];
				sc=sc+1;
				if (sc==6){swapswitch();sc=1;}
				if (e<(EngWords.length-1))
				{e=e+1;
				}else 
				{e='max';
				}
				}
			}
			else
			{
			NewCode[i]=EngWords[e];
			sc=1;
			sw=0;
		if (e<(EngWords.length-1))
				{e=e+1;
				}else 
				{e='max';
				}
			}
	}
	 if(c=='max')
		{NewCode[i]=EngWords[e];
		e=e+1;
		sc=1;
		sw=0;
		}
	 if(e=='max')
		{NewCode[i]=Code[c];
			c=c+1;
			sc=1;
				sw=0;
		}
}
CodeList=NewCode;
}


function FindIn(s) {
var find=-1,low=0,mid=0,high=CodeList.length;
var sEng="";
  while(low<high){
    mid=(low+high)/2;
    mid=Math.floor(mid);
    sEng=CodeList[mid];
    if(sEng.indexOf(s,0)==0){find=mid;break;}
    sEng=CodeList[mid-1];
    if(sEng.indexOf(s,0)==0){find=mid;break;}
    if(sEng<s){low=mid+1;}else{high=mid-1;}
  }
  while(find>0){
    sEng=CodeList[find-1];
    if(sEng.indexOf(s,0)==0){find--;}else{break;}
  }
  return(find);
}

function FindWIn(ws) {
var find=-1,low=0,high=ChiWords.length;
var sEng="";
while (low<high){
    sEng=ChiWords[low];
if(sEng.indexOf(ws,0)==0){
	find=low; 
	break;
  }
  low++;}
	  return(find);
}


function Grep(s){
  var No=-1;
  if(s!=""){
    No=FindIn(s);
    if(No>=0){GetStr(No, s);}
  }

  if( document.getElementById("AutoUp").checked==true && CandChinesePart[0]!="" && CandChinesePart[1]=="" && CandCompPart[0]=="" ) {
    SendCand(0);
  }
}

function SendCand(n){
	
	 if ( n>=0 && n<=9 ) {
    SendStr(CandChinesePart[n]);
	chosenCand=CandChinesePart[n];
		puncts="";
	}
    document.getElementById("Comp").value="";
	clearInnerHTML(Cand);
	cjupdate();
   var WNo="";
   if (chosenCand!="" && chosenCand.length==1)
   { WNo=FindWIn(chosenCand);
   if(WNo>=0){GetWordStr(WNo, chosenCand);
  }
   }
}

function Punct(){
clearInnerHTML(Cand);
 var WNo="";
   WNo=FindWIn('a');
   if(WNo>=0){GetWordStr(WNo, 'a');
     document.getElementById('InputArea').focus();
	 document.getElementById("Comp").value="";
	 puncts="a";
	 }
   }

function SendStr(s) {
 if (s=="") { return }

  switch (browser) {
  case 1: 
    var r=document.selection.createRange();
    r.text=s;
    r.select(); 
    break;
  case 2:
  case 5:
case 6:
    var obj = document.getElementById('InputArea');
    var selectionStart = obj.selectionStart;
    var selectionEnd = obj.selectionEnd;
    var oldScrollTop = obj.scrollTop;  
    var oldScrollHeight = obj.scrollHeight;
    var oldLen = obj.value.length;

    obj.value = obj.value.substring(0, selectionStart) + s + obj.value.substring(selectionEnd); 
    obj.selectionStart = obj.selectionEnd = selectionStart + s.length;
    if (obj.value.length == oldLen) {
      obj.scrollTop = obj.scrollHeight;
	  	puncts="";
		  clearInnerHTML(Cand);
		  cjupdate();
    } else if (obj.scrollHeight > oldScrollHeight) { 
      obj.scrollTop = oldScrollTop + obj.scrollHeight - oldScrollHeight;
	  	puncts="";
		  clearInnerHTML(Cand);
		  		  cjupdate();
    } else { 
      obj.scrollTop = oldScrollTop;
	  	puncts="";
		  clearInnerHTML(Cand);
		  		  cjupdate();
    }
    
    break;
  default: 
    document.getElementById('InputArea').value += s;
		puncts="";
		  clearInnerHTML(Cand);
		  		  cjupdate();
  }
}


function ToFullShapeLetter(aStr) {
  var s="";

  for (i=0;i<aStr.length;i++) {
    var c = aStr.charCodeAt(i);
    if (c>=65 && c<=90) {
      s += FullShape_BigAZ[c-65];
    } else if (c>=97 && c<=122) {
      s += FullShape_SmallAZ[c-97];
    } else {
      s += aStr.charAt(i);
    }
  }

  return s;
}

function clearInnerHTML(obj) {
	while(obj.firstChild) obj.removeChild(obj.firstChild);
}

function ImeKeyDown(e) {
  var s="";
  if(!e) e=window.event;
  var key = e.which ? e.which : e.keyCode;
  CtrlDown=false;
  passNextKeyPress=false;
  
  switch (key) {
  case 8:
    if (document.getElementById("Comp").value!="") {
      s=document.getElementById("Comp").value;
      document.getElementById("Comp").value = s.substr(0, s.length-1);
      clearInnerHTML(Cand);
cjupdate();
      Grep(document.getElementById("Comp").value);
      CancelKey = false;
      return (false);
    }
    return (true);


  case 9:
    SendStr('　');
    CancelKey = false;
    return (false); 


  case 27:
    document.getElementById("Comp").value="";
    clearInnerHTML(Cand);
    chosenCand="";
	cjupdate();
    CancelKey = false;
    return (false); 


  case 109:
  case 45:
  case 189:
  case 173:
  case 33:
  case 57383:

	   if (document.getElementById('EnglishMode').checked!= true){
	  s=document.getElementById("Comp").value;
    if (s!="") {
      if(LastNo>10 && CodeList[LastNo-10].indexOf(s)==0){
        clearInnerHTML(Cand);
        GetStr(LastNo-10, s);
      }

      CancelKey = false;
      return(false);
    }  

	if (puncts=="a") {
      if(LastWNo>10 && ChiWords[LastWNo-10].indexOf('a')==0){
        clearInnerHTML(Cand);
        GetWordStr(LastWNo-10, 'a');
      }

      CancelKey = false;
      return(false);
    }  

	if (s=="") {
      if(LastWNo>10 && ChiWords[LastWNo-10].indexOf(chosenCand)==0){
        clearInnerHTML(Cand);
        GetWordStr(LastWNo-10, chosenCand);
      }

      CancelKey = false;
      return(false);
    }  
    break;
  }
    else{		passNextKeyPress = true;
			return (true);}



  case 61:
  case 107:
  case 187:
  case 34:
  case 57384:
	  	   if (document.getElementById('EnglishMode').checked!= true){
	   s=document.getElementById("Comp").value;
    if ( s!="" ){
      if(LastNo<=CodeList.length-11 && CodeList[LastNo+10].indexOf(s) == 0) {
        clearInnerHTML(Cand);
        GetStr(LastNo+10, s);
      }
      CancelKey = false;
      return(false);
    }

	 if ( puncts=="a" ){
     if(LastWNo<=ChiWords.length-11 && ChiWords[LastWNo+10].indexOf('a') == 0) {
     clearInnerHTML(Cand);
        GetWordStr(LastWNo+10, 'a');
     }
      CancelKey = false;
      return(false);
    }

	 if ( s=="" ){
     if(LastWNo<=ChiWords.length-11 && ChiWords[LastWNo+10].indexOf(chosenCand) == 0) {
     clearInnerHTML(Cand);
        GetWordStr(LastWNo+10, chosenCand);
     }
      CancelKey = false;
      return(false);
    }
    break;
  }
  else{		passNextKeyPress = true;
			return (true);}


 case 32:
	 if (document.getElementById('spacebar').checked== true){
	 if (document.getElementById('EnglishMode').checked!= true){
    s=document.getElementById("Comp").value;
    if ( s!="" && document.getElementById("Cand").innerHTML !="" ){
      if(LastNo<=CodeList.length-11 && CodeList[LastNo+10].indexOf(s) == 0) {
        clearInnerHTML(Cand);
        GetStr(LastNo+10, s);
      }
      else if(LastNo>10 && CodeList[LastNo-10].indexOf(s)==0) {
        clearInnerHTML(Cand);
        Grep(s);
      }

      CancelKey = false;
      return(false);
    }

	 if ( puncts=="a" && document.getElementById("Cand").innerHTML !=""  ){
     if(LastWNo<=ChiWords.length-11 && ChiWords[LastWNo+10].indexOf('a') == 0) {
     clearInnerHTML(Cand);
        GetWordStr(LastWNo+10, 'a');
     }
else  if(LastWNo>10 && ChiWords[LastWNo-10].indexOf('a')==0){
Punct();
      }

      CancelKey = false;
      return(false);
    }

	 if ( s=="" && document.getElementById("Cand").innerHTML !="" ){
     if(LastWNo<=ChiWords.length-11 && ChiWords[LastWNo+10].indexOf(chosenCand) == 0) {
     clearInnerHTML(Cand);
        GetWordStr(LastWNo+10, chosenCand);
     }
	 else  if(LastWNo>10 && ChiWords[LastWNo-10].indexOf(chosenCand)==0){
        clearInnerHTML(Cand);
    //    GetWordStr(LastWNo-10, chosenCand);
   var WNo="";
   if (chosenCand!="" && chosenCand.length==1)
   { WNo=FindWIn(chosenCand);
   if(WNo>=0){GetWordStr(WNo, chosenCand);
  }
   }
      }
      CancelKey = false;
      return(false);
    }
	}
  return(true);
 } 
 else {	    if(document.getElementById("Comp").value!="" && document.getElementById("Cand").innerHTML!="") {
      SendCand(0);
      CancelKey = false;
      return(false);
    }
	    if(document.getElementById("Comp").value!="" && document.getElementById("Cand").innerHTML=="") {
     document.getElementById("Comp").value="";
	 cjupdate();
      CancelKey = false;
      return(false);
    }
	 if(document.getElementById("Comp").value=="" && document.getElementById("Cand").innerHTML!="") {
      SendCand(0);
      CancelKey = false;
      return(false);
    }
    return(true);
}

  case 13:
    if (document.getElementById("Comp").value!="") {
      SendStr( document.getElementById("FullShape").checked ? 
        ToFullShapeLetter(document.getElementById("Comp").value) : 
        document.getElementById("Comp").value);
      document.getElementById("Comp").value="";
      clearInnerHTML(Cand);
	  cjupdate();
      CancelKey = false;
      return(false);
    }
    return(true);

 
  case 113:
    document.getElementById("AutoUp").checked = !document.getElementById("AutoUp").checked;
    CancelKey = false;
    return (false);


  case 123:
  case 57356:
    document.getElementById("FullShape").checked = !document.getElementById("FullShape").checked;
    CancelKey = false;
    return (false);

  case 17:
  case 57402:
    CtrlDown=true;
    break;
    	case 120:  Punct(); return (false); 
		case 91: 
		case 224: MacCommand=true;
  		case 36: 
		case 35:
		case 37:
		case 38:
		case 39:
		case 40:
		case 46:
		case 91: 
		case 112: 
		case 114:
		case 115:
		case 116:
		case 117:
		case 118:
		case 119: 
		case 121: 
		case 122: 
			passNextKeyPress = true;
			return (true);

  }

  if (e.ctrlKey) { return (true) };


  if (key>=48 && key<=57) {
    if (e.shiftKey) { 
      if (document.getElementById("FullShape").checked || !document.getElementById("EnglishMode").checked) {
	if (puncts=="a")
		{  SendStr(SPunct1[key-48]);
		puncts=="a";
		}
		else {
			SendStr(SPunct1[key-48]);
		}
        CancelKey = false;
        return (false);
      }
    } else { 
      if (document.getElementById("Comp").value=="" && document.getElementById("Cand").innerHTML=="") {
        if (document.getElementById("FullShape").checked || !document.getElementById("EnglishMode").checked) {
				if (puncts=="a")
		{  
          SendStr(FullShape_No[key-48]);
		  	puncts=="a";
		}
		else {
			          SendStr(FullShape_No[key-48]);
		}
          CancelKey = false;
          return (false);
        }
      } else {
        if (!document.getElementById("EnglishMode").checked && document.getElementById("Cand").innerHTML!="") {
          SendCand( key==48 ? 9 : (key-49) );
          CancelKey = false;
          return (false);
        }
      }
    }
    return (true);
  }

  if (document.getElementById("FullShape").checked || !document.getElementById("EnglishMode").checked) {
    if (key>=186 && key<=192) {
		if (puncts=="a")
		{      SendStr( e.shiftKey ? SPunct2[key-186] : Punct2[key-186] );
		puncts=="a";
		}
		else {
      SendStr( e.shiftKey ? SPunct2[key-186] : Punct2[key-186] );
	  }
      CancelKey = false;
      return (false);
    }
    if (key>=219 && key<=222) {
		if (puncts=="a"){
      SendStr( e.shiftKey ? SPunct3[key-219] : Punct3[key-219] );
	  		puncts=="a";
	  }
	  else{
 SendStr( e.shiftKey ? SPunct3[key-219] : Punct3[key-219] );
	  }
      CancelKey = false;
      return (false);
    }
  }    

  if (browser==2) {
    if (document.getElementById("FullShape").checked || !document.getElementById("EnglishMode").checked) {
      switch (key) {
      case 59: 
	  	if (puncts=="a")
		{ 
        SendStr( e.shiftKey ? SPunct2[0] : Punct2[0] );
		puncts="a";
		}
		else {
        SendStr( e.shiftKey ? SPunct2[0] : Punct2[0] );
		}
        CancelKey = false;
        return (false);
      case 61:
		  	  	if (puncts=="a")
		{ 
        SendStr( e.shiftKey ? SPunct2[1] : Punct2[1] );
	puncts="a";
		}
		else {
        SendStr( e.shiftKey ? SPunct2[1] : Punct2[1] );
		}
        CancelKey = false;
        return (false);
      case 109:
		    	if (puncts=="a")
		{ 
        SendStr( e.shiftKey ? SPunct2[3] : Punct2[3] );
	puncts="a";
		}
		else {
        SendStr( e.shiftKey ? SPunct2[3] : Punct2[3] );
		}
        CancelKey = false;
        return (false);
      }
    }
  }

  return(true);
}

function ImeKeyPress(e) {
  if(!e) e=window.event;
  var key = e.which ? e.which : e.keyCode;


	if(passNextKeyPress) {
		return (true);
	}

 
  if (browser==2 || browser==3) {
    if (CancelKey) {		
      CancelKey = false;
      return (false);
    }
  }

  if (e.ctrlKey) { return (true); }

if(MacCommand==false){
  if ( key>=65 && key<=90 ) {
	  var Shiftdetect = e.shiftKey || ( e.modifiers && ( e.modifiers & 4 ) );
	  if (!Shiftdetect)
	  {capslockalert();
	  }
    if (document.getElementById("FullShape").checked) {
      SendStr(FullShape_BigAZ[key-65]);
      return (false);
    }
    return (true);
  }

  if (key>=97 && key<=122) {
    if (document.getElementById('EnglishMode').checked== true) {
      if (document.getElementById("FullShape").checked) {
        SendStr( FullShape_SmallAZ[key-97] );
        return (false);
      }
      return (true);
    } else {
      s=document.getElementById("Comp").value;
      if (s.length<50) {
        document.getElementById("Comp").value+=AsciiStr[key-97];
        clearInnerHTML(Cand);
		cjupdate();
        Grep(document.getElementById("Comp").value);
      }
      return (false);
    }
  }
}
 
  if (browser==2) {
    switch (key) {
    case 47: case 63:
      if (!document.getElementById("EnglishMode").checked || document.getElementById("FullShape").checked) {
        return (false);
      }
      break;
    }
  }

  return (true);
}

function ImeKeyUp(e) {
  if(!e) e=window.event;
  var key = e.which ? e.which : e.keyCode;

  if (key==17 || key==57402) {
    if (CtrlDown==true) {
      document.getElementById("EnglishMode").checked = !document.getElementById("EnglishMode").checked;
	  	  englishcontrol();
    }
  }
if (key==91 || key==224) {
	MacCommand=false;}
  return(true);
}

function BodyOnLoad() {
setTimeout(function() { document.getElementById('InputArea').focus(); }, 500);
 document.getElementById('InputArea').focus();
 s=document.getElementById('InputArea').value;
  document.getElementById('InputArea').value = ""; 
  document.getElementById('InputArea').value += s;
}


function googlesearch2() {
 var inputvalue = encodeURI(document.core.InputArea.value);
 var selfDomain = document.domain;
  var searchengine = "";
 if (selfDomain =="www.cantoneseinput.com")
 {searchengine = ".hk";
 }
 else
	{searchengine = "";}
 var urlstring ="http://www.google.com"+searchengine+"/cse?cx=partner-pub-7266732652464817%3Acy0g05798qo&ie=UTF-8&q="+inputvalue+"&sa=%E6%90%9C%E5%B0%8B&siteurl="+selfDomain;
var googlesearchwindow = window.open (urlstring, 'googlesearch');
googlesearchwindow.focus();
return false;
}

function showinfo(divname){
if (document.getElementById(divname).style.left == '75px'){
var t2 = new Tween(document.getElementById(divname).style,'left',Tween.regularEaseIn,75,-425,0.5,'px');
t2.start();}
else {
document.getElementById(divname).style.left='-425px';
document.getElementById(divname).style.display='block';
var t3 = new Tween(document.getElementById(divname).style, 'left',Tween.regularEaseIn,-425,75,0.6,'px');
t3.start();}
}

function movecore(changesize){
if(changesize=='s'){
if (boxsize=='65px'){
var t4 = new Tween(document.getElementById('wrapper').style,'top',Tween.regularEaseIn,0,-73,0.5,'px');
t4.start();
var t3 = new Tween(document.getElementById('news').style,'marginTop',Tween.regularEaseIn,0,80,0.2,'px');
t3.start();
var t9 = new Tween(document.getElementById('InputArea').style, 'height',Tween.regularEaseIn,65,30,0.3,'px');
t9.start();
boxsize='30px';
}
if (boxsize=='130px'){
var t7 = new Tween(document.getElementById('InputArea').style, 'height',Tween.regularEaseIn,130,65,0.3,'px');
t7.start();
boxsize='65px';
}
if (boxsize=='200px'){
var t7 = new Tween(document.getElementById('InputArea').style, 'height',Tween.regularEaseIn,200,130,0.3,'px');
t7.start();
boxsize='130px';
}
}
if(changesize=='l'){
	if (boxsize=='130px'){
var t10 = new Tween(document.getElementById('InputArea').style, 'height',Tween.regularEaseIn,130,200,0.3,'px');
t10.start();
boxsize='200px';
}
if (boxsize=='65px'){
var t6 = new Tween(document.getElementById('InputArea').style, 'height',Tween.regularEaseIn,65,130,0.3,'px');
t6.start();
boxsize='130px';
}
if (boxsize=='30px'){
document.getElementById('wrapper').style.top='-73px';
var t5 = new Tween(document.getElementById('wrapper').style, 'top',Tween.regularEaseIn,-73,0,0.5,'px');
t5.start();
var t2 = new Tween(document.getElementById('news').style,'marginTop',Tween.regularEaseIn,80,0,0.2,'px');
t2.start();
var t8 = new Tween(document.getElementById('InputArea').style, 'height',Tween.regularEaseIn,30,65,0.3,'px');
t8.start();
boxsize='65px';
}
}
document.getElementById('InputArea').focus();
}

var candhtml ="";
var clw=0;
var timer;

function updatecandhtml(candhtml){
document.getElementById("Cand").innerHTML= candhtml;
clw=0;
}

function capslockalert(){
capswarn = "<span id='capslock'>Caps Lock!</span>";
if (clw==0)
{
candhtml = document.getElementById("Cand").innerHTML;
}
document.getElementById("Cand").innerHTML= capswarn;
clw=1;
clearTimeout(timer);
timer=setTimeout(function(){updatecandhtml(candhtml);clw=0;}, 500);
}

function cjupdate() {
	if (cjlimit!==0)
	{
var cjcode = document.core.Comp.value;
cjcode = cjcode.replace(/a/g,"日");
cjcode = cjcode.replace(/b/g,"月");
cjcode = cjcode.replace(/c/g,"金");
cjcode = cjcode.replace(/d/g,"木");
cjcode = cjcode.replace(/e/g,"水");
cjcode = cjcode.replace(/f/g,"火");
cjcode = cjcode.replace(/g/g,"土");
cjcode = cjcode.replace(/h/g,"竹");
cjcode = cjcode.replace(/i/g,"戈");
cjcode = cjcode.replace(/j/g,"十");
cjcode = cjcode.replace(/k/g,"大");
cjcode = cjcode.replace(/l/g,"中");
cjcode = cjcode.replace(/m/g,"一");
cjcode = cjcode.replace(/n/g,"弓");
cjcode = cjcode.replace(/o/g,"人");
cjcode = cjcode.replace(/p/g,"心");
cjcode = cjcode.replace(/q/g,"手");
cjcode = cjcode.replace(/r/g,"口");
cjcode = cjcode.replace(/s/g,"尸");
cjcode = cjcode.replace(/t/g,"廿");
cjcode = cjcode.replace(/u/g,"山");
cjcode = cjcode.replace(/v/g,"女");
cjcode = cjcode.replace(/w/g,"田");
cjcode = cjcode.replace(/x/g,"難");
cjcode = cjcode.replace(/y/g,"卜");
cjcode = cjcode.replace(/z/g,"");
var cjtruncode = 	cjcode.substring(0,cjlimit);
document.core.Cj.value = cjtruncode;
document.getElementById("Comp").value = document.getElementById("Comp").value.substring(0,18);
	}
}

function gup(name)
{  var regexS = "[\\?&]"+name+"=([^&#]*)";
  var regex = new RegExp( regexS );
  var results = regex.exec( window.location.href );
  if( results == null )
    return "";
  else
    return results[1];
}

function validate(chk){
  if (chk.checked == 1)
	  {
   mergeengwords();
	  if (document.getElementById("Comp").value!="")
	  {  
		  s=document.getElementById("Comp").value;
		  clearInnerHTML(Cand);
		Grep(s);
	  }
	  }
  else{
 CodeList=Code;
  	  if (document.getElementById("Comp").value!="")
	  {
		  s=document.getElementById("Comp").value;
		  clearInnerHTML(Cand);
		Grep(s);
	  }
  }
}

function highlightmetasearch() { 
document.core.InputArea.select(); document.core.InputArea.focus(); 
} 

function clearvalue() {
  document.codelookup.query.value= "";
}

function copymetasearch() { 
highlightmetasearch(); 
textRange = document.core.InputArea.createTextRange(); 
textRange.execCommand("RemoveFormat"); 
textRange.execCommand("Copy"); 
   }

function getCookie(c_name)
{
if (document.cookie.length>0)
  {
  c_start=document.cookie.indexOf(c_name + "=");
  if (c_start!=-1)
    {
    c_start=c_start + c_name.length+1;
    c_end=document.cookie.indexOf(";",c_start);
    if (c_end==-1) c_end=document.cookie.length;
    return unescape(document.cookie.substring(c_start,c_end));
    }
  }
return "";
}

function setCookie(c_name,value,expiredays)
{
var exdate=new Date();
exdate.setDate(exdate.getDate()+expiredays);
document.cookie=c_name+ "=" +escape(value)+
((expiredays==null) ? "" : ";expires="+exdate.toUTCString());
}

function checkCookie()
{
var spacebar=getCookie('spacebar');
if (document.getElementById('spacebar').checked==true)
  {
   setCookie('spacebar',1,365);
  }
else
  {
   setCookie('spacebar',0,365);
    }
}

function simplify(){
	 var lang = gup('lang');
if(document.getElementById('sboxwrap').style.marginTop =="18px")
	{
	sboxclose.start();
	}
else if(document.getElementById('InputArea').value=="" && lang==""){
document.getElementById('sboxframe').src = 'php/sboxwarning.php';
sboxopen.start();
}
else if(document.getElementById('InputArea').value=="" && lang=="en"){
document.getElementById('sboxframe').src = 'php/sboxwarningen.php';
sboxopen.start();
}
else {
ajaxFunction();
}
}

   function ajaxFunction()
  {  var xmlHttp;
  var InputArea = document.getElementById('InputArea').value;
  try
    {     xmlHttp=new XMLHttpRequest();    }
  catch (e)
    {   
  try
      {      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");      }
    catch (e)
      {      try
        {        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");        }
      catch (e)
        {        alert("Your browser does not support AJAX!");        return false;        }      }    }
    xmlHttp.onreadystatechange=function()
      {
      if(xmlHttp.readyState==4)
        {
document.getElementById('sboxframe').src = 'php/call.php';
sboxopen.start();
        }
      }
    xmlHttp.open("POST","php/session.php",true);
	xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
    xmlHttp.send("InputArea=" + InputArea);  }

	function ajaxFunctionYahooDict()
  {  var xmlHttp;
  var InputArea = document.getElementById('InputArea').value;
  try
    {     xmlHttp=new XMLHttpRequest();    }
  catch (e)
    {   
  try
      {      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");      }
    catch (e)
      {      try
        {        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");        }
      catch (e)
        {        alert("Your browser does not support AJAX!");        return false;        }      }    }
    xmlHttp.onreadystatechange=function()
      {
      if(xmlHttp.readyState==4)
        {
var yahoodictwindow = window.open ('php/callyahoo.php', 'yahoodict');
yahoodictwindow.focus();
return false;
        }
      }
    xmlHttp.open("POST","php/session.php",true);
	xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
    xmlHttp.send("InputArea=" + InputArea);  }

	function ajaxLookupFunction()
  {  var xmlHttp;
  var query = document.getElementById('query').value;
  try
    {     xmlHttp=new XMLHttpRequest();    }
  catch (e)
    {   
  try
      {      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");      }
    catch (e)
      {      try
        {        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");        }
      catch (e)
        {        alert("Your browser does not support AJAX!");        return false;        }      }    }
    xmlHttp.onreadystatechange=function()
      {
      if(xmlHttp.readyState==4)
        {
 updatepage("result", xmlHttp.responseText);
        }
      }
    xmlHttp.open("POST","php/lookupcall.php",true);
	xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
    xmlHttp.send("query=" + query);  }

	function updatepage(whichdiv,str){
    document.getElementById(whichdiv).innerHTML = str;
}

function Delegate() {}
Delegate.create = function (o, f) {
	var a = new Array() ;
	var l = arguments.length ;
	for(var i = 2 ; i < l ; i++) a[i - 2] = arguments[i] ;
	return function() {
		var aP = [].concat(arguments, a) ;
		f.apply(o, aP);
	}
}

var Tween = function(obj, prop, func, begin, finish, duration, suffixe){
	this.init(obj, prop, func, begin, finish, duration, suffixe)
}
var t = Tween.prototype;

t.obj = new Object();
t.prop='';
t.func = function (t, b, c, d) { return c*t/d + b; };
t.begin = 0;
t.change = 0;
t.prevTime = 0;
t.prevPos = 0;
t.looping = false;
t._duration = 0;
t._time = 0;
t._pos = 0;
t._position = 0;
t._startTime = 0;
t._finish = 0;
t.name = '';
t.suffixe = '';
t._listeners = new Array();	
t.setTime = function(t){
	this.prevTime = this._time;
	if (t > this.getDuration()) {
		if (this.looping) {
			this.rewind (t - this._duration);
			this.update();
			this.broadcastMessage('onMotionLooped',{target:this,type:'onMotionLooped'});
		} else {
			this._time = this._duration;
			this.update();
			this.stop();
			this.broadcastMessage('onMotionFinished',{target:this,type:'onMotionFinished'});
		}
	} else if (t < 0) {
		this.rewind();
		this.update();
	} else {
		this._time = t;
		this.update();
	}
}
t.getTime = function(){
	return this._time;
}
t.setDuration = function(d){
	this._duration = (d == null || d <= 0) ? 100000 : d;
}
t.getDuration = function(){
	return this._duration;
}
t.setPosition = function(p){
	this.prevPos = this._pos;
	var a = this.suffixe != '' ? this.suffixe : '';
	this.obj[this.prop] = Math.round(p) + a;
	this._pos = p;
	this.broadcastMessage('onMotionChanged',{target:this,type:'onMotionChanged'});
}
t.getPosition = function(t){
	if (t == undefined) t = this._time;
	return this.func(t, this.begin, this.change, this._duration);
};
t.setFinish = function(f){
	this.change = f - this.begin;
};
t.geFinish = function(){
	return this.begin + this.change;
};
t.init = function(obj, prop, func, begin, finish, duration, suffixe){
	if (!arguments.length) return;
	this._listeners = new Array();
	this.addListener(this);
	if(suffixe) this.suffixe = suffixe;
	this.obj = obj;
	this.prop = prop;
	this.begin = begin;
	this._pos = begin;
	this.setDuration(duration);
	if (func!=null && func!='') {
		this.func = func;
	}
	this.setFinish(finish);
}
t.start = function(){
	this.rewind();
	this.startEnterFrame();
	this.broadcastMessage('onMotionStarted',{target:this,type:'onMotionStarted'});
}
t.rewind = function(t){
	this.stop();
	this._time = (t == undefined) ? 0 : t;
	this.fixTime();
	this.update();
}
t.fforward = function(){
	this._time = this._duration;
	this.fixTime();
	this.update();
}
t.update = function(){
	this.setPosition(this.getPosition(this._time));
	}
t.startEnterFrame = function(){
	this.stopEnterFrame();
	this.isPlaying = true;
	this.onEnterFrame();
}
t.onEnterFrame = function(){
	if(this.isPlaying) {
		this.nextFrame();
		setTimeout(Delegate.create(this, this.onEnterFrame), 0);
	}
}
t.nextFrame = function(){
	this.setTime((this.getTimer() - this._startTime) / 1000);
	}
t.stop = function(){
	this.stopEnterFrame();
	this.broadcastMessage('onMotionStopped',{target:this,type:'onMotionStopped'});
}
t.stopEnterFrame = function(){
	this.isPlaying = false;
}

t.continueTo = function(finish, duration){
	this.begin = this._pos;
	this.setFinish(finish);
	if (this._duration != undefined)
		this.setDuration(duration);
	this.start();
}
t.resume = function(){
	this.fixTime();
	this.startEnterFrame();
	this.broadcastMessage('onMotionResumed',{target:this,type:'onMotionResumed'});
}
t.yoyo = function (){
	this.continueTo(this.begin,this._time);
}

t.addListener = function(o){
	this.removeListener (o);
	return this._listeners.push(o);
}
t.removeListener = function(o){
	var a = this._listeners;	
	var i = a.length;
	while (i--) {
		if (a[i] == o) {
			a.splice (i, 1);
			return true;
		}
	}
	return false;
}
t.broadcastMessage = function(){
	var arr = new Array();
	for(var i = 0; i < arguments.length; i++){
		arr.push(arguments[i])
	}
	var e = arr.shift();
	var a = this._listeners;
	var l = a.length;
	for (var i=0; i<l; i++){
		if(a[i][e])
		a[i][e].apply(a[i], arr);
	}
}
t.fixTime = function(){
	this._startTime = this.getTimer() - this._time * 1000;
}
t.getTimer = function(){
	return new Date().getTime() - this._time;
}

Tween.regularEaseIn = function(t,b,c,d){
	return c*(t/=d)*t + b;
	}

mergeengwords();
document.loadstatus.ime.checked=true;