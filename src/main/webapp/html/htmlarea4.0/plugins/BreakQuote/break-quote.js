// Copyright Inferior-Products.com 2007-2013
//
// Copyright Dynarch.com 2003-2007
//
// This plugin is distributed under a BSD-style license.
function BreakQuote(editor,params){this.editor=editor;};BreakQuote._pluginInfo={name:"BreakQuote",version:"1.5",developer:"SF_chris",developer_url:"http://Inferior-Products.com/",c_owner:"Inferior-Products.com",sponsor:"Inferior-Products",sponsor_url:"http://Inferior-Products.com/",license:"BSD-style license"};BreakQuote.prototype.onKeyPress=function(ev){if(ev.keyCode!=13)return false;var i,sel,range,r2,df,p,editor=this.editor,qdiv=null,p=editor.getAllAncestors();for(i=0;i<p.length;++i)if(p[i].tagName.toLowerCase()=='div'&&/(^|\s+)quote(\s+|$)/.test(p[i].className))qdiv=p[i];if(qdiv){sel=editor._getSelection();range=editor._createRange(sel);if(!HTMLArea.is_ie){sel.removeAllRanges();r2=range.cloneRange();r2.setEndAfter(qdiv);df=r2.extractContents();p=editor._doc.createElement("p");p.appendChild(editor._doc.createElement("br"));df.insertBefore(p,df.firstChild);qdiv.parentNode.insertBefore(df,qdiv.nextSibling);range.selectNodeContents(p);range.collapse(true);sel.addRange(range);}else{r2=range.duplicate();r2.moveToElementText(qdiv);r2.setEndPoint("StartToStart",range);var txt=r2.htmlText.replace(/\s*<p>\s*<\/p>\s*/i,'');r2.pasteHTML('');p=editor._doc.createElement("p");p.innerHTML="&nbsp;<br />";qdiv.parentNode.insertBefore(p,qdiv.nextSibling);var tmp=qdiv.cloneNode(true);tmp.innerHTML=txt;qdiv.parentNode.insertBefore(tmp,p.nextSibling);range.moveToElementText(p);range.moveEnd('character',-1);range.pasteHTML('');range.select();}HTMLArea._stopEvent(ev);return true;}};
