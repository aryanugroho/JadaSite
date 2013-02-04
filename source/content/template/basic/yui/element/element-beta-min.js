/*
Copyright (c) 2007, Yahoo! Inc. All rights reserved.
Code licensed under the BSD License:
http://developer.yahoo.net/yui/license.txt
version: 2.3.0
*/

YAHOO.util.Attribute=function(hash,owner){if(owner){this.owner=owner;this.configure(hash,true);}};YAHOO.util.Attribute.prototype={name:undefined,value:null,owner:null,readOnly:false,writeOnce:false,_initialConfig:null,_written:false,method:null,validator:null,getValue:function(){return this.value;},setValue:function(value,silent){var beforeRetVal;var owner=this.owner;var name=this.name;var event={type:name,prevValue:this.getValue(),newValue:value};if(this.readOnly||(this.writeOnce&&this._written)){return false;}
if(this.validator&&!this.validator.call(owner,value)){return false;}
if(!silent){beforeRetVal=owner.fireBeforeChangeEvent(event);if(beforeRetVal===false){return false;}}
if(this.method){this.method.call(owner,value);}
this.value=value;this._written=true;event.type=name;if(!silent){this.owner.fireChangeEvent(event);}
return true;},configure:function(map,init){map=map||{};this._written=false;this._initialConfig=this._initialConfig||{};for(var key in map){if(key&&YAHOO.lang.hasOwnProperty(map,key)){this[key]=map[key];if(init){this._initialConfig[key]=map[key];}}}},resetValue:function(){return this.setValue(this._initialConfig.value);},resetConfig:function(){this.configure(this._initialConfig);},refresh:function(silent){this.setValue(this.value,silent);}};(function(){var Lang=YAHOO.util.Lang;YAHOO.util.AttributeProvider=function(){};YAHOO.util.AttributeProvider.prototype={_configs:null,get:function(key){var configs=this._configs||{};var config=configs[key];if(!config){return undefined;}
return config.value;},set:function(key,value,silent){var configs=this._configs||{};var config=configs[key];if(!config){return false;}
return config.setValue(value,silent);},getAttributeKeys:function(){var configs=this._configs;var keys=[];var config;for(var key in configs){config=configs[key];if(Lang.hasOwnProperty(configs,key)&&!Lang.isUndefined(config)){keys[keys.length]=key;}}
return keys;},setAttributes:function(map,silent){for(var key in map){if(Lang.hasOwnProperty(map,key)){this.set(key,map[key],silent);}}},resetValue:function(key,silent){var configs=this._configs||{};if(configs[key]){this.set(key,configs[key]._initialConfig.value,silent);return true;}
return false;},refresh:function(key,silent){var configs=this._configs;key=((Lang.isString(key))?[key]:key)||this.getAttributeKeys();for(var i=0,len=key.length;i<len;++i){if(configs[key[i]]&&!Lang.isUndefined(configs[key[i]].value)&&!Lang.isNull(configs[key[i]].value)){configs[key[i]].refresh(silent);}}},register:function(key,map){this.setAttributeConfig(key,map);},getAttributeConfig:function(key){var configs=this._configs||{};var config=configs[key]||{};var map={};for(key in config){if(Lang.hasOwnProperty(config,key)){map[key]=config[key];}}
return map;},setAttributeConfig:function(key,map,init){var configs=this._configs||{};map=map||{};if(!configs[key]){map.name=key;configs[key]=new YAHOO.util.Attribute(map,this);}else{configs[key].configure(map,init);}},configureAttribute:function(key,map,init){this.setAttributeConfig(key,map,init);},resetAttributeConfig:function(key){var configs=this._configs||{};configs[key].resetConfig();},fireBeforeChangeEvent:function(e){var type='before';type+=e.type.charAt(0).toUpperCase()+e.type.substr(1)+'Change';e.type=type;return this.fireEvent(e.type,e);},fireChangeEvent:function(e){e.type+='Change';return this.fireEvent(e.type,e);}};YAHOO.augment(YAHOO.util.AttributeProvider,YAHOO.util.EventProvider);})();(function(){var Dom=YAHOO.util.Dom,AttributeProvider=YAHOO.util.AttributeProvider;YAHOO.util.Element=function(el,map){if(arguments.length){this.init(el,map);}};YAHOO.util.Element.prototype={DOM_EVENTS:null,appendChild:function(child){child=child.get?child.get('element'):child;this.get('element').appendChild(child);},getElementsByTagName:function(tag){return this.get('element').getElementsByTagName(tag);},hasChildNodes:function(){return this.get('element').hasChildNodes();},insertBefore:function(element,before){element=element.get?element.get('element'):element;before=(before&&before.get)?before.get('element'):before;this.get('element').insertBefore(element,before);},removeChild:function(child){child=child.get?child.get('element'):child;this.get('element').removeChild(child);return true;},replaceChild:function(newNode,oldNode){newNode=newNode.get?newNode.get('element'):newNode;oldNode=oldNode.get?oldNode.get('element'):oldNode;return this.get('element').replaceChild(newNode,oldNode);},initAttributes:function(map){},addListener:function(type,fn,obj,scope){var el=this.get('element');scope=scope||this;el=this.get('id')||el;var self=this;if(!this._events[type]){if(this.DOM_EVENTS[type]){YAHOO.util.Event.addListener(el,type,function(e){if(e.srcElement&&!e.target){e.target=e.srcElement;}
self.fireEvent(type,e);},obj,scope);}
this.createEvent(type,this);}
YAHOO.util.EventProvider.prototype.subscribe.apply(this,arguments);},on:function(){this.addListener.apply(this,arguments);},subscribe:function(){this.addListener.apply(this,arguments);},removeListener:function(type,fn){this.unsubscribe.apply(this,arguments);},addClass:function(className){Dom.addClass(this.get('element'),className);},getElementsByClassName:function(className,tag){return Dom.getElementsByClassName(className,tag,this.get('element'));},hasClass:function(className){return Dom.hasClass(this.get('element'),className);},removeClass:function(className){return Dom.removeClass(this.get('element'),className);},replaceClass:function(oldClassName,newClassName){return Dom.replaceClass(this.get('element'),oldClassName,newClassName);},setStyle:function(property,value){var el=this.get('element');if(!el){return this._queue[this._queue.length]=['setStyle',arguments];}
return Dom.setStyle(el,property,value);},getStyle:function(property){return Dom.getStyle(this.get('element'),property);},fireQueue:function(){var queue=this._queue;for(var i=0,len=queue.length;i<len;++i){this[queue[i][0]].apply(this,queue[i][1]);}},appendTo:function(parent,before){parent=(parent.get)?parent.get('element'):Dom.get(parent);this.fireEvent('beforeAppendTo',{type:'beforeAppendTo',target:parent});before=(before&&before.get)?before.get('element'):Dom.get(before);var element=this.get('element');if(!element){return false;}
if(!parent){return false;}
if(element.parent!=parent){if(before){parent.insertBefore(element,before);}else{parent.appendChild(element);}}
this.fireEvent('appendTo',{type:'appendTo',target:parent});},get:function(key){var configs=this._configs||{};var el=configs.element;if(el&&!configs[key]&&!YAHOO.lang.isUndefined(el.value[key])){return el.value[key];}
return AttributeProvider.prototype.get.call(this,key);},setAttributes:function(map,silent){var el=this.get('element');for(var key in map){if(!this._configs[key]&&!YAHOO.lang.isUndefined(el[key])){this.setAttributeConfig(key);}}
for(var i=0,len=this._configOrder.length;i<len;++i){if(map[this._configOrder[i]]){this.set(this._configOrder[i],map[this._configOrder[i]],silent);}}},set:function(key,value,silent){var el=this.get('element');if(!el){this._queue[this._queue.length]=['set',arguments];if(this._configs[key]){this._configs[key].value=value;}
return;}
if(!this._configs[key]&&!YAHOO.lang.isUndefined(el[key])){_registerHTMLAttr.call(this,key);}
return AttributeProvider.prototype.set.apply(this,arguments);},setAttributeConfig:function(key,map,init){var el=this.get('element');if(el&&!this._configs[key]&&!YAHOO.lang.isUndefined(el[key])){_registerHTMLAttr.call(this,key,map);}else{AttributeProvider.prototype.setAttributeConfig.apply(this,arguments);}
this._configOrder.push(key);},getAttributeKeys:function(){var el=this.get('element');var keys=AttributeProvider.prototype.getAttributeKeys.call(this);for(var key in el){if(!this._configs[key]){keys[key]=keys[key]||el[key];}}
return keys;},createEvent:function(type,scope){this._events[type]=true;AttributeProvider.prototype.createEvent.apply(this,arguments);},init:function(el,attr){_initElement.apply(this,arguments);}};var _initElement=function(el,attr){this._queue=this._queue||[];this._events=this._events||{};this._configs=this._configs||{};this._configOrder=[];attr=attr||{};attr.element=attr.element||el||null;this.DOM_EVENTS={'click':true,'dblclick':true,'keydown':true,'keypress':true,'keyup':true,'mousedown':true,'mousemove':true,'mouseout':true,'mouseover':true,'mouseup':true,'focus':true,'blur':true,'submit':true};var isReady=false;if(YAHOO.lang.isString(el)){_registerHTMLAttr.call(this,'id',{value:attr.element});}
if(Dom.get(el)){isReady=true;_initHTMLElement.call(this,attr);_initContent.call(this,attr);}
YAHOO.util.Event.onAvailable(attr.element,function(){if(!isReady){_initHTMLElement.call(this,attr);}
this.fireEvent('available',{type:'available',target:attr.element});},this,true);YAHOO.util.Event.onContentReady(attr.element,function(){if(!isReady){_initContent.call(this,attr);}
this.fireEvent('contentReady',{type:'contentReady',target:attr.element});},this,true);};var _initHTMLElement=function(attr){this.setAttributeConfig('element',{value:Dom.get(attr.element),readOnly:true});};var _initContent=function(attr){this.initAttributes(attr);this.setAttributes(attr,true);this.fireQueue();};var _registerHTMLAttr=function(key,map){var el=this.get('element');map=map||{};map.name=key;map.method=map.method||function(value){el[key]=value;};map.value=map.value||el[key];this._configs[key]=new YAHOO.util.Attribute(map,this);};YAHOO.augment(YAHOO.util.Element,AttributeProvider);})();YAHOO.register("element",YAHOO.util.Element,{version:"2.3.0",build:"442"});