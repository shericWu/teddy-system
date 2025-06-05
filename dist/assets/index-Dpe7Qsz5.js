(function(){const t=document.createElement("link").relList;if(t&&t.supports&&t.supports("modulepreload"))return;for(const r of document.querySelectorAll('link[rel="modulepreload"]'))n(r);new MutationObserver(r=>{for(const s of r)if(s.type==="childList")for(const a of s.addedNodes)a.tagName==="LINK"&&a.rel==="modulepreload"&&n(a)}).observe(document,{childList:!0,subtree:!0});function e(r){const s={};return r.integrity&&(s.integrity=r.integrity),r.referrerPolicy&&(s.referrerPolicy=r.referrerPolicy),r.crossOrigin==="use-credentials"?s.credentials="include":r.crossOrigin==="anonymous"?s.credentials="omit":s.credentials="same-origin",s}function n(r){if(r.ep)return;r.ep=!0;const s=e(r);fetch(r.href,s)}})();/**
 * @license
 * Copyright 2010-2025 Three.js Authors
 * SPDX-License-Identifier: MIT
 */const ms="177",ud=0,jl=1,hd=2,Jh=1,fd=2,kn=3,In=0,ze=1,Be=2,li=0,yr=1,Kl=2,Zl=3,Jl=4,dd=5,Li=100,pd=101,gd=102,md=103,_d=104,xd=200,vd=201,yd=202,Sd=203,Tc=204,bc=205,Md=206,Ed=207,Td=208,bd=209,Ad=210,wd=211,Rd=212,Cd=213,Pd=214,Ac=0,wc=1,Rc=2,br=3,Cc=4,Pc=5,Ic=6,Lc=7,Qh=0,Id=1,Ld=2,ui=0,Dd=1,Ud=2,Nd=3,Fd=4,Bd=5,Od=6,zd=7,tf=300,Ar=301,wr=302,Dc=303,Uc=304,Xo=306,No=1e3,Fi=1001,Nc=1002,Je=1003,Vd=1004,bs=1005,bn=1006,ta=1007,Bi=1008,Ln=1009,ef=1010,nf=1011,ls=1012,El=1013,di=1014,yn=1015,_s=1016,Tl=1017,bl=1018,us=1020,rf=35902,sf=1021,of=1022,Ke=1023,hs=1026,fs=1027,af=1028,qo=1029,cf=1030,Al=1031,wl=1033,yo=33776,So=33777,Mo=33778,Eo=33779,Fc=35840,Bc=35841,Oc=35842,zc=35843,Vc=36196,Hc=37492,Gc=37496,kc=37808,Wc=37809,Xc=37810,qc=37811,Yc=37812,$c=37813,jc=37814,Kc=37815,Zc=37816,Jc=37817,Qc=37818,tl=37819,el=37820,nl=37821,To=36492,il=36494,rl=36495,lf=36283,sl=36284,ol=36285,al=36286,Hd=3200,Gd=3201,uf=0,kd=1,ri="",rn="srgb",Rr="srgb-linear",Fo="linear",re="srgb",Gi=7680,Ql=519,Wd=512,Xd=513,qd=514,hf=515,Yd=516,$d=517,jd=518,Kd=519,tu=35044,eu="300 es",An=2e3,Bo=2001;class Ir{addEventListener(t,e){this._listeners===void 0&&(this._listeners={});const n=this._listeners;n[t]===void 0&&(n[t]=[]),n[t].indexOf(e)===-1&&n[t].push(e)}hasEventListener(t,e){const n=this._listeners;return n===void 0?!1:n[t]!==void 0&&n[t].indexOf(e)!==-1}removeEventListener(t,e){const n=this._listeners;if(n===void 0)return;const r=n[t];if(r!==void 0){const s=r.indexOf(e);s!==-1&&r.splice(s,1)}}dispatchEvent(t){const e=this._listeners;if(e===void 0)return;const n=e[t.type];if(n!==void 0){t.target=this;const r=n.slice(0);for(let s=0,a=r.length;s<a;s++)r[s].call(this,t);t.target=null}}}const Re=["00","01","02","03","04","05","06","07","08","09","0a","0b","0c","0d","0e","0f","10","11","12","13","14","15","16","17","18","19","1a","1b","1c","1d","1e","1f","20","21","22","23","24","25","26","27","28","29","2a","2b","2c","2d","2e","2f","30","31","32","33","34","35","36","37","38","39","3a","3b","3c","3d","3e","3f","40","41","42","43","44","45","46","47","48","49","4a","4b","4c","4d","4e","4f","50","51","52","53","54","55","56","57","58","59","5a","5b","5c","5d","5e","5f","60","61","62","63","64","65","66","67","68","69","6a","6b","6c","6d","6e","6f","70","71","72","73","74","75","76","77","78","79","7a","7b","7c","7d","7e","7f","80","81","82","83","84","85","86","87","88","89","8a","8b","8c","8d","8e","8f","90","91","92","93","94","95","96","97","98","99","9a","9b","9c","9d","9e","9f","a0","a1","a2","a3","a4","a5","a6","a7","a8","a9","aa","ab","ac","ad","ae","af","b0","b1","b2","b3","b4","b5","b6","b7","b8","b9","ba","bb","bc","bd","be","bf","c0","c1","c2","c3","c4","c5","c6","c7","c8","c9","ca","cb","cc","cd","ce","cf","d0","d1","d2","d3","d4","d5","d6","d7","d8","d9","da","db","dc","dd","de","df","e0","e1","e2","e3","e4","e5","e6","e7","e8","e9","ea","eb","ec","ed","ee","ef","f0","f1","f2","f3","f4","f5","f6","f7","f8","f9","fa","fb","fc","fd","fe","ff"],ea=Math.PI/180,cl=180/Math.PI;function xs(){const i=Math.random()*4294967295|0,t=Math.random()*4294967295|0,e=Math.random()*4294967295|0,n=Math.random()*4294967295|0;return(Re[i&255]+Re[i>>8&255]+Re[i>>16&255]+Re[i>>24&255]+"-"+Re[t&255]+Re[t>>8&255]+"-"+Re[t>>16&15|64]+Re[t>>24&255]+"-"+Re[e&63|128]+Re[e>>8&255]+"-"+Re[e>>16&255]+Re[e>>24&255]+Re[n&255]+Re[n>>8&255]+Re[n>>16&255]+Re[n>>24&255]).toLowerCase()}function Yt(i,t,e){return Math.max(t,Math.min(e,i))}function Zd(i,t){return(i%t+t)%t}function na(i,t,e){return(1-e)*i+e*t}function Br(i,t){switch(t.constructor){case Float32Array:return i;case Uint32Array:return i/4294967295;case Uint16Array:return i/65535;case Uint8Array:return i/255;case Int32Array:return Math.max(i/2147483647,-1);case Int16Array:return Math.max(i/32767,-1);case Int8Array:return Math.max(i/127,-1);default:throw new Error("Invalid component type.")}}function Ge(i,t){switch(t.constructor){case Float32Array:return i;case Uint32Array:return Math.round(i*4294967295);case Uint16Array:return Math.round(i*65535);case Uint8Array:return Math.round(i*255);case Int32Array:return Math.round(i*2147483647);case Int16Array:return Math.round(i*32767);case Int8Array:return Math.round(i*127);default:throw new Error("Invalid component type.")}}class kt{constructor(t=0,e=0){kt.prototype.isVector2=!0,this.x=t,this.y=e}get width(){return this.x}set width(t){this.x=t}get height(){return this.y}set height(t){this.y=t}set(t,e){return this.x=t,this.y=e,this}setScalar(t){return this.x=t,this.y=t,this}setX(t){return this.x=t,this}setY(t){return this.y=t,this}setComponent(t,e){switch(t){case 0:this.x=e;break;case 1:this.y=e;break;default:throw new Error("index is out of range: "+t)}return this}getComponent(t){switch(t){case 0:return this.x;case 1:return this.y;default:throw new Error("index is out of range: "+t)}}clone(){return new this.constructor(this.x,this.y)}copy(t){return this.x=t.x,this.y=t.y,this}add(t){return this.x+=t.x,this.y+=t.y,this}addScalar(t){return this.x+=t,this.y+=t,this}addVectors(t,e){return this.x=t.x+e.x,this.y=t.y+e.y,this}addScaledVector(t,e){return this.x+=t.x*e,this.y+=t.y*e,this}sub(t){return this.x-=t.x,this.y-=t.y,this}subScalar(t){return this.x-=t,this.y-=t,this}subVectors(t,e){return this.x=t.x-e.x,this.y=t.y-e.y,this}multiply(t){return this.x*=t.x,this.y*=t.y,this}multiplyScalar(t){return this.x*=t,this.y*=t,this}divide(t){return this.x/=t.x,this.y/=t.y,this}divideScalar(t){return this.multiplyScalar(1/t)}applyMatrix3(t){const e=this.x,n=this.y,r=t.elements;return this.x=r[0]*e+r[3]*n+r[6],this.y=r[1]*e+r[4]*n+r[7],this}min(t){return this.x=Math.min(this.x,t.x),this.y=Math.min(this.y,t.y),this}max(t){return this.x=Math.max(this.x,t.x),this.y=Math.max(this.y,t.y),this}clamp(t,e){return this.x=Yt(this.x,t.x,e.x),this.y=Yt(this.y,t.y,e.y),this}clampScalar(t,e){return this.x=Yt(this.x,t,e),this.y=Yt(this.y,t,e),this}clampLength(t,e){const n=this.length();return this.divideScalar(n||1).multiplyScalar(Yt(n,t,e))}floor(){return this.x=Math.floor(this.x),this.y=Math.floor(this.y),this}ceil(){return this.x=Math.ceil(this.x),this.y=Math.ceil(this.y),this}round(){return this.x=Math.round(this.x),this.y=Math.round(this.y),this}roundToZero(){return this.x=Math.trunc(this.x),this.y=Math.trunc(this.y),this}negate(){return this.x=-this.x,this.y=-this.y,this}dot(t){return this.x*t.x+this.y*t.y}cross(t){return this.x*t.y-this.y*t.x}lengthSq(){return this.x*this.x+this.y*this.y}length(){return Math.sqrt(this.x*this.x+this.y*this.y)}manhattanLength(){return Math.abs(this.x)+Math.abs(this.y)}normalize(){return this.divideScalar(this.length()||1)}angle(){return Math.atan2(-this.y,-this.x)+Math.PI}angleTo(t){const e=Math.sqrt(this.lengthSq()*t.lengthSq());if(e===0)return Math.PI/2;const n=this.dot(t)/e;return Math.acos(Yt(n,-1,1))}distanceTo(t){return Math.sqrt(this.distanceToSquared(t))}distanceToSquared(t){const e=this.x-t.x,n=this.y-t.y;return e*e+n*n}manhattanDistanceTo(t){return Math.abs(this.x-t.x)+Math.abs(this.y-t.y)}setLength(t){return this.normalize().multiplyScalar(t)}lerp(t,e){return this.x+=(t.x-this.x)*e,this.y+=(t.y-this.y)*e,this}lerpVectors(t,e,n){return this.x=t.x+(e.x-t.x)*n,this.y=t.y+(e.y-t.y)*n,this}equals(t){return t.x===this.x&&t.y===this.y}fromArray(t,e=0){return this.x=t[e],this.y=t[e+1],this}toArray(t=[],e=0){return t[e]=this.x,t[e+1]=this.y,t}fromBufferAttribute(t,e){return this.x=t.getX(e),this.y=t.getY(e),this}rotateAround(t,e){const n=Math.cos(e),r=Math.sin(e),s=this.x-t.x,a=this.y-t.y;return this.x=s*n-a*r+t.x,this.y=s*r+a*n+t.y,this}random(){return this.x=Math.random(),this.y=Math.random(),this}*[Symbol.iterator](){yield this.x,yield this.y}}class vs{constructor(t=0,e=0,n=0,r=1){this.isQuaternion=!0,this._x=t,this._y=e,this._z=n,this._w=r}static slerpFlat(t,e,n,r,s,a,o){let c=n[r+0],h=n[r+1],f=n[r+2],g=n[r+3];const p=s[a+0],_=s[a+1],M=s[a+2],b=s[a+3];if(o===0){t[e+0]=c,t[e+1]=h,t[e+2]=f,t[e+3]=g;return}if(o===1){t[e+0]=p,t[e+1]=_,t[e+2]=M,t[e+3]=b;return}if(g!==b||c!==p||h!==_||f!==M){let x=1-o;const m=c*p+h*_+f*M+g*b,d=m>=0?1:-1,u=1-m*m;if(u>Number.EPSILON){const l=Math.sqrt(u),R=Math.atan2(l,m*d);x=Math.sin(x*R)/l,o=Math.sin(o*R)/l}const v=o*d;if(c=c*x+p*v,h=h*x+_*v,f=f*x+M*v,g=g*x+b*v,x===1-o){const l=1/Math.sqrt(c*c+h*h+f*f+g*g);c*=l,h*=l,f*=l,g*=l}}t[e]=c,t[e+1]=h,t[e+2]=f,t[e+3]=g}static multiplyQuaternionsFlat(t,e,n,r,s,a){const o=n[r],c=n[r+1],h=n[r+2],f=n[r+3],g=s[a],p=s[a+1],_=s[a+2],M=s[a+3];return t[e]=o*M+f*g+c*_-h*p,t[e+1]=c*M+f*p+h*g-o*_,t[e+2]=h*M+f*_+o*p-c*g,t[e+3]=f*M-o*g-c*p-h*_,t}get x(){return this._x}set x(t){this._x=t,this._onChangeCallback()}get y(){return this._y}set y(t){this._y=t,this._onChangeCallback()}get z(){return this._z}set z(t){this._z=t,this._onChangeCallback()}get w(){return this._w}set w(t){this._w=t,this._onChangeCallback()}set(t,e,n,r){return this._x=t,this._y=e,this._z=n,this._w=r,this._onChangeCallback(),this}clone(){return new this.constructor(this._x,this._y,this._z,this._w)}copy(t){return this._x=t.x,this._y=t.y,this._z=t.z,this._w=t.w,this._onChangeCallback(),this}setFromEuler(t,e=!0){const n=t._x,r=t._y,s=t._z,a=t._order,o=Math.cos,c=Math.sin,h=o(n/2),f=o(r/2),g=o(s/2),p=c(n/2),_=c(r/2),M=c(s/2);switch(a){case"XYZ":this._x=p*f*g+h*_*M,this._y=h*_*g-p*f*M,this._z=h*f*M+p*_*g,this._w=h*f*g-p*_*M;break;case"YXZ":this._x=p*f*g+h*_*M,this._y=h*_*g-p*f*M,this._z=h*f*M-p*_*g,this._w=h*f*g+p*_*M;break;case"ZXY":this._x=p*f*g-h*_*M,this._y=h*_*g+p*f*M,this._z=h*f*M+p*_*g,this._w=h*f*g-p*_*M;break;case"ZYX":this._x=p*f*g-h*_*M,this._y=h*_*g+p*f*M,this._z=h*f*M-p*_*g,this._w=h*f*g+p*_*M;break;case"YZX":this._x=p*f*g+h*_*M,this._y=h*_*g+p*f*M,this._z=h*f*M-p*_*g,this._w=h*f*g-p*_*M;break;case"XZY":this._x=p*f*g-h*_*M,this._y=h*_*g-p*f*M,this._z=h*f*M+p*_*g,this._w=h*f*g+p*_*M;break;default:console.warn("THREE.Quaternion: .setFromEuler() encountered an unknown order: "+a)}return e===!0&&this._onChangeCallback(),this}setFromAxisAngle(t,e){const n=e/2,r=Math.sin(n);return this._x=t.x*r,this._y=t.y*r,this._z=t.z*r,this._w=Math.cos(n),this._onChangeCallback(),this}setFromRotationMatrix(t){const e=t.elements,n=e[0],r=e[4],s=e[8],a=e[1],o=e[5],c=e[9],h=e[2],f=e[6],g=e[10],p=n+o+g;if(p>0){const _=.5/Math.sqrt(p+1);this._w=.25/_,this._x=(f-c)*_,this._y=(s-h)*_,this._z=(a-r)*_}else if(n>o&&n>g){const _=2*Math.sqrt(1+n-o-g);this._w=(f-c)/_,this._x=.25*_,this._y=(r+a)/_,this._z=(s+h)/_}else if(o>g){const _=2*Math.sqrt(1+o-n-g);this._w=(s-h)/_,this._x=(r+a)/_,this._y=.25*_,this._z=(c+f)/_}else{const _=2*Math.sqrt(1+g-n-o);this._w=(a-r)/_,this._x=(s+h)/_,this._y=(c+f)/_,this._z=.25*_}return this._onChangeCallback(),this}setFromUnitVectors(t,e){let n=t.dot(e)+1;return n<Number.EPSILON?(n=0,Math.abs(t.x)>Math.abs(t.z)?(this._x=-t.y,this._y=t.x,this._z=0,this._w=n):(this._x=0,this._y=-t.z,this._z=t.y,this._w=n)):(this._x=t.y*e.z-t.z*e.y,this._y=t.z*e.x-t.x*e.z,this._z=t.x*e.y-t.y*e.x,this._w=n),this.normalize()}angleTo(t){return 2*Math.acos(Math.abs(Yt(this.dot(t),-1,1)))}rotateTowards(t,e){const n=this.angleTo(t);if(n===0)return this;const r=Math.min(1,e/n);return this.slerp(t,r),this}identity(){return this.set(0,0,0,1)}invert(){return this.conjugate()}conjugate(){return this._x*=-1,this._y*=-1,this._z*=-1,this._onChangeCallback(),this}dot(t){return this._x*t._x+this._y*t._y+this._z*t._z+this._w*t._w}lengthSq(){return this._x*this._x+this._y*this._y+this._z*this._z+this._w*this._w}length(){return Math.sqrt(this._x*this._x+this._y*this._y+this._z*this._z+this._w*this._w)}normalize(){let t=this.length();return t===0?(this._x=0,this._y=0,this._z=0,this._w=1):(t=1/t,this._x=this._x*t,this._y=this._y*t,this._z=this._z*t,this._w=this._w*t),this._onChangeCallback(),this}multiply(t){return this.multiplyQuaternions(this,t)}premultiply(t){return this.multiplyQuaternions(t,this)}multiplyQuaternions(t,e){const n=t._x,r=t._y,s=t._z,a=t._w,o=e._x,c=e._y,h=e._z,f=e._w;return this._x=n*f+a*o+r*h-s*c,this._y=r*f+a*c+s*o-n*h,this._z=s*f+a*h+n*c-r*o,this._w=a*f-n*o-r*c-s*h,this._onChangeCallback(),this}slerp(t,e){if(e===0)return this;if(e===1)return this.copy(t);const n=this._x,r=this._y,s=this._z,a=this._w;let o=a*t._w+n*t._x+r*t._y+s*t._z;if(o<0?(this._w=-t._w,this._x=-t._x,this._y=-t._y,this._z=-t._z,o=-o):this.copy(t),o>=1)return this._w=a,this._x=n,this._y=r,this._z=s,this;const c=1-o*o;if(c<=Number.EPSILON){const _=1-e;return this._w=_*a+e*this._w,this._x=_*n+e*this._x,this._y=_*r+e*this._y,this._z=_*s+e*this._z,this.normalize(),this}const h=Math.sqrt(c),f=Math.atan2(h,o),g=Math.sin((1-e)*f)/h,p=Math.sin(e*f)/h;return this._w=a*g+this._w*p,this._x=n*g+this._x*p,this._y=r*g+this._y*p,this._z=s*g+this._z*p,this._onChangeCallback(),this}slerpQuaternions(t,e,n){return this.copy(t).slerp(e,n)}random(){const t=2*Math.PI*Math.random(),e=2*Math.PI*Math.random(),n=Math.random(),r=Math.sqrt(1-n),s=Math.sqrt(n);return this.set(r*Math.sin(t),r*Math.cos(t),s*Math.sin(e),s*Math.cos(e))}equals(t){return t._x===this._x&&t._y===this._y&&t._z===this._z&&t._w===this._w}fromArray(t,e=0){return this._x=t[e],this._y=t[e+1],this._z=t[e+2],this._w=t[e+3],this._onChangeCallback(),this}toArray(t=[],e=0){return t[e]=this._x,t[e+1]=this._y,t[e+2]=this._z,t[e+3]=this._w,t}fromBufferAttribute(t,e){return this._x=t.getX(e),this._y=t.getY(e),this._z=t.getZ(e),this._w=t.getW(e),this._onChangeCallback(),this}toJSON(){return this.toArray()}_onChange(t){return this._onChangeCallback=t,this}_onChangeCallback(){}*[Symbol.iterator](){yield this._x,yield this._y,yield this._z,yield this._w}}class U{constructor(t=0,e=0,n=0){U.prototype.isVector3=!0,this.x=t,this.y=e,this.z=n}set(t,e,n){return n===void 0&&(n=this.z),this.x=t,this.y=e,this.z=n,this}setScalar(t){return this.x=t,this.y=t,this.z=t,this}setX(t){return this.x=t,this}setY(t){return this.y=t,this}setZ(t){return this.z=t,this}setComponent(t,e){switch(t){case 0:this.x=e;break;case 1:this.y=e;break;case 2:this.z=e;break;default:throw new Error("index is out of range: "+t)}return this}getComponent(t){switch(t){case 0:return this.x;case 1:return this.y;case 2:return this.z;default:throw new Error("index is out of range: "+t)}}clone(){return new this.constructor(this.x,this.y,this.z)}copy(t){return this.x=t.x,this.y=t.y,this.z=t.z,this}add(t){return this.x+=t.x,this.y+=t.y,this.z+=t.z,this}addScalar(t){return this.x+=t,this.y+=t,this.z+=t,this}addVectors(t,e){return this.x=t.x+e.x,this.y=t.y+e.y,this.z=t.z+e.z,this}addScaledVector(t,e){return this.x+=t.x*e,this.y+=t.y*e,this.z+=t.z*e,this}sub(t){return this.x-=t.x,this.y-=t.y,this.z-=t.z,this}subScalar(t){return this.x-=t,this.y-=t,this.z-=t,this}subVectors(t,e){return this.x=t.x-e.x,this.y=t.y-e.y,this.z=t.z-e.z,this}multiply(t){return this.x*=t.x,this.y*=t.y,this.z*=t.z,this}multiplyScalar(t){return this.x*=t,this.y*=t,this.z*=t,this}multiplyVectors(t,e){return this.x=t.x*e.x,this.y=t.y*e.y,this.z=t.z*e.z,this}applyEuler(t){return this.applyQuaternion(nu.setFromEuler(t))}applyAxisAngle(t,e){return this.applyQuaternion(nu.setFromAxisAngle(t,e))}applyMatrix3(t){const e=this.x,n=this.y,r=this.z,s=t.elements;return this.x=s[0]*e+s[3]*n+s[6]*r,this.y=s[1]*e+s[4]*n+s[7]*r,this.z=s[2]*e+s[5]*n+s[8]*r,this}applyNormalMatrix(t){return this.applyMatrix3(t).normalize()}applyMatrix4(t){const e=this.x,n=this.y,r=this.z,s=t.elements,a=1/(s[3]*e+s[7]*n+s[11]*r+s[15]);return this.x=(s[0]*e+s[4]*n+s[8]*r+s[12])*a,this.y=(s[1]*e+s[5]*n+s[9]*r+s[13])*a,this.z=(s[2]*e+s[6]*n+s[10]*r+s[14])*a,this}applyQuaternion(t){const e=this.x,n=this.y,r=this.z,s=t.x,a=t.y,o=t.z,c=t.w,h=2*(a*r-o*n),f=2*(o*e-s*r),g=2*(s*n-a*e);return this.x=e+c*h+a*g-o*f,this.y=n+c*f+o*h-s*g,this.z=r+c*g+s*f-a*h,this}project(t){return this.applyMatrix4(t.matrixWorldInverse).applyMatrix4(t.projectionMatrix)}unproject(t){return this.applyMatrix4(t.projectionMatrixInverse).applyMatrix4(t.matrixWorld)}transformDirection(t){const e=this.x,n=this.y,r=this.z,s=t.elements;return this.x=s[0]*e+s[4]*n+s[8]*r,this.y=s[1]*e+s[5]*n+s[9]*r,this.z=s[2]*e+s[6]*n+s[10]*r,this.normalize()}divide(t){return this.x/=t.x,this.y/=t.y,this.z/=t.z,this}divideScalar(t){return this.multiplyScalar(1/t)}min(t){return this.x=Math.min(this.x,t.x),this.y=Math.min(this.y,t.y),this.z=Math.min(this.z,t.z),this}max(t){return this.x=Math.max(this.x,t.x),this.y=Math.max(this.y,t.y),this.z=Math.max(this.z,t.z),this}clamp(t,e){return this.x=Yt(this.x,t.x,e.x),this.y=Yt(this.y,t.y,e.y),this.z=Yt(this.z,t.z,e.z),this}clampScalar(t,e){return this.x=Yt(this.x,t,e),this.y=Yt(this.y,t,e),this.z=Yt(this.z,t,e),this}clampLength(t,e){const n=this.length();return this.divideScalar(n||1).multiplyScalar(Yt(n,t,e))}floor(){return this.x=Math.floor(this.x),this.y=Math.floor(this.y),this.z=Math.floor(this.z),this}ceil(){return this.x=Math.ceil(this.x),this.y=Math.ceil(this.y),this.z=Math.ceil(this.z),this}round(){return this.x=Math.round(this.x),this.y=Math.round(this.y),this.z=Math.round(this.z),this}roundToZero(){return this.x=Math.trunc(this.x),this.y=Math.trunc(this.y),this.z=Math.trunc(this.z),this}negate(){return this.x=-this.x,this.y=-this.y,this.z=-this.z,this}dot(t){return this.x*t.x+this.y*t.y+this.z*t.z}lengthSq(){return this.x*this.x+this.y*this.y+this.z*this.z}length(){return Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z)}manhattanLength(){return Math.abs(this.x)+Math.abs(this.y)+Math.abs(this.z)}normalize(){return this.divideScalar(this.length()||1)}setLength(t){return this.normalize().multiplyScalar(t)}lerp(t,e){return this.x+=(t.x-this.x)*e,this.y+=(t.y-this.y)*e,this.z+=(t.z-this.z)*e,this}lerpVectors(t,e,n){return this.x=t.x+(e.x-t.x)*n,this.y=t.y+(e.y-t.y)*n,this.z=t.z+(e.z-t.z)*n,this}cross(t){return this.crossVectors(this,t)}crossVectors(t,e){const n=t.x,r=t.y,s=t.z,a=e.x,o=e.y,c=e.z;return this.x=r*c-s*o,this.y=s*a-n*c,this.z=n*o-r*a,this}projectOnVector(t){const e=t.lengthSq();if(e===0)return this.set(0,0,0);const n=t.dot(this)/e;return this.copy(t).multiplyScalar(n)}projectOnPlane(t){return ia.copy(this).projectOnVector(t),this.sub(ia)}reflect(t){return this.sub(ia.copy(t).multiplyScalar(2*this.dot(t)))}angleTo(t){const e=Math.sqrt(this.lengthSq()*t.lengthSq());if(e===0)return Math.PI/2;const n=this.dot(t)/e;return Math.acos(Yt(n,-1,1))}distanceTo(t){return Math.sqrt(this.distanceToSquared(t))}distanceToSquared(t){const e=this.x-t.x,n=this.y-t.y,r=this.z-t.z;return e*e+n*n+r*r}manhattanDistanceTo(t){return Math.abs(this.x-t.x)+Math.abs(this.y-t.y)+Math.abs(this.z-t.z)}setFromSpherical(t){return this.setFromSphericalCoords(t.radius,t.phi,t.theta)}setFromSphericalCoords(t,e,n){const r=Math.sin(e)*t;return this.x=r*Math.sin(n),this.y=Math.cos(e)*t,this.z=r*Math.cos(n),this}setFromCylindrical(t){return this.setFromCylindricalCoords(t.radius,t.theta,t.y)}setFromCylindricalCoords(t,e,n){return this.x=t*Math.sin(e),this.y=n,this.z=t*Math.cos(e),this}setFromMatrixPosition(t){const e=t.elements;return this.x=e[12],this.y=e[13],this.z=e[14],this}setFromMatrixScale(t){const e=this.setFromMatrixColumn(t,0).length(),n=this.setFromMatrixColumn(t,1).length(),r=this.setFromMatrixColumn(t,2).length();return this.x=e,this.y=n,this.z=r,this}setFromMatrixColumn(t,e){return this.fromArray(t.elements,e*4)}setFromMatrix3Column(t,e){return this.fromArray(t.elements,e*3)}setFromEuler(t){return this.x=t._x,this.y=t._y,this.z=t._z,this}setFromColor(t){return this.x=t.r,this.y=t.g,this.z=t.b,this}equals(t){return t.x===this.x&&t.y===this.y&&t.z===this.z}fromArray(t,e=0){return this.x=t[e],this.y=t[e+1],this.z=t[e+2],this}toArray(t=[],e=0){return t[e]=this.x,t[e+1]=this.y,t[e+2]=this.z,t}fromBufferAttribute(t,e){return this.x=t.getX(e),this.y=t.getY(e),this.z=t.getZ(e),this}random(){return this.x=Math.random(),this.y=Math.random(),this.z=Math.random(),this}randomDirection(){const t=Math.random()*Math.PI*2,e=Math.random()*2-1,n=Math.sqrt(1-e*e);return this.x=n*Math.cos(t),this.y=e,this.z=n*Math.sin(t),this}*[Symbol.iterator](){yield this.x,yield this.y,yield this.z}}const ia=new U,nu=new vs;class Gt{constructor(t,e,n,r,s,a,o,c,h){Gt.prototype.isMatrix3=!0,this.elements=[1,0,0,0,1,0,0,0,1],t!==void 0&&this.set(t,e,n,r,s,a,o,c,h)}set(t,e,n,r,s,a,o,c,h){const f=this.elements;return f[0]=t,f[1]=r,f[2]=o,f[3]=e,f[4]=s,f[5]=c,f[6]=n,f[7]=a,f[8]=h,this}identity(){return this.set(1,0,0,0,1,0,0,0,1),this}copy(t){const e=this.elements,n=t.elements;return e[0]=n[0],e[1]=n[1],e[2]=n[2],e[3]=n[3],e[4]=n[4],e[5]=n[5],e[6]=n[6],e[7]=n[7],e[8]=n[8],this}extractBasis(t,e,n){return t.setFromMatrix3Column(this,0),e.setFromMatrix3Column(this,1),n.setFromMatrix3Column(this,2),this}setFromMatrix4(t){const e=t.elements;return this.set(e[0],e[4],e[8],e[1],e[5],e[9],e[2],e[6],e[10]),this}multiply(t){return this.multiplyMatrices(this,t)}premultiply(t){return this.multiplyMatrices(t,this)}multiplyMatrices(t,e){const n=t.elements,r=e.elements,s=this.elements,a=n[0],o=n[3],c=n[6],h=n[1],f=n[4],g=n[7],p=n[2],_=n[5],M=n[8],b=r[0],x=r[3],m=r[6],d=r[1],u=r[4],v=r[7],l=r[2],R=r[5],T=r[8];return s[0]=a*b+o*d+c*l,s[3]=a*x+o*u+c*R,s[6]=a*m+o*v+c*T,s[1]=h*b+f*d+g*l,s[4]=h*x+f*u+g*R,s[7]=h*m+f*v+g*T,s[2]=p*b+_*d+M*l,s[5]=p*x+_*u+M*R,s[8]=p*m+_*v+M*T,this}multiplyScalar(t){const e=this.elements;return e[0]*=t,e[3]*=t,e[6]*=t,e[1]*=t,e[4]*=t,e[7]*=t,e[2]*=t,e[5]*=t,e[8]*=t,this}determinant(){const t=this.elements,e=t[0],n=t[1],r=t[2],s=t[3],a=t[4],o=t[5],c=t[6],h=t[7],f=t[8];return e*a*f-e*o*h-n*s*f+n*o*c+r*s*h-r*a*c}invert(){const t=this.elements,e=t[0],n=t[1],r=t[2],s=t[3],a=t[4],o=t[5],c=t[6],h=t[7],f=t[8],g=f*a-o*h,p=o*c-f*s,_=h*s-a*c,M=e*g+n*p+r*_;if(M===0)return this.set(0,0,0,0,0,0,0,0,0);const b=1/M;return t[0]=g*b,t[1]=(r*h-f*n)*b,t[2]=(o*n-r*a)*b,t[3]=p*b,t[4]=(f*e-r*c)*b,t[5]=(r*s-o*e)*b,t[6]=_*b,t[7]=(n*c-h*e)*b,t[8]=(a*e-n*s)*b,this}transpose(){let t;const e=this.elements;return t=e[1],e[1]=e[3],e[3]=t,t=e[2],e[2]=e[6],e[6]=t,t=e[5],e[5]=e[7],e[7]=t,this}getNormalMatrix(t){return this.setFromMatrix4(t).invert().transpose()}transposeIntoArray(t){const e=this.elements;return t[0]=e[0],t[1]=e[3],t[2]=e[6],t[3]=e[1],t[4]=e[4],t[5]=e[7],t[6]=e[2],t[7]=e[5],t[8]=e[8],this}setUvTransform(t,e,n,r,s,a,o){const c=Math.cos(s),h=Math.sin(s);return this.set(n*c,n*h,-n*(c*a+h*o)+a+t,-r*h,r*c,-r*(-h*a+c*o)+o+e,0,0,1),this}scale(t,e){return this.premultiply(ra.makeScale(t,e)),this}rotate(t){return this.premultiply(ra.makeRotation(-t)),this}translate(t,e){return this.premultiply(ra.makeTranslation(t,e)),this}makeTranslation(t,e){return t.isVector2?this.set(1,0,t.x,0,1,t.y,0,0,1):this.set(1,0,t,0,1,e,0,0,1),this}makeRotation(t){const e=Math.cos(t),n=Math.sin(t);return this.set(e,-n,0,n,e,0,0,0,1),this}makeScale(t,e){return this.set(t,0,0,0,e,0,0,0,1),this}equals(t){const e=this.elements,n=t.elements;for(let r=0;r<9;r++)if(e[r]!==n[r])return!1;return!0}fromArray(t,e=0){for(let n=0;n<9;n++)this.elements[n]=t[n+e];return this}toArray(t=[],e=0){const n=this.elements;return t[e]=n[0],t[e+1]=n[1],t[e+2]=n[2],t[e+3]=n[3],t[e+4]=n[4],t[e+5]=n[5],t[e+6]=n[6],t[e+7]=n[7],t[e+8]=n[8],t}clone(){return new this.constructor().fromArray(this.elements)}}const ra=new Gt;function ff(i){for(let t=i.length-1;t>=0;--t)if(i[t]>=65535)return!0;return!1}function Oo(i){return document.createElementNS("http://www.w3.org/1999/xhtml",i)}function Jd(){const i=Oo("canvas");return i.style.display="block",i}const iu={};function Sr(i){i in iu||(iu[i]=!0,console.warn(i))}function Qd(i,t,e){return new Promise(function(n,r){function s(){switch(i.clientWaitSync(t,i.SYNC_FLUSH_COMMANDS_BIT,0)){case i.WAIT_FAILED:r();break;case i.TIMEOUT_EXPIRED:setTimeout(s,e);break;default:n()}}setTimeout(s,e)})}function tp(i){const t=i.elements;t[2]=.5*t[2]+.5*t[3],t[6]=.5*t[6]+.5*t[7],t[10]=.5*t[10]+.5*t[11],t[14]=.5*t[14]+.5*t[15]}function ep(i){const t=i.elements;t[11]===-1?(t[10]=-t[10]-1,t[14]=-t[14]):(t[10]=-t[10],t[14]=-t[14]+1)}const ru=new Gt().set(.4123908,.3575843,.1804808,.212639,.7151687,.0721923,.0193308,.1191948,.9505322),su=new Gt().set(3.2409699,-1.5373832,-.4986108,-.9692436,1.8759675,.0415551,.0556301,-.203977,1.0569715);function np(){const i={enabled:!0,workingColorSpace:Rr,spaces:{},convert:function(r,s,a){return this.enabled===!1||s===a||!s||!a||(this.spaces[s].transfer===re&&(r.r=Xn(r.r),r.g=Xn(r.g),r.b=Xn(r.b)),this.spaces[s].primaries!==this.spaces[a].primaries&&(r.applyMatrix3(this.spaces[s].toXYZ),r.applyMatrix3(this.spaces[a].fromXYZ)),this.spaces[a].transfer===re&&(r.r=Mr(r.r),r.g=Mr(r.g),r.b=Mr(r.b))),r},workingToColorSpace:function(r,s){return this.convert(r,this.workingColorSpace,s)},colorSpaceToWorking:function(r,s){return this.convert(r,s,this.workingColorSpace)},getPrimaries:function(r){return this.spaces[r].primaries},getTransfer:function(r){return r===ri?Fo:this.spaces[r].transfer},getLuminanceCoefficients:function(r,s=this.workingColorSpace){return r.fromArray(this.spaces[s].luminanceCoefficients)},define:function(r){Object.assign(this.spaces,r)},_getMatrix:function(r,s,a){return r.copy(this.spaces[s].toXYZ).multiply(this.spaces[a].fromXYZ)},_getDrawingBufferColorSpace:function(r){return this.spaces[r].outputColorSpaceConfig.drawingBufferColorSpace},_getUnpackColorSpace:function(r=this.workingColorSpace){return this.spaces[r].workingColorSpaceConfig.unpackColorSpace},fromWorkingColorSpace:function(r,s){return Sr("THREE.ColorManagement: .fromWorkingColorSpace() has been renamed to .workingToColorSpace()."),i.workingToColorSpace(r,s)},toWorkingColorSpace:function(r,s){return Sr("THREE.ColorManagement: .toWorkingColorSpace() has been renamed to .colorSpaceToWorking()."),i.colorSpaceToWorking(r,s)}},t=[.64,.33,.3,.6,.15,.06],e=[.2126,.7152,.0722],n=[.3127,.329];return i.define({[Rr]:{primaries:t,whitePoint:n,transfer:Fo,toXYZ:ru,fromXYZ:su,luminanceCoefficients:e,workingColorSpaceConfig:{unpackColorSpace:rn},outputColorSpaceConfig:{drawingBufferColorSpace:rn}},[rn]:{primaries:t,whitePoint:n,transfer:re,toXYZ:ru,fromXYZ:su,luminanceCoefficients:e,outputColorSpaceConfig:{drawingBufferColorSpace:rn}}}),i}const Jt=np();function Xn(i){return i<.04045?i*.0773993808:Math.pow(i*.9478672986+.0521327014,2.4)}function Mr(i){return i<.0031308?i*12.92:1.055*Math.pow(i,.41666)-.055}let ki;class ip{static getDataURL(t,e="image/png"){if(/^data:/i.test(t.src)||typeof HTMLCanvasElement>"u")return t.src;let n;if(t instanceof HTMLCanvasElement)n=t;else{ki===void 0&&(ki=Oo("canvas")),ki.width=t.width,ki.height=t.height;const r=ki.getContext("2d");t instanceof ImageData?r.putImageData(t,0,0):r.drawImage(t,0,0,t.width,t.height),n=ki}return n.toDataURL(e)}static sRGBToLinear(t){if(typeof HTMLImageElement<"u"&&t instanceof HTMLImageElement||typeof HTMLCanvasElement<"u"&&t instanceof HTMLCanvasElement||typeof ImageBitmap<"u"&&t instanceof ImageBitmap){const e=Oo("canvas");e.width=t.width,e.height=t.height;const n=e.getContext("2d");n.drawImage(t,0,0,t.width,t.height);const r=n.getImageData(0,0,t.width,t.height),s=r.data;for(let a=0;a<s.length;a++)s[a]=Xn(s[a]/255)*255;return n.putImageData(r,0,0),e}else if(t.data){const e=t.data.slice(0);for(let n=0;n<e.length;n++)e instanceof Uint8Array||e instanceof Uint8ClampedArray?e[n]=Math.floor(Xn(e[n]/255)*255):e[n]=Xn(e[n]);return{data:e,width:t.width,height:t.height}}else return console.warn("THREE.ImageUtils.sRGBToLinear(): Unsupported image type. No color space conversion applied."),t}}let rp=0;class Rl{constructor(t=null){this.isSource=!0,Object.defineProperty(this,"id",{value:rp++}),this.uuid=xs(),this.data=t,this.dataReady=!0,this.version=0}getSize(t){const e=this.data;return e instanceof HTMLVideoElement?t.set(e.videoWidth,e.videoHeight):e!==null?t.set(e.width,e.height,e.depth||0):t.set(0,0,0),t}set needsUpdate(t){t===!0&&this.version++}toJSON(t){const e=t===void 0||typeof t=="string";if(!e&&t.images[this.uuid]!==void 0)return t.images[this.uuid];const n={uuid:this.uuid,url:""},r=this.data;if(r!==null){let s;if(Array.isArray(r)){s=[];for(let a=0,o=r.length;a<o;a++)r[a].isDataTexture?s.push(sa(r[a].image)):s.push(sa(r[a]))}else s=sa(r);n.url=s}return e||(t.images[this.uuid]=n),n}}function sa(i){return typeof HTMLImageElement<"u"&&i instanceof HTMLImageElement||typeof HTMLCanvasElement<"u"&&i instanceof HTMLCanvasElement||typeof ImageBitmap<"u"&&i instanceof ImageBitmap?ip.getDataURL(i):i.data?{data:Array.from(i.data),width:i.width,height:i.height,type:i.data.constructor.name}:(console.warn("THREE.Texture: Unable to serialize Texture."),{})}let sp=0;const oa=new U;class Le extends Ir{constructor(t=Le.DEFAULT_IMAGE,e=Le.DEFAULT_MAPPING,n=Fi,r=Fi,s=bn,a=Bi,o=Ke,c=Ln,h=Le.DEFAULT_ANISOTROPY,f=ri){super(),this.isTexture=!0,Object.defineProperty(this,"id",{value:sp++}),this.uuid=xs(),this.name="",this.source=new Rl(t),this.mipmaps=[],this.mapping=e,this.channel=0,this.wrapS=n,this.wrapT=r,this.magFilter=s,this.minFilter=a,this.anisotropy=h,this.format=o,this.internalFormat=null,this.type=c,this.offset=new kt(0,0),this.repeat=new kt(1,1),this.center=new kt(0,0),this.rotation=0,this.matrixAutoUpdate=!0,this.matrix=new Gt,this.generateMipmaps=!0,this.premultiplyAlpha=!1,this.flipY=!0,this.unpackAlignment=4,this.colorSpace=f,this.userData={},this.updateRanges=[],this.version=0,this.onUpdate=null,this.renderTarget=null,this.isRenderTargetTexture=!1,this.isArrayTexture=!!(t&&t.depth&&t.depth>1),this.pmremVersion=0}get width(){return this.source.getSize(oa).x}get height(){return this.source.getSize(oa).y}get depth(){return this.source.getSize(oa).z}get image(){return this.source.data}set image(t=null){this.source.data=t}updateMatrix(){this.matrix.setUvTransform(this.offset.x,this.offset.y,this.repeat.x,this.repeat.y,this.rotation,this.center.x,this.center.y)}addUpdateRange(t,e){this.updateRanges.push({start:t,count:e})}clearUpdateRanges(){this.updateRanges.length=0}clone(){return new this.constructor().copy(this)}copy(t){return this.name=t.name,this.source=t.source,this.mipmaps=t.mipmaps.slice(0),this.mapping=t.mapping,this.channel=t.channel,this.wrapS=t.wrapS,this.wrapT=t.wrapT,this.magFilter=t.magFilter,this.minFilter=t.minFilter,this.anisotropy=t.anisotropy,this.format=t.format,this.internalFormat=t.internalFormat,this.type=t.type,this.offset.copy(t.offset),this.repeat.copy(t.repeat),this.center.copy(t.center),this.rotation=t.rotation,this.matrixAutoUpdate=t.matrixAutoUpdate,this.matrix.copy(t.matrix),this.generateMipmaps=t.generateMipmaps,this.premultiplyAlpha=t.premultiplyAlpha,this.flipY=t.flipY,this.unpackAlignment=t.unpackAlignment,this.colorSpace=t.colorSpace,this.renderTarget=t.renderTarget,this.isRenderTargetTexture=t.isRenderTargetTexture,this.isArrayTexture=t.isArrayTexture,this.userData=JSON.parse(JSON.stringify(t.userData)),this.needsUpdate=!0,this}setValues(t){for(const e in t){const n=t[e];if(n===void 0){console.warn(`THREE.Texture.setValues(): parameter '${e}' has value of undefined.`);continue}const r=this[e];if(r===void 0){console.warn(`THREE.Texture.setValues(): property '${e}' does not exist.`);continue}r&&n&&r.isVector2&&n.isVector2||r&&n&&r.isVector3&&n.isVector3||r&&n&&r.isMatrix3&&n.isMatrix3?r.copy(n):this[e]=n}}toJSON(t){const e=t===void 0||typeof t=="string";if(!e&&t.textures[this.uuid]!==void 0)return t.textures[this.uuid];const n={metadata:{version:4.7,type:"Texture",generator:"Texture.toJSON"},uuid:this.uuid,name:this.name,image:this.source.toJSON(t).uuid,mapping:this.mapping,channel:this.channel,repeat:[this.repeat.x,this.repeat.y],offset:[this.offset.x,this.offset.y],center:[this.center.x,this.center.y],rotation:this.rotation,wrap:[this.wrapS,this.wrapT],format:this.format,internalFormat:this.internalFormat,type:this.type,colorSpace:this.colorSpace,minFilter:this.minFilter,magFilter:this.magFilter,anisotropy:this.anisotropy,flipY:this.flipY,generateMipmaps:this.generateMipmaps,premultiplyAlpha:this.premultiplyAlpha,unpackAlignment:this.unpackAlignment};return Object.keys(this.userData).length>0&&(n.userData=this.userData),e||(t.textures[this.uuid]=n),n}dispose(){this.dispatchEvent({type:"dispose"})}transformUv(t){if(this.mapping!==tf)return t;if(t.applyMatrix3(this.matrix),t.x<0||t.x>1)switch(this.wrapS){case No:t.x=t.x-Math.floor(t.x);break;case Fi:t.x=t.x<0?0:1;break;case Nc:Math.abs(Math.floor(t.x)%2)===1?t.x=Math.ceil(t.x)-t.x:t.x=t.x-Math.floor(t.x);break}if(t.y<0||t.y>1)switch(this.wrapT){case No:t.y=t.y-Math.floor(t.y);break;case Fi:t.y=t.y<0?0:1;break;case Nc:Math.abs(Math.floor(t.y)%2)===1?t.y=Math.ceil(t.y)-t.y:t.y=t.y-Math.floor(t.y);break}return this.flipY&&(t.y=1-t.y),t}set needsUpdate(t){t===!0&&(this.version++,this.source.needsUpdate=!0)}set needsPMREMUpdate(t){t===!0&&this.pmremVersion++}}Le.DEFAULT_IMAGE=null;Le.DEFAULT_MAPPING=tf;Le.DEFAULT_ANISOTROPY=1;class ie{constructor(t=0,e=0,n=0,r=1){ie.prototype.isVector4=!0,this.x=t,this.y=e,this.z=n,this.w=r}get width(){return this.z}set width(t){this.z=t}get height(){return this.w}set height(t){this.w=t}set(t,e,n,r){return this.x=t,this.y=e,this.z=n,this.w=r,this}setScalar(t){return this.x=t,this.y=t,this.z=t,this.w=t,this}setX(t){return this.x=t,this}setY(t){return this.y=t,this}setZ(t){return this.z=t,this}setW(t){return this.w=t,this}setComponent(t,e){switch(t){case 0:this.x=e;break;case 1:this.y=e;break;case 2:this.z=e;break;case 3:this.w=e;break;default:throw new Error("index is out of range: "+t)}return this}getComponent(t){switch(t){case 0:return this.x;case 1:return this.y;case 2:return this.z;case 3:return this.w;default:throw new Error("index is out of range: "+t)}}clone(){return new this.constructor(this.x,this.y,this.z,this.w)}copy(t){return this.x=t.x,this.y=t.y,this.z=t.z,this.w=t.w!==void 0?t.w:1,this}add(t){return this.x+=t.x,this.y+=t.y,this.z+=t.z,this.w+=t.w,this}addScalar(t){return this.x+=t,this.y+=t,this.z+=t,this.w+=t,this}addVectors(t,e){return this.x=t.x+e.x,this.y=t.y+e.y,this.z=t.z+e.z,this.w=t.w+e.w,this}addScaledVector(t,e){return this.x+=t.x*e,this.y+=t.y*e,this.z+=t.z*e,this.w+=t.w*e,this}sub(t){return this.x-=t.x,this.y-=t.y,this.z-=t.z,this.w-=t.w,this}subScalar(t){return this.x-=t,this.y-=t,this.z-=t,this.w-=t,this}subVectors(t,e){return this.x=t.x-e.x,this.y=t.y-e.y,this.z=t.z-e.z,this.w=t.w-e.w,this}multiply(t){return this.x*=t.x,this.y*=t.y,this.z*=t.z,this.w*=t.w,this}multiplyScalar(t){return this.x*=t,this.y*=t,this.z*=t,this.w*=t,this}applyMatrix4(t){const e=this.x,n=this.y,r=this.z,s=this.w,a=t.elements;return this.x=a[0]*e+a[4]*n+a[8]*r+a[12]*s,this.y=a[1]*e+a[5]*n+a[9]*r+a[13]*s,this.z=a[2]*e+a[6]*n+a[10]*r+a[14]*s,this.w=a[3]*e+a[7]*n+a[11]*r+a[15]*s,this}divide(t){return this.x/=t.x,this.y/=t.y,this.z/=t.z,this.w/=t.w,this}divideScalar(t){return this.multiplyScalar(1/t)}setAxisAngleFromQuaternion(t){this.w=2*Math.acos(t.w);const e=Math.sqrt(1-t.w*t.w);return e<1e-4?(this.x=1,this.y=0,this.z=0):(this.x=t.x/e,this.y=t.y/e,this.z=t.z/e),this}setAxisAngleFromRotationMatrix(t){let e,n,r,s;const c=t.elements,h=c[0],f=c[4],g=c[8],p=c[1],_=c[5],M=c[9],b=c[2],x=c[6],m=c[10];if(Math.abs(f-p)<.01&&Math.abs(g-b)<.01&&Math.abs(M-x)<.01){if(Math.abs(f+p)<.1&&Math.abs(g+b)<.1&&Math.abs(M+x)<.1&&Math.abs(h+_+m-3)<.1)return this.set(1,0,0,0),this;e=Math.PI;const u=(h+1)/2,v=(_+1)/2,l=(m+1)/2,R=(f+p)/4,T=(g+b)/4,E=(M+x)/4;return u>v&&u>l?u<.01?(n=0,r=.707106781,s=.707106781):(n=Math.sqrt(u),r=R/n,s=T/n):v>l?v<.01?(n=.707106781,r=0,s=.707106781):(r=Math.sqrt(v),n=R/r,s=E/r):l<.01?(n=.707106781,r=.707106781,s=0):(s=Math.sqrt(l),n=T/s,r=E/s),this.set(n,r,s,e),this}let d=Math.sqrt((x-M)*(x-M)+(g-b)*(g-b)+(p-f)*(p-f));return Math.abs(d)<.001&&(d=1),this.x=(x-M)/d,this.y=(g-b)/d,this.z=(p-f)/d,this.w=Math.acos((h+_+m-1)/2),this}setFromMatrixPosition(t){const e=t.elements;return this.x=e[12],this.y=e[13],this.z=e[14],this.w=e[15],this}min(t){return this.x=Math.min(this.x,t.x),this.y=Math.min(this.y,t.y),this.z=Math.min(this.z,t.z),this.w=Math.min(this.w,t.w),this}max(t){return this.x=Math.max(this.x,t.x),this.y=Math.max(this.y,t.y),this.z=Math.max(this.z,t.z),this.w=Math.max(this.w,t.w),this}clamp(t,e){return this.x=Yt(this.x,t.x,e.x),this.y=Yt(this.y,t.y,e.y),this.z=Yt(this.z,t.z,e.z),this.w=Yt(this.w,t.w,e.w),this}clampScalar(t,e){return this.x=Yt(this.x,t,e),this.y=Yt(this.y,t,e),this.z=Yt(this.z,t,e),this.w=Yt(this.w,t,e),this}clampLength(t,e){const n=this.length();return this.divideScalar(n||1).multiplyScalar(Yt(n,t,e))}floor(){return this.x=Math.floor(this.x),this.y=Math.floor(this.y),this.z=Math.floor(this.z),this.w=Math.floor(this.w),this}ceil(){return this.x=Math.ceil(this.x),this.y=Math.ceil(this.y),this.z=Math.ceil(this.z),this.w=Math.ceil(this.w),this}round(){return this.x=Math.round(this.x),this.y=Math.round(this.y),this.z=Math.round(this.z),this.w=Math.round(this.w),this}roundToZero(){return this.x=Math.trunc(this.x),this.y=Math.trunc(this.y),this.z=Math.trunc(this.z),this.w=Math.trunc(this.w),this}negate(){return this.x=-this.x,this.y=-this.y,this.z=-this.z,this.w=-this.w,this}dot(t){return this.x*t.x+this.y*t.y+this.z*t.z+this.w*t.w}lengthSq(){return this.x*this.x+this.y*this.y+this.z*this.z+this.w*this.w}length(){return Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z+this.w*this.w)}manhattanLength(){return Math.abs(this.x)+Math.abs(this.y)+Math.abs(this.z)+Math.abs(this.w)}normalize(){return this.divideScalar(this.length()||1)}setLength(t){return this.normalize().multiplyScalar(t)}lerp(t,e){return this.x+=(t.x-this.x)*e,this.y+=(t.y-this.y)*e,this.z+=(t.z-this.z)*e,this.w+=(t.w-this.w)*e,this}lerpVectors(t,e,n){return this.x=t.x+(e.x-t.x)*n,this.y=t.y+(e.y-t.y)*n,this.z=t.z+(e.z-t.z)*n,this.w=t.w+(e.w-t.w)*n,this}equals(t){return t.x===this.x&&t.y===this.y&&t.z===this.z&&t.w===this.w}fromArray(t,e=0){return this.x=t[e],this.y=t[e+1],this.z=t[e+2],this.w=t[e+3],this}toArray(t=[],e=0){return t[e]=this.x,t[e+1]=this.y,t[e+2]=this.z,t[e+3]=this.w,t}fromBufferAttribute(t,e){return this.x=t.getX(e),this.y=t.getY(e),this.z=t.getZ(e),this.w=t.getW(e),this}random(){return this.x=Math.random(),this.y=Math.random(),this.z=Math.random(),this.w=Math.random(),this}*[Symbol.iterator](){yield this.x,yield this.y,yield this.z,yield this.w}}class op extends Ir{constructor(t=1,e=1,n={}){super(),n=Object.assign({generateMipmaps:!1,internalFormat:null,minFilter:bn,depthBuffer:!0,stencilBuffer:!1,resolveDepthBuffer:!0,resolveStencilBuffer:!0,depthTexture:null,samples:0,count:1,depth:1,multiview:!1},n),this.isRenderTarget=!0,this.width=t,this.height=e,this.depth=n.depth,this.scissor=new ie(0,0,t,e),this.scissorTest=!1,this.viewport=new ie(0,0,t,e);const r={width:t,height:e,depth:n.depth},s=new Le(r);this.textures=[];const a=n.count;for(let o=0;o<a;o++)this.textures[o]=s.clone(),this.textures[o].isRenderTargetTexture=!0,this.textures[o].renderTarget=this;this._setTextureOptions(n),this.depthBuffer=n.depthBuffer,this.stencilBuffer=n.stencilBuffer,this.resolveDepthBuffer=n.resolveDepthBuffer,this.resolveStencilBuffer=n.resolveStencilBuffer,this._depthTexture=null,this.depthTexture=n.depthTexture,this.samples=n.samples,this.multiview=n.multiview}_setTextureOptions(t={}){const e={minFilter:bn,generateMipmaps:!1,flipY:!1,internalFormat:null};t.mapping!==void 0&&(e.mapping=t.mapping),t.wrapS!==void 0&&(e.wrapS=t.wrapS),t.wrapT!==void 0&&(e.wrapT=t.wrapT),t.wrapR!==void 0&&(e.wrapR=t.wrapR),t.magFilter!==void 0&&(e.magFilter=t.magFilter),t.minFilter!==void 0&&(e.minFilter=t.minFilter),t.format!==void 0&&(e.format=t.format),t.type!==void 0&&(e.type=t.type),t.anisotropy!==void 0&&(e.anisotropy=t.anisotropy),t.colorSpace!==void 0&&(e.colorSpace=t.colorSpace),t.flipY!==void 0&&(e.flipY=t.flipY),t.generateMipmaps!==void 0&&(e.generateMipmaps=t.generateMipmaps),t.internalFormat!==void 0&&(e.internalFormat=t.internalFormat);for(let n=0;n<this.textures.length;n++)this.textures[n].setValues(e)}get texture(){return this.textures[0]}set texture(t){this.textures[0]=t}set depthTexture(t){this._depthTexture!==null&&(this._depthTexture.renderTarget=null),t!==null&&(t.renderTarget=this),this._depthTexture=t}get depthTexture(){return this._depthTexture}setSize(t,e,n=1){if(this.width!==t||this.height!==e||this.depth!==n){this.width=t,this.height=e,this.depth=n;for(let r=0,s=this.textures.length;r<s;r++)this.textures[r].image.width=t,this.textures[r].image.height=e,this.textures[r].image.depth=n,this.textures[r].isArrayTexture=this.textures[r].image.depth>1;this.dispose()}this.viewport.set(0,0,t,e),this.scissor.set(0,0,t,e)}clone(){return new this.constructor().copy(this)}copy(t){this.width=t.width,this.height=t.height,this.depth=t.depth,this.scissor.copy(t.scissor),this.scissorTest=t.scissorTest,this.viewport.copy(t.viewport),this.textures.length=0;for(let e=0,n=t.textures.length;e<n;e++){this.textures[e]=t.textures[e].clone(),this.textures[e].isRenderTargetTexture=!0,this.textures[e].renderTarget=this;const r=Object.assign({},t.textures[e].image);this.textures[e].source=new Rl(r)}return this.depthBuffer=t.depthBuffer,this.stencilBuffer=t.stencilBuffer,this.resolveDepthBuffer=t.resolveDepthBuffer,this.resolveStencilBuffer=t.resolveStencilBuffer,t.depthTexture!==null&&(this.depthTexture=t.depthTexture.clone()),this.samples=t.samples,this}dispose(){this.dispatchEvent({type:"dispose"})}}class Vi extends op{constructor(t=1,e=1,n={}){super(t,e,n),this.isWebGLRenderTarget=!0}}class df extends Le{constructor(t=null,e=1,n=1,r=1){super(null),this.isDataArrayTexture=!0,this.image={data:t,width:e,height:n,depth:r},this.magFilter=Je,this.minFilter=Je,this.wrapR=Fi,this.generateMipmaps=!1,this.flipY=!1,this.unpackAlignment=1,this.layerUpdates=new Set}addLayerUpdate(t){this.layerUpdates.add(t)}clearLayerUpdates(){this.layerUpdates.clear()}}class ap extends Le{constructor(t=null,e=1,n=1,r=1){super(null),this.isData3DTexture=!0,this.image={data:t,width:e,height:n,depth:r},this.magFilter=Je,this.minFilter=Je,this.wrapR=Fi,this.generateMipmaps=!1,this.flipY=!1,this.unpackAlignment=1}}class ye{constructor(t=new U(1/0,1/0,1/0),e=new U(-1/0,-1/0,-1/0)){this.isBox3=!0,this.min=t,this.max=e}set(t,e){return this.min.copy(t),this.max.copy(e),this}setFromArray(t){this.makeEmpty();for(let e=0,n=t.length;e<n;e+=3)this.expandByPoint(pn.fromArray(t,e));return this}setFromBufferAttribute(t){this.makeEmpty();for(let e=0,n=t.count;e<n;e++)this.expandByPoint(pn.fromBufferAttribute(t,e));return this}setFromPoints(t){this.makeEmpty();for(let e=0,n=t.length;e<n;e++)this.expandByPoint(t[e]);return this}setFromCenterAndSize(t,e){const n=pn.copy(e).multiplyScalar(.5);return this.min.copy(t).sub(n),this.max.copy(t).add(n),this}setFromObject(t,e=!1){return this.makeEmpty(),this.expandByObject(t,e)}clone(){return new this.constructor().copy(this)}copy(t){return this.min.copy(t.min),this.max.copy(t.max),this}makeEmpty(){return this.min.x=this.min.y=this.min.z=1/0,this.max.x=this.max.y=this.max.z=-1/0,this}isEmpty(){return this.max.x<this.min.x||this.max.y<this.min.y||this.max.z<this.min.z}getCenter(t){return this.isEmpty()?t.set(0,0,0):t.addVectors(this.min,this.max).multiplyScalar(.5)}getSize(t){return this.isEmpty()?t.set(0,0,0):t.subVectors(this.max,this.min)}expandByPoint(t){return this.min.min(t),this.max.max(t),this}expandByVector(t){return this.min.sub(t),this.max.add(t),this}expandByScalar(t){return this.min.addScalar(-t),this.max.addScalar(t),this}expandByObject(t,e=!1){t.updateWorldMatrix(!1,!1);const n=t.geometry;if(n!==void 0){const s=n.getAttribute("position");if(e===!0&&s!==void 0&&t.isInstancedMesh!==!0)for(let a=0,o=s.count;a<o;a++)t.isMesh===!0?t.getVertexPosition(a,pn):pn.fromBufferAttribute(s,a),pn.applyMatrix4(t.matrixWorld),this.expandByPoint(pn);else t.boundingBox!==void 0?(t.boundingBox===null&&t.computeBoundingBox(),As.copy(t.boundingBox)):(n.boundingBox===null&&n.computeBoundingBox(),As.copy(n.boundingBox)),As.applyMatrix4(t.matrixWorld),this.union(As)}const r=t.children;for(let s=0,a=r.length;s<a;s++)this.expandByObject(r[s],e);return this}containsPoint(t){return t.x>=this.min.x&&t.x<=this.max.x&&t.y>=this.min.y&&t.y<=this.max.y&&t.z>=this.min.z&&t.z<=this.max.z}containsBox(t){return this.min.x<=t.min.x&&t.max.x<=this.max.x&&this.min.y<=t.min.y&&t.max.y<=this.max.y&&this.min.z<=t.min.z&&t.max.z<=this.max.z}getParameter(t,e){return e.set((t.x-this.min.x)/(this.max.x-this.min.x),(t.y-this.min.y)/(this.max.y-this.min.y),(t.z-this.min.z)/(this.max.z-this.min.z))}intersectsBox(t){return t.max.x>=this.min.x&&t.min.x<=this.max.x&&t.max.y>=this.min.y&&t.min.y<=this.max.y&&t.max.z>=this.min.z&&t.min.z<=this.max.z}intersectsSphere(t){return this.clampPoint(t.center,pn),pn.distanceToSquared(t.center)<=t.radius*t.radius}intersectsPlane(t){let e,n;return t.normal.x>0?(e=t.normal.x*this.min.x,n=t.normal.x*this.max.x):(e=t.normal.x*this.max.x,n=t.normal.x*this.min.x),t.normal.y>0?(e+=t.normal.y*this.min.y,n+=t.normal.y*this.max.y):(e+=t.normal.y*this.max.y,n+=t.normal.y*this.min.y),t.normal.z>0?(e+=t.normal.z*this.min.z,n+=t.normal.z*this.max.z):(e+=t.normal.z*this.max.z,n+=t.normal.z*this.min.z),e<=-t.constant&&n>=-t.constant}intersectsTriangle(t){if(this.isEmpty())return!1;this.getCenter(Or),ws.subVectors(this.max,Or),Wi.subVectors(t.a,Or),Xi.subVectors(t.b,Or),qi.subVectors(t.c,Or),$n.subVectors(Xi,Wi),jn.subVectors(qi,Xi),xi.subVectors(Wi,qi);let e=[0,-$n.z,$n.y,0,-jn.z,jn.y,0,-xi.z,xi.y,$n.z,0,-$n.x,jn.z,0,-jn.x,xi.z,0,-xi.x,-$n.y,$n.x,0,-jn.y,jn.x,0,-xi.y,xi.x,0];return!aa(e,Wi,Xi,qi,ws)||(e=[1,0,0,0,1,0,0,0,1],!aa(e,Wi,Xi,qi,ws))?!1:(Rs.crossVectors($n,jn),e=[Rs.x,Rs.y,Rs.z],aa(e,Wi,Xi,qi,ws))}clampPoint(t,e){return e.copy(t).clamp(this.min,this.max)}distanceToPoint(t){return this.clampPoint(t,pn).distanceTo(t)}getBoundingSphere(t){return this.isEmpty()?t.makeEmpty():(this.getCenter(t.center),t.radius=this.getSize(pn).length()*.5),t}intersect(t){return this.min.max(t.min),this.max.min(t.max),this.isEmpty()&&this.makeEmpty(),this}union(t){return this.min.min(t.min),this.max.max(t.max),this}applyMatrix4(t){return this.isEmpty()?this:(Nn[0].set(this.min.x,this.min.y,this.min.z).applyMatrix4(t),Nn[1].set(this.min.x,this.min.y,this.max.z).applyMatrix4(t),Nn[2].set(this.min.x,this.max.y,this.min.z).applyMatrix4(t),Nn[3].set(this.min.x,this.max.y,this.max.z).applyMatrix4(t),Nn[4].set(this.max.x,this.min.y,this.min.z).applyMatrix4(t),Nn[5].set(this.max.x,this.min.y,this.max.z).applyMatrix4(t),Nn[6].set(this.max.x,this.max.y,this.min.z).applyMatrix4(t),Nn[7].set(this.max.x,this.max.y,this.max.z).applyMatrix4(t),this.setFromPoints(Nn),this)}translate(t){return this.min.add(t),this.max.add(t),this}equals(t){return t.min.equals(this.min)&&t.max.equals(this.max)}toJSON(){return{min:this.min.toArray(),max:this.max.toArray()}}fromJSON(t){return this.min.fromArray(t.min),this.max.fromArray(t.max),this}}const Nn=[new U,new U,new U,new U,new U,new U,new U,new U],pn=new U,As=new ye,Wi=new U,Xi=new U,qi=new U,$n=new U,jn=new U,xi=new U,Or=new U,ws=new U,Rs=new U,vi=new U;function aa(i,t,e,n,r){for(let s=0,a=i.length-3;s<=a;s+=3){vi.fromArray(i,s);const o=r.x*Math.abs(vi.x)+r.y*Math.abs(vi.y)+r.z*Math.abs(vi.z),c=t.dot(vi),h=e.dot(vi),f=n.dot(vi);if(Math.max(-Math.max(c,h,f),Math.min(c,h,f))>o)return!1}return!0}const cp=new ye,zr=new U,ca=new U;class Rn{constructor(t=new U,e=-1){this.isSphere=!0,this.center=t,this.radius=e}set(t,e){return this.center.copy(t),this.radius=e,this}setFromPoints(t,e){const n=this.center;e!==void 0?n.copy(e):cp.setFromPoints(t).getCenter(n);let r=0;for(let s=0,a=t.length;s<a;s++)r=Math.max(r,n.distanceToSquared(t[s]));return this.radius=Math.sqrt(r),this}copy(t){return this.center.copy(t.center),this.radius=t.radius,this}isEmpty(){return this.radius<0}makeEmpty(){return this.center.set(0,0,0),this.radius=-1,this}containsPoint(t){return t.distanceToSquared(this.center)<=this.radius*this.radius}distanceToPoint(t){return t.distanceTo(this.center)-this.radius}intersectsSphere(t){const e=this.radius+t.radius;return t.center.distanceToSquared(this.center)<=e*e}intersectsBox(t){return t.intersectsSphere(this)}intersectsPlane(t){return Math.abs(t.distanceToPoint(this.center))<=this.radius}clampPoint(t,e){const n=this.center.distanceToSquared(t);return e.copy(t),n>this.radius*this.radius&&(e.sub(this.center).normalize(),e.multiplyScalar(this.radius).add(this.center)),e}getBoundingBox(t){return this.isEmpty()?(t.makeEmpty(),t):(t.set(this.center,this.center),t.expandByScalar(this.radius),t)}applyMatrix4(t){return this.center.applyMatrix4(t),this.radius=this.radius*t.getMaxScaleOnAxis(),this}translate(t){return this.center.add(t),this}expandByPoint(t){if(this.isEmpty())return this.center.copy(t),this.radius=0,this;zr.subVectors(t,this.center);const e=zr.lengthSq();if(e>this.radius*this.radius){const n=Math.sqrt(e),r=(n-this.radius)*.5;this.center.addScaledVector(zr,r/n),this.radius+=r}return this}union(t){return t.isEmpty()?this:this.isEmpty()?(this.copy(t),this):(this.center.equals(t.center)===!0?this.radius=Math.max(this.radius,t.radius):(ca.subVectors(t.center,this.center).setLength(t.radius),this.expandByPoint(zr.copy(t.center).add(ca)),this.expandByPoint(zr.copy(t.center).sub(ca))),this)}equals(t){return t.center.equals(this.center)&&t.radius===this.radius}clone(){return new this.constructor().copy(this)}toJSON(){return{radius:this.radius,center:this.center.toArray()}}fromJSON(t){return this.radius=t.radius,this.center.fromArray(t.center),this}}const Fn=new U,la=new U,Cs=new U,Kn=new U,ua=new U,Ps=new U,ha=new U;class Lr{constructor(t=new U,e=new U(0,0,-1)){this.origin=t,this.direction=e}set(t,e){return this.origin.copy(t),this.direction.copy(e),this}copy(t){return this.origin.copy(t.origin),this.direction.copy(t.direction),this}at(t,e){return e.copy(this.origin).addScaledVector(this.direction,t)}lookAt(t){return this.direction.copy(t).sub(this.origin).normalize(),this}recast(t){return this.origin.copy(this.at(t,Fn)),this}closestPointToPoint(t,e){e.subVectors(t,this.origin);const n=e.dot(this.direction);return n<0?e.copy(this.origin):e.copy(this.origin).addScaledVector(this.direction,n)}distanceToPoint(t){return Math.sqrt(this.distanceSqToPoint(t))}distanceSqToPoint(t){const e=Fn.subVectors(t,this.origin).dot(this.direction);return e<0?this.origin.distanceToSquared(t):(Fn.copy(this.origin).addScaledVector(this.direction,e),Fn.distanceToSquared(t))}distanceSqToSegment(t,e,n,r){la.copy(t).add(e).multiplyScalar(.5),Cs.copy(e).sub(t).normalize(),Kn.copy(this.origin).sub(la);const s=t.distanceTo(e)*.5,a=-this.direction.dot(Cs),o=Kn.dot(this.direction),c=-Kn.dot(Cs),h=Kn.lengthSq(),f=Math.abs(1-a*a);let g,p,_,M;if(f>0)if(g=a*c-o,p=a*o-c,M=s*f,g>=0)if(p>=-M)if(p<=M){const b=1/f;g*=b,p*=b,_=g*(g+a*p+2*o)+p*(a*g+p+2*c)+h}else p=s,g=Math.max(0,-(a*p+o)),_=-g*g+p*(p+2*c)+h;else p=-s,g=Math.max(0,-(a*p+o)),_=-g*g+p*(p+2*c)+h;else p<=-M?(g=Math.max(0,-(-a*s+o)),p=g>0?-s:Math.min(Math.max(-s,-c),s),_=-g*g+p*(p+2*c)+h):p<=M?(g=0,p=Math.min(Math.max(-s,-c),s),_=p*(p+2*c)+h):(g=Math.max(0,-(a*s+o)),p=g>0?s:Math.min(Math.max(-s,-c),s),_=-g*g+p*(p+2*c)+h);else p=a>0?-s:s,g=Math.max(0,-(a*p+o)),_=-g*g+p*(p+2*c)+h;return n&&n.copy(this.origin).addScaledVector(this.direction,g),r&&r.copy(la).addScaledVector(Cs,p),_}intersectSphere(t,e){Fn.subVectors(t.center,this.origin);const n=Fn.dot(this.direction),r=Fn.dot(Fn)-n*n,s=t.radius*t.radius;if(r>s)return null;const a=Math.sqrt(s-r),o=n-a,c=n+a;return c<0?null:o<0?this.at(c,e):this.at(o,e)}intersectsSphere(t){return t.radius<0?!1:this.distanceSqToPoint(t.center)<=t.radius*t.radius}distanceToPlane(t){const e=t.normal.dot(this.direction);if(e===0)return t.distanceToPoint(this.origin)===0?0:null;const n=-(this.origin.dot(t.normal)+t.constant)/e;return n>=0?n:null}intersectPlane(t,e){const n=this.distanceToPlane(t);return n===null?null:this.at(n,e)}intersectsPlane(t){const e=t.distanceToPoint(this.origin);return e===0||t.normal.dot(this.direction)*e<0}intersectBox(t,e){let n,r,s,a,o,c;const h=1/this.direction.x,f=1/this.direction.y,g=1/this.direction.z,p=this.origin;return h>=0?(n=(t.min.x-p.x)*h,r=(t.max.x-p.x)*h):(n=(t.max.x-p.x)*h,r=(t.min.x-p.x)*h),f>=0?(s=(t.min.y-p.y)*f,a=(t.max.y-p.y)*f):(s=(t.max.y-p.y)*f,a=(t.min.y-p.y)*f),n>a||s>r||((s>n||isNaN(n))&&(n=s),(a<r||isNaN(r))&&(r=a),g>=0?(o=(t.min.z-p.z)*g,c=(t.max.z-p.z)*g):(o=(t.max.z-p.z)*g,c=(t.min.z-p.z)*g),n>c||o>r)||((o>n||n!==n)&&(n=o),(c<r||r!==r)&&(r=c),r<0)?null:this.at(n>=0?n:r,e)}intersectsBox(t){return this.intersectBox(t,Fn)!==null}intersectTriangle(t,e,n,r,s){ua.subVectors(e,t),Ps.subVectors(n,t),ha.crossVectors(ua,Ps);let a=this.direction.dot(ha),o;if(a>0){if(r)return null;o=1}else if(a<0)o=-1,a=-a;else return null;Kn.subVectors(this.origin,t);const c=o*this.direction.dot(Ps.crossVectors(Kn,Ps));if(c<0)return null;const h=o*this.direction.dot(ua.cross(Kn));if(h<0||c+h>a)return null;const f=-o*Kn.dot(ha);return f<0?null:this.at(f/a,s)}applyMatrix4(t){return this.origin.applyMatrix4(t),this.direction.transformDirection(t),this}equals(t){return t.origin.equals(this.origin)&&t.direction.equals(this.direction)}clone(){return new this.constructor().copy(this)}}class $t{constructor(t,e,n,r,s,a,o,c,h,f,g,p,_,M,b,x){$t.prototype.isMatrix4=!0,this.elements=[1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1],t!==void 0&&this.set(t,e,n,r,s,a,o,c,h,f,g,p,_,M,b,x)}set(t,e,n,r,s,a,o,c,h,f,g,p,_,M,b,x){const m=this.elements;return m[0]=t,m[4]=e,m[8]=n,m[12]=r,m[1]=s,m[5]=a,m[9]=o,m[13]=c,m[2]=h,m[6]=f,m[10]=g,m[14]=p,m[3]=_,m[7]=M,m[11]=b,m[15]=x,this}identity(){return this.set(1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1),this}clone(){return new $t().fromArray(this.elements)}copy(t){const e=this.elements,n=t.elements;return e[0]=n[0],e[1]=n[1],e[2]=n[2],e[3]=n[3],e[4]=n[4],e[5]=n[5],e[6]=n[6],e[7]=n[7],e[8]=n[8],e[9]=n[9],e[10]=n[10],e[11]=n[11],e[12]=n[12],e[13]=n[13],e[14]=n[14],e[15]=n[15],this}copyPosition(t){const e=this.elements,n=t.elements;return e[12]=n[12],e[13]=n[13],e[14]=n[14],this}setFromMatrix3(t){const e=t.elements;return this.set(e[0],e[3],e[6],0,e[1],e[4],e[7],0,e[2],e[5],e[8],0,0,0,0,1),this}extractBasis(t,e,n){return t.setFromMatrixColumn(this,0),e.setFromMatrixColumn(this,1),n.setFromMatrixColumn(this,2),this}makeBasis(t,e,n){return this.set(t.x,e.x,n.x,0,t.y,e.y,n.y,0,t.z,e.z,n.z,0,0,0,0,1),this}extractRotation(t){const e=this.elements,n=t.elements,r=1/Yi.setFromMatrixColumn(t,0).length(),s=1/Yi.setFromMatrixColumn(t,1).length(),a=1/Yi.setFromMatrixColumn(t,2).length();return e[0]=n[0]*r,e[1]=n[1]*r,e[2]=n[2]*r,e[3]=0,e[4]=n[4]*s,e[5]=n[5]*s,e[6]=n[6]*s,e[7]=0,e[8]=n[8]*a,e[9]=n[9]*a,e[10]=n[10]*a,e[11]=0,e[12]=0,e[13]=0,e[14]=0,e[15]=1,this}makeRotationFromEuler(t){const e=this.elements,n=t.x,r=t.y,s=t.z,a=Math.cos(n),o=Math.sin(n),c=Math.cos(r),h=Math.sin(r),f=Math.cos(s),g=Math.sin(s);if(t.order==="XYZ"){const p=a*f,_=a*g,M=o*f,b=o*g;e[0]=c*f,e[4]=-c*g,e[8]=h,e[1]=_+M*h,e[5]=p-b*h,e[9]=-o*c,e[2]=b-p*h,e[6]=M+_*h,e[10]=a*c}else if(t.order==="YXZ"){const p=c*f,_=c*g,M=h*f,b=h*g;e[0]=p+b*o,e[4]=M*o-_,e[8]=a*h,e[1]=a*g,e[5]=a*f,e[9]=-o,e[2]=_*o-M,e[6]=b+p*o,e[10]=a*c}else if(t.order==="ZXY"){const p=c*f,_=c*g,M=h*f,b=h*g;e[0]=p-b*o,e[4]=-a*g,e[8]=M+_*o,e[1]=_+M*o,e[5]=a*f,e[9]=b-p*o,e[2]=-a*h,e[6]=o,e[10]=a*c}else if(t.order==="ZYX"){const p=a*f,_=a*g,M=o*f,b=o*g;e[0]=c*f,e[4]=M*h-_,e[8]=p*h+b,e[1]=c*g,e[5]=b*h+p,e[9]=_*h-M,e[2]=-h,e[6]=o*c,e[10]=a*c}else if(t.order==="YZX"){const p=a*c,_=a*h,M=o*c,b=o*h;e[0]=c*f,e[4]=b-p*g,e[8]=M*g+_,e[1]=g,e[5]=a*f,e[9]=-o*f,e[2]=-h*f,e[6]=_*g+M,e[10]=p-b*g}else if(t.order==="XZY"){const p=a*c,_=a*h,M=o*c,b=o*h;e[0]=c*f,e[4]=-g,e[8]=h*f,e[1]=p*g+b,e[5]=a*f,e[9]=_*g-M,e[2]=M*g-_,e[6]=o*f,e[10]=b*g+p}return e[3]=0,e[7]=0,e[11]=0,e[12]=0,e[13]=0,e[14]=0,e[15]=1,this}makeRotationFromQuaternion(t){return this.compose(lp,t,up)}lookAt(t,e,n){const r=this.elements;return $e.subVectors(t,e),$e.lengthSq()===0&&($e.z=1),$e.normalize(),Zn.crossVectors(n,$e),Zn.lengthSq()===0&&(Math.abs(n.z)===1?$e.x+=1e-4:$e.z+=1e-4,$e.normalize(),Zn.crossVectors(n,$e)),Zn.normalize(),Is.crossVectors($e,Zn),r[0]=Zn.x,r[4]=Is.x,r[8]=$e.x,r[1]=Zn.y,r[5]=Is.y,r[9]=$e.y,r[2]=Zn.z,r[6]=Is.z,r[10]=$e.z,this}multiply(t){return this.multiplyMatrices(this,t)}premultiply(t){return this.multiplyMatrices(t,this)}multiplyMatrices(t,e){const n=t.elements,r=e.elements,s=this.elements,a=n[0],o=n[4],c=n[8],h=n[12],f=n[1],g=n[5],p=n[9],_=n[13],M=n[2],b=n[6],x=n[10],m=n[14],d=n[3],u=n[7],v=n[11],l=n[15],R=r[0],T=r[4],E=r[8],y=r[12],S=r[1],A=r[5],w=r[9],I=r[13],N=r[2],B=r[6],F=r[10],k=r[14],z=r[3],J=r[7],Z=r[11],it=r[15];return s[0]=a*R+o*S+c*N+h*z,s[4]=a*T+o*A+c*B+h*J,s[8]=a*E+o*w+c*F+h*Z,s[12]=a*y+o*I+c*k+h*it,s[1]=f*R+g*S+p*N+_*z,s[5]=f*T+g*A+p*B+_*J,s[9]=f*E+g*w+p*F+_*Z,s[13]=f*y+g*I+p*k+_*it,s[2]=M*R+b*S+x*N+m*z,s[6]=M*T+b*A+x*B+m*J,s[10]=M*E+b*w+x*F+m*Z,s[14]=M*y+b*I+x*k+m*it,s[3]=d*R+u*S+v*N+l*z,s[7]=d*T+u*A+v*B+l*J,s[11]=d*E+u*w+v*F+l*Z,s[15]=d*y+u*I+v*k+l*it,this}multiplyScalar(t){const e=this.elements;return e[0]*=t,e[4]*=t,e[8]*=t,e[12]*=t,e[1]*=t,e[5]*=t,e[9]*=t,e[13]*=t,e[2]*=t,e[6]*=t,e[10]*=t,e[14]*=t,e[3]*=t,e[7]*=t,e[11]*=t,e[15]*=t,this}determinant(){const t=this.elements,e=t[0],n=t[4],r=t[8],s=t[12],a=t[1],o=t[5],c=t[9],h=t[13],f=t[2],g=t[6],p=t[10],_=t[14],M=t[3],b=t[7],x=t[11],m=t[15];return M*(+s*c*g-r*h*g-s*o*p+n*h*p+r*o*_-n*c*_)+b*(+e*c*_-e*h*p+s*a*p-r*a*_+r*h*f-s*c*f)+x*(+e*h*g-e*o*_-s*a*g+n*a*_+s*o*f-n*h*f)+m*(-r*o*f-e*c*g+e*o*p+r*a*g-n*a*p+n*c*f)}transpose(){const t=this.elements;let e;return e=t[1],t[1]=t[4],t[4]=e,e=t[2],t[2]=t[8],t[8]=e,e=t[6],t[6]=t[9],t[9]=e,e=t[3],t[3]=t[12],t[12]=e,e=t[7],t[7]=t[13],t[13]=e,e=t[11],t[11]=t[14],t[14]=e,this}setPosition(t,e,n){const r=this.elements;return t.isVector3?(r[12]=t.x,r[13]=t.y,r[14]=t.z):(r[12]=t,r[13]=e,r[14]=n),this}invert(){const t=this.elements,e=t[0],n=t[1],r=t[2],s=t[3],a=t[4],o=t[5],c=t[6],h=t[7],f=t[8],g=t[9],p=t[10],_=t[11],M=t[12],b=t[13],x=t[14],m=t[15],d=g*x*h-b*p*h+b*c*_-o*x*_-g*c*m+o*p*m,u=M*p*h-f*x*h-M*c*_+a*x*_+f*c*m-a*p*m,v=f*b*h-M*g*h+M*o*_-a*b*_-f*o*m+a*g*m,l=M*g*c-f*b*c-M*o*p+a*b*p+f*o*x-a*g*x,R=e*d+n*u+r*v+s*l;if(R===0)return this.set(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);const T=1/R;return t[0]=d*T,t[1]=(b*p*s-g*x*s-b*r*_+n*x*_+g*r*m-n*p*m)*T,t[2]=(o*x*s-b*c*s+b*r*h-n*x*h-o*r*m+n*c*m)*T,t[3]=(g*c*s-o*p*s-g*r*h+n*p*h+o*r*_-n*c*_)*T,t[4]=u*T,t[5]=(f*x*s-M*p*s+M*r*_-e*x*_-f*r*m+e*p*m)*T,t[6]=(M*c*s-a*x*s-M*r*h+e*x*h+a*r*m-e*c*m)*T,t[7]=(a*p*s-f*c*s+f*r*h-e*p*h-a*r*_+e*c*_)*T,t[8]=v*T,t[9]=(M*g*s-f*b*s-M*n*_+e*b*_+f*n*m-e*g*m)*T,t[10]=(a*b*s-M*o*s+M*n*h-e*b*h-a*n*m+e*o*m)*T,t[11]=(f*o*s-a*g*s-f*n*h+e*g*h+a*n*_-e*o*_)*T,t[12]=l*T,t[13]=(f*b*r-M*g*r+M*n*p-e*b*p-f*n*x+e*g*x)*T,t[14]=(M*o*r-a*b*r-M*n*c+e*b*c+a*n*x-e*o*x)*T,t[15]=(a*g*r-f*o*r+f*n*c-e*g*c-a*n*p+e*o*p)*T,this}scale(t){const e=this.elements,n=t.x,r=t.y,s=t.z;return e[0]*=n,e[4]*=r,e[8]*=s,e[1]*=n,e[5]*=r,e[9]*=s,e[2]*=n,e[6]*=r,e[10]*=s,e[3]*=n,e[7]*=r,e[11]*=s,this}getMaxScaleOnAxis(){const t=this.elements,e=t[0]*t[0]+t[1]*t[1]+t[2]*t[2],n=t[4]*t[4]+t[5]*t[5]+t[6]*t[6],r=t[8]*t[8]+t[9]*t[9]+t[10]*t[10];return Math.sqrt(Math.max(e,n,r))}makeTranslation(t,e,n){return t.isVector3?this.set(1,0,0,t.x,0,1,0,t.y,0,0,1,t.z,0,0,0,1):this.set(1,0,0,t,0,1,0,e,0,0,1,n,0,0,0,1),this}makeRotationX(t){const e=Math.cos(t),n=Math.sin(t);return this.set(1,0,0,0,0,e,-n,0,0,n,e,0,0,0,0,1),this}makeRotationY(t){const e=Math.cos(t),n=Math.sin(t);return this.set(e,0,n,0,0,1,0,0,-n,0,e,0,0,0,0,1),this}makeRotationZ(t){const e=Math.cos(t),n=Math.sin(t);return this.set(e,-n,0,0,n,e,0,0,0,0,1,0,0,0,0,1),this}makeRotationAxis(t,e){const n=Math.cos(e),r=Math.sin(e),s=1-n,a=t.x,o=t.y,c=t.z,h=s*a,f=s*o;return this.set(h*a+n,h*o-r*c,h*c+r*o,0,h*o+r*c,f*o+n,f*c-r*a,0,h*c-r*o,f*c+r*a,s*c*c+n,0,0,0,0,1),this}makeScale(t,e,n){return this.set(t,0,0,0,0,e,0,0,0,0,n,0,0,0,0,1),this}makeShear(t,e,n,r,s,a){return this.set(1,n,s,0,t,1,a,0,e,r,1,0,0,0,0,1),this}compose(t,e,n){const r=this.elements,s=e._x,a=e._y,o=e._z,c=e._w,h=s+s,f=a+a,g=o+o,p=s*h,_=s*f,M=s*g,b=a*f,x=a*g,m=o*g,d=c*h,u=c*f,v=c*g,l=n.x,R=n.y,T=n.z;return r[0]=(1-(b+m))*l,r[1]=(_+v)*l,r[2]=(M-u)*l,r[3]=0,r[4]=(_-v)*R,r[5]=(1-(p+m))*R,r[6]=(x+d)*R,r[7]=0,r[8]=(M+u)*T,r[9]=(x-d)*T,r[10]=(1-(p+b))*T,r[11]=0,r[12]=t.x,r[13]=t.y,r[14]=t.z,r[15]=1,this}decompose(t,e,n){const r=this.elements;let s=Yi.set(r[0],r[1],r[2]).length();const a=Yi.set(r[4],r[5],r[6]).length(),o=Yi.set(r[8],r[9],r[10]).length();this.determinant()<0&&(s=-s),t.x=r[12],t.y=r[13],t.z=r[14],gn.copy(this);const h=1/s,f=1/a,g=1/o;return gn.elements[0]*=h,gn.elements[1]*=h,gn.elements[2]*=h,gn.elements[4]*=f,gn.elements[5]*=f,gn.elements[6]*=f,gn.elements[8]*=g,gn.elements[9]*=g,gn.elements[10]*=g,e.setFromRotationMatrix(gn),n.x=s,n.y=a,n.z=o,this}makePerspective(t,e,n,r,s,a,o=An){const c=this.elements,h=2*s/(e-t),f=2*s/(n-r),g=(e+t)/(e-t),p=(n+r)/(n-r);let _,M;if(o===An)_=-(a+s)/(a-s),M=-2*a*s/(a-s);else if(o===Bo)_=-a/(a-s),M=-a*s/(a-s);else throw new Error("THREE.Matrix4.makePerspective(): Invalid coordinate system: "+o);return c[0]=h,c[4]=0,c[8]=g,c[12]=0,c[1]=0,c[5]=f,c[9]=p,c[13]=0,c[2]=0,c[6]=0,c[10]=_,c[14]=M,c[3]=0,c[7]=0,c[11]=-1,c[15]=0,this}makeOrthographic(t,e,n,r,s,a,o=An){const c=this.elements,h=1/(e-t),f=1/(n-r),g=1/(a-s),p=(e+t)*h,_=(n+r)*f;let M,b;if(o===An)M=(a+s)*g,b=-2*g;else if(o===Bo)M=s*g,b=-1*g;else throw new Error("THREE.Matrix4.makeOrthographic(): Invalid coordinate system: "+o);return c[0]=2*h,c[4]=0,c[8]=0,c[12]=-p,c[1]=0,c[5]=2*f,c[9]=0,c[13]=-_,c[2]=0,c[6]=0,c[10]=b,c[14]=-M,c[3]=0,c[7]=0,c[11]=0,c[15]=1,this}equals(t){const e=this.elements,n=t.elements;for(let r=0;r<16;r++)if(e[r]!==n[r])return!1;return!0}fromArray(t,e=0){for(let n=0;n<16;n++)this.elements[n]=t[n+e];return this}toArray(t=[],e=0){const n=this.elements;return t[e]=n[0],t[e+1]=n[1],t[e+2]=n[2],t[e+3]=n[3],t[e+4]=n[4],t[e+5]=n[5],t[e+6]=n[6],t[e+7]=n[7],t[e+8]=n[8],t[e+9]=n[9],t[e+10]=n[10],t[e+11]=n[11],t[e+12]=n[12],t[e+13]=n[13],t[e+14]=n[14],t[e+15]=n[15],t}}const Yi=new U,gn=new $t,lp=new U(0,0,0),up=new U(1,1,1),Zn=new U,Is=new U,$e=new U,ou=new $t,au=new vs;class Dn{constructor(t=0,e=0,n=0,r=Dn.DEFAULT_ORDER){this.isEuler=!0,this._x=t,this._y=e,this._z=n,this._order=r}get x(){return this._x}set x(t){this._x=t,this._onChangeCallback()}get y(){return this._y}set y(t){this._y=t,this._onChangeCallback()}get z(){return this._z}set z(t){this._z=t,this._onChangeCallback()}get order(){return this._order}set order(t){this._order=t,this._onChangeCallback()}set(t,e,n,r=this._order){return this._x=t,this._y=e,this._z=n,this._order=r,this._onChangeCallback(),this}clone(){return new this.constructor(this._x,this._y,this._z,this._order)}copy(t){return this._x=t._x,this._y=t._y,this._z=t._z,this._order=t._order,this._onChangeCallback(),this}setFromRotationMatrix(t,e=this._order,n=!0){const r=t.elements,s=r[0],a=r[4],o=r[8],c=r[1],h=r[5],f=r[9],g=r[2],p=r[6],_=r[10];switch(e){case"XYZ":this._y=Math.asin(Yt(o,-1,1)),Math.abs(o)<.9999999?(this._x=Math.atan2(-f,_),this._z=Math.atan2(-a,s)):(this._x=Math.atan2(p,h),this._z=0);break;case"YXZ":this._x=Math.asin(-Yt(f,-1,1)),Math.abs(f)<.9999999?(this._y=Math.atan2(o,_),this._z=Math.atan2(c,h)):(this._y=Math.atan2(-g,s),this._z=0);break;case"ZXY":this._x=Math.asin(Yt(p,-1,1)),Math.abs(p)<.9999999?(this._y=Math.atan2(-g,_),this._z=Math.atan2(-a,h)):(this._y=0,this._z=Math.atan2(c,s));break;case"ZYX":this._y=Math.asin(-Yt(g,-1,1)),Math.abs(g)<.9999999?(this._x=Math.atan2(p,_),this._z=Math.atan2(c,s)):(this._x=0,this._z=Math.atan2(-a,h));break;case"YZX":this._z=Math.asin(Yt(c,-1,1)),Math.abs(c)<.9999999?(this._x=Math.atan2(-f,h),this._y=Math.atan2(-g,s)):(this._x=0,this._y=Math.atan2(o,_));break;case"XZY":this._z=Math.asin(-Yt(a,-1,1)),Math.abs(a)<.9999999?(this._x=Math.atan2(p,h),this._y=Math.atan2(o,s)):(this._x=Math.atan2(-f,_),this._y=0);break;default:console.warn("THREE.Euler: .setFromRotationMatrix() encountered an unknown order: "+e)}return this._order=e,n===!0&&this._onChangeCallback(),this}setFromQuaternion(t,e,n){return ou.makeRotationFromQuaternion(t),this.setFromRotationMatrix(ou,e,n)}setFromVector3(t,e=this._order){return this.set(t.x,t.y,t.z,e)}reorder(t){return au.setFromEuler(this),this.setFromQuaternion(au,t)}equals(t){return t._x===this._x&&t._y===this._y&&t._z===this._z&&t._order===this._order}fromArray(t){return this._x=t[0],this._y=t[1],this._z=t[2],t[3]!==void 0&&(this._order=t[3]),this._onChangeCallback(),this}toArray(t=[],e=0){return t[e]=this._x,t[e+1]=this._y,t[e+2]=this._z,t[e+3]=this._order,t}_onChange(t){return this._onChangeCallback=t,this}_onChangeCallback(){}*[Symbol.iterator](){yield this._x,yield this._y,yield this._z,yield this._order}}Dn.DEFAULT_ORDER="XYZ";class Cl{constructor(){this.mask=1}set(t){this.mask=(1<<t|0)>>>0}enable(t){this.mask|=1<<t|0}enableAll(){this.mask=-1}toggle(t){this.mask^=1<<t|0}disable(t){this.mask&=~(1<<t|0)}disableAll(){this.mask=0}test(t){return(this.mask&t.mask)!==0}isEnabled(t){return(this.mask&(1<<t|0))!==0}}let hp=0;const cu=new U,$i=new vs,Bn=new $t,Ls=new U,Vr=new U,fp=new U,dp=new vs,lu=new U(1,0,0),uu=new U(0,1,0),hu=new U(0,0,1),fu={type:"added"},pp={type:"removed"},ji={type:"childadded",child:null},fa={type:"childremoved",child:null};class we extends Ir{constructor(){super(),this.isObject3D=!0,Object.defineProperty(this,"id",{value:hp++}),this.uuid=xs(),this.name="",this.type="Object3D",this.parent=null,this.children=[],this.up=we.DEFAULT_UP.clone();const t=new U,e=new Dn,n=new vs,r=new U(1,1,1);function s(){n.setFromEuler(e,!1)}function a(){e.setFromQuaternion(n,void 0,!1)}e._onChange(s),n._onChange(a),Object.defineProperties(this,{position:{configurable:!0,enumerable:!0,value:t},rotation:{configurable:!0,enumerable:!0,value:e},quaternion:{configurable:!0,enumerable:!0,value:n},scale:{configurable:!0,enumerable:!0,value:r},modelViewMatrix:{value:new $t},normalMatrix:{value:new Gt}}),this.matrix=new $t,this.matrixWorld=new $t,this.matrixAutoUpdate=we.DEFAULT_MATRIX_AUTO_UPDATE,this.matrixWorldAutoUpdate=we.DEFAULT_MATRIX_WORLD_AUTO_UPDATE,this.matrixWorldNeedsUpdate=!1,this.layers=new Cl,this.visible=!0,this.castShadow=!1,this.receiveShadow=!1,this.frustumCulled=!0,this.renderOrder=0,this.animations=[],this.customDepthMaterial=void 0,this.customDistanceMaterial=void 0,this.userData={}}onBeforeShadow(){}onAfterShadow(){}onBeforeRender(){}onAfterRender(){}applyMatrix4(t){this.matrixAutoUpdate&&this.updateMatrix(),this.matrix.premultiply(t),this.matrix.decompose(this.position,this.quaternion,this.scale)}applyQuaternion(t){return this.quaternion.premultiply(t),this}setRotationFromAxisAngle(t,e){this.quaternion.setFromAxisAngle(t,e)}setRotationFromEuler(t){this.quaternion.setFromEuler(t,!0)}setRotationFromMatrix(t){this.quaternion.setFromRotationMatrix(t)}setRotationFromQuaternion(t){this.quaternion.copy(t)}rotateOnAxis(t,e){return $i.setFromAxisAngle(t,e),this.quaternion.multiply($i),this}rotateOnWorldAxis(t,e){return $i.setFromAxisAngle(t,e),this.quaternion.premultiply($i),this}rotateX(t){return this.rotateOnAxis(lu,t)}rotateY(t){return this.rotateOnAxis(uu,t)}rotateZ(t){return this.rotateOnAxis(hu,t)}translateOnAxis(t,e){return cu.copy(t).applyQuaternion(this.quaternion),this.position.add(cu.multiplyScalar(e)),this}translateX(t){return this.translateOnAxis(lu,t)}translateY(t){return this.translateOnAxis(uu,t)}translateZ(t){return this.translateOnAxis(hu,t)}localToWorld(t){return this.updateWorldMatrix(!0,!1),t.applyMatrix4(this.matrixWorld)}worldToLocal(t){return this.updateWorldMatrix(!0,!1),t.applyMatrix4(Bn.copy(this.matrixWorld).invert())}lookAt(t,e,n){t.isVector3?Ls.copy(t):Ls.set(t,e,n);const r=this.parent;this.updateWorldMatrix(!0,!1),Vr.setFromMatrixPosition(this.matrixWorld),this.isCamera||this.isLight?Bn.lookAt(Vr,Ls,this.up):Bn.lookAt(Ls,Vr,this.up),this.quaternion.setFromRotationMatrix(Bn),r&&(Bn.extractRotation(r.matrixWorld),$i.setFromRotationMatrix(Bn),this.quaternion.premultiply($i.invert()))}add(t){if(arguments.length>1){for(let e=0;e<arguments.length;e++)this.add(arguments[e]);return this}return t===this?(console.error("THREE.Object3D.add: object can't be added as a child of itself.",t),this):(t&&t.isObject3D?(t.removeFromParent(),t.parent=this,this.children.push(t),t.dispatchEvent(fu),ji.child=t,this.dispatchEvent(ji),ji.child=null):console.error("THREE.Object3D.add: object not an instance of THREE.Object3D.",t),this)}remove(t){if(arguments.length>1){for(let n=0;n<arguments.length;n++)this.remove(arguments[n]);return this}const e=this.children.indexOf(t);return e!==-1&&(t.parent=null,this.children.splice(e,1),t.dispatchEvent(pp),fa.child=t,this.dispatchEvent(fa),fa.child=null),this}removeFromParent(){const t=this.parent;return t!==null&&t.remove(this),this}clear(){return this.remove(...this.children)}attach(t){return this.updateWorldMatrix(!0,!1),Bn.copy(this.matrixWorld).invert(),t.parent!==null&&(t.parent.updateWorldMatrix(!0,!1),Bn.multiply(t.parent.matrixWorld)),t.applyMatrix4(Bn),t.removeFromParent(),t.parent=this,this.children.push(t),t.updateWorldMatrix(!1,!0),t.dispatchEvent(fu),ji.child=t,this.dispatchEvent(ji),ji.child=null,this}getObjectById(t){return this.getObjectByProperty("id",t)}getObjectByName(t){return this.getObjectByProperty("name",t)}getObjectByProperty(t,e){if(this[t]===e)return this;for(let n=0,r=this.children.length;n<r;n++){const a=this.children[n].getObjectByProperty(t,e);if(a!==void 0)return a}}getObjectsByProperty(t,e,n=[]){this[t]===e&&n.push(this);const r=this.children;for(let s=0,a=r.length;s<a;s++)r[s].getObjectsByProperty(t,e,n);return n}getWorldPosition(t){return this.updateWorldMatrix(!0,!1),t.setFromMatrixPosition(this.matrixWorld)}getWorldQuaternion(t){return this.updateWorldMatrix(!0,!1),this.matrixWorld.decompose(Vr,t,fp),t}getWorldScale(t){return this.updateWorldMatrix(!0,!1),this.matrixWorld.decompose(Vr,dp,t),t}getWorldDirection(t){this.updateWorldMatrix(!0,!1);const e=this.matrixWorld.elements;return t.set(e[8],e[9],e[10]).normalize()}raycast(){}traverse(t){t(this);const e=this.children;for(let n=0,r=e.length;n<r;n++)e[n].traverse(t)}traverseVisible(t){if(this.visible===!1)return;t(this);const e=this.children;for(let n=0,r=e.length;n<r;n++)e[n].traverseVisible(t)}traverseAncestors(t){const e=this.parent;e!==null&&(t(e),e.traverseAncestors(t))}updateMatrix(){this.matrix.compose(this.position,this.quaternion,this.scale),this.matrixWorldNeedsUpdate=!0}updateMatrixWorld(t){this.matrixAutoUpdate&&this.updateMatrix(),(this.matrixWorldNeedsUpdate||t)&&(this.matrixWorldAutoUpdate===!0&&(this.parent===null?this.matrixWorld.copy(this.matrix):this.matrixWorld.multiplyMatrices(this.parent.matrixWorld,this.matrix)),this.matrixWorldNeedsUpdate=!1,t=!0);const e=this.children;for(let n=0,r=e.length;n<r;n++)e[n].updateMatrixWorld(t)}updateWorldMatrix(t,e){const n=this.parent;if(t===!0&&n!==null&&n.updateWorldMatrix(!0,!1),this.matrixAutoUpdate&&this.updateMatrix(),this.matrixWorldAutoUpdate===!0&&(this.parent===null?this.matrixWorld.copy(this.matrix):this.matrixWorld.multiplyMatrices(this.parent.matrixWorld,this.matrix)),e===!0){const r=this.children;for(let s=0,a=r.length;s<a;s++)r[s].updateWorldMatrix(!1,!0)}}toJSON(t){const e=t===void 0||typeof t=="string",n={};e&&(t={geometries:{},materials:{},textures:{},images:{},shapes:{},skeletons:{},animations:{},nodes:{}},n.metadata={version:4.7,type:"Object",generator:"Object3D.toJSON"});const r={};r.uuid=this.uuid,r.type=this.type,this.name!==""&&(r.name=this.name),this.castShadow===!0&&(r.castShadow=!0),this.receiveShadow===!0&&(r.receiveShadow=!0),this.visible===!1&&(r.visible=!1),this.frustumCulled===!1&&(r.frustumCulled=!1),this.renderOrder!==0&&(r.renderOrder=this.renderOrder),Object.keys(this.userData).length>0&&(r.userData=this.userData),r.layers=this.layers.mask,r.matrix=this.matrix.toArray(),r.up=this.up.toArray(),this.matrixAutoUpdate===!1&&(r.matrixAutoUpdate=!1),this.isInstancedMesh&&(r.type="InstancedMesh",r.count=this.count,r.instanceMatrix=this.instanceMatrix.toJSON(),this.instanceColor!==null&&(r.instanceColor=this.instanceColor.toJSON())),this.isBatchedMesh&&(r.type="BatchedMesh",r.perObjectFrustumCulled=this.perObjectFrustumCulled,r.sortObjects=this.sortObjects,r.drawRanges=this._drawRanges,r.reservedRanges=this._reservedRanges,r.geometryInfo=this._geometryInfo.map(o=>({...o,boundingBox:o.boundingBox?o.boundingBox.toJSON():void 0,boundingSphere:o.boundingSphere?o.boundingSphere.toJSON():void 0})),r.instanceInfo=this._instanceInfo.map(o=>({...o})),r.availableInstanceIds=this._availableInstanceIds.slice(),r.availableGeometryIds=this._availableGeometryIds.slice(),r.nextIndexStart=this._nextIndexStart,r.nextVertexStart=this._nextVertexStart,r.geometryCount=this._geometryCount,r.maxInstanceCount=this._maxInstanceCount,r.maxVertexCount=this._maxVertexCount,r.maxIndexCount=this._maxIndexCount,r.geometryInitialized=this._geometryInitialized,r.matricesTexture=this._matricesTexture.toJSON(t),r.indirectTexture=this._indirectTexture.toJSON(t),this._colorsTexture!==null&&(r.colorsTexture=this._colorsTexture.toJSON(t)),this.boundingSphere!==null&&(r.boundingSphere=this.boundingSphere.toJSON()),this.boundingBox!==null&&(r.boundingBox=this.boundingBox.toJSON()));function s(o,c){return o[c.uuid]===void 0&&(o[c.uuid]=c.toJSON(t)),c.uuid}if(this.isScene)this.background&&(this.background.isColor?r.background=this.background.toJSON():this.background.isTexture&&(r.background=this.background.toJSON(t).uuid)),this.environment&&this.environment.isTexture&&this.environment.isRenderTargetTexture!==!0&&(r.environment=this.environment.toJSON(t).uuid);else if(this.isMesh||this.isLine||this.isPoints){r.geometry=s(t.geometries,this.geometry);const o=this.geometry.parameters;if(o!==void 0&&o.shapes!==void 0){const c=o.shapes;if(Array.isArray(c))for(let h=0,f=c.length;h<f;h++){const g=c[h];s(t.shapes,g)}else s(t.shapes,c)}}if(this.isSkinnedMesh&&(r.bindMode=this.bindMode,r.bindMatrix=this.bindMatrix.toArray(),this.skeleton!==void 0&&(s(t.skeletons,this.skeleton),r.skeleton=this.skeleton.uuid)),this.material!==void 0)if(Array.isArray(this.material)){const o=[];for(let c=0,h=this.material.length;c<h;c++)o.push(s(t.materials,this.material[c]));r.material=o}else r.material=s(t.materials,this.material);if(this.children.length>0){r.children=[];for(let o=0;o<this.children.length;o++)r.children.push(this.children[o].toJSON(t).object)}if(this.animations.length>0){r.animations=[];for(let o=0;o<this.animations.length;o++){const c=this.animations[o];r.animations.push(s(t.animations,c))}}if(e){const o=a(t.geometries),c=a(t.materials),h=a(t.textures),f=a(t.images),g=a(t.shapes),p=a(t.skeletons),_=a(t.animations),M=a(t.nodes);o.length>0&&(n.geometries=o),c.length>0&&(n.materials=c),h.length>0&&(n.textures=h),f.length>0&&(n.images=f),g.length>0&&(n.shapes=g),p.length>0&&(n.skeletons=p),_.length>0&&(n.animations=_),M.length>0&&(n.nodes=M)}return n.object=r,n;function a(o){const c=[];for(const h in o){const f=o[h];delete f.metadata,c.push(f)}return c}}clone(t){return new this.constructor().copy(this,t)}copy(t,e=!0){if(this.name=t.name,this.up.copy(t.up),this.position.copy(t.position),this.rotation.order=t.rotation.order,this.quaternion.copy(t.quaternion),this.scale.copy(t.scale),this.matrix.copy(t.matrix),this.matrixWorld.copy(t.matrixWorld),this.matrixAutoUpdate=t.matrixAutoUpdate,this.matrixWorldAutoUpdate=t.matrixWorldAutoUpdate,this.matrixWorldNeedsUpdate=t.matrixWorldNeedsUpdate,this.layers.mask=t.layers.mask,this.visible=t.visible,this.castShadow=t.castShadow,this.receiveShadow=t.receiveShadow,this.frustumCulled=t.frustumCulled,this.renderOrder=t.renderOrder,this.animations=t.animations.slice(),this.userData=JSON.parse(JSON.stringify(t.userData)),e===!0)for(let n=0;n<t.children.length;n++){const r=t.children[n];this.add(r.clone())}return this}}we.DEFAULT_UP=new U(0,1,0);we.DEFAULT_MATRIX_AUTO_UPDATE=!0;we.DEFAULT_MATRIX_WORLD_AUTO_UPDATE=!0;const mn=new U,On=new U,da=new U,zn=new U,Ki=new U,Zi=new U,du=new U,pa=new U,ga=new U,ma=new U,_a=new ie,xa=new ie,va=new ie;let ve=class dr{constructor(t=new U,e=new U,n=new U){this.a=t,this.b=e,this.c=n}static getNormal(t,e,n,r){r.subVectors(n,e),mn.subVectors(t,e),r.cross(mn);const s=r.lengthSq();return s>0?r.multiplyScalar(1/Math.sqrt(s)):r.set(0,0,0)}static getBarycoord(t,e,n,r,s){mn.subVectors(r,e),On.subVectors(n,e),da.subVectors(t,e);const a=mn.dot(mn),o=mn.dot(On),c=mn.dot(da),h=On.dot(On),f=On.dot(da),g=a*h-o*o;if(g===0)return s.set(0,0,0),null;const p=1/g,_=(h*c-o*f)*p,M=(a*f-o*c)*p;return s.set(1-_-M,M,_)}static containsPoint(t,e,n,r){return this.getBarycoord(t,e,n,r,zn)===null?!1:zn.x>=0&&zn.y>=0&&zn.x+zn.y<=1}static getInterpolation(t,e,n,r,s,a,o,c){return this.getBarycoord(t,e,n,r,zn)===null?(c.x=0,c.y=0,"z"in c&&(c.z=0),"w"in c&&(c.w=0),null):(c.setScalar(0),c.addScaledVector(s,zn.x),c.addScaledVector(a,zn.y),c.addScaledVector(o,zn.z),c)}static getInterpolatedAttribute(t,e,n,r,s,a){return _a.setScalar(0),xa.setScalar(0),va.setScalar(0),_a.fromBufferAttribute(t,e),xa.fromBufferAttribute(t,n),va.fromBufferAttribute(t,r),a.setScalar(0),a.addScaledVector(_a,s.x),a.addScaledVector(xa,s.y),a.addScaledVector(va,s.z),a}static isFrontFacing(t,e,n,r){return mn.subVectors(n,e),On.subVectors(t,e),mn.cross(On).dot(r)<0}set(t,e,n){return this.a.copy(t),this.b.copy(e),this.c.copy(n),this}setFromPointsAndIndices(t,e,n,r){return this.a.copy(t[e]),this.b.copy(t[n]),this.c.copy(t[r]),this}setFromAttributeAndIndices(t,e,n,r){return this.a.fromBufferAttribute(t,e),this.b.fromBufferAttribute(t,n),this.c.fromBufferAttribute(t,r),this}clone(){return new this.constructor().copy(this)}copy(t){return this.a.copy(t.a),this.b.copy(t.b),this.c.copy(t.c),this}getArea(){return mn.subVectors(this.c,this.b),On.subVectors(this.a,this.b),mn.cross(On).length()*.5}getMidpoint(t){return t.addVectors(this.a,this.b).add(this.c).multiplyScalar(1/3)}getNormal(t){return dr.getNormal(this.a,this.b,this.c,t)}getPlane(t){return t.setFromCoplanarPoints(this.a,this.b,this.c)}getBarycoord(t,e){return dr.getBarycoord(t,this.a,this.b,this.c,e)}getInterpolation(t,e,n,r,s){return dr.getInterpolation(t,this.a,this.b,this.c,e,n,r,s)}containsPoint(t){return dr.containsPoint(t,this.a,this.b,this.c)}isFrontFacing(t){return dr.isFrontFacing(this.a,this.b,this.c,t)}intersectsBox(t){return t.intersectsTriangle(this)}closestPointToPoint(t,e){const n=this.a,r=this.b,s=this.c;let a,o;Ki.subVectors(r,n),Zi.subVectors(s,n),pa.subVectors(t,n);const c=Ki.dot(pa),h=Zi.dot(pa);if(c<=0&&h<=0)return e.copy(n);ga.subVectors(t,r);const f=Ki.dot(ga),g=Zi.dot(ga);if(f>=0&&g<=f)return e.copy(r);const p=c*g-f*h;if(p<=0&&c>=0&&f<=0)return a=c/(c-f),e.copy(n).addScaledVector(Ki,a);ma.subVectors(t,s);const _=Ki.dot(ma),M=Zi.dot(ma);if(M>=0&&_<=M)return e.copy(s);const b=_*h-c*M;if(b<=0&&h>=0&&M<=0)return o=h/(h-M),e.copy(n).addScaledVector(Zi,o);const x=f*M-_*g;if(x<=0&&g-f>=0&&_-M>=0)return du.subVectors(s,r),o=(g-f)/(g-f+(_-M)),e.copy(r).addScaledVector(du,o);const m=1/(x+b+p);return a=b*m,o=p*m,e.copy(n).addScaledVector(Ki,a).addScaledVector(Zi,o)}equals(t){return t.a.equals(this.a)&&t.b.equals(this.b)&&t.c.equals(this.c)}};const pf={aliceblue:15792383,antiquewhite:16444375,aqua:65535,aquamarine:8388564,azure:15794175,beige:16119260,bisque:16770244,black:0,blanchedalmond:16772045,blue:255,blueviolet:9055202,brown:10824234,burlywood:14596231,cadetblue:6266528,chartreuse:8388352,chocolate:13789470,coral:16744272,cornflowerblue:6591981,cornsilk:16775388,crimson:14423100,cyan:65535,darkblue:139,darkcyan:35723,darkgoldenrod:12092939,darkgray:11119017,darkgreen:25600,darkgrey:11119017,darkkhaki:12433259,darkmagenta:9109643,darkolivegreen:5597999,darkorange:16747520,darkorchid:10040012,darkred:9109504,darksalmon:15308410,darkseagreen:9419919,darkslateblue:4734347,darkslategray:3100495,darkslategrey:3100495,darkturquoise:52945,darkviolet:9699539,deeppink:16716947,deepskyblue:49151,dimgray:6908265,dimgrey:6908265,dodgerblue:2003199,firebrick:11674146,floralwhite:16775920,forestgreen:2263842,fuchsia:16711935,gainsboro:14474460,ghostwhite:16316671,gold:16766720,goldenrod:14329120,gray:8421504,green:32768,greenyellow:11403055,grey:8421504,honeydew:15794160,hotpink:16738740,indianred:13458524,indigo:4915330,ivory:16777200,khaki:15787660,lavender:15132410,lavenderblush:16773365,lawngreen:8190976,lemonchiffon:16775885,lightblue:11393254,lightcoral:15761536,lightcyan:14745599,lightgoldenrodyellow:16448210,lightgray:13882323,lightgreen:9498256,lightgrey:13882323,lightpink:16758465,lightsalmon:16752762,lightseagreen:2142890,lightskyblue:8900346,lightslategray:7833753,lightslategrey:7833753,lightsteelblue:11584734,lightyellow:16777184,lime:65280,limegreen:3329330,linen:16445670,magenta:16711935,maroon:8388608,mediumaquamarine:6737322,mediumblue:205,mediumorchid:12211667,mediumpurple:9662683,mediumseagreen:3978097,mediumslateblue:8087790,mediumspringgreen:64154,mediumturquoise:4772300,mediumvioletred:13047173,midnightblue:1644912,mintcream:16121850,mistyrose:16770273,moccasin:16770229,navajowhite:16768685,navy:128,oldlace:16643558,olive:8421376,olivedrab:7048739,orange:16753920,orangered:16729344,orchid:14315734,palegoldenrod:15657130,palegreen:10025880,paleturquoise:11529966,palevioletred:14381203,papayawhip:16773077,peachpuff:16767673,peru:13468991,pink:16761035,plum:14524637,powderblue:11591910,purple:8388736,rebeccapurple:6697881,red:16711680,rosybrown:12357519,royalblue:4286945,saddlebrown:9127187,salmon:16416882,sandybrown:16032864,seagreen:3050327,seashell:16774638,sienna:10506797,silver:12632256,skyblue:8900331,slateblue:6970061,slategray:7372944,slategrey:7372944,snow:16775930,springgreen:65407,steelblue:4620980,tan:13808780,teal:32896,thistle:14204888,tomato:16737095,turquoise:4251856,violet:15631086,wheat:16113331,white:16777215,whitesmoke:16119285,yellow:16776960,yellowgreen:10145074},Jn={h:0,s:0,l:0},Ds={h:0,s:0,l:0};function ya(i,t,e){return e<0&&(e+=1),e>1&&(e-=1),e<1/6?i+(t-i)*6*e:e<1/2?t:e<2/3?i+(t-i)*6*(2/3-e):i}class qt{constructor(t,e,n){return this.isColor=!0,this.r=1,this.g=1,this.b=1,this.set(t,e,n)}set(t,e,n){if(e===void 0&&n===void 0){const r=t;r&&r.isColor?this.copy(r):typeof r=="number"?this.setHex(r):typeof r=="string"&&this.setStyle(r)}else this.setRGB(t,e,n);return this}setScalar(t){return this.r=t,this.g=t,this.b=t,this}setHex(t,e=rn){return t=Math.floor(t),this.r=(t>>16&255)/255,this.g=(t>>8&255)/255,this.b=(t&255)/255,Jt.colorSpaceToWorking(this,e),this}setRGB(t,e,n,r=Jt.workingColorSpace){return this.r=t,this.g=e,this.b=n,Jt.colorSpaceToWorking(this,r),this}setHSL(t,e,n,r=Jt.workingColorSpace){if(t=Zd(t,1),e=Yt(e,0,1),n=Yt(n,0,1),e===0)this.r=this.g=this.b=n;else{const s=n<=.5?n*(1+e):n+e-n*e,a=2*n-s;this.r=ya(a,s,t+1/3),this.g=ya(a,s,t),this.b=ya(a,s,t-1/3)}return Jt.colorSpaceToWorking(this,r),this}setStyle(t,e=rn){function n(s){s!==void 0&&parseFloat(s)<1&&console.warn("THREE.Color: Alpha component of "+t+" will be ignored.")}let r;if(r=/^(\w+)\(([^\)]*)\)/.exec(t)){let s;const a=r[1],o=r[2];switch(a){case"rgb":case"rgba":if(s=/^\s*(\d+)\s*,\s*(\d+)\s*,\s*(\d+)\s*(?:,\s*(\d*\.?\d+)\s*)?$/.exec(o))return n(s[4]),this.setRGB(Math.min(255,parseInt(s[1],10))/255,Math.min(255,parseInt(s[2],10))/255,Math.min(255,parseInt(s[3],10))/255,e);if(s=/^\s*(\d+)\%\s*,\s*(\d+)\%\s*,\s*(\d+)\%\s*(?:,\s*(\d*\.?\d+)\s*)?$/.exec(o))return n(s[4]),this.setRGB(Math.min(100,parseInt(s[1],10))/100,Math.min(100,parseInt(s[2],10))/100,Math.min(100,parseInt(s[3],10))/100,e);break;case"hsl":case"hsla":if(s=/^\s*(\d*\.?\d+)\s*,\s*(\d*\.?\d+)\%\s*,\s*(\d*\.?\d+)\%\s*(?:,\s*(\d*\.?\d+)\s*)?$/.exec(o))return n(s[4]),this.setHSL(parseFloat(s[1])/360,parseFloat(s[2])/100,parseFloat(s[3])/100,e);break;default:console.warn("THREE.Color: Unknown color model "+t)}}else if(r=/^\#([A-Fa-f\d]+)$/.exec(t)){const s=r[1],a=s.length;if(a===3)return this.setRGB(parseInt(s.charAt(0),16)/15,parseInt(s.charAt(1),16)/15,parseInt(s.charAt(2),16)/15,e);if(a===6)return this.setHex(parseInt(s,16),e);console.warn("THREE.Color: Invalid hex color "+t)}else if(t&&t.length>0)return this.setColorName(t,e);return this}setColorName(t,e=rn){const n=pf[t.toLowerCase()];return n!==void 0?this.setHex(n,e):console.warn("THREE.Color: Unknown color "+t),this}clone(){return new this.constructor(this.r,this.g,this.b)}copy(t){return this.r=t.r,this.g=t.g,this.b=t.b,this}copySRGBToLinear(t){return this.r=Xn(t.r),this.g=Xn(t.g),this.b=Xn(t.b),this}copyLinearToSRGB(t){return this.r=Mr(t.r),this.g=Mr(t.g),this.b=Mr(t.b),this}convertSRGBToLinear(){return this.copySRGBToLinear(this),this}convertLinearToSRGB(){return this.copyLinearToSRGB(this),this}getHex(t=rn){return Jt.workingToColorSpace(Ce.copy(this),t),Math.round(Yt(Ce.r*255,0,255))*65536+Math.round(Yt(Ce.g*255,0,255))*256+Math.round(Yt(Ce.b*255,0,255))}getHexString(t=rn){return("000000"+this.getHex(t).toString(16)).slice(-6)}getHSL(t,e=Jt.workingColorSpace){Jt.workingToColorSpace(Ce.copy(this),e);const n=Ce.r,r=Ce.g,s=Ce.b,a=Math.max(n,r,s),o=Math.min(n,r,s);let c,h;const f=(o+a)/2;if(o===a)c=0,h=0;else{const g=a-o;switch(h=f<=.5?g/(a+o):g/(2-a-o),a){case n:c=(r-s)/g+(r<s?6:0);break;case r:c=(s-n)/g+2;break;case s:c=(n-r)/g+4;break}c/=6}return t.h=c,t.s=h,t.l=f,t}getRGB(t,e=Jt.workingColorSpace){return Jt.workingToColorSpace(Ce.copy(this),e),t.r=Ce.r,t.g=Ce.g,t.b=Ce.b,t}getStyle(t=rn){Jt.workingToColorSpace(Ce.copy(this),t);const e=Ce.r,n=Ce.g,r=Ce.b;return t!==rn?`color(${t} ${e.toFixed(3)} ${n.toFixed(3)} ${r.toFixed(3)})`:`rgb(${Math.round(e*255)},${Math.round(n*255)},${Math.round(r*255)})`}offsetHSL(t,e,n){return this.getHSL(Jn),this.setHSL(Jn.h+t,Jn.s+e,Jn.l+n)}add(t){return this.r+=t.r,this.g+=t.g,this.b+=t.b,this}addColors(t,e){return this.r=t.r+e.r,this.g=t.g+e.g,this.b=t.b+e.b,this}addScalar(t){return this.r+=t,this.g+=t,this.b+=t,this}sub(t){return this.r=Math.max(0,this.r-t.r),this.g=Math.max(0,this.g-t.g),this.b=Math.max(0,this.b-t.b),this}multiply(t){return this.r*=t.r,this.g*=t.g,this.b*=t.b,this}multiplyScalar(t){return this.r*=t,this.g*=t,this.b*=t,this}lerp(t,e){return this.r+=(t.r-this.r)*e,this.g+=(t.g-this.g)*e,this.b+=(t.b-this.b)*e,this}lerpColors(t,e,n){return this.r=t.r+(e.r-t.r)*n,this.g=t.g+(e.g-t.g)*n,this.b=t.b+(e.b-t.b)*n,this}lerpHSL(t,e){this.getHSL(Jn),t.getHSL(Ds);const n=na(Jn.h,Ds.h,e),r=na(Jn.s,Ds.s,e),s=na(Jn.l,Ds.l,e);return this.setHSL(n,r,s),this}setFromVector3(t){return this.r=t.x,this.g=t.y,this.b=t.z,this}applyMatrix3(t){const e=this.r,n=this.g,r=this.b,s=t.elements;return this.r=s[0]*e+s[3]*n+s[6]*r,this.g=s[1]*e+s[4]*n+s[7]*r,this.b=s[2]*e+s[5]*n+s[8]*r,this}equals(t){return t.r===this.r&&t.g===this.g&&t.b===this.b}fromArray(t,e=0){return this.r=t[e],this.g=t[e+1],this.b=t[e+2],this}toArray(t=[],e=0){return t[e]=this.r,t[e+1]=this.g,t[e+2]=this.b,t}fromBufferAttribute(t,e){return this.r=t.getX(e),this.g=t.getY(e),this.b=t.getZ(e),this}toJSON(){return this.getHex()}*[Symbol.iterator](){yield this.r,yield this.g,yield this.b}}const Ce=new qt;qt.NAMES=pf;let gp=0;class Dr extends Ir{constructor(){super(),this.isMaterial=!0,Object.defineProperty(this,"id",{value:gp++}),this.uuid=xs(),this.name="",this.type="Material",this.blending=yr,this.side=In,this.vertexColors=!1,this.opacity=1,this.transparent=!1,this.alphaHash=!1,this.blendSrc=Tc,this.blendDst=bc,this.blendEquation=Li,this.blendSrcAlpha=null,this.blendDstAlpha=null,this.blendEquationAlpha=null,this.blendColor=new qt(0,0,0),this.blendAlpha=0,this.depthFunc=br,this.depthTest=!0,this.depthWrite=!0,this.stencilWriteMask=255,this.stencilFunc=Ql,this.stencilRef=0,this.stencilFuncMask=255,this.stencilFail=Gi,this.stencilZFail=Gi,this.stencilZPass=Gi,this.stencilWrite=!1,this.clippingPlanes=null,this.clipIntersection=!1,this.clipShadows=!1,this.shadowSide=null,this.colorWrite=!0,this.precision=null,this.polygonOffset=!1,this.polygonOffsetFactor=0,this.polygonOffsetUnits=0,this.dithering=!1,this.alphaToCoverage=!1,this.premultipliedAlpha=!1,this.forceSinglePass=!1,this.allowOverride=!0,this.visible=!0,this.toneMapped=!0,this.userData={},this.version=0,this._alphaTest=0}get alphaTest(){return this._alphaTest}set alphaTest(t){this._alphaTest>0!=t>0&&this.version++,this._alphaTest=t}onBeforeRender(){}onBeforeCompile(){}customProgramCacheKey(){return this.onBeforeCompile.toString()}setValues(t){if(t!==void 0)for(const e in t){const n=t[e];if(n===void 0){console.warn(`THREE.Material: parameter '${e}' has value of undefined.`);continue}const r=this[e];if(r===void 0){console.warn(`THREE.Material: '${e}' is not a property of THREE.${this.type}.`);continue}r&&r.isColor?r.set(n):r&&r.isVector3&&n&&n.isVector3?r.copy(n):this[e]=n}}toJSON(t){const e=t===void 0||typeof t=="string";e&&(t={textures:{},images:{}});const n={metadata:{version:4.7,type:"Material",generator:"Material.toJSON"}};n.uuid=this.uuid,n.type=this.type,this.name!==""&&(n.name=this.name),this.color&&this.color.isColor&&(n.color=this.color.getHex()),this.roughness!==void 0&&(n.roughness=this.roughness),this.metalness!==void 0&&(n.metalness=this.metalness),this.sheen!==void 0&&(n.sheen=this.sheen),this.sheenColor&&this.sheenColor.isColor&&(n.sheenColor=this.sheenColor.getHex()),this.sheenRoughness!==void 0&&(n.sheenRoughness=this.sheenRoughness),this.emissive&&this.emissive.isColor&&(n.emissive=this.emissive.getHex()),this.emissiveIntensity!==void 0&&this.emissiveIntensity!==1&&(n.emissiveIntensity=this.emissiveIntensity),this.specular&&this.specular.isColor&&(n.specular=this.specular.getHex()),this.specularIntensity!==void 0&&(n.specularIntensity=this.specularIntensity),this.specularColor&&this.specularColor.isColor&&(n.specularColor=this.specularColor.getHex()),this.shininess!==void 0&&(n.shininess=this.shininess),this.clearcoat!==void 0&&(n.clearcoat=this.clearcoat),this.clearcoatRoughness!==void 0&&(n.clearcoatRoughness=this.clearcoatRoughness),this.clearcoatMap&&this.clearcoatMap.isTexture&&(n.clearcoatMap=this.clearcoatMap.toJSON(t).uuid),this.clearcoatRoughnessMap&&this.clearcoatRoughnessMap.isTexture&&(n.clearcoatRoughnessMap=this.clearcoatRoughnessMap.toJSON(t).uuid),this.clearcoatNormalMap&&this.clearcoatNormalMap.isTexture&&(n.clearcoatNormalMap=this.clearcoatNormalMap.toJSON(t).uuid,n.clearcoatNormalScale=this.clearcoatNormalScale.toArray()),this.dispersion!==void 0&&(n.dispersion=this.dispersion),this.iridescence!==void 0&&(n.iridescence=this.iridescence),this.iridescenceIOR!==void 0&&(n.iridescenceIOR=this.iridescenceIOR),this.iridescenceThicknessRange!==void 0&&(n.iridescenceThicknessRange=this.iridescenceThicknessRange),this.iridescenceMap&&this.iridescenceMap.isTexture&&(n.iridescenceMap=this.iridescenceMap.toJSON(t).uuid),this.iridescenceThicknessMap&&this.iridescenceThicknessMap.isTexture&&(n.iridescenceThicknessMap=this.iridescenceThicknessMap.toJSON(t).uuid),this.anisotropy!==void 0&&(n.anisotropy=this.anisotropy),this.anisotropyRotation!==void 0&&(n.anisotropyRotation=this.anisotropyRotation),this.anisotropyMap&&this.anisotropyMap.isTexture&&(n.anisotropyMap=this.anisotropyMap.toJSON(t).uuid),this.map&&this.map.isTexture&&(n.map=this.map.toJSON(t).uuid),this.matcap&&this.matcap.isTexture&&(n.matcap=this.matcap.toJSON(t).uuid),this.alphaMap&&this.alphaMap.isTexture&&(n.alphaMap=this.alphaMap.toJSON(t).uuid),this.lightMap&&this.lightMap.isTexture&&(n.lightMap=this.lightMap.toJSON(t).uuid,n.lightMapIntensity=this.lightMapIntensity),this.aoMap&&this.aoMap.isTexture&&(n.aoMap=this.aoMap.toJSON(t).uuid,n.aoMapIntensity=this.aoMapIntensity),this.bumpMap&&this.bumpMap.isTexture&&(n.bumpMap=this.bumpMap.toJSON(t).uuid,n.bumpScale=this.bumpScale),this.normalMap&&this.normalMap.isTexture&&(n.normalMap=this.normalMap.toJSON(t).uuid,n.normalMapType=this.normalMapType,n.normalScale=this.normalScale.toArray()),this.displacementMap&&this.displacementMap.isTexture&&(n.displacementMap=this.displacementMap.toJSON(t).uuid,n.displacementScale=this.displacementScale,n.displacementBias=this.displacementBias),this.roughnessMap&&this.roughnessMap.isTexture&&(n.roughnessMap=this.roughnessMap.toJSON(t).uuid),this.metalnessMap&&this.metalnessMap.isTexture&&(n.metalnessMap=this.metalnessMap.toJSON(t).uuid),this.emissiveMap&&this.emissiveMap.isTexture&&(n.emissiveMap=this.emissiveMap.toJSON(t).uuid),this.specularMap&&this.specularMap.isTexture&&(n.specularMap=this.specularMap.toJSON(t).uuid),this.specularIntensityMap&&this.specularIntensityMap.isTexture&&(n.specularIntensityMap=this.specularIntensityMap.toJSON(t).uuid),this.specularColorMap&&this.specularColorMap.isTexture&&(n.specularColorMap=this.specularColorMap.toJSON(t).uuid),this.envMap&&this.envMap.isTexture&&(n.envMap=this.envMap.toJSON(t).uuid,this.combine!==void 0&&(n.combine=this.combine)),this.envMapRotation!==void 0&&(n.envMapRotation=this.envMapRotation.toArray()),this.envMapIntensity!==void 0&&(n.envMapIntensity=this.envMapIntensity),this.reflectivity!==void 0&&(n.reflectivity=this.reflectivity),this.refractionRatio!==void 0&&(n.refractionRatio=this.refractionRatio),this.gradientMap&&this.gradientMap.isTexture&&(n.gradientMap=this.gradientMap.toJSON(t).uuid),this.transmission!==void 0&&(n.transmission=this.transmission),this.transmissionMap&&this.transmissionMap.isTexture&&(n.transmissionMap=this.transmissionMap.toJSON(t).uuid),this.thickness!==void 0&&(n.thickness=this.thickness),this.thicknessMap&&this.thicknessMap.isTexture&&(n.thicknessMap=this.thicknessMap.toJSON(t).uuid),this.attenuationDistance!==void 0&&this.attenuationDistance!==1/0&&(n.attenuationDistance=this.attenuationDistance),this.attenuationColor!==void 0&&(n.attenuationColor=this.attenuationColor.getHex()),this.size!==void 0&&(n.size=this.size),this.shadowSide!==null&&(n.shadowSide=this.shadowSide),this.sizeAttenuation!==void 0&&(n.sizeAttenuation=this.sizeAttenuation),this.blending!==yr&&(n.blending=this.blending),this.side!==In&&(n.side=this.side),this.vertexColors===!0&&(n.vertexColors=!0),this.opacity<1&&(n.opacity=this.opacity),this.transparent===!0&&(n.transparent=!0),this.blendSrc!==Tc&&(n.blendSrc=this.blendSrc),this.blendDst!==bc&&(n.blendDst=this.blendDst),this.blendEquation!==Li&&(n.blendEquation=this.blendEquation),this.blendSrcAlpha!==null&&(n.blendSrcAlpha=this.blendSrcAlpha),this.blendDstAlpha!==null&&(n.blendDstAlpha=this.blendDstAlpha),this.blendEquationAlpha!==null&&(n.blendEquationAlpha=this.blendEquationAlpha),this.blendColor&&this.blendColor.isColor&&(n.blendColor=this.blendColor.getHex()),this.blendAlpha!==0&&(n.blendAlpha=this.blendAlpha),this.depthFunc!==br&&(n.depthFunc=this.depthFunc),this.depthTest===!1&&(n.depthTest=this.depthTest),this.depthWrite===!1&&(n.depthWrite=this.depthWrite),this.colorWrite===!1&&(n.colorWrite=this.colorWrite),this.stencilWriteMask!==255&&(n.stencilWriteMask=this.stencilWriteMask),this.stencilFunc!==Ql&&(n.stencilFunc=this.stencilFunc),this.stencilRef!==0&&(n.stencilRef=this.stencilRef),this.stencilFuncMask!==255&&(n.stencilFuncMask=this.stencilFuncMask),this.stencilFail!==Gi&&(n.stencilFail=this.stencilFail),this.stencilZFail!==Gi&&(n.stencilZFail=this.stencilZFail),this.stencilZPass!==Gi&&(n.stencilZPass=this.stencilZPass),this.stencilWrite===!0&&(n.stencilWrite=this.stencilWrite),this.rotation!==void 0&&this.rotation!==0&&(n.rotation=this.rotation),this.polygonOffset===!0&&(n.polygonOffset=!0),this.polygonOffsetFactor!==0&&(n.polygonOffsetFactor=this.polygonOffsetFactor),this.polygonOffsetUnits!==0&&(n.polygonOffsetUnits=this.polygonOffsetUnits),this.linewidth!==void 0&&this.linewidth!==1&&(n.linewidth=this.linewidth),this.dashSize!==void 0&&(n.dashSize=this.dashSize),this.gapSize!==void 0&&(n.gapSize=this.gapSize),this.scale!==void 0&&(n.scale=this.scale),this.dithering===!0&&(n.dithering=!0),this.alphaTest>0&&(n.alphaTest=this.alphaTest),this.alphaHash===!0&&(n.alphaHash=!0),this.alphaToCoverage===!0&&(n.alphaToCoverage=!0),this.premultipliedAlpha===!0&&(n.premultipliedAlpha=!0),this.forceSinglePass===!0&&(n.forceSinglePass=!0),this.wireframe===!0&&(n.wireframe=!0),this.wireframeLinewidth>1&&(n.wireframeLinewidth=this.wireframeLinewidth),this.wireframeLinecap!=="round"&&(n.wireframeLinecap=this.wireframeLinecap),this.wireframeLinejoin!=="round"&&(n.wireframeLinejoin=this.wireframeLinejoin),this.flatShading===!0&&(n.flatShading=!0),this.visible===!1&&(n.visible=!1),this.toneMapped===!1&&(n.toneMapped=!1),this.fog===!1&&(n.fog=!1),Object.keys(this.userData).length>0&&(n.userData=this.userData);function r(s){const a=[];for(const o in s){const c=s[o];delete c.metadata,a.push(c)}return a}if(e){const s=r(t.textures),a=r(t.images);s.length>0&&(n.textures=s),a.length>0&&(n.images=a)}return n}clone(){return new this.constructor().copy(this)}copy(t){this.name=t.name,this.blending=t.blending,this.side=t.side,this.vertexColors=t.vertexColors,this.opacity=t.opacity,this.transparent=t.transparent,this.blendSrc=t.blendSrc,this.blendDst=t.blendDst,this.blendEquation=t.blendEquation,this.blendSrcAlpha=t.blendSrcAlpha,this.blendDstAlpha=t.blendDstAlpha,this.blendEquationAlpha=t.blendEquationAlpha,this.blendColor.copy(t.blendColor),this.blendAlpha=t.blendAlpha,this.depthFunc=t.depthFunc,this.depthTest=t.depthTest,this.depthWrite=t.depthWrite,this.stencilWriteMask=t.stencilWriteMask,this.stencilFunc=t.stencilFunc,this.stencilRef=t.stencilRef,this.stencilFuncMask=t.stencilFuncMask,this.stencilFail=t.stencilFail,this.stencilZFail=t.stencilZFail,this.stencilZPass=t.stencilZPass,this.stencilWrite=t.stencilWrite;const e=t.clippingPlanes;let n=null;if(e!==null){const r=e.length;n=new Array(r);for(let s=0;s!==r;++s)n[s]=e[s].clone()}return this.clippingPlanes=n,this.clipIntersection=t.clipIntersection,this.clipShadows=t.clipShadows,this.shadowSide=t.shadowSide,this.colorWrite=t.colorWrite,this.precision=t.precision,this.polygonOffset=t.polygonOffset,this.polygonOffsetFactor=t.polygonOffsetFactor,this.polygonOffsetUnits=t.polygonOffsetUnits,this.dithering=t.dithering,this.alphaTest=t.alphaTest,this.alphaHash=t.alphaHash,this.alphaToCoverage=t.alphaToCoverage,this.premultipliedAlpha=t.premultipliedAlpha,this.forceSinglePass=t.forceSinglePass,this.visible=t.visible,this.toneMapped=t.toneMapped,this.userData=JSON.parse(JSON.stringify(t.userData)),this}dispose(){this.dispatchEvent({type:"dispose"})}set needsUpdate(t){t===!0&&this.version++}}class gf extends Dr{constructor(t){super(),this.isMeshBasicMaterial=!0,this.type="MeshBasicMaterial",this.color=new qt(16777215),this.map=null,this.lightMap=null,this.lightMapIntensity=1,this.aoMap=null,this.aoMapIntensity=1,this.specularMap=null,this.alphaMap=null,this.envMap=null,this.envMapRotation=new Dn,this.combine=Qh,this.reflectivity=1,this.refractionRatio=.98,this.wireframe=!1,this.wireframeLinewidth=1,this.wireframeLinecap="round",this.wireframeLinejoin="round",this.fog=!0,this.setValues(t)}copy(t){return super.copy(t),this.color.copy(t.color),this.map=t.map,this.lightMap=t.lightMap,this.lightMapIntensity=t.lightMapIntensity,this.aoMap=t.aoMap,this.aoMapIntensity=t.aoMapIntensity,this.specularMap=t.specularMap,this.alphaMap=t.alphaMap,this.envMap=t.envMap,this.envMapRotation.copy(t.envMapRotation),this.combine=t.combine,this.reflectivity=t.reflectivity,this.refractionRatio=t.refractionRatio,this.wireframe=t.wireframe,this.wireframeLinewidth=t.wireframeLinewidth,this.wireframeLinecap=t.wireframeLinecap,this.wireframeLinejoin=t.wireframeLinejoin,this.fog=t.fog,this}}const me=new U,Us=new kt;let mp=0;class de{constructor(t,e,n=!1){if(Array.isArray(t))throw new TypeError("THREE.BufferAttribute: array should be a Typed Array.");this.isBufferAttribute=!0,Object.defineProperty(this,"id",{value:mp++}),this.name="",this.array=t,this.itemSize=e,this.count=t!==void 0?t.length/e:0,this.normalized=n,this.usage=tu,this.updateRanges=[],this.gpuType=yn,this.version=0}onUploadCallback(){}set needsUpdate(t){t===!0&&this.version++}setUsage(t){return this.usage=t,this}addUpdateRange(t,e){this.updateRanges.push({start:t,count:e})}clearUpdateRanges(){this.updateRanges.length=0}copy(t){return this.name=t.name,this.array=new t.array.constructor(t.array),this.itemSize=t.itemSize,this.count=t.count,this.normalized=t.normalized,this.usage=t.usage,this.gpuType=t.gpuType,this}copyAt(t,e,n){t*=this.itemSize,n*=e.itemSize;for(let r=0,s=this.itemSize;r<s;r++)this.array[t+r]=e.array[n+r];return this}copyArray(t){return this.array.set(t),this}applyMatrix3(t){if(this.itemSize===2)for(let e=0,n=this.count;e<n;e++)Us.fromBufferAttribute(this,e),Us.applyMatrix3(t),this.setXY(e,Us.x,Us.y);else if(this.itemSize===3)for(let e=0,n=this.count;e<n;e++)me.fromBufferAttribute(this,e),me.applyMatrix3(t),this.setXYZ(e,me.x,me.y,me.z);return this}applyMatrix4(t){for(let e=0,n=this.count;e<n;e++)me.fromBufferAttribute(this,e),me.applyMatrix4(t),this.setXYZ(e,me.x,me.y,me.z);return this}applyNormalMatrix(t){for(let e=0,n=this.count;e<n;e++)me.fromBufferAttribute(this,e),me.applyNormalMatrix(t),this.setXYZ(e,me.x,me.y,me.z);return this}transformDirection(t){for(let e=0,n=this.count;e<n;e++)me.fromBufferAttribute(this,e),me.transformDirection(t),this.setXYZ(e,me.x,me.y,me.z);return this}set(t,e=0){return this.array.set(t,e),this}getComponent(t,e){let n=this.array[t*this.itemSize+e];return this.normalized&&(n=Br(n,this.array)),n}setComponent(t,e,n){return this.normalized&&(n=Ge(n,this.array)),this.array[t*this.itemSize+e]=n,this}getX(t){let e=this.array[t*this.itemSize];return this.normalized&&(e=Br(e,this.array)),e}setX(t,e){return this.normalized&&(e=Ge(e,this.array)),this.array[t*this.itemSize]=e,this}getY(t){let e=this.array[t*this.itemSize+1];return this.normalized&&(e=Br(e,this.array)),e}setY(t,e){return this.normalized&&(e=Ge(e,this.array)),this.array[t*this.itemSize+1]=e,this}getZ(t){let e=this.array[t*this.itemSize+2];return this.normalized&&(e=Br(e,this.array)),e}setZ(t,e){return this.normalized&&(e=Ge(e,this.array)),this.array[t*this.itemSize+2]=e,this}getW(t){let e=this.array[t*this.itemSize+3];return this.normalized&&(e=Br(e,this.array)),e}setW(t,e){return this.normalized&&(e=Ge(e,this.array)),this.array[t*this.itemSize+3]=e,this}setXY(t,e,n){return t*=this.itemSize,this.normalized&&(e=Ge(e,this.array),n=Ge(n,this.array)),this.array[t+0]=e,this.array[t+1]=n,this}setXYZ(t,e,n,r){return t*=this.itemSize,this.normalized&&(e=Ge(e,this.array),n=Ge(n,this.array),r=Ge(r,this.array)),this.array[t+0]=e,this.array[t+1]=n,this.array[t+2]=r,this}setXYZW(t,e,n,r,s){return t*=this.itemSize,this.normalized&&(e=Ge(e,this.array),n=Ge(n,this.array),r=Ge(r,this.array),s=Ge(s,this.array)),this.array[t+0]=e,this.array[t+1]=n,this.array[t+2]=r,this.array[t+3]=s,this}onUpload(t){return this.onUploadCallback=t,this}clone(){return new this.constructor(this.array,this.itemSize).copy(this)}toJSON(){const t={itemSize:this.itemSize,type:this.array.constructor.name,array:Array.from(this.array),normalized:this.normalized};return this.name!==""&&(t.name=this.name),this.usage!==tu&&(t.usage=this.usage),t}}class mf extends de{constructor(t,e,n){super(new Uint16Array(t),e,n)}}class _f extends de{constructor(t,e,n){super(new Uint32Array(t),e,n)}}class Cn extends de{constructor(t,e,n){super(new Float32Array(t),e,n)}}let _p=0;const en=new $t,Sa=new we,Ji=new U,je=new ye,Hr=new ye,Ee=new U;class De extends Ir{constructor(){super(),this.isBufferGeometry=!0,Object.defineProperty(this,"id",{value:_p++}),this.uuid=xs(),this.name="",this.type="BufferGeometry",this.index=null,this.indirect=null,this.attributes={},this.morphAttributes={},this.morphTargetsRelative=!1,this.groups=[],this.boundingBox=null,this.boundingSphere=null,this.drawRange={start:0,count:1/0},this.userData={}}getIndex(){return this.index}setIndex(t){return Array.isArray(t)?this.index=new(ff(t)?_f:mf)(t,1):this.index=t,this}setIndirect(t){return this.indirect=t,this}getIndirect(){return this.indirect}getAttribute(t){return this.attributes[t]}setAttribute(t,e){return this.attributes[t]=e,this}deleteAttribute(t){return delete this.attributes[t],this}hasAttribute(t){return this.attributes[t]!==void 0}addGroup(t,e,n=0){this.groups.push({start:t,count:e,materialIndex:n})}clearGroups(){this.groups=[]}setDrawRange(t,e){this.drawRange.start=t,this.drawRange.count=e}applyMatrix4(t){const e=this.attributes.position;e!==void 0&&(e.applyMatrix4(t),e.needsUpdate=!0);const n=this.attributes.normal;if(n!==void 0){const s=new Gt().getNormalMatrix(t);n.applyNormalMatrix(s),n.needsUpdate=!0}const r=this.attributes.tangent;return r!==void 0&&(r.transformDirection(t),r.needsUpdate=!0),this.boundingBox!==null&&this.computeBoundingBox(),this.boundingSphere!==null&&this.computeBoundingSphere(),this}applyQuaternion(t){return en.makeRotationFromQuaternion(t),this.applyMatrix4(en),this}rotateX(t){return en.makeRotationX(t),this.applyMatrix4(en),this}rotateY(t){return en.makeRotationY(t),this.applyMatrix4(en),this}rotateZ(t){return en.makeRotationZ(t),this.applyMatrix4(en),this}translate(t,e,n){return en.makeTranslation(t,e,n),this.applyMatrix4(en),this}scale(t,e,n){return en.makeScale(t,e,n),this.applyMatrix4(en),this}lookAt(t){return Sa.lookAt(t),Sa.updateMatrix(),this.applyMatrix4(Sa.matrix),this}center(){return this.computeBoundingBox(),this.boundingBox.getCenter(Ji).negate(),this.translate(Ji.x,Ji.y,Ji.z),this}setFromPoints(t){const e=this.getAttribute("position");if(e===void 0){const n=[];for(let r=0,s=t.length;r<s;r++){const a=t[r];n.push(a.x,a.y,a.z||0)}this.setAttribute("position",new Cn(n,3))}else{const n=Math.min(t.length,e.count);for(let r=0;r<n;r++){const s=t[r];e.setXYZ(r,s.x,s.y,s.z||0)}t.length>e.count&&console.warn("THREE.BufferGeometry: Buffer size too small for points data. Use .dispose() and create a new geometry."),e.needsUpdate=!0}return this}computeBoundingBox(){this.boundingBox===null&&(this.boundingBox=new ye);const t=this.attributes.position,e=this.morphAttributes.position;if(t&&t.isGLBufferAttribute){console.error("THREE.BufferGeometry.computeBoundingBox(): GLBufferAttribute requires a manual bounding box.",this),this.boundingBox.set(new U(-1/0,-1/0,-1/0),new U(1/0,1/0,1/0));return}if(t!==void 0){if(this.boundingBox.setFromBufferAttribute(t),e)for(let n=0,r=e.length;n<r;n++){const s=e[n];je.setFromBufferAttribute(s),this.morphTargetsRelative?(Ee.addVectors(this.boundingBox.min,je.min),this.boundingBox.expandByPoint(Ee),Ee.addVectors(this.boundingBox.max,je.max),this.boundingBox.expandByPoint(Ee)):(this.boundingBox.expandByPoint(je.min),this.boundingBox.expandByPoint(je.max))}}else this.boundingBox.makeEmpty();(isNaN(this.boundingBox.min.x)||isNaN(this.boundingBox.min.y)||isNaN(this.boundingBox.min.z))&&console.error('THREE.BufferGeometry.computeBoundingBox(): Computed min/max have NaN values. The "position" attribute is likely to have NaN values.',this)}computeBoundingSphere(){this.boundingSphere===null&&(this.boundingSphere=new Rn);const t=this.attributes.position,e=this.morphAttributes.position;if(t&&t.isGLBufferAttribute){console.error("THREE.BufferGeometry.computeBoundingSphere(): GLBufferAttribute requires a manual bounding sphere.",this),this.boundingSphere.set(new U,1/0);return}if(t){const n=this.boundingSphere.center;if(je.setFromBufferAttribute(t),e)for(let s=0,a=e.length;s<a;s++){const o=e[s];Hr.setFromBufferAttribute(o),this.morphTargetsRelative?(Ee.addVectors(je.min,Hr.min),je.expandByPoint(Ee),Ee.addVectors(je.max,Hr.max),je.expandByPoint(Ee)):(je.expandByPoint(Hr.min),je.expandByPoint(Hr.max))}je.getCenter(n);let r=0;for(let s=0,a=t.count;s<a;s++)Ee.fromBufferAttribute(t,s),r=Math.max(r,n.distanceToSquared(Ee));if(e)for(let s=0,a=e.length;s<a;s++){const o=e[s],c=this.morphTargetsRelative;for(let h=0,f=o.count;h<f;h++)Ee.fromBufferAttribute(o,h),c&&(Ji.fromBufferAttribute(t,h),Ee.add(Ji)),r=Math.max(r,n.distanceToSquared(Ee))}this.boundingSphere.radius=Math.sqrt(r),isNaN(this.boundingSphere.radius)&&console.error('THREE.BufferGeometry.computeBoundingSphere(): Computed radius is NaN. The "position" attribute is likely to have NaN values.',this)}}computeTangents(){const t=this.index,e=this.attributes;if(t===null||e.position===void 0||e.normal===void 0||e.uv===void 0){console.error("THREE.BufferGeometry: .computeTangents() failed. Missing required attributes (index, position, normal or uv)");return}const n=e.position,r=e.normal,s=e.uv;this.hasAttribute("tangent")===!1&&this.setAttribute("tangent",new de(new Float32Array(4*n.count),4));const a=this.getAttribute("tangent"),o=[],c=[];for(let E=0;E<n.count;E++)o[E]=new U,c[E]=new U;const h=new U,f=new U,g=new U,p=new kt,_=new kt,M=new kt,b=new U,x=new U;function m(E,y,S){h.fromBufferAttribute(n,E),f.fromBufferAttribute(n,y),g.fromBufferAttribute(n,S),p.fromBufferAttribute(s,E),_.fromBufferAttribute(s,y),M.fromBufferAttribute(s,S),f.sub(h),g.sub(h),_.sub(p),M.sub(p);const A=1/(_.x*M.y-M.x*_.y);isFinite(A)&&(b.copy(f).multiplyScalar(M.y).addScaledVector(g,-_.y).multiplyScalar(A),x.copy(g).multiplyScalar(_.x).addScaledVector(f,-M.x).multiplyScalar(A),o[E].add(b),o[y].add(b),o[S].add(b),c[E].add(x),c[y].add(x),c[S].add(x))}let d=this.groups;d.length===0&&(d=[{start:0,count:t.count}]);for(let E=0,y=d.length;E<y;++E){const S=d[E],A=S.start,w=S.count;for(let I=A,N=A+w;I<N;I+=3)m(t.getX(I+0),t.getX(I+1),t.getX(I+2))}const u=new U,v=new U,l=new U,R=new U;function T(E){l.fromBufferAttribute(r,E),R.copy(l);const y=o[E];u.copy(y),u.sub(l.multiplyScalar(l.dot(y))).normalize(),v.crossVectors(R,y);const A=v.dot(c[E])<0?-1:1;a.setXYZW(E,u.x,u.y,u.z,A)}for(let E=0,y=d.length;E<y;++E){const S=d[E],A=S.start,w=S.count;for(let I=A,N=A+w;I<N;I+=3)T(t.getX(I+0)),T(t.getX(I+1)),T(t.getX(I+2))}}computeVertexNormals(){const t=this.index,e=this.getAttribute("position");if(e!==void 0){let n=this.getAttribute("normal");if(n===void 0)n=new de(new Float32Array(e.count*3),3),this.setAttribute("normal",n);else for(let p=0,_=n.count;p<_;p++)n.setXYZ(p,0,0,0);const r=new U,s=new U,a=new U,o=new U,c=new U,h=new U,f=new U,g=new U;if(t)for(let p=0,_=t.count;p<_;p+=3){const M=t.getX(p+0),b=t.getX(p+1),x=t.getX(p+2);r.fromBufferAttribute(e,M),s.fromBufferAttribute(e,b),a.fromBufferAttribute(e,x),f.subVectors(a,s),g.subVectors(r,s),f.cross(g),o.fromBufferAttribute(n,M),c.fromBufferAttribute(n,b),h.fromBufferAttribute(n,x),o.add(f),c.add(f),h.add(f),n.setXYZ(M,o.x,o.y,o.z),n.setXYZ(b,c.x,c.y,c.z),n.setXYZ(x,h.x,h.y,h.z)}else for(let p=0,_=e.count;p<_;p+=3)r.fromBufferAttribute(e,p+0),s.fromBufferAttribute(e,p+1),a.fromBufferAttribute(e,p+2),f.subVectors(a,s),g.subVectors(r,s),f.cross(g),n.setXYZ(p+0,f.x,f.y,f.z),n.setXYZ(p+1,f.x,f.y,f.z),n.setXYZ(p+2,f.x,f.y,f.z);this.normalizeNormals(),n.needsUpdate=!0}}normalizeNormals(){const t=this.attributes.normal;for(let e=0,n=t.count;e<n;e++)Ee.fromBufferAttribute(t,e),Ee.normalize(),t.setXYZ(e,Ee.x,Ee.y,Ee.z)}toNonIndexed(){function t(o,c){const h=o.array,f=o.itemSize,g=o.normalized,p=new h.constructor(c.length*f);let _=0,M=0;for(let b=0,x=c.length;b<x;b++){o.isInterleavedBufferAttribute?_=c[b]*o.data.stride+o.offset:_=c[b]*f;for(let m=0;m<f;m++)p[M++]=h[_++]}return new de(p,f,g)}if(this.index===null)return console.warn("THREE.BufferGeometry.toNonIndexed(): BufferGeometry is already non-indexed."),this;const e=new De,n=this.index.array,r=this.attributes;for(const o in r){const c=r[o],h=t(c,n);e.setAttribute(o,h)}const s=this.morphAttributes;for(const o in s){const c=[],h=s[o];for(let f=0,g=h.length;f<g;f++){const p=h[f],_=t(p,n);c.push(_)}e.morphAttributes[o]=c}e.morphTargetsRelative=this.morphTargetsRelative;const a=this.groups;for(let o=0,c=a.length;o<c;o++){const h=a[o];e.addGroup(h.start,h.count,h.materialIndex)}return e}toJSON(){const t={metadata:{version:4.7,type:"BufferGeometry",generator:"BufferGeometry.toJSON"}};if(t.uuid=this.uuid,t.type=this.type,this.name!==""&&(t.name=this.name),Object.keys(this.userData).length>0&&(t.userData=this.userData),this.parameters!==void 0){const c=this.parameters;for(const h in c)c[h]!==void 0&&(t[h]=c[h]);return t}t.data={attributes:{}};const e=this.index;e!==null&&(t.data.index={type:e.array.constructor.name,array:Array.prototype.slice.call(e.array)});const n=this.attributes;for(const c in n){const h=n[c];t.data.attributes[c]=h.toJSON(t.data)}const r={};let s=!1;for(const c in this.morphAttributes){const h=this.morphAttributes[c],f=[];for(let g=0,p=h.length;g<p;g++){const _=h[g];f.push(_.toJSON(t.data))}f.length>0&&(r[c]=f,s=!0)}s&&(t.data.morphAttributes=r,t.data.morphTargetsRelative=this.morphTargetsRelative);const a=this.groups;a.length>0&&(t.data.groups=JSON.parse(JSON.stringify(a)));const o=this.boundingSphere;return o!==null&&(t.data.boundingSphere=o.toJSON()),t}clone(){return new this.constructor().copy(this)}copy(t){this.index=null,this.attributes={},this.morphAttributes={},this.groups=[],this.boundingBox=null,this.boundingSphere=null;const e={};this.name=t.name;const n=t.index;n!==null&&this.setIndex(n.clone());const r=t.attributes;for(const h in r){const f=r[h];this.setAttribute(h,f.clone(e))}const s=t.morphAttributes;for(const h in s){const f=[],g=s[h];for(let p=0,_=g.length;p<_;p++)f.push(g[p].clone(e));this.morphAttributes[h]=f}this.morphTargetsRelative=t.morphTargetsRelative;const a=t.groups;for(let h=0,f=a.length;h<f;h++){const g=a[h];this.addGroup(g.start,g.count,g.materialIndex)}const o=t.boundingBox;o!==null&&(this.boundingBox=o.clone());const c=t.boundingSphere;return c!==null&&(this.boundingSphere=c.clone()),this.drawRange.start=t.drawRange.start,this.drawRange.count=t.drawRange.count,this.userData=t.userData,this}dispose(){this.dispatchEvent({type:"dispose"})}}const pu=new $t,yi=new Lr,Ns=new Rn,gu=new U,Fs=new U,Bs=new U,Os=new U,Ma=new U,zs=new U,mu=new U,Vs=new U;class Ie extends we{constructor(t=new De,e=new gf){super(),this.isMesh=!0,this.type="Mesh",this.geometry=t,this.material=e,this.morphTargetDictionary=void 0,this.morphTargetInfluences=void 0,this.count=1,this.updateMorphTargets()}copy(t,e){return super.copy(t,e),t.morphTargetInfluences!==void 0&&(this.morphTargetInfluences=t.morphTargetInfluences.slice()),t.morphTargetDictionary!==void 0&&(this.morphTargetDictionary=Object.assign({},t.morphTargetDictionary)),this.material=Array.isArray(t.material)?t.material.slice():t.material,this.geometry=t.geometry,this}updateMorphTargets(){const e=this.geometry.morphAttributes,n=Object.keys(e);if(n.length>0){const r=e[n[0]];if(r!==void 0){this.morphTargetInfluences=[],this.morphTargetDictionary={};for(let s=0,a=r.length;s<a;s++){const o=r[s].name||String(s);this.morphTargetInfluences.push(0),this.morphTargetDictionary[o]=s}}}}getVertexPosition(t,e){const n=this.geometry,r=n.attributes.position,s=n.morphAttributes.position,a=n.morphTargetsRelative;e.fromBufferAttribute(r,t);const o=this.morphTargetInfluences;if(s&&o){zs.set(0,0,0);for(let c=0,h=s.length;c<h;c++){const f=o[c],g=s[c];f!==0&&(Ma.fromBufferAttribute(g,t),a?zs.addScaledVector(Ma,f):zs.addScaledVector(Ma.sub(e),f))}e.add(zs)}return e}raycast(t,e){const n=this.geometry,r=this.material,s=this.matrixWorld;r!==void 0&&(n.boundingSphere===null&&n.computeBoundingSphere(),Ns.copy(n.boundingSphere),Ns.applyMatrix4(s),yi.copy(t.ray).recast(t.near),!(Ns.containsPoint(yi.origin)===!1&&(yi.intersectSphere(Ns,gu)===null||yi.origin.distanceToSquared(gu)>(t.far-t.near)**2))&&(pu.copy(s).invert(),yi.copy(t.ray).applyMatrix4(pu),!(n.boundingBox!==null&&yi.intersectsBox(n.boundingBox)===!1)&&this._computeIntersections(t,e,yi)))}_computeIntersections(t,e,n){let r;const s=this.geometry,a=this.material,o=s.index,c=s.attributes.position,h=s.attributes.uv,f=s.attributes.uv1,g=s.attributes.normal,p=s.groups,_=s.drawRange;if(o!==null)if(Array.isArray(a))for(let M=0,b=p.length;M<b;M++){const x=p[M],m=a[x.materialIndex],d=Math.max(x.start,_.start),u=Math.min(o.count,Math.min(x.start+x.count,_.start+_.count));for(let v=d,l=u;v<l;v+=3){const R=o.getX(v),T=o.getX(v+1),E=o.getX(v+2);r=Hs(this,m,t,n,h,f,g,R,T,E),r&&(r.faceIndex=Math.floor(v/3),r.face.materialIndex=x.materialIndex,e.push(r))}}else{const M=Math.max(0,_.start),b=Math.min(o.count,_.start+_.count);for(let x=M,m=b;x<m;x+=3){const d=o.getX(x),u=o.getX(x+1),v=o.getX(x+2);r=Hs(this,a,t,n,h,f,g,d,u,v),r&&(r.faceIndex=Math.floor(x/3),e.push(r))}}else if(c!==void 0)if(Array.isArray(a))for(let M=0,b=p.length;M<b;M++){const x=p[M],m=a[x.materialIndex],d=Math.max(x.start,_.start),u=Math.min(c.count,Math.min(x.start+x.count,_.start+_.count));for(let v=d,l=u;v<l;v+=3){const R=v,T=v+1,E=v+2;r=Hs(this,m,t,n,h,f,g,R,T,E),r&&(r.faceIndex=Math.floor(v/3),r.face.materialIndex=x.materialIndex,e.push(r))}}else{const M=Math.max(0,_.start),b=Math.min(c.count,_.start+_.count);for(let x=M,m=b;x<m;x+=3){const d=x,u=x+1,v=x+2;r=Hs(this,a,t,n,h,f,g,d,u,v),r&&(r.faceIndex=Math.floor(x/3),e.push(r))}}}}function xp(i,t,e,n,r,s,a,o){let c;if(t.side===ze?c=n.intersectTriangle(a,s,r,!0,o):c=n.intersectTriangle(r,s,a,t.side===In,o),c===null)return null;Vs.copy(o),Vs.applyMatrix4(i.matrixWorld);const h=e.ray.origin.distanceTo(Vs);return h<e.near||h>e.far?null:{distance:h,point:Vs.clone(),object:i}}function Hs(i,t,e,n,r,s,a,o,c,h){i.getVertexPosition(o,Fs),i.getVertexPosition(c,Bs),i.getVertexPosition(h,Os);const f=xp(i,t,e,n,Fs,Bs,Os,mu);if(f){const g=new U;ve.getBarycoord(mu,Fs,Bs,Os,g),r&&(f.uv=ve.getInterpolatedAttribute(r,o,c,h,g,new kt)),s&&(f.uv1=ve.getInterpolatedAttribute(s,o,c,h,g,new kt)),a&&(f.normal=ve.getInterpolatedAttribute(a,o,c,h,g,new U),f.normal.dot(n.direction)>0&&f.normal.multiplyScalar(-1));const p={a:o,b:c,c:h,normal:new U,materialIndex:0};ve.getNormal(Fs,Bs,Os,p.normal),f.face=p,f.barycoord=g}return f}class ys extends De{constructor(t=1,e=1,n=1,r=1,s=1,a=1){super(),this.type="BoxGeometry",this.parameters={width:t,height:e,depth:n,widthSegments:r,heightSegments:s,depthSegments:a};const o=this;r=Math.floor(r),s=Math.floor(s),a=Math.floor(a);const c=[],h=[],f=[],g=[];let p=0,_=0;M("z","y","x",-1,-1,n,e,t,a,s,0),M("z","y","x",1,-1,n,e,-t,a,s,1),M("x","z","y",1,1,t,n,e,r,a,2),M("x","z","y",1,-1,t,n,-e,r,a,3),M("x","y","z",1,-1,t,e,n,r,s,4),M("x","y","z",-1,-1,t,e,-n,r,s,5),this.setIndex(c),this.setAttribute("position",new Cn(h,3)),this.setAttribute("normal",new Cn(f,3)),this.setAttribute("uv",new Cn(g,2));function M(b,x,m,d,u,v,l,R,T,E,y){const S=v/T,A=l/E,w=v/2,I=l/2,N=R/2,B=T+1,F=E+1;let k=0,z=0;const J=new U;for(let Z=0;Z<F;Z++){const it=Z*A-I;for(let pt=0;pt<B;pt++){const _t=pt*S-w;J[b]=_t*d,J[x]=it*u,J[m]=N,h.push(J.x,J.y,J.z),J[b]=0,J[x]=0,J[m]=R>0?1:-1,f.push(J.x,J.y,J.z),g.push(pt/T),g.push(1-Z/E),k+=1}}for(let Z=0;Z<E;Z++)for(let it=0;it<T;it++){const pt=p+it+B*Z,_t=p+it+B*(Z+1),W=p+(it+1)+B*(Z+1),tt=p+(it+1)+B*Z;c.push(pt,_t,tt),c.push(_t,W,tt),z+=6}o.addGroup(_,z,y),_+=z,p+=k}}copy(t){return super.copy(t),this.parameters=Object.assign({},t.parameters),this}static fromJSON(t){return new ys(t.width,t.height,t.depth,t.widthSegments,t.heightSegments,t.depthSegments)}}function Cr(i){const t={};for(const e in i){t[e]={};for(const n in i[e]){const r=i[e][n];r&&(r.isColor||r.isMatrix3||r.isMatrix4||r.isVector2||r.isVector3||r.isVector4||r.isTexture||r.isQuaternion)?r.isRenderTargetTexture?(console.warn("UniformsUtils: Textures of render targets cannot be cloned via cloneUniforms() or mergeUniforms()."),t[e][n]=null):t[e][n]=r.clone():Array.isArray(r)?t[e][n]=r.slice():t[e][n]=r}}return t}function Fe(i){const t={};for(let e=0;e<i.length;e++){const n=Cr(i[e]);for(const r in n)t[r]=n[r]}return t}function vp(i){const t=[];for(let e=0;e<i.length;e++)t.push(i[e].clone());return t}function xf(i){const t=i.getRenderTarget();return t===null?i.outputColorSpace:t.isXRRenderTarget===!0?t.texture.colorSpace:Jt.workingColorSpace}const yp={clone:Cr,merge:Fe};var Sp=`void main() {
	gl_Position = projectionMatrix * modelViewMatrix * vec4( position, 1.0 );
}`,Mp=`void main() {
	gl_FragColor = vec4( 1.0, 0.0, 0.0, 1.0 );
}`;class pi extends Dr{constructor(t){super(),this.isShaderMaterial=!0,this.type="ShaderMaterial",this.defines={},this.uniforms={},this.uniformsGroups=[],this.vertexShader=Sp,this.fragmentShader=Mp,this.linewidth=1,this.wireframe=!1,this.wireframeLinewidth=1,this.fog=!1,this.lights=!1,this.clipping=!1,this.forceSinglePass=!0,this.extensions={clipCullDistance:!1,multiDraw:!1},this.defaultAttributeValues={color:[1,1,1],uv:[0,0],uv1:[0,0]},this.index0AttributeName=void 0,this.uniformsNeedUpdate=!1,this.glslVersion=null,t!==void 0&&this.setValues(t)}copy(t){return super.copy(t),this.fragmentShader=t.fragmentShader,this.vertexShader=t.vertexShader,this.uniforms=Cr(t.uniforms),this.uniformsGroups=vp(t.uniformsGroups),this.defines=Object.assign({},t.defines),this.wireframe=t.wireframe,this.wireframeLinewidth=t.wireframeLinewidth,this.fog=t.fog,this.lights=t.lights,this.clipping=t.clipping,this.extensions=Object.assign({},t.extensions),this.glslVersion=t.glslVersion,this}toJSON(t){const e=super.toJSON(t);e.glslVersion=this.glslVersion,e.uniforms={};for(const r in this.uniforms){const a=this.uniforms[r].value;a&&a.isTexture?e.uniforms[r]={type:"t",value:a.toJSON(t).uuid}:a&&a.isColor?e.uniforms[r]={type:"c",value:a.getHex()}:a&&a.isVector2?e.uniforms[r]={type:"v2",value:a.toArray()}:a&&a.isVector3?e.uniforms[r]={type:"v3",value:a.toArray()}:a&&a.isVector4?e.uniforms[r]={type:"v4",value:a.toArray()}:a&&a.isMatrix3?e.uniforms[r]={type:"m3",value:a.toArray()}:a&&a.isMatrix4?e.uniforms[r]={type:"m4",value:a.toArray()}:e.uniforms[r]={value:a}}Object.keys(this.defines).length>0&&(e.defines=this.defines),e.vertexShader=this.vertexShader,e.fragmentShader=this.fragmentShader,e.lights=this.lights,e.clipping=this.clipping;const n={};for(const r in this.extensions)this.extensions[r]===!0&&(n[r]=!0);return Object.keys(n).length>0&&(e.extensions=n),e}}class vf extends we{constructor(){super(),this.isCamera=!0,this.type="Camera",this.matrixWorldInverse=new $t,this.projectionMatrix=new $t,this.projectionMatrixInverse=new $t,this.coordinateSystem=An}copy(t,e){return super.copy(t,e),this.matrixWorldInverse.copy(t.matrixWorldInverse),this.projectionMatrix.copy(t.projectionMatrix),this.projectionMatrixInverse.copy(t.projectionMatrixInverse),this.coordinateSystem=t.coordinateSystem,this}getWorldDirection(t){return super.getWorldDirection(t).negate()}updateMatrixWorld(t){super.updateMatrixWorld(t),this.matrixWorldInverse.copy(this.matrixWorld).invert()}updateWorldMatrix(t,e){super.updateWorldMatrix(t,e),this.matrixWorldInverse.copy(this.matrixWorld).invert()}clone(){return new this.constructor().copy(this)}}const Qn=new U,_u=new kt,xu=new kt;class sn extends vf{constructor(t=50,e=1,n=.1,r=2e3){super(),this.isPerspectiveCamera=!0,this.type="PerspectiveCamera",this.fov=t,this.zoom=1,this.near=n,this.far=r,this.focus=10,this.aspect=e,this.view=null,this.filmGauge=35,this.filmOffset=0,this.updateProjectionMatrix()}copy(t,e){return super.copy(t,e),this.fov=t.fov,this.zoom=t.zoom,this.near=t.near,this.far=t.far,this.focus=t.focus,this.aspect=t.aspect,this.view=t.view===null?null:Object.assign({},t.view),this.filmGauge=t.filmGauge,this.filmOffset=t.filmOffset,this}setFocalLength(t){const e=.5*this.getFilmHeight()/t;this.fov=cl*2*Math.atan(e),this.updateProjectionMatrix()}getFocalLength(){const t=Math.tan(ea*.5*this.fov);return .5*this.getFilmHeight()/t}getEffectiveFOV(){return cl*2*Math.atan(Math.tan(ea*.5*this.fov)/this.zoom)}getFilmWidth(){return this.filmGauge*Math.min(this.aspect,1)}getFilmHeight(){return this.filmGauge/Math.max(this.aspect,1)}getViewBounds(t,e,n){Qn.set(-1,-1,.5).applyMatrix4(this.projectionMatrixInverse),e.set(Qn.x,Qn.y).multiplyScalar(-t/Qn.z),Qn.set(1,1,.5).applyMatrix4(this.projectionMatrixInverse),n.set(Qn.x,Qn.y).multiplyScalar(-t/Qn.z)}getViewSize(t,e){return this.getViewBounds(t,_u,xu),e.subVectors(xu,_u)}setViewOffset(t,e,n,r,s,a){this.aspect=t/e,this.view===null&&(this.view={enabled:!0,fullWidth:1,fullHeight:1,offsetX:0,offsetY:0,width:1,height:1}),this.view.enabled=!0,this.view.fullWidth=t,this.view.fullHeight=e,this.view.offsetX=n,this.view.offsetY=r,this.view.width=s,this.view.height=a,this.updateProjectionMatrix()}clearViewOffset(){this.view!==null&&(this.view.enabled=!1),this.updateProjectionMatrix()}updateProjectionMatrix(){const t=this.near;let e=t*Math.tan(ea*.5*this.fov)/this.zoom,n=2*e,r=this.aspect*n,s=-.5*r;const a=this.view;if(this.view!==null&&this.view.enabled){const c=a.fullWidth,h=a.fullHeight;s+=a.offsetX*r/c,e-=a.offsetY*n/h,r*=a.width/c,n*=a.height/h}const o=this.filmOffset;o!==0&&(s+=t*o/this.getFilmWidth()),this.projectionMatrix.makePerspective(s,s+r,e,e-n,t,this.far,this.coordinateSystem),this.projectionMatrixInverse.copy(this.projectionMatrix).invert()}toJSON(t){const e=super.toJSON(t);return e.object.fov=this.fov,e.object.zoom=this.zoom,e.object.near=this.near,e.object.far=this.far,e.object.focus=this.focus,e.object.aspect=this.aspect,this.view!==null&&(e.object.view=Object.assign({},this.view)),e.object.filmGauge=this.filmGauge,e.object.filmOffset=this.filmOffset,e}}const Qi=-90,tr=1;class Ep extends we{constructor(t,e,n){super(),this.type="CubeCamera",this.renderTarget=n,this.coordinateSystem=null,this.activeMipmapLevel=0;const r=new sn(Qi,tr,t,e);r.layers=this.layers,this.add(r);const s=new sn(Qi,tr,t,e);s.layers=this.layers,this.add(s);const a=new sn(Qi,tr,t,e);a.layers=this.layers,this.add(a);const o=new sn(Qi,tr,t,e);o.layers=this.layers,this.add(o);const c=new sn(Qi,tr,t,e);c.layers=this.layers,this.add(c);const h=new sn(Qi,tr,t,e);h.layers=this.layers,this.add(h)}updateCoordinateSystem(){const t=this.coordinateSystem,e=this.children.concat(),[n,r,s,a,o,c]=e;for(const h of e)this.remove(h);if(t===An)n.up.set(0,1,0),n.lookAt(1,0,0),r.up.set(0,1,0),r.lookAt(-1,0,0),s.up.set(0,0,-1),s.lookAt(0,1,0),a.up.set(0,0,1),a.lookAt(0,-1,0),o.up.set(0,1,0),o.lookAt(0,0,1),c.up.set(0,1,0),c.lookAt(0,0,-1);else if(t===Bo)n.up.set(0,-1,0),n.lookAt(-1,0,0),r.up.set(0,-1,0),r.lookAt(1,0,0),s.up.set(0,0,1),s.lookAt(0,1,0),a.up.set(0,0,-1),a.lookAt(0,-1,0),o.up.set(0,-1,0),o.lookAt(0,0,1),c.up.set(0,-1,0),c.lookAt(0,0,-1);else throw new Error("THREE.CubeCamera.updateCoordinateSystem(): Invalid coordinate system: "+t);for(const h of e)this.add(h),h.updateMatrixWorld()}update(t,e){this.parent===null&&this.updateMatrixWorld();const{renderTarget:n,activeMipmapLevel:r}=this;this.coordinateSystem!==t.coordinateSystem&&(this.coordinateSystem=t.coordinateSystem,this.updateCoordinateSystem());const[s,a,o,c,h,f]=this.children,g=t.getRenderTarget(),p=t.getActiveCubeFace(),_=t.getActiveMipmapLevel(),M=t.xr.enabled;t.xr.enabled=!1;const b=n.texture.generateMipmaps;n.texture.generateMipmaps=!1,t.setRenderTarget(n,0,r),t.render(e,s),t.setRenderTarget(n,1,r),t.render(e,a),t.setRenderTarget(n,2,r),t.render(e,o),t.setRenderTarget(n,3,r),t.render(e,c),t.setRenderTarget(n,4,r),t.render(e,h),n.texture.generateMipmaps=b,t.setRenderTarget(n,5,r),t.render(e,f),t.setRenderTarget(g,p,_),t.xr.enabled=M,n.texture.needsPMREMUpdate=!0}}class yf extends Le{constructor(t=[],e=Ar,n,r,s,a,o,c,h,f){super(t,e,n,r,s,a,o,c,h,f),this.isCubeTexture=!0,this.flipY=!1}get images(){return this.image}set images(t){this.image=t}}class Tp extends Vi{constructor(t=1,e={}){super(t,t,e),this.isWebGLCubeRenderTarget=!0;const n={width:t,height:t,depth:1},r=[n,n,n,n,n,n];this.texture=new yf(r),this._setTextureOptions(e),this.texture.isRenderTargetTexture=!0}fromEquirectangularTexture(t,e){this.texture.type=e.type,this.texture.colorSpace=e.colorSpace,this.texture.generateMipmaps=e.generateMipmaps,this.texture.minFilter=e.minFilter,this.texture.magFilter=e.magFilter;const n={uniforms:{tEquirect:{value:null}},vertexShader:`

				varying vec3 vWorldDirection;

				vec3 transformDirection( in vec3 dir, in mat4 matrix ) {

					return normalize( ( matrix * vec4( dir, 0.0 ) ).xyz );

				}

				void main() {

					vWorldDirection = transformDirection( position, modelMatrix );

					#include <begin_vertex>
					#include <project_vertex>

				}
			`,fragmentShader:`

				uniform sampler2D tEquirect;

				varying vec3 vWorldDirection;

				#include <common>

				void main() {

					vec3 direction = normalize( vWorldDirection );

					vec2 sampleUV = equirectUv( direction );

					gl_FragColor = texture2D( tEquirect, sampleUV );

				}
			`},r=new ys(5,5,5),s=new pi({name:"CubemapFromEquirect",uniforms:Cr(n.uniforms),vertexShader:n.vertexShader,fragmentShader:n.fragmentShader,side:ze,blending:li});s.uniforms.tEquirect.value=e;const a=new Ie(r,s),o=e.minFilter;return e.minFilter===Bi&&(e.minFilter=bn),new Ep(1,10,this).update(t,a),e.minFilter=o,a.geometry.dispose(),a.material.dispose(),this}clear(t,e=!0,n=!0,r=!0){const s=t.getRenderTarget();for(let a=0;a<6;a++)t.setRenderTarget(this,a),t.clear(e,n,r);t.setRenderTarget(s)}}class gr extends we{constructor(){super(),this.isGroup=!0,this.type="Group"}}const bp={type:"move"};class Ea{constructor(){this._targetRay=null,this._grip=null,this._hand=null}getHandSpace(){return this._hand===null&&(this._hand=new gr,this._hand.matrixAutoUpdate=!1,this._hand.visible=!1,this._hand.joints={},this._hand.inputState={pinching:!1}),this._hand}getTargetRaySpace(){return this._targetRay===null&&(this._targetRay=new gr,this._targetRay.matrixAutoUpdate=!1,this._targetRay.visible=!1,this._targetRay.hasLinearVelocity=!1,this._targetRay.linearVelocity=new U,this._targetRay.hasAngularVelocity=!1,this._targetRay.angularVelocity=new U),this._targetRay}getGripSpace(){return this._grip===null&&(this._grip=new gr,this._grip.matrixAutoUpdate=!1,this._grip.visible=!1,this._grip.hasLinearVelocity=!1,this._grip.linearVelocity=new U,this._grip.hasAngularVelocity=!1,this._grip.angularVelocity=new U),this._grip}dispatchEvent(t){return this._targetRay!==null&&this._targetRay.dispatchEvent(t),this._grip!==null&&this._grip.dispatchEvent(t),this._hand!==null&&this._hand.dispatchEvent(t),this}connect(t){if(t&&t.hand){const e=this._hand;if(e)for(const n of t.hand.values())this._getHandJoint(e,n)}return this.dispatchEvent({type:"connected",data:t}),this}disconnect(t){return this.dispatchEvent({type:"disconnected",data:t}),this._targetRay!==null&&(this._targetRay.visible=!1),this._grip!==null&&(this._grip.visible=!1),this._hand!==null&&(this._hand.visible=!1),this}update(t,e,n){let r=null,s=null,a=null;const o=this._targetRay,c=this._grip,h=this._hand;if(t&&e.session.visibilityState!=="visible-blurred"){if(h&&t.hand){a=!0;for(const b of t.hand.values()){const x=e.getJointPose(b,n),m=this._getHandJoint(h,b);x!==null&&(m.matrix.fromArray(x.transform.matrix),m.matrix.decompose(m.position,m.rotation,m.scale),m.matrixWorldNeedsUpdate=!0,m.jointRadius=x.radius),m.visible=x!==null}const f=h.joints["index-finger-tip"],g=h.joints["thumb-tip"],p=f.position.distanceTo(g.position),_=.02,M=.005;h.inputState.pinching&&p>_+M?(h.inputState.pinching=!1,this.dispatchEvent({type:"pinchend",handedness:t.handedness,target:this})):!h.inputState.pinching&&p<=_-M&&(h.inputState.pinching=!0,this.dispatchEvent({type:"pinchstart",handedness:t.handedness,target:this}))}else c!==null&&t.gripSpace&&(s=e.getPose(t.gripSpace,n),s!==null&&(c.matrix.fromArray(s.transform.matrix),c.matrix.decompose(c.position,c.rotation,c.scale),c.matrixWorldNeedsUpdate=!0,s.linearVelocity?(c.hasLinearVelocity=!0,c.linearVelocity.copy(s.linearVelocity)):c.hasLinearVelocity=!1,s.angularVelocity?(c.hasAngularVelocity=!0,c.angularVelocity.copy(s.angularVelocity)):c.hasAngularVelocity=!1));o!==null&&(r=e.getPose(t.targetRaySpace,n),r===null&&s!==null&&(r=s),r!==null&&(o.matrix.fromArray(r.transform.matrix),o.matrix.decompose(o.position,o.rotation,o.scale),o.matrixWorldNeedsUpdate=!0,r.linearVelocity?(o.hasLinearVelocity=!0,o.linearVelocity.copy(r.linearVelocity)):o.hasLinearVelocity=!1,r.angularVelocity?(o.hasAngularVelocity=!0,o.angularVelocity.copy(r.angularVelocity)):o.hasAngularVelocity=!1,this.dispatchEvent(bp)))}return o!==null&&(o.visible=r!==null),c!==null&&(c.visible=s!==null),h!==null&&(h.visible=a!==null),this}_getHandJoint(t,e){if(t.joints[e.jointName]===void 0){const n=new gr;n.matrixAutoUpdate=!1,n.visible=!1,t.joints[e.jointName]=n,t.add(n)}return t.joints[e.jointName]}}class Ap extends we{constructor(){super(),this.isScene=!0,this.type="Scene",this.background=null,this.environment=null,this.fog=null,this.backgroundBlurriness=0,this.backgroundIntensity=1,this.backgroundRotation=new Dn,this.environmentIntensity=1,this.environmentRotation=new Dn,this.overrideMaterial=null,typeof __THREE_DEVTOOLS__<"u"&&__THREE_DEVTOOLS__.dispatchEvent(new CustomEvent("observe",{detail:this}))}copy(t,e){return super.copy(t,e),t.background!==null&&(this.background=t.background.clone()),t.environment!==null&&(this.environment=t.environment.clone()),t.fog!==null&&(this.fog=t.fog.clone()),this.backgroundBlurriness=t.backgroundBlurriness,this.backgroundIntensity=t.backgroundIntensity,this.backgroundRotation.copy(t.backgroundRotation),this.environmentIntensity=t.environmentIntensity,this.environmentRotation.copy(t.environmentRotation),t.overrideMaterial!==null&&(this.overrideMaterial=t.overrideMaterial.clone()),this.matrixAutoUpdate=t.matrixAutoUpdate,this}toJSON(t){const e=super.toJSON(t);return this.fog!==null&&(e.object.fog=this.fog.toJSON()),this.backgroundBlurriness>0&&(e.object.backgroundBlurriness=this.backgroundBlurriness),this.backgroundIntensity!==1&&(e.object.backgroundIntensity=this.backgroundIntensity),e.object.backgroundRotation=this.backgroundRotation.toArray(),this.environmentIntensity!==1&&(e.object.environmentIntensity=this.environmentIntensity),e.object.environmentRotation=this.environmentRotation.toArray(),e}}class Ta extends Le{constructor(t=null,e=1,n=1,r,s,a,o,c,h=Je,f=Je,g,p){super(null,a,o,c,h,f,r,s,g,p),this.isDataTexture=!0,this.image={data:t,width:e,height:n},this.generateMipmaps=!1,this.flipY=!1,this.unpackAlignment=1}}const ba=new U,wp=new U,Rp=new Gt;class En{constructor(t=new U(1,0,0),e=0){this.isPlane=!0,this.normal=t,this.constant=e}set(t,e){return this.normal.copy(t),this.constant=e,this}setComponents(t,e,n,r){return this.normal.set(t,e,n),this.constant=r,this}setFromNormalAndCoplanarPoint(t,e){return this.normal.copy(t),this.constant=-e.dot(this.normal),this}setFromCoplanarPoints(t,e,n){const r=ba.subVectors(n,e).cross(wp.subVectors(t,e)).normalize();return this.setFromNormalAndCoplanarPoint(r,t),this}copy(t){return this.normal.copy(t.normal),this.constant=t.constant,this}normalize(){const t=1/this.normal.length();return this.normal.multiplyScalar(t),this.constant*=t,this}negate(){return this.constant*=-1,this.normal.negate(),this}distanceToPoint(t){return this.normal.dot(t)+this.constant}distanceToSphere(t){return this.distanceToPoint(t.center)-t.radius}projectPoint(t,e){return e.copy(t).addScaledVector(this.normal,-this.distanceToPoint(t))}intersectLine(t,e){const n=t.delta(ba),r=this.normal.dot(n);if(r===0)return this.distanceToPoint(t.start)===0?e.copy(t.start):null;const s=-(t.start.dot(this.normal)+this.constant)/r;return s<0||s>1?null:e.copy(t.start).addScaledVector(n,s)}intersectsLine(t){const e=this.distanceToPoint(t.start),n=this.distanceToPoint(t.end);return e<0&&n>0||n<0&&e>0}intersectsBox(t){return t.intersectsPlane(this)}intersectsSphere(t){return t.intersectsPlane(this)}coplanarPoint(t){return t.copy(this.normal).multiplyScalar(-this.constant)}applyMatrix4(t,e){const n=e||Rp.getNormalMatrix(t),r=this.coplanarPoint(ba).applyMatrix4(t),s=this.normal.applyMatrix3(n).normalize();return this.constant=-r.dot(s),this}translate(t){return this.constant-=t.dot(this.normal),this}equals(t){return t.normal.equals(this.normal)&&t.constant===this.constant}clone(){return new this.constructor().copy(this)}}const Si=new Rn,Gs=new U;class Ss{constructor(t=new En,e=new En,n=new En,r=new En,s=new En,a=new En){this.planes=[t,e,n,r,s,a]}set(t,e,n,r,s,a){const o=this.planes;return o[0].copy(t),o[1].copy(e),o[2].copy(n),o[3].copy(r),o[4].copy(s),o[5].copy(a),this}copy(t){const e=this.planes;for(let n=0;n<6;n++)e[n].copy(t.planes[n]);return this}setFromProjectionMatrix(t,e=An){const n=this.planes,r=t.elements,s=r[0],a=r[1],o=r[2],c=r[3],h=r[4],f=r[5],g=r[6],p=r[7],_=r[8],M=r[9],b=r[10],x=r[11],m=r[12],d=r[13],u=r[14],v=r[15];if(n[0].setComponents(c-s,p-h,x-_,v-m).normalize(),n[1].setComponents(c+s,p+h,x+_,v+m).normalize(),n[2].setComponents(c+a,p+f,x+M,v+d).normalize(),n[3].setComponents(c-a,p-f,x-M,v-d).normalize(),n[4].setComponents(c-o,p-g,x-b,v-u).normalize(),e===An)n[5].setComponents(c+o,p+g,x+b,v+u).normalize();else if(e===Bo)n[5].setComponents(o,g,b,u).normalize();else throw new Error("THREE.Frustum.setFromProjectionMatrix(): Invalid coordinate system: "+e);return this}intersectsObject(t){if(t.boundingSphere!==void 0)t.boundingSphere===null&&t.computeBoundingSphere(),Si.copy(t.boundingSphere).applyMatrix4(t.matrixWorld);else{const e=t.geometry;e.boundingSphere===null&&e.computeBoundingSphere(),Si.copy(e.boundingSphere).applyMatrix4(t.matrixWorld)}return this.intersectsSphere(Si)}intersectsSprite(t){return Si.center.set(0,0,0),Si.radius=.7071067811865476,Si.applyMatrix4(t.matrixWorld),this.intersectsSphere(Si)}intersectsSphere(t){const e=this.planes,n=t.center,r=-t.radius;for(let s=0;s<6;s++)if(e[s].distanceToPoint(n)<r)return!1;return!0}intersectsBox(t){const e=this.planes;for(let n=0;n<6;n++){const r=e[n];if(Gs.x=r.normal.x>0?t.max.x:t.min.x,Gs.y=r.normal.y>0?t.max.y:t.min.y,Gs.z=r.normal.z>0?t.max.z:t.min.z,r.distanceToPoint(Gs)<0)return!1}return!0}containsPoint(t){const e=this.planes;for(let n=0;n<6;n++)if(e[n].distanceToPoint(t)<0)return!1;return!0}clone(){return new this.constructor().copy(this)}}const Sn=new $t,Mn=new Ss;class Pl{constructor(){this.coordinateSystem=An}intersectsObject(t,e){if(!e.isArrayCamera||e.cameras.length===0)return!1;for(let n=0;n<e.cameras.length;n++){const r=e.cameras[n];if(Sn.multiplyMatrices(r.projectionMatrix,r.matrixWorldInverse),Mn.setFromProjectionMatrix(Sn,this.coordinateSystem),Mn.intersectsObject(t))return!0}return!1}intersectsSprite(t,e){if(!e||!e.cameras||e.cameras.length===0)return!1;for(let n=0;n<e.cameras.length;n++){const r=e.cameras[n];if(Sn.multiplyMatrices(r.projectionMatrix,r.matrixWorldInverse),Mn.setFromProjectionMatrix(Sn,this.coordinateSystem),Mn.intersectsSprite(t))return!0}return!1}intersectsSphere(t,e){if(!e||!e.cameras||e.cameras.length===0)return!1;for(let n=0;n<e.cameras.length;n++){const r=e.cameras[n];if(Sn.multiplyMatrices(r.projectionMatrix,r.matrixWorldInverse),Mn.setFromProjectionMatrix(Sn,this.coordinateSystem),Mn.intersectsSphere(t))return!0}return!1}intersectsBox(t,e){if(!e||!e.cameras||e.cameras.length===0)return!1;for(let n=0;n<e.cameras.length;n++){const r=e.cameras[n];if(Sn.multiplyMatrices(r.projectionMatrix,r.matrixWorldInverse),Mn.setFromProjectionMatrix(Sn,this.coordinateSystem),Mn.intersectsBox(t))return!0}return!1}containsPoint(t,e){if(!e||!e.cameras||e.cameras.length===0)return!1;for(let n=0;n<e.cameras.length;n++){const r=e.cameras[n];if(Sn.multiplyMatrices(r.projectionMatrix,r.matrixWorldInverse),Mn.setFromProjectionMatrix(Sn,this.coordinateSystem),Mn.containsPoint(t))return!0}return!1}clone(){return new Pl}}function Aa(i,t){return i-t}function Cp(i,t){return i.z-t.z}function Pp(i,t){return t.z-i.z}class Ip{constructor(){this.index=0,this.pool=[],this.list=[]}push(t,e,n,r){const s=this.pool,a=this.list;this.index>=s.length&&s.push({start:-1,count:-1,z:-1,index:-1});const o=s[this.index];a.push(o),this.index++,o.start=t,o.count=e,o.z=n,o.index=r}reset(){this.list.length=0,this.index=0}}const ke=new $t,Lp=new qt(1,1,1),vu=new Ss,Dp=new Pl,ks=new ye,Mi=new Rn,Gr=new U,yu=new U,Up=new U,wa=new Ip,Pe=new Ie,Ws=[];function Np(i,t,e=0){const n=t.itemSize;if(i.isInterleavedBufferAttribute||i.array.constructor!==t.array.constructor){const r=i.count;for(let s=0;s<r;s++)for(let a=0;a<n;a++)t.setComponent(s+e,a,i.getComponent(s,a))}else t.array.set(i.array,e*n);t.needsUpdate=!0}function Ei(i,t){if(i.constructor!==t.constructor){const e=Math.min(i.length,t.length);for(let n=0;n<e;n++)t[n]=i[n]}else{const e=Math.min(i.length,t.length);t.set(new i.constructor(i.buffer,0,e))}}class bo extends Ie{constructor(t,e,n=e*2,r){super(new De,r),this.isBatchedMesh=!0,this.perObjectFrustumCulled=!0,this.sortObjects=!0,this.boundingBox=null,this.boundingSphere=null,this.customSort=null,this._instanceInfo=[],this._geometryInfo=[],this._availableInstanceIds=[],this._availableGeometryIds=[],this._nextIndexStart=0,this._nextVertexStart=0,this._geometryCount=0,this._visibilityChanged=!0,this._geometryInitialized=!1,this._maxInstanceCount=t,this._maxVertexCount=e,this._maxIndexCount=n,this._multiDrawCounts=new Int32Array(t),this._multiDrawStarts=new Int32Array(t),this._multiDrawCount=0,this._multiDrawInstances=null,this._matricesTexture=null,this._indirectTexture=null,this._colorsTexture=null,this._initMatricesTexture(),this._initIndirectTexture()}get maxInstanceCount(){return this._maxInstanceCount}get instanceCount(){return this._instanceInfo.length-this._availableInstanceIds.length}get unusedVertexCount(){return this._maxVertexCount-this._nextVertexStart}get unusedIndexCount(){return this._maxIndexCount-this._nextIndexStart}_initMatricesTexture(){let t=Math.sqrt(this._maxInstanceCount*4);t=Math.ceil(t/4)*4,t=Math.max(t,4);const e=new Float32Array(t*t*4),n=new Ta(e,t,t,Ke,yn);this._matricesTexture=n}_initIndirectTexture(){let t=Math.sqrt(this._maxInstanceCount);t=Math.ceil(t);const e=new Uint32Array(t*t),n=new Ta(e,t,t,qo,di);this._indirectTexture=n}_initColorsTexture(){let t=Math.sqrt(this._maxInstanceCount);t=Math.ceil(t);const e=new Float32Array(t*t*4).fill(1),n=new Ta(e,t,t,Ke,yn);n.colorSpace=Jt.workingColorSpace,this._colorsTexture=n}_initializeGeometry(t){const e=this.geometry,n=this._maxVertexCount,r=this._maxIndexCount;if(this._geometryInitialized===!1){for(const s in t.attributes){const a=t.getAttribute(s),{array:o,itemSize:c,normalized:h}=a,f=new o.constructor(n*c),g=new de(f,c,h);e.setAttribute(s,g)}if(t.getIndex()!==null){const s=n>65535?new Uint32Array(r):new Uint16Array(r);e.setIndex(new de(s,1))}this._geometryInitialized=!0}}_validateGeometry(t){const e=this.geometry;if(!!t.getIndex()!=!!e.getIndex())throw new Error('THREE.BatchedMesh: All geometries must consistently have "index".');for(const n in e.attributes){if(!t.hasAttribute(n))throw new Error(`THREE.BatchedMesh: Added geometry missing "${n}". All geometries must have consistent attributes.`);const r=t.getAttribute(n),s=e.getAttribute(n);if(r.itemSize!==s.itemSize||r.normalized!==s.normalized)throw new Error("THREE.BatchedMesh: All attributes must have a consistent itemSize and normalized value.")}}validateInstanceId(t){const e=this._instanceInfo;if(t<0||t>=e.length||e[t].active===!1)throw new Error(`THREE.BatchedMesh: Invalid instanceId ${t}. Instance is either out of range or has been deleted.`)}validateGeometryId(t){const e=this._geometryInfo;if(t<0||t>=e.length||e[t].active===!1)throw new Error(`THREE.BatchedMesh: Invalid geometryId ${t}. Geometry is either out of range or has been deleted.`)}setCustomSort(t){return this.customSort=t,this}computeBoundingBox(){this.boundingBox===null&&(this.boundingBox=new ye);const t=this.boundingBox,e=this._instanceInfo;t.makeEmpty();for(let n=0,r=e.length;n<r;n++){if(e[n].active===!1)continue;const s=e[n].geometryIndex;this.getMatrixAt(n,ke),this.getBoundingBoxAt(s,ks).applyMatrix4(ke),t.union(ks)}}computeBoundingSphere(){this.boundingSphere===null&&(this.boundingSphere=new Rn);const t=this.boundingSphere,e=this._instanceInfo;t.makeEmpty();for(let n=0,r=e.length;n<r;n++){if(e[n].active===!1)continue;const s=e[n].geometryIndex;this.getMatrixAt(n,ke),this.getBoundingSphereAt(s,Mi).applyMatrix4(ke),t.union(Mi)}}addInstance(t){if(this._instanceInfo.length>=this.maxInstanceCount&&this._availableInstanceIds.length===0)throw new Error("THREE.BatchedMesh: Maximum item count reached.");const n={visible:!0,active:!0,geometryIndex:t};let r=null;this._availableInstanceIds.length>0?(this._availableInstanceIds.sort(Aa),r=this._availableInstanceIds.shift(),this._instanceInfo[r]=n):(r=this._instanceInfo.length,this._instanceInfo.push(n));const s=this._matricesTexture;ke.identity().toArray(s.image.data,r*16),s.needsUpdate=!0;const a=this._colorsTexture;return a&&(Lp.toArray(a.image.data,r*4),a.needsUpdate=!0),this._visibilityChanged=!0,r}addGeometry(t,e=-1,n=-1){this._initializeGeometry(t),this._validateGeometry(t);const r={vertexStart:-1,vertexCount:-1,reservedVertexCount:-1,indexStart:-1,indexCount:-1,reservedIndexCount:-1,start:-1,count:-1,boundingBox:null,boundingSphere:null,active:!0},s=this._geometryInfo;r.vertexStart=this._nextVertexStart,r.reservedVertexCount=e===-1?t.getAttribute("position").count:e;const a=t.getIndex();if(a!==null&&(r.indexStart=this._nextIndexStart,r.reservedIndexCount=n===-1?a.count:n),r.indexStart!==-1&&r.indexStart+r.reservedIndexCount>this._maxIndexCount||r.vertexStart+r.reservedVertexCount>this._maxVertexCount)throw new Error("THREE.BatchedMesh: Reserved space request exceeds the maximum buffer size.");let c;return this._availableGeometryIds.length>0?(this._availableGeometryIds.sort(Aa),c=this._availableGeometryIds.shift(),s[c]=r):(c=this._geometryCount,this._geometryCount++,s.push(r)),this.setGeometryAt(c,t),this._nextIndexStart=r.indexStart+r.reservedIndexCount,this._nextVertexStart=r.vertexStart+r.reservedVertexCount,c}setGeometryAt(t,e){if(t>=this._geometryCount)throw new Error("THREE.BatchedMesh: Maximum geometry count reached.");this._validateGeometry(e);const n=this.geometry,r=n.getIndex()!==null,s=n.getIndex(),a=e.getIndex(),o=this._geometryInfo[t];if(r&&a.count>o.reservedIndexCount||e.attributes.position.count>o.reservedVertexCount)throw new Error("THREE.BatchedMesh: Reserved space not large enough for provided geometry.");const c=o.vertexStart,h=o.reservedVertexCount;o.vertexCount=e.getAttribute("position").count;for(const f in n.attributes){const g=e.getAttribute(f),p=n.getAttribute(f);Np(g,p,c);const _=g.itemSize;for(let M=g.count,b=h;M<b;M++){const x=c+M;for(let m=0;m<_;m++)p.setComponent(x,m,0)}p.needsUpdate=!0,p.addUpdateRange(c*_,h*_)}if(r){const f=o.indexStart,g=o.reservedIndexCount;o.indexCount=e.getIndex().count;for(let p=0;p<a.count;p++)s.setX(f+p,c+a.getX(p));for(let p=a.count,_=g;p<_;p++)s.setX(f+p,c);s.needsUpdate=!0,s.addUpdateRange(f,o.reservedIndexCount)}return o.start=r?o.indexStart:o.vertexStart,o.count=r?o.indexCount:o.vertexCount,o.boundingBox=null,e.boundingBox!==null&&(o.boundingBox=e.boundingBox.clone()),o.boundingSphere=null,e.boundingSphere!==null&&(o.boundingSphere=e.boundingSphere.clone()),this._visibilityChanged=!0,t}deleteGeometry(t){const e=this._geometryInfo;if(t>=e.length||e[t].active===!1)return this;const n=this._instanceInfo;for(let r=0,s=n.length;r<s;r++)n[r].active&&n[r].geometryIndex===t&&this.deleteInstance(r);return e[t].active=!1,this._availableGeometryIds.push(t),this._visibilityChanged=!0,this}deleteInstance(t){return this.validateInstanceId(t),this._instanceInfo[t].active=!1,this._availableInstanceIds.push(t),this._visibilityChanged=!0,this}optimize(){let t=0,e=0;const n=this._geometryInfo,r=n.map((a,o)=>o).sort((a,o)=>n[a].vertexStart-n[o].vertexStart),s=this.geometry;for(let a=0,o=n.length;a<o;a++){const c=r[a],h=n[c];if(h.active!==!1){if(s.index!==null){if(h.indexStart!==e){const{indexStart:f,vertexStart:g,reservedIndexCount:p}=h,_=s.index,M=_.array,b=t-g;for(let x=f;x<f+p;x++)M[x]=M[x]+b;_.array.copyWithin(e,f,f+p),_.addUpdateRange(e,p),h.indexStart=e}e+=h.reservedIndexCount}if(h.vertexStart!==t){const{vertexStart:f,reservedVertexCount:g}=h,p=s.attributes;for(const _ in p){const M=p[_],{array:b,itemSize:x}=M;b.copyWithin(t*x,f*x,(f+g)*x),M.addUpdateRange(t*x,g*x)}h.vertexStart=t}t+=h.reservedVertexCount,h.start=s.index?h.indexStart:h.vertexStart,this._nextIndexStart=s.index?h.indexStart+h.reservedIndexCount:0,this._nextVertexStart=h.vertexStart+h.reservedVertexCount}}return this}getBoundingBoxAt(t,e){if(t>=this._geometryCount)return null;const n=this.geometry,r=this._geometryInfo[t];if(r.boundingBox===null){const s=new ye,a=n.index,o=n.attributes.position;for(let c=r.start,h=r.start+r.count;c<h;c++){let f=c;a&&(f=a.getX(f)),s.expandByPoint(Gr.fromBufferAttribute(o,f))}r.boundingBox=s}return e.copy(r.boundingBox),e}getBoundingSphereAt(t,e){if(t>=this._geometryCount)return null;const n=this.geometry,r=this._geometryInfo[t];if(r.boundingSphere===null){const s=new Rn;this.getBoundingBoxAt(t,ks),ks.getCenter(s.center);const a=n.index,o=n.attributes.position;let c=0;for(let h=r.start,f=r.start+r.count;h<f;h++){let g=h;a&&(g=a.getX(g)),Gr.fromBufferAttribute(o,g),c=Math.max(c,s.center.distanceToSquared(Gr))}s.radius=Math.sqrt(c),r.boundingSphere=s}return e.copy(r.boundingSphere),e}setMatrixAt(t,e){this.validateInstanceId(t);const n=this._matricesTexture,r=this._matricesTexture.image.data;return e.toArray(r,t*16),n.needsUpdate=!0,this}getMatrixAt(t,e){return this.validateInstanceId(t),e.fromArray(this._matricesTexture.image.data,t*16)}setColorAt(t,e){return this.validateInstanceId(t),this._colorsTexture===null&&this._initColorsTexture(),e.toArray(this._colorsTexture.image.data,t*4),this._colorsTexture.needsUpdate=!0,this}getColorAt(t,e){return this.validateInstanceId(t),e.fromArray(this._colorsTexture.image.data,t*4)}setVisibleAt(t,e){return this.validateInstanceId(t),this._instanceInfo[t].visible===e?this:(this._instanceInfo[t].visible=e,this._visibilityChanged=!0,this)}getVisibleAt(t){return this.validateInstanceId(t),this._instanceInfo[t].visible}setGeometryIdAt(t,e){return this.validateInstanceId(t),this.validateGeometryId(e),this._instanceInfo[t].geometryIndex=e,this}getGeometryIdAt(t){return this.validateInstanceId(t),this._instanceInfo[t].geometryIndex}getGeometryRangeAt(t,e={}){this.validateGeometryId(t);const n=this._geometryInfo[t];return e.vertexStart=n.vertexStart,e.vertexCount=n.vertexCount,e.reservedVertexCount=n.reservedVertexCount,e.indexStart=n.indexStart,e.indexCount=n.indexCount,e.reservedIndexCount=n.reservedIndexCount,e.start=n.start,e.count=n.count,e}setInstanceCount(t){const e=this._availableInstanceIds,n=this._instanceInfo;for(e.sort(Aa);e[e.length-1]===n.length;)n.pop(),e.pop();if(t<n.length)throw new Error(`BatchedMesh: Instance ids outside the range ${t} are being used. Cannot shrink instance count.`);const r=new Int32Array(t),s=new Int32Array(t);Ei(this._multiDrawCounts,r),Ei(this._multiDrawStarts,s),this._multiDrawCounts=r,this._multiDrawStarts=s,this._maxInstanceCount=t;const a=this._indirectTexture,o=this._matricesTexture,c=this._colorsTexture;a.dispose(),this._initIndirectTexture(),Ei(a.image.data,this._indirectTexture.image.data),o.dispose(),this._initMatricesTexture(),Ei(o.image.data,this._matricesTexture.image.data),c&&(c.dispose(),this._initColorsTexture(),Ei(c.image.data,this._colorsTexture.image.data))}setGeometrySize(t,e){const n=[...this._geometryInfo].filter(o=>o.active);if(Math.max(...n.map(o=>o.vertexStart+o.reservedVertexCount))>t)throw new Error(`BatchedMesh: Geometry vertex values are being used outside the range ${e}. Cannot shrink further.`);if(this.geometry.index&&Math.max(...n.map(c=>c.indexStart+c.reservedIndexCount))>e)throw new Error(`BatchedMesh: Geometry index values are being used outside the range ${e}. Cannot shrink further.`);const s=this.geometry;s.dispose(),this._maxVertexCount=t,this._maxIndexCount=e,this._geometryInitialized&&(this._geometryInitialized=!1,this.geometry=new De,this._initializeGeometry(s));const a=this.geometry;s.index&&Ei(s.index.array,a.index.array);for(const o in s.attributes)Ei(s.attributes[o].array,a.attributes[o].array)}raycast(t,e){const n=this._instanceInfo,r=this._geometryInfo,s=this.matrixWorld,a=this.geometry;Pe.material=this.material,Pe.geometry.index=a.index,Pe.geometry.attributes=a.attributes,Pe.geometry.boundingBox===null&&(Pe.geometry.boundingBox=new ye),Pe.geometry.boundingSphere===null&&(Pe.geometry.boundingSphere=new Rn);for(let o=0,c=n.length;o<c;o++){if(!n[o].visible||!n[o].active)continue;const h=n[o].geometryIndex,f=r[h];Pe.geometry.setDrawRange(f.start,f.count),this.getMatrixAt(o,Pe.matrixWorld).premultiply(s),this.getBoundingBoxAt(h,Pe.geometry.boundingBox),this.getBoundingSphereAt(h,Pe.geometry.boundingSphere),Pe.raycast(t,Ws);for(let g=0,p=Ws.length;g<p;g++){const _=Ws[g];_.object=this,_.batchId=o,e.push(_)}Ws.length=0}Pe.material=null,Pe.geometry.index=null,Pe.geometry.attributes={},Pe.geometry.setDrawRange(0,1/0)}copy(t){return super.copy(t),this.geometry=t.geometry.clone(),this.perObjectFrustumCulled=t.perObjectFrustumCulled,this.sortObjects=t.sortObjects,this.boundingBox=t.boundingBox!==null?t.boundingBox.clone():null,this.boundingSphere=t.boundingSphere!==null?t.boundingSphere.clone():null,this._geometryInfo=t._geometryInfo.map(e=>({...e,boundingBox:e.boundingBox!==null?e.boundingBox.clone():null,boundingSphere:e.boundingSphere!==null?e.boundingSphere.clone():null})),this._instanceInfo=t._instanceInfo.map(e=>({...e})),this._availableInstanceIds=t._availableInstanceIds.slice(),this._availableGeometryIds=t._availableGeometryIds.slice(),this._nextIndexStart=t._nextIndexStart,this._nextVertexStart=t._nextVertexStart,this._geometryCount=t._geometryCount,this._maxInstanceCount=t._maxInstanceCount,this._maxVertexCount=t._maxVertexCount,this._maxIndexCount=t._maxIndexCount,this._geometryInitialized=t._geometryInitialized,this._multiDrawCounts=t._multiDrawCounts.slice(),this._multiDrawStarts=t._multiDrawStarts.slice(),this._indirectTexture=t._indirectTexture.clone(),this._indirectTexture.image.data=this._indirectTexture.image.data.slice(),this._matricesTexture=t._matricesTexture.clone(),this._matricesTexture.image.data=this._matricesTexture.image.data.slice(),this._colorsTexture!==null&&(this._colorsTexture=t._colorsTexture.clone(),this._colorsTexture.image.data=this._colorsTexture.image.data.slice()),this}dispose(){this.geometry.dispose(),this._matricesTexture.dispose(),this._matricesTexture=null,this._indirectTexture.dispose(),this._indirectTexture=null,this._colorsTexture!==null&&(this._colorsTexture.dispose(),this._colorsTexture=null)}onBeforeRender(t,e,n,r,s){if(!this._visibilityChanged&&!this.perObjectFrustumCulled&&!this.sortObjects)return;const a=r.getIndex(),o=a===null?1:a.array.BYTES_PER_ELEMENT,c=this._instanceInfo,h=this._multiDrawStarts,f=this._multiDrawCounts,g=this._geometryInfo,p=this.perObjectFrustumCulled,_=this._indirectTexture,M=_.image.data,b=n.isArrayCamera?Dp:vu;p&&!n.isArrayCamera&&(ke.multiplyMatrices(n.projectionMatrix,n.matrixWorldInverse).multiply(this.matrixWorld),vu.setFromProjectionMatrix(ke,t.coordinateSystem));let x=0;if(this.sortObjects){ke.copy(this.matrixWorld).invert(),Gr.setFromMatrixPosition(n.matrixWorld).applyMatrix4(ke),yu.set(0,0,-1).transformDirection(n.matrixWorld).transformDirection(ke);for(let u=0,v=c.length;u<v;u++)if(c[u].visible&&c[u].active){const l=c[u].geometryIndex;this.getMatrixAt(u,ke),this.getBoundingSphereAt(l,Mi).applyMatrix4(ke);let R=!1;if(p&&(R=!b.intersectsSphere(Mi,n)),!R){const T=g[l],E=Up.subVectors(Mi.center,Gr).dot(yu);wa.push(T.start,T.count,E,u)}}const m=wa.list,d=this.customSort;d===null?m.sort(s.transparent?Pp:Cp):d.call(this,m,n);for(let u=0,v=m.length;u<v;u++){const l=m[u];h[x]=l.start*o,f[x]=l.count,M[x]=l.index,x++}wa.reset()}else for(let m=0,d=c.length;m<d;m++)if(c[m].visible&&c[m].active){const u=c[m].geometryIndex;let v=!1;if(p&&(this.getMatrixAt(m,ke),this.getBoundingSphereAt(u,Mi).applyMatrix4(ke),v=!b.intersectsSphere(Mi,n)),!v){const l=g[u];h[x]=l.start*o,f[x]=l.count,M[x]=m,x++}}_.needsUpdate=!0,this._multiDrawCount=x,this._visibilityChanged=!1}onBeforeShadow(t,e,n,r,s,a){this.onBeforeRender(t,null,r,s,a)}}class Sf extends Dr{constructor(t){super(),this.isLineBasicMaterial=!0,this.type="LineBasicMaterial",this.color=new qt(16777215),this.map=null,this.linewidth=1,this.linecap="round",this.linejoin="round",this.fog=!0,this.setValues(t)}copy(t){return super.copy(t),this.color.copy(t.color),this.map=t.map,this.linewidth=t.linewidth,this.linecap=t.linecap,this.linejoin=t.linejoin,this.fog=t.fog,this}}const zo=new U,Vo=new U,Su=new $t,kr=new Lr,Xs=new Rn,Ra=new U,Mu=new U;class Fp extends we{constructor(t=new De,e=new Sf){super(),this.isLine=!0,this.type="Line",this.geometry=t,this.material=e,this.morphTargetDictionary=void 0,this.morphTargetInfluences=void 0,this.updateMorphTargets()}copy(t,e){return super.copy(t,e),this.material=Array.isArray(t.material)?t.material.slice():t.material,this.geometry=t.geometry,this}computeLineDistances(){const t=this.geometry;if(t.index===null){const e=t.attributes.position,n=[0];for(let r=1,s=e.count;r<s;r++)zo.fromBufferAttribute(e,r-1),Vo.fromBufferAttribute(e,r),n[r]=n[r-1],n[r]+=zo.distanceTo(Vo);t.setAttribute("lineDistance",new Cn(n,1))}else console.warn("THREE.Line.computeLineDistances(): Computation only possible with non-indexed BufferGeometry.");return this}raycast(t,e){const n=this.geometry,r=this.matrixWorld,s=t.params.Line.threshold,a=n.drawRange;if(n.boundingSphere===null&&n.computeBoundingSphere(),Xs.copy(n.boundingSphere),Xs.applyMatrix4(r),Xs.radius+=s,t.ray.intersectsSphere(Xs)===!1)return;Su.copy(r).invert(),kr.copy(t.ray).applyMatrix4(Su);const o=s/((this.scale.x+this.scale.y+this.scale.z)/3),c=o*o,h=this.isLineSegments?2:1,f=n.index,p=n.attributes.position;if(f!==null){const _=Math.max(0,a.start),M=Math.min(f.count,a.start+a.count);for(let b=_,x=M-1;b<x;b+=h){const m=f.getX(b),d=f.getX(b+1),u=qs(this,t,kr,c,m,d,b);u&&e.push(u)}if(this.isLineLoop){const b=f.getX(M-1),x=f.getX(_),m=qs(this,t,kr,c,b,x,M-1);m&&e.push(m)}}else{const _=Math.max(0,a.start),M=Math.min(p.count,a.start+a.count);for(let b=_,x=M-1;b<x;b+=h){const m=qs(this,t,kr,c,b,b+1,b);m&&e.push(m)}if(this.isLineLoop){const b=qs(this,t,kr,c,M-1,_,M-1);b&&e.push(b)}}}updateMorphTargets(){const e=this.geometry.morphAttributes,n=Object.keys(e);if(n.length>0){const r=e[n[0]];if(r!==void 0){this.morphTargetInfluences=[],this.morphTargetDictionary={};for(let s=0,a=r.length;s<a;s++){const o=r[s].name||String(s);this.morphTargetInfluences.push(0),this.morphTargetDictionary[o]=s}}}}}function qs(i,t,e,n,r,s,a){const o=i.geometry.attributes.position;if(zo.fromBufferAttribute(o,r),Vo.fromBufferAttribute(o,s),e.distanceSqToSegment(zo,Vo,Ra,Mu)>n)return;Ra.applyMatrix4(i.matrixWorld);const h=t.ray.origin.distanceTo(Ra);if(!(h<t.near||h>t.far))return{distance:h,point:Mu.clone().applyMatrix4(i.matrixWorld),index:a,face:null,faceIndex:null,barycoord:null,object:i}}const Eu=new U,Tu=new U;class Bp extends Fp{constructor(t,e){super(t,e),this.isLineSegments=!0,this.type="LineSegments"}computeLineDistances(){const t=this.geometry;if(t.index===null){const e=t.attributes.position,n=[];for(let r=0,s=e.count;r<s;r+=2)Eu.fromBufferAttribute(e,r),Tu.fromBufferAttribute(e,r+1),n[r]=r===0?0:n[r-1],n[r+1]=n[r]+Eu.distanceTo(Tu);t.setAttribute("lineDistance",new Cn(n,1))}else console.warn("THREE.LineSegments.computeLineDistances(): Computation only possible with non-indexed BufferGeometry.");return this}}class Op extends Le{constructor(t,e,n,r,s,a,o,c,h){super(t,e,n,r,s,a,o,c,h),this.isCanvasTexture=!0,this.needsUpdate=!0}}class Mf extends Le{constructor(t,e,n=di,r,s,a,o=Je,c=Je,h,f=hs,g=1){if(f!==hs&&f!==fs)throw new Error("DepthTexture format must be either THREE.DepthFormat or THREE.DepthStencilFormat");const p={width:t,height:e,depth:g};super(p,r,s,a,o,c,f,n,h),this.isDepthTexture=!0,this.flipY=!1,this.generateMipmaps=!1,this.compareFunction=null}copy(t){return super.copy(t),this.source=new Rl(Object.assign({},t.image)),this.compareFunction=t.compareFunction,this}toJSON(t){const e=super.toJSON(t);return this.compareFunction!==null&&(e.compareFunction=this.compareFunction),e}}class Ms extends De{constructor(t=1,e=1,n=1,r=1){super(),this.type="PlaneGeometry",this.parameters={width:t,height:e,widthSegments:n,heightSegments:r};const s=t/2,a=e/2,o=Math.floor(n),c=Math.floor(r),h=o+1,f=c+1,g=t/o,p=e/c,_=[],M=[],b=[],x=[];for(let m=0;m<f;m++){const d=m*p-a;for(let u=0;u<h;u++){const v=u*g-s;M.push(v,-d,0),b.push(0,0,1),x.push(u/o),x.push(1-m/c)}}for(let m=0;m<c;m++)for(let d=0;d<o;d++){const u=d+h*m,v=d+h*(m+1),l=d+1+h*(m+1),R=d+1+h*m;_.push(u,v,R),_.push(v,l,R)}this.setIndex(_),this.setAttribute("position",new Cn(M,3)),this.setAttribute("normal",new Cn(b,3)),this.setAttribute("uv",new Cn(x,2))}copy(t){return super.copy(t),this.parameters=Object.assign({},t.parameters),this}static fromJSON(t){return new Ms(t.width,t.height,t.widthSegments,t.heightSegments)}}class Ef extends Dr{constructor(t){super(),this.isMeshStandardMaterial=!0,this.type="MeshStandardMaterial",this.defines={STANDARD:""},this.color=new qt(16777215),this.roughness=1,this.metalness=0,this.map=null,this.lightMap=null,this.lightMapIntensity=1,this.aoMap=null,this.aoMapIntensity=1,this.emissive=new qt(0),this.emissiveIntensity=1,this.emissiveMap=null,this.bumpMap=null,this.bumpScale=1,this.normalMap=null,this.normalMapType=uf,this.normalScale=new kt(1,1),this.displacementMap=null,this.displacementScale=1,this.displacementBias=0,this.roughnessMap=null,this.metalnessMap=null,this.alphaMap=null,this.envMap=null,this.envMapRotation=new Dn,this.envMapIntensity=1,this.wireframe=!1,this.wireframeLinewidth=1,this.wireframeLinecap="round",this.wireframeLinejoin="round",this.flatShading=!1,this.fog=!0,this.setValues(t)}copy(t){return super.copy(t),this.defines={STANDARD:""},this.color.copy(t.color),this.roughness=t.roughness,this.metalness=t.metalness,this.map=t.map,this.lightMap=t.lightMap,this.lightMapIntensity=t.lightMapIntensity,this.aoMap=t.aoMap,this.aoMapIntensity=t.aoMapIntensity,this.emissive.copy(t.emissive),this.emissiveMap=t.emissiveMap,this.emissiveIntensity=t.emissiveIntensity,this.bumpMap=t.bumpMap,this.bumpScale=t.bumpScale,this.normalMap=t.normalMap,this.normalMapType=t.normalMapType,this.normalScale.copy(t.normalScale),this.displacementMap=t.displacementMap,this.displacementScale=t.displacementScale,this.displacementBias=t.displacementBias,this.roughnessMap=t.roughnessMap,this.metalnessMap=t.metalnessMap,this.alphaMap=t.alphaMap,this.envMap=t.envMap,this.envMapRotation.copy(t.envMapRotation),this.envMapIntensity=t.envMapIntensity,this.wireframe=t.wireframe,this.wireframeLinewidth=t.wireframeLinewidth,this.wireframeLinecap=t.wireframeLinecap,this.wireframeLinejoin=t.wireframeLinejoin,this.flatShading=t.flatShading,this.fog=t.fog,this}}class Tf extends Ef{constructor(t){super(),this.isMeshPhysicalMaterial=!0,this.defines={STANDARD:"",PHYSICAL:""},this.type="MeshPhysicalMaterial",this.anisotropyRotation=0,this.anisotropyMap=null,this.clearcoatMap=null,this.clearcoatRoughness=0,this.clearcoatRoughnessMap=null,this.clearcoatNormalScale=new kt(1,1),this.clearcoatNormalMap=null,this.ior=1.5,Object.defineProperty(this,"reflectivity",{get:function(){return Yt(2.5*(this.ior-1)/(this.ior+1),0,1)},set:function(e){this.ior=(1+.4*e)/(1-.4*e)}}),this.iridescenceMap=null,this.iridescenceIOR=1.3,this.iridescenceThicknessRange=[100,400],this.iridescenceThicknessMap=null,this.sheenColor=new qt(0),this.sheenColorMap=null,this.sheenRoughness=1,this.sheenRoughnessMap=null,this.transmissionMap=null,this.thickness=0,this.thicknessMap=null,this.attenuationDistance=1/0,this.attenuationColor=new qt(1,1,1),this.specularIntensity=1,this.specularIntensityMap=null,this.specularColor=new qt(1,1,1),this.specularColorMap=null,this._anisotropy=0,this._clearcoat=0,this._dispersion=0,this._iridescence=0,this._sheen=0,this._transmission=0,this.setValues(t)}get anisotropy(){return this._anisotropy}set anisotropy(t){this._anisotropy>0!=t>0&&this.version++,this._anisotropy=t}get clearcoat(){return this._clearcoat}set clearcoat(t){this._clearcoat>0!=t>0&&this.version++,this._clearcoat=t}get iridescence(){return this._iridescence}set iridescence(t){this._iridescence>0!=t>0&&this.version++,this._iridescence=t}get dispersion(){return this._dispersion}set dispersion(t){this._dispersion>0!=t>0&&this.version++,this._dispersion=t}get sheen(){return this._sheen}set sheen(t){this._sheen>0!=t>0&&this.version++,this._sheen=t}get transmission(){return this._transmission}set transmission(t){this._transmission>0!=t>0&&this.version++,this._transmission=t}copy(t){return super.copy(t),this.defines={STANDARD:"",PHYSICAL:""},this.anisotropy=t.anisotropy,this.anisotropyRotation=t.anisotropyRotation,this.anisotropyMap=t.anisotropyMap,this.clearcoat=t.clearcoat,this.clearcoatMap=t.clearcoatMap,this.clearcoatRoughness=t.clearcoatRoughness,this.clearcoatRoughnessMap=t.clearcoatRoughnessMap,this.clearcoatNormalMap=t.clearcoatNormalMap,this.clearcoatNormalScale.copy(t.clearcoatNormalScale),this.dispersion=t.dispersion,this.ior=t.ior,this.iridescence=t.iridescence,this.iridescenceMap=t.iridescenceMap,this.iridescenceIOR=t.iridescenceIOR,this.iridescenceThicknessRange=[...t.iridescenceThicknessRange],this.iridescenceThicknessMap=t.iridescenceThicknessMap,this.sheen=t.sheen,this.sheenColor.copy(t.sheenColor),this.sheenColorMap=t.sheenColorMap,this.sheenRoughness=t.sheenRoughness,this.sheenRoughnessMap=t.sheenRoughnessMap,this.transmission=t.transmission,this.transmissionMap=t.transmissionMap,this.thickness=t.thickness,this.thicknessMap=t.thicknessMap,this.attenuationDistance=t.attenuationDistance,this.attenuationColor.copy(t.attenuationColor),this.specularIntensity=t.specularIntensity,this.specularIntensityMap=t.specularIntensityMap,this.specularColor.copy(t.specularColor),this.specularColorMap=t.specularColorMap,this}}class zp extends Dr{constructor(t){super(),this.isMeshDepthMaterial=!0,this.type="MeshDepthMaterial",this.depthPacking=Hd,this.map=null,this.alphaMap=null,this.displacementMap=null,this.displacementScale=1,this.displacementBias=0,this.wireframe=!1,this.wireframeLinewidth=1,this.setValues(t)}copy(t){return super.copy(t),this.depthPacking=t.depthPacking,this.map=t.map,this.alphaMap=t.alphaMap,this.displacementMap=t.displacementMap,this.displacementScale=t.displacementScale,this.displacementBias=t.displacementBias,this.wireframe=t.wireframe,this.wireframeLinewidth=t.wireframeLinewidth,this}}class Vp extends Dr{constructor(t){super(),this.isMeshDistanceMaterial=!0,this.type="MeshDistanceMaterial",this.map=null,this.alphaMap=null,this.displacementMap=null,this.displacementScale=1,this.displacementBias=0,this.setValues(t)}copy(t){return super.copy(t),this.map=t.map,this.alphaMap=t.alphaMap,this.displacementMap=t.displacementMap,this.displacementScale=t.displacementScale,this.displacementBias=t.displacementBias,this}}class bf extends we{constructor(t,e=1){super(),this.isLight=!0,this.type="Light",this.color=new qt(t),this.intensity=e}dispose(){}copy(t,e){return super.copy(t,e),this.color.copy(t.color),this.intensity=t.intensity,this}toJSON(t){const e=super.toJSON(t);return e.object.color=this.color.getHex(),e.object.intensity=this.intensity,this.groundColor!==void 0&&(e.object.groundColor=this.groundColor.getHex()),this.distance!==void 0&&(e.object.distance=this.distance),this.angle!==void 0&&(e.object.angle=this.angle),this.decay!==void 0&&(e.object.decay=this.decay),this.penumbra!==void 0&&(e.object.penumbra=this.penumbra),this.shadow!==void 0&&(e.object.shadow=this.shadow.toJSON()),this.target!==void 0&&(e.object.target=this.target.uuid),e}}const Ca=new $t,bu=new U,Au=new U;class Hp{constructor(t){this.camera=t,this.intensity=1,this.bias=0,this.normalBias=0,this.radius=1,this.blurSamples=8,this.mapSize=new kt(512,512),this.mapType=Ln,this.map=null,this.mapPass=null,this.matrix=new $t,this.autoUpdate=!0,this.needsUpdate=!1,this._frustum=new Ss,this._frameExtents=new kt(1,1),this._viewportCount=1,this._viewports=[new ie(0,0,1,1)]}getViewportCount(){return this._viewportCount}getFrustum(){return this._frustum}updateMatrices(t){const e=this.camera,n=this.matrix;bu.setFromMatrixPosition(t.matrixWorld),e.position.copy(bu),Au.setFromMatrixPosition(t.target.matrixWorld),e.lookAt(Au),e.updateMatrixWorld(),Ca.multiplyMatrices(e.projectionMatrix,e.matrixWorldInverse),this._frustum.setFromProjectionMatrix(Ca),n.set(.5,0,0,.5,0,.5,0,.5,0,0,.5,.5,0,0,0,1),n.multiply(Ca)}getViewport(t){return this._viewports[t]}getFrameExtents(){return this._frameExtents}dispose(){this.map&&this.map.dispose(),this.mapPass&&this.mapPass.dispose()}copy(t){return this.camera=t.camera.clone(),this.intensity=t.intensity,this.bias=t.bias,this.radius=t.radius,this.autoUpdate=t.autoUpdate,this.needsUpdate=t.needsUpdate,this.normalBias=t.normalBias,this.blurSamples=t.blurSamples,this.mapSize.copy(t.mapSize),this}clone(){return new this.constructor().copy(this)}toJSON(){const t={};return this.intensity!==1&&(t.intensity=this.intensity),this.bias!==0&&(t.bias=this.bias),this.normalBias!==0&&(t.normalBias=this.normalBias),this.radius!==1&&(t.radius=this.radius),(this.mapSize.x!==512||this.mapSize.y!==512)&&(t.mapSize=this.mapSize.toArray()),t.camera=this.camera.toJSON(!1).object,delete t.camera.matrix,t}}class Af extends vf{constructor(t=-1,e=1,n=1,r=-1,s=.1,a=2e3){super(),this.isOrthographicCamera=!0,this.type="OrthographicCamera",this.zoom=1,this.view=null,this.left=t,this.right=e,this.top=n,this.bottom=r,this.near=s,this.far=a,this.updateProjectionMatrix()}copy(t,e){return super.copy(t,e),this.left=t.left,this.right=t.right,this.top=t.top,this.bottom=t.bottom,this.near=t.near,this.far=t.far,this.zoom=t.zoom,this.view=t.view===null?null:Object.assign({},t.view),this}setViewOffset(t,e,n,r,s,a){this.view===null&&(this.view={enabled:!0,fullWidth:1,fullHeight:1,offsetX:0,offsetY:0,width:1,height:1}),this.view.enabled=!0,this.view.fullWidth=t,this.view.fullHeight=e,this.view.offsetX=n,this.view.offsetY=r,this.view.width=s,this.view.height=a,this.updateProjectionMatrix()}clearViewOffset(){this.view!==null&&(this.view.enabled=!1),this.updateProjectionMatrix()}updateProjectionMatrix(){const t=(this.right-this.left)/(2*this.zoom),e=(this.top-this.bottom)/(2*this.zoom),n=(this.right+this.left)/2,r=(this.top+this.bottom)/2;let s=n-t,a=n+t,o=r+e,c=r-e;if(this.view!==null&&this.view.enabled){const h=(this.right-this.left)/this.view.fullWidth/this.zoom,f=(this.top-this.bottom)/this.view.fullHeight/this.zoom;s+=h*this.view.offsetX,a=s+h*this.view.width,o-=f*this.view.offsetY,c=o-f*this.view.height}this.projectionMatrix.makeOrthographic(s,a,o,c,this.near,this.far,this.coordinateSystem),this.projectionMatrixInverse.copy(this.projectionMatrix).invert()}toJSON(t){const e=super.toJSON(t);return e.object.zoom=this.zoom,e.object.left=this.left,e.object.right=this.right,e.object.top=this.top,e.object.bottom=this.bottom,e.object.near=this.near,e.object.far=this.far,this.view!==null&&(e.object.view=Object.assign({},this.view)),e}}class Gp extends Hp{constructor(){super(new Af(-5,5,5,-5,.5,500)),this.isDirectionalLightShadow=!0}}class kp extends bf{constructor(t,e){super(t,e),this.isDirectionalLight=!0,this.type="DirectionalLight",this.position.copy(we.DEFAULT_UP),this.updateMatrix(),this.target=new we,this.shadow=new Gp}dispose(){this.shadow.dispose()}copy(t){return super.copy(t),this.target=t.target.clone(),this.shadow=t.shadow.clone(),this}}class Wp extends bf{constructor(t,e){super(t,e),this.isAmbientLight=!0,this.type="AmbientLight"}}class Xp extends sn{constructor(t=[]){super(),this.isArrayCamera=!0,this.isMultiViewCamera=!1,this.cameras=t}}const wu=new $t;class qp{constructor(t,e,n=0,r=1/0){this.ray=new Lr(t,e),this.near=n,this.far=r,this.camera=null,this.layers=new Cl,this.params={Mesh:{},Line:{threshold:1},LOD:{},Points:{threshold:1},Sprite:{}}}set(t,e){this.ray.set(t,e)}setFromCamera(t,e){e.isPerspectiveCamera?(this.ray.origin.setFromMatrixPosition(e.matrixWorld),this.ray.direction.set(t.x,t.y,.5).unproject(e).sub(this.ray.origin).normalize(),this.camera=e):e.isOrthographicCamera?(this.ray.origin.set(t.x,t.y,(e.near+e.far)/(e.near-e.far)).unproject(e),this.ray.direction.set(0,0,-1).transformDirection(e.matrixWorld),this.camera=e):console.error("THREE.Raycaster: Unsupported camera type: "+e.type)}setFromXRController(t){return wu.identity().extractRotation(t.matrixWorld),this.ray.origin.setFromMatrixPosition(t.matrixWorld),this.ray.direction.set(0,0,-1).applyMatrix4(wu),this}intersectObject(t,e=!0,n=[]){return ll(t,this,n,e),n.sort(Ru),n}intersectObjects(t,e=!0,n=[]){for(let r=0,s=t.length;r<s;r++)ll(t[r],this,n,e);return n.sort(Ru),n}}function Ru(i,t){return i.distance-t.distance}function ll(i,t,e,n){let r=!0;if(i.layers.test(t.layers)&&i.raycast(t,e)===!1&&(r=!1),r===!0&&n===!0){const s=i.children;for(let a=0,o=s.length;a<o;a++)ll(s[a],t,e,!0)}}const Cu=new U,Ys=new U;class un{constructor(t=new U,e=new U){this.start=t,this.end=e}set(t,e){return this.start.copy(t),this.end.copy(e),this}copy(t){return this.start.copy(t.start),this.end.copy(t.end),this}getCenter(t){return t.addVectors(this.start,this.end).multiplyScalar(.5)}delta(t){return t.subVectors(this.end,this.start)}distanceSq(){return this.start.distanceToSquared(this.end)}distance(){return this.start.distanceTo(this.end)}at(t,e){return this.delta(e).multiplyScalar(t).add(this.start)}closestPointToPointParameter(t,e){Cu.subVectors(t,this.start),Ys.subVectors(this.end,this.start);const n=Ys.dot(Ys);let s=Ys.dot(Cu)/n;return e&&(s=Yt(s,0,1)),s}closestPointToPoint(t,e,n){const r=this.closestPointToPointParameter(t,e);return this.delta(n).multiplyScalar(r).add(this.start)}applyMatrix4(t){return this.start.applyMatrix4(t),this.end.applyMatrix4(t),this}equals(t){return t.start.equals(this.start)&&t.end.equals(this.end)}clone(){return new this.constructor().copy(this)}}function Pu(i,t,e,n){const r=Yp(n);switch(e){case sf:return i*t;case af:return i*t/r.components*r.byteLength;case qo:return i*t/r.components*r.byteLength;case cf:return i*t*2/r.components*r.byteLength;case Al:return i*t*2/r.components*r.byteLength;case of:return i*t*3/r.components*r.byteLength;case Ke:return i*t*4/r.components*r.byteLength;case wl:return i*t*4/r.components*r.byteLength;case yo:case So:return Math.floor((i+3)/4)*Math.floor((t+3)/4)*8;case Mo:case Eo:return Math.floor((i+3)/4)*Math.floor((t+3)/4)*16;case Bc:case zc:return Math.max(i,16)*Math.max(t,8)/4;case Fc:case Oc:return Math.max(i,8)*Math.max(t,8)/2;case Vc:case Hc:return Math.floor((i+3)/4)*Math.floor((t+3)/4)*8;case Gc:return Math.floor((i+3)/4)*Math.floor((t+3)/4)*16;case kc:return Math.floor((i+3)/4)*Math.floor((t+3)/4)*16;case Wc:return Math.floor((i+4)/5)*Math.floor((t+3)/4)*16;case Xc:return Math.floor((i+4)/5)*Math.floor((t+4)/5)*16;case qc:return Math.floor((i+5)/6)*Math.floor((t+4)/5)*16;case Yc:return Math.floor((i+5)/6)*Math.floor((t+5)/6)*16;case $c:return Math.floor((i+7)/8)*Math.floor((t+4)/5)*16;case jc:return Math.floor((i+7)/8)*Math.floor((t+5)/6)*16;case Kc:return Math.floor((i+7)/8)*Math.floor((t+7)/8)*16;case Zc:return Math.floor((i+9)/10)*Math.floor((t+4)/5)*16;case Jc:return Math.floor((i+9)/10)*Math.floor((t+5)/6)*16;case Qc:return Math.floor((i+9)/10)*Math.floor((t+7)/8)*16;case tl:return Math.floor((i+9)/10)*Math.floor((t+9)/10)*16;case el:return Math.floor((i+11)/12)*Math.floor((t+9)/10)*16;case nl:return Math.floor((i+11)/12)*Math.floor((t+11)/12)*16;case To:case il:case rl:return Math.ceil(i/4)*Math.ceil(t/4)*16;case lf:case sl:return Math.ceil(i/4)*Math.ceil(t/4)*8;case ol:case al:return Math.ceil(i/4)*Math.ceil(t/4)*16}throw new Error(`Unable to determine texture byte length for ${e} format.`)}function Yp(i){switch(i){case Ln:case ef:return{byteLength:1,components:1};case ls:case nf:case _s:return{byteLength:2,components:1};case Tl:case bl:return{byteLength:2,components:4};case di:case El:case yn:return{byteLength:4,components:1};case rf:return{byteLength:4,components:3}}throw new Error(`Unknown texture type ${i}.`)}typeof __THREE_DEVTOOLS__<"u"&&__THREE_DEVTOOLS__.dispatchEvent(new CustomEvent("register",{detail:{revision:ms}}));typeof window<"u"&&(window.__THREE__?console.warn("WARNING: Multiple instances of Three.js being imported."):window.__THREE__=ms);/**
 * @license
 * Copyright 2010-2025 Three.js Authors
 * SPDX-License-Identifier: MIT
 */function wf(){let i=null,t=!1,e=null,n=null;function r(s,a){e(s,a),n=i.requestAnimationFrame(r)}return{start:function(){t!==!0&&e!==null&&(n=i.requestAnimationFrame(r),t=!0)},stop:function(){i.cancelAnimationFrame(n),t=!1},setAnimationLoop:function(s){e=s},setContext:function(s){i=s}}}function $p(i){const t=new WeakMap;function e(o,c){const h=o.array,f=o.usage,g=h.byteLength,p=i.createBuffer();i.bindBuffer(c,p),i.bufferData(c,h,f),o.onUploadCallback();let _;if(h instanceof Float32Array)_=i.FLOAT;else if(h instanceof Uint16Array)o.isFloat16BufferAttribute?_=i.HALF_FLOAT:_=i.UNSIGNED_SHORT;else if(h instanceof Int16Array)_=i.SHORT;else if(h instanceof Uint32Array)_=i.UNSIGNED_INT;else if(h instanceof Int32Array)_=i.INT;else if(h instanceof Int8Array)_=i.BYTE;else if(h instanceof Uint8Array)_=i.UNSIGNED_BYTE;else if(h instanceof Uint8ClampedArray)_=i.UNSIGNED_BYTE;else throw new Error("THREE.WebGLAttributes: Unsupported buffer data format: "+h);return{buffer:p,type:_,bytesPerElement:h.BYTES_PER_ELEMENT,version:o.version,size:g}}function n(o,c,h){const f=c.array,g=c.updateRanges;if(i.bindBuffer(h,o),g.length===0)i.bufferSubData(h,0,f);else{g.sort((_,M)=>_.start-M.start);let p=0;for(let _=1;_<g.length;_++){const M=g[p],b=g[_];b.start<=M.start+M.count+1?M.count=Math.max(M.count,b.start+b.count-M.start):(++p,g[p]=b)}g.length=p+1;for(let _=0,M=g.length;_<M;_++){const b=g[_];i.bufferSubData(h,b.start*f.BYTES_PER_ELEMENT,f,b.start,b.count)}c.clearUpdateRanges()}c.onUploadCallback()}function r(o){return o.isInterleavedBufferAttribute&&(o=o.data),t.get(o)}function s(o){o.isInterleavedBufferAttribute&&(o=o.data);const c=t.get(o);c&&(i.deleteBuffer(c.buffer),t.delete(o))}function a(o,c){if(o.isInterleavedBufferAttribute&&(o=o.data),o.isGLBufferAttribute){const f=t.get(o);(!f||f.version<o.version)&&t.set(o,{buffer:o.buffer,type:o.type,bytesPerElement:o.elementSize,version:o.version});return}const h=t.get(o);if(h===void 0)t.set(o,e(o,c));else if(h.version<o.version){if(h.size!==o.array.byteLength)throw new Error("THREE.WebGLAttributes: The size of the buffer attribute's array buffer does not match the original size. Resizing buffer attributes is not supported.");n(h.buffer,o,c),h.version=o.version}}return{get:r,remove:s,update:a}}var jp=`#ifdef USE_ALPHAHASH
	if ( diffuseColor.a < getAlphaHashThreshold( vPosition ) ) discard;
#endif`,Kp=`#ifdef USE_ALPHAHASH
	const float ALPHA_HASH_SCALE = 0.05;
	float hash2D( vec2 value ) {
		return fract( 1.0e4 * sin( 17.0 * value.x + 0.1 * value.y ) * ( 0.1 + abs( sin( 13.0 * value.y + value.x ) ) ) );
	}
	float hash3D( vec3 value ) {
		return hash2D( vec2( hash2D( value.xy ), value.z ) );
	}
	float getAlphaHashThreshold( vec3 position ) {
		float maxDeriv = max(
			length( dFdx( position.xyz ) ),
			length( dFdy( position.xyz ) )
		);
		float pixScale = 1.0 / ( ALPHA_HASH_SCALE * maxDeriv );
		vec2 pixScales = vec2(
			exp2( floor( log2( pixScale ) ) ),
			exp2( ceil( log2( pixScale ) ) )
		);
		vec2 alpha = vec2(
			hash3D( floor( pixScales.x * position.xyz ) ),
			hash3D( floor( pixScales.y * position.xyz ) )
		);
		float lerpFactor = fract( log2( pixScale ) );
		float x = ( 1.0 - lerpFactor ) * alpha.x + lerpFactor * alpha.y;
		float a = min( lerpFactor, 1.0 - lerpFactor );
		vec3 cases = vec3(
			x * x / ( 2.0 * a * ( 1.0 - a ) ),
			( x - 0.5 * a ) / ( 1.0 - a ),
			1.0 - ( ( 1.0 - x ) * ( 1.0 - x ) / ( 2.0 * a * ( 1.0 - a ) ) )
		);
		float threshold = ( x < ( 1.0 - a ) )
			? ( ( x < a ) ? cases.x : cases.y )
			: cases.z;
		return clamp( threshold , 1.0e-6, 1.0 );
	}
#endif`,Zp=`#ifdef USE_ALPHAMAP
	diffuseColor.a *= texture2D( alphaMap, vAlphaMapUv ).g;
#endif`,Jp=`#ifdef USE_ALPHAMAP
	uniform sampler2D alphaMap;
#endif`,Qp=`#ifdef USE_ALPHATEST
	#ifdef ALPHA_TO_COVERAGE
	diffuseColor.a = smoothstep( alphaTest, alphaTest + fwidth( diffuseColor.a ), diffuseColor.a );
	if ( diffuseColor.a == 0.0 ) discard;
	#else
	if ( diffuseColor.a < alphaTest ) discard;
	#endif
#endif`,tg=`#ifdef USE_ALPHATEST
	uniform float alphaTest;
#endif`,eg=`#ifdef USE_AOMAP
	float ambientOcclusion = ( texture2D( aoMap, vAoMapUv ).r - 1.0 ) * aoMapIntensity + 1.0;
	reflectedLight.indirectDiffuse *= ambientOcclusion;
	#if defined( USE_CLEARCOAT ) 
		clearcoatSpecularIndirect *= ambientOcclusion;
	#endif
	#if defined( USE_SHEEN ) 
		sheenSpecularIndirect *= ambientOcclusion;
	#endif
	#if defined( USE_ENVMAP ) && defined( STANDARD )
		float dotNV = saturate( dot( geometryNormal, geometryViewDir ) );
		reflectedLight.indirectSpecular *= computeSpecularOcclusion( dotNV, ambientOcclusion, material.roughness );
	#endif
#endif`,ng=`#ifdef USE_AOMAP
	uniform sampler2D aoMap;
	uniform float aoMapIntensity;
#endif`,ig=`#ifdef USE_BATCHING
	#if ! defined( GL_ANGLE_multi_draw )
	#define gl_DrawID _gl_DrawID
	uniform int _gl_DrawID;
	#endif
	uniform highp sampler2D batchingTexture;
	uniform highp usampler2D batchingIdTexture;
	mat4 getBatchingMatrix( const in float i ) {
		int size = textureSize( batchingTexture, 0 ).x;
		int j = int( i ) * 4;
		int x = j % size;
		int y = j / size;
		vec4 v1 = texelFetch( batchingTexture, ivec2( x, y ), 0 );
		vec4 v2 = texelFetch( batchingTexture, ivec2( x + 1, y ), 0 );
		vec4 v3 = texelFetch( batchingTexture, ivec2( x + 2, y ), 0 );
		vec4 v4 = texelFetch( batchingTexture, ivec2( x + 3, y ), 0 );
		return mat4( v1, v2, v3, v4 );
	}
	float getIndirectIndex( const in int i ) {
		int size = textureSize( batchingIdTexture, 0 ).x;
		int x = i % size;
		int y = i / size;
		return float( texelFetch( batchingIdTexture, ivec2( x, y ), 0 ).r );
	}
#endif
#ifdef USE_BATCHING_COLOR
	uniform sampler2D batchingColorTexture;
	vec3 getBatchingColor( const in float i ) {
		int size = textureSize( batchingColorTexture, 0 ).x;
		int j = int( i );
		int x = j % size;
		int y = j / size;
		return texelFetch( batchingColorTexture, ivec2( x, y ), 0 ).rgb;
	}
#endif`,rg=`#ifdef USE_BATCHING
	mat4 batchingMatrix = getBatchingMatrix( getIndirectIndex( gl_DrawID ) );
#endif`,sg=`vec3 transformed = vec3( position );
#ifdef USE_ALPHAHASH
	vPosition = vec3( position );
#endif`,og=`vec3 objectNormal = vec3( normal );
#ifdef USE_TANGENT
	vec3 objectTangent = vec3( tangent.xyz );
#endif`,ag=`float G_BlinnPhong_Implicit( ) {
	return 0.25;
}
float D_BlinnPhong( const in float shininess, const in float dotNH ) {
	return RECIPROCAL_PI * ( shininess * 0.5 + 1.0 ) * pow( dotNH, shininess );
}
vec3 BRDF_BlinnPhong( const in vec3 lightDir, const in vec3 viewDir, const in vec3 normal, const in vec3 specularColor, const in float shininess ) {
	vec3 halfDir = normalize( lightDir + viewDir );
	float dotNH = saturate( dot( normal, halfDir ) );
	float dotVH = saturate( dot( viewDir, halfDir ) );
	vec3 F = F_Schlick( specularColor, 1.0, dotVH );
	float G = G_BlinnPhong_Implicit( );
	float D = D_BlinnPhong( shininess, dotNH );
	return F * ( G * D );
} // validated`,cg=`#ifdef USE_IRIDESCENCE
	const mat3 XYZ_TO_REC709 = mat3(
		 3.2404542, -0.9692660,  0.0556434,
		-1.5371385,  1.8760108, -0.2040259,
		-0.4985314,  0.0415560,  1.0572252
	);
	vec3 Fresnel0ToIor( vec3 fresnel0 ) {
		vec3 sqrtF0 = sqrt( fresnel0 );
		return ( vec3( 1.0 ) + sqrtF0 ) / ( vec3( 1.0 ) - sqrtF0 );
	}
	vec3 IorToFresnel0( vec3 transmittedIor, float incidentIor ) {
		return pow2( ( transmittedIor - vec3( incidentIor ) ) / ( transmittedIor + vec3( incidentIor ) ) );
	}
	float IorToFresnel0( float transmittedIor, float incidentIor ) {
		return pow2( ( transmittedIor - incidentIor ) / ( transmittedIor + incidentIor ));
	}
	vec3 evalSensitivity( float OPD, vec3 shift ) {
		float phase = 2.0 * PI * OPD * 1.0e-9;
		vec3 val = vec3( 5.4856e-13, 4.4201e-13, 5.2481e-13 );
		vec3 pos = vec3( 1.6810e+06, 1.7953e+06, 2.2084e+06 );
		vec3 var = vec3( 4.3278e+09, 9.3046e+09, 6.6121e+09 );
		vec3 xyz = val * sqrt( 2.0 * PI * var ) * cos( pos * phase + shift ) * exp( - pow2( phase ) * var );
		xyz.x += 9.7470e-14 * sqrt( 2.0 * PI * 4.5282e+09 ) * cos( 2.2399e+06 * phase + shift[ 0 ] ) * exp( - 4.5282e+09 * pow2( phase ) );
		xyz /= 1.0685e-7;
		vec3 rgb = XYZ_TO_REC709 * xyz;
		return rgb;
	}
	vec3 evalIridescence( float outsideIOR, float eta2, float cosTheta1, float thinFilmThickness, vec3 baseF0 ) {
		vec3 I;
		float iridescenceIOR = mix( outsideIOR, eta2, smoothstep( 0.0, 0.03, thinFilmThickness ) );
		float sinTheta2Sq = pow2( outsideIOR / iridescenceIOR ) * ( 1.0 - pow2( cosTheta1 ) );
		float cosTheta2Sq = 1.0 - sinTheta2Sq;
		if ( cosTheta2Sq < 0.0 ) {
			return vec3( 1.0 );
		}
		float cosTheta2 = sqrt( cosTheta2Sq );
		float R0 = IorToFresnel0( iridescenceIOR, outsideIOR );
		float R12 = F_Schlick( R0, 1.0, cosTheta1 );
		float T121 = 1.0 - R12;
		float phi12 = 0.0;
		if ( iridescenceIOR < outsideIOR ) phi12 = PI;
		float phi21 = PI - phi12;
		vec3 baseIOR = Fresnel0ToIor( clamp( baseF0, 0.0, 0.9999 ) );		vec3 R1 = IorToFresnel0( baseIOR, iridescenceIOR );
		vec3 R23 = F_Schlick( R1, 1.0, cosTheta2 );
		vec3 phi23 = vec3( 0.0 );
		if ( baseIOR[ 0 ] < iridescenceIOR ) phi23[ 0 ] = PI;
		if ( baseIOR[ 1 ] < iridescenceIOR ) phi23[ 1 ] = PI;
		if ( baseIOR[ 2 ] < iridescenceIOR ) phi23[ 2 ] = PI;
		float OPD = 2.0 * iridescenceIOR * thinFilmThickness * cosTheta2;
		vec3 phi = vec3( phi21 ) + phi23;
		vec3 R123 = clamp( R12 * R23, 1e-5, 0.9999 );
		vec3 r123 = sqrt( R123 );
		vec3 Rs = pow2( T121 ) * R23 / ( vec3( 1.0 ) - R123 );
		vec3 C0 = R12 + Rs;
		I = C0;
		vec3 Cm = Rs - T121;
		for ( int m = 1; m <= 2; ++ m ) {
			Cm *= r123;
			vec3 Sm = 2.0 * evalSensitivity( float( m ) * OPD, float( m ) * phi );
			I += Cm * Sm;
		}
		return max( I, vec3( 0.0 ) );
	}
#endif`,lg=`#ifdef USE_BUMPMAP
	uniform sampler2D bumpMap;
	uniform float bumpScale;
	vec2 dHdxy_fwd() {
		vec2 dSTdx = dFdx( vBumpMapUv );
		vec2 dSTdy = dFdy( vBumpMapUv );
		float Hll = bumpScale * texture2D( bumpMap, vBumpMapUv ).x;
		float dBx = bumpScale * texture2D( bumpMap, vBumpMapUv + dSTdx ).x - Hll;
		float dBy = bumpScale * texture2D( bumpMap, vBumpMapUv + dSTdy ).x - Hll;
		return vec2( dBx, dBy );
	}
	vec3 perturbNormalArb( vec3 surf_pos, vec3 surf_norm, vec2 dHdxy, float faceDirection ) {
		vec3 vSigmaX = normalize( dFdx( surf_pos.xyz ) );
		vec3 vSigmaY = normalize( dFdy( surf_pos.xyz ) );
		vec3 vN = surf_norm;
		vec3 R1 = cross( vSigmaY, vN );
		vec3 R2 = cross( vN, vSigmaX );
		float fDet = dot( vSigmaX, R1 ) * faceDirection;
		vec3 vGrad = sign( fDet ) * ( dHdxy.x * R1 + dHdxy.y * R2 );
		return normalize( abs( fDet ) * surf_norm - vGrad );
	}
#endif`,ug=`#if NUM_CLIPPING_PLANES > 0
	vec4 plane;
	#ifdef ALPHA_TO_COVERAGE
		float distanceToPlane, distanceGradient;
		float clipOpacity = 1.0;
		#pragma unroll_loop_start
		for ( int i = 0; i < UNION_CLIPPING_PLANES; i ++ ) {
			plane = clippingPlanes[ i ];
			distanceToPlane = - dot( vClipPosition, plane.xyz ) + plane.w;
			distanceGradient = fwidth( distanceToPlane ) / 2.0;
			clipOpacity *= smoothstep( - distanceGradient, distanceGradient, distanceToPlane );
			if ( clipOpacity == 0.0 ) discard;
		}
		#pragma unroll_loop_end
		#if UNION_CLIPPING_PLANES < NUM_CLIPPING_PLANES
			float unionClipOpacity = 1.0;
			#pragma unroll_loop_start
			for ( int i = UNION_CLIPPING_PLANES; i < NUM_CLIPPING_PLANES; i ++ ) {
				plane = clippingPlanes[ i ];
				distanceToPlane = - dot( vClipPosition, plane.xyz ) + plane.w;
				distanceGradient = fwidth( distanceToPlane ) / 2.0;
				unionClipOpacity *= 1.0 - smoothstep( - distanceGradient, distanceGradient, distanceToPlane );
			}
			#pragma unroll_loop_end
			clipOpacity *= 1.0 - unionClipOpacity;
		#endif
		diffuseColor.a *= clipOpacity;
		if ( diffuseColor.a == 0.0 ) discard;
	#else
		#pragma unroll_loop_start
		for ( int i = 0; i < UNION_CLIPPING_PLANES; i ++ ) {
			plane = clippingPlanes[ i ];
			if ( dot( vClipPosition, plane.xyz ) > plane.w ) discard;
		}
		#pragma unroll_loop_end
		#if UNION_CLIPPING_PLANES < NUM_CLIPPING_PLANES
			bool clipped = true;
			#pragma unroll_loop_start
			for ( int i = UNION_CLIPPING_PLANES; i < NUM_CLIPPING_PLANES; i ++ ) {
				plane = clippingPlanes[ i ];
				clipped = ( dot( vClipPosition, plane.xyz ) > plane.w ) && clipped;
			}
			#pragma unroll_loop_end
			if ( clipped ) discard;
		#endif
	#endif
#endif`,hg=`#if NUM_CLIPPING_PLANES > 0
	varying vec3 vClipPosition;
	uniform vec4 clippingPlanes[ NUM_CLIPPING_PLANES ];
#endif`,fg=`#if NUM_CLIPPING_PLANES > 0
	varying vec3 vClipPosition;
#endif`,dg=`#if NUM_CLIPPING_PLANES > 0
	vClipPosition = - mvPosition.xyz;
#endif`,pg=`#if defined( USE_COLOR_ALPHA )
	diffuseColor *= vColor;
#elif defined( USE_COLOR )
	diffuseColor.rgb *= vColor;
#endif`,gg=`#if defined( USE_COLOR_ALPHA )
	varying vec4 vColor;
#elif defined( USE_COLOR )
	varying vec3 vColor;
#endif`,mg=`#if defined( USE_COLOR_ALPHA )
	varying vec4 vColor;
#elif defined( USE_COLOR ) || defined( USE_INSTANCING_COLOR ) || defined( USE_BATCHING_COLOR )
	varying vec3 vColor;
#endif`,_g=`#if defined( USE_COLOR_ALPHA )
	vColor = vec4( 1.0 );
#elif defined( USE_COLOR ) || defined( USE_INSTANCING_COLOR ) || defined( USE_BATCHING_COLOR )
	vColor = vec3( 1.0 );
#endif
#ifdef USE_COLOR
	vColor *= color;
#endif
#ifdef USE_INSTANCING_COLOR
	vColor.xyz *= instanceColor.xyz;
#endif
#ifdef USE_BATCHING_COLOR
	vec3 batchingColor = getBatchingColor( getIndirectIndex( gl_DrawID ) );
	vColor.xyz *= batchingColor.xyz;
#endif`,xg=`#define PI 3.141592653589793
#define PI2 6.283185307179586
#define PI_HALF 1.5707963267948966
#define RECIPROCAL_PI 0.3183098861837907
#define RECIPROCAL_PI2 0.15915494309189535
#define EPSILON 1e-6
#ifndef saturate
#define saturate( a ) clamp( a, 0.0, 1.0 )
#endif
#define whiteComplement( a ) ( 1.0 - saturate( a ) )
float pow2( const in float x ) { return x*x; }
vec3 pow2( const in vec3 x ) { return x*x; }
float pow3( const in float x ) { return x*x*x; }
float pow4( const in float x ) { float x2 = x*x; return x2*x2; }
float max3( const in vec3 v ) { return max( max( v.x, v.y ), v.z ); }
float average( const in vec3 v ) { return dot( v, vec3( 0.3333333 ) ); }
highp float rand( const in vec2 uv ) {
	const highp float a = 12.9898, b = 78.233, c = 43758.5453;
	highp float dt = dot( uv.xy, vec2( a,b ) ), sn = mod( dt, PI );
	return fract( sin( sn ) * c );
}
#ifdef HIGH_PRECISION
	float precisionSafeLength( vec3 v ) { return length( v ); }
#else
	float precisionSafeLength( vec3 v ) {
		float maxComponent = max3( abs( v ) );
		return length( v / maxComponent ) * maxComponent;
	}
#endif
struct IncidentLight {
	vec3 color;
	vec3 direction;
	bool visible;
};
struct ReflectedLight {
	vec3 directDiffuse;
	vec3 directSpecular;
	vec3 indirectDiffuse;
	vec3 indirectSpecular;
};
#ifdef USE_ALPHAHASH
	varying vec3 vPosition;
#endif
vec3 transformDirection( in vec3 dir, in mat4 matrix ) {
	return normalize( ( matrix * vec4( dir, 0.0 ) ).xyz );
}
vec3 inverseTransformDirection( in vec3 dir, in mat4 matrix ) {
	return normalize( ( vec4( dir, 0.0 ) * matrix ).xyz );
}
mat3 transposeMat3( const in mat3 m ) {
	mat3 tmp;
	tmp[ 0 ] = vec3( m[ 0 ].x, m[ 1 ].x, m[ 2 ].x );
	tmp[ 1 ] = vec3( m[ 0 ].y, m[ 1 ].y, m[ 2 ].y );
	tmp[ 2 ] = vec3( m[ 0 ].z, m[ 1 ].z, m[ 2 ].z );
	return tmp;
}
bool isPerspectiveMatrix( mat4 m ) {
	return m[ 2 ][ 3 ] == - 1.0;
}
vec2 equirectUv( in vec3 dir ) {
	float u = atan( dir.z, dir.x ) * RECIPROCAL_PI2 + 0.5;
	float v = asin( clamp( dir.y, - 1.0, 1.0 ) ) * RECIPROCAL_PI + 0.5;
	return vec2( u, v );
}
vec3 BRDF_Lambert( const in vec3 diffuseColor ) {
	return RECIPROCAL_PI * diffuseColor;
}
vec3 F_Schlick( const in vec3 f0, const in float f90, const in float dotVH ) {
	float fresnel = exp2( ( - 5.55473 * dotVH - 6.98316 ) * dotVH );
	return f0 * ( 1.0 - fresnel ) + ( f90 * fresnel );
}
float F_Schlick( const in float f0, const in float f90, const in float dotVH ) {
	float fresnel = exp2( ( - 5.55473 * dotVH - 6.98316 ) * dotVH );
	return f0 * ( 1.0 - fresnel ) + ( f90 * fresnel );
} // validated`,vg=`#ifdef ENVMAP_TYPE_CUBE_UV
	#define cubeUV_minMipLevel 4.0
	#define cubeUV_minTileSize 16.0
	float getFace( vec3 direction ) {
		vec3 absDirection = abs( direction );
		float face = - 1.0;
		if ( absDirection.x > absDirection.z ) {
			if ( absDirection.x > absDirection.y )
				face = direction.x > 0.0 ? 0.0 : 3.0;
			else
				face = direction.y > 0.0 ? 1.0 : 4.0;
		} else {
			if ( absDirection.z > absDirection.y )
				face = direction.z > 0.0 ? 2.0 : 5.0;
			else
				face = direction.y > 0.0 ? 1.0 : 4.0;
		}
		return face;
	}
	vec2 getUV( vec3 direction, float face ) {
		vec2 uv;
		if ( face == 0.0 ) {
			uv = vec2( direction.z, direction.y ) / abs( direction.x );
		} else if ( face == 1.0 ) {
			uv = vec2( - direction.x, - direction.z ) / abs( direction.y );
		} else if ( face == 2.0 ) {
			uv = vec2( - direction.x, direction.y ) / abs( direction.z );
		} else if ( face == 3.0 ) {
			uv = vec2( - direction.z, direction.y ) / abs( direction.x );
		} else if ( face == 4.0 ) {
			uv = vec2( - direction.x, direction.z ) / abs( direction.y );
		} else {
			uv = vec2( direction.x, direction.y ) / abs( direction.z );
		}
		return 0.5 * ( uv + 1.0 );
	}
	vec3 bilinearCubeUV( sampler2D envMap, vec3 direction, float mipInt ) {
		float face = getFace( direction );
		float filterInt = max( cubeUV_minMipLevel - mipInt, 0.0 );
		mipInt = max( mipInt, cubeUV_minMipLevel );
		float faceSize = exp2( mipInt );
		highp vec2 uv = getUV( direction, face ) * ( faceSize - 2.0 ) + 1.0;
		if ( face > 2.0 ) {
			uv.y += faceSize;
			face -= 3.0;
		}
		uv.x += face * faceSize;
		uv.x += filterInt * 3.0 * cubeUV_minTileSize;
		uv.y += 4.0 * ( exp2( CUBEUV_MAX_MIP ) - faceSize );
		uv.x *= CUBEUV_TEXEL_WIDTH;
		uv.y *= CUBEUV_TEXEL_HEIGHT;
		#ifdef texture2DGradEXT
			return texture2DGradEXT( envMap, uv, vec2( 0.0 ), vec2( 0.0 ) ).rgb;
		#else
			return texture2D( envMap, uv ).rgb;
		#endif
	}
	#define cubeUV_r0 1.0
	#define cubeUV_m0 - 2.0
	#define cubeUV_r1 0.8
	#define cubeUV_m1 - 1.0
	#define cubeUV_r4 0.4
	#define cubeUV_m4 2.0
	#define cubeUV_r5 0.305
	#define cubeUV_m5 3.0
	#define cubeUV_r6 0.21
	#define cubeUV_m6 4.0
	float roughnessToMip( float roughness ) {
		float mip = 0.0;
		if ( roughness >= cubeUV_r1 ) {
			mip = ( cubeUV_r0 - roughness ) * ( cubeUV_m1 - cubeUV_m0 ) / ( cubeUV_r0 - cubeUV_r1 ) + cubeUV_m0;
		} else if ( roughness >= cubeUV_r4 ) {
			mip = ( cubeUV_r1 - roughness ) * ( cubeUV_m4 - cubeUV_m1 ) / ( cubeUV_r1 - cubeUV_r4 ) + cubeUV_m1;
		} else if ( roughness >= cubeUV_r5 ) {
			mip = ( cubeUV_r4 - roughness ) * ( cubeUV_m5 - cubeUV_m4 ) / ( cubeUV_r4 - cubeUV_r5 ) + cubeUV_m4;
		} else if ( roughness >= cubeUV_r6 ) {
			mip = ( cubeUV_r5 - roughness ) * ( cubeUV_m6 - cubeUV_m5 ) / ( cubeUV_r5 - cubeUV_r6 ) + cubeUV_m5;
		} else {
			mip = - 2.0 * log2( 1.16 * roughness );		}
		return mip;
	}
	vec4 textureCubeUV( sampler2D envMap, vec3 sampleDir, float roughness ) {
		float mip = clamp( roughnessToMip( roughness ), cubeUV_m0, CUBEUV_MAX_MIP );
		float mipF = fract( mip );
		float mipInt = floor( mip );
		vec3 color0 = bilinearCubeUV( envMap, sampleDir, mipInt );
		if ( mipF == 0.0 ) {
			return vec4( color0, 1.0 );
		} else {
			vec3 color1 = bilinearCubeUV( envMap, sampleDir, mipInt + 1.0 );
			return vec4( mix( color0, color1, mipF ), 1.0 );
		}
	}
#endif`,yg=`vec3 transformedNormal = objectNormal;
#ifdef USE_TANGENT
	vec3 transformedTangent = objectTangent;
#endif
#ifdef USE_BATCHING
	mat3 bm = mat3( batchingMatrix );
	transformedNormal /= vec3( dot( bm[ 0 ], bm[ 0 ] ), dot( bm[ 1 ], bm[ 1 ] ), dot( bm[ 2 ], bm[ 2 ] ) );
	transformedNormal = bm * transformedNormal;
	#ifdef USE_TANGENT
		transformedTangent = bm * transformedTangent;
	#endif
#endif
#ifdef USE_INSTANCING
	mat3 im = mat3( instanceMatrix );
	transformedNormal /= vec3( dot( im[ 0 ], im[ 0 ] ), dot( im[ 1 ], im[ 1 ] ), dot( im[ 2 ], im[ 2 ] ) );
	transformedNormal = im * transformedNormal;
	#ifdef USE_TANGENT
		transformedTangent = im * transformedTangent;
	#endif
#endif
transformedNormal = normalMatrix * transformedNormal;
#ifdef FLIP_SIDED
	transformedNormal = - transformedNormal;
#endif
#ifdef USE_TANGENT
	transformedTangent = ( modelViewMatrix * vec4( transformedTangent, 0.0 ) ).xyz;
	#ifdef FLIP_SIDED
		transformedTangent = - transformedTangent;
	#endif
#endif`,Sg=`#ifdef USE_DISPLACEMENTMAP
	uniform sampler2D displacementMap;
	uniform float displacementScale;
	uniform float displacementBias;
#endif`,Mg=`#ifdef USE_DISPLACEMENTMAP
	transformed += normalize( objectNormal ) * ( texture2D( displacementMap, vDisplacementMapUv ).x * displacementScale + displacementBias );
#endif`,Eg=`#ifdef USE_EMISSIVEMAP
	vec4 emissiveColor = texture2D( emissiveMap, vEmissiveMapUv );
	#ifdef DECODE_VIDEO_TEXTURE_EMISSIVE
		emissiveColor = sRGBTransferEOTF( emissiveColor );
	#endif
	totalEmissiveRadiance *= emissiveColor.rgb;
#endif`,Tg=`#ifdef USE_EMISSIVEMAP
	uniform sampler2D emissiveMap;
#endif`,bg="gl_FragColor = linearToOutputTexel( gl_FragColor );",Ag=`vec4 LinearTransferOETF( in vec4 value ) {
	return value;
}
vec4 sRGBTransferEOTF( in vec4 value ) {
	return vec4( mix( pow( value.rgb * 0.9478672986 + vec3( 0.0521327014 ), vec3( 2.4 ) ), value.rgb * 0.0773993808, vec3( lessThanEqual( value.rgb, vec3( 0.04045 ) ) ) ), value.a );
}
vec4 sRGBTransferOETF( in vec4 value ) {
	return vec4( mix( pow( value.rgb, vec3( 0.41666 ) ) * 1.055 - vec3( 0.055 ), value.rgb * 12.92, vec3( lessThanEqual( value.rgb, vec3( 0.0031308 ) ) ) ), value.a );
}`,wg=`#ifdef USE_ENVMAP
	#ifdef ENV_WORLDPOS
		vec3 cameraToFrag;
		if ( isOrthographic ) {
			cameraToFrag = normalize( vec3( - viewMatrix[ 0 ][ 2 ], - viewMatrix[ 1 ][ 2 ], - viewMatrix[ 2 ][ 2 ] ) );
		} else {
			cameraToFrag = normalize( vWorldPosition - cameraPosition );
		}
		vec3 worldNormal = inverseTransformDirection( normal, viewMatrix );
		#ifdef ENVMAP_MODE_REFLECTION
			vec3 reflectVec = reflect( cameraToFrag, worldNormal );
		#else
			vec3 reflectVec = refract( cameraToFrag, worldNormal, refractionRatio );
		#endif
	#else
		vec3 reflectVec = vReflect;
	#endif
	#ifdef ENVMAP_TYPE_CUBE
		vec4 envColor = textureCube( envMap, envMapRotation * vec3( flipEnvMap * reflectVec.x, reflectVec.yz ) );
	#else
		vec4 envColor = vec4( 0.0 );
	#endif
	#ifdef ENVMAP_BLENDING_MULTIPLY
		outgoingLight = mix( outgoingLight, outgoingLight * envColor.xyz, specularStrength * reflectivity );
	#elif defined( ENVMAP_BLENDING_MIX )
		outgoingLight = mix( outgoingLight, envColor.xyz, specularStrength * reflectivity );
	#elif defined( ENVMAP_BLENDING_ADD )
		outgoingLight += envColor.xyz * specularStrength * reflectivity;
	#endif
#endif`,Rg=`#ifdef USE_ENVMAP
	uniform float envMapIntensity;
	uniform float flipEnvMap;
	uniform mat3 envMapRotation;
	#ifdef ENVMAP_TYPE_CUBE
		uniform samplerCube envMap;
	#else
		uniform sampler2D envMap;
	#endif
	
#endif`,Cg=`#ifdef USE_ENVMAP
	uniform float reflectivity;
	#if defined( USE_BUMPMAP ) || defined( USE_NORMALMAP ) || defined( PHONG ) || defined( LAMBERT )
		#define ENV_WORLDPOS
	#endif
	#ifdef ENV_WORLDPOS
		varying vec3 vWorldPosition;
		uniform float refractionRatio;
	#else
		varying vec3 vReflect;
	#endif
#endif`,Pg=`#ifdef USE_ENVMAP
	#if defined( USE_BUMPMAP ) || defined( USE_NORMALMAP ) || defined( PHONG ) || defined( LAMBERT )
		#define ENV_WORLDPOS
	#endif
	#ifdef ENV_WORLDPOS
		
		varying vec3 vWorldPosition;
	#else
		varying vec3 vReflect;
		uniform float refractionRatio;
	#endif
#endif`,Ig=`#ifdef USE_ENVMAP
	#ifdef ENV_WORLDPOS
		vWorldPosition = worldPosition.xyz;
	#else
		vec3 cameraToVertex;
		if ( isOrthographic ) {
			cameraToVertex = normalize( vec3( - viewMatrix[ 0 ][ 2 ], - viewMatrix[ 1 ][ 2 ], - viewMatrix[ 2 ][ 2 ] ) );
		} else {
			cameraToVertex = normalize( worldPosition.xyz - cameraPosition );
		}
		vec3 worldNormal = inverseTransformDirection( transformedNormal, viewMatrix );
		#ifdef ENVMAP_MODE_REFLECTION
			vReflect = reflect( cameraToVertex, worldNormal );
		#else
			vReflect = refract( cameraToVertex, worldNormal, refractionRatio );
		#endif
	#endif
#endif`,Lg=`#ifdef USE_FOG
	vFogDepth = - mvPosition.z;
#endif`,Dg=`#ifdef USE_FOG
	varying float vFogDepth;
#endif`,Ug=`#ifdef USE_FOG
	#ifdef FOG_EXP2
		float fogFactor = 1.0 - exp( - fogDensity * fogDensity * vFogDepth * vFogDepth );
	#else
		float fogFactor = smoothstep( fogNear, fogFar, vFogDepth );
	#endif
	gl_FragColor.rgb = mix( gl_FragColor.rgb, fogColor, fogFactor );
#endif`,Ng=`#ifdef USE_FOG
	uniform vec3 fogColor;
	varying float vFogDepth;
	#ifdef FOG_EXP2
		uniform float fogDensity;
	#else
		uniform float fogNear;
		uniform float fogFar;
	#endif
#endif`,Fg=`#ifdef USE_GRADIENTMAP
	uniform sampler2D gradientMap;
#endif
vec3 getGradientIrradiance( vec3 normal, vec3 lightDirection ) {
	float dotNL = dot( normal, lightDirection );
	vec2 coord = vec2( dotNL * 0.5 + 0.5, 0.0 );
	#ifdef USE_GRADIENTMAP
		return vec3( texture2D( gradientMap, coord ).r );
	#else
		vec2 fw = fwidth( coord ) * 0.5;
		return mix( vec3( 0.7 ), vec3( 1.0 ), smoothstep( 0.7 - fw.x, 0.7 + fw.x, coord.x ) );
	#endif
}`,Bg=`#ifdef USE_LIGHTMAP
	uniform sampler2D lightMap;
	uniform float lightMapIntensity;
#endif`,Og=`LambertMaterial material;
material.diffuseColor = diffuseColor.rgb;
material.specularStrength = specularStrength;`,zg=`varying vec3 vViewPosition;
struct LambertMaterial {
	vec3 diffuseColor;
	float specularStrength;
};
void RE_Direct_Lambert( const in IncidentLight directLight, const in vec3 geometryPosition, const in vec3 geometryNormal, const in vec3 geometryViewDir, const in vec3 geometryClearcoatNormal, const in LambertMaterial material, inout ReflectedLight reflectedLight ) {
	float dotNL = saturate( dot( geometryNormal, directLight.direction ) );
	vec3 irradiance = dotNL * directLight.color;
	reflectedLight.directDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
void RE_IndirectDiffuse_Lambert( const in vec3 irradiance, const in vec3 geometryPosition, const in vec3 geometryNormal, const in vec3 geometryViewDir, const in vec3 geometryClearcoatNormal, const in LambertMaterial material, inout ReflectedLight reflectedLight ) {
	reflectedLight.indirectDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
#define RE_Direct				RE_Direct_Lambert
#define RE_IndirectDiffuse		RE_IndirectDiffuse_Lambert`,Vg=`uniform bool receiveShadow;
uniform vec3 ambientLightColor;
#if defined( USE_LIGHT_PROBES )
	uniform vec3 lightProbe[ 9 ];
#endif
vec3 shGetIrradianceAt( in vec3 normal, in vec3 shCoefficients[ 9 ] ) {
	float x = normal.x, y = normal.y, z = normal.z;
	vec3 result = shCoefficients[ 0 ] * 0.886227;
	result += shCoefficients[ 1 ] * 2.0 * 0.511664 * y;
	result += shCoefficients[ 2 ] * 2.0 * 0.511664 * z;
	result += shCoefficients[ 3 ] * 2.0 * 0.511664 * x;
	result += shCoefficients[ 4 ] * 2.0 * 0.429043 * x * y;
	result += shCoefficients[ 5 ] * 2.0 * 0.429043 * y * z;
	result += shCoefficients[ 6 ] * ( 0.743125 * z * z - 0.247708 );
	result += shCoefficients[ 7 ] * 2.0 * 0.429043 * x * z;
	result += shCoefficients[ 8 ] * 0.429043 * ( x * x - y * y );
	return result;
}
vec3 getLightProbeIrradiance( const in vec3 lightProbe[ 9 ], const in vec3 normal ) {
	vec3 worldNormal = inverseTransformDirection( normal, viewMatrix );
	vec3 irradiance = shGetIrradianceAt( worldNormal, lightProbe );
	return irradiance;
}
vec3 getAmbientLightIrradiance( const in vec3 ambientLightColor ) {
	vec3 irradiance = ambientLightColor;
	return irradiance;
}
float getDistanceAttenuation( const in float lightDistance, const in float cutoffDistance, const in float decayExponent ) {
	float distanceFalloff = 1.0 / max( pow( lightDistance, decayExponent ), 0.01 );
	if ( cutoffDistance > 0.0 ) {
		distanceFalloff *= pow2( saturate( 1.0 - pow4( lightDistance / cutoffDistance ) ) );
	}
	return distanceFalloff;
}
float getSpotAttenuation( const in float coneCosine, const in float penumbraCosine, const in float angleCosine ) {
	return smoothstep( coneCosine, penumbraCosine, angleCosine );
}
#if NUM_DIR_LIGHTS > 0
	struct DirectionalLight {
		vec3 direction;
		vec3 color;
	};
	uniform DirectionalLight directionalLights[ NUM_DIR_LIGHTS ];
	void getDirectionalLightInfo( const in DirectionalLight directionalLight, out IncidentLight light ) {
		light.color = directionalLight.color;
		light.direction = directionalLight.direction;
		light.visible = true;
	}
#endif
#if NUM_POINT_LIGHTS > 0
	struct PointLight {
		vec3 position;
		vec3 color;
		float distance;
		float decay;
	};
	uniform PointLight pointLights[ NUM_POINT_LIGHTS ];
	void getPointLightInfo( const in PointLight pointLight, const in vec3 geometryPosition, out IncidentLight light ) {
		vec3 lVector = pointLight.position - geometryPosition;
		light.direction = normalize( lVector );
		float lightDistance = length( lVector );
		light.color = pointLight.color;
		light.color *= getDistanceAttenuation( lightDistance, pointLight.distance, pointLight.decay );
		light.visible = ( light.color != vec3( 0.0 ) );
	}
#endif
#if NUM_SPOT_LIGHTS > 0
	struct SpotLight {
		vec3 position;
		vec3 direction;
		vec3 color;
		float distance;
		float decay;
		float coneCos;
		float penumbraCos;
	};
	uniform SpotLight spotLights[ NUM_SPOT_LIGHTS ];
	void getSpotLightInfo( const in SpotLight spotLight, const in vec3 geometryPosition, out IncidentLight light ) {
		vec3 lVector = spotLight.position - geometryPosition;
		light.direction = normalize( lVector );
		float angleCos = dot( light.direction, spotLight.direction );
		float spotAttenuation = getSpotAttenuation( spotLight.coneCos, spotLight.penumbraCos, angleCos );
		if ( spotAttenuation > 0.0 ) {
			float lightDistance = length( lVector );
			light.color = spotLight.color * spotAttenuation;
			light.color *= getDistanceAttenuation( lightDistance, spotLight.distance, spotLight.decay );
			light.visible = ( light.color != vec3( 0.0 ) );
		} else {
			light.color = vec3( 0.0 );
			light.visible = false;
		}
	}
#endif
#if NUM_RECT_AREA_LIGHTS > 0
	struct RectAreaLight {
		vec3 color;
		vec3 position;
		vec3 halfWidth;
		vec3 halfHeight;
	};
	uniform sampler2D ltc_1;	uniform sampler2D ltc_2;
	uniform RectAreaLight rectAreaLights[ NUM_RECT_AREA_LIGHTS ];
#endif
#if NUM_HEMI_LIGHTS > 0
	struct HemisphereLight {
		vec3 direction;
		vec3 skyColor;
		vec3 groundColor;
	};
	uniform HemisphereLight hemisphereLights[ NUM_HEMI_LIGHTS ];
	vec3 getHemisphereLightIrradiance( const in HemisphereLight hemiLight, const in vec3 normal ) {
		float dotNL = dot( normal, hemiLight.direction );
		float hemiDiffuseWeight = 0.5 * dotNL + 0.5;
		vec3 irradiance = mix( hemiLight.groundColor, hemiLight.skyColor, hemiDiffuseWeight );
		return irradiance;
	}
#endif`,Hg=`#ifdef USE_ENVMAP
	vec3 getIBLIrradiance( const in vec3 normal ) {
		#ifdef ENVMAP_TYPE_CUBE_UV
			vec3 worldNormal = inverseTransformDirection( normal, viewMatrix );
			vec4 envMapColor = textureCubeUV( envMap, envMapRotation * worldNormal, 1.0 );
			return PI * envMapColor.rgb * envMapIntensity;
		#else
			return vec3( 0.0 );
		#endif
	}
	vec3 getIBLRadiance( const in vec3 viewDir, const in vec3 normal, const in float roughness ) {
		#ifdef ENVMAP_TYPE_CUBE_UV
			vec3 reflectVec = reflect( - viewDir, normal );
			reflectVec = normalize( mix( reflectVec, normal, roughness * roughness) );
			reflectVec = inverseTransformDirection( reflectVec, viewMatrix );
			vec4 envMapColor = textureCubeUV( envMap, envMapRotation * reflectVec, roughness );
			return envMapColor.rgb * envMapIntensity;
		#else
			return vec3( 0.0 );
		#endif
	}
	#ifdef USE_ANISOTROPY
		vec3 getIBLAnisotropyRadiance( const in vec3 viewDir, const in vec3 normal, const in float roughness, const in vec3 bitangent, const in float anisotropy ) {
			#ifdef ENVMAP_TYPE_CUBE_UV
				vec3 bentNormal = cross( bitangent, viewDir );
				bentNormal = normalize( cross( bentNormal, bitangent ) );
				bentNormal = normalize( mix( bentNormal, normal, pow2( pow2( 1.0 - anisotropy * ( 1.0 - roughness ) ) ) ) );
				return getIBLRadiance( viewDir, bentNormal, roughness );
			#else
				return vec3( 0.0 );
			#endif
		}
	#endif
#endif`,Gg=`ToonMaterial material;
material.diffuseColor = diffuseColor.rgb;`,kg=`varying vec3 vViewPosition;
struct ToonMaterial {
	vec3 diffuseColor;
};
void RE_Direct_Toon( const in IncidentLight directLight, const in vec3 geometryPosition, const in vec3 geometryNormal, const in vec3 geometryViewDir, const in vec3 geometryClearcoatNormal, const in ToonMaterial material, inout ReflectedLight reflectedLight ) {
	vec3 irradiance = getGradientIrradiance( geometryNormal, directLight.direction ) * directLight.color;
	reflectedLight.directDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
void RE_IndirectDiffuse_Toon( const in vec3 irradiance, const in vec3 geometryPosition, const in vec3 geometryNormal, const in vec3 geometryViewDir, const in vec3 geometryClearcoatNormal, const in ToonMaterial material, inout ReflectedLight reflectedLight ) {
	reflectedLight.indirectDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
#define RE_Direct				RE_Direct_Toon
#define RE_IndirectDiffuse		RE_IndirectDiffuse_Toon`,Wg=`BlinnPhongMaterial material;
material.diffuseColor = diffuseColor.rgb;
material.specularColor = specular;
material.specularShininess = shininess;
material.specularStrength = specularStrength;`,Xg=`varying vec3 vViewPosition;
struct BlinnPhongMaterial {
	vec3 diffuseColor;
	vec3 specularColor;
	float specularShininess;
	float specularStrength;
};
void RE_Direct_BlinnPhong( const in IncidentLight directLight, const in vec3 geometryPosition, const in vec3 geometryNormal, const in vec3 geometryViewDir, const in vec3 geometryClearcoatNormal, const in BlinnPhongMaterial material, inout ReflectedLight reflectedLight ) {
	float dotNL = saturate( dot( geometryNormal, directLight.direction ) );
	vec3 irradiance = dotNL * directLight.color;
	reflectedLight.directDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
	reflectedLight.directSpecular += irradiance * BRDF_BlinnPhong( directLight.direction, geometryViewDir, geometryNormal, material.specularColor, material.specularShininess ) * material.specularStrength;
}
void RE_IndirectDiffuse_BlinnPhong( const in vec3 irradiance, const in vec3 geometryPosition, const in vec3 geometryNormal, const in vec3 geometryViewDir, const in vec3 geometryClearcoatNormal, const in BlinnPhongMaterial material, inout ReflectedLight reflectedLight ) {
	reflectedLight.indirectDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
#define RE_Direct				RE_Direct_BlinnPhong
#define RE_IndirectDiffuse		RE_IndirectDiffuse_BlinnPhong`,qg=`PhysicalMaterial material;
material.diffuseColor = diffuseColor.rgb * ( 1.0 - metalnessFactor );
vec3 dxy = max( abs( dFdx( nonPerturbedNormal ) ), abs( dFdy( nonPerturbedNormal ) ) );
float geometryRoughness = max( max( dxy.x, dxy.y ), dxy.z );
material.roughness = max( roughnessFactor, 0.0525 );material.roughness += geometryRoughness;
material.roughness = min( material.roughness, 1.0 );
#ifdef IOR
	material.ior = ior;
	#ifdef USE_SPECULAR
		float specularIntensityFactor = specularIntensity;
		vec3 specularColorFactor = specularColor;
		#ifdef USE_SPECULAR_COLORMAP
			specularColorFactor *= texture2D( specularColorMap, vSpecularColorMapUv ).rgb;
		#endif
		#ifdef USE_SPECULAR_INTENSITYMAP
			specularIntensityFactor *= texture2D( specularIntensityMap, vSpecularIntensityMapUv ).a;
		#endif
		material.specularF90 = mix( specularIntensityFactor, 1.0, metalnessFactor );
	#else
		float specularIntensityFactor = 1.0;
		vec3 specularColorFactor = vec3( 1.0 );
		material.specularF90 = 1.0;
	#endif
	material.specularColor = mix( min( pow2( ( material.ior - 1.0 ) / ( material.ior + 1.0 ) ) * specularColorFactor, vec3( 1.0 ) ) * specularIntensityFactor, diffuseColor.rgb, metalnessFactor );
#else
	material.specularColor = mix( vec3( 0.04 ), diffuseColor.rgb, metalnessFactor );
	material.specularF90 = 1.0;
#endif
#ifdef USE_CLEARCOAT
	material.clearcoat = clearcoat;
	material.clearcoatRoughness = clearcoatRoughness;
	material.clearcoatF0 = vec3( 0.04 );
	material.clearcoatF90 = 1.0;
	#ifdef USE_CLEARCOATMAP
		material.clearcoat *= texture2D( clearcoatMap, vClearcoatMapUv ).x;
	#endif
	#ifdef USE_CLEARCOAT_ROUGHNESSMAP
		material.clearcoatRoughness *= texture2D( clearcoatRoughnessMap, vClearcoatRoughnessMapUv ).y;
	#endif
	material.clearcoat = saturate( material.clearcoat );	material.clearcoatRoughness = max( material.clearcoatRoughness, 0.0525 );
	material.clearcoatRoughness += geometryRoughness;
	material.clearcoatRoughness = min( material.clearcoatRoughness, 1.0 );
#endif
#ifdef USE_DISPERSION
	material.dispersion = dispersion;
#endif
#ifdef USE_IRIDESCENCE
	material.iridescence = iridescence;
	material.iridescenceIOR = iridescenceIOR;
	#ifdef USE_IRIDESCENCEMAP
		material.iridescence *= texture2D( iridescenceMap, vIridescenceMapUv ).r;
	#endif
	#ifdef USE_IRIDESCENCE_THICKNESSMAP
		material.iridescenceThickness = (iridescenceThicknessMaximum - iridescenceThicknessMinimum) * texture2D( iridescenceThicknessMap, vIridescenceThicknessMapUv ).g + iridescenceThicknessMinimum;
	#else
		material.iridescenceThickness = iridescenceThicknessMaximum;
	#endif
#endif
#ifdef USE_SHEEN
	material.sheenColor = sheenColor;
	#ifdef USE_SHEEN_COLORMAP
		material.sheenColor *= texture2D( sheenColorMap, vSheenColorMapUv ).rgb;
	#endif
	material.sheenRoughness = clamp( sheenRoughness, 0.07, 1.0 );
	#ifdef USE_SHEEN_ROUGHNESSMAP
		material.sheenRoughness *= texture2D( sheenRoughnessMap, vSheenRoughnessMapUv ).a;
	#endif
#endif
#ifdef USE_ANISOTROPY
	#ifdef USE_ANISOTROPYMAP
		mat2 anisotropyMat = mat2( anisotropyVector.x, anisotropyVector.y, - anisotropyVector.y, anisotropyVector.x );
		vec3 anisotropyPolar = texture2D( anisotropyMap, vAnisotropyMapUv ).rgb;
		vec2 anisotropyV = anisotropyMat * normalize( 2.0 * anisotropyPolar.rg - vec2( 1.0 ) ) * anisotropyPolar.b;
	#else
		vec2 anisotropyV = anisotropyVector;
	#endif
	material.anisotropy = length( anisotropyV );
	if( material.anisotropy == 0.0 ) {
		anisotropyV = vec2( 1.0, 0.0 );
	} else {
		anisotropyV /= material.anisotropy;
		material.anisotropy = saturate( material.anisotropy );
	}
	material.alphaT = mix( pow2( material.roughness ), 1.0, pow2( material.anisotropy ) );
	material.anisotropyT = tbn[ 0 ] * anisotropyV.x + tbn[ 1 ] * anisotropyV.y;
	material.anisotropyB = tbn[ 1 ] * anisotropyV.x - tbn[ 0 ] * anisotropyV.y;
#endif`,Yg=`struct PhysicalMaterial {
	vec3 diffuseColor;
	float roughness;
	vec3 specularColor;
	float specularF90;
	float dispersion;
	#ifdef USE_CLEARCOAT
		float clearcoat;
		float clearcoatRoughness;
		vec3 clearcoatF0;
		float clearcoatF90;
	#endif
	#ifdef USE_IRIDESCENCE
		float iridescence;
		float iridescenceIOR;
		float iridescenceThickness;
		vec3 iridescenceFresnel;
		vec3 iridescenceF0;
	#endif
	#ifdef USE_SHEEN
		vec3 sheenColor;
		float sheenRoughness;
	#endif
	#ifdef IOR
		float ior;
	#endif
	#ifdef USE_TRANSMISSION
		float transmission;
		float transmissionAlpha;
		float thickness;
		float attenuationDistance;
		vec3 attenuationColor;
	#endif
	#ifdef USE_ANISOTROPY
		float anisotropy;
		float alphaT;
		vec3 anisotropyT;
		vec3 anisotropyB;
	#endif
};
vec3 clearcoatSpecularDirect = vec3( 0.0 );
vec3 clearcoatSpecularIndirect = vec3( 0.0 );
vec3 sheenSpecularDirect = vec3( 0.0 );
vec3 sheenSpecularIndirect = vec3(0.0 );
vec3 Schlick_to_F0( const in vec3 f, const in float f90, const in float dotVH ) {
    float x = clamp( 1.0 - dotVH, 0.0, 1.0 );
    float x2 = x * x;
    float x5 = clamp( x * x2 * x2, 0.0, 0.9999 );
    return ( f - vec3( f90 ) * x5 ) / ( 1.0 - x5 );
}
float V_GGX_SmithCorrelated( const in float alpha, const in float dotNL, const in float dotNV ) {
	float a2 = pow2( alpha );
	float gv = dotNL * sqrt( a2 + ( 1.0 - a2 ) * pow2( dotNV ) );
	float gl = dotNV * sqrt( a2 + ( 1.0 - a2 ) * pow2( dotNL ) );
	return 0.5 / max( gv + gl, EPSILON );
}
float D_GGX( const in float alpha, const in float dotNH ) {
	float a2 = pow2( alpha );
	float denom = pow2( dotNH ) * ( a2 - 1.0 ) + 1.0;
	return RECIPROCAL_PI * a2 / pow2( denom );
}
#ifdef USE_ANISOTROPY
	float V_GGX_SmithCorrelated_Anisotropic( const in float alphaT, const in float alphaB, const in float dotTV, const in float dotBV, const in float dotTL, const in float dotBL, const in float dotNV, const in float dotNL ) {
		float gv = dotNL * length( vec3( alphaT * dotTV, alphaB * dotBV, dotNV ) );
		float gl = dotNV * length( vec3( alphaT * dotTL, alphaB * dotBL, dotNL ) );
		float v = 0.5 / ( gv + gl );
		return saturate(v);
	}
	float D_GGX_Anisotropic( const in float alphaT, const in float alphaB, const in float dotNH, const in float dotTH, const in float dotBH ) {
		float a2 = alphaT * alphaB;
		highp vec3 v = vec3( alphaB * dotTH, alphaT * dotBH, a2 * dotNH );
		highp float v2 = dot( v, v );
		float w2 = a2 / v2;
		return RECIPROCAL_PI * a2 * pow2 ( w2 );
	}
#endif
#ifdef USE_CLEARCOAT
	vec3 BRDF_GGX_Clearcoat( const in vec3 lightDir, const in vec3 viewDir, const in vec3 normal, const in PhysicalMaterial material) {
		vec3 f0 = material.clearcoatF0;
		float f90 = material.clearcoatF90;
		float roughness = material.clearcoatRoughness;
		float alpha = pow2( roughness );
		vec3 halfDir = normalize( lightDir + viewDir );
		float dotNL = saturate( dot( normal, lightDir ) );
		float dotNV = saturate( dot( normal, viewDir ) );
		float dotNH = saturate( dot( normal, halfDir ) );
		float dotVH = saturate( dot( viewDir, halfDir ) );
		vec3 F = F_Schlick( f0, f90, dotVH );
		float V = V_GGX_SmithCorrelated( alpha, dotNL, dotNV );
		float D = D_GGX( alpha, dotNH );
		return F * ( V * D );
	}
#endif
vec3 BRDF_GGX( const in vec3 lightDir, const in vec3 viewDir, const in vec3 normal, const in PhysicalMaterial material ) {
	vec3 f0 = material.specularColor;
	float f90 = material.specularF90;
	float roughness = material.roughness;
	float alpha = pow2( roughness );
	vec3 halfDir = normalize( lightDir + viewDir );
	float dotNL = saturate( dot( normal, lightDir ) );
	float dotNV = saturate( dot( normal, viewDir ) );
	float dotNH = saturate( dot( normal, halfDir ) );
	float dotVH = saturate( dot( viewDir, halfDir ) );
	vec3 F = F_Schlick( f0, f90, dotVH );
	#ifdef USE_IRIDESCENCE
		F = mix( F, material.iridescenceFresnel, material.iridescence );
	#endif
	#ifdef USE_ANISOTROPY
		float dotTL = dot( material.anisotropyT, lightDir );
		float dotTV = dot( material.anisotropyT, viewDir );
		float dotTH = dot( material.anisotropyT, halfDir );
		float dotBL = dot( material.anisotropyB, lightDir );
		float dotBV = dot( material.anisotropyB, viewDir );
		float dotBH = dot( material.anisotropyB, halfDir );
		float V = V_GGX_SmithCorrelated_Anisotropic( material.alphaT, alpha, dotTV, dotBV, dotTL, dotBL, dotNV, dotNL );
		float D = D_GGX_Anisotropic( material.alphaT, alpha, dotNH, dotTH, dotBH );
	#else
		float V = V_GGX_SmithCorrelated( alpha, dotNL, dotNV );
		float D = D_GGX( alpha, dotNH );
	#endif
	return F * ( V * D );
}
vec2 LTC_Uv( const in vec3 N, const in vec3 V, const in float roughness ) {
	const float LUT_SIZE = 64.0;
	const float LUT_SCALE = ( LUT_SIZE - 1.0 ) / LUT_SIZE;
	const float LUT_BIAS = 0.5 / LUT_SIZE;
	float dotNV = saturate( dot( N, V ) );
	vec2 uv = vec2( roughness, sqrt( 1.0 - dotNV ) );
	uv = uv * LUT_SCALE + LUT_BIAS;
	return uv;
}
float LTC_ClippedSphereFormFactor( const in vec3 f ) {
	float l = length( f );
	return max( ( l * l + f.z ) / ( l + 1.0 ), 0.0 );
}
vec3 LTC_EdgeVectorFormFactor( const in vec3 v1, const in vec3 v2 ) {
	float x = dot( v1, v2 );
	float y = abs( x );
	float a = 0.8543985 + ( 0.4965155 + 0.0145206 * y ) * y;
	float b = 3.4175940 + ( 4.1616724 + y ) * y;
	float v = a / b;
	float theta_sintheta = ( x > 0.0 ) ? v : 0.5 * inversesqrt( max( 1.0 - x * x, 1e-7 ) ) - v;
	return cross( v1, v2 ) * theta_sintheta;
}
vec3 LTC_Evaluate( const in vec3 N, const in vec3 V, const in vec3 P, const in mat3 mInv, const in vec3 rectCoords[ 4 ] ) {
	vec3 v1 = rectCoords[ 1 ] - rectCoords[ 0 ];
	vec3 v2 = rectCoords[ 3 ] - rectCoords[ 0 ];
	vec3 lightNormal = cross( v1, v2 );
	if( dot( lightNormal, P - rectCoords[ 0 ] ) < 0.0 ) return vec3( 0.0 );
	vec3 T1, T2;
	T1 = normalize( V - N * dot( V, N ) );
	T2 = - cross( N, T1 );
	mat3 mat = mInv * transposeMat3( mat3( T1, T2, N ) );
	vec3 coords[ 4 ];
	coords[ 0 ] = mat * ( rectCoords[ 0 ] - P );
	coords[ 1 ] = mat * ( rectCoords[ 1 ] - P );
	coords[ 2 ] = mat * ( rectCoords[ 2 ] - P );
	coords[ 3 ] = mat * ( rectCoords[ 3 ] - P );
	coords[ 0 ] = normalize( coords[ 0 ] );
	coords[ 1 ] = normalize( coords[ 1 ] );
	coords[ 2 ] = normalize( coords[ 2 ] );
	coords[ 3 ] = normalize( coords[ 3 ] );
	vec3 vectorFormFactor = vec3( 0.0 );
	vectorFormFactor += LTC_EdgeVectorFormFactor( coords[ 0 ], coords[ 1 ] );
	vectorFormFactor += LTC_EdgeVectorFormFactor( coords[ 1 ], coords[ 2 ] );
	vectorFormFactor += LTC_EdgeVectorFormFactor( coords[ 2 ], coords[ 3 ] );
	vectorFormFactor += LTC_EdgeVectorFormFactor( coords[ 3 ], coords[ 0 ] );
	float result = LTC_ClippedSphereFormFactor( vectorFormFactor );
	return vec3( result );
}
#if defined( USE_SHEEN )
float D_Charlie( float roughness, float dotNH ) {
	float alpha = pow2( roughness );
	float invAlpha = 1.0 / alpha;
	float cos2h = dotNH * dotNH;
	float sin2h = max( 1.0 - cos2h, 0.0078125 );
	return ( 2.0 + invAlpha ) * pow( sin2h, invAlpha * 0.5 ) / ( 2.0 * PI );
}
float V_Neubelt( float dotNV, float dotNL ) {
	return saturate( 1.0 / ( 4.0 * ( dotNL + dotNV - dotNL * dotNV ) ) );
}
vec3 BRDF_Sheen( const in vec3 lightDir, const in vec3 viewDir, const in vec3 normal, vec3 sheenColor, const in float sheenRoughness ) {
	vec3 halfDir = normalize( lightDir + viewDir );
	float dotNL = saturate( dot( normal, lightDir ) );
	float dotNV = saturate( dot( normal, viewDir ) );
	float dotNH = saturate( dot( normal, halfDir ) );
	float D = D_Charlie( sheenRoughness, dotNH );
	float V = V_Neubelt( dotNV, dotNL );
	return sheenColor * ( D * V );
}
#endif
float IBLSheenBRDF( const in vec3 normal, const in vec3 viewDir, const in float roughness ) {
	float dotNV = saturate( dot( normal, viewDir ) );
	float r2 = roughness * roughness;
	float a = roughness < 0.25 ? -339.2 * r2 + 161.4 * roughness - 25.9 : -8.48 * r2 + 14.3 * roughness - 9.95;
	float b = roughness < 0.25 ? 44.0 * r2 - 23.7 * roughness + 3.26 : 1.97 * r2 - 3.27 * roughness + 0.72;
	float DG = exp( a * dotNV + b ) + ( roughness < 0.25 ? 0.0 : 0.1 * ( roughness - 0.25 ) );
	return saturate( DG * RECIPROCAL_PI );
}
vec2 DFGApprox( const in vec3 normal, const in vec3 viewDir, const in float roughness ) {
	float dotNV = saturate( dot( normal, viewDir ) );
	const vec4 c0 = vec4( - 1, - 0.0275, - 0.572, 0.022 );
	const vec4 c1 = vec4( 1, 0.0425, 1.04, - 0.04 );
	vec4 r = roughness * c0 + c1;
	float a004 = min( r.x * r.x, exp2( - 9.28 * dotNV ) ) * r.x + r.y;
	vec2 fab = vec2( - 1.04, 1.04 ) * a004 + r.zw;
	return fab;
}
vec3 EnvironmentBRDF( const in vec3 normal, const in vec3 viewDir, const in vec3 specularColor, const in float specularF90, const in float roughness ) {
	vec2 fab = DFGApprox( normal, viewDir, roughness );
	return specularColor * fab.x + specularF90 * fab.y;
}
#ifdef USE_IRIDESCENCE
void computeMultiscatteringIridescence( const in vec3 normal, const in vec3 viewDir, const in vec3 specularColor, const in float specularF90, const in float iridescence, const in vec3 iridescenceF0, const in float roughness, inout vec3 singleScatter, inout vec3 multiScatter ) {
#else
void computeMultiscattering( const in vec3 normal, const in vec3 viewDir, const in vec3 specularColor, const in float specularF90, const in float roughness, inout vec3 singleScatter, inout vec3 multiScatter ) {
#endif
	vec2 fab = DFGApprox( normal, viewDir, roughness );
	#ifdef USE_IRIDESCENCE
		vec3 Fr = mix( specularColor, iridescenceF0, iridescence );
	#else
		vec3 Fr = specularColor;
	#endif
	vec3 FssEss = Fr * fab.x + specularF90 * fab.y;
	float Ess = fab.x + fab.y;
	float Ems = 1.0 - Ess;
	vec3 Favg = Fr + ( 1.0 - Fr ) * 0.047619;	vec3 Fms = FssEss * Favg / ( 1.0 - Ems * Favg );
	singleScatter += FssEss;
	multiScatter += Fms * Ems;
}
#if NUM_RECT_AREA_LIGHTS > 0
	void RE_Direct_RectArea_Physical( const in RectAreaLight rectAreaLight, const in vec3 geometryPosition, const in vec3 geometryNormal, const in vec3 geometryViewDir, const in vec3 geometryClearcoatNormal, const in PhysicalMaterial material, inout ReflectedLight reflectedLight ) {
		vec3 normal = geometryNormal;
		vec3 viewDir = geometryViewDir;
		vec3 position = geometryPosition;
		vec3 lightPos = rectAreaLight.position;
		vec3 halfWidth = rectAreaLight.halfWidth;
		vec3 halfHeight = rectAreaLight.halfHeight;
		vec3 lightColor = rectAreaLight.color;
		float roughness = material.roughness;
		vec3 rectCoords[ 4 ];
		rectCoords[ 0 ] = lightPos + halfWidth - halfHeight;		rectCoords[ 1 ] = lightPos - halfWidth - halfHeight;
		rectCoords[ 2 ] = lightPos - halfWidth + halfHeight;
		rectCoords[ 3 ] = lightPos + halfWidth + halfHeight;
		vec2 uv = LTC_Uv( normal, viewDir, roughness );
		vec4 t1 = texture2D( ltc_1, uv );
		vec4 t2 = texture2D( ltc_2, uv );
		mat3 mInv = mat3(
			vec3( t1.x, 0, t1.y ),
			vec3(    0, 1,    0 ),
			vec3( t1.z, 0, t1.w )
		);
		vec3 fresnel = ( material.specularColor * t2.x + ( vec3( 1.0 ) - material.specularColor ) * t2.y );
		reflectedLight.directSpecular += lightColor * fresnel * LTC_Evaluate( normal, viewDir, position, mInv, rectCoords );
		reflectedLight.directDiffuse += lightColor * material.diffuseColor * LTC_Evaluate( normal, viewDir, position, mat3( 1.0 ), rectCoords );
	}
#endif
void RE_Direct_Physical( const in IncidentLight directLight, const in vec3 geometryPosition, const in vec3 geometryNormal, const in vec3 geometryViewDir, const in vec3 geometryClearcoatNormal, const in PhysicalMaterial material, inout ReflectedLight reflectedLight ) {
	float dotNL = saturate( dot( geometryNormal, directLight.direction ) );
	vec3 irradiance = dotNL * directLight.color;
	#ifdef USE_CLEARCOAT
		float dotNLcc = saturate( dot( geometryClearcoatNormal, directLight.direction ) );
		vec3 ccIrradiance = dotNLcc * directLight.color;
		clearcoatSpecularDirect += ccIrradiance * BRDF_GGX_Clearcoat( directLight.direction, geometryViewDir, geometryClearcoatNormal, material );
	#endif
	#ifdef USE_SHEEN
		sheenSpecularDirect += irradiance * BRDF_Sheen( directLight.direction, geometryViewDir, geometryNormal, material.sheenColor, material.sheenRoughness );
	#endif
	reflectedLight.directSpecular += irradiance * BRDF_GGX( directLight.direction, geometryViewDir, geometryNormal, material );
	reflectedLight.directDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
void RE_IndirectDiffuse_Physical( const in vec3 irradiance, const in vec3 geometryPosition, const in vec3 geometryNormal, const in vec3 geometryViewDir, const in vec3 geometryClearcoatNormal, const in PhysicalMaterial material, inout ReflectedLight reflectedLight ) {
	reflectedLight.indirectDiffuse += irradiance * BRDF_Lambert( material.diffuseColor );
}
void RE_IndirectSpecular_Physical( const in vec3 radiance, const in vec3 irradiance, const in vec3 clearcoatRadiance, const in vec3 geometryPosition, const in vec3 geometryNormal, const in vec3 geometryViewDir, const in vec3 geometryClearcoatNormal, const in PhysicalMaterial material, inout ReflectedLight reflectedLight) {
	#ifdef USE_CLEARCOAT
		clearcoatSpecularIndirect += clearcoatRadiance * EnvironmentBRDF( geometryClearcoatNormal, geometryViewDir, material.clearcoatF0, material.clearcoatF90, material.clearcoatRoughness );
	#endif
	#ifdef USE_SHEEN
		sheenSpecularIndirect += irradiance * material.sheenColor * IBLSheenBRDF( geometryNormal, geometryViewDir, material.sheenRoughness );
	#endif
	vec3 singleScattering = vec3( 0.0 );
	vec3 multiScattering = vec3( 0.0 );
	vec3 cosineWeightedIrradiance = irradiance * RECIPROCAL_PI;
	#ifdef USE_IRIDESCENCE
		computeMultiscatteringIridescence( geometryNormal, geometryViewDir, material.specularColor, material.specularF90, material.iridescence, material.iridescenceFresnel, material.roughness, singleScattering, multiScattering );
	#else
		computeMultiscattering( geometryNormal, geometryViewDir, material.specularColor, material.specularF90, material.roughness, singleScattering, multiScattering );
	#endif
	vec3 totalScattering = singleScattering + multiScattering;
	vec3 diffuse = material.diffuseColor * ( 1.0 - max( max( totalScattering.r, totalScattering.g ), totalScattering.b ) );
	reflectedLight.indirectSpecular += radiance * singleScattering;
	reflectedLight.indirectSpecular += multiScattering * cosineWeightedIrradiance;
	reflectedLight.indirectDiffuse += diffuse * cosineWeightedIrradiance;
}
#define RE_Direct				RE_Direct_Physical
#define RE_Direct_RectArea		RE_Direct_RectArea_Physical
#define RE_IndirectDiffuse		RE_IndirectDiffuse_Physical
#define RE_IndirectSpecular		RE_IndirectSpecular_Physical
float computeSpecularOcclusion( const in float dotNV, const in float ambientOcclusion, const in float roughness ) {
	return saturate( pow( dotNV + ambientOcclusion, exp2( - 16.0 * roughness - 1.0 ) ) - 1.0 + ambientOcclusion );
}`,$g=`
vec3 geometryPosition = - vViewPosition;
vec3 geometryNormal = normal;
vec3 geometryViewDir = ( isOrthographic ) ? vec3( 0, 0, 1 ) : normalize( vViewPosition );
vec3 geometryClearcoatNormal = vec3( 0.0 );
#ifdef USE_CLEARCOAT
	geometryClearcoatNormal = clearcoatNormal;
#endif
#ifdef USE_IRIDESCENCE
	float dotNVi = saturate( dot( normal, geometryViewDir ) );
	if ( material.iridescenceThickness == 0.0 ) {
		material.iridescence = 0.0;
	} else {
		material.iridescence = saturate( material.iridescence );
	}
	if ( material.iridescence > 0.0 ) {
		material.iridescenceFresnel = evalIridescence( 1.0, material.iridescenceIOR, dotNVi, material.iridescenceThickness, material.specularColor );
		material.iridescenceF0 = Schlick_to_F0( material.iridescenceFresnel, 1.0, dotNVi );
	}
#endif
IncidentLight directLight;
#if ( NUM_POINT_LIGHTS > 0 ) && defined( RE_Direct )
	PointLight pointLight;
	#if defined( USE_SHADOWMAP ) && NUM_POINT_LIGHT_SHADOWS > 0
	PointLightShadow pointLightShadow;
	#endif
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_POINT_LIGHTS; i ++ ) {
		pointLight = pointLights[ i ];
		getPointLightInfo( pointLight, geometryPosition, directLight );
		#if defined( USE_SHADOWMAP ) && ( UNROLLED_LOOP_INDEX < NUM_POINT_LIGHT_SHADOWS )
		pointLightShadow = pointLightShadows[ i ];
		directLight.color *= ( directLight.visible && receiveShadow ) ? getPointShadow( pointShadowMap[ i ], pointLightShadow.shadowMapSize, pointLightShadow.shadowIntensity, pointLightShadow.shadowBias, pointLightShadow.shadowRadius, vPointShadowCoord[ i ], pointLightShadow.shadowCameraNear, pointLightShadow.shadowCameraFar ) : 1.0;
		#endif
		RE_Direct( directLight, geometryPosition, geometryNormal, geometryViewDir, geometryClearcoatNormal, material, reflectedLight );
	}
	#pragma unroll_loop_end
#endif
#if ( NUM_SPOT_LIGHTS > 0 ) && defined( RE_Direct )
	SpotLight spotLight;
	vec4 spotColor;
	vec3 spotLightCoord;
	bool inSpotLightMap;
	#if defined( USE_SHADOWMAP ) && NUM_SPOT_LIGHT_SHADOWS > 0
	SpotLightShadow spotLightShadow;
	#endif
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_SPOT_LIGHTS; i ++ ) {
		spotLight = spotLights[ i ];
		getSpotLightInfo( spotLight, geometryPosition, directLight );
		#if ( UNROLLED_LOOP_INDEX < NUM_SPOT_LIGHT_SHADOWS_WITH_MAPS )
		#define SPOT_LIGHT_MAP_INDEX UNROLLED_LOOP_INDEX
		#elif ( UNROLLED_LOOP_INDEX < NUM_SPOT_LIGHT_SHADOWS )
		#define SPOT_LIGHT_MAP_INDEX NUM_SPOT_LIGHT_MAPS
		#else
		#define SPOT_LIGHT_MAP_INDEX ( UNROLLED_LOOP_INDEX - NUM_SPOT_LIGHT_SHADOWS + NUM_SPOT_LIGHT_SHADOWS_WITH_MAPS )
		#endif
		#if ( SPOT_LIGHT_MAP_INDEX < NUM_SPOT_LIGHT_MAPS )
			spotLightCoord = vSpotLightCoord[ i ].xyz / vSpotLightCoord[ i ].w;
			inSpotLightMap = all( lessThan( abs( spotLightCoord * 2. - 1. ), vec3( 1.0 ) ) );
			spotColor = texture2D( spotLightMap[ SPOT_LIGHT_MAP_INDEX ], spotLightCoord.xy );
			directLight.color = inSpotLightMap ? directLight.color * spotColor.rgb : directLight.color;
		#endif
		#undef SPOT_LIGHT_MAP_INDEX
		#if defined( USE_SHADOWMAP ) && ( UNROLLED_LOOP_INDEX < NUM_SPOT_LIGHT_SHADOWS )
		spotLightShadow = spotLightShadows[ i ];
		directLight.color *= ( directLight.visible && receiveShadow ) ? getShadow( spotShadowMap[ i ], spotLightShadow.shadowMapSize, spotLightShadow.shadowIntensity, spotLightShadow.shadowBias, spotLightShadow.shadowRadius, vSpotLightCoord[ i ] ) : 1.0;
		#endif
		RE_Direct( directLight, geometryPosition, geometryNormal, geometryViewDir, geometryClearcoatNormal, material, reflectedLight );
	}
	#pragma unroll_loop_end
#endif
#if ( NUM_DIR_LIGHTS > 0 ) && defined( RE_Direct )
	DirectionalLight directionalLight;
	#if defined( USE_SHADOWMAP ) && NUM_DIR_LIGHT_SHADOWS > 0
	DirectionalLightShadow directionalLightShadow;
	#endif
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_DIR_LIGHTS; i ++ ) {
		directionalLight = directionalLights[ i ];
		getDirectionalLightInfo( directionalLight, directLight );
		#if defined( USE_SHADOWMAP ) && ( UNROLLED_LOOP_INDEX < NUM_DIR_LIGHT_SHADOWS )
		directionalLightShadow = directionalLightShadows[ i ];
		directLight.color *= ( directLight.visible && receiveShadow ) ? getShadow( directionalShadowMap[ i ], directionalLightShadow.shadowMapSize, directionalLightShadow.shadowIntensity, directionalLightShadow.shadowBias, directionalLightShadow.shadowRadius, vDirectionalShadowCoord[ i ] ) : 1.0;
		#endif
		RE_Direct( directLight, geometryPosition, geometryNormal, geometryViewDir, geometryClearcoatNormal, material, reflectedLight );
	}
	#pragma unroll_loop_end
#endif
#if ( NUM_RECT_AREA_LIGHTS > 0 ) && defined( RE_Direct_RectArea )
	RectAreaLight rectAreaLight;
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_RECT_AREA_LIGHTS; i ++ ) {
		rectAreaLight = rectAreaLights[ i ];
		RE_Direct_RectArea( rectAreaLight, geometryPosition, geometryNormal, geometryViewDir, geometryClearcoatNormal, material, reflectedLight );
	}
	#pragma unroll_loop_end
#endif
#if defined( RE_IndirectDiffuse )
	vec3 iblIrradiance = vec3( 0.0 );
	vec3 irradiance = getAmbientLightIrradiance( ambientLightColor );
	#if defined( USE_LIGHT_PROBES )
		irradiance += getLightProbeIrradiance( lightProbe, geometryNormal );
	#endif
	#if ( NUM_HEMI_LIGHTS > 0 )
		#pragma unroll_loop_start
		for ( int i = 0; i < NUM_HEMI_LIGHTS; i ++ ) {
			irradiance += getHemisphereLightIrradiance( hemisphereLights[ i ], geometryNormal );
		}
		#pragma unroll_loop_end
	#endif
#endif
#if defined( RE_IndirectSpecular )
	vec3 radiance = vec3( 0.0 );
	vec3 clearcoatRadiance = vec3( 0.0 );
#endif`,jg=`#if defined( RE_IndirectDiffuse )
	#ifdef USE_LIGHTMAP
		vec4 lightMapTexel = texture2D( lightMap, vLightMapUv );
		vec3 lightMapIrradiance = lightMapTexel.rgb * lightMapIntensity;
		irradiance += lightMapIrradiance;
	#endif
	#if defined( USE_ENVMAP ) && defined( STANDARD ) && defined( ENVMAP_TYPE_CUBE_UV )
		iblIrradiance += getIBLIrradiance( geometryNormal );
	#endif
#endif
#if defined( USE_ENVMAP ) && defined( RE_IndirectSpecular )
	#ifdef USE_ANISOTROPY
		radiance += getIBLAnisotropyRadiance( geometryViewDir, geometryNormal, material.roughness, material.anisotropyB, material.anisotropy );
	#else
		radiance += getIBLRadiance( geometryViewDir, geometryNormal, material.roughness );
	#endif
	#ifdef USE_CLEARCOAT
		clearcoatRadiance += getIBLRadiance( geometryViewDir, geometryClearcoatNormal, material.clearcoatRoughness );
	#endif
#endif`,Kg=`#if defined( RE_IndirectDiffuse )
	RE_IndirectDiffuse( irradiance, geometryPosition, geometryNormal, geometryViewDir, geometryClearcoatNormal, material, reflectedLight );
#endif
#if defined( RE_IndirectSpecular )
	RE_IndirectSpecular( radiance, iblIrradiance, clearcoatRadiance, geometryPosition, geometryNormal, geometryViewDir, geometryClearcoatNormal, material, reflectedLight );
#endif`,Zg=`#if defined( USE_LOGDEPTHBUF )
	gl_FragDepth = vIsPerspective == 0.0 ? gl_FragCoord.z : log2( vFragDepth ) * logDepthBufFC * 0.5;
#endif`,Jg=`#if defined( USE_LOGDEPTHBUF )
	uniform float logDepthBufFC;
	varying float vFragDepth;
	varying float vIsPerspective;
#endif`,Qg=`#ifdef USE_LOGDEPTHBUF
	varying float vFragDepth;
	varying float vIsPerspective;
#endif`,tm=`#ifdef USE_LOGDEPTHBUF
	vFragDepth = 1.0 + gl_Position.w;
	vIsPerspective = float( isPerspectiveMatrix( projectionMatrix ) );
#endif`,em=`#ifdef USE_MAP
	vec4 sampledDiffuseColor = texture2D( map, vMapUv );
	#ifdef DECODE_VIDEO_TEXTURE
		sampledDiffuseColor = sRGBTransferEOTF( sampledDiffuseColor );
	#endif
	diffuseColor *= sampledDiffuseColor;
#endif`,nm=`#ifdef USE_MAP
	uniform sampler2D map;
#endif`,im=`#if defined( USE_MAP ) || defined( USE_ALPHAMAP )
	#if defined( USE_POINTS_UV )
		vec2 uv = vUv;
	#else
		vec2 uv = ( uvTransform * vec3( gl_PointCoord.x, 1.0 - gl_PointCoord.y, 1 ) ).xy;
	#endif
#endif
#ifdef USE_MAP
	diffuseColor *= texture2D( map, uv );
#endif
#ifdef USE_ALPHAMAP
	diffuseColor.a *= texture2D( alphaMap, uv ).g;
#endif`,rm=`#if defined( USE_POINTS_UV )
	varying vec2 vUv;
#else
	#if defined( USE_MAP ) || defined( USE_ALPHAMAP )
		uniform mat3 uvTransform;
	#endif
#endif
#ifdef USE_MAP
	uniform sampler2D map;
#endif
#ifdef USE_ALPHAMAP
	uniform sampler2D alphaMap;
#endif`,sm=`float metalnessFactor = metalness;
#ifdef USE_METALNESSMAP
	vec4 texelMetalness = texture2D( metalnessMap, vMetalnessMapUv );
	metalnessFactor *= texelMetalness.b;
#endif`,om=`#ifdef USE_METALNESSMAP
	uniform sampler2D metalnessMap;
#endif`,am=`#ifdef USE_INSTANCING_MORPH
	float morphTargetInfluences[ MORPHTARGETS_COUNT ];
	float morphTargetBaseInfluence = texelFetch( morphTexture, ivec2( 0, gl_InstanceID ), 0 ).r;
	for ( int i = 0; i < MORPHTARGETS_COUNT; i ++ ) {
		morphTargetInfluences[i] =  texelFetch( morphTexture, ivec2( i + 1, gl_InstanceID ), 0 ).r;
	}
#endif`,cm=`#if defined( USE_MORPHCOLORS )
	vColor *= morphTargetBaseInfluence;
	for ( int i = 0; i < MORPHTARGETS_COUNT; i ++ ) {
		#if defined( USE_COLOR_ALPHA )
			if ( morphTargetInfluences[ i ] != 0.0 ) vColor += getMorph( gl_VertexID, i, 2 ) * morphTargetInfluences[ i ];
		#elif defined( USE_COLOR )
			if ( morphTargetInfluences[ i ] != 0.0 ) vColor += getMorph( gl_VertexID, i, 2 ).rgb * morphTargetInfluences[ i ];
		#endif
	}
#endif`,lm=`#ifdef USE_MORPHNORMALS
	objectNormal *= morphTargetBaseInfluence;
	for ( int i = 0; i < MORPHTARGETS_COUNT; i ++ ) {
		if ( morphTargetInfluences[ i ] != 0.0 ) objectNormal += getMorph( gl_VertexID, i, 1 ).xyz * morphTargetInfluences[ i ];
	}
#endif`,um=`#ifdef USE_MORPHTARGETS
	#ifndef USE_INSTANCING_MORPH
		uniform float morphTargetBaseInfluence;
		uniform float morphTargetInfluences[ MORPHTARGETS_COUNT ];
	#endif
	uniform sampler2DArray morphTargetsTexture;
	uniform ivec2 morphTargetsTextureSize;
	vec4 getMorph( const in int vertexIndex, const in int morphTargetIndex, const in int offset ) {
		int texelIndex = vertexIndex * MORPHTARGETS_TEXTURE_STRIDE + offset;
		int y = texelIndex / morphTargetsTextureSize.x;
		int x = texelIndex - y * morphTargetsTextureSize.x;
		ivec3 morphUV = ivec3( x, y, morphTargetIndex );
		return texelFetch( morphTargetsTexture, morphUV, 0 );
	}
#endif`,hm=`#ifdef USE_MORPHTARGETS
	transformed *= morphTargetBaseInfluence;
	for ( int i = 0; i < MORPHTARGETS_COUNT; i ++ ) {
		if ( morphTargetInfluences[ i ] != 0.0 ) transformed += getMorph( gl_VertexID, i, 0 ).xyz * morphTargetInfluences[ i ];
	}
#endif`,fm=`float faceDirection = gl_FrontFacing ? 1.0 : - 1.0;
#ifdef FLAT_SHADED
	vec3 fdx = dFdx( vViewPosition );
	vec3 fdy = dFdy( vViewPosition );
	vec3 normal = normalize( cross( fdx, fdy ) );
#else
	vec3 normal = normalize( vNormal );
	#ifdef DOUBLE_SIDED
		normal *= faceDirection;
	#endif
#endif
#if defined( USE_NORMALMAP_TANGENTSPACE ) || defined( USE_CLEARCOAT_NORMALMAP ) || defined( USE_ANISOTROPY )
	#ifdef USE_TANGENT
		mat3 tbn = mat3( normalize( vTangent ), normalize( vBitangent ), normal );
	#else
		mat3 tbn = getTangentFrame( - vViewPosition, normal,
		#if defined( USE_NORMALMAP )
			vNormalMapUv
		#elif defined( USE_CLEARCOAT_NORMALMAP )
			vClearcoatNormalMapUv
		#else
			vUv
		#endif
		);
	#endif
	#if defined( DOUBLE_SIDED ) && ! defined( FLAT_SHADED )
		tbn[0] *= faceDirection;
		tbn[1] *= faceDirection;
	#endif
#endif
#ifdef USE_CLEARCOAT_NORMALMAP
	#ifdef USE_TANGENT
		mat3 tbn2 = mat3( normalize( vTangent ), normalize( vBitangent ), normal );
	#else
		mat3 tbn2 = getTangentFrame( - vViewPosition, normal, vClearcoatNormalMapUv );
	#endif
	#if defined( DOUBLE_SIDED ) && ! defined( FLAT_SHADED )
		tbn2[0] *= faceDirection;
		tbn2[1] *= faceDirection;
	#endif
#endif
vec3 nonPerturbedNormal = normal;`,dm=`#ifdef USE_NORMALMAP_OBJECTSPACE
	normal = texture2D( normalMap, vNormalMapUv ).xyz * 2.0 - 1.0;
	#ifdef FLIP_SIDED
		normal = - normal;
	#endif
	#ifdef DOUBLE_SIDED
		normal = normal * faceDirection;
	#endif
	normal = normalize( normalMatrix * normal );
#elif defined( USE_NORMALMAP_TANGENTSPACE )
	vec3 mapN = texture2D( normalMap, vNormalMapUv ).xyz * 2.0 - 1.0;
	mapN.xy *= normalScale;
	normal = normalize( tbn * mapN );
#elif defined( USE_BUMPMAP )
	normal = perturbNormalArb( - vViewPosition, normal, dHdxy_fwd(), faceDirection );
#endif`,pm=`#ifndef FLAT_SHADED
	varying vec3 vNormal;
	#ifdef USE_TANGENT
		varying vec3 vTangent;
		varying vec3 vBitangent;
	#endif
#endif`,gm=`#ifndef FLAT_SHADED
	varying vec3 vNormal;
	#ifdef USE_TANGENT
		varying vec3 vTangent;
		varying vec3 vBitangent;
	#endif
#endif`,mm=`#ifndef FLAT_SHADED
	vNormal = normalize( transformedNormal );
	#ifdef USE_TANGENT
		vTangent = normalize( transformedTangent );
		vBitangent = normalize( cross( vNormal, vTangent ) * tangent.w );
	#endif
#endif`,_m=`#ifdef USE_NORMALMAP
	uniform sampler2D normalMap;
	uniform vec2 normalScale;
#endif
#ifdef USE_NORMALMAP_OBJECTSPACE
	uniform mat3 normalMatrix;
#endif
#if ! defined ( USE_TANGENT ) && ( defined ( USE_NORMALMAP_TANGENTSPACE ) || defined ( USE_CLEARCOAT_NORMALMAP ) || defined( USE_ANISOTROPY ) )
	mat3 getTangentFrame( vec3 eye_pos, vec3 surf_norm, vec2 uv ) {
		vec3 q0 = dFdx( eye_pos.xyz );
		vec3 q1 = dFdy( eye_pos.xyz );
		vec2 st0 = dFdx( uv.st );
		vec2 st1 = dFdy( uv.st );
		vec3 N = surf_norm;
		vec3 q1perp = cross( q1, N );
		vec3 q0perp = cross( N, q0 );
		vec3 T = q1perp * st0.x + q0perp * st1.x;
		vec3 B = q1perp * st0.y + q0perp * st1.y;
		float det = max( dot( T, T ), dot( B, B ) );
		float scale = ( det == 0.0 ) ? 0.0 : inversesqrt( det );
		return mat3( T * scale, B * scale, N );
	}
#endif`,xm=`#ifdef USE_CLEARCOAT
	vec3 clearcoatNormal = nonPerturbedNormal;
#endif`,vm=`#ifdef USE_CLEARCOAT_NORMALMAP
	vec3 clearcoatMapN = texture2D( clearcoatNormalMap, vClearcoatNormalMapUv ).xyz * 2.0 - 1.0;
	clearcoatMapN.xy *= clearcoatNormalScale;
	clearcoatNormal = normalize( tbn2 * clearcoatMapN );
#endif`,ym=`#ifdef USE_CLEARCOATMAP
	uniform sampler2D clearcoatMap;
#endif
#ifdef USE_CLEARCOAT_NORMALMAP
	uniform sampler2D clearcoatNormalMap;
	uniform vec2 clearcoatNormalScale;
#endif
#ifdef USE_CLEARCOAT_ROUGHNESSMAP
	uniform sampler2D clearcoatRoughnessMap;
#endif`,Sm=`#ifdef USE_IRIDESCENCEMAP
	uniform sampler2D iridescenceMap;
#endif
#ifdef USE_IRIDESCENCE_THICKNESSMAP
	uniform sampler2D iridescenceThicknessMap;
#endif`,Mm=`#ifdef OPAQUE
diffuseColor.a = 1.0;
#endif
#ifdef USE_TRANSMISSION
diffuseColor.a *= material.transmissionAlpha;
#endif
gl_FragColor = vec4( outgoingLight, diffuseColor.a );`,Em=`vec3 packNormalToRGB( const in vec3 normal ) {
	return normalize( normal ) * 0.5 + 0.5;
}
vec3 unpackRGBToNormal( const in vec3 rgb ) {
	return 2.0 * rgb.xyz - 1.0;
}
const float PackUpscale = 256. / 255.;const float UnpackDownscale = 255. / 256.;const float ShiftRight8 = 1. / 256.;
const float Inv255 = 1. / 255.;
const vec4 PackFactors = vec4( 1.0, 256.0, 256.0 * 256.0, 256.0 * 256.0 * 256.0 );
const vec2 UnpackFactors2 = vec2( UnpackDownscale, 1.0 / PackFactors.g );
const vec3 UnpackFactors3 = vec3( UnpackDownscale / PackFactors.rg, 1.0 / PackFactors.b );
const vec4 UnpackFactors4 = vec4( UnpackDownscale / PackFactors.rgb, 1.0 / PackFactors.a );
vec4 packDepthToRGBA( const in float v ) {
	if( v <= 0.0 )
		return vec4( 0., 0., 0., 0. );
	if( v >= 1.0 )
		return vec4( 1., 1., 1., 1. );
	float vuf;
	float af = modf( v * PackFactors.a, vuf );
	float bf = modf( vuf * ShiftRight8, vuf );
	float gf = modf( vuf * ShiftRight8, vuf );
	return vec4( vuf * Inv255, gf * PackUpscale, bf * PackUpscale, af );
}
vec3 packDepthToRGB( const in float v ) {
	if( v <= 0.0 )
		return vec3( 0., 0., 0. );
	if( v >= 1.0 )
		return vec3( 1., 1., 1. );
	float vuf;
	float bf = modf( v * PackFactors.b, vuf );
	float gf = modf( vuf * ShiftRight8, vuf );
	return vec3( vuf * Inv255, gf * PackUpscale, bf );
}
vec2 packDepthToRG( const in float v ) {
	if( v <= 0.0 )
		return vec2( 0., 0. );
	if( v >= 1.0 )
		return vec2( 1., 1. );
	float vuf;
	float gf = modf( v * 256., vuf );
	return vec2( vuf * Inv255, gf );
}
float unpackRGBAToDepth( const in vec4 v ) {
	return dot( v, UnpackFactors4 );
}
float unpackRGBToDepth( const in vec3 v ) {
	return dot( v, UnpackFactors3 );
}
float unpackRGToDepth( const in vec2 v ) {
	return v.r * UnpackFactors2.r + v.g * UnpackFactors2.g;
}
vec4 pack2HalfToRGBA( const in vec2 v ) {
	vec4 r = vec4( v.x, fract( v.x * 255.0 ), v.y, fract( v.y * 255.0 ) );
	return vec4( r.x - r.y / 255.0, r.y, r.z - r.w / 255.0, r.w );
}
vec2 unpackRGBATo2Half( const in vec4 v ) {
	return vec2( v.x + ( v.y / 255.0 ), v.z + ( v.w / 255.0 ) );
}
float viewZToOrthographicDepth( const in float viewZ, const in float near, const in float far ) {
	return ( viewZ + near ) / ( near - far );
}
float orthographicDepthToViewZ( const in float depth, const in float near, const in float far ) {
	return depth * ( near - far ) - near;
}
float viewZToPerspectiveDepth( const in float viewZ, const in float near, const in float far ) {
	return ( ( near + viewZ ) * far ) / ( ( far - near ) * viewZ );
}
float perspectiveDepthToViewZ( const in float depth, const in float near, const in float far ) {
	return ( near * far ) / ( ( far - near ) * depth - far );
}`,Tm=`#ifdef PREMULTIPLIED_ALPHA
	gl_FragColor.rgb *= gl_FragColor.a;
#endif`,bm=`vec4 mvPosition = vec4( transformed, 1.0 );
#ifdef USE_BATCHING
	mvPosition = batchingMatrix * mvPosition;
#endif
#ifdef USE_INSTANCING
	mvPosition = instanceMatrix * mvPosition;
#endif
mvPosition = modelViewMatrix * mvPosition;
gl_Position = projectionMatrix * mvPosition;`,Am=`#ifdef DITHERING
	gl_FragColor.rgb = dithering( gl_FragColor.rgb );
#endif`,wm=`#ifdef DITHERING
	vec3 dithering( vec3 color ) {
		float grid_position = rand( gl_FragCoord.xy );
		vec3 dither_shift_RGB = vec3( 0.25 / 255.0, -0.25 / 255.0, 0.25 / 255.0 );
		dither_shift_RGB = mix( 2.0 * dither_shift_RGB, -2.0 * dither_shift_RGB, grid_position );
		return color + dither_shift_RGB;
	}
#endif`,Rm=`float roughnessFactor = roughness;
#ifdef USE_ROUGHNESSMAP
	vec4 texelRoughness = texture2D( roughnessMap, vRoughnessMapUv );
	roughnessFactor *= texelRoughness.g;
#endif`,Cm=`#ifdef USE_ROUGHNESSMAP
	uniform sampler2D roughnessMap;
#endif`,Pm=`#if NUM_SPOT_LIGHT_COORDS > 0
	varying vec4 vSpotLightCoord[ NUM_SPOT_LIGHT_COORDS ];
#endif
#if NUM_SPOT_LIGHT_MAPS > 0
	uniform sampler2D spotLightMap[ NUM_SPOT_LIGHT_MAPS ];
#endif
#ifdef USE_SHADOWMAP
	#if NUM_DIR_LIGHT_SHADOWS > 0
		uniform sampler2D directionalShadowMap[ NUM_DIR_LIGHT_SHADOWS ];
		varying vec4 vDirectionalShadowCoord[ NUM_DIR_LIGHT_SHADOWS ];
		struct DirectionalLightShadow {
			float shadowIntensity;
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
		};
		uniform DirectionalLightShadow directionalLightShadows[ NUM_DIR_LIGHT_SHADOWS ];
	#endif
	#if NUM_SPOT_LIGHT_SHADOWS > 0
		uniform sampler2D spotShadowMap[ NUM_SPOT_LIGHT_SHADOWS ];
		struct SpotLightShadow {
			float shadowIntensity;
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
		};
		uniform SpotLightShadow spotLightShadows[ NUM_SPOT_LIGHT_SHADOWS ];
	#endif
	#if NUM_POINT_LIGHT_SHADOWS > 0
		uniform sampler2D pointShadowMap[ NUM_POINT_LIGHT_SHADOWS ];
		varying vec4 vPointShadowCoord[ NUM_POINT_LIGHT_SHADOWS ];
		struct PointLightShadow {
			float shadowIntensity;
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
			float shadowCameraNear;
			float shadowCameraFar;
		};
		uniform PointLightShadow pointLightShadows[ NUM_POINT_LIGHT_SHADOWS ];
	#endif
	float texture2DCompare( sampler2D depths, vec2 uv, float compare ) {
		return step( compare, unpackRGBAToDepth( texture2D( depths, uv ) ) );
	}
	vec2 texture2DDistribution( sampler2D shadow, vec2 uv ) {
		return unpackRGBATo2Half( texture2D( shadow, uv ) );
	}
	float VSMShadow (sampler2D shadow, vec2 uv, float compare ){
		float occlusion = 1.0;
		vec2 distribution = texture2DDistribution( shadow, uv );
		float hard_shadow = step( compare , distribution.x );
		if (hard_shadow != 1.0 ) {
			float distance = compare - distribution.x ;
			float variance = max( 0.00000, distribution.y * distribution.y );
			float softness_probability = variance / (variance + distance * distance );			softness_probability = clamp( ( softness_probability - 0.3 ) / ( 0.95 - 0.3 ), 0.0, 1.0 );			occlusion = clamp( max( hard_shadow, softness_probability ), 0.0, 1.0 );
		}
		return occlusion;
	}
	float getShadow( sampler2D shadowMap, vec2 shadowMapSize, float shadowIntensity, float shadowBias, float shadowRadius, vec4 shadowCoord ) {
		float shadow = 1.0;
		shadowCoord.xyz /= shadowCoord.w;
		shadowCoord.z += shadowBias;
		bool inFrustum = shadowCoord.x >= 0.0 && shadowCoord.x <= 1.0 && shadowCoord.y >= 0.0 && shadowCoord.y <= 1.0;
		bool frustumTest = inFrustum && shadowCoord.z <= 1.0;
		if ( frustumTest ) {
		#if defined( SHADOWMAP_TYPE_PCF )
			vec2 texelSize = vec2( 1.0 ) / shadowMapSize;
			float dx0 = - texelSize.x * shadowRadius;
			float dy0 = - texelSize.y * shadowRadius;
			float dx1 = + texelSize.x * shadowRadius;
			float dy1 = + texelSize.y * shadowRadius;
			float dx2 = dx0 / 2.0;
			float dy2 = dy0 / 2.0;
			float dx3 = dx1 / 2.0;
			float dy3 = dy1 / 2.0;
			shadow = (
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx0, dy0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( 0.0, dy0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx1, dy0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx2, dy2 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( 0.0, dy2 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx3, dy2 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx0, 0.0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx2, 0.0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy, shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx3, 0.0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx1, 0.0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx2, dy3 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( 0.0, dy3 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx3, dy3 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx0, dy1 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( 0.0, dy1 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, shadowCoord.xy + vec2( dx1, dy1 ), shadowCoord.z )
			) * ( 1.0 / 17.0 );
		#elif defined( SHADOWMAP_TYPE_PCF_SOFT )
			vec2 texelSize = vec2( 1.0 ) / shadowMapSize;
			float dx = texelSize.x;
			float dy = texelSize.y;
			vec2 uv = shadowCoord.xy;
			vec2 f = fract( uv * shadowMapSize + 0.5 );
			uv -= f * texelSize;
			shadow = (
				texture2DCompare( shadowMap, uv, shadowCoord.z ) +
				texture2DCompare( shadowMap, uv + vec2( dx, 0.0 ), shadowCoord.z ) +
				texture2DCompare( shadowMap, uv + vec2( 0.0, dy ), shadowCoord.z ) +
				texture2DCompare( shadowMap, uv + texelSize, shadowCoord.z ) +
				mix( texture2DCompare( shadowMap, uv + vec2( -dx, 0.0 ), shadowCoord.z ),
					 texture2DCompare( shadowMap, uv + vec2( 2.0 * dx, 0.0 ), shadowCoord.z ),
					 f.x ) +
				mix( texture2DCompare( shadowMap, uv + vec2( -dx, dy ), shadowCoord.z ),
					 texture2DCompare( shadowMap, uv + vec2( 2.0 * dx, dy ), shadowCoord.z ),
					 f.x ) +
				mix( texture2DCompare( shadowMap, uv + vec2( 0.0, -dy ), shadowCoord.z ),
					 texture2DCompare( shadowMap, uv + vec2( 0.0, 2.0 * dy ), shadowCoord.z ),
					 f.y ) +
				mix( texture2DCompare( shadowMap, uv + vec2( dx, -dy ), shadowCoord.z ),
					 texture2DCompare( shadowMap, uv + vec2( dx, 2.0 * dy ), shadowCoord.z ),
					 f.y ) +
				mix( mix( texture2DCompare( shadowMap, uv + vec2( -dx, -dy ), shadowCoord.z ),
						  texture2DCompare( shadowMap, uv + vec2( 2.0 * dx, -dy ), shadowCoord.z ),
						  f.x ),
					 mix( texture2DCompare( shadowMap, uv + vec2( -dx, 2.0 * dy ), shadowCoord.z ),
						  texture2DCompare( shadowMap, uv + vec2( 2.0 * dx, 2.0 * dy ), shadowCoord.z ),
						  f.x ),
					 f.y )
			) * ( 1.0 / 9.0 );
		#elif defined( SHADOWMAP_TYPE_VSM )
			shadow = VSMShadow( shadowMap, shadowCoord.xy, shadowCoord.z );
		#else
			shadow = texture2DCompare( shadowMap, shadowCoord.xy, shadowCoord.z );
		#endif
		}
		return mix( 1.0, shadow, shadowIntensity );
	}
	vec2 cubeToUV( vec3 v, float texelSizeY ) {
		vec3 absV = abs( v );
		float scaleToCube = 1.0 / max( absV.x, max( absV.y, absV.z ) );
		absV *= scaleToCube;
		v *= scaleToCube * ( 1.0 - 2.0 * texelSizeY );
		vec2 planar = v.xy;
		float almostATexel = 1.5 * texelSizeY;
		float almostOne = 1.0 - almostATexel;
		if ( absV.z >= almostOne ) {
			if ( v.z > 0.0 )
				planar.x = 4.0 - v.x;
		} else if ( absV.x >= almostOne ) {
			float signX = sign( v.x );
			planar.x = v.z * signX + 2.0 * signX;
		} else if ( absV.y >= almostOne ) {
			float signY = sign( v.y );
			planar.x = v.x + 2.0 * signY + 2.0;
			planar.y = v.z * signY - 2.0;
		}
		return vec2( 0.125, 0.25 ) * planar + vec2( 0.375, 0.75 );
	}
	float getPointShadow( sampler2D shadowMap, vec2 shadowMapSize, float shadowIntensity, float shadowBias, float shadowRadius, vec4 shadowCoord, float shadowCameraNear, float shadowCameraFar ) {
		float shadow = 1.0;
		vec3 lightToPosition = shadowCoord.xyz;
		
		float lightToPositionLength = length( lightToPosition );
		if ( lightToPositionLength - shadowCameraFar <= 0.0 && lightToPositionLength - shadowCameraNear >= 0.0 ) {
			float dp = ( lightToPositionLength - shadowCameraNear ) / ( shadowCameraFar - shadowCameraNear );			dp += shadowBias;
			vec3 bd3D = normalize( lightToPosition );
			vec2 texelSize = vec2( 1.0 ) / ( shadowMapSize * vec2( 4.0, 2.0 ) );
			#if defined( SHADOWMAP_TYPE_PCF ) || defined( SHADOWMAP_TYPE_PCF_SOFT ) || defined( SHADOWMAP_TYPE_VSM )
				vec2 offset = vec2( - 1, 1 ) * shadowRadius * texelSize.y;
				shadow = (
					texture2DCompare( shadowMap, cubeToUV( bd3D + offset.xyy, texelSize.y ), dp ) +
					texture2DCompare( shadowMap, cubeToUV( bd3D + offset.yyy, texelSize.y ), dp ) +
					texture2DCompare( shadowMap, cubeToUV( bd3D + offset.xyx, texelSize.y ), dp ) +
					texture2DCompare( shadowMap, cubeToUV( bd3D + offset.yyx, texelSize.y ), dp ) +
					texture2DCompare( shadowMap, cubeToUV( bd3D, texelSize.y ), dp ) +
					texture2DCompare( shadowMap, cubeToUV( bd3D + offset.xxy, texelSize.y ), dp ) +
					texture2DCompare( shadowMap, cubeToUV( bd3D + offset.yxy, texelSize.y ), dp ) +
					texture2DCompare( shadowMap, cubeToUV( bd3D + offset.xxx, texelSize.y ), dp ) +
					texture2DCompare( shadowMap, cubeToUV( bd3D + offset.yxx, texelSize.y ), dp )
				) * ( 1.0 / 9.0 );
			#else
				shadow = texture2DCompare( shadowMap, cubeToUV( bd3D, texelSize.y ), dp );
			#endif
		}
		return mix( 1.0, shadow, shadowIntensity );
	}
#endif`,Im=`#if NUM_SPOT_LIGHT_COORDS > 0
	uniform mat4 spotLightMatrix[ NUM_SPOT_LIGHT_COORDS ];
	varying vec4 vSpotLightCoord[ NUM_SPOT_LIGHT_COORDS ];
#endif
#ifdef USE_SHADOWMAP
	#if NUM_DIR_LIGHT_SHADOWS > 0
		uniform mat4 directionalShadowMatrix[ NUM_DIR_LIGHT_SHADOWS ];
		varying vec4 vDirectionalShadowCoord[ NUM_DIR_LIGHT_SHADOWS ];
		struct DirectionalLightShadow {
			float shadowIntensity;
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
		};
		uniform DirectionalLightShadow directionalLightShadows[ NUM_DIR_LIGHT_SHADOWS ];
	#endif
	#if NUM_SPOT_LIGHT_SHADOWS > 0
		struct SpotLightShadow {
			float shadowIntensity;
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
		};
		uniform SpotLightShadow spotLightShadows[ NUM_SPOT_LIGHT_SHADOWS ];
	#endif
	#if NUM_POINT_LIGHT_SHADOWS > 0
		uniform mat4 pointShadowMatrix[ NUM_POINT_LIGHT_SHADOWS ];
		varying vec4 vPointShadowCoord[ NUM_POINT_LIGHT_SHADOWS ];
		struct PointLightShadow {
			float shadowIntensity;
			float shadowBias;
			float shadowNormalBias;
			float shadowRadius;
			vec2 shadowMapSize;
			float shadowCameraNear;
			float shadowCameraFar;
		};
		uniform PointLightShadow pointLightShadows[ NUM_POINT_LIGHT_SHADOWS ];
	#endif
#endif`,Lm=`#if ( defined( USE_SHADOWMAP ) && ( NUM_DIR_LIGHT_SHADOWS > 0 || NUM_POINT_LIGHT_SHADOWS > 0 ) ) || ( NUM_SPOT_LIGHT_COORDS > 0 )
	vec3 shadowWorldNormal = inverseTransformDirection( transformedNormal, viewMatrix );
	vec4 shadowWorldPosition;
#endif
#if defined( USE_SHADOWMAP )
	#if NUM_DIR_LIGHT_SHADOWS > 0
		#pragma unroll_loop_start
		for ( int i = 0; i < NUM_DIR_LIGHT_SHADOWS; i ++ ) {
			shadowWorldPosition = worldPosition + vec4( shadowWorldNormal * directionalLightShadows[ i ].shadowNormalBias, 0 );
			vDirectionalShadowCoord[ i ] = directionalShadowMatrix[ i ] * shadowWorldPosition;
		}
		#pragma unroll_loop_end
	#endif
	#if NUM_POINT_LIGHT_SHADOWS > 0
		#pragma unroll_loop_start
		for ( int i = 0; i < NUM_POINT_LIGHT_SHADOWS; i ++ ) {
			shadowWorldPosition = worldPosition + vec4( shadowWorldNormal * pointLightShadows[ i ].shadowNormalBias, 0 );
			vPointShadowCoord[ i ] = pointShadowMatrix[ i ] * shadowWorldPosition;
		}
		#pragma unroll_loop_end
	#endif
#endif
#if NUM_SPOT_LIGHT_COORDS > 0
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_SPOT_LIGHT_COORDS; i ++ ) {
		shadowWorldPosition = worldPosition;
		#if ( defined( USE_SHADOWMAP ) && UNROLLED_LOOP_INDEX < NUM_SPOT_LIGHT_SHADOWS )
			shadowWorldPosition.xyz += shadowWorldNormal * spotLightShadows[ i ].shadowNormalBias;
		#endif
		vSpotLightCoord[ i ] = spotLightMatrix[ i ] * shadowWorldPosition;
	}
	#pragma unroll_loop_end
#endif`,Dm=`float getShadowMask() {
	float shadow = 1.0;
	#ifdef USE_SHADOWMAP
	#if NUM_DIR_LIGHT_SHADOWS > 0
	DirectionalLightShadow directionalLight;
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_DIR_LIGHT_SHADOWS; i ++ ) {
		directionalLight = directionalLightShadows[ i ];
		shadow *= receiveShadow ? getShadow( directionalShadowMap[ i ], directionalLight.shadowMapSize, directionalLight.shadowIntensity, directionalLight.shadowBias, directionalLight.shadowRadius, vDirectionalShadowCoord[ i ] ) : 1.0;
	}
	#pragma unroll_loop_end
	#endif
	#if NUM_SPOT_LIGHT_SHADOWS > 0
	SpotLightShadow spotLight;
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_SPOT_LIGHT_SHADOWS; i ++ ) {
		spotLight = spotLightShadows[ i ];
		shadow *= receiveShadow ? getShadow( spotShadowMap[ i ], spotLight.shadowMapSize, spotLight.shadowIntensity, spotLight.shadowBias, spotLight.shadowRadius, vSpotLightCoord[ i ] ) : 1.0;
	}
	#pragma unroll_loop_end
	#endif
	#if NUM_POINT_LIGHT_SHADOWS > 0
	PointLightShadow pointLight;
	#pragma unroll_loop_start
	for ( int i = 0; i < NUM_POINT_LIGHT_SHADOWS; i ++ ) {
		pointLight = pointLightShadows[ i ];
		shadow *= receiveShadow ? getPointShadow( pointShadowMap[ i ], pointLight.shadowMapSize, pointLight.shadowIntensity, pointLight.shadowBias, pointLight.shadowRadius, vPointShadowCoord[ i ], pointLight.shadowCameraNear, pointLight.shadowCameraFar ) : 1.0;
	}
	#pragma unroll_loop_end
	#endif
	#endif
	return shadow;
}`,Um=`#ifdef USE_SKINNING
	mat4 boneMatX = getBoneMatrix( skinIndex.x );
	mat4 boneMatY = getBoneMatrix( skinIndex.y );
	mat4 boneMatZ = getBoneMatrix( skinIndex.z );
	mat4 boneMatW = getBoneMatrix( skinIndex.w );
#endif`,Nm=`#ifdef USE_SKINNING
	uniform mat4 bindMatrix;
	uniform mat4 bindMatrixInverse;
	uniform highp sampler2D boneTexture;
	mat4 getBoneMatrix( const in float i ) {
		int size = textureSize( boneTexture, 0 ).x;
		int j = int( i ) * 4;
		int x = j % size;
		int y = j / size;
		vec4 v1 = texelFetch( boneTexture, ivec2( x, y ), 0 );
		vec4 v2 = texelFetch( boneTexture, ivec2( x + 1, y ), 0 );
		vec4 v3 = texelFetch( boneTexture, ivec2( x + 2, y ), 0 );
		vec4 v4 = texelFetch( boneTexture, ivec2( x + 3, y ), 0 );
		return mat4( v1, v2, v3, v4 );
	}
#endif`,Fm=`#ifdef USE_SKINNING
	vec4 skinVertex = bindMatrix * vec4( transformed, 1.0 );
	vec4 skinned = vec4( 0.0 );
	skinned += boneMatX * skinVertex * skinWeight.x;
	skinned += boneMatY * skinVertex * skinWeight.y;
	skinned += boneMatZ * skinVertex * skinWeight.z;
	skinned += boneMatW * skinVertex * skinWeight.w;
	transformed = ( bindMatrixInverse * skinned ).xyz;
#endif`,Bm=`#ifdef USE_SKINNING
	mat4 skinMatrix = mat4( 0.0 );
	skinMatrix += skinWeight.x * boneMatX;
	skinMatrix += skinWeight.y * boneMatY;
	skinMatrix += skinWeight.z * boneMatZ;
	skinMatrix += skinWeight.w * boneMatW;
	skinMatrix = bindMatrixInverse * skinMatrix * bindMatrix;
	objectNormal = vec4( skinMatrix * vec4( objectNormal, 0.0 ) ).xyz;
	#ifdef USE_TANGENT
		objectTangent = vec4( skinMatrix * vec4( objectTangent, 0.0 ) ).xyz;
	#endif
#endif`,Om=`float specularStrength;
#ifdef USE_SPECULARMAP
	vec4 texelSpecular = texture2D( specularMap, vSpecularMapUv );
	specularStrength = texelSpecular.r;
#else
	specularStrength = 1.0;
#endif`,zm=`#ifdef USE_SPECULARMAP
	uniform sampler2D specularMap;
#endif`,Vm=`#if defined( TONE_MAPPING )
	gl_FragColor.rgb = toneMapping( gl_FragColor.rgb );
#endif`,Hm=`#ifndef saturate
#define saturate( a ) clamp( a, 0.0, 1.0 )
#endif
uniform float toneMappingExposure;
vec3 LinearToneMapping( vec3 color ) {
	return saturate( toneMappingExposure * color );
}
vec3 ReinhardToneMapping( vec3 color ) {
	color *= toneMappingExposure;
	return saturate( color / ( vec3( 1.0 ) + color ) );
}
vec3 CineonToneMapping( vec3 color ) {
	color *= toneMappingExposure;
	color = max( vec3( 0.0 ), color - 0.004 );
	return pow( ( color * ( 6.2 * color + 0.5 ) ) / ( color * ( 6.2 * color + 1.7 ) + 0.06 ), vec3( 2.2 ) );
}
vec3 RRTAndODTFit( vec3 v ) {
	vec3 a = v * ( v + 0.0245786 ) - 0.000090537;
	vec3 b = v * ( 0.983729 * v + 0.4329510 ) + 0.238081;
	return a / b;
}
vec3 ACESFilmicToneMapping( vec3 color ) {
	const mat3 ACESInputMat = mat3(
		vec3( 0.59719, 0.07600, 0.02840 ),		vec3( 0.35458, 0.90834, 0.13383 ),
		vec3( 0.04823, 0.01566, 0.83777 )
	);
	const mat3 ACESOutputMat = mat3(
		vec3(  1.60475, -0.10208, -0.00327 ),		vec3( -0.53108,  1.10813, -0.07276 ),
		vec3( -0.07367, -0.00605,  1.07602 )
	);
	color *= toneMappingExposure / 0.6;
	color = ACESInputMat * color;
	color = RRTAndODTFit( color );
	color = ACESOutputMat * color;
	return saturate( color );
}
const mat3 LINEAR_REC2020_TO_LINEAR_SRGB = mat3(
	vec3( 1.6605, - 0.1246, - 0.0182 ),
	vec3( - 0.5876, 1.1329, - 0.1006 ),
	vec3( - 0.0728, - 0.0083, 1.1187 )
);
const mat3 LINEAR_SRGB_TO_LINEAR_REC2020 = mat3(
	vec3( 0.6274, 0.0691, 0.0164 ),
	vec3( 0.3293, 0.9195, 0.0880 ),
	vec3( 0.0433, 0.0113, 0.8956 )
);
vec3 agxDefaultContrastApprox( vec3 x ) {
	vec3 x2 = x * x;
	vec3 x4 = x2 * x2;
	return + 15.5 * x4 * x2
		- 40.14 * x4 * x
		+ 31.96 * x4
		- 6.868 * x2 * x
		+ 0.4298 * x2
		+ 0.1191 * x
		- 0.00232;
}
vec3 AgXToneMapping( vec3 color ) {
	const mat3 AgXInsetMatrix = mat3(
		vec3( 0.856627153315983, 0.137318972929847, 0.11189821299995 ),
		vec3( 0.0951212405381588, 0.761241990602591, 0.0767994186031903 ),
		vec3( 0.0482516061458583, 0.101439036467562, 0.811302368396859 )
	);
	const mat3 AgXOutsetMatrix = mat3(
		vec3( 1.1271005818144368, - 0.1413297634984383, - 0.14132976349843826 ),
		vec3( - 0.11060664309660323, 1.157823702216272, - 0.11060664309660294 ),
		vec3( - 0.016493938717834573, - 0.016493938717834257, 1.2519364065950405 )
	);
	const float AgxMinEv = - 12.47393;	const float AgxMaxEv = 4.026069;
	color *= toneMappingExposure;
	color = LINEAR_SRGB_TO_LINEAR_REC2020 * color;
	color = AgXInsetMatrix * color;
	color = max( color, 1e-10 );	color = log2( color );
	color = ( color - AgxMinEv ) / ( AgxMaxEv - AgxMinEv );
	color = clamp( color, 0.0, 1.0 );
	color = agxDefaultContrastApprox( color );
	color = AgXOutsetMatrix * color;
	color = pow( max( vec3( 0.0 ), color ), vec3( 2.2 ) );
	color = LINEAR_REC2020_TO_LINEAR_SRGB * color;
	color = clamp( color, 0.0, 1.0 );
	return color;
}
vec3 NeutralToneMapping( vec3 color ) {
	const float StartCompression = 0.8 - 0.04;
	const float Desaturation = 0.15;
	color *= toneMappingExposure;
	float x = min( color.r, min( color.g, color.b ) );
	float offset = x < 0.08 ? x - 6.25 * x * x : 0.04;
	color -= offset;
	float peak = max( color.r, max( color.g, color.b ) );
	if ( peak < StartCompression ) return color;
	float d = 1. - StartCompression;
	float newPeak = 1. - d * d / ( peak + d - StartCompression );
	color *= newPeak / peak;
	float g = 1. - 1. / ( Desaturation * ( peak - newPeak ) + 1. );
	return mix( color, vec3( newPeak ), g );
}
vec3 CustomToneMapping( vec3 color ) { return color; }`,Gm=`#ifdef USE_TRANSMISSION
	material.transmission = transmission;
	material.transmissionAlpha = 1.0;
	material.thickness = thickness;
	material.attenuationDistance = attenuationDistance;
	material.attenuationColor = attenuationColor;
	#ifdef USE_TRANSMISSIONMAP
		material.transmission *= texture2D( transmissionMap, vTransmissionMapUv ).r;
	#endif
	#ifdef USE_THICKNESSMAP
		material.thickness *= texture2D( thicknessMap, vThicknessMapUv ).g;
	#endif
	vec3 pos = vWorldPosition;
	vec3 v = normalize( cameraPosition - pos );
	vec3 n = inverseTransformDirection( normal, viewMatrix );
	vec4 transmitted = getIBLVolumeRefraction(
		n, v, material.roughness, material.diffuseColor, material.specularColor, material.specularF90,
		pos, modelMatrix, viewMatrix, projectionMatrix, material.dispersion, material.ior, material.thickness,
		material.attenuationColor, material.attenuationDistance );
	material.transmissionAlpha = mix( material.transmissionAlpha, transmitted.a, material.transmission );
	totalDiffuse = mix( totalDiffuse, transmitted.rgb, material.transmission );
#endif`,km=`#ifdef USE_TRANSMISSION
	uniform float transmission;
	uniform float thickness;
	uniform float attenuationDistance;
	uniform vec3 attenuationColor;
	#ifdef USE_TRANSMISSIONMAP
		uniform sampler2D transmissionMap;
	#endif
	#ifdef USE_THICKNESSMAP
		uniform sampler2D thicknessMap;
	#endif
	uniform vec2 transmissionSamplerSize;
	uniform sampler2D transmissionSamplerMap;
	uniform mat4 modelMatrix;
	uniform mat4 projectionMatrix;
	varying vec3 vWorldPosition;
	float w0( float a ) {
		return ( 1.0 / 6.0 ) * ( a * ( a * ( - a + 3.0 ) - 3.0 ) + 1.0 );
	}
	float w1( float a ) {
		return ( 1.0 / 6.0 ) * ( a *  a * ( 3.0 * a - 6.0 ) + 4.0 );
	}
	float w2( float a ){
		return ( 1.0 / 6.0 ) * ( a * ( a * ( - 3.0 * a + 3.0 ) + 3.0 ) + 1.0 );
	}
	float w3( float a ) {
		return ( 1.0 / 6.0 ) * ( a * a * a );
	}
	float g0( float a ) {
		return w0( a ) + w1( a );
	}
	float g1( float a ) {
		return w2( a ) + w3( a );
	}
	float h0( float a ) {
		return - 1.0 + w1( a ) / ( w0( a ) + w1( a ) );
	}
	float h1( float a ) {
		return 1.0 + w3( a ) / ( w2( a ) + w3( a ) );
	}
	vec4 bicubic( sampler2D tex, vec2 uv, vec4 texelSize, float lod ) {
		uv = uv * texelSize.zw + 0.5;
		vec2 iuv = floor( uv );
		vec2 fuv = fract( uv );
		float g0x = g0( fuv.x );
		float g1x = g1( fuv.x );
		float h0x = h0( fuv.x );
		float h1x = h1( fuv.x );
		float h0y = h0( fuv.y );
		float h1y = h1( fuv.y );
		vec2 p0 = ( vec2( iuv.x + h0x, iuv.y + h0y ) - 0.5 ) * texelSize.xy;
		vec2 p1 = ( vec2( iuv.x + h1x, iuv.y + h0y ) - 0.5 ) * texelSize.xy;
		vec2 p2 = ( vec2( iuv.x + h0x, iuv.y + h1y ) - 0.5 ) * texelSize.xy;
		vec2 p3 = ( vec2( iuv.x + h1x, iuv.y + h1y ) - 0.5 ) * texelSize.xy;
		return g0( fuv.y ) * ( g0x * textureLod( tex, p0, lod ) + g1x * textureLod( tex, p1, lod ) ) +
			g1( fuv.y ) * ( g0x * textureLod( tex, p2, lod ) + g1x * textureLod( tex, p3, lod ) );
	}
	vec4 textureBicubic( sampler2D sampler, vec2 uv, float lod ) {
		vec2 fLodSize = vec2( textureSize( sampler, int( lod ) ) );
		vec2 cLodSize = vec2( textureSize( sampler, int( lod + 1.0 ) ) );
		vec2 fLodSizeInv = 1.0 / fLodSize;
		vec2 cLodSizeInv = 1.0 / cLodSize;
		vec4 fSample = bicubic( sampler, uv, vec4( fLodSizeInv, fLodSize ), floor( lod ) );
		vec4 cSample = bicubic( sampler, uv, vec4( cLodSizeInv, cLodSize ), ceil( lod ) );
		return mix( fSample, cSample, fract( lod ) );
	}
	vec3 getVolumeTransmissionRay( const in vec3 n, const in vec3 v, const in float thickness, const in float ior, const in mat4 modelMatrix ) {
		vec3 refractionVector = refract( - v, normalize( n ), 1.0 / ior );
		vec3 modelScale;
		modelScale.x = length( vec3( modelMatrix[ 0 ].xyz ) );
		modelScale.y = length( vec3( modelMatrix[ 1 ].xyz ) );
		modelScale.z = length( vec3( modelMatrix[ 2 ].xyz ) );
		return normalize( refractionVector ) * thickness * modelScale;
	}
	float applyIorToRoughness( const in float roughness, const in float ior ) {
		return roughness * clamp( ior * 2.0 - 2.0, 0.0, 1.0 );
	}
	vec4 getTransmissionSample( const in vec2 fragCoord, const in float roughness, const in float ior ) {
		float lod = log2( transmissionSamplerSize.x ) * applyIorToRoughness( roughness, ior );
		return textureBicubic( transmissionSamplerMap, fragCoord.xy, lod );
	}
	vec3 volumeAttenuation( const in float transmissionDistance, const in vec3 attenuationColor, const in float attenuationDistance ) {
		if ( isinf( attenuationDistance ) ) {
			return vec3( 1.0 );
		} else {
			vec3 attenuationCoefficient = -log( attenuationColor ) / attenuationDistance;
			vec3 transmittance = exp( - attenuationCoefficient * transmissionDistance );			return transmittance;
		}
	}
	vec4 getIBLVolumeRefraction( const in vec3 n, const in vec3 v, const in float roughness, const in vec3 diffuseColor,
		const in vec3 specularColor, const in float specularF90, const in vec3 position, const in mat4 modelMatrix,
		const in mat4 viewMatrix, const in mat4 projMatrix, const in float dispersion, const in float ior, const in float thickness,
		const in vec3 attenuationColor, const in float attenuationDistance ) {
		vec4 transmittedLight;
		vec3 transmittance;
		#ifdef USE_DISPERSION
			float halfSpread = ( ior - 1.0 ) * 0.025 * dispersion;
			vec3 iors = vec3( ior - halfSpread, ior, ior + halfSpread );
			for ( int i = 0; i < 3; i ++ ) {
				vec3 transmissionRay = getVolumeTransmissionRay( n, v, thickness, iors[ i ], modelMatrix );
				vec3 refractedRayExit = position + transmissionRay;
				vec4 ndcPos = projMatrix * viewMatrix * vec4( refractedRayExit, 1.0 );
				vec2 refractionCoords = ndcPos.xy / ndcPos.w;
				refractionCoords += 1.0;
				refractionCoords /= 2.0;
				vec4 transmissionSample = getTransmissionSample( refractionCoords, roughness, iors[ i ] );
				transmittedLight[ i ] = transmissionSample[ i ];
				transmittedLight.a += transmissionSample.a;
				transmittance[ i ] = diffuseColor[ i ] * volumeAttenuation( length( transmissionRay ), attenuationColor, attenuationDistance )[ i ];
			}
			transmittedLight.a /= 3.0;
		#else
			vec3 transmissionRay = getVolumeTransmissionRay( n, v, thickness, ior, modelMatrix );
			vec3 refractedRayExit = position + transmissionRay;
			vec4 ndcPos = projMatrix * viewMatrix * vec4( refractedRayExit, 1.0 );
			vec2 refractionCoords = ndcPos.xy / ndcPos.w;
			refractionCoords += 1.0;
			refractionCoords /= 2.0;
			transmittedLight = getTransmissionSample( refractionCoords, roughness, ior );
			transmittance = diffuseColor * volumeAttenuation( length( transmissionRay ), attenuationColor, attenuationDistance );
		#endif
		vec3 attenuatedColor = transmittance * transmittedLight.rgb;
		vec3 F = EnvironmentBRDF( n, v, specularColor, specularF90, roughness );
		float transmittanceFactor = ( transmittance.r + transmittance.g + transmittance.b ) / 3.0;
		return vec4( ( 1.0 - F ) * attenuatedColor, 1.0 - ( 1.0 - transmittedLight.a ) * transmittanceFactor );
	}
#endif`,Wm=`#if defined( USE_UV ) || defined( USE_ANISOTROPY )
	varying vec2 vUv;
#endif
#ifdef USE_MAP
	varying vec2 vMapUv;
#endif
#ifdef USE_ALPHAMAP
	varying vec2 vAlphaMapUv;
#endif
#ifdef USE_LIGHTMAP
	varying vec2 vLightMapUv;
#endif
#ifdef USE_AOMAP
	varying vec2 vAoMapUv;
#endif
#ifdef USE_BUMPMAP
	varying vec2 vBumpMapUv;
#endif
#ifdef USE_NORMALMAP
	varying vec2 vNormalMapUv;
#endif
#ifdef USE_EMISSIVEMAP
	varying vec2 vEmissiveMapUv;
#endif
#ifdef USE_METALNESSMAP
	varying vec2 vMetalnessMapUv;
#endif
#ifdef USE_ROUGHNESSMAP
	varying vec2 vRoughnessMapUv;
#endif
#ifdef USE_ANISOTROPYMAP
	varying vec2 vAnisotropyMapUv;
#endif
#ifdef USE_CLEARCOATMAP
	varying vec2 vClearcoatMapUv;
#endif
#ifdef USE_CLEARCOAT_NORMALMAP
	varying vec2 vClearcoatNormalMapUv;
#endif
#ifdef USE_CLEARCOAT_ROUGHNESSMAP
	varying vec2 vClearcoatRoughnessMapUv;
#endif
#ifdef USE_IRIDESCENCEMAP
	varying vec2 vIridescenceMapUv;
#endif
#ifdef USE_IRIDESCENCE_THICKNESSMAP
	varying vec2 vIridescenceThicknessMapUv;
#endif
#ifdef USE_SHEEN_COLORMAP
	varying vec2 vSheenColorMapUv;
#endif
#ifdef USE_SHEEN_ROUGHNESSMAP
	varying vec2 vSheenRoughnessMapUv;
#endif
#ifdef USE_SPECULARMAP
	varying vec2 vSpecularMapUv;
#endif
#ifdef USE_SPECULAR_COLORMAP
	varying vec2 vSpecularColorMapUv;
#endif
#ifdef USE_SPECULAR_INTENSITYMAP
	varying vec2 vSpecularIntensityMapUv;
#endif
#ifdef USE_TRANSMISSIONMAP
	uniform mat3 transmissionMapTransform;
	varying vec2 vTransmissionMapUv;
#endif
#ifdef USE_THICKNESSMAP
	uniform mat3 thicknessMapTransform;
	varying vec2 vThicknessMapUv;
#endif`,Xm=`#if defined( USE_UV ) || defined( USE_ANISOTROPY )
	varying vec2 vUv;
#endif
#ifdef USE_MAP
	uniform mat3 mapTransform;
	varying vec2 vMapUv;
#endif
#ifdef USE_ALPHAMAP
	uniform mat3 alphaMapTransform;
	varying vec2 vAlphaMapUv;
#endif
#ifdef USE_LIGHTMAP
	uniform mat3 lightMapTransform;
	varying vec2 vLightMapUv;
#endif
#ifdef USE_AOMAP
	uniform mat3 aoMapTransform;
	varying vec2 vAoMapUv;
#endif
#ifdef USE_BUMPMAP
	uniform mat3 bumpMapTransform;
	varying vec2 vBumpMapUv;
#endif
#ifdef USE_NORMALMAP
	uniform mat3 normalMapTransform;
	varying vec2 vNormalMapUv;
#endif
#ifdef USE_DISPLACEMENTMAP
	uniform mat3 displacementMapTransform;
	varying vec2 vDisplacementMapUv;
#endif
#ifdef USE_EMISSIVEMAP
	uniform mat3 emissiveMapTransform;
	varying vec2 vEmissiveMapUv;
#endif
#ifdef USE_METALNESSMAP
	uniform mat3 metalnessMapTransform;
	varying vec2 vMetalnessMapUv;
#endif
#ifdef USE_ROUGHNESSMAP
	uniform mat3 roughnessMapTransform;
	varying vec2 vRoughnessMapUv;
#endif
#ifdef USE_ANISOTROPYMAP
	uniform mat3 anisotropyMapTransform;
	varying vec2 vAnisotropyMapUv;
#endif
#ifdef USE_CLEARCOATMAP
	uniform mat3 clearcoatMapTransform;
	varying vec2 vClearcoatMapUv;
#endif
#ifdef USE_CLEARCOAT_NORMALMAP
	uniform mat3 clearcoatNormalMapTransform;
	varying vec2 vClearcoatNormalMapUv;
#endif
#ifdef USE_CLEARCOAT_ROUGHNESSMAP
	uniform mat3 clearcoatRoughnessMapTransform;
	varying vec2 vClearcoatRoughnessMapUv;
#endif
#ifdef USE_SHEEN_COLORMAP
	uniform mat3 sheenColorMapTransform;
	varying vec2 vSheenColorMapUv;
#endif
#ifdef USE_SHEEN_ROUGHNESSMAP
	uniform mat3 sheenRoughnessMapTransform;
	varying vec2 vSheenRoughnessMapUv;
#endif
#ifdef USE_IRIDESCENCEMAP
	uniform mat3 iridescenceMapTransform;
	varying vec2 vIridescenceMapUv;
#endif
#ifdef USE_IRIDESCENCE_THICKNESSMAP
	uniform mat3 iridescenceThicknessMapTransform;
	varying vec2 vIridescenceThicknessMapUv;
#endif
#ifdef USE_SPECULARMAP
	uniform mat3 specularMapTransform;
	varying vec2 vSpecularMapUv;
#endif
#ifdef USE_SPECULAR_COLORMAP
	uniform mat3 specularColorMapTransform;
	varying vec2 vSpecularColorMapUv;
#endif
#ifdef USE_SPECULAR_INTENSITYMAP
	uniform mat3 specularIntensityMapTransform;
	varying vec2 vSpecularIntensityMapUv;
#endif
#ifdef USE_TRANSMISSIONMAP
	uniform mat3 transmissionMapTransform;
	varying vec2 vTransmissionMapUv;
#endif
#ifdef USE_THICKNESSMAP
	uniform mat3 thicknessMapTransform;
	varying vec2 vThicknessMapUv;
#endif`,qm=`#if defined( USE_UV ) || defined( USE_ANISOTROPY )
	vUv = vec3( uv, 1 ).xy;
#endif
#ifdef USE_MAP
	vMapUv = ( mapTransform * vec3( MAP_UV, 1 ) ).xy;
#endif
#ifdef USE_ALPHAMAP
	vAlphaMapUv = ( alphaMapTransform * vec3( ALPHAMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_LIGHTMAP
	vLightMapUv = ( lightMapTransform * vec3( LIGHTMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_AOMAP
	vAoMapUv = ( aoMapTransform * vec3( AOMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_BUMPMAP
	vBumpMapUv = ( bumpMapTransform * vec3( BUMPMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_NORMALMAP
	vNormalMapUv = ( normalMapTransform * vec3( NORMALMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_DISPLACEMENTMAP
	vDisplacementMapUv = ( displacementMapTransform * vec3( DISPLACEMENTMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_EMISSIVEMAP
	vEmissiveMapUv = ( emissiveMapTransform * vec3( EMISSIVEMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_METALNESSMAP
	vMetalnessMapUv = ( metalnessMapTransform * vec3( METALNESSMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_ROUGHNESSMAP
	vRoughnessMapUv = ( roughnessMapTransform * vec3( ROUGHNESSMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_ANISOTROPYMAP
	vAnisotropyMapUv = ( anisotropyMapTransform * vec3( ANISOTROPYMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_CLEARCOATMAP
	vClearcoatMapUv = ( clearcoatMapTransform * vec3( CLEARCOATMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_CLEARCOAT_NORMALMAP
	vClearcoatNormalMapUv = ( clearcoatNormalMapTransform * vec3( CLEARCOAT_NORMALMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_CLEARCOAT_ROUGHNESSMAP
	vClearcoatRoughnessMapUv = ( clearcoatRoughnessMapTransform * vec3( CLEARCOAT_ROUGHNESSMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_IRIDESCENCEMAP
	vIridescenceMapUv = ( iridescenceMapTransform * vec3( IRIDESCENCEMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_IRIDESCENCE_THICKNESSMAP
	vIridescenceThicknessMapUv = ( iridescenceThicknessMapTransform * vec3( IRIDESCENCE_THICKNESSMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_SHEEN_COLORMAP
	vSheenColorMapUv = ( sheenColorMapTransform * vec3( SHEEN_COLORMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_SHEEN_ROUGHNESSMAP
	vSheenRoughnessMapUv = ( sheenRoughnessMapTransform * vec3( SHEEN_ROUGHNESSMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_SPECULARMAP
	vSpecularMapUv = ( specularMapTransform * vec3( SPECULARMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_SPECULAR_COLORMAP
	vSpecularColorMapUv = ( specularColorMapTransform * vec3( SPECULAR_COLORMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_SPECULAR_INTENSITYMAP
	vSpecularIntensityMapUv = ( specularIntensityMapTransform * vec3( SPECULAR_INTENSITYMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_TRANSMISSIONMAP
	vTransmissionMapUv = ( transmissionMapTransform * vec3( TRANSMISSIONMAP_UV, 1 ) ).xy;
#endif
#ifdef USE_THICKNESSMAP
	vThicknessMapUv = ( thicknessMapTransform * vec3( THICKNESSMAP_UV, 1 ) ).xy;
#endif`,Ym=`#if defined( USE_ENVMAP ) || defined( DISTANCE ) || defined ( USE_SHADOWMAP ) || defined ( USE_TRANSMISSION ) || NUM_SPOT_LIGHT_COORDS > 0
	vec4 worldPosition = vec4( transformed, 1.0 );
	#ifdef USE_BATCHING
		worldPosition = batchingMatrix * worldPosition;
	#endif
	#ifdef USE_INSTANCING
		worldPosition = instanceMatrix * worldPosition;
	#endif
	worldPosition = modelMatrix * worldPosition;
#endif`;const $m=`varying vec2 vUv;
uniform mat3 uvTransform;
void main() {
	vUv = ( uvTransform * vec3( uv, 1 ) ).xy;
	gl_Position = vec4( position.xy, 1.0, 1.0 );
}`,jm=`uniform sampler2D t2D;
uniform float backgroundIntensity;
varying vec2 vUv;
void main() {
	vec4 texColor = texture2D( t2D, vUv );
	#ifdef DECODE_VIDEO_TEXTURE
		texColor = vec4( mix( pow( texColor.rgb * 0.9478672986 + vec3( 0.0521327014 ), vec3( 2.4 ) ), texColor.rgb * 0.0773993808, vec3( lessThanEqual( texColor.rgb, vec3( 0.04045 ) ) ) ), texColor.w );
	#endif
	texColor.rgb *= backgroundIntensity;
	gl_FragColor = texColor;
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
}`,Km=`varying vec3 vWorldDirection;
#include <common>
void main() {
	vWorldDirection = transformDirection( position, modelMatrix );
	#include <begin_vertex>
	#include <project_vertex>
	gl_Position.z = gl_Position.w;
}`,Zm=`#ifdef ENVMAP_TYPE_CUBE
	uniform samplerCube envMap;
#elif defined( ENVMAP_TYPE_CUBE_UV )
	uniform sampler2D envMap;
#endif
uniform float flipEnvMap;
uniform float backgroundBlurriness;
uniform float backgroundIntensity;
uniform mat3 backgroundRotation;
varying vec3 vWorldDirection;
#include <cube_uv_reflection_fragment>
void main() {
	#ifdef ENVMAP_TYPE_CUBE
		vec4 texColor = textureCube( envMap, backgroundRotation * vec3( flipEnvMap * vWorldDirection.x, vWorldDirection.yz ) );
	#elif defined( ENVMAP_TYPE_CUBE_UV )
		vec4 texColor = textureCubeUV( envMap, backgroundRotation * vWorldDirection, backgroundBlurriness );
	#else
		vec4 texColor = vec4( 0.0, 0.0, 0.0, 1.0 );
	#endif
	texColor.rgb *= backgroundIntensity;
	gl_FragColor = texColor;
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
}`,Jm=`varying vec3 vWorldDirection;
#include <common>
void main() {
	vWorldDirection = transformDirection( position, modelMatrix );
	#include <begin_vertex>
	#include <project_vertex>
	gl_Position.z = gl_Position.w;
}`,Qm=`uniform samplerCube tCube;
uniform float tFlip;
uniform float opacity;
varying vec3 vWorldDirection;
void main() {
	vec4 texColor = textureCube( tCube, vec3( tFlip * vWorldDirection.x, vWorldDirection.yz ) );
	gl_FragColor = texColor;
	gl_FragColor.a *= opacity;
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
}`,t_=`#include <common>
#include <batching_pars_vertex>
#include <uv_pars_vertex>
#include <displacementmap_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
varying vec2 vHighPrecisionZW;
void main() {
	#include <uv_vertex>
	#include <batching_vertex>
	#include <skinbase_vertex>
	#include <morphinstance_vertex>
	#ifdef USE_DISPLACEMENTMAP
		#include <beginnormal_vertex>
		#include <morphnormal_vertex>
		#include <skinnormal_vertex>
	#endif
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	vHighPrecisionZW = gl_Position.zw;
}`,e_=`#if DEPTH_PACKING == 3200
	uniform float opacity;
#endif
#include <common>
#include <packing>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <alphahash_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
varying vec2 vHighPrecisionZW;
void main() {
	vec4 diffuseColor = vec4( 1.0 );
	#include <clipping_planes_fragment>
	#if DEPTH_PACKING == 3200
		diffuseColor.a = opacity;
	#endif
	#include <map_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <alphahash_fragment>
	#include <logdepthbuf_fragment>
	float fragCoordZ = 0.5 * vHighPrecisionZW[0] / vHighPrecisionZW[1] + 0.5;
	#if DEPTH_PACKING == 3200
		gl_FragColor = vec4( vec3( 1.0 - fragCoordZ ), opacity );
	#elif DEPTH_PACKING == 3201
		gl_FragColor = packDepthToRGBA( fragCoordZ );
	#elif DEPTH_PACKING == 3202
		gl_FragColor = vec4( packDepthToRGB( fragCoordZ ), 1.0 );
	#elif DEPTH_PACKING == 3203
		gl_FragColor = vec4( packDepthToRG( fragCoordZ ), 0.0, 1.0 );
	#endif
}`,n_=`#define DISTANCE
varying vec3 vWorldPosition;
#include <common>
#include <batching_pars_vertex>
#include <uv_pars_vertex>
#include <displacementmap_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <batching_vertex>
	#include <skinbase_vertex>
	#include <morphinstance_vertex>
	#ifdef USE_DISPLACEMENTMAP
		#include <beginnormal_vertex>
		#include <morphnormal_vertex>
		#include <skinnormal_vertex>
	#endif
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <worldpos_vertex>
	#include <clipping_planes_vertex>
	vWorldPosition = worldPosition.xyz;
}`,i_=`#define DISTANCE
uniform vec3 referencePosition;
uniform float nearDistance;
uniform float farDistance;
varying vec3 vWorldPosition;
#include <common>
#include <packing>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <alphahash_pars_fragment>
#include <clipping_planes_pars_fragment>
void main () {
	vec4 diffuseColor = vec4( 1.0 );
	#include <clipping_planes_fragment>
	#include <map_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <alphahash_fragment>
	float dist = length( vWorldPosition - referencePosition );
	dist = ( dist - nearDistance ) / ( farDistance - nearDistance );
	dist = saturate( dist );
	gl_FragColor = packDepthToRGBA( dist );
}`,r_=`varying vec3 vWorldDirection;
#include <common>
void main() {
	vWorldDirection = transformDirection( position, modelMatrix );
	#include <begin_vertex>
	#include <project_vertex>
}`,s_=`uniform sampler2D tEquirect;
varying vec3 vWorldDirection;
#include <common>
void main() {
	vec3 direction = normalize( vWorldDirection );
	vec2 sampleUV = equirectUv( direction );
	gl_FragColor = texture2D( tEquirect, sampleUV );
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
}`,o_=`uniform float scale;
attribute float lineDistance;
varying float vLineDistance;
#include <common>
#include <uv_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <morphtarget_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	vLineDistance = scale * lineDistance;
	#include <uv_vertex>
	#include <color_vertex>
	#include <morphinstance_vertex>
	#include <morphcolor_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	#include <fog_vertex>
}`,a_=`uniform vec3 diffuse;
uniform float opacity;
uniform float dashSize;
uniform float totalSize;
varying float vLineDistance;
#include <common>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <fog_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <clipping_planes_fragment>
	if ( mod( vLineDistance, totalSize ) > dashSize ) {
		discard;
	}
	vec3 outgoingLight = vec3( 0.0 );
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	outgoingLight = diffuseColor.rgb;
	#include <opaque_fragment>
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
}`,c_=`#include <common>
#include <batching_pars_vertex>
#include <uv_pars_vertex>
#include <envmap_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <color_vertex>
	#include <morphinstance_vertex>
	#include <morphcolor_vertex>
	#include <batching_vertex>
	#if defined ( USE_ENVMAP ) || defined ( USE_SKINNING )
		#include <beginnormal_vertex>
		#include <morphnormal_vertex>
		#include <skinbase_vertex>
		#include <skinnormal_vertex>
		#include <defaultnormal_vertex>
	#endif
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	#include <worldpos_vertex>
	#include <envmap_vertex>
	#include <fog_vertex>
}`,l_=`uniform vec3 diffuse;
uniform float opacity;
#ifndef FLAT_SHADED
	varying vec3 vNormal;
#endif
#include <common>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <alphahash_pars_fragment>
#include <aomap_pars_fragment>
#include <lightmap_pars_fragment>
#include <envmap_common_pars_fragment>
#include <envmap_pars_fragment>
#include <fog_pars_fragment>
#include <specularmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <clipping_planes_fragment>
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <alphahash_fragment>
	#include <specularmap_fragment>
	ReflectedLight reflectedLight = ReflectedLight( vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ) );
	#ifdef USE_LIGHTMAP
		vec4 lightMapTexel = texture2D( lightMap, vLightMapUv );
		reflectedLight.indirectDiffuse += lightMapTexel.rgb * lightMapIntensity * RECIPROCAL_PI;
	#else
		reflectedLight.indirectDiffuse += vec3( 1.0 );
	#endif
	#include <aomap_fragment>
	reflectedLight.indirectDiffuse *= diffuseColor.rgb;
	vec3 outgoingLight = reflectedLight.indirectDiffuse;
	#include <envmap_fragment>
	#include <opaque_fragment>
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,u_=`#define LAMBERT
varying vec3 vViewPosition;
#include <common>
#include <batching_pars_vertex>
#include <uv_pars_vertex>
#include <displacementmap_pars_vertex>
#include <envmap_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <shadowmap_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <color_vertex>
	#include <morphinstance_vertex>
	#include <morphcolor_vertex>
	#include <batching_vertex>
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	vViewPosition = - mvPosition.xyz;
	#include <worldpos_vertex>
	#include <envmap_vertex>
	#include <shadowmap_vertex>
	#include <fog_vertex>
}`,h_=`#define LAMBERT
uniform vec3 diffuse;
uniform vec3 emissive;
uniform float opacity;
#include <common>
#include <packing>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <alphahash_pars_fragment>
#include <aomap_pars_fragment>
#include <lightmap_pars_fragment>
#include <emissivemap_pars_fragment>
#include <envmap_common_pars_fragment>
#include <envmap_pars_fragment>
#include <fog_pars_fragment>
#include <bsdfs>
#include <lights_pars_begin>
#include <normal_pars_fragment>
#include <lights_lambert_pars_fragment>
#include <shadowmap_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <specularmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <clipping_planes_fragment>
	ReflectedLight reflectedLight = ReflectedLight( vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ) );
	vec3 totalEmissiveRadiance = emissive;
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <alphahash_fragment>
	#include <specularmap_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	#include <emissivemap_fragment>
	#include <lights_lambert_fragment>
	#include <lights_fragment_begin>
	#include <lights_fragment_maps>
	#include <lights_fragment_end>
	#include <aomap_fragment>
	vec3 outgoingLight = reflectedLight.directDiffuse + reflectedLight.indirectDiffuse + totalEmissiveRadiance;
	#include <envmap_fragment>
	#include <opaque_fragment>
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,f_=`#define MATCAP
varying vec3 vViewPosition;
#include <common>
#include <batching_pars_vertex>
#include <uv_pars_vertex>
#include <color_pars_vertex>
#include <displacementmap_pars_vertex>
#include <fog_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <color_vertex>
	#include <morphinstance_vertex>
	#include <morphcolor_vertex>
	#include <batching_vertex>
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	#include <fog_vertex>
	vViewPosition = - mvPosition.xyz;
}`,d_=`#define MATCAP
uniform vec3 diffuse;
uniform float opacity;
uniform sampler2D matcap;
varying vec3 vViewPosition;
#include <common>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <alphahash_pars_fragment>
#include <fog_pars_fragment>
#include <normal_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <clipping_planes_fragment>
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <alphahash_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	vec3 viewDir = normalize( vViewPosition );
	vec3 x = normalize( vec3( viewDir.z, 0.0, - viewDir.x ) );
	vec3 y = cross( viewDir, x );
	vec2 uv = vec2( dot( x, normal ), dot( y, normal ) ) * 0.495 + 0.5;
	#ifdef USE_MATCAP
		vec4 matcapColor = texture2D( matcap, uv );
	#else
		vec4 matcapColor = vec4( vec3( mix( 0.2, 0.8, uv.y ) ), 1.0 );
	#endif
	vec3 outgoingLight = diffuseColor.rgb * matcapColor.rgb;
	#include <opaque_fragment>
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,p_=`#define NORMAL
#if defined( FLAT_SHADED ) || defined( USE_BUMPMAP ) || defined( USE_NORMALMAP_TANGENTSPACE )
	varying vec3 vViewPosition;
#endif
#include <common>
#include <batching_pars_vertex>
#include <uv_pars_vertex>
#include <displacementmap_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <batching_vertex>
	#include <beginnormal_vertex>
	#include <morphinstance_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
#if defined( FLAT_SHADED ) || defined( USE_BUMPMAP ) || defined( USE_NORMALMAP_TANGENTSPACE )
	vViewPosition = - mvPosition.xyz;
#endif
}`,g_=`#define NORMAL
uniform float opacity;
#if defined( FLAT_SHADED ) || defined( USE_BUMPMAP ) || defined( USE_NORMALMAP_TANGENTSPACE )
	varying vec3 vViewPosition;
#endif
#include <packing>
#include <uv_pars_fragment>
#include <normal_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	vec4 diffuseColor = vec4( 0.0, 0.0, 0.0, opacity );
	#include <clipping_planes_fragment>
	#include <logdepthbuf_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	gl_FragColor = vec4( packNormalToRGB( normal ), diffuseColor.a );
	#ifdef OPAQUE
		gl_FragColor.a = 1.0;
	#endif
}`,m_=`#define PHONG
varying vec3 vViewPosition;
#include <common>
#include <batching_pars_vertex>
#include <uv_pars_vertex>
#include <displacementmap_pars_vertex>
#include <envmap_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <shadowmap_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <color_vertex>
	#include <morphcolor_vertex>
	#include <batching_vertex>
	#include <beginnormal_vertex>
	#include <morphinstance_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	vViewPosition = - mvPosition.xyz;
	#include <worldpos_vertex>
	#include <envmap_vertex>
	#include <shadowmap_vertex>
	#include <fog_vertex>
}`,__=`#define PHONG
uniform vec3 diffuse;
uniform vec3 emissive;
uniform vec3 specular;
uniform float shininess;
uniform float opacity;
#include <common>
#include <packing>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <alphahash_pars_fragment>
#include <aomap_pars_fragment>
#include <lightmap_pars_fragment>
#include <emissivemap_pars_fragment>
#include <envmap_common_pars_fragment>
#include <envmap_pars_fragment>
#include <fog_pars_fragment>
#include <bsdfs>
#include <lights_pars_begin>
#include <normal_pars_fragment>
#include <lights_phong_pars_fragment>
#include <shadowmap_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <specularmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <clipping_planes_fragment>
	ReflectedLight reflectedLight = ReflectedLight( vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ) );
	vec3 totalEmissiveRadiance = emissive;
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <alphahash_fragment>
	#include <specularmap_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	#include <emissivemap_fragment>
	#include <lights_phong_fragment>
	#include <lights_fragment_begin>
	#include <lights_fragment_maps>
	#include <lights_fragment_end>
	#include <aomap_fragment>
	vec3 outgoingLight = reflectedLight.directDiffuse + reflectedLight.indirectDiffuse + reflectedLight.directSpecular + reflectedLight.indirectSpecular + totalEmissiveRadiance;
	#include <envmap_fragment>
	#include <opaque_fragment>
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,x_=`#define STANDARD
varying vec3 vViewPosition;
#ifdef USE_TRANSMISSION
	varying vec3 vWorldPosition;
#endif
#include <common>
#include <batching_pars_vertex>
#include <uv_pars_vertex>
#include <displacementmap_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <shadowmap_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <color_vertex>
	#include <morphinstance_vertex>
	#include <morphcolor_vertex>
	#include <batching_vertex>
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	vViewPosition = - mvPosition.xyz;
	#include <worldpos_vertex>
	#include <shadowmap_vertex>
	#include <fog_vertex>
#ifdef USE_TRANSMISSION
	vWorldPosition = worldPosition.xyz;
#endif
}`,v_=`#define STANDARD
#ifdef PHYSICAL
	#define IOR
	#define USE_SPECULAR
#endif
uniform vec3 diffuse;
uniform vec3 emissive;
uniform float roughness;
uniform float metalness;
uniform float opacity;
#ifdef IOR
	uniform float ior;
#endif
#ifdef USE_SPECULAR
	uniform float specularIntensity;
	uniform vec3 specularColor;
	#ifdef USE_SPECULAR_COLORMAP
		uniform sampler2D specularColorMap;
	#endif
	#ifdef USE_SPECULAR_INTENSITYMAP
		uniform sampler2D specularIntensityMap;
	#endif
#endif
#ifdef USE_CLEARCOAT
	uniform float clearcoat;
	uniform float clearcoatRoughness;
#endif
#ifdef USE_DISPERSION
	uniform float dispersion;
#endif
#ifdef USE_IRIDESCENCE
	uniform float iridescence;
	uniform float iridescenceIOR;
	uniform float iridescenceThicknessMinimum;
	uniform float iridescenceThicknessMaximum;
#endif
#ifdef USE_SHEEN
	uniform vec3 sheenColor;
	uniform float sheenRoughness;
	#ifdef USE_SHEEN_COLORMAP
		uniform sampler2D sheenColorMap;
	#endif
	#ifdef USE_SHEEN_ROUGHNESSMAP
		uniform sampler2D sheenRoughnessMap;
	#endif
#endif
#ifdef USE_ANISOTROPY
	uniform vec2 anisotropyVector;
	#ifdef USE_ANISOTROPYMAP
		uniform sampler2D anisotropyMap;
	#endif
#endif
varying vec3 vViewPosition;
#include <common>
#include <packing>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <alphahash_pars_fragment>
#include <aomap_pars_fragment>
#include <lightmap_pars_fragment>
#include <emissivemap_pars_fragment>
#include <iridescence_fragment>
#include <cube_uv_reflection_fragment>
#include <envmap_common_pars_fragment>
#include <envmap_physical_pars_fragment>
#include <fog_pars_fragment>
#include <lights_pars_begin>
#include <normal_pars_fragment>
#include <lights_physical_pars_fragment>
#include <transmission_pars_fragment>
#include <shadowmap_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <clearcoat_pars_fragment>
#include <iridescence_pars_fragment>
#include <roughnessmap_pars_fragment>
#include <metalnessmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <clipping_planes_fragment>
	ReflectedLight reflectedLight = ReflectedLight( vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ) );
	vec3 totalEmissiveRadiance = emissive;
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <alphahash_fragment>
	#include <roughnessmap_fragment>
	#include <metalnessmap_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	#include <clearcoat_normal_fragment_begin>
	#include <clearcoat_normal_fragment_maps>
	#include <emissivemap_fragment>
	#include <lights_physical_fragment>
	#include <lights_fragment_begin>
	#include <lights_fragment_maps>
	#include <lights_fragment_end>
	#include <aomap_fragment>
	vec3 totalDiffuse = reflectedLight.directDiffuse + reflectedLight.indirectDiffuse;
	vec3 totalSpecular = reflectedLight.directSpecular + reflectedLight.indirectSpecular;
	#include <transmission_fragment>
	vec3 outgoingLight = totalDiffuse + totalSpecular + totalEmissiveRadiance;
	#ifdef USE_SHEEN
		float sheenEnergyComp = 1.0 - 0.157 * max3( material.sheenColor );
		outgoingLight = outgoingLight * sheenEnergyComp + sheenSpecularDirect + sheenSpecularIndirect;
	#endif
	#ifdef USE_CLEARCOAT
		float dotNVcc = saturate( dot( geometryClearcoatNormal, geometryViewDir ) );
		vec3 Fcc = F_Schlick( material.clearcoatF0, material.clearcoatF90, dotNVcc );
		outgoingLight = outgoingLight * ( 1.0 - material.clearcoat * Fcc ) + ( clearcoatSpecularDirect + clearcoatSpecularIndirect ) * material.clearcoat;
	#endif
	#include <opaque_fragment>
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,y_=`#define TOON
varying vec3 vViewPosition;
#include <common>
#include <batching_pars_vertex>
#include <uv_pars_vertex>
#include <displacementmap_pars_vertex>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <normal_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <shadowmap_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	#include <color_vertex>
	#include <morphinstance_vertex>
	#include <morphcolor_vertex>
	#include <batching_vertex>
	#include <beginnormal_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <normal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <displacementmap_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	vViewPosition = - mvPosition.xyz;
	#include <worldpos_vertex>
	#include <shadowmap_vertex>
	#include <fog_vertex>
}`,S_=`#define TOON
uniform vec3 diffuse;
uniform vec3 emissive;
uniform float opacity;
#include <common>
#include <packing>
#include <dithering_pars_fragment>
#include <color_pars_fragment>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <alphahash_pars_fragment>
#include <aomap_pars_fragment>
#include <lightmap_pars_fragment>
#include <emissivemap_pars_fragment>
#include <gradientmap_pars_fragment>
#include <fog_pars_fragment>
#include <bsdfs>
#include <lights_pars_begin>
#include <normal_pars_fragment>
#include <lights_toon_pars_fragment>
#include <shadowmap_pars_fragment>
#include <bumpmap_pars_fragment>
#include <normalmap_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <clipping_planes_fragment>
	ReflectedLight reflectedLight = ReflectedLight( vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ), vec3( 0.0 ) );
	vec3 totalEmissiveRadiance = emissive;
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <color_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <alphahash_fragment>
	#include <normal_fragment_begin>
	#include <normal_fragment_maps>
	#include <emissivemap_fragment>
	#include <lights_toon_fragment>
	#include <lights_fragment_begin>
	#include <lights_fragment_maps>
	#include <lights_fragment_end>
	#include <aomap_fragment>
	vec3 outgoingLight = reflectedLight.directDiffuse + reflectedLight.indirectDiffuse + totalEmissiveRadiance;
	#include <opaque_fragment>
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
	#include <dithering_fragment>
}`,M_=`uniform float size;
uniform float scale;
#include <common>
#include <color_pars_vertex>
#include <fog_pars_vertex>
#include <morphtarget_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
#ifdef USE_POINTS_UV
	varying vec2 vUv;
	uniform mat3 uvTransform;
#endif
void main() {
	#ifdef USE_POINTS_UV
		vUv = ( uvTransform * vec3( uv, 1 ) ).xy;
	#endif
	#include <color_vertex>
	#include <morphinstance_vertex>
	#include <morphcolor_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <project_vertex>
	gl_PointSize = size;
	#ifdef USE_SIZEATTENUATION
		bool isPerspective = isPerspectiveMatrix( projectionMatrix );
		if ( isPerspective ) gl_PointSize *= ( scale / - mvPosition.z );
	#endif
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	#include <worldpos_vertex>
	#include <fog_vertex>
}`,E_=`uniform vec3 diffuse;
uniform float opacity;
#include <common>
#include <color_pars_fragment>
#include <map_particle_pars_fragment>
#include <alphatest_pars_fragment>
#include <alphahash_pars_fragment>
#include <fog_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <clipping_planes_fragment>
	vec3 outgoingLight = vec3( 0.0 );
	#include <logdepthbuf_fragment>
	#include <map_particle_fragment>
	#include <color_fragment>
	#include <alphatest_fragment>
	#include <alphahash_fragment>
	outgoingLight = diffuseColor.rgb;
	#include <opaque_fragment>
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
	#include <fog_fragment>
	#include <premultiplied_alpha_fragment>
}`,T_=`#include <common>
#include <batching_pars_vertex>
#include <fog_pars_vertex>
#include <morphtarget_pars_vertex>
#include <skinning_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <shadowmap_pars_vertex>
void main() {
	#include <batching_vertex>
	#include <beginnormal_vertex>
	#include <morphinstance_vertex>
	#include <morphnormal_vertex>
	#include <skinbase_vertex>
	#include <skinnormal_vertex>
	#include <defaultnormal_vertex>
	#include <begin_vertex>
	#include <morphtarget_vertex>
	#include <skinning_vertex>
	#include <project_vertex>
	#include <logdepthbuf_vertex>
	#include <worldpos_vertex>
	#include <shadowmap_vertex>
	#include <fog_vertex>
}`,b_=`uniform vec3 color;
uniform float opacity;
#include <common>
#include <packing>
#include <fog_pars_fragment>
#include <bsdfs>
#include <lights_pars_begin>
#include <logdepthbuf_pars_fragment>
#include <shadowmap_pars_fragment>
#include <shadowmask_pars_fragment>
void main() {
	#include <logdepthbuf_fragment>
	gl_FragColor = vec4( color, opacity * ( 1.0 - getShadowMask() ) );
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
	#include <fog_fragment>
}`,A_=`uniform float rotation;
uniform vec2 center;
#include <common>
#include <uv_pars_vertex>
#include <fog_pars_vertex>
#include <logdepthbuf_pars_vertex>
#include <clipping_planes_pars_vertex>
void main() {
	#include <uv_vertex>
	vec4 mvPosition = modelViewMatrix[ 3 ];
	vec2 scale = vec2( length( modelMatrix[ 0 ].xyz ), length( modelMatrix[ 1 ].xyz ) );
	#ifndef USE_SIZEATTENUATION
		bool isPerspective = isPerspectiveMatrix( projectionMatrix );
		if ( isPerspective ) scale *= - mvPosition.z;
	#endif
	vec2 alignedPosition = ( position.xy - ( center - vec2( 0.5 ) ) ) * scale;
	vec2 rotatedPosition;
	rotatedPosition.x = cos( rotation ) * alignedPosition.x - sin( rotation ) * alignedPosition.y;
	rotatedPosition.y = sin( rotation ) * alignedPosition.x + cos( rotation ) * alignedPosition.y;
	mvPosition.xy += rotatedPosition;
	gl_Position = projectionMatrix * mvPosition;
	#include <logdepthbuf_vertex>
	#include <clipping_planes_vertex>
	#include <fog_vertex>
}`,w_=`uniform vec3 diffuse;
uniform float opacity;
#include <common>
#include <uv_pars_fragment>
#include <map_pars_fragment>
#include <alphamap_pars_fragment>
#include <alphatest_pars_fragment>
#include <alphahash_pars_fragment>
#include <fog_pars_fragment>
#include <logdepthbuf_pars_fragment>
#include <clipping_planes_pars_fragment>
void main() {
	vec4 diffuseColor = vec4( diffuse, opacity );
	#include <clipping_planes_fragment>
	vec3 outgoingLight = vec3( 0.0 );
	#include <logdepthbuf_fragment>
	#include <map_fragment>
	#include <alphamap_fragment>
	#include <alphatest_fragment>
	#include <alphahash_fragment>
	outgoingLight = diffuseColor.rgb;
	#include <opaque_fragment>
	#include <tonemapping_fragment>
	#include <colorspace_fragment>
	#include <fog_fragment>
}`,Wt={alphahash_fragment:jp,alphahash_pars_fragment:Kp,alphamap_fragment:Zp,alphamap_pars_fragment:Jp,alphatest_fragment:Qp,alphatest_pars_fragment:tg,aomap_fragment:eg,aomap_pars_fragment:ng,batching_pars_vertex:ig,batching_vertex:rg,begin_vertex:sg,beginnormal_vertex:og,bsdfs:ag,iridescence_fragment:cg,bumpmap_pars_fragment:lg,clipping_planes_fragment:ug,clipping_planes_pars_fragment:hg,clipping_planes_pars_vertex:fg,clipping_planes_vertex:dg,color_fragment:pg,color_pars_fragment:gg,color_pars_vertex:mg,color_vertex:_g,common:xg,cube_uv_reflection_fragment:vg,defaultnormal_vertex:yg,displacementmap_pars_vertex:Sg,displacementmap_vertex:Mg,emissivemap_fragment:Eg,emissivemap_pars_fragment:Tg,colorspace_fragment:bg,colorspace_pars_fragment:Ag,envmap_fragment:wg,envmap_common_pars_fragment:Rg,envmap_pars_fragment:Cg,envmap_pars_vertex:Pg,envmap_physical_pars_fragment:Hg,envmap_vertex:Ig,fog_vertex:Lg,fog_pars_vertex:Dg,fog_fragment:Ug,fog_pars_fragment:Ng,gradientmap_pars_fragment:Fg,lightmap_pars_fragment:Bg,lights_lambert_fragment:Og,lights_lambert_pars_fragment:zg,lights_pars_begin:Vg,lights_toon_fragment:Gg,lights_toon_pars_fragment:kg,lights_phong_fragment:Wg,lights_phong_pars_fragment:Xg,lights_physical_fragment:qg,lights_physical_pars_fragment:Yg,lights_fragment_begin:$g,lights_fragment_maps:jg,lights_fragment_end:Kg,logdepthbuf_fragment:Zg,logdepthbuf_pars_fragment:Jg,logdepthbuf_pars_vertex:Qg,logdepthbuf_vertex:tm,map_fragment:em,map_pars_fragment:nm,map_particle_fragment:im,map_particle_pars_fragment:rm,metalnessmap_fragment:sm,metalnessmap_pars_fragment:om,morphinstance_vertex:am,morphcolor_vertex:cm,morphnormal_vertex:lm,morphtarget_pars_vertex:um,morphtarget_vertex:hm,normal_fragment_begin:fm,normal_fragment_maps:dm,normal_pars_fragment:pm,normal_pars_vertex:gm,normal_vertex:mm,normalmap_pars_fragment:_m,clearcoat_normal_fragment_begin:xm,clearcoat_normal_fragment_maps:vm,clearcoat_pars_fragment:ym,iridescence_pars_fragment:Sm,opaque_fragment:Mm,packing:Em,premultiplied_alpha_fragment:Tm,project_vertex:bm,dithering_fragment:Am,dithering_pars_fragment:wm,roughnessmap_fragment:Rm,roughnessmap_pars_fragment:Cm,shadowmap_pars_fragment:Pm,shadowmap_pars_vertex:Im,shadowmap_vertex:Lm,shadowmask_pars_fragment:Dm,skinbase_vertex:Um,skinning_pars_vertex:Nm,skinning_vertex:Fm,skinnormal_vertex:Bm,specularmap_fragment:Om,specularmap_pars_fragment:zm,tonemapping_fragment:Vm,tonemapping_pars_fragment:Hm,transmission_fragment:Gm,transmission_pars_fragment:km,uv_pars_fragment:Wm,uv_pars_vertex:Xm,uv_vertex:qm,worldpos_vertex:Ym,background_vert:$m,background_frag:jm,backgroundCube_vert:Km,backgroundCube_frag:Zm,cube_vert:Jm,cube_frag:Qm,depth_vert:t_,depth_frag:e_,distanceRGBA_vert:n_,distanceRGBA_frag:i_,equirect_vert:r_,equirect_frag:s_,linedashed_vert:o_,linedashed_frag:a_,meshbasic_vert:c_,meshbasic_frag:l_,meshlambert_vert:u_,meshlambert_frag:h_,meshmatcap_vert:f_,meshmatcap_frag:d_,meshnormal_vert:p_,meshnormal_frag:g_,meshphong_vert:m_,meshphong_frag:__,meshphysical_vert:x_,meshphysical_frag:v_,meshtoon_vert:y_,meshtoon_frag:S_,points_vert:M_,points_frag:E_,shadow_vert:T_,shadow_frag:b_,sprite_vert:A_,sprite_frag:w_},dt={common:{diffuse:{value:new qt(16777215)},opacity:{value:1},map:{value:null},mapTransform:{value:new Gt},alphaMap:{value:null},alphaMapTransform:{value:new Gt},alphaTest:{value:0}},specularmap:{specularMap:{value:null},specularMapTransform:{value:new Gt}},envmap:{envMap:{value:null},envMapRotation:{value:new Gt},flipEnvMap:{value:-1},reflectivity:{value:1},ior:{value:1.5},refractionRatio:{value:.98}},aomap:{aoMap:{value:null},aoMapIntensity:{value:1},aoMapTransform:{value:new Gt}},lightmap:{lightMap:{value:null},lightMapIntensity:{value:1},lightMapTransform:{value:new Gt}},bumpmap:{bumpMap:{value:null},bumpMapTransform:{value:new Gt},bumpScale:{value:1}},normalmap:{normalMap:{value:null},normalMapTransform:{value:new Gt},normalScale:{value:new kt(1,1)}},displacementmap:{displacementMap:{value:null},displacementMapTransform:{value:new Gt},displacementScale:{value:1},displacementBias:{value:0}},emissivemap:{emissiveMap:{value:null},emissiveMapTransform:{value:new Gt}},metalnessmap:{metalnessMap:{value:null},metalnessMapTransform:{value:new Gt}},roughnessmap:{roughnessMap:{value:null},roughnessMapTransform:{value:new Gt}},gradientmap:{gradientMap:{value:null}},fog:{fogDensity:{value:25e-5},fogNear:{value:1},fogFar:{value:2e3},fogColor:{value:new qt(16777215)}},lights:{ambientLightColor:{value:[]},lightProbe:{value:[]},directionalLights:{value:[],properties:{direction:{},color:{}}},directionalLightShadows:{value:[],properties:{shadowIntensity:1,shadowBias:{},shadowNormalBias:{},shadowRadius:{},shadowMapSize:{}}},directionalShadowMap:{value:[]},directionalShadowMatrix:{value:[]},spotLights:{value:[],properties:{color:{},position:{},direction:{},distance:{},coneCos:{},penumbraCos:{},decay:{}}},spotLightShadows:{value:[],properties:{shadowIntensity:1,shadowBias:{},shadowNormalBias:{},shadowRadius:{},shadowMapSize:{}}},spotLightMap:{value:[]},spotShadowMap:{value:[]},spotLightMatrix:{value:[]},pointLights:{value:[],properties:{color:{},position:{},decay:{},distance:{}}},pointLightShadows:{value:[],properties:{shadowIntensity:1,shadowBias:{},shadowNormalBias:{},shadowRadius:{},shadowMapSize:{},shadowCameraNear:{},shadowCameraFar:{}}},pointShadowMap:{value:[]},pointShadowMatrix:{value:[]},hemisphereLights:{value:[],properties:{direction:{},skyColor:{},groundColor:{}}},rectAreaLights:{value:[],properties:{color:{},position:{},width:{},height:{}}},ltc_1:{value:null},ltc_2:{value:null}},points:{diffuse:{value:new qt(16777215)},opacity:{value:1},size:{value:1},scale:{value:1},map:{value:null},alphaMap:{value:null},alphaMapTransform:{value:new Gt},alphaTest:{value:0},uvTransform:{value:new Gt}},sprite:{diffuse:{value:new qt(16777215)},opacity:{value:1},center:{value:new kt(.5,.5)},rotation:{value:0},map:{value:null},mapTransform:{value:new Gt},alphaMap:{value:null},alphaMapTransform:{value:new Gt},alphaTest:{value:0}}},Tn={basic:{uniforms:Fe([dt.common,dt.specularmap,dt.envmap,dt.aomap,dt.lightmap,dt.fog]),vertexShader:Wt.meshbasic_vert,fragmentShader:Wt.meshbasic_frag},lambert:{uniforms:Fe([dt.common,dt.specularmap,dt.envmap,dt.aomap,dt.lightmap,dt.emissivemap,dt.bumpmap,dt.normalmap,dt.displacementmap,dt.fog,dt.lights,{emissive:{value:new qt(0)}}]),vertexShader:Wt.meshlambert_vert,fragmentShader:Wt.meshlambert_frag},phong:{uniforms:Fe([dt.common,dt.specularmap,dt.envmap,dt.aomap,dt.lightmap,dt.emissivemap,dt.bumpmap,dt.normalmap,dt.displacementmap,dt.fog,dt.lights,{emissive:{value:new qt(0)},specular:{value:new qt(1118481)},shininess:{value:30}}]),vertexShader:Wt.meshphong_vert,fragmentShader:Wt.meshphong_frag},standard:{uniforms:Fe([dt.common,dt.envmap,dt.aomap,dt.lightmap,dt.emissivemap,dt.bumpmap,dt.normalmap,dt.displacementmap,dt.roughnessmap,dt.metalnessmap,dt.fog,dt.lights,{emissive:{value:new qt(0)},roughness:{value:1},metalness:{value:0},envMapIntensity:{value:1}}]),vertexShader:Wt.meshphysical_vert,fragmentShader:Wt.meshphysical_frag},toon:{uniforms:Fe([dt.common,dt.aomap,dt.lightmap,dt.emissivemap,dt.bumpmap,dt.normalmap,dt.displacementmap,dt.gradientmap,dt.fog,dt.lights,{emissive:{value:new qt(0)}}]),vertexShader:Wt.meshtoon_vert,fragmentShader:Wt.meshtoon_frag},matcap:{uniforms:Fe([dt.common,dt.bumpmap,dt.normalmap,dt.displacementmap,dt.fog,{matcap:{value:null}}]),vertexShader:Wt.meshmatcap_vert,fragmentShader:Wt.meshmatcap_frag},points:{uniforms:Fe([dt.points,dt.fog]),vertexShader:Wt.points_vert,fragmentShader:Wt.points_frag},dashed:{uniforms:Fe([dt.common,dt.fog,{scale:{value:1},dashSize:{value:1},totalSize:{value:2}}]),vertexShader:Wt.linedashed_vert,fragmentShader:Wt.linedashed_frag},depth:{uniforms:Fe([dt.common,dt.displacementmap]),vertexShader:Wt.depth_vert,fragmentShader:Wt.depth_frag},normal:{uniforms:Fe([dt.common,dt.bumpmap,dt.normalmap,dt.displacementmap,{opacity:{value:1}}]),vertexShader:Wt.meshnormal_vert,fragmentShader:Wt.meshnormal_frag},sprite:{uniforms:Fe([dt.sprite,dt.fog]),vertexShader:Wt.sprite_vert,fragmentShader:Wt.sprite_frag},background:{uniforms:{uvTransform:{value:new Gt},t2D:{value:null},backgroundIntensity:{value:1}},vertexShader:Wt.background_vert,fragmentShader:Wt.background_frag},backgroundCube:{uniforms:{envMap:{value:null},flipEnvMap:{value:-1},backgroundBlurriness:{value:0},backgroundIntensity:{value:1},backgroundRotation:{value:new Gt}},vertexShader:Wt.backgroundCube_vert,fragmentShader:Wt.backgroundCube_frag},cube:{uniforms:{tCube:{value:null},tFlip:{value:-1},opacity:{value:1}},vertexShader:Wt.cube_vert,fragmentShader:Wt.cube_frag},equirect:{uniforms:{tEquirect:{value:null}},vertexShader:Wt.equirect_vert,fragmentShader:Wt.equirect_frag},distanceRGBA:{uniforms:Fe([dt.common,dt.displacementmap,{referencePosition:{value:new U},nearDistance:{value:1},farDistance:{value:1e3}}]),vertexShader:Wt.distanceRGBA_vert,fragmentShader:Wt.distanceRGBA_frag},shadow:{uniforms:Fe([dt.lights,dt.fog,{color:{value:new qt(0)},opacity:{value:1}}]),vertexShader:Wt.shadow_vert,fragmentShader:Wt.shadow_frag}};Tn.physical={uniforms:Fe([Tn.standard.uniforms,{clearcoat:{value:0},clearcoatMap:{value:null},clearcoatMapTransform:{value:new Gt},clearcoatNormalMap:{value:null},clearcoatNormalMapTransform:{value:new Gt},clearcoatNormalScale:{value:new kt(1,1)},clearcoatRoughness:{value:0},clearcoatRoughnessMap:{value:null},clearcoatRoughnessMapTransform:{value:new Gt},dispersion:{value:0},iridescence:{value:0},iridescenceMap:{value:null},iridescenceMapTransform:{value:new Gt},iridescenceIOR:{value:1.3},iridescenceThicknessMinimum:{value:100},iridescenceThicknessMaximum:{value:400},iridescenceThicknessMap:{value:null},iridescenceThicknessMapTransform:{value:new Gt},sheen:{value:0},sheenColor:{value:new qt(0)},sheenColorMap:{value:null},sheenColorMapTransform:{value:new Gt},sheenRoughness:{value:1},sheenRoughnessMap:{value:null},sheenRoughnessMapTransform:{value:new Gt},transmission:{value:0},transmissionMap:{value:null},transmissionMapTransform:{value:new Gt},transmissionSamplerSize:{value:new kt},transmissionSamplerMap:{value:null},thickness:{value:0},thicknessMap:{value:null},thicknessMapTransform:{value:new Gt},attenuationDistance:{value:0},attenuationColor:{value:new qt(0)},specularColor:{value:new qt(1,1,1)},specularColorMap:{value:null},specularColorMapTransform:{value:new Gt},specularIntensity:{value:1},specularIntensityMap:{value:null},specularIntensityMapTransform:{value:new Gt},anisotropyVector:{value:new kt},anisotropyMap:{value:null},anisotropyMapTransform:{value:new Gt}}]),vertexShader:Wt.meshphysical_vert,fragmentShader:Wt.meshphysical_frag};const $s={r:0,b:0,g:0},Ti=new Dn,R_=new $t;function C_(i,t,e,n,r,s,a){const o=new qt(0);let c=s===!0?0:1,h,f,g=null,p=0,_=null;function M(u){let v=u.isScene===!0?u.background:null;return v&&v.isTexture&&(v=(u.backgroundBlurriness>0?e:t).get(v)),v}function b(u){let v=!1;const l=M(u);l===null?m(o,c):l&&l.isColor&&(m(l,1),v=!0);const R=i.xr.getEnvironmentBlendMode();R==="additive"?n.buffers.color.setClear(0,0,0,1,a):R==="alpha-blend"&&n.buffers.color.setClear(0,0,0,0,a),(i.autoClear||v)&&(n.buffers.depth.setTest(!0),n.buffers.depth.setMask(!0),n.buffers.color.setMask(!0),i.clear(i.autoClearColor,i.autoClearDepth,i.autoClearStencil))}function x(u,v){const l=M(v);l&&(l.isCubeTexture||l.mapping===Xo)?(f===void 0&&(f=new Ie(new ys(1,1,1),new pi({name:"BackgroundCubeMaterial",uniforms:Cr(Tn.backgroundCube.uniforms),vertexShader:Tn.backgroundCube.vertexShader,fragmentShader:Tn.backgroundCube.fragmentShader,side:ze,depthTest:!1,depthWrite:!1,fog:!1,allowOverride:!1})),f.geometry.deleteAttribute("normal"),f.geometry.deleteAttribute("uv"),f.onBeforeRender=function(R,T,E){this.matrixWorld.copyPosition(E.matrixWorld)},Object.defineProperty(f.material,"envMap",{get:function(){return this.uniforms.envMap.value}}),r.update(f)),Ti.copy(v.backgroundRotation),Ti.x*=-1,Ti.y*=-1,Ti.z*=-1,l.isCubeTexture&&l.isRenderTargetTexture===!1&&(Ti.y*=-1,Ti.z*=-1),f.material.uniforms.envMap.value=l,f.material.uniforms.flipEnvMap.value=l.isCubeTexture&&l.isRenderTargetTexture===!1?-1:1,f.material.uniforms.backgroundBlurriness.value=v.backgroundBlurriness,f.material.uniforms.backgroundIntensity.value=v.backgroundIntensity,f.material.uniforms.backgroundRotation.value.setFromMatrix4(R_.makeRotationFromEuler(Ti)),f.material.toneMapped=Jt.getTransfer(l.colorSpace)!==re,(g!==l||p!==l.version||_!==i.toneMapping)&&(f.material.needsUpdate=!0,g=l,p=l.version,_=i.toneMapping),f.layers.enableAll(),u.unshift(f,f.geometry,f.material,0,0,null)):l&&l.isTexture&&(h===void 0&&(h=new Ie(new Ms(2,2),new pi({name:"BackgroundMaterial",uniforms:Cr(Tn.background.uniforms),vertexShader:Tn.background.vertexShader,fragmentShader:Tn.background.fragmentShader,side:In,depthTest:!1,depthWrite:!1,fog:!1,allowOverride:!1})),h.geometry.deleteAttribute("normal"),Object.defineProperty(h.material,"map",{get:function(){return this.uniforms.t2D.value}}),r.update(h)),h.material.uniforms.t2D.value=l,h.material.uniforms.backgroundIntensity.value=v.backgroundIntensity,h.material.toneMapped=Jt.getTransfer(l.colorSpace)!==re,l.matrixAutoUpdate===!0&&l.updateMatrix(),h.material.uniforms.uvTransform.value.copy(l.matrix),(g!==l||p!==l.version||_!==i.toneMapping)&&(h.material.needsUpdate=!0,g=l,p=l.version,_=i.toneMapping),h.layers.enableAll(),u.unshift(h,h.geometry,h.material,0,0,null))}function m(u,v){u.getRGB($s,xf(i)),n.buffers.color.setClear($s.r,$s.g,$s.b,v,a)}function d(){f!==void 0&&(f.geometry.dispose(),f.material.dispose(),f=void 0),h!==void 0&&(h.geometry.dispose(),h.material.dispose(),h=void 0)}return{getClearColor:function(){return o},setClearColor:function(u,v=1){o.set(u),c=v,m(o,c)},getClearAlpha:function(){return c},setClearAlpha:function(u){c=u,m(o,c)},render:b,addToRenderList:x,dispose:d}}function P_(i,t){const e=i.getParameter(i.MAX_VERTEX_ATTRIBS),n={},r=p(null);let s=r,a=!1;function o(S,A,w,I,N){let B=!1;const F=g(I,w,A);s!==F&&(s=F,h(s.object)),B=_(S,I,w,N),B&&M(S,I,w,N),N!==null&&t.update(N,i.ELEMENT_ARRAY_BUFFER),(B||a)&&(a=!1,v(S,A,w,I),N!==null&&i.bindBuffer(i.ELEMENT_ARRAY_BUFFER,t.get(N).buffer))}function c(){return i.createVertexArray()}function h(S){return i.bindVertexArray(S)}function f(S){return i.deleteVertexArray(S)}function g(S,A,w){const I=w.wireframe===!0;let N=n[S.id];N===void 0&&(N={},n[S.id]=N);let B=N[A.id];B===void 0&&(B={},N[A.id]=B);let F=B[I];return F===void 0&&(F=p(c()),B[I]=F),F}function p(S){const A=[],w=[],I=[];for(let N=0;N<e;N++)A[N]=0,w[N]=0,I[N]=0;return{geometry:null,program:null,wireframe:!1,newAttributes:A,enabledAttributes:w,attributeDivisors:I,object:S,attributes:{},index:null}}function _(S,A,w,I){const N=s.attributes,B=A.attributes;let F=0;const k=w.getAttributes();for(const z in k)if(k[z].location>=0){const Z=N[z];let it=B[z];if(it===void 0&&(z==="instanceMatrix"&&S.instanceMatrix&&(it=S.instanceMatrix),z==="instanceColor"&&S.instanceColor&&(it=S.instanceColor)),Z===void 0||Z.attribute!==it||it&&Z.data!==it.data)return!0;F++}return s.attributesNum!==F||s.index!==I}function M(S,A,w,I){const N={},B=A.attributes;let F=0;const k=w.getAttributes();for(const z in k)if(k[z].location>=0){let Z=B[z];Z===void 0&&(z==="instanceMatrix"&&S.instanceMatrix&&(Z=S.instanceMatrix),z==="instanceColor"&&S.instanceColor&&(Z=S.instanceColor));const it={};it.attribute=Z,Z&&Z.data&&(it.data=Z.data),N[z]=it,F++}s.attributes=N,s.attributesNum=F,s.index=I}function b(){const S=s.newAttributes;for(let A=0,w=S.length;A<w;A++)S[A]=0}function x(S){m(S,0)}function m(S,A){const w=s.newAttributes,I=s.enabledAttributes,N=s.attributeDivisors;w[S]=1,I[S]===0&&(i.enableVertexAttribArray(S),I[S]=1),N[S]!==A&&(i.vertexAttribDivisor(S,A),N[S]=A)}function d(){const S=s.newAttributes,A=s.enabledAttributes;for(let w=0,I=A.length;w<I;w++)A[w]!==S[w]&&(i.disableVertexAttribArray(w),A[w]=0)}function u(S,A,w,I,N,B,F){F===!0?i.vertexAttribIPointer(S,A,w,N,B):i.vertexAttribPointer(S,A,w,I,N,B)}function v(S,A,w,I){b();const N=I.attributes,B=w.getAttributes(),F=A.defaultAttributeValues;for(const k in B){const z=B[k];if(z.location>=0){let J=N[k];if(J===void 0&&(k==="instanceMatrix"&&S.instanceMatrix&&(J=S.instanceMatrix),k==="instanceColor"&&S.instanceColor&&(J=S.instanceColor)),J!==void 0){const Z=J.normalized,it=J.itemSize,pt=t.get(J);if(pt===void 0)continue;const _t=pt.buffer,W=pt.type,tt=pt.bytesPerElement,st=W===i.INT||W===i.UNSIGNED_INT||J.gpuType===El;if(J.isInterleavedBufferAttribute){const Q=J.data,at=Q.stride,xt=J.offset;if(Q.isInstancedInterleavedBuffer){for(let lt=0;lt<z.locationSize;lt++)m(z.location+lt,Q.meshPerAttribute);S.isInstancedMesh!==!0&&I._maxInstanceCount===void 0&&(I._maxInstanceCount=Q.meshPerAttribute*Q.count)}else for(let lt=0;lt<z.locationSize;lt++)x(z.location+lt);i.bindBuffer(i.ARRAY_BUFFER,_t);for(let lt=0;lt<z.locationSize;lt++)u(z.location+lt,it/z.locationSize,W,Z,at*tt,(xt+it/z.locationSize*lt)*tt,st)}else{if(J.isInstancedBufferAttribute){for(let Q=0;Q<z.locationSize;Q++)m(z.location+Q,J.meshPerAttribute);S.isInstancedMesh!==!0&&I._maxInstanceCount===void 0&&(I._maxInstanceCount=J.meshPerAttribute*J.count)}else for(let Q=0;Q<z.locationSize;Q++)x(z.location+Q);i.bindBuffer(i.ARRAY_BUFFER,_t);for(let Q=0;Q<z.locationSize;Q++)u(z.location+Q,it/z.locationSize,W,Z,it*tt,it/z.locationSize*Q*tt,st)}}else if(F!==void 0){const Z=F[k];if(Z!==void 0)switch(Z.length){case 2:i.vertexAttrib2fv(z.location,Z);break;case 3:i.vertexAttrib3fv(z.location,Z);break;case 4:i.vertexAttrib4fv(z.location,Z);break;default:i.vertexAttrib1fv(z.location,Z)}}}}d()}function l(){E();for(const S in n){const A=n[S];for(const w in A){const I=A[w];for(const N in I)f(I[N].object),delete I[N];delete A[w]}delete n[S]}}function R(S){if(n[S.id]===void 0)return;const A=n[S.id];for(const w in A){const I=A[w];for(const N in I)f(I[N].object),delete I[N];delete A[w]}delete n[S.id]}function T(S){for(const A in n){const w=n[A];if(w[S.id]===void 0)continue;const I=w[S.id];for(const N in I)f(I[N].object),delete I[N];delete w[S.id]}}function E(){y(),a=!0,s!==r&&(s=r,h(s.object))}function y(){r.geometry=null,r.program=null,r.wireframe=!1}return{setup:o,reset:E,resetDefaultState:y,dispose:l,releaseStatesOfGeometry:R,releaseStatesOfProgram:T,initAttributes:b,enableAttribute:x,disableUnusedAttributes:d}}function I_(i,t,e){let n;function r(h){n=h}function s(h,f){i.drawArrays(n,h,f),e.update(f,n,1)}function a(h,f,g){g!==0&&(i.drawArraysInstanced(n,h,f,g),e.update(f,n,g))}function o(h,f,g){if(g===0)return;t.get("WEBGL_multi_draw").multiDrawArraysWEBGL(n,h,0,f,0,g);let _=0;for(let M=0;M<g;M++)_+=f[M];e.update(_,n,1)}function c(h,f,g,p){if(g===0)return;const _=t.get("WEBGL_multi_draw");if(_===null)for(let M=0;M<h.length;M++)a(h[M],f[M],p[M]);else{_.multiDrawArraysInstancedWEBGL(n,h,0,f,0,p,0,g);let M=0;for(let b=0;b<g;b++)M+=f[b]*p[b];e.update(M,n,1)}}this.setMode=r,this.render=s,this.renderInstances=a,this.renderMultiDraw=o,this.renderMultiDrawInstances=c}function L_(i,t,e,n){let r;function s(){if(r!==void 0)return r;if(t.has("EXT_texture_filter_anisotropic")===!0){const T=t.get("EXT_texture_filter_anisotropic");r=i.getParameter(T.MAX_TEXTURE_MAX_ANISOTROPY_EXT)}else r=0;return r}function a(T){return!(T!==Ke&&n.convert(T)!==i.getParameter(i.IMPLEMENTATION_COLOR_READ_FORMAT))}function o(T){const E=T===_s&&(t.has("EXT_color_buffer_half_float")||t.has("EXT_color_buffer_float"));return!(T!==Ln&&n.convert(T)!==i.getParameter(i.IMPLEMENTATION_COLOR_READ_TYPE)&&T!==yn&&!E)}function c(T){if(T==="highp"){if(i.getShaderPrecisionFormat(i.VERTEX_SHADER,i.HIGH_FLOAT).precision>0&&i.getShaderPrecisionFormat(i.FRAGMENT_SHADER,i.HIGH_FLOAT).precision>0)return"highp";T="mediump"}return T==="mediump"&&i.getShaderPrecisionFormat(i.VERTEX_SHADER,i.MEDIUM_FLOAT).precision>0&&i.getShaderPrecisionFormat(i.FRAGMENT_SHADER,i.MEDIUM_FLOAT).precision>0?"mediump":"lowp"}let h=e.precision!==void 0?e.precision:"highp";const f=c(h);f!==h&&(console.warn("THREE.WebGLRenderer:",h,"not supported, using",f,"instead."),h=f);const g=e.logarithmicDepthBuffer===!0,p=e.reverseDepthBuffer===!0&&t.has("EXT_clip_control"),_=i.getParameter(i.MAX_TEXTURE_IMAGE_UNITS),M=i.getParameter(i.MAX_VERTEX_TEXTURE_IMAGE_UNITS),b=i.getParameter(i.MAX_TEXTURE_SIZE),x=i.getParameter(i.MAX_CUBE_MAP_TEXTURE_SIZE),m=i.getParameter(i.MAX_VERTEX_ATTRIBS),d=i.getParameter(i.MAX_VERTEX_UNIFORM_VECTORS),u=i.getParameter(i.MAX_VARYING_VECTORS),v=i.getParameter(i.MAX_FRAGMENT_UNIFORM_VECTORS),l=M>0,R=i.getParameter(i.MAX_SAMPLES);return{isWebGL2:!0,getMaxAnisotropy:s,getMaxPrecision:c,textureFormatReadable:a,textureTypeReadable:o,precision:h,logarithmicDepthBuffer:g,reverseDepthBuffer:p,maxTextures:_,maxVertexTextures:M,maxTextureSize:b,maxCubemapSize:x,maxAttributes:m,maxVertexUniforms:d,maxVaryings:u,maxFragmentUniforms:v,vertexTextures:l,maxSamples:R}}function D_(i){const t=this;let e=null,n=0,r=!1,s=!1;const a=new En,o=new Gt,c={value:null,needsUpdate:!1};this.uniform=c,this.numPlanes=0,this.numIntersection=0,this.init=function(g,p){const _=g.length!==0||p||n!==0||r;return r=p,n=g.length,_},this.beginShadows=function(){s=!0,f(null)},this.endShadows=function(){s=!1},this.setGlobalState=function(g,p){e=f(g,p,0)},this.setState=function(g,p,_){const M=g.clippingPlanes,b=g.clipIntersection,x=g.clipShadows,m=i.get(g);if(!r||M===null||M.length===0||s&&!x)s?f(null):h();else{const d=s?0:n,u=d*4;let v=m.clippingState||null;c.value=v,v=f(M,p,u,_);for(let l=0;l!==u;++l)v[l]=e[l];m.clippingState=v,this.numIntersection=b?this.numPlanes:0,this.numPlanes+=d}};function h(){c.value!==e&&(c.value=e,c.needsUpdate=n>0),t.numPlanes=n,t.numIntersection=0}function f(g,p,_,M){const b=g!==null?g.length:0;let x=null;if(b!==0){if(x=c.value,M!==!0||x===null){const m=_+b*4,d=p.matrixWorldInverse;o.getNormalMatrix(d),(x===null||x.length<m)&&(x=new Float32Array(m));for(let u=0,v=_;u!==b;++u,v+=4)a.copy(g[u]).applyMatrix4(d,o),a.normal.toArray(x,v),x[v+3]=a.constant}c.value=x,c.needsUpdate=!0}return t.numPlanes=b,t.numIntersection=0,x}}function U_(i){let t=new WeakMap;function e(a,o){return o===Dc?a.mapping=Ar:o===Uc&&(a.mapping=wr),a}function n(a){if(a&&a.isTexture){const o=a.mapping;if(o===Dc||o===Uc)if(t.has(a)){const c=t.get(a).texture;return e(c,a.mapping)}else{const c=a.image;if(c&&c.height>0){const h=new Tp(c.height);return h.fromEquirectangularTexture(i,a),t.set(a,h),a.addEventListener("dispose",r),e(h.texture,a.mapping)}else return null}}return a}function r(a){const o=a.target;o.removeEventListener("dispose",r);const c=t.get(o);c!==void 0&&(t.delete(o),c.dispose())}function s(){t=new WeakMap}return{get:n,dispose:s}}const mr=4,Iu=[.125,.215,.35,.446,.526,.582],Di=20,Pa=new Af,Lu=new qt;let Ia=null,La=0,Da=0,Ua=!1;const Ii=(1+Math.sqrt(5))/2,er=1/Ii,Du=[new U(-Ii,er,0),new U(Ii,er,0),new U(-er,0,Ii),new U(er,0,Ii),new U(0,Ii,-er),new U(0,Ii,er),new U(-1,1,-1),new U(1,1,-1),new U(-1,1,1),new U(1,1,1)],N_=new U;class Uu{constructor(t){this._renderer=t,this._pingPongRenderTarget=null,this._lodMax=0,this._cubeSize=0,this._lodPlanes=[],this._sizeLods=[],this._sigmas=[],this._blurMaterial=null,this._cubemapMaterial=null,this._equirectMaterial=null,this._compileMaterial(this._blurMaterial)}fromScene(t,e=0,n=.1,r=100,s={}){const{size:a=256,position:o=N_}=s;Ia=this._renderer.getRenderTarget(),La=this._renderer.getActiveCubeFace(),Da=this._renderer.getActiveMipmapLevel(),Ua=this._renderer.xr.enabled,this._renderer.xr.enabled=!1,this._setSize(a);const c=this._allocateTargets();return c.depthBuffer=!0,this._sceneToCubeUV(t,n,r,c,o),e>0&&this._blur(c,0,0,e),this._applyPMREM(c),this._cleanup(c),c}fromEquirectangular(t,e=null){return this._fromTexture(t,e)}fromCubemap(t,e=null){return this._fromTexture(t,e)}compileCubemapShader(){this._cubemapMaterial===null&&(this._cubemapMaterial=Bu(),this._compileMaterial(this._cubemapMaterial))}compileEquirectangularShader(){this._equirectMaterial===null&&(this._equirectMaterial=Fu(),this._compileMaterial(this._equirectMaterial))}dispose(){this._dispose(),this._cubemapMaterial!==null&&this._cubemapMaterial.dispose(),this._equirectMaterial!==null&&this._equirectMaterial.dispose()}_setSize(t){this._lodMax=Math.floor(Math.log2(t)),this._cubeSize=Math.pow(2,this._lodMax)}_dispose(){this._blurMaterial!==null&&this._blurMaterial.dispose(),this._pingPongRenderTarget!==null&&this._pingPongRenderTarget.dispose();for(let t=0;t<this._lodPlanes.length;t++)this._lodPlanes[t].dispose()}_cleanup(t){this._renderer.setRenderTarget(Ia,La,Da),this._renderer.xr.enabled=Ua,t.scissorTest=!1,js(t,0,0,t.width,t.height)}_fromTexture(t,e){t.mapping===Ar||t.mapping===wr?this._setSize(t.image.length===0?16:t.image[0].width||t.image[0].image.width):this._setSize(t.image.width/4),Ia=this._renderer.getRenderTarget(),La=this._renderer.getActiveCubeFace(),Da=this._renderer.getActiveMipmapLevel(),Ua=this._renderer.xr.enabled,this._renderer.xr.enabled=!1;const n=e||this._allocateTargets();return this._textureToCubeUV(t,n),this._applyPMREM(n),this._cleanup(n),n}_allocateTargets(){const t=3*Math.max(this._cubeSize,112),e=4*this._cubeSize,n={magFilter:bn,minFilter:bn,generateMipmaps:!1,type:_s,format:Ke,colorSpace:Rr,depthBuffer:!1},r=Nu(t,e,n);if(this._pingPongRenderTarget===null||this._pingPongRenderTarget.width!==t||this._pingPongRenderTarget.height!==e){this._pingPongRenderTarget!==null&&this._dispose(),this._pingPongRenderTarget=Nu(t,e,n);const{_lodMax:s}=this;({sizeLods:this._sizeLods,lodPlanes:this._lodPlanes,sigmas:this._sigmas}=F_(s)),this._blurMaterial=B_(s,t,e)}return r}_compileMaterial(t){const e=new Ie(this._lodPlanes[0],t);this._renderer.compile(e,Pa)}_sceneToCubeUV(t,e,n,r,s){const c=new sn(90,1,e,n),h=[1,-1,1,1,1,1],f=[1,1,1,-1,-1,-1],g=this._renderer,p=g.autoClear,_=g.toneMapping;g.getClearColor(Lu),g.toneMapping=ui,g.autoClear=!1;const M=new gf({name:"PMREM.Background",side:ze,depthWrite:!1,depthTest:!1}),b=new Ie(new ys,M);let x=!1;const m=t.background;m?m.isColor&&(M.color.copy(m),t.background=null,x=!0):(M.color.copy(Lu),x=!0);for(let d=0;d<6;d++){const u=d%3;u===0?(c.up.set(0,h[d],0),c.position.set(s.x,s.y,s.z),c.lookAt(s.x+f[d],s.y,s.z)):u===1?(c.up.set(0,0,h[d]),c.position.set(s.x,s.y,s.z),c.lookAt(s.x,s.y+f[d],s.z)):(c.up.set(0,h[d],0),c.position.set(s.x,s.y,s.z),c.lookAt(s.x,s.y,s.z+f[d]));const v=this._cubeSize;js(r,u*v,d>2?v:0,v,v),g.setRenderTarget(r),x&&g.render(b,c),g.render(t,c)}b.geometry.dispose(),b.material.dispose(),g.toneMapping=_,g.autoClear=p,t.background=m}_textureToCubeUV(t,e){const n=this._renderer,r=t.mapping===Ar||t.mapping===wr;r?(this._cubemapMaterial===null&&(this._cubemapMaterial=Bu()),this._cubemapMaterial.uniforms.flipEnvMap.value=t.isRenderTargetTexture===!1?-1:1):this._equirectMaterial===null&&(this._equirectMaterial=Fu());const s=r?this._cubemapMaterial:this._equirectMaterial,a=new Ie(this._lodPlanes[0],s),o=s.uniforms;o.envMap.value=t;const c=this._cubeSize;js(e,0,0,3*c,2*c),n.setRenderTarget(e),n.render(a,Pa)}_applyPMREM(t){const e=this._renderer,n=e.autoClear;e.autoClear=!1;const r=this._lodPlanes.length;for(let s=1;s<r;s++){const a=Math.sqrt(this._sigmas[s]*this._sigmas[s]-this._sigmas[s-1]*this._sigmas[s-1]),o=Du[(r-s-1)%Du.length];this._blur(t,s-1,s,a,o)}e.autoClear=n}_blur(t,e,n,r,s){const a=this._pingPongRenderTarget;this._halfBlur(t,a,e,n,r,"latitudinal",s),this._halfBlur(a,t,n,n,r,"longitudinal",s)}_halfBlur(t,e,n,r,s,a,o){const c=this._renderer,h=this._blurMaterial;a!=="latitudinal"&&a!=="longitudinal"&&console.error("blur direction must be either latitudinal or longitudinal!");const f=3,g=new Ie(this._lodPlanes[r],h),p=h.uniforms,_=this._sizeLods[n]-1,M=isFinite(s)?Math.PI/(2*_):2*Math.PI/(2*Di-1),b=s/M,x=isFinite(s)?1+Math.floor(f*b):Di;x>Di&&console.warn(`sigmaRadians, ${s}, is too large and will clip, as it requested ${x} samples when the maximum is set to ${Di}`);const m=[];let d=0;for(let T=0;T<Di;++T){const E=T/b,y=Math.exp(-E*E/2);m.push(y),T===0?d+=y:T<x&&(d+=2*y)}for(let T=0;T<m.length;T++)m[T]=m[T]/d;p.envMap.value=t.texture,p.samples.value=x,p.weights.value=m,p.latitudinal.value=a==="latitudinal",o&&(p.poleAxis.value=o);const{_lodMax:u}=this;p.dTheta.value=M,p.mipInt.value=u-n;const v=this._sizeLods[r],l=3*v*(r>u-mr?r-u+mr:0),R=4*(this._cubeSize-v);js(e,l,R,3*v,2*v),c.setRenderTarget(e),c.render(g,Pa)}}function F_(i){const t=[],e=[],n=[];let r=i;const s=i-mr+1+Iu.length;for(let a=0;a<s;a++){const o=Math.pow(2,r);e.push(o);let c=1/o;a>i-mr?c=Iu[a-i+mr-1]:a===0&&(c=0),n.push(c);const h=1/(o-2),f=-h,g=1+h,p=[f,f,g,f,g,g,f,f,g,g,f,g],_=6,M=6,b=3,x=2,m=1,d=new Float32Array(b*M*_),u=new Float32Array(x*M*_),v=new Float32Array(m*M*_);for(let R=0;R<_;R++){const T=R%3*2/3-1,E=R>2?0:-1,y=[T,E,0,T+2/3,E,0,T+2/3,E+1,0,T,E,0,T+2/3,E+1,0,T,E+1,0];d.set(y,b*M*R),u.set(p,x*M*R);const S=[R,R,R,R,R,R];v.set(S,m*M*R)}const l=new De;l.setAttribute("position",new de(d,b)),l.setAttribute("uv",new de(u,x)),l.setAttribute("faceIndex",new de(v,m)),t.push(l),r>mr&&r--}return{lodPlanes:t,sizeLods:e,sigmas:n}}function Nu(i,t,e){const n=new Vi(i,t,e);return n.texture.mapping=Xo,n.texture.name="PMREM.cubeUv",n.scissorTest=!0,n}function js(i,t,e,n,r){i.viewport.set(t,e,n,r),i.scissor.set(t,e,n,r)}function B_(i,t,e){const n=new Float32Array(Di),r=new U(0,1,0);return new pi({name:"SphericalGaussianBlur",defines:{n:Di,CUBEUV_TEXEL_WIDTH:1/t,CUBEUV_TEXEL_HEIGHT:1/e,CUBEUV_MAX_MIP:`${i}.0`},uniforms:{envMap:{value:null},samples:{value:1},weights:{value:n},latitudinal:{value:!1},dTheta:{value:0},mipInt:{value:0},poleAxis:{value:r}},vertexShader:Il(),fragmentShader:`

			precision mediump float;
			precision mediump int;

			varying vec3 vOutputDirection;

			uniform sampler2D envMap;
			uniform int samples;
			uniform float weights[ n ];
			uniform bool latitudinal;
			uniform float dTheta;
			uniform float mipInt;
			uniform vec3 poleAxis;

			#define ENVMAP_TYPE_CUBE_UV
			#include <cube_uv_reflection_fragment>

			vec3 getSample( float theta, vec3 axis ) {

				float cosTheta = cos( theta );
				// Rodrigues' axis-angle rotation
				vec3 sampleDirection = vOutputDirection * cosTheta
					+ cross( axis, vOutputDirection ) * sin( theta )
					+ axis * dot( axis, vOutputDirection ) * ( 1.0 - cosTheta );

				return bilinearCubeUV( envMap, sampleDirection, mipInt );

			}

			void main() {

				vec3 axis = latitudinal ? poleAxis : cross( poleAxis, vOutputDirection );

				if ( all( equal( axis, vec3( 0.0 ) ) ) ) {

					axis = vec3( vOutputDirection.z, 0.0, - vOutputDirection.x );

				}

				axis = normalize( axis );

				gl_FragColor = vec4( 0.0, 0.0, 0.0, 1.0 );
				gl_FragColor.rgb += weights[ 0 ] * getSample( 0.0, axis );

				for ( int i = 1; i < n; i++ ) {

					if ( i >= samples ) {

						break;

					}

					float theta = dTheta * float( i );
					gl_FragColor.rgb += weights[ i ] * getSample( -1.0 * theta, axis );
					gl_FragColor.rgb += weights[ i ] * getSample( theta, axis );

				}

			}
		`,blending:li,depthTest:!1,depthWrite:!1})}function Fu(){return new pi({name:"EquirectangularToCubeUV",uniforms:{envMap:{value:null}},vertexShader:Il(),fragmentShader:`

			precision mediump float;
			precision mediump int;

			varying vec3 vOutputDirection;

			uniform sampler2D envMap;

			#include <common>

			void main() {

				vec3 outputDirection = normalize( vOutputDirection );
				vec2 uv = equirectUv( outputDirection );

				gl_FragColor = vec4( texture2D ( envMap, uv ).rgb, 1.0 );

			}
		`,blending:li,depthTest:!1,depthWrite:!1})}function Bu(){return new pi({name:"CubemapToCubeUV",uniforms:{envMap:{value:null},flipEnvMap:{value:-1}},vertexShader:Il(),fragmentShader:`

			precision mediump float;
			precision mediump int;

			uniform float flipEnvMap;

			varying vec3 vOutputDirection;

			uniform samplerCube envMap;

			void main() {

				gl_FragColor = textureCube( envMap, vec3( flipEnvMap * vOutputDirection.x, vOutputDirection.yz ) );

			}
		`,blending:li,depthTest:!1,depthWrite:!1})}function Il(){return`

		precision mediump float;
		precision mediump int;

		attribute float faceIndex;

		varying vec3 vOutputDirection;

		// RH coordinate system; PMREM face-indexing convention
		vec3 getDirection( vec2 uv, float face ) {

			uv = 2.0 * uv - 1.0;

			vec3 direction = vec3( uv, 1.0 );

			if ( face == 0.0 ) {

				direction = direction.zyx; // ( 1, v, u ) pos x

			} else if ( face == 1.0 ) {

				direction = direction.xzy;
				direction.xz *= -1.0; // ( -u, 1, -v ) pos y

			} else if ( face == 2.0 ) {

				direction.x *= -1.0; // ( -u, v, 1 ) pos z

			} else if ( face == 3.0 ) {

				direction = direction.zyx;
				direction.xz *= -1.0; // ( -1, v, -u ) neg x

			} else if ( face == 4.0 ) {

				direction = direction.xzy;
				direction.xy *= -1.0; // ( -u, -1, v ) neg y

			} else if ( face == 5.0 ) {

				direction.z *= -1.0; // ( u, v, -1 ) neg z

			}

			return direction;

		}

		void main() {

			vOutputDirection = getDirection( uv, faceIndex );
			gl_Position = vec4( position, 1.0 );

		}
	`}function O_(i){let t=new WeakMap,e=null;function n(o){if(o&&o.isTexture){const c=o.mapping,h=c===Dc||c===Uc,f=c===Ar||c===wr;if(h||f){let g=t.get(o);const p=g!==void 0?g.texture.pmremVersion:0;if(o.isRenderTargetTexture&&o.pmremVersion!==p)return e===null&&(e=new Uu(i)),g=h?e.fromEquirectangular(o,g):e.fromCubemap(o,g),g.texture.pmremVersion=o.pmremVersion,t.set(o,g),g.texture;if(g!==void 0)return g.texture;{const _=o.image;return h&&_&&_.height>0||f&&_&&r(_)?(e===null&&(e=new Uu(i)),g=h?e.fromEquirectangular(o):e.fromCubemap(o),g.texture.pmremVersion=o.pmremVersion,t.set(o,g),o.addEventListener("dispose",s),g.texture):null}}}return o}function r(o){let c=0;const h=6;for(let f=0;f<h;f++)o[f]!==void 0&&c++;return c===h}function s(o){const c=o.target;c.removeEventListener("dispose",s);const h=t.get(c);h!==void 0&&(t.delete(c),h.dispose())}function a(){t=new WeakMap,e!==null&&(e.dispose(),e=null)}return{get:n,dispose:a}}function z_(i){const t={};function e(n){if(t[n]!==void 0)return t[n];let r;switch(n){case"WEBGL_depth_texture":r=i.getExtension("WEBGL_depth_texture")||i.getExtension("MOZ_WEBGL_depth_texture")||i.getExtension("WEBKIT_WEBGL_depth_texture");break;case"EXT_texture_filter_anisotropic":r=i.getExtension("EXT_texture_filter_anisotropic")||i.getExtension("MOZ_EXT_texture_filter_anisotropic")||i.getExtension("WEBKIT_EXT_texture_filter_anisotropic");break;case"WEBGL_compressed_texture_s3tc":r=i.getExtension("WEBGL_compressed_texture_s3tc")||i.getExtension("MOZ_WEBGL_compressed_texture_s3tc")||i.getExtension("WEBKIT_WEBGL_compressed_texture_s3tc");break;case"WEBGL_compressed_texture_pvrtc":r=i.getExtension("WEBGL_compressed_texture_pvrtc")||i.getExtension("WEBKIT_WEBGL_compressed_texture_pvrtc");break;default:r=i.getExtension(n)}return t[n]=r,r}return{has:function(n){return e(n)!==null},init:function(){e("EXT_color_buffer_float"),e("WEBGL_clip_cull_distance"),e("OES_texture_float_linear"),e("EXT_color_buffer_half_float"),e("WEBGL_multisampled_render_to_texture"),e("WEBGL_render_shared_exponent")},get:function(n){const r=e(n);return r===null&&Sr("THREE.WebGLRenderer: "+n+" extension not supported."),r}}}function V_(i,t,e,n){const r={},s=new WeakMap;function a(g){const p=g.target;p.index!==null&&t.remove(p.index);for(const M in p.attributes)t.remove(p.attributes[M]);p.removeEventListener("dispose",a),delete r[p.id];const _=s.get(p);_&&(t.remove(_),s.delete(p)),n.releaseStatesOfGeometry(p),p.isInstancedBufferGeometry===!0&&delete p._maxInstanceCount,e.memory.geometries--}function o(g,p){return r[p.id]===!0||(p.addEventListener("dispose",a),r[p.id]=!0,e.memory.geometries++),p}function c(g){const p=g.attributes;for(const _ in p)t.update(p[_],i.ARRAY_BUFFER)}function h(g){const p=[],_=g.index,M=g.attributes.position;let b=0;if(_!==null){const d=_.array;b=_.version;for(let u=0,v=d.length;u<v;u+=3){const l=d[u+0],R=d[u+1],T=d[u+2];p.push(l,R,R,T,T,l)}}else if(M!==void 0){const d=M.array;b=M.version;for(let u=0,v=d.length/3-1;u<v;u+=3){const l=u+0,R=u+1,T=u+2;p.push(l,R,R,T,T,l)}}else return;const x=new(ff(p)?_f:mf)(p,1);x.version=b;const m=s.get(g);m&&t.remove(m),s.set(g,x)}function f(g){const p=s.get(g);if(p){const _=g.index;_!==null&&p.version<_.version&&h(g)}else h(g);return s.get(g)}return{get:o,update:c,getWireframeAttribute:f}}function H_(i,t,e){let n;function r(p){n=p}let s,a;function o(p){s=p.type,a=p.bytesPerElement}function c(p,_){i.drawElements(n,_,s,p*a),e.update(_,n,1)}function h(p,_,M){M!==0&&(i.drawElementsInstanced(n,_,s,p*a,M),e.update(_,n,M))}function f(p,_,M){if(M===0)return;t.get("WEBGL_multi_draw").multiDrawElementsWEBGL(n,_,0,s,p,0,M);let x=0;for(let m=0;m<M;m++)x+=_[m];e.update(x,n,1)}function g(p,_,M,b){if(M===0)return;const x=t.get("WEBGL_multi_draw");if(x===null)for(let m=0;m<p.length;m++)h(p[m]/a,_[m],b[m]);else{x.multiDrawElementsInstancedWEBGL(n,_,0,s,p,0,b,0,M);let m=0;for(let d=0;d<M;d++)m+=_[d]*b[d];e.update(m,n,1)}}this.setMode=r,this.setIndex=o,this.render=c,this.renderInstances=h,this.renderMultiDraw=f,this.renderMultiDrawInstances=g}function G_(i){const t={geometries:0,textures:0},e={frame:0,calls:0,triangles:0,points:0,lines:0};function n(s,a,o){switch(e.calls++,a){case i.TRIANGLES:e.triangles+=o*(s/3);break;case i.LINES:e.lines+=o*(s/2);break;case i.LINE_STRIP:e.lines+=o*(s-1);break;case i.LINE_LOOP:e.lines+=o*s;break;case i.POINTS:e.points+=o*s;break;default:console.error("THREE.WebGLInfo: Unknown draw mode:",a);break}}function r(){e.calls=0,e.triangles=0,e.points=0,e.lines=0}return{memory:t,render:e,programs:null,autoReset:!0,reset:r,update:n}}function k_(i,t,e){const n=new WeakMap,r=new ie;function s(a,o,c){const h=a.morphTargetInfluences,f=o.morphAttributes.position||o.morphAttributes.normal||o.morphAttributes.color,g=f!==void 0?f.length:0;let p=n.get(o);if(p===void 0||p.count!==g){let S=function(){E.dispose(),n.delete(o),o.removeEventListener("dispose",S)};var _=S;p!==void 0&&p.texture.dispose();const M=o.morphAttributes.position!==void 0,b=o.morphAttributes.normal!==void 0,x=o.morphAttributes.color!==void 0,m=o.morphAttributes.position||[],d=o.morphAttributes.normal||[],u=o.morphAttributes.color||[];let v=0;M===!0&&(v=1),b===!0&&(v=2),x===!0&&(v=3);let l=o.attributes.position.count*v,R=1;l>t.maxTextureSize&&(R=Math.ceil(l/t.maxTextureSize),l=t.maxTextureSize);const T=new Float32Array(l*R*4*g),E=new df(T,l,R,g);E.type=yn,E.needsUpdate=!0;const y=v*4;for(let A=0;A<g;A++){const w=m[A],I=d[A],N=u[A],B=l*R*4*A;for(let F=0;F<w.count;F++){const k=F*y;M===!0&&(r.fromBufferAttribute(w,F),T[B+k+0]=r.x,T[B+k+1]=r.y,T[B+k+2]=r.z,T[B+k+3]=0),b===!0&&(r.fromBufferAttribute(I,F),T[B+k+4]=r.x,T[B+k+5]=r.y,T[B+k+6]=r.z,T[B+k+7]=0),x===!0&&(r.fromBufferAttribute(N,F),T[B+k+8]=r.x,T[B+k+9]=r.y,T[B+k+10]=r.z,T[B+k+11]=N.itemSize===4?r.w:1)}}p={count:g,texture:E,size:new kt(l,R)},n.set(o,p),o.addEventListener("dispose",S)}if(a.isInstancedMesh===!0&&a.morphTexture!==null)c.getUniforms().setValue(i,"morphTexture",a.morphTexture,e);else{let M=0;for(let x=0;x<h.length;x++)M+=h[x];const b=o.morphTargetsRelative?1:1-M;c.getUniforms().setValue(i,"morphTargetBaseInfluence",b),c.getUniforms().setValue(i,"morphTargetInfluences",h)}c.getUniforms().setValue(i,"morphTargetsTexture",p.texture,e),c.getUniforms().setValue(i,"morphTargetsTextureSize",p.size)}return{update:s}}function W_(i,t,e,n){let r=new WeakMap;function s(c){const h=n.render.frame,f=c.geometry,g=t.get(c,f);if(r.get(g)!==h&&(t.update(g),r.set(g,h)),c.isInstancedMesh&&(c.hasEventListener("dispose",o)===!1&&c.addEventListener("dispose",o),r.get(c)!==h&&(e.update(c.instanceMatrix,i.ARRAY_BUFFER),c.instanceColor!==null&&e.update(c.instanceColor,i.ARRAY_BUFFER),r.set(c,h))),c.isSkinnedMesh){const p=c.skeleton;r.get(p)!==h&&(p.update(),r.set(p,h))}return g}function a(){r=new WeakMap}function o(c){const h=c.target;h.removeEventListener("dispose",o),e.remove(h.instanceMatrix),h.instanceColor!==null&&e.remove(h.instanceColor)}return{update:s,dispose:a}}const Rf=new Le,Ou=new Mf(1,1),Cf=new df,Pf=new ap,If=new yf,zu=[],Vu=[],Hu=new Float32Array(16),Gu=new Float32Array(9),ku=new Float32Array(4);function Ur(i,t,e){const n=i[0];if(n<=0||n>0)return i;const r=t*e;let s=zu[r];if(s===void 0&&(s=new Float32Array(r),zu[r]=s),t!==0){n.toArray(s,0);for(let a=1,o=0;a!==t;++a)o+=e,i[a].toArray(s,o)}return s}function Se(i,t){if(i.length!==t.length)return!1;for(let e=0,n=i.length;e<n;e++)if(i[e]!==t[e])return!1;return!0}function Me(i,t){for(let e=0,n=t.length;e<n;e++)i[e]=t[e]}function Yo(i,t){let e=Vu[t];e===void 0&&(e=new Int32Array(t),Vu[t]=e);for(let n=0;n!==t;++n)e[n]=i.allocateTextureUnit();return e}function X_(i,t){const e=this.cache;e[0]!==t&&(i.uniform1f(this.addr,t),e[0]=t)}function q_(i,t){const e=this.cache;if(t.x!==void 0)(e[0]!==t.x||e[1]!==t.y)&&(i.uniform2f(this.addr,t.x,t.y),e[0]=t.x,e[1]=t.y);else{if(Se(e,t))return;i.uniform2fv(this.addr,t),Me(e,t)}}function Y_(i,t){const e=this.cache;if(t.x!==void 0)(e[0]!==t.x||e[1]!==t.y||e[2]!==t.z)&&(i.uniform3f(this.addr,t.x,t.y,t.z),e[0]=t.x,e[1]=t.y,e[2]=t.z);else if(t.r!==void 0)(e[0]!==t.r||e[1]!==t.g||e[2]!==t.b)&&(i.uniform3f(this.addr,t.r,t.g,t.b),e[0]=t.r,e[1]=t.g,e[2]=t.b);else{if(Se(e,t))return;i.uniform3fv(this.addr,t),Me(e,t)}}function $_(i,t){const e=this.cache;if(t.x!==void 0)(e[0]!==t.x||e[1]!==t.y||e[2]!==t.z||e[3]!==t.w)&&(i.uniform4f(this.addr,t.x,t.y,t.z,t.w),e[0]=t.x,e[1]=t.y,e[2]=t.z,e[3]=t.w);else{if(Se(e,t))return;i.uniform4fv(this.addr,t),Me(e,t)}}function j_(i,t){const e=this.cache,n=t.elements;if(n===void 0){if(Se(e,t))return;i.uniformMatrix2fv(this.addr,!1,t),Me(e,t)}else{if(Se(e,n))return;ku.set(n),i.uniformMatrix2fv(this.addr,!1,ku),Me(e,n)}}function K_(i,t){const e=this.cache,n=t.elements;if(n===void 0){if(Se(e,t))return;i.uniformMatrix3fv(this.addr,!1,t),Me(e,t)}else{if(Se(e,n))return;Gu.set(n),i.uniformMatrix3fv(this.addr,!1,Gu),Me(e,n)}}function Z_(i,t){const e=this.cache,n=t.elements;if(n===void 0){if(Se(e,t))return;i.uniformMatrix4fv(this.addr,!1,t),Me(e,t)}else{if(Se(e,n))return;Hu.set(n),i.uniformMatrix4fv(this.addr,!1,Hu),Me(e,n)}}function J_(i,t){const e=this.cache;e[0]!==t&&(i.uniform1i(this.addr,t),e[0]=t)}function Q_(i,t){const e=this.cache;if(t.x!==void 0)(e[0]!==t.x||e[1]!==t.y)&&(i.uniform2i(this.addr,t.x,t.y),e[0]=t.x,e[1]=t.y);else{if(Se(e,t))return;i.uniform2iv(this.addr,t),Me(e,t)}}function tx(i,t){const e=this.cache;if(t.x!==void 0)(e[0]!==t.x||e[1]!==t.y||e[2]!==t.z)&&(i.uniform3i(this.addr,t.x,t.y,t.z),e[0]=t.x,e[1]=t.y,e[2]=t.z);else{if(Se(e,t))return;i.uniform3iv(this.addr,t),Me(e,t)}}function ex(i,t){const e=this.cache;if(t.x!==void 0)(e[0]!==t.x||e[1]!==t.y||e[2]!==t.z||e[3]!==t.w)&&(i.uniform4i(this.addr,t.x,t.y,t.z,t.w),e[0]=t.x,e[1]=t.y,e[2]=t.z,e[3]=t.w);else{if(Se(e,t))return;i.uniform4iv(this.addr,t),Me(e,t)}}function nx(i,t){const e=this.cache;e[0]!==t&&(i.uniform1ui(this.addr,t),e[0]=t)}function ix(i,t){const e=this.cache;if(t.x!==void 0)(e[0]!==t.x||e[1]!==t.y)&&(i.uniform2ui(this.addr,t.x,t.y),e[0]=t.x,e[1]=t.y);else{if(Se(e,t))return;i.uniform2uiv(this.addr,t),Me(e,t)}}function rx(i,t){const e=this.cache;if(t.x!==void 0)(e[0]!==t.x||e[1]!==t.y||e[2]!==t.z)&&(i.uniform3ui(this.addr,t.x,t.y,t.z),e[0]=t.x,e[1]=t.y,e[2]=t.z);else{if(Se(e,t))return;i.uniform3uiv(this.addr,t),Me(e,t)}}function sx(i,t){const e=this.cache;if(t.x!==void 0)(e[0]!==t.x||e[1]!==t.y||e[2]!==t.z||e[3]!==t.w)&&(i.uniform4ui(this.addr,t.x,t.y,t.z,t.w),e[0]=t.x,e[1]=t.y,e[2]=t.z,e[3]=t.w);else{if(Se(e,t))return;i.uniform4uiv(this.addr,t),Me(e,t)}}function ox(i,t,e){const n=this.cache,r=e.allocateTextureUnit();n[0]!==r&&(i.uniform1i(this.addr,r),n[0]=r);let s;this.type===i.SAMPLER_2D_SHADOW?(Ou.compareFunction=hf,s=Ou):s=Rf,e.setTexture2D(t||s,r)}function ax(i,t,e){const n=this.cache,r=e.allocateTextureUnit();n[0]!==r&&(i.uniform1i(this.addr,r),n[0]=r),e.setTexture3D(t||Pf,r)}function cx(i,t,e){const n=this.cache,r=e.allocateTextureUnit();n[0]!==r&&(i.uniform1i(this.addr,r),n[0]=r),e.setTextureCube(t||If,r)}function lx(i,t,e){const n=this.cache,r=e.allocateTextureUnit();n[0]!==r&&(i.uniform1i(this.addr,r),n[0]=r),e.setTexture2DArray(t||Cf,r)}function ux(i){switch(i){case 5126:return X_;case 35664:return q_;case 35665:return Y_;case 35666:return $_;case 35674:return j_;case 35675:return K_;case 35676:return Z_;case 5124:case 35670:return J_;case 35667:case 35671:return Q_;case 35668:case 35672:return tx;case 35669:case 35673:return ex;case 5125:return nx;case 36294:return ix;case 36295:return rx;case 36296:return sx;case 35678:case 36198:case 36298:case 36306:case 35682:return ox;case 35679:case 36299:case 36307:return ax;case 35680:case 36300:case 36308:case 36293:return cx;case 36289:case 36303:case 36311:case 36292:return lx}}function hx(i,t){i.uniform1fv(this.addr,t)}function fx(i,t){const e=Ur(t,this.size,2);i.uniform2fv(this.addr,e)}function dx(i,t){const e=Ur(t,this.size,3);i.uniform3fv(this.addr,e)}function px(i,t){const e=Ur(t,this.size,4);i.uniform4fv(this.addr,e)}function gx(i,t){const e=Ur(t,this.size,4);i.uniformMatrix2fv(this.addr,!1,e)}function mx(i,t){const e=Ur(t,this.size,9);i.uniformMatrix3fv(this.addr,!1,e)}function _x(i,t){const e=Ur(t,this.size,16);i.uniformMatrix4fv(this.addr,!1,e)}function xx(i,t){i.uniform1iv(this.addr,t)}function vx(i,t){i.uniform2iv(this.addr,t)}function yx(i,t){i.uniform3iv(this.addr,t)}function Sx(i,t){i.uniform4iv(this.addr,t)}function Mx(i,t){i.uniform1uiv(this.addr,t)}function Ex(i,t){i.uniform2uiv(this.addr,t)}function Tx(i,t){i.uniform3uiv(this.addr,t)}function bx(i,t){i.uniform4uiv(this.addr,t)}function Ax(i,t,e){const n=this.cache,r=t.length,s=Yo(e,r);Se(n,s)||(i.uniform1iv(this.addr,s),Me(n,s));for(let a=0;a!==r;++a)e.setTexture2D(t[a]||Rf,s[a])}function wx(i,t,e){const n=this.cache,r=t.length,s=Yo(e,r);Se(n,s)||(i.uniform1iv(this.addr,s),Me(n,s));for(let a=0;a!==r;++a)e.setTexture3D(t[a]||Pf,s[a])}function Rx(i,t,e){const n=this.cache,r=t.length,s=Yo(e,r);Se(n,s)||(i.uniform1iv(this.addr,s),Me(n,s));for(let a=0;a!==r;++a)e.setTextureCube(t[a]||If,s[a])}function Cx(i,t,e){const n=this.cache,r=t.length,s=Yo(e,r);Se(n,s)||(i.uniform1iv(this.addr,s),Me(n,s));for(let a=0;a!==r;++a)e.setTexture2DArray(t[a]||Cf,s[a])}function Px(i){switch(i){case 5126:return hx;case 35664:return fx;case 35665:return dx;case 35666:return px;case 35674:return gx;case 35675:return mx;case 35676:return _x;case 5124:case 35670:return xx;case 35667:case 35671:return vx;case 35668:case 35672:return yx;case 35669:case 35673:return Sx;case 5125:return Mx;case 36294:return Ex;case 36295:return Tx;case 36296:return bx;case 35678:case 36198:case 36298:case 36306:case 35682:return Ax;case 35679:case 36299:case 36307:return wx;case 35680:case 36300:case 36308:case 36293:return Rx;case 36289:case 36303:case 36311:case 36292:return Cx}}class Ix{constructor(t,e,n){this.id=t,this.addr=n,this.cache=[],this.type=e.type,this.setValue=ux(e.type)}}class Lx{constructor(t,e,n){this.id=t,this.addr=n,this.cache=[],this.type=e.type,this.size=e.size,this.setValue=Px(e.type)}}class Dx{constructor(t){this.id=t,this.seq=[],this.map={}}setValue(t,e,n){const r=this.seq;for(let s=0,a=r.length;s!==a;++s){const o=r[s];o.setValue(t,e[o.id],n)}}}const Na=/(\w+)(\])?(\[|\.)?/g;function Wu(i,t){i.seq.push(t),i.map[t.id]=t}function Ux(i,t,e){const n=i.name,r=n.length;for(Na.lastIndex=0;;){const s=Na.exec(n),a=Na.lastIndex;let o=s[1];const c=s[2]==="]",h=s[3];if(c&&(o=o|0),h===void 0||h==="["&&a+2===r){Wu(e,h===void 0?new Ix(o,i,t):new Lx(o,i,t));break}else{let g=e.map[o];g===void 0&&(g=new Dx(o),Wu(e,g)),e=g}}}class Ao{constructor(t,e){this.seq=[],this.map={};const n=t.getProgramParameter(e,t.ACTIVE_UNIFORMS);for(let r=0;r<n;++r){const s=t.getActiveUniform(e,r),a=t.getUniformLocation(e,s.name);Ux(s,a,this)}}setValue(t,e,n,r){const s=this.map[e];s!==void 0&&s.setValue(t,n,r)}setOptional(t,e,n){const r=e[n];r!==void 0&&this.setValue(t,n,r)}static upload(t,e,n,r){for(let s=0,a=e.length;s!==a;++s){const o=e[s],c=n[o.id];c.needsUpdate!==!1&&o.setValue(t,c.value,r)}}static seqWithValue(t,e){const n=[];for(let r=0,s=t.length;r!==s;++r){const a=t[r];a.id in e&&n.push(a)}return n}}function Xu(i,t,e){const n=i.createShader(t);return i.shaderSource(n,e),i.compileShader(n),n}const Nx=37297;let Fx=0;function Bx(i,t){const e=i.split(`
`),n=[],r=Math.max(t-6,0),s=Math.min(t+6,e.length);for(let a=r;a<s;a++){const o=a+1;n.push(`${o===t?">":" "} ${o}: ${e[a]}`)}return n.join(`
`)}const qu=new Gt;function Ox(i){Jt._getMatrix(qu,Jt.workingColorSpace,i);const t=`mat3( ${qu.elements.map(e=>e.toFixed(4))} )`;switch(Jt.getTransfer(i)){case Fo:return[t,"LinearTransferOETF"];case re:return[t,"sRGBTransferOETF"];default:return console.warn("THREE.WebGLProgram: Unsupported color space: ",i),[t,"LinearTransferOETF"]}}function Yu(i,t,e){const n=i.getShaderParameter(t,i.COMPILE_STATUS),r=i.getShaderInfoLog(t).trim();if(n&&r==="")return"";const s=/ERROR: 0:(\d+)/.exec(r);if(s){const a=parseInt(s[1]);return e.toUpperCase()+`

`+r+`

`+Bx(i.getShaderSource(t),a)}else return r}function zx(i,t){const e=Ox(t);return[`vec4 ${i}( vec4 value ) {`,`	return ${e[1]}( vec4( value.rgb * ${e[0]}, value.a ) );`,"}"].join(`
`)}function Vx(i,t){let e;switch(t){case Dd:e="Linear";break;case Ud:e="Reinhard";break;case Nd:e="Cineon";break;case Fd:e="ACESFilmic";break;case Od:e="AgX";break;case zd:e="Neutral";break;case Bd:e="Custom";break;default:console.warn("THREE.WebGLProgram: Unsupported toneMapping:",t),e="Linear"}return"vec3 "+i+"( vec3 color ) { return "+e+"ToneMapping( color ); }"}const Ks=new U;function Hx(){Jt.getLuminanceCoefficients(Ks);const i=Ks.x.toFixed(4),t=Ks.y.toFixed(4),e=Ks.z.toFixed(4);return["float luminance( const in vec3 rgb ) {",`	const vec3 weights = vec3( ${i}, ${t}, ${e} );`,"	return dot( weights, rgb );","}"].join(`
`)}function Gx(i){return[i.extensionClipCullDistance?"#extension GL_ANGLE_clip_cull_distance : require":"",i.extensionMultiDraw?"#extension GL_ANGLE_multi_draw : require":""].filter(Qr).join(`
`)}function kx(i){const t=[];for(const e in i){const n=i[e];n!==!1&&t.push("#define "+e+" "+n)}return t.join(`
`)}function Wx(i,t){const e={},n=i.getProgramParameter(t,i.ACTIVE_ATTRIBUTES);for(let r=0;r<n;r++){const s=i.getActiveAttrib(t,r),a=s.name;let o=1;s.type===i.FLOAT_MAT2&&(o=2),s.type===i.FLOAT_MAT3&&(o=3),s.type===i.FLOAT_MAT4&&(o=4),e[a]={type:s.type,location:i.getAttribLocation(t,a),locationSize:o}}return e}function Qr(i){return i!==""}function $u(i,t){const e=t.numSpotLightShadows+t.numSpotLightMaps-t.numSpotLightShadowsWithMaps;return i.replace(/NUM_DIR_LIGHTS/g,t.numDirLights).replace(/NUM_SPOT_LIGHTS/g,t.numSpotLights).replace(/NUM_SPOT_LIGHT_MAPS/g,t.numSpotLightMaps).replace(/NUM_SPOT_LIGHT_COORDS/g,e).replace(/NUM_RECT_AREA_LIGHTS/g,t.numRectAreaLights).replace(/NUM_POINT_LIGHTS/g,t.numPointLights).replace(/NUM_HEMI_LIGHTS/g,t.numHemiLights).replace(/NUM_DIR_LIGHT_SHADOWS/g,t.numDirLightShadows).replace(/NUM_SPOT_LIGHT_SHADOWS_WITH_MAPS/g,t.numSpotLightShadowsWithMaps).replace(/NUM_SPOT_LIGHT_SHADOWS/g,t.numSpotLightShadows).replace(/NUM_POINT_LIGHT_SHADOWS/g,t.numPointLightShadows)}function ju(i,t){return i.replace(/NUM_CLIPPING_PLANES/g,t.numClippingPlanes).replace(/UNION_CLIPPING_PLANES/g,t.numClippingPlanes-t.numClipIntersection)}const Xx=/^[ \t]*#include +<([\w\d./]+)>/gm;function ul(i){return i.replace(Xx,Yx)}const qx=new Map;function Yx(i,t){let e=Wt[t];if(e===void 0){const n=qx.get(t);if(n!==void 0)e=Wt[n],console.warn('THREE.WebGLRenderer: Shader chunk "%s" has been deprecated. Use "%s" instead.',t,n);else throw new Error("Can not resolve #include <"+t+">")}return ul(e)}const $x=/#pragma unroll_loop_start\s+for\s*\(\s*int\s+i\s*=\s*(\d+)\s*;\s*i\s*<\s*(\d+)\s*;\s*i\s*\+\+\s*\)\s*{([\s\S]+?)}\s+#pragma unroll_loop_end/g;function Ku(i){return i.replace($x,jx)}function jx(i,t,e,n){let r="";for(let s=parseInt(t);s<parseInt(e);s++)r+=n.replace(/\[\s*i\s*\]/g,"[ "+s+" ]").replace(/UNROLLED_LOOP_INDEX/g,s);return r}function Zu(i){let t=`precision ${i.precision} float;
	precision ${i.precision} int;
	precision ${i.precision} sampler2D;
	precision ${i.precision} samplerCube;
	precision ${i.precision} sampler3D;
	precision ${i.precision} sampler2DArray;
	precision ${i.precision} sampler2DShadow;
	precision ${i.precision} samplerCubeShadow;
	precision ${i.precision} sampler2DArrayShadow;
	precision ${i.precision} isampler2D;
	precision ${i.precision} isampler3D;
	precision ${i.precision} isamplerCube;
	precision ${i.precision} isampler2DArray;
	precision ${i.precision} usampler2D;
	precision ${i.precision} usampler3D;
	precision ${i.precision} usamplerCube;
	precision ${i.precision} usampler2DArray;
	`;return i.precision==="highp"?t+=`
#define HIGH_PRECISION`:i.precision==="mediump"?t+=`
#define MEDIUM_PRECISION`:i.precision==="lowp"&&(t+=`
#define LOW_PRECISION`),t}function Kx(i){let t="SHADOWMAP_TYPE_BASIC";return i.shadowMapType===Jh?t="SHADOWMAP_TYPE_PCF":i.shadowMapType===fd?t="SHADOWMAP_TYPE_PCF_SOFT":i.shadowMapType===kn&&(t="SHADOWMAP_TYPE_VSM"),t}function Zx(i){let t="ENVMAP_TYPE_CUBE";if(i.envMap)switch(i.envMapMode){case Ar:case wr:t="ENVMAP_TYPE_CUBE";break;case Xo:t="ENVMAP_TYPE_CUBE_UV";break}return t}function Jx(i){let t="ENVMAP_MODE_REFLECTION";if(i.envMap)switch(i.envMapMode){case wr:t="ENVMAP_MODE_REFRACTION";break}return t}function Qx(i){let t="ENVMAP_BLENDING_NONE";if(i.envMap)switch(i.combine){case Qh:t="ENVMAP_BLENDING_MULTIPLY";break;case Id:t="ENVMAP_BLENDING_MIX";break;case Ld:t="ENVMAP_BLENDING_ADD";break}return t}function tv(i){const t=i.envMapCubeUVHeight;if(t===null)return null;const e=Math.log2(t)-2,n=1/t;return{texelWidth:1/(3*Math.max(Math.pow(2,e),7*16)),texelHeight:n,maxMip:e}}function ev(i,t,e,n){const r=i.getContext(),s=e.defines;let a=e.vertexShader,o=e.fragmentShader;const c=Kx(e),h=Zx(e),f=Jx(e),g=Qx(e),p=tv(e),_=Gx(e),M=kx(s),b=r.createProgram();let x,m,d=e.glslVersion?"#version "+e.glslVersion+`
`:"";e.isRawShaderMaterial?(x=["#define SHADER_TYPE "+e.shaderType,"#define SHADER_NAME "+e.shaderName,M].filter(Qr).join(`
`),x.length>0&&(x+=`
`),m=["#define SHADER_TYPE "+e.shaderType,"#define SHADER_NAME "+e.shaderName,M].filter(Qr).join(`
`),m.length>0&&(m+=`
`)):(x=[Zu(e),"#define SHADER_TYPE "+e.shaderType,"#define SHADER_NAME "+e.shaderName,M,e.extensionClipCullDistance?"#define USE_CLIP_DISTANCE":"",e.batching?"#define USE_BATCHING":"",e.batchingColor?"#define USE_BATCHING_COLOR":"",e.instancing?"#define USE_INSTANCING":"",e.instancingColor?"#define USE_INSTANCING_COLOR":"",e.instancingMorph?"#define USE_INSTANCING_MORPH":"",e.useFog&&e.fog?"#define USE_FOG":"",e.useFog&&e.fogExp2?"#define FOG_EXP2":"",e.map?"#define USE_MAP":"",e.envMap?"#define USE_ENVMAP":"",e.envMap?"#define "+f:"",e.lightMap?"#define USE_LIGHTMAP":"",e.aoMap?"#define USE_AOMAP":"",e.bumpMap?"#define USE_BUMPMAP":"",e.normalMap?"#define USE_NORMALMAP":"",e.normalMapObjectSpace?"#define USE_NORMALMAP_OBJECTSPACE":"",e.normalMapTangentSpace?"#define USE_NORMALMAP_TANGENTSPACE":"",e.displacementMap?"#define USE_DISPLACEMENTMAP":"",e.emissiveMap?"#define USE_EMISSIVEMAP":"",e.anisotropy?"#define USE_ANISOTROPY":"",e.anisotropyMap?"#define USE_ANISOTROPYMAP":"",e.clearcoatMap?"#define USE_CLEARCOATMAP":"",e.clearcoatRoughnessMap?"#define USE_CLEARCOAT_ROUGHNESSMAP":"",e.clearcoatNormalMap?"#define USE_CLEARCOAT_NORMALMAP":"",e.iridescenceMap?"#define USE_IRIDESCENCEMAP":"",e.iridescenceThicknessMap?"#define USE_IRIDESCENCE_THICKNESSMAP":"",e.specularMap?"#define USE_SPECULARMAP":"",e.specularColorMap?"#define USE_SPECULAR_COLORMAP":"",e.specularIntensityMap?"#define USE_SPECULAR_INTENSITYMAP":"",e.roughnessMap?"#define USE_ROUGHNESSMAP":"",e.metalnessMap?"#define USE_METALNESSMAP":"",e.alphaMap?"#define USE_ALPHAMAP":"",e.alphaHash?"#define USE_ALPHAHASH":"",e.transmission?"#define USE_TRANSMISSION":"",e.transmissionMap?"#define USE_TRANSMISSIONMAP":"",e.thicknessMap?"#define USE_THICKNESSMAP":"",e.sheenColorMap?"#define USE_SHEEN_COLORMAP":"",e.sheenRoughnessMap?"#define USE_SHEEN_ROUGHNESSMAP":"",e.mapUv?"#define MAP_UV "+e.mapUv:"",e.alphaMapUv?"#define ALPHAMAP_UV "+e.alphaMapUv:"",e.lightMapUv?"#define LIGHTMAP_UV "+e.lightMapUv:"",e.aoMapUv?"#define AOMAP_UV "+e.aoMapUv:"",e.emissiveMapUv?"#define EMISSIVEMAP_UV "+e.emissiveMapUv:"",e.bumpMapUv?"#define BUMPMAP_UV "+e.bumpMapUv:"",e.normalMapUv?"#define NORMALMAP_UV "+e.normalMapUv:"",e.displacementMapUv?"#define DISPLACEMENTMAP_UV "+e.displacementMapUv:"",e.metalnessMapUv?"#define METALNESSMAP_UV "+e.metalnessMapUv:"",e.roughnessMapUv?"#define ROUGHNESSMAP_UV "+e.roughnessMapUv:"",e.anisotropyMapUv?"#define ANISOTROPYMAP_UV "+e.anisotropyMapUv:"",e.clearcoatMapUv?"#define CLEARCOATMAP_UV "+e.clearcoatMapUv:"",e.clearcoatNormalMapUv?"#define CLEARCOAT_NORMALMAP_UV "+e.clearcoatNormalMapUv:"",e.clearcoatRoughnessMapUv?"#define CLEARCOAT_ROUGHNESSMAP_UV "+e.clearcoatRoughnessMapUv:"",e.iridescenceMapUv?"#define IRIDESCENCEMAP_UV "+e.iridescenceMapUv:"",e.iridescenceThicknessMapUv?"#define IRIDESCENCE_THICKNESSMAP_UV "+e.iridescenceThicknessMapUv:"",e.sheenColorMapUv?"#define SHEEN_COLORMAP_UV "+e.sheenColorMapUv:"",e.sheenRoughnessMapUv?"#define SHEEN_ROUGHNESSMAP_UV "+e.sheenRoughnessMapUv:"",e.specularMapUv?"#define SPECULARMAP_UV "+e.specularMapUv:"",e.specularColorMapUv?"#define SPECULAR_COLORMAP_UV "+e.specularColorMapUv:"",e.specularIntensityMapUv?"#define SPECULAR_INTENSITYMAP_UV "+e.specularIntensityMapUv:"",e.transmissionMapUv?"#define TRANSMISSIONMAP_UV "+e.transmissionMapUv:"",e.thicknessMapUv?"#define THICKNESSMAP_UV "+e.thicknessMapUv:"",e.vertexTangents&&e.flatShading===!1?"#define USE_TANGENT":"",e.vertexColors?"#define USE_COLOR":"",e.vertexAlphas?"#define USE_COLOR_ALPHA":"",e.vertexUv1s?"#define USE_UV1":"",e.vertexUv2s?"#define USE_UV2":"",e.vertexUv3s?"#define USE_UV3":"",e.pointsUvs?"#define USE_POINTS_UV":"",e.flatShading?"#define FLAT_SHADED":"",e.skinning?"#define USE_SKINNING":"",e.morphTargets?"#define USE_MORPHTARGETS":"",e.morphNormals&&e.flatShading===!1?"#define USE_MORPHNORMALS":"",e.morphColors?"#define USE_MORPHCOLORS":"",e.morphTargetsCount>0?"#define MORPHTARGETS_TEXTURE_STRIDE "+e.morphTextureStride:"",e.morphTargetsCount>0?"#define MORPHTARGETS_COUNT "+e.morphTargetsCount:"",e.doubleSided?"#define DOUBLE_SIDED":"",e.flipSided?"#define FLIP_SIDED":"",e.shadowMapEnabled?"#define USE_SHADOWMAP":"",e.shadowMapEnabled?"#define "+c:"",e.sizeAttenuation?"#define USE_SIZEATTENUATION":"",e.numLightProbes>0?"#define USE_LIGHT_PROBES":"",e.logarithmicDepthBuffer?"#define USE_LOGDEPTHBUF":"",e.reverseDepthBuffer?"#define USE_REVERSEDEPTHBUF":"","uniform mat4 modelMatrix;","uniform mat4 modelViewMatrix;","uniform mat4 projectionMatrix;","uniform mat4 viewMatrix;","uniform mat3 normalMatrix;","uniform vec3 cameraPosition;","uniform bool isOrthographic;","#ifdef USE_INSTANCING","	attribute mat4 instanceMatrix;","#endif","#ifdef USE_INSTANCING_COLOR","	attribute vec3 instanceColor;","#endif","#ifdef USE_INSTANCING_MORPH","	uniform sampler2D morphTexture;","#endif","attribute vec3 position;","attribute vec3 normal;","attribute vec2 uv;","#ifdef USE_UV1","	attribute vec2 uv1;","#endif","#ifdef USE_UV2","	attribute vec2 uv2;","#endif","#ifdef USE_UV3","	attribute vec2 uv3;","#endif","#ifdef USE_TANGENT","	attribute vec4 tangent;","#endif","#if defined( USE_COLOR_ALPHA )","	attribute vec4 color;","#elif defined( USE_COLOR )","	attribute vec3 color;","#endif","#ifdef USE_SKINNING","	attribute vec4 skinIndex;","	attribute vec4 skinWeight;","#endif",`
`].filter(Qr).join(`
`),m=[Zu(e),"#define SHADER_TYPE "+e.shaderType,"#define SHADER_NAME "+e.shaderName,M,e.useFog&&e.fog?"#define USE_FOG":"",e.useFog&&e.fogExp2?"#define FOG_EXP2":"",e.alphaToCoverage?"#define ALPHA_TO_COVERAGE":"",e.map?"#define USE_MAP":"",e.matcap?"#define USE_MATCAP":"",e.envMap?"#define USE_ENVMAP":"",e.envMap?"#define "+h:"",e.envMap?"#define "+f:"",e.envMap?"#define "+g:"",p?"#define CUBEUV_TEXEL_WIDTH "+p.texelWidth:"",p?"#define CUBEUV_TEXEL_HEIGHT "+p.texelHeight:"",p?"#define CUBEUV_MAX_MIP "+p.maxMip+".0":"",e.lightMap?"#define USE_LIGHTMAP":"",e.aoMap?"#define USE_AOMAP":"",e.bumpMap?"#define USE_BUMPMAP":"",e.normalMap?"#define USE_NORMALMAP":"",e.normalMapObjectSpace?"#define USE_NORMALMAP_OBJECTSPACE":"",e.normalMapTangentSpace?"#define USE_NORMALMAP_TANGENTSPACE":"",e.emissiveMap?"#define USE_EMISSIVEMAP":"",e.anisotropy?"#define USE_ANISOTROPY":"",e.anisotropyMap?"#define USE_ANISOTROPYMAP":"",e.clearcoat?"#define USE_CLEARCOAT":"",e.clearcoatMap?"#define USE_CLEARCOATMAP":"",e.clearcoatRoughnessMap?"#define USE_CLEARCOAT_ROUGHNESSMAP":"",e.clearcoatNormalMap?"#define USE_CLEARCOAT_NORMALMAP":"",e.dispersion?"#define USE_DISPERSION":"",e.iridescence?"#define USE_IRIDESCENCE":"",e.iridescenceMap?"#define USE_IRIDESCENCEMAP":"",e.iridescenceThicknessMap?"#define USE_IRIDESCENCE_THICKNESSMAP":"",e.specularMap?"#define USE_SPECULARMAP":"",e.specularColorMap?"#define USE_SPECULAR_COLORMAP":"",e.specularIntensityMap?"#define USE_SPECULAR_INTENSITYMAP":"",e.roughnessMap?"#define USE_ROUGHNESSMAP":"",e.metalnessMap?"#define USE_METALNESSMAP":"",e.alphaMap?"#define USE_ALPHAMAP":"",e.alphaTest?"#define USE_ALPHATEST":"",e.alphaHash?"#define USE_ALPHAHASH":"",e.sheen?"#define USE_SHEEN":"",e.sheenColorMap?"#define USE_SHEEN_COLORMAP":"",e.sheenRoughnessMap?"#define USE_SHEEN_ROUGHNESSMAP":"",e.transmission?"#define USE_TRANSMISSION":"",e.transmissionMap?"#define USE_TRANSMISSIONMAP":"",e.thicknessMap?"#define USE_THICKNESSMAP":"",e.vertexTangents&&e.flatShading===!1?"#define USE_TANGENT":"",e.vertexColors||e.instancingColor||e.batchingColor?"#define USE_COLOR":"",e.vertexAlphas?"#define USE_COLOR_ALPHA":"",e.vertexUv1s?"#define USE_UV1":"",e.vertexUv2s?"#define USE_UV2":"",e.vertexUv3s?"#define USE_UV3":"",e.pointsUvs?"#define USE_POINTS_UV":"",e.gradientMap?"#define USE_GRADIENTMAP":"",e.flatShading?"#define FLAT_SHADED":"",e.doubleSided?"#define DOUBLE_SIDED":"",e.flipSided?"#define FLIP_SIDED":"",e.shadowMapEnabled?"#define USE_SHADOWMAP":"",e.shadowMapEnabled?"#define "+c:"",e.premultipliedAlpha?"#define PREMULTIPLIED_ALPHA":"",e.numLightProbes>0?"#define USE_LIGHT_PROBES":"",e.decodeVideoTexture?"#define DECODE_VIDEO_TEXTURE":"",e.decodeVideoTextureEmissive?"#define DECODE_VIDEO_TEXTURE_EMISSIVE":"",e.logarithmicDepthBuffer?"#define USE_LOGDEPTHBUF":"",e.reverseDepthBuffer?"#define USE_REVERSEDEPTHBUF":"","uniform mat4 viewMatrix;","uniform vec3 cameraPosition;","uniform bool isOrthographic;",e.toneMapping!==ui?"#define TONE_MAPPING":"",e.toneMapping!==ui?Wt.tonemapping_pars_fragment:"",e.toneMapping!==ui?Vx("toneMapping",e.toneMapping):"",e.dithering?"#define DITHERING":"",e.opaque?"#define OPAQUE":"",Wt.colorspace_pars_fragment,zx("linearToOutputTexel",e.outputColorSpace),Hx(),e.useDepthPacking?"#define DEPTH_PACKING "+e.depthPacking:"",`
`].filter(Qr).join(`
`)),a=ul(a),a=$u(a,e),a=ju(a,e),o=ul(o),o=$u(o,e),o=ju(o,e),a=Ku(a),o=Ku(o),e.isRawShaderMaterial!==!0&&(d=`#version 300 es
`,x=[_,"#define attribute in","#define varying out","#define texture2D texture"].join(`
`)+`
`+x,m=["#define varying in",e.glslVersion===eu?"":"layout(location = 0) out highp vec4 pc_fragColor;",e.glslVersion===eu?"":"#define gl_FragColor pc_fragColor","#define gl_FragDepthEXT gl_FragDepth","#define texture2D texture","#define textureCube texture","#define texture2DProj textureProj","#define texture2DLodEXT textureLod","#define texture2DProjLodEXT textureProjLod","#define textureCubeLodEXT textureLod","#define texture2DGradEXT textureGrad","#define texture2DProjGradEXT textureProjGrad","#define textureCubeGradEXT textureGrad"].join(`
`)+`
`+m);const u=d+x+a,v=d+m+o,l=Xu(r,r.VERTEX_SHADER,u),R=Xu(r,r.FRAGMENT_SHADER,v);r.attachShader(b,l),r.attachShader(b,R),e.index0AttributeName!==void 0?r.bindAttribLocation(b,0,e.index0AttributeName):e.morphTargets===!0&&r.bindAttribLocation(b,0,"position"),r.linkProgram(b);function T(A){if(i.debug.checkShaderErrors){const w=r.getProgramInfoLog(b).trim(),I=r.getShaderInfoLog(l).trim(),N=r.getShaderInfoLog(R).trim();let B=!0,F=!0;if(r.getProgramParameter(b,r.LINK_STATUS)===!1)if(B=!1,typeof i.debug.onShaderError=="function")i.debug.onShaderError(r,b,l,R);else{const k=Yu(r,l,"vertex"),z=Yu(r,R,"fragment");console.error("THREE.WebGLProgram: Shader Error "+r.getError()+" - VALIDATE_STATUS "+r.getProgramParameter(b,r.VALIDATE_STATUS)+`

Material Name: `+A.name+`
Material Type: `+A.type+`

Program Info Log: `+w+`
`+k+`
`+z)}else w!==""?console.warn("THREE.WebGLProgram: Program Info Log:",w):(I===""||N==="")&&(F=!1);F&&(A.diagnostics={runnable:B,programLog:w,vertexShader:{log:I,prefix:x},fragmentShader:{log:N,prefix:m}})}r.deleteShader(l),r.deleteShader(R),E=new Ao(r,b),y=Wx(r,b)}let E;this.getUniforms=function(){return E===void 0&&T(this),E};let y;this.getAttributes=function(){return y===void 0&&T(this),y};let S=e.rendererExtensionParallelShaderCompile===!1;return this.isReady=function(){return S===!1&&(S=r.getProgramParameter(b,Nx)),S},this.destroy=function(){n.releaseStatesOfProgram(this),r.deleteProgram(b),this.program=void 0},this.type=e.shaderType,this.name=e.shaderName,this.id=Fx++,this.cacheKey=t,this.usedTimes=1,this.program=b,this.vertexShader=l,this.fragmentShader=R,this}let nv=0;class iv{constructor(){this.shaderCache=new Map,this.materialCache=new Map}update(t){const e=t.vertexShader,n=t.fragmentShader,r=this._getShaderStage(e),s=this._getShaderStage(n),a=this._getShaderCacheForMaterial(t);return a.has(r)===!1&&(a.add(r),r.usedTimes++),a.has(s)===!1&&(a.add(s),s.usedTimes++),this}remove(t){const e=this.materialCache.get(t);for(const n of e)n.usedTimes--,n.usedTimes===0&&this.shaderCache.delete(n.code);return this.materialCache.delete(t),this}getVertexShaderID(t){return this._getShaderStage(t.vertexShader).id}getFragmentShaderID(t){return this._getShaderStage(t.fragmentShader).id}dispose(){this.shaderCache.clear(),this.materialCache.clear()}_getShaderCacheForMaterial(t){const e=this.materialCache;let n=e.get(t);return n===void 0&&(n=new Set,e.set(t,n)),n}_getShaderStage(t){const e=this.shaderCache;let n=e.get(t);return n===void 0&&(n=new rv(t),e.set(t,n)),n}}class rv{constructor(t){this.id=nv++,this.code=t,this.usedTimes=0}}function sv(i,t,e,n,r,s,a){const o=new Cl,c=new iv,h=new Set,f=[],g=r.logarithmicDepthBuffer,p=r.vertexTextures;let _=r.precision;const M={MeshDepthMaterial:"depth",MeshDistanceMaterial:"distanceRGBA",MeshNormalMaterial:"normal",MeshBasicMaterial:"basic",MeshLambertMaterial:"lambert",MeshPhongMaterial:"phong",MeshToonMaterial:"toon",MeshStandardMaterial:"physical",MeshPhysicalMaterial:"physical",MeshMatcapMaterial:"matcap",LineBasicMaterial:"basic",LineDashedMaterial:"dashed",PointsMaterial:"points",ShadowMaterial:"shadow",SpriteMaterial:"sprite"};function b(y){return h.add(y),y===0?"uv":`uv${y}`}function x(y,S,A,w,I){const N=w.fog,B=I.geometry,F=y.isMeshStandardMaterial?w.environment:null,k=(y.isMeshStandardMaterial?e:t).get(y.envMap||F),z=k&&k.mapping===Xo?k.image.height:null,J=M[y.type];y.precision!==null&&(_=r.getMaxPrecision(y.precision),_!==y.precision&&console.warn("THREE.WebGLProgram.getParameters:",y.precision,"not supported, using",_,"instead."));const Z=B.morphAttributes.position||B.morphAttributes.normal||B.morphAttributes.color,it=Z!==void 0?Z.length:0;let pt=0;B.morphAttributes.position!==void 0&&(pt=1),B.morphAttributes.normal!==void 0&&(pt=2),B.morphAttributes.color!==void 0&&(pt=3);let _t,W,tt,st;if(J){const ee=Tn[J];_t=ee.vertexShader,W=ee.fragmentShader}else _t=y.vertexShader,W=y.fragmentShader,c.update(y),tt=c.getVertexShaderID(y),st=c.getFragmentShaderID(y);const Q=i.getRenderTarget(),at=i.state.buffers.depth.getReversed(),xt=I.isInstancedMesh===!0,lt=I.isBatchedMesh===!0,jt=!!y.map,Lt=!!y.matcap,Mt=!!k,D=!!y.aoMap,Ft=!!y.lightMap,Et=!!y.bumpMap,Zt=!!y.normalMap,ct=!!y.displacementMap,Rt=!!y.emissiveMap,ut=!!y.metalnessMap,vt=!!y.roughnessMap,zt=y.anisotropy>0,L=y.clearcoat>0,C=y.dispersion>0,V=y.iridescence>0,$=y.sheen>0,j=y.transmission>0,X=zt&&!!y.anisotropyMap,Ct=L&&!!y.clearcoatMap,ht=L&&!!y.clearcoatNormalMap,bt=L&&!!y.clearcoatRoughnessMap,Pt=V&&!!y.iridescenceMap,et=V&&!!y.iridescenceThicknessMap,yt=$&&!!y.sheenColorMap,Nt=$&&!!y.sheenRoughnessMap,Ut=!!y.specularMap,ft=!!y.specularColorMap,Vt=!!y.specularIntensityMap,O=j&&!!y.transmissionMap,gt=j&&!!y.thicknessMap,nt=!!y.gradientMap,Tt=!!y.alphaMap,rt=y.alphaTest>0,K=!!y.alphaHash,At=!!y.extensions;let Ht=ui;y.toneMapped&&(Q===null||Q.isXRRenderTarget===!0)&&(Ht=i.toneMapping);const oe={shaderID:J,shaderType:y.type,shaderName:y.name,vertexShader:_t,fragmentShader:W,defines:y.defines,customVertexShaderID:tt,customFragmentShaderID:st,isRawShaderMaterial:y.isRawShaderMaterial===!0,glslVersion:y.glslVersion,precision:_,batching:lt,batchingColor:lt&&I._colorsTexture!==null,instancing:xt,instancingColor:xt&&I.instanceColor!==null,instancingMorph:xt&&I.morphTexture!==null,supportsVertexTextures:p,outputColorSpace:Q===null?i.outputColorSpace:Q.isXRRenderTarget===!0?Q.texture.colorSpace:Rr,alphaToCoverage:!!y.alphaToCoverage,map:jt,matcap:Lt,envMap:Mt,envMapMode:Mt&&k.mapping,envMapCubeUVHeight:z,aoMap:D,lightMap:Ft,bumpMap:Et,normalMap:Zt,displacementMap:p&&ct,emissiveMap:Rt,normalMapObjectSpace:Zt&&y.normalMapType===kd,normalMapTangentSpace:Zt&&y.normalMapType===uf,metalnessMap:ut,roughnessMap:vt,anisotropy:zt,anisotropyMap:X,clearcoat:L,clearcoatMap:Ct,clearcoatNormalMap:ht,clearcoatRoughnessMap:bt,dispersion:C,iridescence:V,iridescenceMap:Pt,iridescenceThicknessMap:et,sheen:$,sheenColorMap:yt,sheenRoughnessMap:Nt,specularMap:Ut,specularColorMap:ft,specularIntensityMap:Vt,transmission:j,transmissionMap:O,thicknessMap:gt,gradientMap:nt,opaque:y.transparent===!1&&y.blending===yr&&y.alphaToCoverage===!1,alphaMap:Tt,alphaTest:rt,alphaHash:K,combine:y.combine,mapUv:jt&&b(y.map.channel),aoMapUv:D&&b(y.aoMap.channel),lightMapUv:Ft&&b(y.lightMap.channel),bumpMapUv:Et&&b(y.bumpMap.channel),normalMapUv:Zt&&b(y.normalMap.channel),displacementMapUv:ct&&b(y.displacementMap.channel),emissiveMapUv:Rt&&b(y.emissiveMap.channel),metalnessMapUv:ut&&b(y.metalnessMap.channel),roughnessMapUv:vt&&b(y.roughnessMap.channel),anisotropyMapUv:X&&b(y.anisotropyMap.channel),clearcoatMapUv:Ct&&b(y.clearcoatMap.channel),clearcoatNormalMapUv:ht&&b(y.clearcoatNormalMap.channel),clearcoatRoughnessMapUv:bt&&b(y.clearcoatRoughnessMap.channel),iridescenceMapUv:Pt&&b(y.iridescenceMap.channel),iridescenceThicknessMapUv:et&&b(y.iridescenceThicknessMap.channel),sheenColorMapUv:yt&&b(y.sheenColorMap.channel),sheenRoughnessMapUv:Nt&&b(y.sheenRoughnessMap.channel),specularMapUv:Ut&&b(y.specularMap.channel),specularColorMapUv:ft&&b(y.specularColorMap.channel),specularIntensityMapUv:Vt&&b(y.specularIntensityMap.channel),transmissionMapUv:O&&b(y.transmissionMap.channel),thicknessMapUv:gt&&b(y.thicknessMap.channel),alphaMapUv:Tt&&b(y.alphaMap.channel),vertexTangents:!!B.attributes.tangent&&(Zt||zt),vertexColors:y.vertexColors,vertexAlphas:y.vertexColors===!0&&!!B.attributes.color&&B.attributes.color.itemSize===4,pointsUvs:I.isPoints===!0&&!!B.attributes.uv&&(jt||Tt),fog:!!N,useFog:y.fog===!0,fogExp2:!!N&&N.isFogExp2,flatShading:y.flatShading===!0,sizeAttenuation:y.sizeAttenuation===!0,logarithmicDepthBuffer:g,reverseDepthBuffer:at,skinning:I.isSkinnedMesh===!0,morphTargets:B.morphAttributes.position!==void 0,morphNormals:B.morphAttributes.normal!==void 0,morphColors:B.morphAttributes.color!==void 0,morphTargetsCount:it,morphTextureStride:pt,numDirLights:S.directional.length,numPointLights:S.point.length,numSpotLights:S.spot.length,numSpotLightMaps:S.spotLightMap.length,numRectAreaLights:S.rectArea.length,numHemiLights:S.hemi.length,numDirLightShadows:S.directionalShadowMap.length,numPointLightShadows:S.pointShadowMap.length,numSpotLightShadows:S.spotShadowMap.length,numSpotLightShadowsWithMaps:S.numSpotLightShadowsWithMaps,numLightProbes:S.numLightProbes,numClippingPlanes:a.numPlanes,numClipIntersection:a.numIntersection,dithering:y.dithering,shadowMapEnabled:i.shadowMap.enabled&&A.length>0,shadowMapType:i.shadowMap.type,toneMapping:Ht,decodeVideoTexture:jt&&y.map.isVideoTexture===!0&&Jt.getTransfer(y.map.colorSpace)===re,decodeVideoTextureEmissive:Rt&&y.emissiveMap.isVideoTexture===!0&&Jt.getTransfer(y.emissiveMap.colorSpace)===re,premultipliedAlpha:y.premultipliedAlpha,doubleSided:y.side===Be,flipSided:y.side===ze,useDepthPacking:y.depthPacking>=0,depthPacking:y.depthPacking||0,index0AttributeName:y.index0AttributeName,extensionClipCullDistance:At&&y.extensions.clipCullDistance===!0&&n.has("WEBGL_clip_cull_distance"),extensionMultiDraw:(At&&y.extensions.multiDraw===!0||lt)&&n.has("WEBGL_multi_draw"),rendererExtensionParallelShaderCompile:n.has("KHR_parallel_shader_compile"),customProgramCacheKey:y.customProgramCacheKey()};return oe.vertexUv1s=h.has(1),oe.vertexUv2s=h.has(2),oe.vertexUv3s=h.has(3),h.clear(),oe}function m(y){const S=[];if(y.shaderID?S.push(y.shaderID):(S.push(y.customVertexShaderID),S.push(y.customFragmentShaderID)),y.defines!==void 0)for(const A in y.defines)S.push(A),S.push(y.defines[A]);return y.isRawShaderMaterial===!1&&(d(S,y),u(S,y),S.push(i.outputColorSpace)),S.push(y.customProgramCacheKey),S.join()}function d(y,S){y.push(S.precision),y.push(S.outputColorSpace),y.push(S.envMapMode),y.push(S.envMapCubeUVHeight),y.push(S.mapUv),y.push(S.alphaMapUv),y.push(S.lightMapUv),y.push(S.aoMapUv),y.push(S.bumpMapUv),y.push(S.normalMapUv),y.push(S.displacementMapUv),y.push(S.emissiveMapUv),y.push(S.metalnessMapUv),y.push(S.roughnessMapUv),y.push(S.anisotropyMapUv),y.push(S.clearcoatMapUv),y.push(S.clearcoatNormalMapUv),y.push(S.clearcoatRoughnessMapUv),y.push(S.iridescenceMapUv),y.push(S.iridescenceThicknessMapUv),y.push(S.sheenColorMapUv),y.push(S.sheenRoughnessMapUv),y.push(S.specularMapUv),y.push(S.specularColorMapUv),y.push(S.specularIntensityMapUv),y.push(S.transmissionMapUv),y.push(S.thicknessMapUv),y.push(S.combine),y.push(S.fogExp2),y.push(S.sizeAttenuation),y.push(S.morphTargetsCount),y.push(S.morphAttributeCount),y.push(S.numDirLights),y.push(S.numPointLights),y.push(S.numSpotLights),y.push(S.numSpotLightMaps),y.push(S.numHemiLights),y.push(S.numRectAreaLights),y.push(S.numDirLightShadows),y.push(S.numPointLightShadows),y.push(S.numSpotLightShadows),y.push(S.numSpotLightShadowsWithMaps),y.push(S.numLightProbes),y.push(S.shadowMapType),y.push(S.toneMapping),y.push(S.numClippingPlanes),y.push(S.numClipIntersection),y.push(S.depthPacking)}function u(y,S){o.disableAll(),S.supportsVertexTextures&&o.enable(0),S.instancing&&o.enable(1),S.instancingColor&&o.enable(2),S.instancingMorph&&o.enable(3),S.matcap&&o.enable(4),S.envMap&&o.enable(5),S.normalMapObjectSpace&&o.enable(6),S.normalMapTangentSpace&&o.enable(7),S.clearcoat&&o.enable(8),S.iridescence&&o.enable(9),S.alphaTest&&o.enable(10),S.vertexColors&&o.enable(11),S.vertexAlphas&&o.enable(12),S.vertexUv1s&&o.enable(13),S.vertexUv2s&&o.enable(14),S.vertexUv3s&&o.enable(15),S.vertexTangents&&o.enable(16),S.anisotropy&&o.enable(17),S.alphaHash&&o.enable(18),S.batching&&o.enable(19),S.dispersion&&o.enable(20),S.batchingColor&&o.enable(21),y.push(o.mask),o.disableAll(),S.fog&&o.enable(0),S.useFog&&o.enable(1),S.flatShading&&o.enable(2),S.logarithmicDepthBuffer&&o.enable(3),S.reverseDepthBuffer&&o.enable(4),S.skinning&&o.enable(5),S.morphTargets&&o.enable(6),S.morphNormals&&o.enable(7),S.morphColors&&o.enable(8),S.premultipliedAlpha&&o.enable(9),S.shadowMapEnabled&&o.enable(10),S.doubleSided&&o.enable(11),S.flipSided&&o.enable(12),S.useDepthPacking&&o.enable(13),S.dithering&&o.enable(14),S.transmission&&o.enable(15),S.sheen&&o.enable(16),S.opaque&&o.enable(17),S.pointsUvs&&o.enable(18),S.decodeVideoTexture&&o.enable(19),S.decodeVideoTextureEmissive&&o.enable(20),S.alphaToCoverage&&o.enable(21),y.push(o.mask)}function v(y){const S=M[y.type];let A;if(S){const w=Tn[S];A=yp.clone(w.uniforms)}else A=y.uniforms;return A}function l(y,S){let A;for(let w=0,I=f.length;w<I;w++){const N=f[w];if(N.cacheKey===S){A=N,++A.usedTimes;break}}return A===void 0&&(A=new ev(i,S,y,s),f.push(A)),A}function R(y){if(--y.usedTimes===0){const S=f.indexOf(y);f[S]=f[f.length-1],f.pop(),y.destroy()}}function T(y){c.remove(y)}function E(){c.dispose()}return{getParameters:x,getProgramCacheKey:m,getUniforms:v,acquireProgram:l,releaseProgram:R,releaseShaderCache:T,programs:f,dispose:E}}function ov(){let i=new WeakMap;function t(a){return i.has(a)}function e(a){let o=i.get(a);return o===void 0&&(o={},i.set(a,o)),o}function n(a){i.delete(a)}function r(a,o,c){i.get(a)[o]=c}function s(){i=new WeakMap}return{has:t,get:e,remove:n,update:r,dispose:s}}function av(i,t){return i.groupOrder!==t.groupOrder?i.groupOrder-t.groupOrder:i.renderOrder!==t.renderOrder?i.renderOrder-t.renderOrder:i.material.id!==t.material.id?i.material.id-t.material.id:i.z!==t.z?i.z-t.z:i.id-t.id}function Ju(i,t){return i.groupOrder!==t.groupOrder?i.groupOrder-t.groupOrder:i.renderOrder!==t.renderOrder?i.renderOrder-t.renderOrder:i.z!==t.z?t.z-i.z:i.id-t.id}function Qu(){const i=[];let t=0;const e=[],n=[],r=[];function s(){t=0,e.length=0,n.length=0,r.length=0}function a(g,p,_,M,b,x){let m=i[t];return m===void 0?(m={id:g.id,object:g,geometry:p,material:_,groupOrder:M,renderOrder:g.renderOrder,z:b,group:x},i[t]=m):(m.id=g.id,m.object=g,m.geometry=p,m.material=_,m.groupOrder=M,m.renderOrder=g.renderOrder,m.z=b,m.group=x),t++,m}function o(g,p,_,M,b,x){const m=a(g,p,_,M,b,x);_.transmission>0?n.push(m):_.transparent===!0?r.push(m):e.push(m)}function c(g,p,_,M,b,x){const m=a(g,p,_,M,b,x);_.transmission>0?n.unshift(m):_.transparent===!0?r.unshift(m):e.unshift(m)}function h(g,p){e.length>1&&e.sort(g||av),n.length>1&&n.sort(p||Ju),r.length>1&&r.sort(p||Ju)}function f(){for(let g=t,p=i.length;g<p;g++){const _=i[g];if(_.id===null)break;_.id=null,_.object=null,_.geometry=null,_.material=null,_.group=null}}return{opaque:e,transmissive:n,transparent:r,init:s,push:o,unshift:c,finish:f,sort:h}}function cv(){let i=new WeakMap;function t(n,r){const s=i.get(n);let a;return s===void 0?(a=new Qu,i.set(n,[a])):r>=s.length?(a=new Qu,s.push(a)):a=s[r],a}function e(){i=new WeakMap}return{get:t,dispose:e}}function lv(){const i={};return{get:function(t){if(i[t.id]!==void 0)return i[t.id];let e;switch(t.type){case"DirectionalLight":e={direction:new U,color:new qt};break;case"SpotLight":e={position:new U,direction:new U,color:new qt,distance:0,coneCos:0,penumbraCos:0,decay:0};break;case"PointLight":e={position:new U,color:new qt,distance:0,decay:0};break;case"HemisphereLight":e={direction:new U,skyColor:new qt,groundColor:new qt};break;case"RectAreaLight":e={color:new qt,position:new U,halfWidth:new U,halfHeight:new U};break}return i[t.id]=e,e}}}function uv(){const i={};return{get:function(t){if(i[t.id]!==void 0)return i[t.id];let e;switch(t.type){case"DirectionalLight":e={shadowIntensity:1,shadowBias:0,shadowNormalBias:0,shadowRadius:1,shadowMapSize:new kt};break;case"SpotLight":e={shadowIntensity:1,shadowBias:0,shadowNormalBias:0,shadowRadius:1,shadowMapSize:new kt};break;case"PointLight":e={shadowIntensity:1,shadowBias:0,shadowNormalBias:0,shadowRadius:1,shadowMapSize:new kt,shadowCameraNear:1,shadowCameraFar:1e3};break}return i[t.id]=e,e}}}let hv=0;function fv(i,t){return(t.castShadow?2:0)-(i.castShadow?2:0)+(t.map?1:0)-(i.map?1:0)}function dv(i){const t=new lv,e=uv(),n={version:0,hash:{directionalLength:-1,pointLength:-1,spotLength:-1,rectAreaLength:-1,hemiLength:-1,numDirectionalShadows:-1,numPointShadows:-1,numSpotShadows:-1,numSpotMaps:-1,numLightProbes:-1},ambient:[0,0,0],probe:[],directional:[],directionalShadow:[],directionalShadowMap:[],directionalShadowMatrix:[],spot:[],spotLightMap:[],spotShadow:[],spotShadowMap:[],spotLightMatrix:[],rectArea:[],rectAreaLTC1:null,rectAreaLTC2:null,point:[],pointShadow:[],pointShadowMap:[],pointShadowMatrix:[],hemi:[],numSpotLightShadowsWithMaps:0,numLightProbes:0};for(let h=0;h<9;h++)n.probe.push(new U);const r=new U,s=new $t,a=new $t;function o(h){let f=0,g=0,p=0;for(let y=0;y<9;y++)n.probe[y].set(0,0,0);let _=0,M=0,b=0,x=0,m=0,d=0,u=0,v=0,l=0,R=0,T=0;h.sort(fv);for(let y=0,S=h.length;y<S;y++){const A=h[y],w=A.color,I=A.intensity,N=A.distance,B=A.shadow&&A.shadow.map?A.shadow.map.texture:null;if(A.isAmbientLight)f+=w.r*I,g+=w.g*I,p+=w.b*I;else if(A.isLightProbe){for(let F=0;F<9;F++)n.probe[F].addScaledVector(A.sh.coefficients[F],I);T++}else if(A.isDirectionalLight){const F=t.get(A);if(F.color.copy(A.color).multiplyScalar(A.intensity),A.castShadow){const k=A.shadow,z=e.get(A);z.shadowIntensity=k.intensity,z.shadowBias=k.bias,z.shadowNormalBias=k.normalBias,z.shadowRadius=k.radius,z.shadowMapSize=k.mapSize,n.directionalShadow[_]=z,n.directionalShadowMap[_]=B,n.directionalShadowMatrix[_]=A.shadow.matrix,d++}n.directional[_]=F,_++}else if(A.isSpotLight){const F=t.get(A);F.position.setFromMatrixPosition(A.matrixWorld),F.color.copy(w).multiplyScalar(I),F.distance=N,F.coneCos=Math.cos(A.angle),F.penumbraCos=Math.cos(A.angle*(1-A.penumbra)),F.decay=A.decay,n.spot[b]=F;const k=A.shadow;if(A.map&&(n.spotLightMap[l]=A.map,l++,k.updateMatrices(A),A.castShadow&&R++),n.spotLightMatrix[b]=k.matrix,A.castShadow){const z=e.get(A);z.shadowIntensity=k.intensity,z.shadowBias=k.bias,z.shadowNormalBias=k.normalBias,z.shadowRadius=k.radius,z.shadowMapSize=k.mapSize,n.spotShadow[b]=z,n.spotShadowMap[b]=B,v++}b++}else if(A.isRectAreaLight){const F=t.get(A);F.color.copy(w).multiplyScalar(I),F.halfWidth.set(A.width*.5,0,0),F.halfHeight.set(0,A.height*.5,0),n.rectArea[x]=F,x++}else if(A.isPointLight){const F=t.get(A);if(F.color.copy(A.color).multiplyScalar(A.intensity),F.distance=A.distance,F.decay=A.decay,A.castShadow){const k=A.shadow,z=e.get(A);z.shadowIntensity=k.intensity,z.shadowBias=k.bias,z.shadowNormalBias=k.normalBias,z.shadowRadius=k.radius,z.shadowMapSize=k.mapSize,z.shadowCameraNear=k.camera.near,z.shadowCameraFar=k.camera.far,n.pointShadow[M]=z,n.pointShadowMap[M]=B,n.pointShadowMatrix[M]=A.shadow.matrix,u++}n.point[M]=F,M++}else if(A.isHemisphereLight){const F=t.get(A);F.skyColor.copy(A.color).multiplyScalar(I),F.groundColor.copy(A.groundColor).multiplyScalar(I),n.hemi[m]=F,m++}}x>0&&(i.has("OES_texture_float_linear")===!0?(n.rectAreaLTC1=dt.LTC_FLOAT_1,n.rectAreaLTC2=dt.LTC_FLOAT_2):(n.rectAreaLTC1=dt.LTC_HALF_1,n.rectAreaLTC2=dt.LTC_HALF_2)),n.ambient[0]=f,n.ambient[1]=g,n.ambient[2]=p;const E=n.hash;(E.directionalLength!==_||E.pointLength!==M||E.spotLength!==b||E.rectAreaLength!==x||E.hemiLength!==m||E.numDirectionalShadows!==d||E.numPointShadows!==u||E.numSpotShadows!==v||E.numSpotMaps!==l||E.numLightProbes!==T)&&(n.directional.length=_,n.spot.length=b,n.rectArea.length=x,n.point.length=M,n.hemi.length=m,n.directionalShadow.length=d,n.directionalShadowMap.length=d,n.pointShadow.length=u,n.pointShadowMap.length=u,n.spotShadow.length=v,n.spotShadowMap.length=v,n.directionalShadowMatrix.length=d,n.pointShadowMatrix.length=u,n.spotLightMatrix.length=v+l-R,n.spotLightMap.length=l,n.numSpotLightShadowsWithMaps=R,n.numLightProbes=T,E.directionalLength=_,E.pointLength=M,E.spotLength=b,E.rectAreaLength=x,E.hemiLength=m,E.numDirectionalShadows=d,E.numPointShadows=u,E.numSpotShadows=v,E.numSpotMaps=l,E.numLightProbes=T,n.version=hv++)}function c(h,f){let g=0,p=0,_=0,M=0,b=0;const x=f.matrixWorldInverse;for(let m=0,d=h.length;m<d;m++){const u=h[m];if(u.isDirectionalLight){const v=n.directional[g];v.direction.setFromMatrixPosition(u.matrixWorld),r.setFromMatrixPosition(u.target.matrixWorld),v.direction.sub(r),v.direction.transformDirection(x),g++}else if(u.isSpotLight){const v=n.spot[_];v.position.setFromMatrixPosition(u.matrixWorld),v.position.applyMatrix4(x),v.direction.setFromMatrixPosition(u.matrixWorld),r.setFromMatrixPosition(u.target.matrixWorld),v.direction.sub(r),v.direction.transformDirection(x),_++}else if(u.isRectAreaLight){const v=n.rectArea[M];v.position.setFromMatrixPosition(u.matrixWorld),v.position.applyMatrix4(x),a.identity(),s.copy(u.matrixWorld),s.premultiply(x),a.extractRotation(s),v.halfWidth.set(u.width*.5,0,0),v.halfHeight.set(0,u.height*.5,0),v.halfWidth.applyMatrix4(a),v.halfHeight.applyMatrix4(a),M++}else if(u.isPointLight){const v=n.point[p];v.position.setFromMatrixPosition(u.matrixWorld),v.position.applyMatrix4(x),p++}else if(u.isHemisphereLight){const v=n.hemi[b];v.direction.setFromMatrixPosition(u.matrixWorld),v.direction.transformDirection(x),b++}}}return{setup:o,setupView:c,state:n}}function th(i){const t=new dv(i),e=[],n=[];function r(f){h.camera=f,e.length=0,n.length=0}function s(f){e.push(f)}function a(f){n.push(f)}function o(){t.setup(e)}function c(f){t.setupView(e,f)}const h={lightsArray:e,shadowsArray:n,camera:null,lights:t,transmissionRenderTarget:{}};return{init:r,state:h,setupLights:o,setupLightsView:c,pushLight:s,pushShadow:a}}function pv(i){let t=new WeakMap;function e(r,s=0){const a=t.get(r);let o;return a===void 0?(o=new th(i),t.set(r,[o])):s>=a.length?(o=new th(i),a.push(o)):o=a[s],o}function n(){t=new WeakMap}return{get:e,dispose:n}}const gv=`void main() {
	gl_Position = vec4( position, 1.0 );
}`,mv=`uniform sampler2D shadow_pass;
uniform vec2 resolution;
uniform float radius;
#include <packing>
void main() {
	const float samples = float( VSM_SAMPLES );
	float mean = 0.0;
	float squared_mean = 0.0;
	float uvStride = samples <= 1.0 ? 0.0 : 2.0 / ( samples - 1.0 );
	float uvStart = samples <= 1.0 ? 0.0 : - 1.0;
	for ( float i = 0.0; i < samples; i ++ ) {
		float uvOffset = uvStart + i * uvStride;
		#ifdef HORIZONTAL_PASS
			vec2 distribution = unpackRGBATo2Half( texture2D( shadow_pass, ( gl_FragCoord.xy + vec2( uvOffset, 0.0 ) * radius ) / resolution ) );
			mean += distribution.x;
			squared_mean += distribution.y * distribution.y + distribution.x * distribution.x;
		#else
			float depth = unpackRGBAToDepth( texture2D( shadow_pass, ( gl_FragCoord.xy + vec2( 0.0, uvOffset ) * radius ) / resolution ) );
			mean += depth;
			squared_mean += depth * depth;
		#endif
	}
	mean = mean / samples;
	squared_mean = squared_mean / samples;
	float std_dev = sqrt( squared_mean - mean * mean );
	gl_FragColor = pack2HalfToRGBA( vec2( mean, std_dev ) );
}`;function _v(i,t,e){let n=new Ss;const r=new kt,s=new kt,a=new ie,o=new zp({depthPacking:Gd}),c=new Vp,h={},f=e.maxTextureSize,g={[In]:ze,[ze]:In,[Be]:Be},p=new pi({defines:{VSM_SAMPLES:8},uniforms:{shadow_pass:{value:null},resolution:{value:new kt},radius:{value:4}},vertexShader:gv,fragmentShader:mv}),_=p.clone();_.defines.HORIZONTAL_PASS=1;const M=new De;M.setAttribute("position",new de(new Float32Array([-1,-1,.5,3,-1,.5,-1,3,.5]),3));const b=new Ie(M,p),x=this;this.enabled=!1,this.autoUpdate=!0,this.needsUpdate=!1,this.type=Jh;let m=this.type;this.render=function(R,T,E){if(x.enabled===!1||x.autoUpdate===!1&&x.needsUpdate===!1||R.length===0)return;const y=i.getRenderTarget(),S=i.getActiveCubeFace(),A=i.getActiveMipmapLevel(),w=i.state;w.setBlending(li),w.buffers.color.setClear(1,1,1,1),w.buffers.depth.setTest(!0),w.setScissorTest(!1);const I=m!==kn&&this.type===kn,N=m===kn&&this.type!==kn;for(let B=0,F=R.length;B<F;B++){const k=R[B],z=k.shadow;if(z===void 0){console.warn("THREE.WebGLShadowMap:",k,"has no shadow.");continue}if(z.autoUpdate===!1&&z.needsUpdate===!1)continue;r.copy(z.mapSize);const J=z.getFrameExtents();if(r.multiply(J),s.copy(z.mapSize),(r.x>f||r.y>f)&&(r.x>f&&(s.x=Math.floor(f/J.x),r.x=s.x*J.x,z.mapSize.x=s.x),r.y>f&&(s.y=Math.floor(f/J.y),r.y=s.y*J.y,z.mapSize.y=s.y)),z.map===null||I===!0||N===!0){const it=this.type!==kn?{minFilter:Je,magFilter:Je}:{};z.map!==null&&z.map.dispose(),z.map=new Vi(r.x,r.y,it),z.map.texture.name=k.name+".shadowMap",z.camera.updateProjectionMatrix()}i.setRenderTarget(z.map),i.clear();const Z=z.getViewportCount();for(let it=0;it<Z;it++){const pt=z.getViewport(it);a.set(s.x*pt.x,s.y*pt.y,s.x*pt.z,s.y*pt.w),w.viewport(a),z.updateMatrices(k,it),n=z.getFrustum(),v(T,E,z.camera,k,this.type)}z.isPointLightShadow!==!0&&this.type===kn&&d(z,E),z.needsUpdate=!1}m=this.type,x.needsUpdate=!1,i.setRenderTarget(y,S,A)};function d(R,T){const E=t.update(b);p.defines.VSM_SAMPLES!==R.blurSamples&&(p.defines.VSM_SAMPLES=R.blurSamples,_.defines.VSM_SAMPLES=R.blurSamples,p.needsUpdate=!0,_.needsUpdate=!0),R.mapPass===null&&(R.mapPass=new Vi(r.x,r.y)),p.uniforms.shadow_pass.value=R.map.texture,p.uniforms.resolution.value=R.mapSize,p.uniforms.radius.value=R.radius,i.setRenderTarget(R.mapPass),i.clear(),i.renderBufferDirect(T,null,E,p,b,null),_.uniforms.shadow_pass.value=R.mapPass.texture,_.uniforms.resolution.value=R.mapSize,_.uniforms.radius.value=R.radius,i.setRenderTarget(R.map),i.clear(),i.renderBufferDirect(T,null,E,_,b,null)}function u(R,T,E,y){let S=null;const A=E.isPointLight===!0?R.customDistanceMaterial:R.customDepthMaterial;if(A!==void 0)S=A;else if(S=E.isPointLight===!0?c:o,i.localClippingEnabled&&T.clipShadows===!0&&Array.isArray(T.clippingPlanes)&&T.clippingPlanes.length!==0||T.displacementMap&&T.displacementScale!==0||T.alphaMap&&T.alphaTest>0||T.map&&T.alphaTest>0||T.alphaToCoverage===!0){const w=S.uuid,I=T.uuid;let N=h[w];N===void 0&&(N={},h[w]=N);let B=N[I];B===void 0&&(B=S.clone(),N[I]=B,T.addEventListener("dispose",l)),S=B}if(S.visible=T.visible,S.wireframe=T.wireframe,y===kn?S.side=T.shadowSide!==null?T.shadowSide:T.side:S.side=T.shadowSide!==null?T.shadowSide:g[T.side],S.alphaMap=T.alphaMap,S.alphaTest=T.alphaToCoverage===!0?.5:T.alphaTest,S.map=T.map,S.clipShadows=T.clipShadows,S.clippingPlanes=T.clippingPlanes,S.clipIntersection=T.clipIntersection,S.displacementMap=T.displacementMap,S.displacementScale=T.displacementScale,S.displacementBias=T.displacementBias,S.wireframeLinewidth=T.wireframeLinewidth,S.linewidth=T.linewidth,E.isPointLight===!0&&S.isMeshDistanceMaterial===!0){const w=i.properties.get(S);w.light=E}return S}function v(R,T,E,y,S){if(R.visible===!1)return;if(R.layers.test(T.layers)&&(R.isMesh||R.isLine||R.isPoints)&&(R.castShadow||R.receiveShadow&&S===kn)&&(!R.frustumCulled||n.intersectsObject(R))){R.modelViewMatrix.multiplyMatrices(E.matrixWorldInverse,R.matrixWorld);const I=t.update(R),N=R.material;if(Array.isArray(N)){const B=I.groups;for(let F=0,k=B.length;F<k;F++){const z=B[F],J=N[z.materialIndex];if(J&&J.visible){const Z=u(R,J,y,S);R.onBeforeShadow(i,R,T,E,I,Z,z),i.renderBufferDirect(E,null,I,Z,R,z),R.onAfterShadow(i,R,T,E,I,Z,z)}}}else if(N.visible){const B=u(R,N,y,S);R.onBeforeShadow(i,R,T,E,I,B,null),i.renderBufferDirect(E,null,I,B,R,null),R.onAfterShadow(i,R,T,E,I,B,null)}}const w=R.children;for(let I=0,N=w.length;I<N;I++)v(w[I],T,E,y,S)}function l(R){R.target.removeEventListener("dispose",l);for(const E in h){const y=h[E],S=R.target.uuid;S in y&&(y[S].dispose(),delete y[S])}}}const xv={[Ac]:wc,[Rc]:Ic,[Cc]:Lc,[br]:Pc,[wc]:Ac,[Ic]:Rc,[Lc]:Cc,[Pc]:br};function vv(i,t){function e(){let O=!1;const gt=new ie;let nt=null;const Tt=new ie(0,0,0,0);return{setMask:function(rt){nt!==rt&&!O&&(i.colorMask(rt,rt,rt,rt),nt=rt)},setLocked:function(rt){O=rt},setClear:function(rt,K,At,Ht,oe){oe===!0&&(rt*=Ht,K*=Ht,At*=Ht),gt.set(rt,K,At,Ht),Tt.equals(gt)===!1&&(i.clearColor(rt,K,At,Ht),Tt.copy(gt))},reset:function(){O=!1,nt=null,Tt.set(-1,0,0,0)}}}function n(){let O=!1,gt=!1,nt=null,Tt=null,rt=null;return{setReversed:function(K){if(gt!==K){const At=t.get("EXT_clip_control");K?At.clipControlEXT(At.LOWER_LEFT_EXT,At.ZERO_TO_ONE_EXT):At.clipControlEXT(At.LOWER_LEFT_EXT,At.NEGATIVE_ONE_TO_ONE_EXT),gt=K;const Ht=rt;rt=null,this.setClear(Ht)}},getReversed:function(){return gt},setTest:function(K){K?Q(i.DEPTH_TEST):at(i.DEPTH_TEST)},setMask:function(K){nt!==K&&!O&&(i.depthMask(K),nt=K)},setFunc:function(K){if(gt&&(K=xv[K]),Tt!==K){switch(K){case Ac:i.depthFunc(i.NEVER);break;case wc:i.depthFunc(i.ALWAYS);break;case Rc:i.depthFunc(i.LESS);break;case br:i.depthFunc(i.LEQUAL);break;case Cc:i.depthFunc(i.EQUAL);break;case Pc:i.depthFunc(i.GEQUAL);break;case Ic:i.depthFunc(i.GREATER);break;case Lc:i.depthFunc(i.NOTEQUAL);break;default:i.depthFunc(i.LEQUAL)}Tt=K}},setLocked:function(K){O=K},setClear:function(K){rt!==K&&(gt&&(K=1-K),i.clearDepth(K),rt=K)},reset:function(){O=!1,nt=null,Tt=null,rt=null,gt=!1}}}function r(){let O=!1,gt=null,nt=null,Tt=null,rt=null,K=null,At=null,Ht=null,oe=null;return{setTest:function(ee){O||(ee?Q(i.STENCIL_TEST):at(i.STENCIL_TEST))},setMask:function(ee){gt!==ee&&!O&&(i.stencilMask(ee),gt=ee)},setFunc:function(ee,fn,Un){(nt!==ee||Tt!==fn||rt!==Un)&&(i.stencilFunc(ee,fn,Un),nt=ee,Tt=fn,rt=Un)},setOp:function(ee,fn,Un){(K!==ee||At!==fn||Ht!==Un)&&(i.stencilOp(ee,fn,Un),K=ee,At=fn,Ht=Un)},setLocked:function(ee){O=ee},setClear:function(ee){oe!==ee&&(i.clearStencil(ee),oe=ee)},reset:function(){O=!1,gt=null,nt=null,Tt=null,rt=null,K=null,At=null,Ht=null,oe=null}}}const s=new e,a=new n,o=new r,c=new WeakMap,h=new WeakMap;let f={},g={},p=new WeakMap,_=[],M=null,b=!1,x=null,m=null,d=null,u=null,v=null,l=null,R=null,T=new qt(0,0,0),E=0,y=!1,S=null,A=null,w=null,I=null,N=null;const B=i.getParameter(i.MAX_COMBINED_TEXTURE_IMAGE_UNITS);let F=!1,k=0;const z=i.getParameter(i.VERSION);z.indexOf("WebGL")!==-1?(k=parseFloat(/^WebGL (\d)/.exec(z)[1]),F=k>=1):z.indexOf("OpenGL ES")!==-1&&(k=parseFloat(/^OpenGL ES (\d)/.exec(z)[1]),F=k>=2);let J=null,Z={};const it=i.getParameter(i.SCISSOR_BOX),pt=i.getParameter(i.VIEWPORT),_t=new ie().fromArray(it),W=new ie().fromArray(pt);function tt(O,gt,nt,Tt){const rt=new Uint8Array(4),K=i.createTexture();i.bindTexture(O,K),i.texParameteri(O,i.TEXTURE_MIN_FILTER,i.NEAREST),i.texParameteri(O,i.TEXTURE_MAG_FILTER,i.NEAREST);for(let At=0;At<nt;At++)O===i.TEXTURE_3D||O===i.TEXTURE_2D_ARRAY?i.texImage3D(gt,0,i.RGBA,1,1,Tt,0,i.RGBA,i.UNSIGNED_BYTE,rt):i.texImage2D(gt+At,0,i.RGBA,1,1,0,i.RGBA,i.UNSIGNED_BYTE,rt);return K}const st={};st[i.TEXTURE_2D]=tt(i.TEXTURE_2D,i.TEXTURE_2D,1),st[i.TEXTURE_CUBE_MAP]=tt(i.TEXTURE_CUBE_MAP,i.TEXTURE_CUBE_MAP_POSITIVE_X,6),st[i.TEXTURE_2D_ARRAY]=tt(i.TEXTURE_2D_ARRAY,i.TEXTURE_2D_ARRAY,1,1),st[i.TEXTURE_3D]=tt(i.TEXTURE_3D,i.TEXTURE_3D,1,1),s.setClear(0,0,0,1),a.setClear(1),o.setClear(0),Q(i.DEPTH_TEST),a.setFunc(br),Et(!1),Zt(jl),Q(i.CULL_FACE),D(li);function Q(O){f[O]!==!0&&(i.enable(O),f[O]=!0)}function at(O){f[O]!==!1&&(i.disable(O),f[O]=!1)}function xt(O,gt){return g[O]!==gt?(i.bindFramebuffer(O,gt),g[O]=gt,O===i.DRAW_FRAMEBUFFER&&(g[i.FRAMEBUFFER]=gt),O===i.FRAMEBUFFER&&(g[i.DRAW_FRAMEBUFFER]=gt),!0):!1}function lt(O,gt){let nt=_,Tt=!1;if(O){nt=p.get(gt),nt===void 0&&(nt=[],p.set(gt,nt));const rt=O.textures;if(nt.length!==rt.length||nt[0]!==i.COLOR_ATTACHMENT0){for(let K=0,At=rt.length;K<At;K++)nt[K]=i.COLOR_ATTACHMENT0+K;nt.length=rt.length,Tt=!0}}else nt[0]!==i.BACK&&(nt[0]=i.BACK,Tt=!0);Tt&&i.drawBuffers(nt)}function jt(O){return M!==O?(i.useProgram(O),M=O,!0):!1}const Lt={[Li]:i.FUNC_ADD,[pd]:i.FUNC_SUBTRACT,[gd]:i.FUNC_REVERSE_SUBTRACT};Lt[md]=i.MIN,Lt[_d]=i.MAX;const Mt={[xd]:i.ZERO,[vd]:i.ONE,[yd]:i.SRC_COLOR,[Tc]:i.SRC_ALPHA,[Ad]:i.SRC_ALPHA_SATURATE,[Td]:i.DST_COLOR,[Md]:i.DST_ALPHA,[Sd]:i.ONE_MINUS_SRC_COLOR,[bc]:i.ONE_MINUS_SRC_ALPHA,[bd]:i.ONE_MINUS_DST_COLOR,[Ed]:i.ONE_MINUS_DST_ALPHA,[wd]:i.CONSTANT_COLOR,[Rd]:i.ONE_MINUS_CONSTANT_COLOR,[Cd]:i.CONSTANT_ALPHA,[Pd]:i.ONE_MINUS_CONSTANT_ALPHA};function D(O,gt,nt,Tt,rt,K,At,Ht,oe,ee){if(O===li){b===!0&&(at(i.BLEND),b=!1);return}if(b===!1&&(Q(i.BLEND),b=!0),O!==dd){if(O!==x||ee!==y){if((m!==Li||v!==Li)&&(i.blendEquation(i.FUNC_ADD),m=Li,v=Li),ee)switch(O){case yr:i.blendFuncSeparate(i.ONE,i.ONE_MINUS_SRC_ALPHA,i.ONE,i.ONE_MINUS_SRC_ALPHA);break;case Kl:i.blendFunc(i.ONE,i.ONE);break;case Zl:i.blendFuncSeparate(i.ZERO,i.ONE_MINUS_SRC_COLOR,i.ZERO,i.ONE);break;case Jl:i.blendFuncSeparate(i.ZERO,i.SRC_COLOR,i.ZERO,i.SRC_ALPHA);break;default:console.error("THREE.WebGLState: Invalid blending: ",O);break}else switch(O){case yr:i.blendFuncSeparate(i.SRC_ALPHA,i.ONE_MINUS_SRC_ALPHA,i.ONE,i.ONE_MINUS_SRC_ALPHA);break;case Kl:i.blendFunc(i.SRC_ALPHA,i.ONE);break;case Zl:i.blendFuncSeparate(i.ZERO,i.ONE_MINUS_SRC_COLOR,i.ZERO,i.ONE);break;case Jl:i.blendFunc(i.ZERO,i.SRC_COLOR);break;default:console.error("THREE.WebGLState: Invalid blending: ",O);break}d=null,u=null,l=null,R=null,T.set(0,0,0),E=0,x=O,y=ee}return}rt=rt||gt,K=K||nt,At=At||Tt,(gt!==m||rt!==v)&&(i.blendEquationSeparate(Lt[gt],Lt[rt]),m=gt,v=rt),(nt!==d||Tt!==u||K!==l||At!==R)&&(i.blendFuncSeparate(Mt[nt],Mt[Tt],Mt[K],Mt[At]),d=nt,u=Tt,l=K,R=At),(Ht.equals(T)===!1||oe!==E)&&(i.blendColor(Ht.r,Ht.g,Ht.b,oe),T.copy(Ht),E=oe),x=O,y=!1}function Ft(O,gt){O.side===Be?at(i.CULL_FACE):Q(i.CULL_FACE);let nt=O.side===ze;gt&&(nt=!nt),Et(nt),O.blending===yr&&O.transparent===!1?D(li):D(O.blending,O.blendEquation,O.blendSrc,O.blendDst,O.blendEquationAlpha,O.blendSrcAlpha,O.blendDstAlpha,O.blendColor,O.blendAlpha,O.premultipliedAlpha),a.setFunc(O.depthFunc),a.setTest(O.depthTest),a.setMask(O.depthWrite),s.setMask(O.colorWrite);const Tt=O.stencilWrite;o.setTest(Tt),Tt&&(o.setMask(O.stencilWriteMask),o.setFunc(O.stencilFunc,O.stencilRef,O.stencilFuncMask),o.setOp(O.stencilFail,O.stencilZFail,O.stencilZPass)),Rt(O.polygonOffset,O.polygonOffsetFactor,O.polygonOffsetUnits),O.alphaToCoverage===!0?Q(i.SAMPLE_ALPHA_TO_COVERAGE):at(i.SAMPLE_ALPHA_TO_COVERAGE)}function Et(O){S!==O&&(O?i.frontFace(i.CW):i.frontFace(i.CCW),S=O)}function Zt(O){O!==ud?(Q(i.CULL_FACE),O!==A&&(O===jl?i.cullFace(i.BACK):O===hd?i.cullFace(i.FRONT):i.cullFace(i.FRONT_AND_BACK))):at(i.CULL_FACE),A=O}function ct(O){O!==w&&(F&&i.lineWidth(O),w=O)}function Rt(O,gt,nt){O?(Q(i.POLYGON_OFFSET_FILL),(I!==gt||N!==nt)&&(i.polygonOffset(gt,nt),I=gt,N=nt)):at(i.POLYGON_OFFSET_FILL)}function ut(O){O?Q(i.SCISSOR_TEST):at(i.SCISSOR_TEST)}function vt(O){O===void 0&&(O=i.TEXTURE0+B-1),J!==O&&(i.activeTexture(O),J=O)}function zt(O,gt,nt){nt===void 0&&(J===null?nt=i.TEXTURE0+B-1:nt=J);let Tt=Z[nt];Tt===void 0&&(Tt={type:void 0,texture:void 0},Z[nt]=Tt),(Tt.type!==O||Tt.texture!==gt)&&(J!==nt&&(i.activeTexture(nt),J=nt),i.bindTexture(O,gt||st[O]),Tt.type=O,Tt.texture=gt)}function L(){const O=Z[J];O!==void 0&&O.type!==void 0&&(i.bindTexture(O.type,null),O.type=void 0,O.texture=void 0)}function C(){try{i.compressedTexImage2D(...arguments)}catch(O){console.error("THREE.WebGLState:",O)}}function V(){try{i.compressedTexImage3D(...arguments)}catch(O){console.error("THREE.WebGLState:",O)}}function $(){try{i.texSubImage2D(...arguments)}catch(O){console.error("THREE.WebGLState:",O)}}function j(){try{i.texSubImage3D(...arguments)}catch(O){console.error("THREE.WebGLState:",O)}}function X(){try{i.compressedTexSubImage2D(...arguments)}catch(O){console.error("THREE.WebGLState:",O)}}function Ct(){try{i.compressedTexSubImage3D(...arguments)}catch(O){console.error("THREE.WebGLState:",O)}}function ht(){try{i.texStorage2D(...arguments)}catch(O){console.error("THREE.WebGLState:",O)}}function bt(){try{i.texStorage3D(...arguments)}catch(O){console.error("THREE.WebGLState:",O)}}function Pt(){try{i.texImage2D(...arguments)}catch(O){console.error("THREE.WebGLState:",O)}}function et(){try{i.texImage3D(...arguments)}catch(O){console.error("THREE.WebGLState:",O)}}function yt(O){_t.equals(O)===!1&&(i.scissor(O.x,O.y,O.z,O.w),_t.copy(O))}function Nt(O){W.equals(O)===!1&&(i.viewport(O.x,O.y,O.z,O.w),W.copy(O))}function Ut(O,gt){let nt=h.get(gt);nt===void 0&&(nt=new WeakMap,h.set(gt,nt));let Tt=nt.get(O);Tt===void 0&&(Tt=i.getUniformBlockIndex(gt,O.name),nt.set(O,Tt))}function ft(O,gt){const Tt=h.get(gt).get(O);c.get(gt)!==Tt&&(i.uniformBlockBinding(gt,Tt,O.__bindingPointIndex),c.set(gt,Tt))}function Vt(){i.disable(i.BLEND),i.disable(i.CULL_FACE),i.disable(i.DEPTH_TEST),i.disable(i.POLYGON_OFFSET_FILL),i.disable(i.SCISSOR_TEST),i.disable(i.STENCIL_TEST),i.disable(i.SAMPLE_ALPHA_TO_COVERAGE),i.blendEquation(i.FUNC_ADD),i.blendFunc(i.ONE,i.ZERO),i.blendFuncSeparate(i.ONE,i.ZERO,i.ONE,i.ZERO),i.blendColor(0,0,0,0),i.colorMask(!0,!0,!0,!0),i.clearColor(0,0,0,0),i.depthMask(!0),i.depthFunc(i.LESS),a.setReversed(!1),i.clearDepth(1),i.stencilMask(4294967295),i.stencilFunc(i.ALWAYS,0,4294967295),i.stencilOp(i.KEEP,i.KEEP,i.KEEP),i.clearStencil(0),i.cullFace(i.BACK),i.frontFace(i.CCW),i.polygonOffset(0,0),i.activeTexture(i.TEXTURE0),i.bindFramebuffer(i.FRAMEBUFFER,null),i.bindFramebuffer(i.DRAW_FRAMEBUFFER,null),i.bindFramebuffer(i.READ_FRAMEBUFFER,null),i.useProgram(null),i.lineWidth(1),i.scissor(0,0,i.canvas.width,i.canvas.height),i.viewport(0,0,i.canvas.width,i.canvas.height),f={},J=null,Z={},g={},p=new WeakMap,_=[],M=null,b=!1,x=null,m=null,d=null,u=null,v=null,l=null,R=null,T=new qt(0,0,0),E=0,y=!1,S=null,A=null,w=null,I=null,N=null,_t.set(0,0,i.canvas.width,i.canvas.height),W.set(0,0,i.canvas.width,i.canvas.height),s.reset(),a.reset(),o.reset()}return{buffers:{color:s,depth:a,stencil:o},enable:Q,disable:at,bindFramebuffer:xt,drawBuffers:lt,useProgram:jt,setBlending:D,setMaterial:Ft,setFlipSided:Et,setCullFace:Zt,setLineWidth:ct,setPolygonOffset:Rt,setScissorTest:ut,activeTexture:vt,bindTexture:zt,unbindTexture:L,compressedTexImage2D:C,compressedTexImage3D:V,texImage2D:Pt,texImage3D:et,updateUBOMapping:Ut,uniformBlockBinding:ft,texStorage2D:ht,texStorage3D:bt,texSubImage2D:$,texSubImage3D:j,compressedTexSubImage2D:X,compressedTexSubImage3D:Ct,scissor:yt,viewport:Nt,reset:Vt}}function yv(i,t,e,n,r,s,a){const o=t.has("WEBGL_multisampled_render_to_texture")?t.get("WEBGL_multisampled_render_to_texture"):null,c=typeof navigator>"u"?!1:/OculusBrowser/g.test(navigator.userAgent),h=new kt,f=new WeakMap;let g;const p=new WeakMap;let _=!1;try{_=typeof OffscreenCanvas<"u"&&new OffscreenCanvas(1,1).getContext("2d")!==null}catch{}function M(L,C){return _?new OffscreenCanvas(L,C):Oo("canvas")}function b(L,C,V){let $=1;const j=zt(L);if((j.width>V||j.height>V)&&($=V/Math.max(j.width,j.height)),$<1)if(typeof HTMLImageElement<"u"&&L instanceof HTMLImageElement||typeof HTMLCanvasElement<"u"&&L instanceof HTMLCanvasElement||typeof ImageBitmap<"u"&&L instanceof ImageBitmap||typeof VideoFrame<"u"&&L instanceof VideoFrame){const X=Math.floor($*j.width),Ct=Math.floor($*j.height);g===void 0&&(g=M(X,Ct));const ht=C?M(X,Ct):g;return ht.width=X,ht.height=Ct,ht.getContext("2d").drawImage(L,0,0,X,Ct),console.warn("THREE.WebGLRenderer: Texture has been resized from ("+j.width+"x"+j.height+") to ("+X+"x"+Ct+")."),ht}else return"data"in L&&console.warn("THREE.WebGLRenderer: Image in DataTexture is too big ("+j.width+"x"+j.height+")."),L;return L}function x(L){return L.generateMipmaps}function m(L){i.generateMipmap(L)}function d(L){return L.isWebGLCubeRenderTarget?i.TEXTURE_CUBE_MAP:L.isWebGL3DRenderTarget?i.TEXTURE_3D:L.isWebGLArrayRenderTarget||L.isCompressedArrayTexture?i.TEXTURE_2D_ARRAY:i.TEXTURE_2D}function u(L,C,V,$,j=!1){if(L!==null){if(i[L]!==void 0)return i[L];console.warn("THREE.WebGLRenderer: Attempt to use non-existing WebGL internal format '"+L+"'")}let X=C;if(C===i.RED&&(V===i.FLOAT&&(X=i.R32F),V===i.HALF_FLOAT&&(X=i.R16F),V===i.UNSIGNED_BYTE&&(X=i.R8)),C===i.RED_INTEGER&&(V===i.UNSIGNED_BYTE&&(X=i.R8UI),V===i.UNSIGNED_SHORT&&(X=i.R16UI),V===i.UNSIGNED_INT&&(X=i.R32UI),V===i.BYTE&&(X=i.R8I),V===i.SHORT&&(X=i.R16I),V===i.INT&&(X=i.R32I)),C===i.RG&&(V===i.FLOAT&&(X=i.RG32F),V===i.HALF_FLOAT&&(X=i.RG16F),V===i.UNSIGNED_BYTE&&(X=i.RG8)),C===i.RG_INTEGER&&(V===i.UNSIGNED_BYTE&&(X=i.RG8UI),V===i.UNSIGNED_SHORT&&(X=i.RG16UI),V===i.UNSIGNED_INT&&(X=i.RG32UI),V===i.BYTE&&(X=i.RG8I),V===i.SHORT&&(X=i.RG16I),V===i.INT&&(X=i.RG32I)),C===i.RGB_INTEGER&&(V===i.UNSIGNED_BYTE&&(X=i.RGB8UI),V===i.UNSIGNED_SHORT&&(X=i.RGB16UI),V===i.UNSIGNED_INT&&(X=i.RGB32UI),V===i.BYTE&&(X=i.RGB8I),V===i.SHORT&&(X=i.RGB16I),V===i.INT&&(X=i.RGB32I)),C===i.RGBA_INTEGER&&(V===i.UNSIGNED_BYTE&&(X=i.RGBA8UI),V===i.UNSIGNED_SHORT&&(X=i.RGBA16UI),V===i.UNSIGNED_INT&&(X=i.RGBA32UI),V===i.BYTE&&(X=i.RGBA8I),V===i.SHORT&&(X=i.RGBA16I),V===i.INT&&(X=i.RGBA32I)),C===i.RGB&&V===i.UNSIGNED_INT_5_9_9_9_REV&&(X=i.RGB9_E5),C===i.RGBA){const Ct=j?Fo:Jt.getTransfer($);V===i.FLOAT&&(X=i.RGBA32F),V===i.HALF_FLOAT&&(X=i.RGBA16F),V===i.UNSIGNED_BYTE&&(X=Ct===re?i.SRGB8_ALPHA8:i.RGBA8),V===i.UNSIGNED_SHORT_4_4_4_4&&(X=i.RGBA4),V===i.UNSIGNED_SHORT_5_5_5_1&&(X=i.RGB5_A1)}return(X===i.R16F||X===i.R32F||X===i.RG16F||X===i.RG32F||X===i.RGBA16F||X===i.RGBA32F)&&t.get("EXT_color_buffer_float"),X}function v(L,C){let V;return L?C===null||C===di||C===us?V=i.DEPTH24_STENCIL8:C===yn?V=i.DEPTH32F_STENCIL8:C===ls&&(V=i.DEPTH24_STENCIL8,console.warn("DepthTexture: 16 bit depth attachment is not supported with stencil. Using 24-bit attachment.")):C===null||C===di||C===us?V=i.DEPTH_COMPONENT24:C===yn?V=i.DEPTH_COMPONENT32F:C===ls&&(V=i.DEPTH_COMPONENT16),V}function l(L,C){return x(L)===!0||L.isFramebufferTexture&&L.minFilter!==Je&&L.minFilter!==bn?Math.log2(Math.max(C.width,C.height))+1:L.mipmaps!==void 0&&L.mipmaps.length>0?L.mipmaps.length:L.isCompressedTexture&&Array.isArray(L.image)?C.mipmaps.length:1}function R(L){const C=L.target;C.removeEventListener("dispose",R),E(C),C.isVideoTexture&&f.delete(C)}function T(L){const C=L.target;C.removeEventListener("dispose",T),S(C)}function E(L){const C=n.get(L);if(C.__webglInit===void 0)return;const V=L.source,$=p.get(V);if($){const j=$[C.__cacheKey];j.usedTimes--,j.usedTimes===0&&y(L),Object.keys($).length===0&&p.delete(V)}n.remove(L)}function y(L){const C=n.get(L);i.deleteTexture(C.__webglTexture);const V=L.source,$=p.get(V);delete $[C.__cacheKey],a.memory.textures--}function S(L){const C=n.get(L);if(L.depthTexture&&(L.depthTexture.dispose(),n.remove(L.depthTexture)),L.isWebGLCubeRenderTarget)for(let $=0;$<6;$++){if(Array.isArray(C.__webglFramebuffer[$]))for(let j=0;j<C.__webglFramebuffer[$].length;j++)i.deleteFramebuffer(C.__webglFramebuffer[$][j]);else i.deleteFramebuffer(C.__webglFramebuffer[$]);C.__webglDepthbuffer&&i.deleteRenderbuffer(C.__webglDepthbuffer[$])}else{if(Array.isArray(C.__webglFramebuffer))for(let $=0;$<C.__webglFramebuffer.length;$++)i.deleteFramebuffer(C.__webglFramebuffer[$]);else i.deleteFramebuffer(C.__webglFramebuffer);if(C.__webglDepthbuffer&&i.deleteRenderbuffer(C.__webglDepthbuffer),C.__webglMultisampledFramebuffer&&i.deleteFramebuffer(C.__webglMultisampledFramebuffer),C.__webglColorRenderbuffer)for(let $=0;$<C.__webglColorRenderbuffer.length;$++)C.__webglColorRenderbuffer[$]&&i.deleteRenderbuffer(C.__webglColorRenderbuffer[$]);C.__webglDepthRenderbuffer&&i.deleteRenderbuffer(C.__webglDepthRenderbuffer)}const V=L.textures;for(let $=0,j=V.length;$<j;$++){const X=n.get(V[$]);X.__webglTexture&&(i.deleteTexture(X.__webglTexture),a.memory.textures--),n.remove(V[$])}n.remove(L)}let A=0;function w(){A=0}function I(){const L=A;return L>=r.maxTextures&&console.warn("THREE.WebGLTextures: Trying to use "+L+" texture units while this GPU supports only "+r.maxTextures),A+=1,L}function N(L){const C=[];return C.push(L.wrapS),C.push(L.wrapT),C.push(L.wrapR||0),C.push(L.magFilter),C.push(L.minFilter),C.push(L.anisotropy),C.push(L.internalFormat),C.push(L.format),C.push(L.type),C.push(L.generateMipmaps),C.push(L.premultiplyAlpha),C.push(L.flipY),C.push(L.unpackAlignment),C.push(L.colorSpace),C.join()}function B(L,C){const V=n.get(L);if(L.isVideoTexture&&ut(L),L.isRenderTargetTexture===!1&&L.version>0&&V.__version!==L.version){const $=L.image;if($===null)console.warn("THREE.WebGLRenderer: Texture marked for update but no image data found.");else if($.complete===!1)console.warn("THREE.WebGLRenderer: Texture marked for update but image is incomplete");else{st(V,L,C);return}}e.bindTexture(i.TEXTURE_2D,V.__webglTexture,i.TEXTURE0+C)}function F(L,C){const V=n.get(L);if(L.version>0&&V.__version!==L.version){st(V,L,C);return}e.bindTexture(i.TEXTURE_2D_ARRAY,V.__webglTexture,i.TEXTURE0+C)}function k(L,C){const V=n.get(L);if(L.version>0&&V.__version!==L.version){st(V,L,C);return}e.bindTexture(i.TEXTURE_3D,V.__webglTexture,i.TEXTURE0+C)}function z(L,C){const V=n.get(L);if(L.version>0&&V.__version!==L.version){Q(V,L,C);return}e.bindTexture(i.TEXTURE_CUBE_MAP,V.__webglTexture,i.TEXTURE0+C)}const J={[No]:i.REPEAT,[Fi]:i.CLAMP_TO_EDGE,[Nc]:i.MIRRORED_REPEAT},Z={[Je]:i.NEAREST,[Vd]:i.NEAREST_MIPMAP_NEAREST,[bs]:i.NEAREST_MIPMAP_LINEAR,[bn]:i.LINEAR,[ta]:i.LINEAR_MIPMAP_NEAREST,[Bi]:i.LINEAR_MIPMAP_LINEAR},it={[Wd]:i.NEVER,[Kd]:i.ALWAYS,[Xd]:i.LESS,[hf]:i.LEQUAL,[qd]:i.EQUAL,[jd]:i.GEQUAL,[Yd]:i.GREATER,[$d]:i.NOTEQUAL};function pt(L,C){if(C.type===yn&&t.has("OES_texture_float_linear")===!1&&(C.magFilter===bn||C.magFilter===ta||C.magFilter===bs||C.magFilter===Bi||C.minFilter===bn||C.minFilter===ta||C.minFilter===bs||C.minFilter===Bi)&&console.warn("THREE.WebGLRenderer: Unable to use linear filtering with floating point textures. OES_texture_float_linear not supported on this device."),i.texParameteri(L,i.TEXTURE_WRAP_S,J[C.wrapS]),i.texParameteri(L,i.TEXTURE_WRAP_T,J[C.wrapT]),(L===i.TEXTURE_3D||L===i.TEXTURE_2D_ARRAY)&&i.texParameteri(L,i.TEXTURE_WRAP_R,J[C.wrapR]),i.texParameteri(L,i.TEXTURE_MAG_FILTER,Z[C.magFilter]),i.texParameteri(L,i.TEXTURE_MIN_FILTER,Z[C.minFilter]),C.compareFunction&&(i.texParameteri(L,i.TEXTURE_COMPARE_MODE,i.COMPARE_REF_TO_TEXTURE),i.texParameteri(L,i.TEXTURE_COMPARE_FUNC,it[C.compareFunction])),t.has("EXT_texture_filter_anisotropic")===!0){if(C.magFilter===Je||C.minFilter!==bs&&C.minFilter!==Bi||C.type===yn&&t.has("OES_texture_float_linear")===!1)return;if(C.anisotropy>1||n.get(C).__currentAnisotropy){const V=t.get("EXT_texture_filter_anisotropic");i.texParameterf(L,V.TEXTURE_MAX_ANISOTROPY_EXT,Math.min(C.anisotropy,r.getMaxAnisotropy())),n.get(C).__currentAnisotropy=C.anisotropy}}}function _t(L,C){let V=!1;L.__webglInit===void 0&&(L.__webglInit=!0,C.addEventListener("dispose",R));const $=C.source;let j=p.get($);j===void 0&&(j={},p.set($,j));const X=N(C);if(X!==L.__cacheKey){j[X]===void 0&&(j[X]={texture:i.createTexture(),usedTimes:0},a.memory.textures++,V=!0),j[X].usedTimes++;const Ct=j[L.__cacheKey];Ct!==void 0&&(j[L.__cacheKey].usedTimes--,Ct.usedTimes===0&&y(C)),L.__cacheKey=X,L.__webglTexture=j[X].texture}return V}function W(L,C,V){return Math.floor(Math.floor(L/V)/C)}function tt(L,C,V,$){const X=L.updateRanges;if(X.length===0)e.texSubImage2D(i.TEXTURE_2D,0,0,0,C.width,C.height,V,$,C.data);else{X.sort((et,yt)=>et.start-yt.start);let Ct=0;for(let et=1;et<X.length;et++){const yt=X[Ct],Nt=X[et],Ut=yt.start+yt.count,ft=W(Nt.start,C.width,4),Vt=W(yt.start,C.width,4);Nt.start<=Ut+1&&ft===Vt&&W(Nt.start+Nt.count-1,C.width,4)===ft?yt.count=Math.max(yt.count,Nt.start+Nt.count-yt.start):(++Ct,X[Ct]=Nt)}X.length=Ct+1;const ht=i.getParameter(i.UNPACK_ROW_LENGTH),bt=i.getParameter(i.UNPACK_SKIP_PIXELS),Pt=i.getParameter(i.UNPACK_SKIP_ROWS);i.pixelStorei(i.UNPACK_ROW_LENGTH,C.width);for(let et=0,yt=X.length;et<yt;et++){const Nt=X[et],Ut=Math.floor(Nt.start/4),ft=Math.ceil(Nt.count/4),Vt=Ut%C.width,O=Math.floor(Ut/C.width),gt=ft,nt=1;i.pixelStorei(i.UNPACK_SKIP_PIXELS,Vt),i.pixelStorei(i.UNPACK_SKIP_ROWS,O),e.texSubImage2D(i.TEXTURE_2D,0,Vt,O,gt,nt,V,$,C.data)}L.clearUpdateRanges(),i.pixelStorei(i.UNPACK_ROW_LENGTH,ht),i.pixelStorei(i.UNPACK_SKIP_PIXELS,bt),i.pixelStorei(i.UNPACK_SKIP_ROWS,Pt)}}function st(L,C,V){let $=i.TEXTURE_2D;(C.isDataArrayTexture||C.isCompressedArrayTexture)&&($=i.TEXTURE_2D_ARRAY),C.isData3DTexture&&($=i.TEXTURE_3D);const j=_t(L,C),X=C.source;e.bindTexture($,L.__webglTexture,i.TEXTURE0+V);const Ct=n.get(X);if(X.version!==Ct.__version||j===!0){e.activeTexture(i.TEXTURE0+V);const ht=Jt.getPrimaries(Jt.workingColorSpace),bt=C.colorSpace===ri?null:Jt.getPrimaries(C.colorSpace),Pt=C.colorSpace===ri||ht===bt?i.NONE:i.BROWSER_DEFAULT_WEBGL;i.pixelStorei(i.UNPACK_FLIP_Y_WEBGL,C.flipY),i.pixelStorei(i.UNPACK_PREMULTIPLY_ALPHA_WEBGL,C.premultiplyAlpha),i.pixelStorei(i.UNPACK_ALIGNMENT,C.unpackAlignment),i.pixelStorei(i.UNPACK_COLORSPACE_CONVERSION_WEBGL,Pt);let et=b(C.image,!1,r.maxTextureSize);et=vt(C,et);const yt=s.convert(C.format,C.colorSpace),Nt=s.convert(C.type);let Ut=u(C.internalFormat,yt,Nt,C.colorSpace,C.isVideoTexture);pt($,C);let ft;const Vt=C.mipmaps,O=C.isVideoTexture!==!0,gt=Ct.__version===void 0||j===!0,nt=X.dataReady,Tt=l(C,et);if(C.isDepthTexture)Ut=v(C.format===fs,C.type),gt&&(O?e.texStorage2D(i.TEXTURE_2D,1,Ut,et.width,et.height):e.texImage2D(i.TEXTURE_2D,0,Ut,et.width,et.height,0,yt,Nt,null));else if(C.isDataTexture)if(Vt.length>0){O&&gt&&e.texStorage2D(i.TEXTURE_2D,Tt,Ut,Vt[0].width,Vt[0].height);for(let rt=0,K=Vt.length;rt<K;rt++)ft=Vt[rt],O?nt&&e.texSubImage2D(i.TEXTURE_2D,rt,0,0,ft.width,ft.height,yt,Nt,ft.data):e.texImage2D(i.TEXTURE_2D,rt,Ut,ft.width,ft.height,0,yt,Nt,ft.data);C.generateMipmaps=!1}else O?(gt&&e.texStorage2D(i.TEXTURE_2D,Tt,Ut,et.width,et.height),nt&&tt(C,et,yt,Nt)):e.texImage2D(i.TEXTURE_2D,0,Ut,et.width,et.height,0,yt,Nt,et.data);else if(C.isCompressedTexture)if(C.isCompressedArrayTexture){O&&gt&&e.texStorage3D(i.TEXTURE_2D_ARRAY,Tt,Ut,Vt[0].width,Vt[0].height,et.depth);for(let rt=0,K=Vt.length;rt<K;rt++)if(ft=Vt[rt],C.format!==Ke)if(yt!==null)if(O){if(nt)if(C.layerUpdates.size>0){const At=Pu(ft.width,ft.height,C.format,C.type);for(const Ht of C.layerUpdates){const oe=ft.data.subarray(Ht*At/ft.data.BYTES_PER_ELEMENT,(Ht+1)*At/ft.data.BYTES_PER_ELEMENT);e.compressedTexSubImage3D(i.TEXTURE_2D_ARRAY,rt,0,0,Ht,ft.width,ft.height,1,yt,oe)}C.clearLayerUpdates()}else e.compressedTexSubImage3D(i.TEXTURE_2D_ARRAY,rt,0,0,0,ft.width,ft.height,et.depth,yt,ft.data)}else e.compressedTexImage3D(i.TEXTURE_2D_ARRAY,rt,Ut,ft.width,ft.height,et.depth,0,ft.data,0,0);else console.warn("THREE.WebGLRenderer: Attempt to load unsupported compressed texture format in .uploadTexture()");else O?nt&&e.texSubImage3D(i.TEXTURE_2D_ARRAY,rt,0,0,0,ft.width,ft.height,et.depth,yt,Nt,ft.data):e.texImage3D(i.TEXTURE_2D_ARRAY,rt,Ut,ft.width,ft.height,et.depth,0,yt,Nt,ft.data)}else{O&&gt&&e.texStorage2D(i.TEXTURE_2D,Tt,Ut,Vt[0].width,Vt[0].height);for(let rt=0,K=Vt.length;rt<K;rt++)ft=Vt[rt],C.format!==Ke?yt!==null?O?nt&&e.compressedTexSubImage2D(i.TEXTURE_2D,rt,0,0,ft.width,ft.height,yt,ft.data):e.compressedTexImage2D(i.TEXTURE_2D,rt,Ut,ft.width,ft.height,0,ft.data):console.warn("THREE.WebGLRenderer: Attempt to load unsupported compressed texture format in .uploadTexture()"):O?nt&&e.texSubImage2D(i.TEXTURE_2D,rt,0,0,ft.width,ft.height,yt,Nt,ft.data):e.texImage2D(i.TEXTURE_2D,rt,Ut,ft.width,ft.height,0,yt,Nt,ft.data)}else if(C.isDataArrayTexture)if(O){if(gt&&e.texStorage3D(i.TEXTURE_2D_ARRAY,Tt,Ut,et.width,et.height,et.depth),nt)if(C.layerUpdates.size>0){const rt=Pu(et.width,et.height,C.format,C.type);for(const K of C.layerUpdates){const At=et.data.subarray(K*rt/et.data.BYTES_PER_ELEMENT,(K+1)*rt/et.data.BYTES_PER_ELEMENT);e.texSubImage3D(i.TEXTURE_2D_ARRAY,0,0,0,K,et.width,et.height,1,yt,Nt,At)}C.clearLayerUpdates()}else e.texSubImage3D(i.TEXTURE_2D_ARRAY,0,0,0,0,et.width,et.height,et.depth,yt,Nt,et.data)}else e.texImage3D(i.TEXTURE_2D_ARRAY,0,Ut,et.width,et.height,et.depth,0,yt,Nt,et.data);else if(C.isData3DTexture)O?(gt&&e.texStorage3D(i.TEXTURE_3D,Tt,Ut,et.width,et.height,et.depth),nt&&e.texSubImage3D(i.TEXTURE_3D,0,0,0,0,et.width,et.height,et.depth,yt,Nt,et.data)):e.texImage3D(i.TEXTURE_3D,0,Ut,et.width,et.height,et.depth,0,yt,Nt,et.data);else if(C.isFramebufferTexture){if(gt)if(O)e.texStorage2D(i.TEXTURE_2D,Tt,Ut,et.width,et.height);else{let rt=et.width,K=et.height;for(let At=0;At<Tt;At++)e.texImage2D(i.TEXTURE_2D,At,Ut,rt,K,0,yt,Nt,null),rt>>=1,K>>=1}}else if(Vt.length>0){if(O&&gt){const rt=zt(Vt[0]);e.texStorage2D(i.TEXTURE_2D,Tt,Ut,rt.width,rt.height)}for(let rt=0,K=Vt.length;rt<K;rt++)ft=Vt[rt],O?nt&&e.texSubImage2D(i.TEXTURE_2D,rt,0,0,yt,Nt,ft):e.texImage2D(i.TEXTURE_2D,rt,Ut,yt,Nt,ft);C.generateMipmaps=!1}else if(O){if(gt){const rt=zt(et);e.texStorage2D(i.TEXTURE_2D,Tt,Ut,rt.width,rt.height)}nt&&e.texSubImage2D(i.TEXTURE_2D,0,0,0,yt,Nt,et)}else e.texImage2D(i.TEXTURE_2D,0,Ut,yt,Nt,et);x(C)&&m($),Ct.__version=X.version,C.onUpdate&&C.onUpdate(C)}L.__version=C.version}function Q(L,C,V){if(C.image.length!==6)return;const $=_t(L,C),j=C.source;e.bindTexture(i.TEXTURE_CUBE_MAP,L.__webglTexture,i.TEXTURE0+V);const X=n.get(j);if(j.version!==X.__version||$===!0){e.activeTexture(i.TEXTURE0+V);const Ct=Jt.getPrimaries(Jt.workingColorSpace),ht=C.colorSpace===ri?null:Jt.getPrimaries(C.colorSpace),bt=C.colorSpace===ri||Ct===ht?i.NONE:i.BROWSER_DEFAULT_WEBGL;i.pixelStorei(i.UNPACK_FLIP_Y_WEBGL,C.flipY),i.pixelStorei(i.UNPACK_PREMULTIPLY_ALPHA_WEBGL,C.premultiplyAlpha),i.pixelStorei(i.UNPACK_ALIGNMENT,C.unpackAlignment),i.pixelStorei(i.UNPACK_COLORSPACE_CONVERSION_WEBGL,bt);const Pt=C.isCompressedTexture||C.image[0].isCompressedTexture,et=C.image[0]&&C.image[0].isDataTexture,yt=[];for(let K=0;K<6;K++)!Pt&&!et?yt[K]=b(C.image[K],!0,r.maxCubemapSize):yt[K]=et?C.image[K].image:C.image[K],yt[K]=vt(C,yt[K]);const Nt=yt[0],Ut=s.convert(C.format,C.colorSpace),ft=s.convert(C.type),Vt=u(C.internalFormat,Ut,ft,C.colorSpace),O=C.isVideoTexture!==!0,gt=X.__version===void 0||$===!0,nt=j.dataReady;let Tt=l(C,Nt);pt(i.TEXTURE_CUBE_MAP,C);let rt;if(Pt){O&&gt&&e.texStorage2D(i.TEXTURE_CUBE_MAP,Tt,Vt,Nt.width,Nt.height);for(let K=0;K<6;K++){rt=yt[K].mipmaps;for(let At=0;At<rt.length;At++){const Ht=rt[At];C.format!==Ke?Ut!==null?O?nt&&e.compressedTexSubImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,At,0,0,Ht.width,Ht.height,Ut,Ht.data):e.compressedTexImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,At,Vt,Ht.width,Ht.height,0,Ht.data):console.warn("THREE.WebGLRenderer: Attempt to load unsupported compressed texture format in .setTextureCube()"):O?nt&&e.texSubImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,At,0,0,Ht.width,Ht.height,Ut,ft,Ht.data):e.texImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,At,Vt,Ht.width,Ht.height,0,Ut,ft,Ht.data)}}}else{if(rt=C.mipmaps,O&&gt){rt.length>0&&Tt++;const K=zt(yt[0]);e.texStorage2D(i.TEXTURE_CUBE_MAP,Tt,Vt,K.width,K.height)}for(let K=0;K<6;K++)if(et){O?nt&&e.texSubImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,0,0,0,yt[K].width,yt[K].height,Ut,ft,yt[K].data):e.texImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,0,Vt,yt[K].width,yt[K].height,0,Ut,ft,yt[K].data);for(let At=0;At<rt.length;At++){const oe=rt[At].image[K].image;O?nt&&e.texSubImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,At+1,0,0,oe.width,oe.height,Ut,ft,oe.data):e.texImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,At+1,Vt,oe.width,oe.height,0,Ut,ft,oe.data)}}else{O?nt&&e.texSubImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,0,0,0,Ut,ft,yt[K]):e.texImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,0,Vt,Ut,ft,yt[K]);for(let At=0;At<rt.length;At++){const Ht=rt[At];O?nt&&e.texSubImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,At+1,0,0,Ut,ft,Ht.image[K]):e.texImage2D(i.TEXTURE_CUBE_MAP_POSITIVE_X+K,At+1,Vt,Ut,ft,Ht.image[K])}}}x(C)&&m(i.TEXTURE_CUBE_MAP),X.__version=j.version,C.onUpdate&&C.onUpdate(C)}L.__version=C.version}function at(L,C,V,$,j,X){const Ct=s.convert(V.format,V.colorSpace),ht=s.convert(V.type),bt=u(V.internalFormat,Ct,ht,V.colorSpace),Pt=n.get(C),et=n.get(V);if(et.__renderTarget=C,!Pt.__hasExternalTextures){const yt=Math.max(1,C.width>>X),Nt=Math.max(1,C.height>>X);j===i.TEXTURE_3D||j===i.TEXTURE_2D_ARRAY?e.texImage3D(j,X,bt,yt,Nt,C.depth,0,Ct,ht,null):e.texImage2D(j,X,bt,yt,Nt,0,Ct,ht,null)}e.bindFramebuffer(i.FRAMEBUFFER,L),Rt(C)?o.framebufferTexture2DMultisampleEXT(i.FRAMEBUFFER,$,j,et.__webglTexture,0,ct(C)):(j===i.TEXTURE_2D||j>=i.TEXTURE_CUBE_MAP_POSITIVE_X&&j<=i.TEXTURE_CUBE_MAP_NEGATIVE_Z)&&i.framebufferTexture2D(i.FRAMEBUFFER,$,j,et.__webglTexture,X),e.bindFramebuffer(i.FRAMEBUFFER,null)}function xt(L,C,V){if(i.bindRenderbuffer(i.RENDERBUFFER,L),C.depthBuffer){const $=C.depthTexture,j=$&&$.isDepthTexture?$.type:null,X=v(C.stencilBuffer,j),Ct=C.stencilBuffer?i.DEPTH_STENCIL_ATTACHMENT:i.DEPTH_ATTACHMENT,ht=ct(C);Rt(C)?o.renderbufferStorageMultisampleEXT(i.RENDERBUFFER,ht,X,C.width,C.height):V?i.renderbufferStorageMultisample(i.RENDERBUFFER,ht,X,C.width,C.height):i.renderbufferStorage(i.RENDERBUFFER,X,C.width,C.height),i.framebufferRenderbuffer(i.FRAMEBUFFER,Ct,i.RENDERBUFFER,L)}else{const $=C.textures;for(let j=0;j<$.length;j++){const X=$[j],Ct=s.convert(X.format,X.colorSpace),ht=s.convert(X.type),bt=u(X.internalFormat,Ct,ht,X.colorSpace),Pt=ct(C);V&&Rt(C)===!1?i.renderbufferStorageMultisample(i.RENDERBUFFER,Pt,bt,C.width,C.height):Rt(C)?o.renderbufferStorageMultisampleEXT(i.RENDERBUFFER,Pt,bt,C.width,C.height):i.renderbufferStorage(i.RENDERBUFFER,bt,C.width,C.height)}}i.bindRenderbuffer(i.RENDERBUFFER,null)}function lt(L,C){if(C&&C.isWebGLCubeRenderTarget)throw new Error("Depth Texture with cube render targets is not supported");if(e.bindFramebuffer(i.FRAMEBUFFER,L),!(C.depthTexture&&C.depthTexture.isDepthTexture))throw new Error("renderTarget.depthTexture must be an instance of THREE.DepthTexture");const $=n.get(C.depthTexture);$.__renderTarget=C,(!$.__webglTexture||C.depthTexture.image.width!==C.width||C.depthTexture.image.height!==C.height)&&(C.depthTexture.image.width=C.width,C.depthTexture.image.height=C.height,C.depthTexture.needsUpdate=!0),B(C.depthTexture,0);const j=$.__webglTexture,X=ct(C);if(C.depthTexture.format===hs)Rt(C)?o.framebufferTexture2DMultisampleEXT(i.FRAMEBUFFER,i.DEPTH_ATTACHMENT,i.TEXTURE_2D,j,0,X):i.framebufferTexture2D(i.FRAMEBUFFER,i.DEPTH_ATTACHMENT,i.TEXTURE_2D,j,0);else if(C.depthTexture.format===fs)Rt(C)?o.framebufferTexture2DMultisampleEXT(i.FRAMEBUFFER,i.DEPTH_STENCIL_ATTACHMENT,i.TEXTURE_2D,j,0,X):i.framebufferTexture2D(i.FRAMEBUFFER,i.DEPTH_STENCIL_ATTACHMENT,i.TEXTURE_2D,j,0);else throw new Error("Unknown depthTexture format")}function jt(L){const C=n.get(L),V=L.isWebGLCubeRenderTarget===!0;if(C.__boundDepthTexture!==L.depthTexture){const $=L.depthTexture;if(C.__depthDisposeCallback&&C.__depthDisposeCallback(),$){const j=()=>{delete C.__boundDepthTexture,delete C.__depthDisposeCallback,$.removeEventListener("dispose",j)};$.addEventListener("dispose",j),C.__depthDisposeCallback=j}C.__boundDepthTexture=$}if(L.depthTexture&&!C.__autoAllocateDepthBuffer){if(V)throw new Error("target.depthTexture not supported in Cube render targets");const $=L.texture.mipmaps;$&&$.length>0?lt(C.__webglFramebuffer[0],L):lt(C.__webglFramebuffer,L)}else if(V){C.__webglDepthbuffer=[];for(let $=0;$<6;$++)if(e.bindFramebuffer(i.FRAMEBUFFER,C.__webglFramebuffer[$]),C.__webglDepthbuffer[$]===void 0)C.__webglDepthbuffer[$]=i.createRenderbuffer(),xt(C.__webglDepthbuffer[$],L,!1);else{const j=L.stencilBuffer?i.DEPTH_STENCIL_ATTACHMENT:i.DEPTH_ATTACHMENT,X=C.__webglDepthbuffer[$];i.bindRenderbuffer(i.RENDERBUFFER,X),i.framebufferRenderbuffer(i.FRAMEBUFFER,j,i.RENDERBUFFER,X)}}else{const $=L.texture.mipmaps;if($&&$.length>0?e.bindFramebuffer(i.FRAMEBUFFER,C.__webglFramebuffer[0]):e.bindFramebuffer(i.FRAMEBUFFER,C.__webglFramebuffer),C.__webglDepthbuffer===void 0)C.__webglDepthbuffer=i.createRenderbuffer(),xt(C.__webglDepthbuffer,L,!1);else{const j=L.stencilBuffer?i.DEPTH_STENCIL_ATTACHMENT:i.DEPTH_ATTACHMENT,X=C.__webglDepthbuffer;i.bindRenderbuffer(i.RENDERBUFFER,X),i.framebufferRenderbuffer(i.FRAMEBUFFER,j,i.RENDERBUFFER,X)}}e.bindFramebuffer(i.FRAMEBUFFER,null)}function Lt(L,C,V){const $=n.get(L);C!==void 0&&at($.__webglFramebuffer,L,L.texture,i.COLOR_ATTACHMENT0,i.TEXTURE_2D,0),V!==void 0&&jt(L)}function Mt(L){const C=L.texture,V=n.get(L),$=n.get(C);L.addEventListener("dispose",T);const j=L.textures,X=L.isWebGLCubeRenderTarget===!0,Ct=j.length>1;if(Ct||($.__webglTexture===void 0&&($.__webglTexture=i.createTexture()),$.__version=C.version,a.memory.textures++),X){V.__webglFramebuffer=[];for(let ht=0;ht<6;ht++)if(C.mipmaps&&C.mipmaps.length>0){V.__webglFramebuffer[ht]=[];for(let bt=0;bt<C.mipmaps.length;bt++)V.__webglFramebuffer[ht][bt]=i.createFramebuffer()}else V.__webglFramebuffer[ht]=i.createFramebuffer()}else{if(C.mipmaps&&C.mipmaps.length>0){V.__webglFramebuffer=[];for(let ht=0;ht<C.mipmaps.length;ht++)V.__webglFramebuffer[ht]=i.createFramebuffer()}else V.__webglFramebuffer=i.createFramebuffer();if(Ct)for(let ht=0,bt=j.length;ht<bt;ht++){const Pt=n.get(j[ht]);Pt.__webglTexture===void 0&&(Pt.__webglTexture=i.createTexture(),a.memory.textures++)}if(L.samples>0&&Rt(L)===!1){V.__webglMultisampledFramebuffer=i.createFramebuffer(),V.__webglColorRenderbuffer=[],e.bindFramebuffer(i.FRAMEBUFFER,V.__webglMultisampledFramebuffer);for(let ht=0;ht<j.length;ht++){const bt=j[ht];V.__webglColorRenderbuffer[ht]=i.createRenderbuffer(),i.bindRenderbuffer(i.RENDERBUFFER,V.__webglColorRenderbuffer[ht]);const Pt=s.convert(bt.format,bt.colorSpace),et=s.convert(bt.type),yt=u(bt.internalFormat,Pt,et,bt.colorSpace,L.isXRRenderTarget===!0),Nt=ct(L);i.renderbufferStorageMultisample(i.RENDERBUFFER,Nt,yt,L.width,L.height),i.framebufferRenderbuffer(i.FRAMEBUFFER,i.COLOR_ATTACHMENT0+ht,i.RENDERBUFFER,V.__webglColorRenderbuffer[ht])}i.bindRenderbuffer(i.RENDERBUFFER,null),L.depthBuffer&&(V.__webglDepthRenderbuffer=i.createRenderbuffer(),xt(V.__webglDepthRenderbuffer,L,!0)),e.bindFramebuffer(i.FRAMEBUFFER,null)}}if(X){e.bindTexture(i.TEXTURE_CUBE_MAP,$.__webglTexture),pt(i.TEXTURE_CUBE_MAP,C);for(let ht=0;ht<6;ht++)if(C.mipmaps&&C.mipmaps.length>0)for(let bt=0;bt<C.mipmaps.length;bt++)at(V.__webglFramebuffer[ht][bt],L,C,i.COLOR_ATTACHMENT0,i.TEXTURE_CUBE_MAP_POSITIVE_X+ht,bt);else at(V.__webglFramebuffer[ht],L,C,i.COLOR_ATTACHMENT0,i.TEXTURE_CUBE_MAP_POSITIVE_X+ht,0);x(C)&&m(i.TEXTURE_CUBE_MAP),e.unbindTexture()}else if(Ct){for(let ht=0,bt=j.length;ht<bt;ht++){const Pt=j[ht],et=n.get(Pt);e.bindTexture(i.TEXTURE_2D,et.__webglTexture),pt(i.TEXTURE_2D,Pt),at(V.__webglFramebuffer,L,Pt,i.COLOR_ATTACHMENT0+ht,i.TEXTURE_2D,0),x(Pt)&&m(i.TEXTURE_2D)}e.unbindTexture()}else{let ht=i.TEXTURE_2D;if((L.isWebGL3DRenderTarget||L.isWebGLArrayRenderTarget)&&(ht=L.isWebGL3DRenderTarget?i.TEXTURE_3D:i.TEXTURE_2D_ARRAY),e.bindTexture(ht,$.__webglTexture),pt(ht,C),C.mipmaps&&C.mipmaps.length>0)for(let bt=0;bt<C.mipmaps.length;bt++)at(V.__webglFramebuffer[bt],L,C,i.COLOR_ATTACHMENT0,ht,bt);else at(V.__webglFramebuffer,L,C,i.COLOR_ATTACHMENT0,ht,0);x(C)&&m(ht),e.unbindTexture()}L.depthBuffer&&jt(L)}function D(L){const C=L.textures;for(let V=0,$=C.length;V<$;V++){const j=C[V];if(x(j)){const X=d(L),Ct=n.get(j).__webglTexture;e.bindTexture(X,Ct),m(X),e.unbindTexture()}}}const Ft=[],Et=[];function Zt(L){if(L.samples>0){if(Rt(L)===!1){const C=L.textures,V=L.width,$=L.height;let j=i.COLOR_BUFFER_BIT;const X=L.stencilBuffer?i.DEPTH_STENCIL_ATTACHMENT:i.DEPTH_ATTACHMENT,Ct=n.get(L),ht=C.length>1;if(ht)for(let Pt=0;Pt<C.length;Pt++)e.bindFramebuffer(i.FRAMEBUFFER,Ct.__webglMultisampledFramebuffer),i.framebufferRenderbuffer(i.FRAMEBUFFER,i.COLOR_ATTACHMENT0+Pt,i.RENDERBUFFER,null),e.bindFramebuffer(i.FRAMEBUFFER,Ct.__webglFramebuffer),i.framebufferTexture2D(i.DRAW_FRAMEBUFFER,i.COLOR_ATTACHMENT0+Pt,i.TEXTURE_2D,null,0);e.bindFramebuffer(i.READ_FRAMEBUFFER,Ct.__webglMultisampledFramebuffer);const bt=L.texture.mipmaps;bt&&bt.length>0?e.bindFramebuffer(i.DRAW_FRAMEBUFFER,Ct.__webglFramebuffer[0]):e.bindFramebuffer(i.DRAW_FRAMEBUFFER,Ct.__webglFramebuffer);for(let Pt=0;Pt<C.length;Pt++){if(L.resolveDepthBuffer&&(L.depthBuffer&&(j|=i.DEPTH_BUFFER_BIT),L.stencilBuffer&&L.resolveStencilBuffer&&(j|=i.STENCIL_BUFFER_BIT)),ht){i.framebufferRenderbuffer(i.READ_FRAMEBUFFER,i.COLOR_ATTACHMENT0,i.RENDERBUFFER,Ct.__webglColorRenderbuffer[Pt]);const et=n.get(C[Pt]).__webglTexture;i.framebufferTexture2D(i.DRAW_FRAMEBUFFER,i.COLOR_ATTACHMENT0,i.TEXTURE_2D,et,0)}i.blitFramebuffer(0,0,V,$,0,0,V,$,j,i.NEAREST),c===!0&&(Ft.length=0,Et.length=0,Ft.push(i.COLOR_ATTACHMENT0+Pt),L.depthBuffer&&L.resolveDepthBuffer===!1&&(Ft.push(X),Et.push(X),i.invalidateFramebuffer(i.DRAW_FRAMEBUFFER,Et)),i.invalidateFramebuffer(i.READ_FRAMEBUFFER,Ft))}if(e.bindFramebuffer(i.READ_FRAMEBUFFER,null),e.bindFramebuffer(i.DRAW_FRAMEBUFFER,null),ht)for(let Pt=0;Pt<C.length;Pt++){e.bindFramebuffer(i.FRAMEBUFFER,Ct.__webglMultisampledFramebuffer),i.framebufferRenderbuffer(i.FRAMEBUFFER,i.COLOR_ATTACHMENT0+Pt,i.RENDERBUFFER,Ct.__webglColorRenderbuffer[Pt]);const et=n.get(C[Pt]).__webglTexture;e.bindFramebuffer(i.FRAMEBUFFER,Ct.__webglFramebuffer),i.framebufferTexture2D(i.DRAW_FRAMEBUFFER,i.COLOR_ATTACHMENT0+Pt,i.TEXTURE_2D,et,0)}e.bindFramebuffer(i.DRAW_FRAMEBUFFER,Ct.__webglMultisampledFramebuffer)}else if(L.depthBuffer&&L.resolveDepthBuffer===!1&&c){const C=L.stencilBuffer?i.DEPTH_STENCIL_ATTACHMENT:i.DEPTH_ATTACHMENT;i.invalidateFramebuffer(i.DRAW_FRAMEBUFFER,[C])}}}function ct(L){return Math.min(r.maxSamples,L.samples)}function Rt(L){const C=n.get(L);return L.samples>0&&t.has("WEBGL_multisampled_render_to_texture")===!0&&C.__useRenderToTexture!==!1}function ut(L){const C=a.render.frame;f.get(L)!==C&&(f.set(L,C),L.update())}function vt(L,C){const V=L.colorSpace,$=L.format,j=L.type;return L.isCompressedTexture===!0||L.isVideoTexture===!0||V!==Rr&&V!==ri&&(Jt.getTransfer(V)===re?($!==Ke||j!==Ln)&&console.warn("THREE.WebGLTextures: sRGB encoded textures have to use RGBAFormat and UnsignedByteType."):console.error("THREE.WebGLTextures: Unsupported texture color space:",V)),C}function zt(L){return typeof HTMLImageElement<"u"&&L instanceof HTMLImageElement?(h.width=L.naturalWidth||L.width,h.height=L.naturalHeight||L.height):typeof VideoFrame<"u"&&L instanceof VideoFrame?(h.width=L.displayWidth,h.height=L.displayHeight):(h.width=L.width,h.height=L.height),h}this.allocateTextureUnit=I,this.resetTextureUnits=w,this.setTexture2D=B,this.setTexture2DArray=F,this.setTexture3D=k,this.setTextureCube=z,this.rebindTextures=Lt,this.setupRenderTarget=Mt,this.updateRenderTargetMipmap=D,this.updateMultisampleRenderTarget=Zt,this.setupDepthRenderbuffer=jt,this.setupFrameBufferTexture=at,this.useMultisampledRTT=Rt}function Sv(i,t){function e(n,r=ri){let s;const a=Jt.getTransfer(r);if(n===Ln)return i.UNSIGNED_BYTE;if(n===Tl)return i.UNSIGNED_SHORT_4_4_4_4;if(n===bl)return i.UNSIGNED_SHORT_5_5_5_1;if(n===rf)return i.UNSIGNED_INT_5_9_9_9_REV;if(n===ef)return i.BYTE;if(n===nf)return i.SHORT;if(n===ls)return i.UNSIGNED_SHORT;if(n===El)return i.INT;if(n===di)return i.UNSIGNED_INT;if(n===yn)return i.FLOAT;if(n===_s)return i.HALF_FLOAT;if(n===sf)return i.ALPHA;if(n===of)return i.RGB;if(n===Ke)return i.RGBA;if(n===hs)return i.DEPTH_COMPONENT;if(n===fs)return i.DEPTH_STENCIL;if(n===af)return i.RED;if(n===qo)return i.RED_INTEGER;if(n===cf)return i.RG;if(n===Al)return i.RG_INTEGER;if(n===wl)return i.RGBA_INTEGER;if(n===yo||n===So||n===Mo||n===Eo)if(a===re)if(s=t.get("WEBGL_compressed_texture_s3tc_srgb"),s!==null){if(n===yo)return s.COMPRESSED_SRGB_S3TC_DXT1_EXT;if(n===So)return s.COMPRESSED_SRGB_ALPHA_S3TC_DXT1_EXT;if(n===Mo)return s.COMPRESSED_SRGB_ALPHA_S3TC_DXT3_EXT;if(n===Eo)return s.COMPRESSED_SRGB_ALPHA_S3TC_DXT5_EXT}else return null;else if(s=t.get("WEBGL_compressed_texture_s3tc"),s!==null){if(n===yo)return s.COMPRESSED_RGB_S3TC_DXT1_EXT;if(n===So)return s.COMPRESSED_RGBA_S3TC_DXT1_EXT;if(n===Mo)return s.COMPRESSED_RGBA_S3TC_DXT3_EXT;if(n===Eo)return s.COMPRESSED_RGBA_S3TC_DXT5_EXT}else return null;if(n===Fc||n===Bc||n===Oc||n===zc)if(s=t.get("WEBGL_compressed_texture_pvrtc"),s!==null){if(n===Fc)return s.COMPRESSED_RGB_PVRTC_4BPPV1_IMG;if(n===Bc)return s.COMPRESSED_RGB_PVRTC_2BPPV1_IMG;if(n===Oc)return s.COMPRESSED_RGBA_PVRTC_4BPPV1_IMG;if(n===zc)return s.COMPRESSED_RGBA_PVRTC_2BPPV1_IMG}else return null;if(n===Vc||n===Hc||n===Gc)if(s=t.get("WEBGL_compressed_texture_etc"),s!==null){if(n===Vc||n===Hc)return a===re?s.COMPRESSED_SRGB8_ETC2:s.COMPRESSED_RGB8_ETC2;if(n===Gc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ETC2_EAC:s.COMPRESSED_RGBA8_ETC2_EAC}else return null;if(n===kc||n===Wc||n===Xc||n===qc||n===Yc||n===$c||n===jc||n===Kc||n===Zc||n===Jc||n===Qc||n===tl||n===el||n===nl)if(s=t.get("WEBGL_compressed_texture_astc"),s!==null){if(n===kc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_4x4_KHR:s.COMPRESSED_RGBA_ASTC_4x4_KHR;if(n===Wc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_5x4_KHR:s.COMPRESSED_RGBA_ASTC_5x4_KHR;if(n===Xc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_5x5_KHR:s.COMPRESSED_RGBA_ASTC_5x5_KHR;if(n===qc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_6x5_KHR:s.COMPRESSED_RGBA_ASTC_6x5_KHR;if(n===Yc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_6x6_KHR:s.COMPRESSED_RGBA_ASTC_6x6_KHR;if(n===$c)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_8x5_KHR:s.COMPRESSED_RGBA_ASTC_8x5_KHR;if(n===jc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_8x6_KHR:s.COMPRESSED_RGBA_ASTC_8x6_KHR;if(n===Kc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_8x8_KHR:s.COMPRESSED_RGBA_ASTC_8x8_KHR;if(n===Zc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_10x5_KHR:s.COMPRESSED_RGBA_ASTC_10x5_KHR;if(n===Jc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_10x6_KHR:s.COMPRESSED_RGBA_ASTC_10x6_KHR;if(n===Qc)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_10x8_KHR:s.COMPRESSED_RGBA_ASTC_10x8_KHR;if(n===tl)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_10x10_KHR:s.COMPRESSED_RGBA_ASTC_10x10_KHR;if(n===el)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_12x10_KHR:s.COMPRESSED_RGBA_ASTC_12x10_KHR;if(n===nl)return a===re?s.COMPRESSED_SRGB8_ALPHA8_ASTC_12x12_KHR:s.COMPRESSED_RGBA_ASTC_12x12_KHR}else return null;if(n===To||n===il||n===rl)if(s=t.get("EXT_texture_compression_bptc"),s!==null){if(n===To)return a===re?s.COMPRESSED_SRGB_ALPHA_BPTC_UNORM_EXT:s.COMPRESSED_RGBA_BPTC_UNORM_EXT;if(n===il)return s.COMPRESSED_RGB_BPTC_SIGNED_FLOAT_EXT;if(n===rl)return s.COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT_EXT}else return null;if(n===lf||n===sl||n===ol||n===al)if(s=t.get("EXT_texture_compression_rgtc"),s!==null){if(n===To)return s.COMPRESSED_RED_RGTC1_EXT;if(n===sl)return s.COMPRESSED_SIGNED_RED_RGTC1_EXT;if(n===ol)return s.COMPRESSED_RED_GREEN_RGTC2_EXT;if(n===al)return s.COMPRESSED_SIGNED_RED_GREEN_RGTC2_EXT}else return null;return n===us?i.UNSIGNED_INT_24_8:i[n]!==void 0?i[n]:null}return{convert:e}}const Mv=`
void main() {

	gl_Position = vec4( position, 1.0 );

}`,Ev=`
uniform sampler2DArray depthColor;
uniform float depthWidth;
uniform float depthHeight;

void main() {

	vec2 coord = vec2( gl_FragCoord.x / depthWidth, gl_FragCoord.y / depthHeight );

	if ( coord.x >= 1.0 ) {

		gl_FragDepth = texture( depthColor, vec3( coord.x - 1.0, coord.y, 1 ) ).r;

	} else {

		gl_FragDepth = texture( depthColor, vec3( coord.x, coord.y, 0 ) ).r;

	}

}`;class Tv{constructor(){this.texture=null,this.mesh=null,this.depthNear=0,this.depthFar=0}init(t,e,n){if(this.texture===null){const r=new Le,s=t.properties.get(r);s.__webglTexture=e.texture,(e.depthNear!==n.depthNear||e.depthFar!==n.depthFar)&&(this.depthNear=e.depthNear,this.depthFar=e.depthFar),this.texture=r}}getMesh(t){if(this.texture!==null&&this.mesh===null){const e=t.cameras[0].viewport,n=new pi({vertexShader:Mv,fragmentShader:Ev,uniforms:{depthColor:{value:this.texture},depthWidth:{value:e.z},depthHeight:{value:e.w}}});this.mesh=new Ie(new Ms(20,20),n)}return this.mesh}reset(){this.texture=null,this.mesh=null}getDepthTexture(){return this.texture}}class bv extends Ir{constructor(t,e){super();const n=this;let r=null,s=1,a=null,o="local-floor",c=1,h=null,f=null,g=null,p=null,_=null,M=null;const b=new Tv,x=e.getContextAttributes();let m=null,d=null;const u=[],v=[],l=new kt;let R=null;const T=new sn;T.viewport=new ie;const E=new sn;E.viewport=new ie;const y=[T,E],S=new Xp;let A=null,w=null;this.cameraAutoUpdate=!0,this.enabled=!1,this.isPresenting=!1,this.getController=function(W){let tt=u[W];return tt===void 0&&(tt=new Ea,u[W]=tt),tt.getTargetRaySpace()},this.getControllerGrip=function(W){let tt=u[W];return tt===void 0&&(tt=new Ea,u[W]=tt),tt.getGripSpace()},this.getHand=function(W){let tt=u[W];return tt===void 0&&(tt=new Ea,u[W]=tt),tt.getHandSpace()};function I(W){const tt=v.indexOf(W.inputSource);if(tt===-1)return;const st=u[tt];st!==void 0&&(st.update(W.inputSource,W.frame,h||a),st.dispatchEvent({type:W.type,data:W.inputSource}))}function N(){r.removeEventListener("select",I),r.removeEventListener("selectstart",I),r.removeEventListener("selectend",I),r.removeEventListener("squeeze",I),r.removeEventListener("squeezestart",I),r.removeEventListener("squeezeend",I),r.removeEventListener("end",N),r.removeEventListener("inputsourceschange",B);for(let W=0;W<u.length;W++){const tt=v[W];tt!==null&&(v[W]=null,u[W].disconnect(tt))}A=null,w=null,b.reset(),t.setRenderTarget(m),_=null,p=null,g=null,r=null,d=null,_t.stop(),n.isPresenting=!1,t.setPixelRatio(R),t.setSize(l.width,l.height,!1),n.dispatchEvent({type:"sessionend"})}this.setFramebufferScaleFactor=function(W){s=W,n.isPresenting===!0&&console.warn("THREE.WebXRManager: Cannot change framebuffer scale while presenting.")},this.setReferenceSpaceType=function(W){o=W,n.isPresenting===!0&&console.warn("THREE.WebXRManager: Cannot change reference space type while presenting.")},this.getReferenceSpace=function(){return h||a},this.setReferenceSpace=function(W){h=W},this.getBaseLayer=function(){return p!==null?p:_},this.getBinding=function(){return g},this.getFrame=function(){return M},this.getSession=function(){return r},this.setSession=async function(W){if(r=W,r!==null){if(m=t.getRenderTarget(),r.addEventListener("select",I),r.addEventListener("selectstart",I),r.addEventListener("selectend",I),r.addEventListener("squeeze",I),r.addEventListener("squeezestart",I),r.addEventListener("squeezeend",I),r.addEventListener("end",N),r.addEventListener("inputsourceschange",B),x.xrCompatible!==!0&&await e.makeXRCompatible(),R=t.getPixelRatio(),t.getSize(l),typeof XRWebGLBinding<"u"&&"createProjectionLayer"in XRWebGLBinding.prototype){let st=null,Q=null,at=null;x.depth&&(at=x.stencil?e.DEPTH24_STENCIL8:e.DEPTH_COMPONENT24,st=x.stencil?fs:hs,Q=x.stencil?us:di);const xt={colorFormat:e.RGBA8,depthFormat:at,scaleFactor:s};g=new XRWebGLBinding(r,e),p=g.createProjectionLayer(xt),r.updateRenderState({layers:[p]}),t.setPixelRatio(1),t.setSize(p.textureWidth,p.textureHeight,!1),d=new Vi(p.textureWidth,p.textureHeight,{format:Ke,type:Ln,depthTexture:new Mf(p.textureWidth,p.textureHeight,Q,void 0,void 0,void 0,void 0,void 0,void 0,st),stencilBuffer:x.stencil,colorSpace:t.outputColorSpace,samples:x.antialias?4:0,resolveDepthBuffer:p.ignoreDepthValues===!1,resolveStencilBuffer:p.ignoreDepthValues===!1})}else{const st={antialias:x.antialias,alpha:!0,depth:x.depth,stencil:x.stencil,framebufferScaleFactor:s};_=new XRWebGLLayer(r,e,st),r.updateRenderState({baseLayer:_}),t.setPixelRatio(1),t.setSize(_.framebufferWidth,_.framebufferHeight,!1),d=new Vi(_.framebufferWidth,_.framebufferHeight,{format:Ke,type:Ln,colorSpace:t.outputColorSpace,stencilBuffer:x.stencil,resolveDepthBuffer:_.ignoreDepthValues===!1,resolveStencilBuffer:_.ignoreDepthValues===!1})}d.isXRRenderTarget=!0,this.setFoveation(c),h=null,a=await r.requestReferenceSpace(o),_t.setContext(r),_t.start(),n.isPresenting=!0,n.dispatchEvent({type:"sessionstart"})}},this.getEnvironmentBlendMode=function(){if(r!==null)return r.environmentBlendMode},this.getDepthTexture=function(){return b.getDepthTexture()};function B(W){for(let tt=0;tt<W.removed.length;tt++){const st=W.removed[tt],Q=v.indexOf(st);Q>=0&&(v[Q]=null,u[Q].disconnect(st))}for(let tt=0;tt<W.added.length;tt++){const st=W.added[tt];let Q=v.indexOf(st);if(Q===-1){for(let xt=0;xt<u.length;xt++)if(xt>=v.length){v.push(st),Q=xt;break}else if(v[xt]===null){v[xt]=st,Q=xt;break}if(Q===-1)break}const at=u[Q];at&&at.connect(st)}}const F=new U,k=new U;function z(W,tt,st){F.setFromMatrixPosition(tt.matrixWorld),k.setFromMatrixPosition(st.matrixWorld);const Q=F.distanceTo(k),at=tt.projectionMatrix.elements,xt=st.projectionMatrix.elements,lt=at[14]/(at[10]-1),jt=at[14]/(at[10]+1),Lt=(at[9]+1)/at[5],Mt=(at[9]-1)/at[5],D=(at[8]-1)/at[0],Ft=(xt[8]+1)/xt[0],Et=lt*D,Zt=lt*Ft,ct=Q/(-D+Ft),Rt=ct*-D;if(tt.matrixWorld.decompose(W.position,W.quaternion,W.scale),W.translateX(Rt),W.translateZ(ct),W.matrixWorld.compose(W.position,W.quaternion,W.scale),W.matrixWorldInverse.copy(W.matrixWorld).invert(),at[10]===-1)W.projectionMatrix.copy(tt.projectionMatrix),W.projectionMatrixInverse.copy(tt.projectionMatrixInverse);else{const ut=lt+ct,vt=jt+ct,zt=Et-Rt,L=Zt+(Q-Rt),C=Lt*jt/vt*ut,V=Mt*jt/vt*ut;W.projectionMatrix.makePerspective(zt,L,C,V,ut,vt),W.projectionMatrixInverse.copy(W.projectionMatrix).invert()}}function J(W,tt){tt===null?W.matrixWorld.copy(W.matrix):W.matrixWorld.multiplyMatrices(tt.matrixWorld,W.matrix),W.matrixWorldInverse.copy(W.matrixWorld).invert()}this.updateCamera=function(W){if(r===null)return;let tt=W.near,st=W.far;b.texture!==null&&(b.depthNear>0&&(tt=b.depthNear),b.depthFar>0&&(st=b.depthFar)),S.near=E.near=T.near=tt,S.far=E.far=T.far=st,(A!==S.near||w!==S.far)&&(r.updateRenderState({depthNear:S.near,depthFar:S.far}),A=S.near,w=S.far),T.layers.mask=W.layers.mask|2,E.layers.mask=W.layers.mask|4,S.layers.mask=T.layers.mask|E.layers.mask;const Q=W.parent,at=S.cameras;J(S,Q);for(let xt=0;xt<at.length;xt++)J(at[xt],Q);at.length===2?z(S,T,E):S.projectionMatrix.copy(T.projectionMatrix),Z(W,S,Q)};function Z(W,tt,st){st===null?W.matrix.copy(tt.matrixWorld):(W.matrix.copy(st.matrixWorld),W.matrix.invert(),W.matrix.multiply(tt.matrixWorld)),W.matrix.decompose(W.position,W.quaternion,W.scale),W.updateMatrixWorld(!0),W.projectionMatrix.copy(tt.projectionMatrix),W.projectionMatrixInverse.copy(tt.projectionMatrixInverse),W.isPerspectiveCamera&&(W.fov=cl*2*Math.atan(1/W.projectionMatrix.elements[5]),W.zoom=1)}this.getCamera=function(){return S},this.getFoveation=function(){if(!(p===null&&_===null))return c},this.setFoveation=function(W){c=W,p!==null&&(p.fixedFoveation=W),_!==null&&_.fixedFoveation!==void 0&&(_.fixedFoveation=W)},this.hasDepthSensing=function(){return b.texture!==null},this.getDepthSensingMesh=function(){return b.getMesh(S)};let it=null;function pt(W,tt){if(f=tt.getViewerPose(h||a),M=tt,f!==null){const st=f.views;_!==null&&(t.setRenderTargetFramebuffer(d,_.framebuffer),t.setRenderTarget(d));let Q=!1;st.length!==S.cameras.length&&(S.cameras.length=0,Q=!0);for(let lt=0;lt<st.length;lt++){const jt=st[lt];let Lt=null;if(_!==null)Lt=_.getViewport(jt);else{const D=g.getViewSubImage(p,jt);Lt=D.viewport,lt===0&&(t.setRenderTargetTextures(d,D.colorTexture,D.depthStencilTexture),t.setRenderTarget(d))}let Mt=y[lt];Mt===void 0&&(Mt=new sn,Mt.layers.enable(lt),Mt.viewport=new ie,y[lt]=Mt),Mt.matrix.fromArray(jt.transform.matrix),Mt.matrix.decompose(Mt.position,Mt.quaternion,Mt.scale),Mt.projectionMatrix.fromArray(jt.projectionMatrix),Mt.projectionMatrixInverse.copy(Mt.projectionMatrix).invert(),Mt.viewport.set(Lt.x,Lt.y,Lt.width,Lt.height),lt===0&&(S.matrix.copy(Mt.matrix),S.matrix.decompose(S.position,S.quaternion,S.scale)),Q===!0&&S.cameras.push(Mt)}const at=r.enabledFeatures;if(at&&at.includes("depth-sensing")&&r.depthUsage=="gpu-optimized"&&g){const lt=g.getDepthInformation(st[0]);lt&&lt.isValid&&lt.texture&&b.init(t,lt,r.renderState)}}for(let st=0;st<u.length;st++){const Q=v[st],at=u[st];Q!==null&&at!==void 0&&at.update(Q,tt,h||a)}it&&it(W,tt),tt.detectedPlanes&&n.dispatchEvent({type:"planesdetected",data:tt}),M=null}const _t=new wf;_t.setAnimationLoop(pt),this.setAnimationLoop=function(W){it=W},this.dispose=function(){}}}const bi=new Dn,Av=new $t;function wv(i,t){function e(x,m){x.matrixAutoUpdate===!0&&x.updateMatrix(),m.value.copy(x.matrix)}function n(x,m){m.color.getRGB(x.fogColor.value,xf(i)),m.isFog?(x.fogNear.value=m.near,x.fogFar.value=m.far):m.isFogExp2&&(x.fogDensity.value=m.density)}function r(x,m,d,u,v){m.isMeshBasicMaterial||m.isMeshLambertMaterial?s(x,m):m.isMeshToonMaterial?(s(x,m),g(x,m)):m.isMeshPhongMaterial?(s(x,m),f(x,m)):m.isMeshStandardMaterial?(s(x,m),p(x,m),m.isMeshPhysicalMaterial&&_(x,m,v)):m.isMeshMatcapMaterial?(s(x,m),M(x,m)):m.isMeshDepthMaterial?s(x,m):m.isMeshDistanceMaterial?(s(x,m),b(x,m)):m.isMeshNormalMaterial?s(x,m):m.isLineBasicMaterial?(a(x,m),m.isLineDashedMaterial&&o(x,m)):m.isPointsMaterial?c(x,m,d,u):m.isSpriteMaterial?h(x,m):m.isShadowMaterial?(x.color.value.copy(m.color),x.opacity.value=m.opacity):m.isShaderMaterial&&(m.uniformsNeedUpdate=!1)}function s(x,m){x.opacity.value=m.opacity,m.color&&x.diffuse.value.copy(m.color),m.emissive&&x.emissive.value.copy(m.emissive).multiplyScalar(m.emissiveIntensity),m.map&&(x.map.value=m.map,e(m.map,x.mapTransform)),m.alphaMap&&(x.alphaMap.value=m.alphaMap,e(m.alphaMap,x.alphaMapTransform)),m.bumpMap&&(x.bumpMap.value=m.bumpMap,e(m.bumpMap,x.bumpMapTransform),x.bumpScale.value=m.bumpScale,m.side===ze&&(x.bumpScale.value*=-1)),m.normalMap&&(x.normalMap.value=m.normalMap,e(m.normalMap,x.normalMapTransform),x.normalScale.value.copy(m.normalScale),m.side===ze&&x.normalScale.value.negate()),m.displacementMap&&(x.displacementMap.value=m.displacementMap,e(m.displacementMap,x.displacementMapTransform),x.displacementScale.value=m.displacementScale,x.displacementBias.value=m.displacementBias),m.emissiveMap&&(x.emissiveMap.value=m.emissiveMap,e(m.emissiveMap,x.emissiveMapTransform)),m.specularMap&&(x.specularMap.value=m.specularMap,e(m.specularMap,x.specularMapTransform)),m.alphaTest>0&&(x.alphaTest.value=m.alphaTest);const d=t.get(m),u=d.envMap,v=d.envMapRotation;u&&(x.envMap.value=u,bi.copy(v),bi.x*=-1,bi.y*=-1,bi.z*=-1,u.isCubeTexture&&u.isRenderTargetTexture===!1&&(bi.y*=-1,bi.z*=-1),x.envMapRotation.value.setFromMatrix4(Av.makeRotationFromEuler(bi)),x.flipEnvMap.value=u.isCubeTexture&&u.isRenderTargetTexture===!1?-1:1,x.reflectivity.value=m.reflectivity,x.ior.value=m.ior,x.refractionRatio.value=m.refractionRatio),m.lightMap&&(x.lightMap.value=m.lightMap,x.lightMapIntensity.value=m.lightMapIntensity,e(m.lightMap,x.lightMapTransform)),m.aoMap&&(x.aoMap.value=m.aoMap,x.aoMapIntensity.value=m.aoMapIntensity,e(m.aoMap,x.aoMapTransform))}function a(x,m){x.diffuse.value.copy(m.color),x.opacity.value=m.opacity,m.map&&(x.map.value=m.map,e(m.map,x.mapTransform))}function o(x,m){x.dashSize.value=m.dashSize,x.totalSize.value=m.dashSize+m.gapSize,x.scale.value=m.scale}function c(x,m,d,u){x.diffuse.value.copy(m.color),x.opacity.value=m.opacity,x.size.value=m.size*d,x.scale.value=u*.5,m.map&&(x.map.value=m.map,e(m.map,x.uvTransform)),m.alphaMap&&(x.alphaMap.value=m.alphaMap,e(m.alphaMap,x.alphaMapTransform)),m.alphaTest>0&&(x.alphaTest.value=m.alphaTest)}function h(x,m){x.diffuse.value.copy(m.color),x.opacity.value=m.opacity,x.rotation.value=m.rotation,m.map&&(x.map.value=m.map,e(m.map,x.mapTransform)),m.alphaMap&&(x.alphaMap.value=m.alphaMap,e(m.alphaMap,x.alphaMapTransform)),m.alphaTest>0&&(x.alphaTest.value=m.alphaTest)}function f(x,m){x.specular.value.copy(m.specular),x.shininess.value=Math.max(m.shininess,1e-4)}function g(x,m){m.gradientMap&&(x.gradientMap.value=m.gradientMap)}function p(x,m){x.metalness.value=m.metalness,m.metalnessMap&&(x.metalnessMap.value=m.metalnessMap,e(m.metalnessMap,x.metalnessMapTransform)),x.roughness.value=m.roughness,m.roughnessMap&&(x.roughnessMap.value=m.roughnessMap,e(m.roughnessMap,x.roughnessMapTransform)),m.envMap&&(x.envMapIntensity.value=m.envMapIntensity)}function _(x,m,d){x.ior.value=m.ior,m.sheen>0&&(x.sheenColor.value.copy(m.sheenColor).multiplyScalar(m.sheen),x.sheenRoughness.value=m.sheenRoughness,m.sheenColorMap&&(x.sheenColorMap.value=m.sheenColorMap,e(m.sheenColorMap,x.sheenColorMapTransform)),m.sheenRoughnessMap&&(x.sheenRoughnessMap.value=m.sheenRoughnessMap,e(m.sheenRoughnessMap,x.sheenRoughnessMapTransform))),m.clearcoat>0&&(x.clearcoat.value=m.clearcoat,x.clearcoatRoughness.value=m.clearcoatRoughness,m.clearcoatMap&&(x.clearcoatMap.value=m.clearcoatMap,e(m.clearcoatMap,x.clearcoatMapTransform)),m.clearcoatRoughnessMap&&(x.clearcoatRoughnessMap.value=m.clearcoatRoughnessMap,e(m.clearcoatRoughnessMap,x.clearcoatRoughnessMapTransform)),m.clearcoatNormalMap&&(x.clearcoatNormalMap.value=m.clearcoatNormalMap,e(m.clearcoatNormalMap,x.clearcoatNormalMapTransform),x.clearcoatNormalScale.value.copy(m.clearcoatNormalScale),m.side===ze&&x.clearcoatNormalScale.value.negate())),m.dispersion>0&&(x.dispersion.value=m.dispersion),m.iridescence>0&&(x.iridescence.value=m.iridescence,x.iridescenceIOR.value=m.iridescenceIOR,x.iridescenceThicknessMinimum.value=m.iridescenceThicknessRange[0],x.iridescenceThicknessMaximum.value=m.iridescenceThicknessRange[1],m.iridescenceMap&&(x.iridescenceMap.value=m.iridescenceMap,e(m.iridescenceMap,x.iridescenceMapTransform)),m.iridescenceThicknessMap&&(x.iridescenceThicknessMap.value=m.iridescenceThicknessMap,e(m.iridescenceThicknessMap,x.iridescenceThicknessMapTransform))),m.transmission>0&&(x.transmission.value=m.transmission,x.transmissionSamplerMap.value=d.texture,x.transmissionSamplerSize.value.set(d.width,d.height),m.transmissionMap&&(x.transmissionMap.value=m.transmissionMap,e(m.transmissionMap,x.transmissionMapTransform)),x.thickness.value=m.thickness,m.thicknessMap&&(x.thicknessMap.value=m.thicknessMap,e(m.thicknessMap,x.thicknessMapTransform)),x.attenuationDistance.value=m.attenuationDistance,x.attenuationColor.value.copy(m.attenuationColor)),m.anisotropy>0&&(x.anisotropyVector.value.set(m.anisotropy*Math.cos(m.anisotropyRotation),m.anisotropy*Math.sin(m.anisotropyRotation)),m.anisotropyMap&&(x.anisotropyMap.value=m.anisotropyMap,e(m.anisotropyMap,x.anisotropyMapTransform))),x.specularIntensity.value=m.specularIntensity,x.specularColor.value.copy(m.specularColor),m.specularColorMap&&(x.specularColorMap.value=m.specularColorMap,e(m.specularColorMap,x.specularColorMapTransform)),m.specularIntensityMap&&(x.specularIntensityMap.value=m.specularIntensityMap,e(m.specularIntensityMap,x.specularIntensityMapTransform))}function M(x,m){m.matcap&&(x.matcap.value=m.matcap)}function b(x,m){const d=t.get(m).light;x.referencePosition.value.setFromMatrixPosition(d.matrixWorld),x.nearDistance.value=d.shadow.camera.near,x.farDistance.value=d.shadow.camera.far}return{refreshFogUniforms:n,refreshMaterialUniforms:r}}function Rv(i,t,e,n){let r={},s={},a=[];const o=i.getParameter(i.MAX_UNIFORM_BUFFER_BINDINGS);function c(d,u){const v=u.program;n.uniformBlockBinding(d,v)}function h(d,u){let v=r[d.id];v===void 0&&(M(d),v=f(d),r[d.id]=v,d.addEventListener("dispose",x));const l=u.program;n.updateUBOMapping(d,l);const R=t.render.frame;s[d.id]!==R&&(p(d),s[d.id]=R)}function f(d){const u=g();d.__bindingPointIndex=u;const v=i.createBuffer(),l=d.__size,R=d.usage;return i.bindBuffer(i.UNIFORM_BUFFER,v),i.bufferData(i.UNIFORM_BUFFER,l,R),i.bindBuffer(i.UNIFORM_BUFFER,null),i.bindBufferBase(i.UNIFORM_BUFFER,u,v),v}function g(){for(let d=0;d<o;d++)if(a.indexOf(d)===-1)return a.push(d),d;return console.error("THREE.WebGLRenderer: Maximum number of simultaneously usable uniforms groups reached."),0}function p(d){const u=r[d.id],v=d.uniforms,l=d.__cache;i.bindBuffer(i.UNIFORM_BUFFER,u);for(let R=0,T=v.length;R<T;R++){const E=Array.isArray(v[R])?v[R]:[v[R]];for(let y=0,S=E.length;y<S;y++){const A=E[y];if(_(A,R,y,l)===!0){const w=A.__offset,I=Array.isArray(A.value)?A.value:[A.value];let N=0;for(let B=0;B<I.length;B++){const F=I[B],k=b(F);typeof F=="number"||typeof F=="boolean"?(A.__data[0]=F,i.bufferSubData(i.UNIFORM_BUFFER,w+N,A.__data)):F.isMatrix3?(A.__data[0]=F.elements[0],A.__data[1]=F.elements[1],A.__data[2]=F.elements[2],A.__data[3]=0,A.__data[4]=F.elements[3],A.__data[5]=F.elements[4],A.__data[6]=F.elements[5],A.__data[7]=0,A.__data[8]=F.elements[6],A.__data[9]=F.elements[7],A.__data[10]=F.elements[8],A.__data[11]=0):(F.toArray(A.__data,N),N+=k.storage/Float32Array.BYTES_PER_ELEMENT)}i.bufferSubData(i.UNIFORM_BUFFER,w,A.__data)}}}i.bindBuffer(i.UNIFORM_BUFFER,null)}function _(d,u,v,l){const R=d.value,T=u+"_"+v;if(l[T]===void 0)return typeof R=="number"||typeof R=="boolean"?l[T]=R:l[T]=R.clone(),!0;{const E=l[T];if(typeof R=="number"||typeof R=="boolean"){if(E!==R)return l[T]=R,!0}else if(E.equals(R)===!1)return E.copy(R),!0}return!1}function M(d){const u=d.uniforms;let v=0;const l=16;for(let T=0,E=u.length;T<E;T++){const y=Array.isArray(u[T])?u[T]:[u[T]];for(let S=0,A=y.length;S<A;S++){const w=y[S],I=Array.isArray(w.value)?w.value:[w.value];for(let N=0,B=I.length;N<B;N++){const F=I[N],k=b(F),z=v%l,J=z%k.boundary,Z=z+J;v+=J,Z!==0&&l-Z<k.storage&&(v+=l-Z),w.__data=new Float32Array(k.storage/Float32Array.BYTES_PER_ELEMENT),w.__offset=v,v+=k.storage}}}const R=v%l;return R>0&&(v+=l-R),d.__size=v,d.__cache={},this}function b(d){const u={boundary:0,storage:0};return typeof d=="number"||typeof d=="boolean"?(u.boundary=4,u.storage=4):d.isVector2?(u.boundary=8,u.storage=8):d.isVector3||d.isColor?(u.boundary=16,u.storage=12):d.isVector4?(u.boundary=16,u.storage=16):d.isMatrix3?(u.boundary=48,u.storage=48):d.isMatrix4?(u.boundary=64,u.storage=64):d.isTexture?console.warn("THREE.WebGLRenderer: Texture samplers can not be part of an uniforms group."):console.warn("THREE.WebGLRenderer: Unsupported uniform value type.",d),u}function x(d){const u=d.target;u.removeEventListener("dispose",x);const v=a.indexOf(u.__bindingPointIndex);a.splice(v,1),i.deleteBuffer(r[u.id]),delete r[u.id],delete s[u.id]}function m(){for(const d in r)i.deleteBuffer(r[d]);a=[],r={},s={}}return{bind:c,update:h,dispose:m}}class Cv{constructor(t={}){const{canvas:e=Jd(),context:n=null,depth:r=!0,stencil:s=!1,alpha:a=!1,antialias:o=!1,premultipliedAlpha:c=!0,preserveDrawingBuffer:h=!1,powerPreference:f="default",failIfMajorPerformanceCaveat:g=!1,reverseDepthBuffer:p=!1}=t;this.isWebGLRenderer=!0;let _;if(n!==null){if(typeof WebGLRenderingContext<"u"&&n instanceof WebGLRenderingContext)throw new Error("THREE.WebGLRenderer: WebGL 1 is not supported since r163.");_=n.getContextAttributes().alpha}else _=a;const M=new Uint32Array(4),b=new Int32Array(4);let x=null,m=null;const d=[],u=[];this.domElement=e,this.debug={checkShaderErrors:!0,onShaderError:null},this.autoClear=!0,this.autoClearColor=!0,this.autoClearDepth=!0,this.autoClearStencil=!0,this.sortObjects=!0,this.clippingPlanes=[],this.localClippingEnabled=!1,this.toneMapping=ui,this.toneMappingExposure=1,this.transmissionResolutionScale=1;const v=this;let l=!1;this._outputColorSpace=rn;let R=0,T=0,E=null,y=-1,S=null;const A=new ie,w=new ie;let I=null;const N=new qt(0);let B=0,F=e.width,k=e.height,z=1,J=null,Z=null;const it=new ie(0,0,F,k),pt=new ie(0,0,F,k);let _t=!1;const W=new Ss;let tt=!1,st=!1;const Q=new $t,at=new $t,xt=new U,lt=new ie,jt={background:null,fog:null,environment:null,overrideMaterial:null,isScene:!0};let Lt=!1;function Mt(){return E===null?z:1}let D=n;function Ft(P,H){return e.getContext(P,H)}try{const P={alpha:!0,depth:r,stencil:s,antialias:o,premultipliedAlpha:c,preserveDrawingBuffer:h,powerPreference:f,failIfMajorPerformanceCaveat:g};if("setAttribute"in e&&e.setAttribute("data-engine",`three.js r${ms}`),e.addEventListener("webglcontextlost",Tt,!1),e.addEventListener("webglcontextrestored",rt,!1),e.addEventListener("webglcontextcreationerror",K,!1),D===null){const H="webgl2";if(D=Ft(H,P),D===null)throw Ft(H)?new Error("Error creating WebGL context with your selected attributes."):new Error("Error creating WebGL context.")}}catch(P){throw console.error("THREE.WebGLRenderer: "+P.message),P}let Et,Zt,ct,Rt,ut,vt,zt,L,C,V,$,j,X,Ct,ht,bt,Pt,et,yt,Nt,Ut,ft,Vt,O;function gt(){Et=new z_(D),Et.init(),ft=new Sv(D,Et),Zt=new L_(D,Et,t,ft),ct=new vv(D,Et),Zt.reverseDepthBuffer&&p&&ct.buffers.depth.setReversed(!0),Rt=new G_(D),ut=new ov,vt=new yv(D,Et,ct,ut,Zt,ft,Rt),zt=new U_(v),L=new O_(v),C=new $p(D),Vt=new P_(D,C),V=new V_(D,C,Rt,Vt),$=new W_(D,V,C,Rt),yt=new k_(D,Zt,vt),bt=new D_(ut),j=new sv(v,zt,L,Et,Zt,Vt,bt),X=new wv(v,ut),Ct=new cv,ht=new pv(Et),et=new C_(v,zt,L,ct,$,_,c),Pt=new _v(v,$,Zt),O=new Rv(D,Rt,Zt,ct),Nt=new I_(D,Et,Rt),Ut=new H_(D,Et,Rt),Rt.programs=j.programs,v.capabilities=Zt,v.extensions=Et,v.properties=ut,v.renderLists=Ct,v.shadowMap=Pt,v.state=ct,v.info=Rt}gt();const nt=new bv(v,D);this.xr=nt,this.getContext=function(){return D},this.getContextAttributes=function(){return D.getContextAttributes()},this.forceContextLoss=function(){const P=Et.get("WEBGL_lose_context");P&&P.loseContext()},this.forceContextRestore=function(){const P=Et.get("WEBGL_lose_context");P&&P.restoreContext()},this.getPixelRatio=function(){return z},this.setPixelRatio=function(P){P!==void 0&&(z=P,this.setSize(F,k,!1))},this.getSize=function(P){return P.set(F,k)},this.setSize=function(P,H,q=!0){if(nt.isPresenting){console.warn("THREE.WebGLRenderer: Can't change size while VR device is presenting.");return}F=P,k=H,e.width=Math.floor(P*z),e.height=Math.floor(H*z),q===!0&&(e.style.width=P+"px",e.style.height=H+"px"),this.setViewport(0,0,P,H)},this.getDrawingBufferSize=function(P){return P.set(F*z,k*z).floor()},this.setDrawingBufferSize=function(P,H,q){F=P,k=H,z=q,e.width=Math.floor(P*q),e.height=Math.floor(H*q),this.setViewport(0,0,P,H)},this.getCurrentViewport=function(P){return P.copy(A)},this.getViewport=function(P){return P.copy(it)},this.setViewport=function(P,H,q,Y){P.isVector4?it.set(P.x,P.y,P.z,P.w):it.set(P,H,q,Y),ct.viewport(A.copy(it).multiplyScalar(z).round())},this.getScissor=function(P){return P.copy(pt)},this.setScissor=function(P,H,q,Y){P.isVector4?pt.set(P.x,P.y,P.z,P.w):pt.set(P,H,q,Y),ct.scissor(w.copy(pt).multiplyScalar(z).round())},this.getScissorTest=function(){return _t},this.setScissorTest=function(P){ct.setScissorTest(_t=P)},this.setOpaqueSort=function(P){J=P},this.setTransparentSort=function(P){Z=P},this.getClearColor=function(P){return P.copy(et.getClearColor())},this.setClearColor=function(){et.setClearColor(...arguments)},this.getClearAlpha=function(){return et.getClearAlpha()},this.setClearAlpha=function(){et.setClearAlpha(...arguments)},this.clear=function(P=!0,H=!0,q=!0){let Y=0;if(P){let G=!1;if(E!==null){const ot=E.texture.format;G=ot===wl||ot===Al||ot===qo}if(G){const ot=E.texture.type,mt=ot===Ln||ot===di||ot===ls||ot===us||ot===Tl||ot===bl,wt=et.getClearColor(),St=et.getClearAlpha(),Bt=wt.r,Ot=wt.g,It=wt.b;mt?(M[0]=Bt,M[1]=Ot,M[2]=It,M[3]=St,D.clearBufferuiv(D.COLOR,0,M)):(b[0]=Bt,b[1]=Ot,b[2]=It,b[3]=St,D.clearBufferiv(D.COLOR,0,b))}else Y|=D.COLOR_BUFFER_BIT}H&&(Y|=D.DEPTH_BUFFER_BIT),q&&(Y|=D.STENCIL_BUFFER_BIT,this.state.buffers.stencil.setMask(4294967295)),D.clear(Y)},this.clearColor=function(){this.clear(!0,!1,!1)},this.clearDepth=function(){this.clear(!1,!0,!1)},this.clearStencil=function(){this.clear(!1,!1,!0)},this.dispose=function(){e.removeEventListener("webglcontextlost",Tt,!1),e.removeEventListener("webglcontextrestored",rt,!1),e.removeEventListener("webglcontextcreationerror",K,!1),et.dispose(),Ct.dispose(),ht.dispose(),ut.dispose(),zt.dispose(),L.dispose(),$.dispose(),Vt.dispose(),O.dispose(),j.dispose(),nt.dispose(),nt.removeEventListener("sessionstart",Gl),nt.removeEventListener("sessionend",kl),mi.stop()};function Tt(P){P.preventDefault(),console.log("THREE.WebGLRenderer: Context Lost."),l=!0}function rt(){console.log("THREE.WebGLRenderer: Context Restored."),l=!1;const P=Rt.autoReset,H=Pt.enabled,q=Pt.autoUpdate,Y=Pt.needsUpdate,G=Pt.type;gt(),Rt.autoReset=P,Pt.enabled=H,Pt.autoUpdate=q,Pt.needsUpdate=Y,Pt.type=G}function K(P){console.error("THREE.WebGLRenderer: A WebGL context could not be created. Reason: ",P.statusMessage)}function At(P){const H=P.target;H.removeEventListener("dispose",At),Ht(H)}function Ht(P){oe(P),ut.remove(P)}function oe(P){const H=ut.get(P).programs;H!==void 0&&(H.forEach(function(q){j.releaseProgram(q)}),P.isShaderMaterial&&j.releaseShaderCache(P))}this.renderBufferDirect=function(P,H,q,Y,G,ot){H===null&&(H=jt);const mt=G.isMesh&&G.matrixWorld.determinant()<0,wt=rd(P,H,q,Y,G);ct.setMaterial(Y,mt);let St=q.index,Bt=1;if(Y.wireframe===!0){if(St=V.getWireframeAttribute(q),St===void 0)return;Bt=2}const Ot=q.drawRange,It=q.attributes.position;let Kt=Ot.start*Bt,ne=(Ot.start+Ot.count)*Bt;ot!==null&&(Kt=Math.max(Kt,ot.start*Bt),ne=Math.min(ne,(ot.start+ot.count)*Bt)),St!==null?(Kt=Math.max(Kt,0),ne=Math.min(ne,St.count)):It!=null&&(Kt=Math.max(Kt,0),ne=Math.min(ne,It.count));const le=ne-Kt;if(le<0||le===1/0)return;Vt.setup(G,Y,wt,q,St);let he,Qt=Nt;if(St!==null&&(he=C.get(St),Qt=Ut,Qt.setIndex(he)),G.isMesh)Y.wireframe===!0?(ct.setLineWidth(Y.wireframeLinewidth*Mt()),Qt.setMode(D.LINES)):Qt.setMode(D.TRIANGLES);else if(G.isLine){let Dt=Y.linewidth;Dt===void 0&&(Dt=1),ct.setLineWidth(Dt*Mt()),G.isLineSegments?Qt.setMode(D.LINES):G.isLineLoop?Qt.setMode(D.LINE_LOOP):Qt.setMode(D.LINE_STRIP)}else G.isPoints?Qt.setMode(D.POINTS):G.isSprite&&Qt.setMode(D.TRIANGLES);if(G.isBatchedMesh)if(G._multiDrawInstances!==null)Sr("THREE.WebGLRenderer: renderMultiDrawInstances has been deprecated and will be removed in r184. Append to renderMultiDraw arguments and use indirection."),Qt.renderMultiDrawInstances(G._multiDrawStarts,G._multiDrawCounts,G._multiDrawCount,G._multiDrawInstances);else if(Et.get("WEBGL_multi_draw"))Qt.renderMultiDraw(G._multiDrawStarts,G._multiDrawCounts,G._multiDrawCount);else{const Dt=G._multiDrawStarts,be=G._multiDrawCounts,te=G._multiDrawCount,dn=St?C.get(St).bytesPerElement:1,Hi=ut.get(Y).currentProgram.getUniforms();for(let Ye=0;Ye<te;Ye++)Hi.setValue(D,"_gl_DrawID",Ye),Qt.render(Dt[Ye]/dn,be[Ye])}else if(G.isInstancedMesh)Qt.renderInstances(Kt,le,G.count);else if(q.isInstancedBufferGeometry){const Dt=q._maxInstanceCount!==void 0?q._maxInstanceCount:1/0,be=Math.min(q.instanceCount,Dt);Qt.renderInstances(Kt,le,be)}else Qt.render(Kt,le)};function ee(P,H,q){P.transparent===!0&&P.side===Be&&P.forceSinglePass===!1?(P.side=ze,P.needsUpdate=!0,Ts(P,H,q),P.side=In,P.needsUpdate=!0,Ts(P,H,q),P.side=Be):Ts(P,H,q)}this.compile=function(P,H,q=null){q===null&&(q=P),m=ht.get(q),m.init(H),u.push(m),q.traverseVisible(function(G){G.isLight&&G.layers.test(H.layers)&&(m.pushLight(G),G.castShadow&&m.pushShadow(G))}),P!==q&&P.traverseVisible(function(G){G.isLight&&G.layers.test(H.layers)&&(m.pushLight(G),G.castShadow&&m.pushShadow(G))}),m.setupLights();const Y=new Set;return P.traverse(function(G){if(!(G.isMesh||G.isPoints||G.isLine||G.isSprite))return;const ot=G.material;if(ot)if(Array.isArray(ot))for(let mt=0;mt<ot.length;mt++){const wt=ot[mt];ee(wt,q,G),Y.add(wt)}else ee(ot,q,G),Y.add(ot)}),m=u.pop(),Y},this.compileAsync=function(P,H,q=null){const Y=this.compile(P,H,q);return new Promise(G=>{function ot(){if(Y.forEach(function(mt){ut.get(mt).currentProgram.isReady()&&Y.delete(mt)}),Y.size===0){G(P);return}setTimeout(ot,10)}Et.get("KHR_parallel_shader_compile")!==null?ot():setTimeout(ot,10)})};let fn=null;function Un(P){fn&&fn(P)}function Gl(){mi.stop()}function kl(){mi.start()}const mi=new wf;mi.setAnimationLoop(Un),typeof self<"u"&&mi.setContext(self),this.setAnimationLoop=function(P){fn=P,nt.setAnimationLoop(P),P===null?mi.stop():mi.start()},nt.addEventListener("sessionstart",Gl),nt.addEventListener("sessionend",kl),this.render=function(P,H){if(H!==void 0&&H.isCamera!==!0){console.error("THREE.WebGLRenderer.render: camera is not an instance of THREE.Camera.");return}if(l===!0)return;if(P.matrixWorldAutoUpdate===!0&&P.updateMatrixWorld(),H.parent===null&&H.matrixWorldAutoUpdate===!0&&H.updateMatrixWorld(),nt.enabled===!0&&nt.isPresenting===!0&&(nt.cameraAutoUpdate===!0&&nt.updateCamera(H),H=nt.getCamera()),P.isScene===!0&&P.onBeforeRender(v,P,H,E),m=ht.get(P,u.length),m.init(H),u.push(m),at.multiplyMatrices(H.projectionMatrix,H.matrixWorldInverse),W.setFromProjectionMatrix(at),st=this.localClippingEnabled,tt=bt.init(this.clippingPlanes,st),x=Ct.get(P,d.length),x.init(),d.push(x),nt.enabled===!0&&nt.isPresenting===!0){const ot=v.xr.getDepthSensingMesh();ot!==null&&Jo(ot,H,-1/0,v.sortObjects)}Jo(P,H,0,v.sortObjects),x.finish(),v.sortObjects===!0&&x.sort(J,Z),Lt=nt.enabled===!1||nt.isPresenting===!1||nt.hasDepthSensing()===!1,Lt&&et.addToRenderList(x,P),this.info.render.frame++,tt===!0&&bt.beginShadows();const q=m.state.shadowsArray;Pt.render(q,P,H),tt===!0&&bt.endShadows(),this.info.autoReset===!0&&this.info.reset();const Y=x.opaque,G=x.transmissive;if(m.setupLights(),H.isArrayCamera){const ot=H.cameras;if(G.length>0)for(let mt=0,wt=ot.length;mt<wt;mt++){const St=ot[mt];Xl(Y,G,P,St)}Lt&&et.render(P);for(let mt=0,wt=ot.length;mt<wt;mt++){const St=ot[mt];Wl(x,P,St,St.viewport)}}else G.length>0&&Xl(Y,G,P,H),Lt&&et.render(P),Wl(x,P,H);E!==null&&T===0&&(vt.updateMultisampleRenderTarget(E),vt.updateRenderTargetMipmap(E)),P.isScene===!0&&P.onAfterRender(v,P,H),Vt.resetDefaultState(),y=-1,S=null,u.pop(),u.length>0?(m=u[u.length-1],tt===!0&&bt.setGlobalState(v.clippingPlanes,m.state.camera)):m=null,d.pop(),d.length>0?x=d[d.length-1]:x=null};function Jo(P,H,q,Y){if(P.visible===!1)return;if(P.layers.test(H.layers)){if(P.isGroup)q=P.renderOrder;else if(P.isLOD)P.autoUpdate===!0&&P.update(H);else if(P.isLight)m.pushLight(P),P.castShadow&&m.pushShadow(P);else if(P.isSprite){if(!P.frustumCulled||W.intersectsSprite(P)){Y&&lt.setFromMatrixPosition(P.matrixWorld).applyMatrix4(at);const mt=$.update(P),wt=P.material;wt.visible&&x.push(P,mt,wt,q,lt.z,null)}}else if((P.isMesh||P.isLine||P.isPoints)&&(!P.frustumCulled||W.intersectsObject(P))){const mt=$.update(P),wt=P.material;if(Y&&(P.boundingSphere!==void 0?(P.boundingSphere===null&&P.computeBoundingSphere(),lt.copy(P.boundingSphere.center)):(mt.boundingSphere===null&&mt.computeBoundingSphere(),lt.copy(mt.boundingSphere.center)),lt.applyMatrix4(P.matrixWorld).applyMatrix4(at)),Array.isArray(wt)){const St=mt.groups;for(let Bt=0,Ot=St.length;Bt<Ot;Bt++){const It=St[Bt],Kt=wt[It.materialIndex];Kt&&Kt.visible&&x.push(P,mt,Kt,q,lt.z,It)}}else wt.visible&&x.push(P,mt,wt,q,lt.z,null)}}const ot=P.children;for(let mt=0,wt=ot.length;mt<wt;mt++)Jo(ot[mt],H,q,Y)}function Wl(P,H,q,Y){const G=P.opaque,ot=P.transmissive,mt=P.transparent;m.setupLightsView(q),tt===!0&&bt.setGlobalState(v.clippingPlanes,q),Y&&ct.viewport(A.copy(Y)),G.length>0&&Es(G,H,q),ot.length>0&&Es(ot,H,q),mt.length>0&&Es(mt,H,q),ct.buffers.depth.setTest(!0),ct.buffers.depth.setMask(!0),ct.buffers.color.setMask(!0),ct.setPolygonOffset(!1)}function Xl(P,H,q,Y){if((q.isScene===!0?q.overrideMaterial:null)!==null)return;m.state.transmissionRenderTarget[Y.id]===void 0&&(m.state.transmissionRenderTarget[Y.id]=new Vi(1,1,{generateMipmaps:!0,type:Et.has("EXT_color_buffer_half_float")||Et.has("EXT_color_buffer_float")?_s:Ln,minFilter:Bi,samples:4,stencilBuffer:s,resolveDepthBuffer:!1,resolveStencilBuffer:!1,colorSpace:Jt.workingColorSpace}));const ot=m.state.transmissionRenderTarget[Y.id],mt=Y.viewport||A;ot.setSize(mt.z*v.transmissionResolutionScale,mt.w*v.transmissionResolutionScale);const wt=v.getRenderTarget();v.setRenderTarget(ot),v.getClearColor(N),B=v.getClearAlpha(),B<1&&v.setClearColor(16777215,.5),v.clear(),Lt&&et.render(q);const St=v.toneMapping;v.toneMapping=ui;const Bt=Y.viewport;if(Y.viewport!==void 0&&(Y.viewport=void 0),m.setupLightsView(Y),tt===!0&&bt.setGlobalState(v.clippingPlanes,Y),Es(P,q,Y),vt.updateMultisampleRenderTarget(ot),vt.updateRenderTargetMipmap(ot),Et.has("WEBGL_multisampled_render_to_texture")===!1){let Ot=!1;for(let It=0,Kt=H.length;It<Kt;It++){const ne=H[It],le=ne.object,he=ne.geometry,Qt=ne.material,Dt=ne.group;if(Qt.side===Be&&le.layers.test(Y.layers)){const be=Qt.side;Qt.side=ze,Qt.needsUpdate=!0,ql(le,q,Y,he,Qt,Dt),Qt.side=be,Qt.needsUpdate=!0,Ot=!0}}Ot===!0&&(vt.updateMultisampleRenderTarget(ot),vt.updateRenderTargetMipmap(ot))}v.setRenderTarget(wt),v.setClearColor(N,B),Bt!==void 0&&(Y.viewport=Bt),v.toneMapping=St}function Es(P,H,q){const Y=H.isScene===!0?H.overrideMaterial:null;for(let G=0,ot=P.length;G<ot;G++){const mt=P[G],wt=mt.object,St=mt.geometry,Bt=mt.group;let Ot=mt.material;Ot.allowOverride===!0&&Y!==null&&(Ot=Y),wt.layers.test(q.layers)&&ql(wt,H,q,St,Ot,Bt)}}function ql(P,H,q,Y,G,ot){P.onBeforeRender(v,H,q,Y,G,ot),P.modelViewMatrix.multiplyMatrices(q.matrixWorldInverse,P.matrixWorld),P.normalMatrix.getNormalMatrix(P.modelViewMatrix),G.onBeforeRender(v,H,q,Y,P,ot),G.transparent===!0&&G.side===Be&&G.forceSinglePass===!1?(G.side=ze,G.needsUpdate=!0,v.renderBufferDirect(q,H,Y,G,P,ot),G.side=In,G.needsUpdate=!0,v.renderBufferDirect(q,H,Y,G,P,ot),G.side=Be):v.renderBufferDirect(q,H,Y,G,P,ot),P.onAfterRender(v,H,q,Y,G,ot)}function Ts(P,H,q){H.isScene!==!0&&(H=jt);const Y=ut.get(P),G=m.state.lights,ot=m.state.shadowsArray,mt=G.state.version,wt=j.getParameters(P,G.state,ot,H,q),St=j.getProgramCacheKey(wt);let Bt=Y.programs;Y.environment=P.isMeshStandardMaterial?H.environment:null,Y.fog=H.fog,Y.envMap=(P.isMeshStandardMaterial?L:zt).get(P.envMap||Y.environment),Y.envMapRotation=Y.environment!==null&&P.envMap===null?H.environmentRotation:P.envMapRotation,Bt===void 0&&(P.addEventListener("dispose",At),Bt=new Map,Y.programs=Bt);let Ot=Bt.get(St);if(Ot!==void 0){if(Y.currentProgram===Ot&&Y.lightsStateVersion===mt)return $l(P,wt),Ot}else wt.uniforms=j.getUniforms(P),P.onBeforeCompile(wt,v),Ot=j.acquireProgram(wt,St),Bt.set(St,Ot),Y.uniforms=wt.uniforms;const It=Y.uniforms;return(!P.isShaderMaterial&&!P.isRawShaderMaterial||P.clipping===!0)&&(It.clippingPlanes=bt.uniform),$l(P,wt),Y.needsLights=od(P),Y.lightsStateVersion=mt,Y.needsLights&&(It.ambientLightColor.value=G.state.ambient,It.lightProbe.value=G.state.probe,It.directionalLights.value=G.state.directional,It.directionalLightShadows.value=G.state.directionalShadow,It.spotLights.value=G.state.spot,It.spotLightShadows.value=G.state.spotShadow,It.rectAreaLights.value=G.state.rectArea,It.ltc_1.value=G.state.rectAreaLTC1,It.ltc_2.value=G.state.rectAreaLTC2,It.pointLights.value=G.state.point,It.pointLightShadows.value=G.state.pointShadow,It.hemisphereLights.value=G.state.hemi,It.directionalShadowMap.value=G.state.directionalShadowMap,It.directionalShadowMatrix.value=G.state.directionalShadowMatrix,It.spotShadowMap.value=G.state.spotShadowMap,It.spotLightMatrix.value=G.state.spotLightMatrix,It.spotLightMap.value=G.state.spotLightMap,It.pointShadowMap.value=G.state.pointShadowMap,It.pointShadowMatrix.value=G.state.pointShadowMatrix),Y.currentProgram=Ot,Y.uniformsList=null,Ot}function Yl(P){if(P.uniformsList===null){const H=P.currentProgram.getUniforms();P.uniformsList=Ao.seqWithValue(H.seq,P.uniforms)}return P.uniformsList}function $l(P,H){const q=ut.get(P);q.outputColorSpace=H.outputColorSpace,q.batching=H.batching,q.batchingColor=H.batchingColor,q.instancing=H.instancing,q.instancingColor=H.instancingColor,q.instancingMorph=H.instancingMorph,q.skinning=H.skinning,q.morphTargets=H.morphTargets,q.morphNormals=H.morphNormals,q.morphColors=H.morphColors,q.morphTargetsCount=H.morphTargetsCount,q.numClippingPlanes=H.numClippingPlanes,q.numIntersection=H.numClipIntersection,q.vertexAlphas=H.vertexAlphas,q.vertexTangents=H.vertexTangents,q.toneMapping=H.toneMapping}function rd(P,H,q,Y,G){H.isScene!==!0&&(H=jt),vt.resetTextureUnits();const ot=H.fog,mt=Y.isMeshStandardMaterial?H.environment:null,wt=E===null?v.outputColorSpace:E.isXRRenderTarget===!0?E.texture.colorSpace:Rr,St=(Y.isMeshStandardMaterial?L:zt).get(Y.envMap||mt),Bt=Y.vertexColors===!0&&!!q.attributes.color&&q.attributes.color.itemSize===4,Ot=!!q.attributes.tangent&&(!!Y.normalMap||Y.anisotropy>0),It=!!q.morphAttributes.position,Kt=!!q.morphAttributes.normal,ne=!!q.morphAttributes.color;let le=ui;Y.toneMapped&&(E===null||E.isXRRenderTarget===!0)&&(le=v.toneMapping);const he=q.morphAttributes.position||q.morphAttributes.normal||q.morphAttributes.color,Qt=he!==void 0?he.length:0,Dt=ut.get(Y),be=m.state.lights;if(tt===!0&&(st===!0||P!==S)){const Ue=P===S&&Y.id===y;bt.setState(Y,P,Ue)}let te=!1;Y.version===Dt.__version?(Dt.needsLights&&Dt.lightsStateVersion!==be.state.version||Dt.outputColorSpace!==wt||G.isBatchedMesh&&Dt.batching===!1||!G.isBatchedMesh&&Dt.batching===!0||G.isBatchedMesh&&Dt.batchingColor===!0&&G.colorTexture===null||G.isBatchedMesh&&Dt.batchingColor===!1&&G.colorTexture!==null||G.isInstancedMesh&&Dt.instancing===!1||!G.isInstancedMesh&&Dt.instancing===!0||G.isSkinnedMesh&&Dt.skinning===!1||!G.isSkinnedMesh&&Dt.skinning===!0||G.isInstancedMesh&&Dt.instancingColor===!0&&G.instanceColor===null||G.isInstancedMesh&&Dt.instancingColor===!1&&G.instanceColor!==null||G.isInstancedMesh&&Dt.instancingMorph===!0&&G.morphTexture===null||G.isInstancedMesh&&Dt.instancingMorph===!1&&G.morphTexture!==null||Dt.envMap!==St||Y.fog===!0&&Dt.fog!==ot||Dt.numClippingPlanes!==void 0&&(Dt.numClippingPlanes!==bt.numPlanes||Dt.numIntersection!==bt.numIntersection)||Dt.vertexAlphas!==Bt||Dt.vertexTangents!==Ot||Dt.morphTargets!==It||Dt.morphNormals!==Kt||Dt.morphColors!==ne||Dt.toneMapping!==le||Dt.morphTargetsCount!==Qt)&&(te=!0):(te=!0,Dt.__version=Y.version);let dn=Dt.currentProgram;te===!0&&(dn=Ts(Y,H,G));let Hi=!1,Ye=!1,Fr=!1;const ce=dn.getUniforms(),Qe=Dt.uniforms;if(ct.useProgram(dn.program)&&(Hi=!0,Ye=!0,Fr=!0),Y.id!==y&&(y=Y.id,Ye=!0),Hi||S!==P){ct.buffers.depth.getReversed()?(Q.copy(P.projectionMatrix),tp(Q),ep(Q),ce.setValue(D,"projectionMatrix",Q)):ce.setValue(D,"projectionMatrix",P.projectionMatrix),ce.setValue(D,"viewMatrix",P.matrixWorldInverse);const He=ce.map.cameraPosition;He!==void 0&&He.setValue(D,xt.setFromMatrixPosition(P.matrixWorld)),Zt.logarithmicDepthBuffer&&ce.setValue(D,"logDepthBufFC",2/(Math.log(P.far+1)/Math.LN2)),(Y.isMeshPhongMaterial||Y.isMeshToonMaterial||Y.isMeshLambertMaterial||Y.isMeshBasicMaterial||Y.isMeshStandardMaterial||Y.isShaderMaterial)&&ce.setValue(D,"isOrthographic",P.isOrthographicCamera===!0),S!==P&&(S=P,Ye=!0,Fr=!0)}if(G.isSkinnedMesh){ce.setOptional(D,G,"bindMatrix"),ce.setOptional(D,G,"bindMatrixInverse");const Ue=G.skeleton;Ue&&(Ue.boneTexture===null&&Ue.computeBoneTexture(),ce.setValue(D,"boneTexture",Ue.boneTexture,vt))}G.isBatchedMesh&&(ce.setOptional(D,G,"batchingTexture"),ce.setValue(D,"batchingTexture",G._matricesTexture,vt),ce.setOptional(D,G,"batchingIdTexture"),ce.setValue(D,"batchingIdTexture",G._indirectTexture,vt),ce.setOptional(D,G,"batchingColorTexture"),G._colorsTexture!==null&&ce.setValue(D,"batchingColorTexture",G._colorsTexture,vt));const tn=q.morphAttributes;if((tn.position!==void 0||tn.normal!==void 0||tn.color!==void 0)&&yt.update(G,q,dn),(Ye||Dt.receiveShadow!==G.receiveShadow)&&(Dt.receiveShadow=G.receiveShadow,ce.setValue(D,"receiveShadow",G.receiveShadow)),Y.isMeshGouraudMaterial&&Y.envMap!==null&&(Qe.envMap.value=St,Qe.flipEnvMap.value=St.isCubeTexture&&St.isRenderTargetTexture===!1?-1:1),Y.isMeshStandardMaterial&&Y.envMap===null&&H.environment!==null&&(Qe.envMapIntensity.value=H.environmentIntensity),Ye&&(ce.setValue(D,"toneMappingExposure",v.toneMappingExposure),Dt.needsLights&&sd(Qe,Fr),ot&&Y.fog===!0&&X.refreshFogUniforms(Qe,ot),X.refreshMaterialUniforms(Qe,Y,z,k,m.state.transmissionRenderTarget[P.id]),Ao.upload(D,Yl(Dt),Qe,vt)),Y.isShaderMaterial&&Y.uniformsNeedUpdate===!0&&(Ao.upload(D,Yl(Dt),Qe,vt),Y.uniformsNeedUpdate=!1),Y.isSpriteMaterial&&ce.setValue(D,"center",G.center),ce.setValue(D,"modelViewMatrix",G.modelViewMatrix),ce.setValue(D,"normalMatrix",G.normalMatrix),ce.setValue(D,"modelMatrix",G.matrixWorld),Y.isShaderMaterial||Y.isRawShaderMaterial){const Ue=Y.uniformsGroups;for(let He=0,Qo=Ue.length;He<Qo;He++){const _i=Ue[He];O.update(_i,dn),O.bind(_i,dn)}}return dn}function sd(P,H){P.ambientLightColor.needsUpdate=H,P.lightProbe.needsUpdate=H,P.directionalLights.needsUpdate=H,P.directionalLightShadows.needsUpdate=H,P.pointLights.needsUpdate=H,P.pointLightShadows.needsUpdate=H,P.spotLights.needsUpdate=H,P.spotLightShadows.needsUpdate=H,P.rectAreaLights.needsUpdate=H,P.hemisphereLights.needsUpdate=H}function od(P){return P.isMeshLambertMaterial||P.isMeshToonMaterial||P.isMeshPhongMaterial||P.isMeshStandardMaterial||P.isShadowMaterial||P.isShaderMaterial&&P.lights===!0}this.getActiveCubeFace=function(){return R},this.getActiveMipmapLevel=function(){return T},this.getRenderTarget=function(){return E},this.setRenderTargetTextures=function(P,H,q){const Y=ut.get(P);Y.__autoAllocateDepthBuffer=P.resolveDepthBuffer===!1,Y.__autoAllocateDepthBuffer===!1&&(Y.__useRenderToTexture=!1),ut.get(P.texture).__webglTexture=H,ut.get(P.depthTexture).__webglTexture=Y.__autoAllocateDepthBuffer?void 0:q,Y.__hasExternalTextures=!0},this.setRenderTargetFramebuffer=function(P,H){const q=ut.get(P);q.__webglFramebuffer=H,q.__useDefaultFramebuffer=H===void 0};const ad=D.createFramebuffer();this.setRenderTarget=function(P,H=0,q=0){E=P,R=H,T=q;let Y=!0,G=null,ot=!1,mt=!1;if(P){const St=ut.get(P);if(St.__useDefaultFramebuffer!==void 0)ct.bindFramebuffer(D.FRAMEBUFFER,null),Y=!1;else if(St.__webglFramebuffer===void 0)vt.setupRenderTarget(P);else if(St.__hasExternalTextures)vt.rebindTextures(P,ut.get(P.texture).__webglTexture,ut.get(P.depthTexture).__webglTexture);else if(P.depthBuffer){const It=P.depthTexture;if(St.__boundDepthTexture!==It){if(It!==null&&ut.has(It)&&(P.width!==It.image.width||P.height!==It.image.height))throw new Error("WebGLRenderTarget: Attached DepthTexture is initialized to the incorrect size.");vt.setupDepthRenderbuffer(P)}}const Bt=P.texture;(Bt.isData3DTexture||Bt.isDataArrayTexture||Bt.isCompressedArrayTexture)&&(mt=!0);const Ot=ut.get(P).__webglFramebuffer;P.isWebGLCubeRenderTarget?(Array.isArray(Ot[H])?G=Ot[H][q]:G=Ot[H],ot=!0):P.samples>0&&vt.useMultisampledRTT(P)===!1?G=ut.get(P).__webglMultisampledFramebuffer:Array.isArray(Ot)?G=Ot[q]:G=Ot,A.copy(P.viewport),w.copy(P.scissor),I=P.scissorTest}else A.copy(it).multiplyScalar(z).floor(),w.copy(pt).multiplyScalar(z).floor(),I=_t;if(q!==0&&(G=ad),ct.bindFramebuffer(D.FRAMEBUFFER,G)&&Y&&ct.drawBuffers(P,G),ct.viewport(A),ct.scissor(w),ct.setScissorTest(I),ot){const St=ut.get(P.texture);D.framebufferTexture2D(D.FRAMEBUFFER,D.COLOR_ATTACHMENT0,D.TEXTURE_CUBE_MAP_POSITIVE_X+H,St.__webglTexture,q)}else if(mt){const St=ut.get(P.texture),Bt=H;D.framebufferTextureLayer(D.FRAMEBUFFER,D.COLOR_ATTACHMENT0,St.__webglTexture,q,Bt)}else if(P!==null&&q!==0){const St=ut.get(P.texture);D.framebufferTexture2D(D.FRAMEBUFFER,D.COLOR_ATTACHMENT0,D.TEXTURE_2D,St.__webglTexture,q)}y=-1},this.readRenderTargetPixels=function(P,H,q,Y,G,ot,mt,wt=0){if(!(P&&P.isWebGLRenderTarget)){console.error("THREE.WebGLRenderer.readRenderTargetPixels: renderTarget is not THREE.WebGLRenderTarget.");return}let St=ut.get(P).__webglFramebuffer;if(P.isWebGLCubeRenderTarget&&mt!==void 0&&(St=St[mt]),St){ct.bindFramebuffer(D.FRAMEBUFFER,St);try{const Bt=P.textures[wt],Ot=Bt.format,It=Bt.type;if(!Zt.textureFormatReadable(Ot)){console.error("THREE.WebGLRenderer.readRenderTargetPixels: renderTarget is not in RGBA or implementation defined format.");return}if(!Zt.textureTypeReadable(It)){console.error("THREE.WebGLRenderer.readRenderTargetPixels: renderTarget is not in UnsignedByteType or implementation defined type.");return}H>=0&&H<=P.width-Y&&q>=0&&q<=P.height-G&&(P.textures.length>1&&D.readBuffer(D.COLOR_ATTACHMENT0+wt),D.readPixels(H,q,Y,G,ft.convert(Ot),ft.convert(It),ot))}finally{const Bt=E!==null?ut.get(E).__webglFramebuffer:null;ct.bindFramebuffer(D.FRAMEBUFFER,Bt)}}},this.readRenderTargetPixelsAsync=async function(P,H,q,Y,G,ot,mt,wt=0){if(!(P&&P.isWebGLRenderTarget))throw new Error("THREE.WebGLRenderer.readRenderTargetPixels: renderTarget is not THREE.WebGLRenderTarget.");let St=ut.get(P).__webglFramebuffer;if(P.isWebGLCubeRenderTarget&&mt!==void 0&&(St=St[mt]),St)if(H>=0&&H<=P.width-Y&&q>=0&&q<=P.height-G){ct.bindFramebuffer(D.FRAMEBUFFER,St);const Bt=P.textures[wt],Ot=Bt.format,It=Bt.type;if(!Zt.textureFormatReadable(Ot))throw new Error("THREE.WebGLRenderer.readRenderTargetPixelsAsync: renderTarget is not in RGBA or implementation defined format.");if(!Zt.textureTypeReadable(It))throw new Error("THREE.WebGLRenderer.readRenderTargetPixelsAsync: renderTarget is not in UnsignedByteType or implementation defined type.");const Kt=D.createBuffer();D.bindBuffer(D.PIXEL_PACK_BUFFER,Kt),D.bufferData(D.PIXEL_PACK_BUFFER,ot.byteLength,D.STREAM_READ),P.textures.length>1&&D.readBuffer(D.COLOR_ATTACHMENT0+wt),D.readPixels(H,q,Y,G,ft.convert(Ot),ft.convert(It),0);const ne=E!==null?ut.get(E).__webglFramebuffer:null;ct.bindFramebuffer(D.FRAMEBUFFER,ne);const le=D.fenceSync(D.SYNC_GPU_COMMANDS_COMPLETE,0);return D.flush(),await Qd(D,le,4),D.bindBuffer(D.PIXEL_PACK_BUFFER,Kt),D.getBufferSubData(D.PIXEL_PACK_BUFFER,0,ot),D.deleteBuffer(Kt),D.deleteSync(le),ot}else throw new Error("THREE.WebGLRenderer.readRenderTargetPixelsAsync: requested read bounds are out of range.")},this.copyFramebufferToTexture=function(P,H=null,q=0){const Y=Math.pow(2,-q),G=Math.floor(P.image.width*Y),ot=Math.floor(P.image.height*Y),mt=H!==null?H.x:0,wt=H!==null?H.y:0;vt.setTexture2D(P,0),D.copyTexSubImage2D(D.TEXTURE_2D,q,0,0,mt,wt,G,ot),ct.unbindTexture()};const cd=D.createFramebuffer(),ld=D.createFramebuffer();this.copyTextureToTexture=function(P,H,q=null,Y=null,G=0,ot=null){ot===null&&(G!==0?(Sr("WebGLRenderer: copyTextureToTexture function signature has changed to support src and dst mipmap levels."),ot=G,G=0):ot=0);let mt,wt,St,Bt,Ot,It,Kt,ne,le;const he=P.isCompressedTexture?P.mipmaps[ot]:P.image;if(q!==null)mt=q.max.x-q.min.x,wt=q.max.y-q.min.y,St=q.isBox3?q.max.z-q.min.z:1,Bt=q.min.x,Ot=q.min.y,It=q.isBox3?q.min.z:0;else{const tn=Math.pow(2,-G);mt=Math.floor(he.width*tn),wt=Math.floor(he.height*tn),P.isDataArrayTexture?St=he.depth:P.isData3DTexture?St=Math.floor(he.depth*tn):St=1,Bt=0,Ot=0,It=0}Y!==null?(Kt=Y.x,ne=Y.y,le=Y.z):(Kt=0,ne=0,le=0);const Qt=ft.convert(H.format),Dt=ft.convert(H.type);let be;H.isData3DTexture?(vt.setTexture3D(H,0),be=D.TEXTURE_3D):H.isDataArrayTexture||H.isCompressedArrayTexture?(vt.setTexture2DArray(H,0),be=D.TEXTURE_2D_ARRAY):(vt.setTexture2D(H,0),be=D.TEXTURE_2D),D.pixelStorei(D.UNPACK_FLIP_Y_WEBGL,H.flipY),D.pixelStorei(D.UNPACK_PREMULTIPLY_ALPHA_WEBGL,H.premultiplyAlpha),D.pixelStorei(D.UNPACK_ALIGNMENT,H.unpackAlignment);const te=D.getParameter(D.UNPACK_ROW_LENGTH),dn=D.getParameter(D.UNPACK_IMAGE_HEIGHT),Hi=D.getParameter(D.UNPACK_SKIP_PIXELS),Ye=D.getParameter(D.UNPACK_SKIP_ROWS),Fr=D.getParameter(D.UNPACK_SKIP_IMAGES);D.pixelStorei(D.UNPACK_ROW_LENGTH,he.width),D.pixelStorei(D.UNPACK_IMAGE_HEIGHT,he.height),D.pixelStorei(D.UNPACK_SKIP_PIXELS,Bt),D.pixelStorei(D.UNPACK_SKIP_ROWS,Ot),D.pixelStorei(D.UNPACK_SKIP_IMAGES,It);const ce=P.isDataArrayTexture||P.isData3DTexture,Qe=H.isDataArrayTexture||H.isData3DTexture;if(P.isDepthTexture){const tn=ut.get(P),Ue=ut.get(H),He=ut.get(tn.__renderTarget),Qo=ut.get(Ue.__renderTarget);ct.bindFramebuffer(D.READ_FRAMEBUFFER,He.__webglFramebuffer),ct.bindFramebuffer(D.DRAW_FRAMEBUFFER,Qo.__webglFramebuffer);for(let _i=0;_i<St;_i++)ce&&(D.framebufferTextureLayer(D.READ_FRAMEBUFFER,D.COLOR_ATTACHMENT0,ut.get(P).__webglTexture,G,It+_i),D.framebufferTextureLayer(D.DRAW_FRAMEBUFFER,D.COLOR_ATTACHMENT0,ut.get(H).__webglTexture,ot,le+_i)),D.blitFramebuffer(Bt,Ot,mt,wt,Kt,ne,mt,wt,D.DEPTH_BUFFER_BIT,D.NEAREST);ct.bindFramebuffer(D.READ_FRAMEBUFFER,null),ct.bindFramebuffer(D.DRAW_FRAMEBUFFER,null)}else if(G!==0||P.isRenderTargetTexture||ut.has(P)){const tn=ut.get(P),Ue=ut.get(H);ct.bindFramebuffer(D.READ_FRAMEBUFFER,cd),ct.bindFramebuffer(D.DRAW_FRAMEBUFFER,ld);for(let He=0;He<St;He++)ce?D.framebufferTextureLayer(D.READ_FRAMEBUFFER,D.COLOR_ATTACHMENT0,tn.__webglTexture,G,It+He):D.framebufferTexture2D(D.READ_FRAMEBUFFER,D.COLOR_ATTACHMENT0,D.TEXTURE_2D,tn.__webglTexture,G),Qe?D.framebufferTextureLayer(D.DRAW_FRAMEBUFFER,D.COLOR_ATTACHMENT0,Ue.__webglTexture,ot,le+He):D.framebufferTexture2D(D.DRAW_FRAMEBUFFER,D.COLOR_ATTACHMENT0,D.TEXTURE_2D,Ue.__webglTexture,ot),G!==0?D.blitFramebuffer(Bt,Ot,mt,wt,Kt,ne,mt,wt,D.COLOR_BUFFER_BIT,D.NEAREST):Qe?D.copyTexSubImage3D(be,ot,Kt,ne,le+He,Bt,Ot,mt,wt):D.copyTexSubImage2D(be,ot,Kt,ne,Bt,Ot,mt,wt);ct.bindFramebuffer(D.READ_FRAMEBUFFER,null),ct.bindFramebuffer(D.DRAW_FRAMEBUFFER,null)}else Qe?P.isDataTexture||P.isData3DTexture?D.texSubImage3D(be,ot,Kt,ne,le,mt,wt,St,Qt,Dt,he.data):H.isCompressedArrayTexture?D.compressedTexSubImage3D(be,ot,Kt,ne,le,mt,wt,St,Qt,he.data):D.texSubImage3D(be,ot,Kt,ne,le,mt,wt,St,Qt,Dt,he):P.isDataTexture?D.texSubImage2D(D.TEXTURE_2D,ot,Kt,ne,mt,wt,Qt,Dt,he.data):P.isCompressedTexture?D.compressedTexSubImage2D(D.TEXTURE_2D,ot,Kt,ne,he.width,he.height,Qt,he.data):D.texSubImage2D(D.TEXTURE_2D,ot,Kt,ne,mt,wt,Qt,Dt,he);D.pixelStorei(D.UNPACK_ROW_LENGTH,te),D.pixelStorei(D.UNPACK_IMAGE_HEIGHT,dn),D.pixelStorei(D.UNPACK_SKIP_PIXELS,Hi),D.pixelStorei(D.UNPACK_SKIP_ROWS,Ye),D.pixelStorei(D.UNPACK_SKIP_IMAGES,Fr),ot===0&&H.generateMipmaps&&D.generateMipmap(be),ct.unbindTexture()},this.copyTextureToTexture3D=function(P,H,q=null,Y=null,G=0){return Sr('WebGLRenderer: copyTextureToTexture3D function has been deprecated. Use "copyTextureToTexture" instead.'),this.copyTextureToTexture(P,H,q,Y,G)},this.initRenderTarget=function(P){ut.get(P).__webglFramebuffer===void 0&&vt.setupRenderTarget(P)},this.initTexture=function(P){P.isCubeTexture?vt.setTextureCube(P,0):P.isData3DTexture?vt.setTexture3D(P,0):P.isDataArrayTexture||P.isCompressedArrayTexture?vt.setTexture2DArray(P,0):vt.setTexture2D(P,0),ct.unbindTexture()},this.resetState=function(){R=0,T=0,E=null,ct.reset(),Vt.reset()},typeof __THREE_DEVTOOLS__<"u"&&__THREE_DEVTOOLS__.dispatchEvent(new CustomEvent("observe",{detail:this}))}get coordinateSystem(){return An}get outputColorSpace(){return this._outputColorSpace}set outputColorSpace(t){this._outputColorSpace=t;const e=this.getContext();e.drawingBufferColorSpace=Jt._getDrawingBufferColorSpace(t),e.unpackColorSpace=Jt._getUnpackColorSpace()}}class _r{constructor(t,e,n="external"){this.p1=t,this.p2=e,this.type=n,this.is_pruned=!1,this.adjacent_triangles=[]}getMidpoint(){return new U((this.p1.x+this.p2.x)/2,(this.p1.y+this.p2.y)/2,0)}getLength(){return this.p1.distanceTo(this.p2)}}class Ll{constructor(t,e,n){this.points=[t,e,n],this.edges=[null,null,null],this.type=null,this.center=new U((this.points[0].x+this.points[1].x+this.points[2].x)/3,(this.points[0].y+this.points[1].y+this.points[2].y)/3,0)}getMidpoint(){return this.center}}function Pv(i,t){let e=new Map,n=[];for(const r of i){const s=[t[r[0]],t[r[1]],t[r[2]]];let a=new Ll(s[0],s[1],s[2]),o=[[s[1],s[2]],[s[2],s[0]],[s[0],s[1]]];for(let c=0;c<3;c++){let[h,f]=o[c],g=`${h.x},${h.y}|${f.x},${f.y}`,p=`${f.x},${f.y}|${h.x},${h.y}`;if(e.has(g)){let _=e.get(g);_.type="internal",_.adjacent_triangles.push(a),a.edges[c]=_}else{let _=new _r(h,f);_.adjacent_triangles=[a],e.set(g,_),e.set(p,_),a.edges[c]=_}}n.push(a)}for(let r of n){let s=0;for(let a=0;a<3;a++)r.edges[a].type=="external"&&s++;s==2?r.type="terminal":s==1?r.type="sleeve":r.type="junction"}return n}function Iv(i,t){const e=t.getMidpoint(),n=t.getLength()/2;for(let r=1;r<i.length-1;r++)if(i[r].distanceTo(e)>n)return!0;return!1}function eh(i,t){for(let e=0;e<t.edges.length;e++){let n=t.edges[e];if((n.type=="internal"||n.type=="fan")&&n!=i)return[n,e]}return[null,-1]}function Lv(i,t){for(let e of t.edges)if(e.type=="external"){let n=e.p1,r=e.p2;i[0]==n?i.unshift(r):i[0]==r?i.unshift(n):i[i.length-1]==n?i.push(r):i[i.length-1]==r&&i.push(n);return}}let ds=new Map;function Dv(i,t){const e=`${i.x},${i.y}`;if(ds.has(e))return;let n=0;for(const r of t)n+=Math.sqrt((i.x-r.x)**2+(i.y-r.y)**2);ds.set(e,n/t.length)}function Uv(i){let t=[],e=[];for(let n of i){if(n.type!=="terminal")continue;let r=[],s,a;[s,a]=eh(null,n),r.push(n.points[a]),r.push(n.points[(a+1)%3]),r.unshift(n.points[(a+2)%3]);let o=n;for(;!Iv(r,s)&&(e.push(o),o=s.adjacent_triangles[0]==o?s.adjacent_triangles[1]:s.adjacent_triangles[0],!(o.type=="junction"||s.type=="fan"));){let p=s;if([s,a]=eh(s,o),s==null){s=p;break}Lv(r,o)}o.type=="junction"&&(s.is_pruned=!0);let c=o.type=="junction"?o.getMidpoint():s.getMidpoint();o.type!=="junction"&&(e.push(o),s.adjacent_triangles[0]==o?o=s.adjacent_triangles[1]:o=s.adjacent_triangles[0]);let h=[];for(let p=0;p<r.length-1;p++){let _=new Ll(r[p],r[p+1],c);_.edges[2]=new _r(r[p],r[p+1],"external"),_.edges[2].adjacent_triangles=[_],_.type="fan",h.push(_)}s.type="fan",s.adjacent_triangles=[h[0],h[h.length-1],o];for(let p=1;p<r.length-1;p++){let _=new _r(r[p],c,"internal");h[p-1].edges[0]=_,h[p].edges[1]=_,_.adjacent_triangles=[h[p-1],h[p]]}let f=new _r(r[0],c,"fan");f.adjacent_triangles=[h[0],o];let g=new _r(r[r.length-1],c,"fan");g.adjacent_triangles=[h[h.length-1],o],h[0].edges[1]=f,h[h.length-1].edges[0]=g,t=t.concat(h),o.type=="junction"&&o.edges[0].is_pruned&&o.edges[1].is_pruned&&o.edges[2].is_pruned&&e.push(o)}i=i.filter(n=>!e.includes(n)),i=i.concat(t),ds=new Map;for(let n of i){if(n.type!=="junction")continue;let r=0;for(let s of n.edges)s.is_pruned&&r++;if(r==1){let s=[];for(let a of n.edges)a.is_pruned||s.push(a.getMidpoint());n.center.x=(s[0].x+s[1].x)/2,n.center.y=(s[0].y+s[1].y)/2,Dv(n.center,n.points)}}return i}function Nv(i){return i&&i.__esModule&&Object.prototype.hasOwnProperty.call(i,"default")?i.default:i}var Fa,nh;function $o(){if(nh)return Fa;nh=1;function i(a,o,c,h,f){for(var g=f+1;h<=f;){var p=h+f>>>1,_=a[p],M=c!==void 0?c(_,o):_-o;M>=0?(g=p,f=p-1):h=p+1}return g}function t(a,o,c,h,f){for(var g=f+1;h<=f;){var p=h+f>>>1,_=a[p],M=c!==void 0?c(_,o):_-o;M>0?(g=p,f=p-1):h=p+1}return g}function e(a,o,c,h,f){for(var g=h-1;h<=f;){var p=h+f>>>1,_=a[p],M=c!==void 0?c(_,o):_-o;M<0?(g=p,h=p+1):f=p-1}return g}function n(a,o,c,h,f){for(var g=h-1;h<=f;){var p=h+f>>>1,_=a[p],M=c!==void 0?c(_,o):_-o;M<=0?(g=p,h=p+1):f=p-1}return g}function r(a,o,c,h,f){for(;h<=f;){var g=h+f>>>1,p=a[g],_=c!==void 0?c(p,o):p-o;if(_===0)return g;_<=0?h=g+1:f=g-1}return-1}function s(a,o,c,h,f,g){return typeof c=="function"?g(a,o,c,h===void 0?0:h|0,f===void 0?a.length-1:f|0):g(a,o,void 0,c===void 0?0:c|0,h===void 0?a.length-1:h|0)}return Fa={ge:function(a,o,c,h,f){return s(a,o,c,h,f,i)},gt:function(a,o,c,h,f){return s(a,o,c,h,f,t)},lt:function(a,o,c,h,f){return s(a,o,c,h,f,e)},le:function(a,o,c,h,f){return s(a,o,c,h,f,n)},eq:function(a,o,c,h,f){return s(a,o,c,h,f,r)}},Fa}var Ba={exports:{}},Oa,ih;function Dl(){if(ih)return Oa;ih=1,Oa=t;var i=+(Math.pow(2,27)+1);function t(e,n,r){var s=e*n,a=i*e,o=a-e,c=a-o,h=e-c,f=i*n,g=f-n,p=f-g,_=n-p,M=s-c*p,b=M-h*p,x=b-c*_,m=h*_-x;return r?(r[0]=m,r[1]=s,r):[m,s]}return Oa}var za,rh;function Lf(){if(rh)return za;rh=1,za=t;function i(e,n){var r=e+n,s=r-e,a=r-s,o=n-s,c=e-a,h=c+o;return h?[h,r]:[r]}function t(e,n){var r=e.length|0,s=n.length|0;if(r===1&&s===1)return i(e[0],n[0]);var a=r+s,o=new Array(a),c=0,h=0,f=0,g=Math.abs,p=e[h],_=g(p),M=n[f],b=g(M),x,m;_<b?(m=p,h+=1,h<r&&(p=e[h],_=g(p))):(m=M,f+=1,f<s&&(M=n[f],b=g(M))),h<r&&_<b||f>=s?(x=p,h+=1,h<r&&(p=e[h],_=g(p))):(x=M,f+=1,f<s&&(M=n[f],b=g(M)));for(var d=x+m,u=d-x,v=m-u,l=v,R=d,T,E,y,S,A;h<r&&f<s;)_<b?(x=p,h+=1,h<r&&(p=e[h],_=g(p))):(x=M,f+=1,f<s&&(M=n[f],b=g(M))),m=l,d=x+m,u=d-x,v=m-u,v&&(o[c++]=v),T=R+d,E=T-R,y=T-E,S=d-E,A=R-y,l=A+S,R=T;for(;h<r;)x=p,m=l,d=x+m,u=d-x,v=m-u,v&&(o[c++]=v),T=R+d,E=T-R,y=T-E,S=d-E,A=R-y,l=A+S,R=T,h+=1,h<r&&(p=e[h]);for(;f<s;)x=M,m=l,d=x+m,u=d-x,v=m-u,v&&(o[c++]=v),T=R+d,E=T-R,y=T-E,S=d-E,A=R-y,l=A+S,R=T,f+=1,f<s&&(M=n[f]);return l&&(o[c++]=l),R&&(o[c++]=R),c||(o[c++]=0),o.length=c,o}return za}var Va,sh;function Fv(){if(sh)return Va;sh=1,Va=i;function i(t,e,n){var r=t+e,s=r-t,a=r-s,o=e-s,c=t-a;return n?(n[0]=c+o,n[1]=r,n):[c+o,r]}return Va}var Ha,oh;function Df(){if(oh)return Ha;oh=1;var i=Dl(),t=Fv();Ha=e;function e(n,r){var s=n.length;if(s===1){var a=i(n[0],r);return a[0]?a:[a[1]]}var o=new Array(2*s),c=[.1,.1],h=[.1,.1],f=0;i(n[0],r,c),c[0]&&(o[f++]=c[0]);for(var g=1;g<s;++g){i(n[g],r,h);var p=c[1];t(p,h[0],c),c[0]&&(o[f++]=c[0]);var _=h[1],M=c[1],b=_+M,x=b-_,m=M-x;c[1]=b,m&&(o[f++]=m)}return c[1]&&(o[f++]=c[1]),f===0&&(o[f++]=0),o.length=f,o}return Ha}var Ga,ah;function Uf(){if(ah)return Ga;ah=1,Ga=t;function i(e,n){var r=e+n,s=r-e,a=r-s,o=n-s,c=e-a,h=c+o;return h?[h,r]:[r]}function t(e,n){var r=e.length|0,s=n.length|0;if(r===1&&s===1)return i(e[0],-n[0]);var a=r+s,o=new Array(a),c=0,h=0,f=0,g=Math.abs,p=e[h],_=g(p),M=-n[f],b=g(M),x,m;_<b?(m=p,h+=1,h<r&&(p=e[h],_=g(p))):(m=M,f+=1,f<s&&(M=-n[f],b=g(M))),h<r&&_<b||f>=s?(x=p,h+=1,h<r&&(p=e[h],_=g(p))):(x=M,f+=1,f<s&&(M=-n[f],b=g(M)));for(var d=x+m,u=d-x,v=m-u,l=v,R=d,T,E,y,S,A;h<r&&f<s;)_<b?(x=p,h+=1,h<r&&(p=e[h],_=g(p))):(x=M,f+=1,f<s&&(M=-n[f],b=g(M))),m=l,d=x+m,u=d-x,v=m-u,v&&(o[c++]=v),T=R+d,E=T-R,y=T-E,S=d-E,A=R-y,l=A+S,R=T;for(;h<r;)x=p,m=l,d=x+m,u=d-x,v=m-u,v&&(o[c++]=v),T=R+d,E=T-R,y=T-E,S=d-E,A=R-y,l=A+S,R=T,h+=1,h<r&&(p=e[h]);for(;f<s;)x=M,m=l,d=x+m,u=d-x,v=m-u,v&&(o[c++]=v),T=R+d,E=T-R,y=T-E,S=d-E,A=R-y,l=A+S,R=T,f+=1,f<s&&(M=-n[f]);return l&&(o[c++]=l),R&&(o[c++]=R),c||(o[c++]=0),o.length=c,o}return Ga}var ch;function Bv(){return ch||(ch=1,function(i){var t=Dl(),e=Lf(),n=Df(),r=Uf(),s=5,a=11102230246251565e-32,o=(3+16*a)*a,c=(7+56*a)*a;function h(u,v,l,R){return function(E,y,S){var A=u(u(v(y[1],S[0]),v(-S[1],y[0])),u(v(E[1],y[0]),v(-y[1],E[0]))),w=u(v(E[1],S[0]),v(-S[1],E[0])),I=R(A,w);return I[I.length-1]}}function f(u,v,l,R){return function(E,y,S,A){var w=u(u(l(u(v(S[1],A[0]),v(-A[1],S[0])),y[2]),u(l(u(v(y[1],A[0]),v(-A[1],y[0])),-S[2]),l(u(v(y[1],S[0]),v(-S[1],y[0])),A[2]))),u(l(u(v(y[1],A[0]),v(-A[1],y[0])),E[2]),u(l(u(v(E[1],A[0]),v(-A[1],E[0])),-y[2]),l(u(v(E[1],y[0]),v(-y[1],E[0])),A[2])))),I=u(u(l(u(v(S[1],A[0]),v(-A[1],S[0])),E[2]),u(l(u(v(E[1],A[0]),v(-A[1],E[0])),-S[2]),l(u(v(E[1],S[0]),v(-S[1],E[0])),A[2]))),u(l(u(v(y[1],S[0]),v(-S[1],y[0])),E[2]),u(l(u(v(E[1],S[0]),v(-S[1],E[0])),-y[2]),l(u(v(E[1],y[0]),v(-y[1],E[0])),S[2])))),N=R(w,I);return N[N.length-1]}}function g(u,v,l,R){return function(E,y,S,A,w){var I=u(u(u(l(u(l(u(v(A[1],w[0]),v(-w[1],A[0])),S[2]),u(l(u(v(S[1],w[0]),v(-w[1],S[0])),-A[2]),l(u(v(S[1],A[0]),v(-A[1],S[0])),w[2]))),y[3]),u(l(u(l(u(v(A[1],w[0]),v(-w[1],A[0])),y[2]),u(l(u(v(y[1],w[0]),v(-w[1],y[0])),-A[2]),l(u(v(y[1],A[0]),v(-A[1],y[0])),w[2]))),-S[3]),l(u(l(u(v(S[1],w[0]),v(-w[1],S[0])),y[2]),u(l(u(v(y[1],w[0]),v(-w[1],y[0])),-S[2]),l(u(v(y[1],S[0]),v(-S[1],y[0])),w[2]))),A[3]))),u(l(u(l(u(v(S[1],A[0]),v(-A[1],S[0])),y[2]),u(l(u(v(y[1],A[0]),v(-A[1],y[0])),-S[2]),l(u(v(y[1],S[0]),v(-S[1],y[0])),A[2]))),-w[3]),u(l(u(l(u(v(A[1],w[0]),v(-w[1],A[0])),y[2]),u(l(u(v(y[1],w[0]),v(-w[1],y[0])),-A[2]),l(u(v(y[1],A[0]),v(-A[1],y[0])),w[2]))),E[3]),l(u(l(u(v(A[1],w[0]),v(-w[1],A[0])),E[2]),u(l(u(v(E[1],w[0]),v(-w[1],E[0])),-A[2]),l(u(v(E[1],A[0]),v(-A[1],E[0])),w[2]))),-y[3])))),u(u(l(u(l(u(v(y[1],w[0]),v(-w[1],y[0])),E[2]),u(l(u(v(E[1],w[0]),v(-w[1],E[0])),-y[2]),l(u(v(E[1],y[0]),v(-y[1],E[0])),w[2]))),A[3]),u(l(u(l(u(v(y[1],A[0]),v(-A[1],y[0])),E[2]),u(l(u(v(E[1],A[0]),v(-A[1],E[0])),-y[2]),l(u(v(E[1],y[0]),v(-y[1],E[0])),A[2]))),-w[3]),l(u(l(u(v(S[1],A[0]),v(-A[1],S[0])),y[2]),u(l(u(v(y[1],A[0]),v(-A[1],y[0])),-S[2]),l(u(v(y[1],S[0]),v(-S[1],y[0])),A[2]))),E[3]))),u(l(u(l(u(v(S[1],A[0]),v(-A[1],S[0])),E[2]),u(l(u(v(E[1],A[0]),v(-A[1],E[0])),-S[2]),l(u(v(E[1],S[0]),v(-S[1],E[0])),A[2]))),-y[3]),u(l(u(l(u(v(y[1],A[0]),v(-A[1],y[0])),E[2]),u(l(u(v(E[1],A[0]),v(-A[1],E[0])),-y[2]),l(u(v(E[1],y[0]),v(-y[1],E[0])),A[2]))),S[3]),l(u(l(u(v(y[1],S[0]),v(-S[1],y[0])),E[2]),u(l(u(v(E[1],S[0]),v(-S[1],E[0])),-y[2]),l(u(v(E[1],y[0]),v(-y[1],E[0])),S[2]))),-A[3]))))),N=u(u(u(l(u(l(u(v(A[1],w[0]),v(-w[1],A[0])),S[2]),u(l(u(v(S[1],w[0]),v(-w[1],S[0])),-A[2]),l(u(v(S[1],A[0]),v(-A[1],S[0])),w[2]))),E[3]),l(u(l(u(v(A[1],w[0]),v(-w[1],A[0])),E[2]),u(l(u(v(E[1],w[0]),v(-w[1],E[0])),-A[2]),l(u(v(E[1],A[0]),v(-A[1],E[0])),w[2]))),-S[3])),u(l(u(l(u(v(S[1],w[0]),v(-w[1],S[0])),E[2]),u(l(u(v(E[1],w[0]),v(-w[1],E[0])),-S[2]),l(u(v(E[1],S[0]),v(-S[1],E[0])),w[2]))),A[3]),l(u(l(u(v(S[1],A[0]),v(-A[1],S[0])),E[2]),u(l(u(v(E[1],A[0]),v(-A[1],E[0])),-S[2]),l(u(v(E[1],S[0]),v(-S[1],E[0])),A[2]))),-w[3]))),u(u(l(u(l(u(v(S[1],w[0]),v(-w[1],S[0])),y[2]),u(l(u(v(y[1],w[0]),v(-w[1],y[0])),-S[2]),l(u(v(y[1],S[0]),v(-S[1],y[0])),w[2]))),E[3]),l(u(l(u(v(S[1],w[0]),v(-w[1],S[0])),E[2]),u(l(u(v(E[1],w[0]),v(-w[1],E[0])),-S[2]),l(u(v(E[1],S[0]),v(-S[1],E[0])),w[2]))),-y[3])),u(l(u(l(u(v(y[1],w[0]),v(-w[1],y[0])),E[2]),u(l(u(v(E[1],w[0]),v(-w[1],E[0])),-y[2]),l(u(v(E[1],y[0]),v(-y[1],E[0])),w[2]))),S[3]),l(u(l(u(v(y[1],S[0]),v(-S[1],y[0])),E[2]),u(l(u(v(E[1],S[0]),v(-S[1],E[0])),-y[2]),l(u(v(E[1],y[0]),v(-y[1],E[0])),S[2]))),-w[3])))),B=R(I,N);return B[B.length-1]}}function p(u){var v=u===3?h:u===4?f:g;return v(e,t,n,r)}var _=p(3),M=p(4),b=[function(){return 0},function(){return 0},function(v,l){return l[0]-v[0]},function(v,l,R){var T=(v[1]-R[1])*(l[0]-R[0]),E=(v[0]-R[0])*(l[1]-R[1]),y=T-E,S;if(T>0){if(E<=0)return y;S=T+E}else if(T<0){if(E>=0)return y;S=-(T+E)}else return y;var A=o*S;return y>=A||y<=-A?y:_(v,l,R)},function(v,l,R,T){var E=v[0]-T[0],y=l[0]-T[0],S=R[0]-T[0],A=v[1]-T[1],w=l[1]-T[1],I=R[1]-T[1],N=v[2]-T[2],B=l[2]-T[2],F=R[2]-T[2],k=y*I,z=S*w,J=S*A,Z=E*I,it=E*w,pt=y*A,_t=N*(k-z)+B*(J-Z)+F*(it-pt),W=(Math.abs(k)+Math.abs(z))*Math.abs(N)+(Math.abs(J)+Math.abs(Z))*Math.abs(B)+(Math.abs(it)+Math.abs(pt))*Math.abs(F),tt=c*W;return _t>tt||-_t>tt?_t:M(v,l,R,T)}];function x(u){var v=b[u.length];return v||(v=b[u.length]=p(u.length)),v.apply(void 0,u)}function m(u,v,l,R,T,E,y){return function(A,w,I,N,B){switch(arguments.length){case 0:case 1:return 0;case 2:return R(A,w);case 3:return T(A,w,I);case 4:return E(A,w,I,N);case 5:return y(A,w,I,N,B)}for(var F=new Array(arguments.length),k=0;k<arguments.length;++k)F[k]=arguments[k];return u(F)}}function d(){for(;b.length<=s;)b.push(p(b.length));i.exports=m.apply(void 0,[x].concat(b));for(var u=0;u<=s;++u)i.exports[u]=b[u]}d()}(Ba)),Ba.exports}var ka,lh;function Ov(){if(lh)return ka;lh=1;var i=$o(),t=Bv()[3],e=0,n=1,r=2;ka=_;function s(M,b,x,m,d){this.a=M,this.b=b,this.idx=x,this.lowerIds=m,this.upperIds=d}function a(M,b,x,m){this.a=M,this.b=b,this.type=x,this.idx=m}function o(M,b){var x=M.a[0]-b.a[0]||M.a[1]-b.a[1]||M.type-b.type;return x||M.type!==e&&(x=t(M.a,M.b,b.b),x)?x:M.idx-b.idx}function c(M,b){return t(M.a,M.b,b)}function h(M,b,x,m,d){for(var u=i.lt(b,m,c),v=i.gt(b,m,c),l=u;l<v;++l){for(var R=b[l],T=R.lowerIds,y=T.length;y>1&&t(x[T[y-2]],x[T[y-1]],m)>0;)M.push([T[y-1],T[y-2],d]),y-=1;T.length=y,T.push(d);for(var E=R.upperIds,y=E.length;y>1&&t(x[E[y-2]],x[E[y-1]],m)<0;)M.push([E[y-2],E[y-1],d]),y-=1;E.length=y,E.push(d)}}function f(M,b){var x;return M.a[0]<b.a[0]?x=t(M.a,M.b,b.a):x=t(b.b,b.a,M.a),x||(b.b[0]<M.b[0]?x=t(M.a,M.b,b.b):x=t(b.b,b.a,M.b),x||M.idx-b.idx)}function g(M,b,x){var m=i.le(M,x,f),d=M[m],u=d.upperIds,v=u[u.length-1];d.upperIds=[v],M.splice(m+1,0,new s(x.a,x.b,x.idx,[v],u))}function p(M,b,x){var m=x.a;x.a=x.b,x.b=m;var d=i.eq(M,x,f),u=M[d],v=M[d-1];v.upperIds=u.upperIds,M.splice(d,1)}function _(M,b){for(var x=M.length,m=b.length,d=[],u=0;u<x;++u)d.push(new a(M[u],null,e,u));for(var u=0;u<m;++u){var v=b[u],l=M[v[0]],R=M[v[1]];l[0]<R[0]?d.push(new a(l,R,r,u),new a(R,l,n,u)):l[0]>R[0]&&d.push(new a(R,l,r,u),new a(l,R,n,u))}d.sort(o);for(var T=d[0].a[0]-(1+Math.abs(d[0].a[0]))*Math.pow(2,-52),E=[new s([T,1],[T,0],-1,[],[])],y=[],u=0,S=d.length;u<S;++u){var A=d[u],w=A.type;w===e?h(y,E,M,A.a,A.idx):w===r?g(E,M,A):p(E,M,A)}return y}return ka}var Wa,uh;function zv(){if(uh)return Wa;uh=1;var i=$o();Wa=r;function t(s,a){this.stars=s,this.edges=a}var e=t.prototype;function n(s,a,o){for(var c=1,h=s.length;c<h;c+=2)if(s[c-1]===a&&s[c]===o){s[c-1]=s[h-2],s[c]=s[h-1],s.length=h-2;return}}e.isConstraint=function(){var s=[0,0];function a(o,c){return o[0]-c[0]||o[1]-c[1]}return function(o,c){return s[0]=Math.min(o,c),s[1]=Math.max(o,c),i.eq(this.edges,s,a)>=0}}(),e.removeTriangle=function(s,a,o){var c=this.stars;n(c[s],a,o),n(c[a],o,s),n(c[o],s,a)},e.addTriangle=function(s,a,o){var c=this.stars;c[s].push(a,o),c[a].push(o,s),c[o].push(s,a)},e.opposite=function(s,a){for(var o=this.stars[a],c=1,h=o.length;c<h;c+=2)if(o[c]===s)return o[c-1];return-1},e.flip=function(s,a){var o=this.opposite(s,a),c=this.opposite(a,s);this.removeTriangle(s,a,o),this.removeTriangle(a,s,c),this.addTriangle(s,c,o),this.addTriangle(a,o,c)},e.edges=function(){for(var s=this.stars,a=[],o=0,c=s.length;o<c;++o)for(var h=s[o],f=0,g=h.length;f<g;f+=2)a.push([h[f],h[f+1]]);return a},e.cells=function(){for(var s=this.stars,a=[],o=0,c=s.length;o<c;++o)for(var h=s[o],f=0,g=h.length;f<g;f+=2){var p=h[f],_=h[f+1];o<Math.min(p,_)&&a.push([o,p,_])}return a};function r(s,a){for(var o=new Array(s),c=0;c<s;++c)o[c]=[];return new t(o,a)}return Wa}var Xa={exports:{}},hh;function Vv(){return hh||(hh=1,function(i){var t=Dl(),e=Lf(),n=Uf(),r=Df(),s=6;function a(d){var u=d===3?f:d===4?g:d===5?p:_;return u(e,n,t,r)}function o(){return 0}function c(){return 0}function h(){return 0}function f(d,u,v,l){function R(T,E,y){var S=v(T[0],T[0]),A=l(S,E[0]),w=l(S,y[0]),I=v(E[0],E[0]),N=l(I,T[0]),B=l(I,y[0]),F=v(y[0],y[0]),k=l(F,T[0]),z=l(F,E[0]),J=d(u(z,B),u(N,A)),Z=u(k,w),it=u(J,Z);return it[it.length-1]}return R}function g(d,u,v,l){function R(T,E,y,S){var A=d(v(T[0],T[0]),v(T[1],T[1])),w=l(A,E[0]),I=l(A,y[0]),N=l(A,S[0]),B=d(v(E[0],E[0]),v(E[1],E[1])),F=l(B,T[0]),k=l(B,y[0]),z=l(B,S[0]),J=d(v(y[0],y[0]),v(y[1],y[1])),Z=l(J,T[0]),it=l(J,E[0]),pt=l(J,S[0]),_t=d(v(S[0],S[0]),v(S[1],S[1])),W=l(_t,T[0]),tt=l(_t,E[0]),st=l(_t,y[0]),Q=d(d(l(u(st,pt),E[1]),d(l(u(tt,z),-y[1]),l(u(it,k),S[1]))),d(l(u(tt,z),T[1]),d(l(u(W,N),-E[1]),l(u(F,w),S[1])))),at=d(d(l(u(st,pt),T[1]),d(l(u(W,N),-y[1]),l(u(Z,I),S[1]))),d(l(u(it,k),T[1]),d(l(u(Z,I),-E[1]),l(u(F,w),y[1])))),xt=u(Q,at);return xt[xt.length-1]}return R}function p(d,u,v,l){function R(T,E,y,S,A){var w=d(v(T[0],T[0]),d(v(T[1],T[1]),v(T[2],T[2]))),I=l(w,E[0]),N=l(w,y[0]),B=l(w,S[0]),F=l(w,A[0]),k=d(v(E[0],E[0]),d(v(E[1],E[1]),v(E[2],E[2]))),z=l(k,T[0]),J=l(k,y[0]),Z=l(k,S[0]),it=l(k,A[0]),pt=d(v(y[0],y[0]),d(v(y[1],y[1]),v(y[2],y[2]))),_t=l(pt,T[0]),W=l(pt,E[0]),tt=l(pt,S[0]),st=l(pt,A[0]),Q=d(v(S[0],S[0]),d(v(S[1],S[1]),v(S[2],S[2]))),at=l(Q,T[0]),xt=l(Q,E[0]),lt=l(Q,y[0]),jt=l(Q,A[0]),Lt=d(v(A[0],A[0]),d(v(A[1],A[1]),v(A[2],A[2]))),Mt=l(Lt,T[0]),D=l(Lt,E[0]),Ft=l(Lt,y[0]),Et=l(Lt,S[0]),Zt=d(d(d(l(d(l(u(Et,jt),y[1]),d(l(u(Ft,st),-S[1]),l(u(lt,tt),A[1]))),E[2]),d(l(d(l(u(Et,jt),E[1]),d(l(u(D,it),-S[1]),l(u(xt,Z),A[1]))),-y[2]),l(d(l(u(Ft,st),E[1]),d(l(u(D,it),-y[1]),l(u(W,J),A[1]))),S[2]))),d(l(d(l(u(lt,tt),E[1]),d(l(u(xt,Z),-y[1]),l(u(W,J),S[1]))),-A[2]),d(l(d(l(u(Et,jt),E[1]),d(l(u(D,it),-S[1]),l(u(xt,Z),A[1]))),T[2]),l(d(l(u(Et,jt),T[1]),d(l(u(Mt,F),-S[1]),l(u(at,B),A[1]))),-E[2])))),d(d(l(d(l(u(D,it),T[1]),d(l(u(Mt,F),-E[1]),l(u(z,I),A[1]))),S[2]),d(l(d(l(u(xt,Z),T[1]),d(l(u(at,B),-E[1]),l(u(z,I),S[1]))),-A[2]),l(d(l(u(lt,tt),E[1]),d(l(u(xt,Z),-y[1]),l(u(W,J),S[1]))),T[2]))),d(l(d(l(u(lt,tt),T[1]),d(l(u(at,B),-y[1]),l(u(_t,N),S[1]))),-E[2]),d(l(d(l(u(xt,Z),T[1]),d(l(u(at,B),-E[1]),l(u(z,I),S[1]))),y[2]),l(d(l(u(W,J),T[1]),d(l(u(_t,N),-E[1]),l(u(z,I),y[1]))),-S[2]))))),ct=d(d(d(l(d(l(u(Et,jt),y[1]),d(l(u(Ft,st),-S[1]),l(u(lt,tt),A[1]))),T[2]),l(d(l(u(Et,jt),T[1]),d(l(u(Mt,F),-S[1]),l(u(at,B),A[1]))),-y[2])),d(l(d(l(u(Ft,st),T[1]),d(l(u(Mt,F),-y[1]),l(u(_t,N),A[1]))),S[2]),l(d(l(u(lt,tt),T[1]),d(l(u(at,B),-y[1]),l(u(_t,N),S[1]))),-A[2]))),d(d(l(d(l(u(Ft,st),E[1]),d(l(u(D,it),-y[1]),l(u(W,J),A[1]))),T[2]),l(d(l(u(Ft,st),T[1]),d(l(u(Mt,F),-y[1]),l(u(_t,N),A[1]))),-E[2])),d(l(d(l(u(D,it),T[1]),d(l(u(Mt,F),-E[1]),l(u(z,I),A[1]))),y[2]),l(d(l(u(W,J),T[1]),d(l(u(_t,N),-E[1]),l(u(z,I),y[1]))),-A[2])))),Rt=u(Zt,ct);return Rt[Rt.length-1]}return R}function _(d,u,v,l){function R(T,E,y,S,A,w){var I=d(d(v(T[0],T[0]),v(T[1],T[1])),d(v(T[2],T[2]),v(T[3],T[3]))),N=l(I,E[0]),B=l(I,y[0]),F=l(I,S[0]),k=l(I,A[0]),z=l(I,w[0]),J=d(d(v(E[0],E[0]),v(E[1],E[1])),d(v(E[2],E[2]),v(E[3],E[3]))),Z=l(J,T[0]),it=l(J,y[0]),pt=l(J,S[0]),_t=l(J,A[0]),W=l(J,w[0]),tt=d(d(v(y[0],y[0]),v(y[1],y[1])),d(v(y[2],y[2]),v(y[3],y[3]))),st=l(tt,T[0]),Q=l(tt,E[0]),at=l(tt,S[0]),xt=l(tt,A[0]),lt=l(tt,w[0]),jt=d(d(v(S[0],S[0]),v(S[1],S[1])),d(v(S[2],S[2]),v(S[3],S[3]))),Lt=l(jt,T[0]),Mt=l(jt,E[0]),D=l(jt,y[0]),Ft=l(jt,A[0]),Et=l(jt,w[0]),Zt=d(d(v(A[0],A[0]),v(A[1],A[1])),d(v(A[2],A[2]),v(A[3],A[3]))),ct=l(Zt,T[0]),Rt=l(Zt,E[0]),ut=l(Zt,y[0]),vt=l(Zt,S[0]),zt=l(Zt,w[0]),L=d(d(v(w[0],w[0]),v(w[1],w[1])),d(v(w[2],w[2]),v(w[3],w[3]))),C=l(L,T[0]),V=l(L,E[0]),$=l(L,y[0]),j=l(L,S[0]),X=l(L,A[0]),Ct=d(d(d(l(d(d(l(d(l(u(X,zt),S[1]),d(l(u(j,Et),-A[1]),l(u(vt,Ft),w[1]))),y[2]),l(d(l(u(X,zt),y[1]),d(l(u($,lt),-A[1]),l(u(ut,xt),w[1]))),-S[2])),d(l(d(l(u(j,Et),y[1]),d(l(u($,lt),-S[1]),l(u(D,at),w[1]))),A[2]),l(d(l(u(vt,Ft),y[1]),d(l(u(ut,xt),-S[1]),l(u(D,at),A[1]))),-w[2]))),E[3]),d(l(d(d(l(d(l(u(X,zt),S[1]),d(l(u(j,Et),-A[1]),l(u(vt,Ft),w[1]))),E[2]),l(d(l(u(X,zt),E[1]),d(l(u(V,W),-A[1]),l(u(Rt,_t),w[1]))),-S[2])),d(l(d(l(u(j,Et),E[1]),d(l(u(V,W),-S[1]),l(u(Mt,pt),w[1]))),A[2]),l(d(l(u(vt,Ft),E[1]),d(l(u(Rt,_t),-S[1]),l(u(Mt,pt),A[1]))),-w[2]))),-y[3]),l(d(d(l(d(l(u(X,zt),y[1]),d(l(u($,lt),-A[1]),l(u(ut,xt),w[1]))),E[2]),l(d(l(u(X,zt),E[1]),d(l(u(V,W),-A[1]),l(u(Rt,_t),w[1]))),-y[2])),d(l(d(l(u($,lt),E[1]),d(l(u(V,W),-y[1]),l(u(Q,it),w[1]))),A[2]),l(d(l(u(ut,xt),E[1]),d(l(u(Rt,_t),-y[1]),l(u(Q,it),A[1]))),-w[2]))),S[3]))),d(d(l(d(d(l(d(l(u(j,Et),y[1]),d(l(u($,lt),-S[1]),l(u(D,at),w[1]))),E[2]),l(d(l(u(j,Et),E[1]),d(l(u(V,W),-S[1]),l(u(Mt,pt),w[1]))),-y[2])),d(l(d(l(u($,lt),E[1]),d(l(u(V,W),-y[1]),l(u(Q,it),w[1]))),S[2]),l(d(l(u(D,at),E[1]),d(l(u(Mt,pt),-y[1]),l(u(Q,it),S[1]))),-w[2]))),-A[3]),l(d(d(l(d(l(u(vt,Ft),y[1]),d(l(u(ut,xt),-S[1]),l(u(D,at),A[1]))),E[2]),l(d(l(u(vt,Ft),E[1]),d(l(u(Rt,_t),-S[1]),l(u(Mt,pt),A[1]))),-y[2])),d(l(d(l(u(ut,xt),E[1]),d(l(u(Rt,_t),-y[1]),l(u(Q,it),A[1]))),S[2]),l(d(l(u(D,at),E[1]),d(l(u(Mt,pt),-y[1]),l(u(Q,it),S[1]))),-A[2]))),w[3])),d(l(d(d(l(d(l(u(X,zt),S[1]),d(l(u(j,Et),-A[1]),l(u(vt,Ft),w[1]))),E[2]),l(d(l(u(X,zt),E[1]),d(l(u(V,W),-A[1]),l(u(Rt,_t),w[1]))),-S[2])),d(l(d(l(u(j,Et),E[1]),d(l(u(V,W),-S[1]),l(u(Mt,pt),w[1]))),A[2]),l(d(l(u(vt,Ft),E[1]),d(l(u(Rt,_t),-S[1]),l(u(Mt,pt),A[1]))),-w[2]))),T[3]),l(d(d(l(d(l(u(X,zt),S[1]),d(l(u(j,Et),-A[1]),l(u(vt,Ft),w[1]))),T[2]),l(d(l(u(X,zt),T[1]),d(l(u(C,z),-A[1]),l(u(ct,k),w[1]))),-S[2])),d(l(d(l(u(j,Et),T[1]),d(l(u(C,z),-S[1]),l(u(Lt,F),w[1]))),A[2]),l(d(l(u(vt,Ft),T[1]),d(l(u(ct,k),-S[1]),l(u(Lt,F),A[1]))),-w[2]))),-E[3])))),d(d(d(l(d(d(l(d(l(u(X,zt),E[1]),d(l(u(V,W),-A[1]),l(u(Rt,_t),w[1]))),T[2]),l(d(l(u(X,zt),T[1]),d(l(u(C,z),-A[1]),l(u(ct,k),w[1]))),-E[2])),d(l(d(l(u(V,W),T[1]),d(l(u(C,z),-E[1]),l(u(Z,N),w[1]))),A[2]),l(d(l(u(Rt,_t),T[1]),d(l(u(ct,k),-E[1]),l(u(Z,N),A[1]))),-w[2]))),S[3]),l(d(d(l(d(l(u(j,Et),E[1]),d(l(u(V,W),-S[1]),l(u(Mt,pt),w[1]))),T[2]),l(d(l(u(j,Et),T[1]),d(l(u(C,z),-S[1]),l(u(Lt,F),w[1]))),-E[2])),d(l(d(l(u(V,W),T[1]),d(l(u(C,z),-E[1]),l(u(Z,N),w[1]))),S[2]),l(d(l(u(Mt,pt),T[1]),d(l(u(Lt,F),-E[1]),l(u(Z,N),S[1]))),-w[2]))),-A[3])),d(l(d(d(l(d(l(u(vt,Ft),E[1]),d(l(u(Rt,_t),-S[1]),l(u(Mt,pt),A[1]))),T[2]),l(d(l(u(vt,Ft),T[1]),d(l(u(ct,k),-S[1]),l(u(Lt,F),A[1]))),-E[2])),d(l(d(l(u(Rt,_t),T[1]),d(l(u(ct,k),-E[1]),l(u(Z,N),A[1]))),S[2]),l(d(l(u(Mt,pt),T[1]),d(l(u(Lt,F),-E[1]),l(u(Z,N),S[1]))),-A[2]))),w[3]),l(d(d(l(d(l(u(j,Et),y[1]),d(l(u($,lt),-S[1]),l(u(D,at),w[1]))),E[2]),l(d(l(u(j,Et),E[1]),d(l(u(V,W),-S[1]),l(u(Mt,pt),w[1]))),-y[2])),d(l(d(l(u($,lt),E[1]),d(l(u(V,W),-y[1]),l(u(Q,it),w[1]))),S[2]),l(d(l(u(D,at),E[1]),d(l(u(Mt,pt),-y[1]),l(u(Q,it),S[1]))),-w[2]))),T[3]))),d(d(l(d(d(l(d(l(u(j,Et),y[1]),d(l(u($,lt),-S[1]),l(u(D,at),w[1]))),T[2]),l(d(l(u(j,Et),T[1]),d(l(u(C,z),-S[1]),l(u(Lt,F),w[1]))),-y[2])),d(l(d(l(u($,lt),T[1]),d(l(u(C,z),-y[1]),l(u(st,B),w[1]))),S[2]),l(d(l(u(D,at),T[1]),d(l(u(Lt,F),-y[1]),l(u(st,B),S[1]))),-w[2]))),-E[3]),l(d(d(l(d(l(u(j,Et),E[1]),d(l(u(V,W),-S[1]),l(u(Mt,pt),w[1]))),T[2]),l(d(l(u(j,Et),T[1]),d(l(u(C,z),-S[1]),l(u(Lt,F),w[1]))),-E[2])),d(l(d(l(u(V,W),T[1]),d(l(u(C,z),-E[1]),l(u(Z,N),w[1]))),S[2]),l(d(l(u(Mt,pt),T[1]),d(l(u(Lt,F),-E[1]),l(u(Z,N),S[1]))),-w[2]))),y[3])),d(l(d(d(l(d(l(u($,lt),E[1]),d(l(u(V,W),-y[1]),l(u(Q,it),w[1]))),T[2]),l(d(l(u($,lt),T[1]),d(l(u(C,z),-y[1]),l(u(st,B),w[1]))),-E[2])),d(l(d(l(u(V,W),T[1]),d(l(u(C,z),-E[1]),l(u(Z,N),w[1]))),y[2]),l(d(l(u(Q,it),T[1]),d(l(u(st,B),-E[1]),l(u(Z,N),y[1]))),-w[2]))),-S[3]),l(d(d(l(d(l(u(D,at),E[1]),d(l(u(Mt,pt),-y[1]),l(u(Q,it),S[1]))),T[2]),l(d(l(u(D,at),T[1]),d(l(u(Lt,F),-y[1]),l(u(st,B),S[1]))),-E[2])),d(l(d(l(u(Mt,pt),T[1]),d(l(u(Lt,F),-E[1]),l(u(Z,N),S[1]))),y[2]),l(d(l(u(Q,it),T[1]),d(l(u(st,B),-E[1]),l(u(Z,N),y[1]))),-S[2]))),w[3]))))),ht=d(d(d(l(d(d(l(d(l(u(X,zt),S[1]),d(l(u(j,Et),-A[1]),l(u(vt,Ft),w[1]))),y[2]),l(d(l(u(X,zt),y[1]),d(l(u($,lt),-A[1]),l(u(ut,xt),w[1]))),-S[2])),d(l(d(l(u(j,Et),y[1]),d(l(u($,lt),-S[1]),l(u(D,at),w[1]))),A[2]),l(d(l(u(vt,Ft),y[1]),d(l(u(ut,xt),-S[1]),l(u(D,at),A[1]))),-w[2]))),T[3]),d(l(d(d(l(d(l(u(X,zt),S[1]),d(l(u(j,Et),-A[1]),l(u(vt,Ft),w[1]))),T[2]),l(d(l(u(X,zt),T[1]),d(l(u(C,z),-A[1]),l(u(ct,k),w[1]))),-S[2])),d(l(d(l(u(j,Et),T[1]),d(l(u(C,z),-S[1]),l(u(Lt,F),w[1]))),A[2]),l(d(l(u(vt,Ft),T[1]),d(l(u(ct,k),-S[1]),l(u(Lt,F),A[1]))),-w[2]))),-y[3]),l(d(d(l(d(l(u(X,zt),y[1]),d(l(u($,lt),-A[1]),l(u(ut,xt),w[1]))),T[2]),l(d(l(u(X,zt),T[1]),d(l(u(C,z),-A[1]),l(u(ct,k),w[1]))),-y[2])),d(l(d(l(u($,lt),T[1]),d(l(u(C,z),-y[1]),l(u(st,B),w[1]))),A[2]),l(d(l(u(ut,xt),T[1]),d(l(u(ct,k),-y[1]),l(u(st,B),A[1]))),-w[2]))),S[3]))),d(d(l(d(d(l(d(l(u(j,Et),y[1]),d(l(u($,lt),-S[1]),l(u(D,at),w[1]))),T[2]),l(d(l(u(j,Et),T[1]),d(l(u(C,z),-S[1]),l(u(Lt,F),w[1]))),-y[2])),d(l(d(l(u($,lt),T[1]),d(l(u(C,z),-y[1]),l(u(st,B),w[1]))),S[2]),l(d(l(u(D,at),T[1]),d(l(u(Lt,F),-y[1]),l(u(st,B),S[1]))),-w[2]))),-A[3]),l(d(d(l(d(l(u(vt,Ft),y[1]),d(l(u(ut,xt),-S[1]),l(u(D,at),A[1]))),T[2]),l(d(l(u(vt,Ft),T[1]),d(l(u(ct,k),-S[1]),l(u(Lt,F),A[1]))),-y[2])),d(l(d(l(u(ut,xt),T[1]),d(l(u(ct,k),-y[1]),l(u(st,B),A[1]))),S[2]),l(d(l(u(D,at),T[1]),d(l(u(Lt,F),-y[1]),l(u(st,B),S[1]))),-A[2]))),w[3])),d(l(d(d(l(d(l(u(X,zt),y[1]),d(l(u($,lt),-A[1]),l(u(ut,xt),w[1]))),E[2]),l(d(l(u(X,zt),E[1]),d(l(u(V,W),-A[1]),l(u(Rt,_t),w[1]))),-y[2])),d(l(d(l(u($,lt),E[1]),d(l(u(V,W),-y[1]),l(u(Q,it),w[1]))),A[2]),l(d(l(u(ut,xt),E[1]),d(l(u(Rt,_t),-y[1]),l(u(Q,it),A[1]))),-w[2]))),T[3]),l(d(d(l(d(l(u(X,zt),y[1]),d(l(u($,lt),-A[1]),l(u(ut,xt),w[1]))),T[2]),l(d(l(u(X,zt),T[1]),d(l(u(C,z),-A[1]),l(u(ct,k),w[1]))),-y[2])),d(l(d(l(u($,lt),T[1]),d(l(u(C,z),-y[1]),l(u(st,B),w[1]))),A[2]),l(d(l(u(ut,xt),T[1]),d(l(u(ct,k),-y[1]),l(u(st,B),A[1]))),-w[2]))),-E[3])))),d(d(d(l(d(d(l(d(l(u(X,zt),E[1]),d(l(u(V,W),-A[1]),l(u(Rt,_t),w[1]))),T[2]),l(d(l(u(X,zt),T[1]),d(l(u(C,z),-A[1]),l(u(ct,k),w[1]))),-E[2])),d(l(d(l(u(V,W),T[1]),d(l(u(C,z),-E[1]),l(u(Z,N),w[1]))),A[2]),l(d(l(u(Rt,_t),T[1]),d(l(u(ct,k),-E[1]),l(u(Z,N),A[1]))),-w[2]))),y[3]),l(d(d(l(d(l(u($,lt),E[1]),d(l(u(V,W),-y[1]),l(u(Q,it),w[1]))),T[2]),l(d(l(u($,lt),T[1]),d(l(u(C,z),-y[1]),l(u(st,B),w[1]))),-E[2])),d(l(d(l(u(V,W),T[1]),d(l(u(C,z),-E[1]),l(u(Z,N),w[1]))),y[2]),l(d(l(u(Q,it),T[1]),d(l(u(st,B),-E[1]),l(u(Z,N),y[1]))),-w[2]))),-A[3])),d(l(d(d(l(d(l(u(ut,xt),E[1]),d(l(u(Rt,_t),-y[1]),l(u(Q,it),A[1]))),T[2]),l(d(l(u(ut,xt),T[1]),d(l(u(ct,k),-y[1]),l(u(st,B),A[1]))),-E[2])),d(l(d(l(u(Rt,_t),T[1]),d(l(u(ct,k),-E[1]),l(u(Z,N),A[1]))),y[2]),l(d(l(u(Q,it),T[1]),d(l(u(st,B),-E[1]),l(u(Z,N),y[1]))),-A[2]))),w[3]),l(d(d(l(d(l(u(vt,Ft),y[1]),d(l(u(ut,xt),-S[1]),l(u(D,at),A[1]))),E[2]),l(d(l(u(vt,Ft),E[1]),d(l(u(Rt,_t),-S[1]),l(u(Mt,pt),A[1]))),-y[2])),d(l(d(l(u(ut,xt),E[1]),d(l(u(Rt,_t),-y[1]),l(u(Q,it),A[1]))),S[2]),l(d(l(u(D,at),E[1]),d(l(u(Mt,pt),-y[1]),l(u(Q,it),S[1]))),-A[2]))),T[3]))),d(d(l(d(d(l(d(l(u(vt,Ft),y[1]),d(l(u(ut,xt),-S[1]),l(u(D,at),A[1]))),T[2]),l(d(l(u(vt,Ft),T[1]),d(l(u(ct,k),-S[1]),l(u(Lt,F),A[1]))),-y[2])),d(l(d(l(u(ut,xt),T[1]),d(l(u(ct,k),-y[1]),l(u(st,B),A[1]))),S[2]),l(d(l(u(D,at),T[1]),d(l(u(Lt,F),-y[1]),l(u(st,B),S[1]))),-A[2]))),-E[3]),l(d(d(l(d(l(u(vt,Ft),E[1]),d(l(u(Rt,_t),-S[1]),l(u(Mt,pt),A[1]))),T[2]),l(d(l(u(vt,Ft),T[1]),d(l(u(ct,k),-S[1]),l(u(Lt,F),A[1]))),-E[2])),d(l(d(l(u(Rt,_t),T[1]),d(l(u(ct,k),-E[1]),l(u(Z,N),A[1]))),S[2]),l(d(l(u(Mt,pt),T[1]),d(l(u(Lt,F),-E[1]),l(u(Z,N),S[1]))),-A[2]))),y[3])),d(l(d(d(l(d(l(u(ut,xt),E[1]),d(l(u(Rt,_t),-y[1]),l(u(Q,it),A[1]))),T[2]),l(d(l(u(ut,xt),T[1]),d(l(u(ct,k),-y[1]),l(u(st,B),A[1]))),-E[2])),d(l(d(l(u(Rt,_t),T[1]),d(l(u(ct,k),-E[1]),l(u(Z,N),A[1]))),y[2]),l(d(l(u(Q,it),T[1]),d(l(u(st,B),-E[1]),l(u(Z,N),y[1]))),-A[2]))),-S[3]),l(d(d(l(d(l(u(D,at),E[1]),d(l(u(Mt,pt),-y[1]),l(u(Q,it),S[1]))),T[2]),l(d(l(u(D,at),T[1]),d(l(u(Lt,F),-y[1]),l(u(st,B),S[1]))),-E[2])),d(l(d(l(u(Mt,pt),T[1]),d(l(u(Lt,F),-E[1]),l(u(Z,N),S[1]))),y[2]),l(d(l(u(Q,it),T[1]),d(l(u(st,B),-E[1]),l(u(Z,N),y[1]))),-S[2]))),A[3]))))),bt=u(Ct,ht);return bt[bt.length-1]}return R}var M=[o,c,h];function b(d){var u=M[d.length];return u||(u=M[d.length]=a(d.length)),u.apply(void 0,d)}function x(d,u,v,l,R,T,E,y){function S(A,w,I,N,B,F){switch(arguments.length){case 0:case 1:return 0;case 2:return l(A,w);case 3:return R(A,w,I);case 4:return T(A,w,I,N);case 5:return E(A,w,I,N,B);case 6:return y(A,w,I,N,B,F)}for(var k=new Array(arguments.length),z=0;z<arguments.length;++z)k[z]=arguments[z];return d(k)}return S}function m(){for(;M.length<=s;)M.push(a(M.length));i.exports=x.apply(void 0,[b].concat(M));for(var d=0;d<=s;++d)i.exports[d]=M[d]}m()}(Xa)),Xa.exports}var qa,fh;function Hv(){if(fh)return qa;fh=1;var i=Vv()[4];$o(),qa=e;function t(n,r,s,a,o,c){var h=r.opposite(a,o);if(!(h<0)){if(o<a){var f=a;a=o,o=f,f=c,c=h,h=f}r.isConstraint(a,o)||i(n[a],n[o],n[c],n[h])<0&&s.push(a,o)}}function e(n,r){for(var s=[],a=n.length,o=r.stars,c=0;c<a;++c)for(var h=o[c],f=1;f<h.length;f+=2){var g=h[f];if(!(g<c)&&!r.isConstraint(c,g)){for(var p=h[f-1],_=-1,M=1;M<h.length;M+=2)if(h[M-1]===g){_=h[M];break}_<0||i(n[c],n[g],n[p],n[_])<0&&s.push(c,g)}}for(;s.length>0;){for(var g=s.pop(),c=s.pop(),p=-1,_=-1,h=o[c],b=1;b<h.length;b+=2){var x=h[b-1],m=h[b];x===g?_=m:m===g&&(p=x)}p<0||_<0||i(n[c],n[g],n[p],n[_])>=0||(r.flip(c,g),t(n,r,s,p,c,_),t(n,r,s,c,_,p),t(n,r,s,_,g,p),t(n,r,s,g,p,_))}}return qa}var Ya,dh;function Gv(){if(dh)return Ya;dh=1;var i=$o();Ya=a;function t(o,c,h,f,g,p,_){this.cells=o,this.neighbor=c,this.flags=f,this.constraint=h,this.active=g,this.next=p,this.boundary=_}var e=t.prototype;function n(o,c){return o[0]-c[0]||o[1]-c[1]||o[2]-c[2]}e.locate=function(){var o=[0,0,0];return function(c,h,f){var g=c,p=h,_=f;return h<f?h<c&&(g=h,p=f,_=c):f<c&&(g=f,p=c,_=h),g<0?-1:(o[0]=g,o[1]=p,o[2]=_,i.eq(this.cells,o,n))}}();function r(o,c){for(var h=o.cells(),f=h.length,g=0;g<f;++g){var p=h[g],_=p[0],M=p[1],b=p[2];M<b?M<_&&(p[0]=M,p[1]=b,p[2]=_):b<_&&(p[0]=b,p[1]=_,p[2]=M)}h.sort(n);for(var x=new Array(f),g=0;g<x.length;++g)x[g]=0;var m=[],d=[],u=new Array(3*f),v=new Array(3*f),l=null;c&&(l=[]);for(var R=new t(h,u,v,x,m,d,l),g=0;g<f;++g)for(var p=h[g],T=0;T<3;++T){var _=p[T],M=p[(T+1)%3],E=u[3*g+T]=R.locate(M,_,o.opposite(M,_)),y=v[3*g+T]=o.isConstraint(_,M);E<0&&(y?d.push(g):(m.push(g),x[g]=1),c&&l.push([M,_,-1]))}return R}function s(o,c,h){for(var f=0,g=0;g<o.length;++g)c[g]===h&&(o[f++]=o[g]);return o.length=f,o}function a(o,c,h){var f=r(o,h);if(c===0)return h?f.cells.concat(f.boundary):f.cells;for(var g=1,p=f.active,_=f.next,M=f.flags,b=f.cells,x=f.constraint,m=f.neighbor;p.length>0||_.length>0;){for(;p.length>0;){var d=p.pop();if(M[d]!==-g){M[d]=g,b[d];for(var u=0;u<3;++u){var v=m[3*d+u];v>=0&&M[v]===0&&(x[3*d+u]?_.push(v):(p.push(v),M[v]=g))}}}var l=_;_=p,p=l,_.length=0,g=-g}var R=s(b,M,c);return h?R.concat(f.boundary):R}return Ya}var $a,ph;function kv(){if(ph)return $a;ph=1;var i=Ov(),t=zv(),e=Hv(),n=Gv();$a=c;function r(h){return[Math.min(h[0],h[1]),Math.max(h[0],h[1])]}function s(h,f){return h[0]-f[0]||h[1]-f[1]}function a(h){return h.map(r).sort(s)}function o(h,f,g){return f in h?h[f]:g}function c(h,f,g){Array.isArray(f)?(g=g||{},f=f||[]):(g=f||{},f=[]);var p=!!o(g,"delaunay",!0),_=!!o(g,"interior",!0),M=!!o(g,"exterior",!0),b=!!o(g,"infinity",!1);if(!_&&!M||h.length===0)return[];var x=i(h,f);if(p||_!==M||b){for(var m=t(h.length,a(f)),d=0;d<x.length;++d){var u=x[d];m.addTriangle(u[0],u[1],u[2])}return p&&e(h,m),M?_?b?n(m,0,b):m.cells():n(m,1,b):n(m,-1)}else return x}return $a}var Wv=kv();const Xv=Nv(Wv);function qv(i){const t=[],e=[];let n=0,r=i.length;for(n=0;n<r-1;n++)t.push([i[n].x,i[n].y]),n>0&&e.push([n-1,n]);return e.push([n-1,0]),Xv(t,e,{exterior:!1})}class hl{constructor(t,e="external"){this.x=t.x??0,this.y=t.y??0,this.z=t.z??0,this.type=e,this.adjacent_points=[]}distanceTo(t){return Math.sqrt(Math.pow(this.x-t.x,2)+Math.pow(this.y-t.y,2)+Math.pow(this.z-t.z,2))}}var fl=[],ts=new Map,wo=new Map;function Yv(i){fl=[],ts=new Map,wo=new Map;let t=[];for(let e of i)e.type==="sleeve"?Kv(e,t):e.type==="junction"&&Zv(e,t);for(let e of i)e.type==="fan"&&Jv(e);return t.length===0&&Qv(i,t),[t,fl]}function hi(i,t){let e=`${i.x},${i.y}`;if(wo.has(e))return wo.get(e);let n=new hl(i,t);return wo.set(e,n),n}function Er(i,t,e){const n=`${i.x},${i.y}|${t.x},${t.y}`,r=`${t.x},${t.y}|${i.x},${i.y}`;if(ts.has(n)){let a=ts.get(n);return a.type=="external"&&(a.type="internal"),a}let s=new _r(i,t,e);return ts.set(n,s),ts.set(r,s),i.adjacent_points.push(t),t.adjacent_points.push(i),s}function Tr(i,t,e,n="external",r="external",s="external",a="external",o="external",c="external"){(t.x-i.x)*(e.y-i.y)-(e.x-i.x)*(t.y-i.y)<0&&([i,t]=[t,i],[n,r]=[r,n],[a,o]=[o,a]);let f=hi(i,n),g=hi(t,r),p=hi(e,s),_=Er(g,p,a),M=Er(p,f,o),b=Er(f,g,c),x=new Ll(f,g,p);return x.points=[f,g,p],x.edges=[_,M,b],fl.push(x),x}function $v(i,t,e,n){Tr(t.p1,i.points[n],i.points[e],"spine","external","external","external","internal","internal"),Tr(t.p1,i.points[e],t.p2,"spine","external","spine","internal","spine","internal"),Tr(t.p1,t.p2,i.points[3-e-n],"spine","spine","external","internal","internal","spine")}function jv(i,t,e,n){Tr(t.p1,t.p2,i.points[e],"spine","spine","external","internal","internal","spine"),Tr(t.p2,t.p1,i.points[n],"spine","spine","external","internal","internal","spine")}function Kv(i,t){for(let e=0;e<3;e++)if(i.edges[e].type=="external"){let r=hi(i.edges[(e+1)%3].getMidpoint(),"spine"),s=hi(i.edges[(e+2)%3].getMidpoint(),"spine"),a=Er(r,s,"spine");t.push(a),$v(i,a,(e+1)%3,(e+2)%3);break}}function Zv(i,t){let e=hi(i.getMidpoint(),"spine");for(let n=0;n<3;n++){let r=i.edges[n];if(r.type==="internal"||!r.is_pruned){let s=hi(r.getMidpoint(),"spine"),a=Er(s,e,"spine");t.push(a),jv(i,a,(n+1)%3,(n+2)%3)}}}function Jv(i){Tr(i.points[0],i.points[1],i.points[2])}function Qv(i,t){let e;for(let r=0;r<3;r++)for(let s=0;s<3;s++)if(i[0].points[r]==i[1].points[s]){e=hi(i[0].points[r]);break}e.type="spine";let n=Er(e,e,"spine");t.push(n)}const Nf=1,xr=5;var is=[],ni=[],Ro=new Map,Co=0;function t0(i,t){i0(t);let e=n0(i);return e0(i,e),[is,ni]}function e0(i,t){is=[],ni=[],Ro=new Map,Co=0;for(let e of i){let n,r,s;for(let f=0;f<e.edges.length;f++)if(n=e.edges[f],n.type=="external"||n.type=="spine"){r=e.edges[(f+1)%3],s=e.edges[(f+2)%3];break}let a=`${r.p1.x},${r.p1.y}|${r.p2.x},${r.p2.y}`,o=`${s.p1.x},${s.p1.y}|${s.p2.x},${s.p2.y}`,c=Array.from(t.get(a)),h=Array.from(t.get(o));n.type==="spine"&&(c.reverse(),h.reverse());for(let f=0;f<xr-1;f++)ja(c[f],c[f+1],h[f]),ja(c[f+1],h[f+1],h[f]);ja(c[xr-1],c[xr],h[xr-1])}}function nr(i){const t=`${i.x},${i.y},${i.z}`;return Ro.has(t)?Ro.get(t):(is.push(i.x),is.push(i.y),is.push(i.z),Ro.set(t,Co),Co++,Co-1)}function ja(i,t,e){let n=nr(i),r=nr(t),s=nr(e);ni.push(n),ni.push(r),ni.push(s);let a=new U(i.x,i.y,-i.z),o=new U(t.x,t.y,-t.z),c=new U(e.x,e.y,-e.z),h=nr(a),f=nr(c),g=nr(o);ni.push(h),ni.push(f),ni.push(g)}function n0(i){var t=new Map;for(let e of i)for(let n of e.edges){if(n.type!=="internal")continue;let r=`${n.p1.x},${n.p1.y}|${n.p2.x},${n.p2.y}`;if(t.has(r))continue;let s=[],a,o,c,h;n.p1.type=="spine"?(h=new hl(n.p1),h.z=0,a=n.p2.x-h.x,o=n.p2.y-h.y,c=n.p1.z):(h=new hl(n.p2),h.z=0,a=n.p1.x-h.x,o=n.p1.y-h.y,c=n.p2.z);let f=0;for(let g=0;g<xr;g++){f=Math.PI/2/xr*g;let p=a*Math.cos(f)+h.x,_=o*Math.cos(f)+h.y,M=c*Math.sin(f),b=new U(p,_,M);s.push(b)}s.push(new U(h.x,h.y,c)),t.set(r,s)}return t}function i0(i){let t=[];for(let e of i){let n=e.p1,r=e.p2;n.z==0&&(gh(n),t.push(n)),r.z==0&&(gh(r),t.push(r))}return t}function r0(i){const t=`${i.x},${i.y}`;if(!ds.has(t))return!1;const e=ds.get(t);return i.z=Nf*e,!0}function gh(i){if(r0(i))return;let t=0,e=0;for(const n of i.adjacent_points)n.type==="external"&&(t+=i.distanceTo(n),e++);i.z=Nf*t/e}const Ka=document.getElementById("infoBox"),es=document.getElementById("infoButtom"),Ho=document.querySelectorAll(".infoPage"),s0=document.getElementById("nextPage"),o0=document.getElementById("prevPage");let Oi=0;a0();function a0(){es.addEventListener("click",Ff),s0.addEventListener("click",c0),o0.addEventListener("click",l0),Ul(Oi)}function Ff(){Ka.style.display=="none"?(Ka.style.display="",es.style.right="335px",es.textContent="▶"):(Ka.style.display="none",es.style.right="16px",es.textContent="◀")}function Ul(i){Ho.forEach((t,e)=>{t.classList.toggle("active",e===i)})}function c0(){Oi=(Oi+1)%Ho.length,Ul(Oi)}function l0(){Oi=(Oi-1+Ho.length)%Ho.length,Ul(Oi)}const Bf=0,u0=1,h0=2,mh=2,Za=1.25,_h=1,rs=6*4+4+4,jo=65535,f0=Math.pow(2,-24),Ja=Symbol("SKIP_GENERATION");function d0(i){return i.index?i.index.count:i.attributes.position.count}function Nr(i){return d0(i)/3}function p0(i,t=ArrayBuffer){return i>65535?new Uint32Array(new t(4*i)):new Uint16Array(new t(2*i))}function g0(i,t){if(!i.index){const e=i.attributes.position.count,n=t.useSharedArrayBuffer?SharedArrayBuffer:ArrayBuffer,r=p0(e,n);i.setIndex(new de(r,1));for(let s=0;s<e;s++)r[s]=s}}function Of(i,t){const e=Nr(i),n=t||i.drawRange,r=n.start/3,s=(n.start+n.count)/3,a=Math.max(0,r),o=Math.min(e,s)-a;return[{offset:Math.floor(a),count:Math.floor(o)}]}function zf(i,t){if(!i.groups||!i.groups.length)return Of(i,t);const e=[],n=new Set,r=t||i.drawRange,s=r.start/3,a=(r.start+r.count)/3;for(const c of i.groups){const h=c.start/3,f=(c.start+c.count)/3;n.add(Math.max(s,h)),n.add(Math.min(a,f))}const o=Array.from(n.values()).sort((c,h)=>c-h);for(let c=0;c<o.length-1;c++){const h=o[c],f=o[c+1];e.push({offset:Math.floor(h),count:Math.floor(f-h)})}return e}function m0(i,t){const e=Nr(i),n=zf(i,t).sort((a,o)=>a.offset-o.offset),r=n[n.length-1];r.count=Math.min(e-r.offset,r.count);let s=0;return n.forEach(({count:a})=>s+=a),e!==s}function Qa(i,t,e,n,r){let s=1/0,a=1/0,o=1/0,c=-1/0,h=-1/0,f=-1/0,g=1/0,p=1/0,_=1/0,M=-1/0,b=-1/0,x=-1/0;for(let m=t*6,d=(t+e)*6;m<d;m+=6){const u=i[m+0],v=i[m+1],l=u-v,R=u+v;l<s&&(s=l),R>c&&(c=R),u<g&&(g=u),u>M&&(M=u);const T=i[m+2],E=i[m+3],y=T-E,S=T+E;y<a&&(a=y),S>h&&(h=S),T<p&&(p=T),T>b&&(b=T);const A=i[m+4],w=i[m+5],I=A-w,N=A+w;I<o&&(o=I),N>f&&(f=N),A<_&&(_=A),A>x&&(x=A)}n[0]=s,n[1]=a,n[2]=o,n[3]=c,n[4]=h,n[5]=f,r[0]=g,r[1]=p,r[2]=_,r[3]=M,r[4]=b,r[5]=x}function _0(i,t=null,e=null,n=null){const r=i.attributes.position,s=i.index?i.index.array:null,a=Nr(i),o=r.normalized;let c;t===null?(c=new Float32Array(a*6),e=0,n=a):(c=t,e=e||0,n=n||a);const h=r.array,f=r.offset||0;let g=3;r.isInterleavedBufferAttribute&&(g=r.data.stride);const p=["getX","getY","getZ"];for(let _=e;_<e+n;_++){const M=_*3,b=_*6;let x=M+0,m=M+1,d=M+2;s&&(x=s[x],m=s[m],d=s[d]),o||(x=x*g+f,m=m*g+f,d=d*g+f);for(let u=0;u<3;u++){let v,l,R;o?(v=r[p[u]](x),l=r[p[u]](m),R=r[p[u]](d)):(v=h[x+u],l=h[m+u],R=h[d+u]);let T=v;l<T&&(T=l),R<T&&(T=R);let E=v;l>E&&(E=l),R>E&&(E=R);const y=(E-T)/2,S=u*2;c[b+S+0]=T+y,c[b+S+1]=y+(Math.abs(T)+y)*f0}}return c}function fe(i,t,e){return e.min.x=t[i],e.min.y=t[i+1],e.min.z=t[i+2],e.max.x=t[i+3],e.max.y=t[i+4],e.max.z=t[i+5],e}function xh(i){let t=-1,e=-1/0;for(let n=0;n<3;n++){const r=i[n+3]-i[n];r>e&&(e=r,t=n)}return t}function vh(i,t){t.set(i)}function yh(i,t,e){let n,r;for(let s=0;s<3;s++){const a=s+3;n=i[s],r=t[s],e[s]=n<r?n:r,n=i[a],r=t[a],e[a]=n>r?n:r}}function Zs(i,t,e){for(let n=0;n<3;n++){const r=t[i+2*n],s=t[i+2*n+1],a=r-s,o=r+s;a<e[n]&&(e[n]=a),o>e[n+3]&&(e[n+3]=o)}}function Wr(i){const t=i[3]-i[0],e=i[4]-i[1],n=i[5]-i[2];return 2*(t*e+e*n+n*t)}const Wn=32,x0=(i,t)=>i.candidate-t.candidate,ti=new Array(Wn).fill().map(()=>({count:0,bounds:new Float32Array(6),rightCacheBounds:new Float32Array(6),leftCacheBounds:new Float32Array(6),candidate:0})),Js=new Float32Array(6);function v0(i,t,e,n,r,s){let a=-1,o=0;if(s===Bf)a=xh(t),a!==-1&&(o=(t[a]+t[a+3])/2);else if(s===u0)a=xh(i),a!==-1&&(o=y0(e,n,r,a));else if(s===h0){const c=Wr(i);let h=Za*r;const f=n*6,g=(n+r)*6;for(let p=0;p<3;p++){const _=t[p],x=(t[p+3]-_)/Wn;if(r<Wn/4){const m=[...ti];m.length=r;let d=0;for(let v=f;v<g;v+=6,d++){const l=m[d];l.candidate=e[v+2*p],l.count=0;const{bounds:R,leftCacheBounds:T,rightCacheBounds:E}=l;for(let y=0;y<3;y++)E[y]=1/0,E[y+3]=-1/0,T[y]=1/0,T[y+3]=-1/0,R[y]=1/0,R[y+3]=-1/0;Zs(v,e,R)}m.sort(x0);let u=r;for(let v=0;v<u;v++){const l=m[v];for(;v+1<u&&m[v+1].candidate===l.candidate;)m.splice(v+1,1),u--}for(let v=f;v<g;v+=6){const l=e[v+2*p];for(let R=0;R<u;R++){const T=m[R];l>=T.candidate?Zs(v,e,T.rightCacheBounds):(Zs(v,e,T.leftCacheBounds),T.count++)}}for(let v=0;v<u;v++){const l=m[v],R=l.count,T=r-l.count,E=l.leftCacheBounds,y=l.rightCacheBounds;let S=0;R!==0&&(S=Wr(E)/c);let A=0;T!==0&&(A=Wr(y)/c);const w=_h+Za*(S*R+A*T);w<h&&(a=p,h=w,o=l.candidate)}}else{for(let u=0;u<Wn;u++){const v=ti[u];v.count=0,v.candidate=_+x+u*x;const l=v.bounds;for(let R=0;R<3;R++)l[R]=1/0,l[R+3]=-1/0}for(let u=f;u<g;u+=6){let R=~~((e[u+2*p]-_)/x);R>=Wn&&(R=Wn-1);const T=ti[R];T.count++,Zs(u,e,T.bounds)}const m=ti[Wn-1];vh(m.bounds,m.rightCacheBounds);for(let u=Wn-2;u>=0;u--){const v=ti[u],l=ti[u+1];yh(v.bounds,l.rightCacheBounds,v.rightCacheBounds)}let d=0;for(let u=0;u<Wn-1;u++){const v=ti[u],l=v.count,R=v.bounds,E=ti[u+1].rightCacheBounds;l!==0&&(d===0?vh(R,Js):yh(R,Js,Js)),d+=l;let y=0,S=0;d!==0&&(y=Wr(Js)/c);const A=r-d;A!==0&&(S=Wr(E)/c);const w=_h+Za*(y*d+S*A);w<h&&(a=p,h=w,o=v.candidate)}}}}else console.warn(`MeshBVH: Invalid build strategy value ${s} used.`);return{axis:a,pos:o}}function y0(i,t,e,n){let r=0;for(let s=t,a=t+e;s<a;s++)r+=i[s*6+n*2];return r/e}class tc{constructor(){this.boundingData=new Float32Array(6)}}function S0(i,t,e,n,r,s){let a=n,o=n+r-1;const c=s.pos,h=s.axis*2;for(;;){for(;a<=o&&e[a*6+h]<c;)a++;for(;a<=o&&e[o*6+h]>=c;)o--;if(a<o){for(let f=0;f<3;f++){let g=t[a*3+f];t[a*3+f]=t[o*3+f],t[o*3+f]=g}for(let f=0;f<6;f++){let g=e[a*6+f];e[a*6+f]=e[o*6+f],e[o*6+f]=g}a++,o--}else return a}}function M0(i,t,e,n,r,s){let a=n,o=n+r-1;const c=s.pos,h=s.axis*2;for(;;){for(;a<=o&&e[a*6+h]<c;)a++;for(;a<=o&&e[o*6+h]>=c;)o--;if(a<o){let f=i[a];i[a]=i[o],i[o]=f;for(let g=0;g<6;g++){let p=e[a*6+g];e[a*6+g]=e[o*6+g],e[o*6+g]=p}a++,o--}else return a}}function We(i,t){return t[i+15]===65535}function Ze(i,t){return t[i+6]}function on(i,t){return t[i+14]}function an(i){return i+8}function cn(i,t){return t[i+6]}function Vf(i,t){return t[i+7]}let Hf,ns,Po,Gf;const E0=Math.pow(2,32);function dl(i){return"count"in i?1:1+dl(i.left)+dl(i.right)}function T0(i,t,e){return Hf=new Float32Array(e),ns=new Uint32Array(e),Po=new Uint16Array(e),Gf=new Uint8Array(e),pl(i,t)}function pl(i,t){const e=i/4,n=i/2,r="count"in t,s=t.boundingData;for(let a=0;a<6;a++)Hf[e+a]=s[a];if(r)if(t.buffer){const a=t.buffer;Gf.set(new Uint8Array(a),i);for(let o=i,c=i+a.byteLength;o<c;o+=rs){const h=o/2;We(h,Po)||(ns[o/4+6]+=e)}return i+a.byteLength}else{const a=t.offset,o=t.count;return ns[e+6]=a,Po[n+14]=o,Po[n+15]=jo,i+rs}else{const a=t.left,o=t.right,c=t.splitAxis;let h;if(h=pl(i+rs,a),h/4>E0)throw new Error("MeshBVH: Cannot store child pointer greater than 32 bits.");return ns[e+6]=h/4,h=pl(h,o),ns[e+7]=c,h}}function b0(i,t){const e=(i.index?i.index.count:i.attributes.position.count)/3,n=e>2**16,r=n?4:2,s=t?new SharedArrayBuffer(e*r):new ArrayBuffer(e*r),a=n?new Uint32Array(s):new Uint16Array(s);for(let o=0,c=a.length;o<c;o++)a[o]=o;return a}function A0(i,t,e,n,r){const{maxDepth:s,verbose:a,maxLeafTris:o,strategy:c,onProgress:h,indirect:f}=r,g=i._indirectBuffer,p=i.geometry,_=p.index?p.index.array:null,M=f?M0:S0,b=Nr(p),x=new Float32Array(6);let m=!1;const d=new tc;return Qa(t,e,n,d.boundingData,x),v(d,e,n,x),d;function u(l){h&&h(l/b)}function v(l,R,T,E=null,y=0){if(!m&&y>=s&&(m=!0,a&&(console.warn(`MeshBVH: Max depth of ${s} reached when generating BVH. Consider increasing maxDepth.`),console.warn(p))),T<=o||y>=s)return u(R+T),l.offset=R,l.count=T,l;const S=v0(l.boundingData,E,t,R,T,c);if(S.axis===-1)return u(R+T),l.offset=R,l.count=T,l;const A=M(g,_,t,R,T,S);if(A===R||A===R+T)u(R+T),l.offset=R,l.count=T;else{l.splitAxis=S.axis;const w=new tc,I=R,N=A-R;l.left=w,Qa(t,I,N,w.boundingData,x),v(w,I,N,x,y+1);const B=new tc,F=A,k=T-N;l.right=B,Qa(t,F,k,B.boundingData,x),v(B,F,k,x,y+1)}return l}}function w0(i,t){const e=i.geometry;t.indirect&&(i._indirectBuffer=b0(e,t.useSharedArrayBuffer),m0(e,t.range)&&!t.verbose&&console.warn('MeshBVH: Provided geometry contains groups or a range that do not fully span the vertex contents while using the "indirect" option. BVH may incorrectly report intersections on unrendered portions of the geometry.')),i._indirectBuffer||g0(e,t);const n=t.useSharedArrayBuffer?SharedArrayBuffer:ArrayBuffer,r=_0(e),s=t.indirect?Of(e,t.range):zf(e,t.range);i._roots=s.map(a=>{const o=A0(i,r,a.offset,a.count,t),c=dl(o),h=new n(rs*c);return T0(0,o,h),h})}class qn{constructor(){this.min=1/0,this.max=-1/0}setFromPointsField(t,e){let n=1/0,r=-1/0;for(let s=0,a=t.length;s<a;s++){const c=t[s][e];n=c<n?c:n,r=c>r?c:r}this.min=n,this.max=r}setFromPoints(t,e){let n=1/0,r=-1/0;for(let s=0,a=e.length;s<a;s++){const o=e[s],c=t.dot(o);n=c<n?c:n,r=c>r?c:r}this.min=n,this.max=r}isSeparated(t){return this.min>t.max||t.min>this.max}}qn.prototype.setFromBox=function(){const i=new U;return function(e,n){const r=n.min,s=n.max;let a=1/0,o=-1/0;for(let c=0;c<=1;c++)for(let h=0;h<=1;h++)for(let f=0;f<=1;f++){i.x=r.x*c+s.x*(1-c),i.y=r.y*h+s.y*(1-h),i.z=r.z*f+s.z*(1-f);const g=e.dot(i);a=Math.min(g,a),o=Math.max(g,o)}this.min=a,this.max=o}}();const R0=function(){const i=new U,t=new U,e=new U;return function(r,s,a){const o=r.start,c=i,h=s.start,f=t;e.subVectors(o,h),i.subVectors(r.end,r.start),t.subVectors(s.end,s.start);const g=e.dot(f),p=f.dot(c),_=f.dot(f),M=e.dot(c),x=c.dot(c)*_-p*p;let m,d;x!==0?m=(g*p-M*_)/x:m=0,d=(g+m*p)/_,a.x=m,a.y=d}}(),Nl=function(){const i=new kt,t=new U,e=new U;return function(r,s,a,o){R0(r,s,i);let c=i.x,h=i.y;if(c>=0&&c<=1&&h>=0&&h<=1){r.at(c,a),s.at(h,o);return}else if(c>=0&&c<=1){h<0?s.at(0,o):s.at(1,o),r.closestPointToPoint(o,!0,a);return}else if(h>=0&&h<=1){c<0?r.at(0,a):r.at(1,a),s.closestPointToPoint(a,!0,o);return}else{let f;c<0?f=r.start:f=r.end;let g;h<0?g=s.start:g=s.end;const p=t,_=e;if(r.closestPointToPoint(g,!0,t),s.closestPointToPoint(f,!0,e),p.distanceToSquared(g)<=_.distanceToSquared(f)){a.copy(p),o.copy(g);return}else{a.copy(f),o.copy(_);return}}}}(),C0=function(){const i=new U,t=new U,e=new En,n=new un;return function(s,a){const{radius:o,center:c}=s,{a:h,b:f,c:g}=a;if(n.start=h,n.end=f,n.closestPointToPoint(c,!0,i).distanceTo(c)<=o||(n.start=h,n.end=g,n.closestPointToPoint(c,!0,i).distanceTo(c)<=o)||(n.start=f,n.end=g,n.closestPointToPoint(c,!0,i).distanceTo(c)<=o))return!0;const b=a.getPlane(e);if(Math.abs(b.distanceToPoint(c))<=o){const m=b.projectPoint(c,t);if(a.containsPoint(m))return!0}return!1}}(),P0=1e-15;function ec(i){return Math.abs(i)<P0}class hn extends ve{constructor(...t){super(...t),this.isExtendedTriangle=!0,this.satAxes=new Array(4).fill().map(()=>new U),this.satBounds=new Array(4).fill().map(()=>new qn),this.points=[this.a,this.b,this.c],this.sphere=new Rn,this.plane=new En,this.needsUpdate=!0}intersectsSphere(t){return C0(t,this)}update(){const t=this.a,e=this.b,n=this.c,r=this.points,s=this.satAxes,a=this.satBounds,o=s[0],c=a[0];this.getNormal(o),c.setFromPoints(o,r);const h=s[1],f=a[1];h.subVectors(t,e),f.setFromPoints(h,r);const g=s[2],p=a[2];g.subVectors(e,n),p.setFromPoints(g,r);const _=s[3],M=a[3];_.subVectors(n,t),M.setFromPoints(_,r),this.sphere.setFromPoints(this.points),this.plane.setFromNormalAndCoplanarPoint(o,t),this.needsUpdate=!1}}hn.prototype.closestPointToSegment=function(){const i=new U,t=new U,e=new un;return function(r,s=null,a=null){const{start:o,end:c}=r,h=this.points;let f,g=1/0;for(let p=0;p<3;p++){const _=(p+1)%3;e.start.copy(h[p]),e.end.copy(h[_]),Nl(e,r,i,t),f=i.distanceToSquared(t),f<g&&(g=f,s&&s.copy(i),a&&a.copy(t))}return this.closestPointToPoint(o,i),f=o.distanceToSquared(i),f<g&&(g=f,s&&s.copy(i),a&&a.copy(o)),this.closestPointToPoint(c,i),f=c.distanceToSquared(i),f<g&&(g=f,s&&s.copy(i),a&&a.copy(c)),Math.sqrt(g)}}();hn.prototype.intersectsTriangle=function(){const i=new hn,t=new Array(3),e=new Array(3),n=new qn,r=new qn,s=new U,a=new U,o=new U,c=new U,h=new U,f=new un,g=new un,p=new un,_=new U;function M(b,x,m){const d=b.points;let u=0,v=-1;for(let l=0;l<3;l++){const{start:R,end:T}=f;R.copy(d[l]),T.copy(d[(l+1)%3]),f.delta(a);const E=ec(x.distanceToPoint(R));if(ec(x.normal.dot(a))&&E){m.copy(f),u=2;break}const y=x.intersectLine(f,_);if(!y&&E&&_.copy(R),(y||E)&&!ec(_.distanceTo(T))){if(u<=1)(u===1?m.start:m.end).copy(_),E&&(v=u);else if(u>=2){(v===1?m.start:m.end).copy(_),u=2;break}if(u++,u===2&&v===-1)break}}return u}return function(x,m=null,d=!1){this.needsUpdate&&this.update(),x.isExtendedTriangle?x.needsUpdate&&x.update():(i.copy(x),i.update(),x=i);const u=this.plane,v=x.plane;if(Math.abs(u.normal.dot(v.normal))>1-1e-10){const l=this.satBounds,R=this.satAxes;e[0]=x.a,e[1]=x.b,e[2]=x.c;for(let y=0;y<4;y++){const S=l[y],A=R[y];if(n.setFromPoints(A,e),S.isSeparated(n))return!1}const T=x.satBounds,E=x.satAxes;t[0]=this.a,t[1]=this.b,t[2]=this.c;for(let y=0;y<4;y++){const S=T[y],A=E[y];if(n.setFromPoints(A,t),S.isSeparated(n))return!1}for(let y=0;y<4;y++){const S=R[y];for(let A=0;A<4;A++){const w=E[A];if(s.crossVectors(S,w),n.setFromPoints(s,t),r.setFromPoints(s,e),n.isSeparated(r))return!1}}return m&&(d||console.warn("ExtendedTriangle.intersectsTriangle: Triangles are coplanar which does not support an output edge. Setting edge to 0, 0, 0."),m.start.set(0,0,0),m.end.set(0,0,0)),!0}else{const l=M(this,v,g);if(l===1&&x.containsPoint(g.end))return m&&(m.start.copy(g.end),m.end.copy(g.end)),!0;if(l!==2)return!1;const R=M(x,u,p);if(R===1&&this.containsPoint(p.end))return m&&(m.start.copy(p.end),m.end.copy(p.end)),!0;if(R!==2)return!1;if(g.delta(o),p.delta(c),o.dot(c)<0){let I=p.start;p.start=p.end,p.end=I}const T=g.start.dot(o),E=g.end.dot(o),y=p.start.dot(o),S=p.end.dot(o),A=E<y,w=T<S;return T!==S&&y!==E&&A===w?!1:(m&&(h.subVectors(g.start,p.start),h.dot(o)>0?m.start.copy(g.start):m.start.copy(p.start),h.subVectors(g.end,p.end),h.dot(o)<0?m.end.copy(g.end):m.end.copy(p.end)),!0)}}}();hn.prototype.distanceToPoint=function(){const i=new U;return function(e){return this.closestPointToPoint(e,i),e.distanceTo(i)}}();hn.prototype.distanceToTriangle=function(){const i=new U,t=new U,e=["a","b","c"],n=new un,r=new un;return function(a,o=null,c=null){const h=o||c?n:null;if(this.intersectsTriangle(a,h))return(o||c)&&(o&&h.getCenter(o),c&&h.getCenter(c)),0;let f=1/0;for(let g=0;g<3;g++){let p;const _=e[g],M=a[_];this.closestPointToPoint(M,i),p=M.distanceToSquared(i),p<f&&(f=p,o&&o.copy(i),c&&c.copy(M));const b=this[_];a.closestPointToPoint(b,i),p=b.distanceToSquared(i),p<f&&(f=p,o&&o.copy(b),c&&c.copy(i))}for(let g=0;g<3;g++){const p=e[g],_=e[(g+1)%3];n.set(this[p],this[_]);for(let M=0;M<3;M++){const b=e[M],x=e[(M+1)%3];r.set(a[b],a[x]),Nl(n,r,i,t);const m=i.distanceToSquared(t);m<f&&(f=m,o&&o.copy(i),c&&c.copy(t))}}return Math.sqrt(f)}}();class Ve{constructor(t,e,n){this.isOrientedBox=!0,this.min=new U,this.max=new U,this.matrix=new $t,this.invMatrix=new $t,this.points=new Array(8).fill().map(()=>new U),this.satAxes=new Array(3).fill().map(()=>new U),this.satBounds=new Array(3).fill().map(()=>new qn),this.alignedSatBounds=new Array(3).fill().map(()=>new qn),this.needsUpdate=!1,t&&this.min.copy(t),e&&this.max.copy(e),n&&this.matrix.copy(n)}set(t,e,n){this.min.copy(t),this.max.copy(e),this.matrix.copy(n),this.needsUpdate=!0}copy(t){this.min.copy(t.min),this.max.copy(t.max),this.matrix.copy(t.matrix),this.needsUpdate=!0}}Ve.prototype.update=function(){return function(){const t=this.matrix,e=this.min,n=this.max,r=this.points;for(let h=0;h<=1;h++)for(let f=0;f<=1;f++)for(let g=0;g<=1;g++){const p=1*h|2*f|4*g,_=r[p];_.x=h?n.x:e.x,_.y=f?n.y:e.y,_.z=g?n.z:e.z,_.applyMatrix4(t)}const s=this.satBounds,a=this.satAxes,o=r[0];for(let h=0;h<3;h++){const f=a[h],g=s[h],p=1<<h,_=r[p];f.subVectors(o,_),g.setFromPoints(f,r)}const c=this.alignedSatBounds;c[0].setFromPointsField(r,"x"),c[1].setFromPointsField(r,"y"),c[2].setFromPointsField(r,"z"),this.invMatrix.copy(this.matrix).invert(),this.needsUpdate=!1}}();Ve.prototype.intersectsBox=function(){const i=new qn;return function(e){this.needsUpdate&&this.update();const n=e.min,r=e.max,s=this.satBounds,a=this.satAxes,o=this.alignedSatBounds;if(i.min=n.x,i.max=r.x,o[0].isSeparated(i)||(i.min=n.y,i.max=r.y,o[1].isSeparated(i))||(i.min=n.z,i.max=r.z,o[2].isSeparated(i)))return!1;for(let c=0;c<3;c++){const h=a[c],f=s[c];if(i.setFromBox(h,e),f.isSeparated(i))return!1}return!0}}();Ve.prototype.intersectsTriangle=function(){const i=new hn,t=new Array(3),e=new qn,n=new qn,r=new U;return function(a){this.needsUpdate&&this.update(),a.isExtendedTriangle?a.needsUpdate&&a.update():(i.copy(a),i.update(),a=i);const o=this.satBounds,c=this.satAxes;t[0]=a.a,t[1]=a.b,t[2]=a.c;for(let p=0;p<3;p++){const _=o[p],M=c[p];if(e.setFromPoints(M,t),_.isSeparated(e))return!1}const h=a.satBounds,f=a.satAxes,g=this.points;for(let p=0;p<3;p++){const _=h[p],M=f[p];if(e.setFromPoints(M,g),_.isSeparated(e))return!1}for(let p=0;p<3;p++){const _=c[p];for(let M=0;M<4;M++){const b=f[M];if(r.crossVectors(_,b),e.setFromPoints(r,t),n.setFromPoints(r,g),e.isSeparated(n))return!1}}return!0}}();Ve.prototype.closestPointToPoint=function(){return function(t,e){return this.needsUpdate&&this.update(),e.copy(t).applyMatrix4(this.invMatrix).clamp(this.min,this.max).applyMatrix4(this.matrix),e}}();Ve.prototype.distanceToPoint=function(){const i=new U;return function(e){return this.closestPointToPoint(e,i),e.distanceTo(i)}}();Ve.prototype.distanceToBox=function(){const i=["x","y","z"],t=new Array(12).fill().map(()=>new un),e=new Array(12).fill().map(()=>new un),n=new U,r=new U;return function(a,o=0,c=null,h=null){if(this.needsUpdate&&this.update(),this.intersectsBox(a))return(c||h)&&(a.getCenter(r),this.closestPointToPoint(r,n),a.closestPointToPoint(n,r),c&&c.copy(n),h&&h.copy(r)),0;const f=o*o,g=a.min,p=a.max,_=this.points;let M=1/0;for(let x=0;x<8;x++){const m=_[x];r.copy(m).clamp(g,p);const d=m.distanceToSquared(r);if(d<M&&(M=d,c&&c.copy(m),h&&h.copy(r),d<f))return Math.sqrt(d)}let b=0;for(let x=0;x<3;x++)for(let m=0;m<=1;m++)for(let d=0;d<=1;d++){const u=(x+1)%3,v=(x+2)%3,l=m<<u|d<<v,R=1<<x|m<<u|d<<v,T=_[l],E=_[R];t[b].set(T,E);const S=i[x],A=i[u],w=i[v],I=e[b],N=I.start,B=I.end;N[S]=g[S],N[A]=m?g[A]:p[A],N[w]=d?g[w]:p[A],B[S]=p[S],B[A]=m?g[A]:p[A],B[w]=d?g[w]:p[A],b++}for(let x=0;x<=1;x++)for(let m=0;m<=1;m++)for(let d=0;d<=1;d++){r.x=x?p.x:g.x,r.y=m?p.y:g.y,r.z=d?p.z:g.z,this.closestPointToPoint(r,n);const u=r.distanceToSquared(n);if(u<M&&(M=u,c&&c.copy(n),h&&h.copy(r),u<f))return Math.sqrt(u)}for(let x=0;x<12;x++){const m=t[x];for(let d=0;d<12;d++){const u=e[d];Nl(m,u,n,r);const v=n.distanceToSquared(r);if(v<M&&(M=v,c&&c.copy(n),h&&h.copy(r),v<f))return Math.sqrt(v)}}return Math.sqrt(M)}}();class Fl{constructor(t){this._getNewPrimitive=t,this._primitives=[]}getPrimitive(){const t=this._primitives;return t.length===0?this._getNewPrimitive():t.pop()}releasePrimitive(t){this._primitives.push(t)}}class I0 extends Fl{constructor(){super(()=>new hn)}}const ln=new I0;class L0{constructor(){this.float32Array=null,this.uint16Array=null,this.uint32Array=null;const t=[];let e=null;this.setBuffer=n=>{e&&t.push(e),e=n,this.float32Array=new Float32Array(n),this.uint16Array=new Uint16Array(n),this.uint32Array=new Uint32Array(n)},this.clearBuffer=()=>{e=null,this.float32Array=null,this.uint16Array=null,this.uint32Array=null,t.length!==0&&this.setBuffer(t.pop())}}}const ae=new L0;let oi,vr;const ir=[],Qs=new Fl(()=>new ye);function D0(i,t,e,n,r,s){oi=Qs.getPrimitive(),vr=Qs.getPrimitive(),ir.push(oi,vr),ae.setBuffer(i._roots[t]);const a=gl(0,i.geometry,e,n,r,s);ae.clearBuffer(),Qs.releasePrimitive(oi),Qs.releasePrimitive(vr),ir.pop(),ir.pop();const o=ir.length;return o>0&&(vr=ir[o-1],oi=ir[o-2]),a}function gl(i,t,e,n,r=null,s=0,a=0){const{float32Array:o,uint16Array:c,uint32Array:h}=ae;let f=i*2;if(We(f,c)){const M=Ze(i,h),b=on(f,c);return fe(i,o,oi),n(M,b,!1,a,s+i,oi)}else{let w=function(N){const{uint16Array:B,uint32Array:F}=ae;let k=N*2;for(;!We(k,B);)N=an(N),k=N*2;return Ze(N,F)},I=function(N){const{uint16Array:B,uint32Array:F}=ae;let k=N*2;for(;!We(k,B);)N=cn(N,F),k=N*2;return Ze(N,F)+on(k,B)};var p=w,_=I;const M=an(i),b=cn(i,h);let x=M,m=b,d,u,v,l;if(r&&(v=oi,l=vr,fe(x,o,v),fe(m,o,l),d=r(v),u=r(l),u<d)){x=b,m=M;const N=d;d=u,u=N,v=l}v||(v=oi,fe(x,o,v));const R=We(x*2,c),T=e(v,R,d,a+1,s+x);let E;if(T===mh){const N=w(x),F=I(x)-N;E=n(N,F,!0,a+1,s+x,v)}else E=T&&gl(x,t,e,n,r,s,a+1);if(E)return!0;l=vr,fe(m,o,l);const y=We(m*2,c),S=e(l,y,u,a+1,s+m);let A;if(S===mh){const N=w(m),F=I(m)-N;A=n(N,F,!0,a+1,s+m,l)}else A=S&&gl(m,t,e,n,r,s,a+1);return!!A}}const Xr=new U,nc=new U;function U0(i,t,e={},n=0,r=1/0){const s=n*n,a=r*r;let o=1/0,c=null;if(i.shapecast({boundsTraverseOrder:f=>(Xr.copy(t).clamp(f.min,f.max),Xr.distanceToSquared(t)),intersectsBounds:(f,g,p)=>p<o&&p<a,intersectsTriangle:(f,g)=>{f.closestPointToPoint(t,Xr);const p=t.distanceToSquared(Xr);return p<o&&(nc.copy(Xr),o=p,c=g),p<s}}),o===1/0)return null;const h=Math.sqrt(o);return e.point?e.point.copy(nc):e.point=nc.clone(),e.distance=h,e.faceIndex=c,e}const N0=parseInt(ms)>=169,Ai=new U,wi=new U,Ri=new U,to=new kt,eo=new kt,no=new kt,Sh=new U,Mh=new U,Eh=new U,qr=new U;function F0(i,t,e,n,r,s,a,o){let c;if(s===ze?c=i.intersectTriangle(n,e,t,!0,r):c=i.intersectTriangle(t,e,n,s!==Be,r),c===null)return null;const h=i.origin.distanceTo(r);return h<a||h>o?null:{distance:h,point:r.clone()}}function B0(i,t,e,n,r,s,a,o,c,h,f){Ai.fromBufferAttribute(t,s),wi.fromBufferAttribute(t,a),Ri.fromBufferAttribute(t,o);const g=F0(i,Ai,wi,Ri,qr,c,h,f);if(g){const p=new U;ve.getBarycoord(qr,Ai,wi,Ri,p),n&&(to.fromBufferAttribute(n,s),eo.fromBufferAttribute(n,a),no.fromBufferAttribute(n,o),g.uv=ve.getInterpolation(qr,Ai,wi,Ri,to,eo,no,new kt)),r&&(to.fromBufferAttribute(r,s),eo.fromBufferAttribute(r,a),no.fromBufferAttribute(r,o),g.uv1=ve.getInterpolation(qr,Ai,wi,Ri,to,eo,no,new kt)),e&&(Sh.fromBufferAttribute(e,s),Mh.fromBufferAttribute(e,a),Eh.fromBufferAttribute(e,o),g.normal=ve.getInterpolation(qr,Ai,wi,Ri,Sh,Mh,Eh,new U),g.normal.dot(i.direction)>0&&g.normal.multiplyScalar(-1));const _={a:s,b:a,c:o,normal:new U,materialIndex:0};ve.getNormal(Ai,wi,Ri,_.normal),g.face=_,g.faceIndex=s,N0&&(g.barycoord=p)}return g}function Ko(i,t,e,n,r,s,a){const o=n*3;let c=o+0,h=o+1,f=o+2;const g=i.index;i.index&&(c=g.getX(c),h=g.getX(h),f=g.getX(f));const{position:p,normal:_,uv:M,uv1:b}=i.attributes,x=B0(e,p,_,M,b,c,h,f,t,s,a);return x?(x.faceIndex=n,r&&r.push(x),x):null}function xe(i,t,e,n){const r=i.a,s=i.b,a=i.c;let o=t,c=t+1,h=t+2;e&&(o=e.getX(o),c=e.getX(c),h=e.getX(h)),r.x=n.getX(o),r.y=n.getY(o),r.z=n.getZ(o),s.x=n.getX(c),s.y=n.getY(c),s.z=n.getZ(c),a.x=n.getX(h),a.y=n.getY(h),a.z=n.getZ(h)}function O0(i,t,e,n,r,s,a,o){const{geometry:c,_indirectBuffer:h}=i;for(let f=n,g=n+r;f<g;f++)Ko(c,t,e,f,s,a,o)}function z0(i,t,e,n,r,s,a){const{geometry:o,_indirectBuffer:c}=i;let h=1/0,f=null;for(let g=n,p=n+r;g<p;g++){let _;_=Ko(o,t,e,g,null,s,a),_&&_.distance<h&&(f=_,h=_.distance)}return f}function V0(i,t,e,n,r,s,a){const{geometry:o}=e,{index:c}=o,h=o.attributes.position;for(let f=i,g=t+i;f<g;f++){let p;if(p=f,xe(a,p*3,c,h),a.needsUpdate=!0,n(a,p,r,s))return!0}return!1}function H0(i,t=null){t&&Array.isArray(t)&&(t=new Set(t));const e=i.geometry,n=e.index?e.index.array:null,r=e.attributes.position;let s,a,o,c,h=0;const f=i._roots;for(let p=0,_=f.length;p<_;p++)s=f[p],a=new Uint32Array(s),o=new Uint16Array(s),c=new Float32Array(s),g(0,h),h+=s.byteLength;function g(p,_,M=!1){const b=p*2;if(o[b+15]===jo){const m=a[p+6],d=o[b+14];let u=1/0,v=1/0,l=1/0,R=-1/0,T=-1/0,E=-1/0;for(let y=3*m,S=3*(m+d);y<S;y++){let A=n[y];const w=r.getX(A),I=r.getY(A),N=r.getZ(A);w<u&&(u=w),w>R&&(R=w),I<v&&(v=I),I>T&&(T=I),N<l&&(l=N),N>E&&(E=N)}return c[p+0]!==u||c[p+1]!==v||c[p+2]!==l||c[p+3]!==R||c[p+4]!==T||c[p+5]!==E?(c[p+0]=u,c[p+1]=v,c[p+2]=l,c[p+3]=R,c[p+4]=T,c[p+5]=E,!0):!1}else{const m=p+8,d=a[p+6],u=m+_,v=d+_;let l=M,R=!1,T=!1;t?l||(R=t.has(u),T=t.has(v),l=!R&&!T):(R=!0,T=!0);const E=l||R,y=l||T;let S=!1;E&&(S=g(m,_,l));let A=!1;y&&(A=g(d,_,l));const w=S||A;if(w)for(let I=0;I<3;I++){const N=m+I,B=d+I,F=c[N],k=c[N+3],z=c[B],J=c[B+3];c[p+I]=F<z?F:z,c[p+I+3]=k>J?k:J}return w}}}function gi(i,t,e,n,r){let s,a,o,c,h,f;const g=1/e.direction.x,p=1/e.direction.y,_=1/e.direction.z,M=e.origin.x,b=e.origin.y,x=e.origin.z;let m=t[i],d=t[i+3],u=t[i+1],v=t[i+3+1],l=t[i+2],R=t[i+3+2];return g>=0?(s=(m-M)*g,a=(d-M)*g):(s=(d-M)*g,a=(m-M)*g),p>=0?(o=(u-b)*p,c=(v-b)*p):(o=(v-b)*p,c=(u-b)*p),s>c||o>a||((o>s||isNaN(s))&&(s=o),(c<a||isNaN(a))&&(a=c),_>=0?(h=(l-x)*_,f=(R-x)*_):(h=(R-x)*_,f=(l-x)*_),s>f||h>a)?!1:((h>s||s!==s)&&(s=h),(f<a||a!==a)&&(a=f),s<=r&&a>=n)}function G0(i,t,e,n,r,s,a,o){const{geometry:c,_indirectBuffer:h}=i;for(let f=n,g=n+r;f<g;f++){let p=h?h[f]:f;Ko(c,t,e,p,s,a,o)}}function k0(i,t,e,n,r,s,a){const{geometry:o,_indirectBuffer:c}=i;let h=1/0,f=null;for(let g=n,p=n+r;g<p;g++){let _;_=Ko(o,t,e,c?c[g]:g,null,s,a),_&&_.distance<h&&(f=_,h=_.distance)}return f}function W0(i,t,e,n,r,s,a){const{geometry:o}=e,{index:c}=o,h=o.attributes.position;for(let f=i,g=t+i;f<g;f++){let p;if(p=e.resolveTriangleIndex(f),xe(a,p*3,c,h),a.needsUpdate=!0,n(a,p,r,s))return!0}return!1}function X0(i,t,e,n,r,s,a){ae.setBuffer(i._roots[t]),ml(0,i,e,n,r,s,a),ae.clearBuffer()}function ml(i,t,e,n,r,s,a){const{float32Array:o,uint16Array:c,uint32Array:h}=ae,f=i*2;if(We(f,c)){const p=Ze(i,h),_=on(f,c);O0(t,e,n,p,_,r,s,a)}else{const p=an(i);gi(p,o,n,s,a)&&ml(p,t,e,n,r,s,a);const _=cn(i,h);gi(_,o,n,s,a)&&ml(_,t,e,n,r,s,a)}}const q0=["x","y","z"];function Y0(i,t,e,n,r,s){ae.setBuffer(i._roots[t]);const a=_l(0,i,e,n,r,s);return ae.clearBuffer(),a}function _l(i,t,e,n,r,s){const{float32Array:a,uint16Array:o,uint32Array:c}=ae;let h=i*2;if(We(h,o)){const g=Ze(i,c),p=on(h,o);return z0(t,e,n,g,p,r,s)}else{const g=Vf(i,c),p=q0[g],M=n.direction[p]>=0;let b,x;M?(b=an(i),x=cn(i,c)):(b=cn(i,c),x=an(i));const d=gi(b,a,n,r,s)?_l(b,t,e,n,r,s):null;if(d){const l=d.point[p];if(M?l<=a[x+g]:l>=a[x+g+3])return d}const v=gi(x,a,n,r,s)?_l(x,t,e,n,r,s):null;return d&&v?d.distance<=v.distance?d:v:d||v||null}}const io=new ye,rr=new hn,sr=new hn,Yr=new $t,Th=new Ve,ro=new Ve;function $0(i,t,e,n){ae.setBuffer(i._roots[t]);const r=xl(0,i,e,n);return ae.clearBuffer(),r}function xl(i,t,e,n,r=null){const{float32Array:s,uint16Array:a,uint32Array:o}=ae;let c=i*2;if(r===null&&(e.boundingBox||e.computeBoundingBox(),Th.set(e.boundingBox.min,e.boundingBox.max,n),r=Th),We(c,a)){const f=t.geometry,g=f.index,p=f.attributes.position,_=e.index,M=e.attributes.position,b=Ze(i,o),x=on(c,a);if(Yr.copy(n).invert(),e.boundsTree)return fe(i,s,ro),ro.matrix.copy(Yr),ro.needsUpdate=!0,e.boundsTree.shapecast({intersectsBounds:d=>ro.intersectsBox(d),intersectsTriangle:d=>{d.a.applyMatrix4(n),d.b.applyMatrix4(n),d.c.applyMatrix4(n),d.needsUpdate=!0;for(let u=b*3,v=(x+b)*3;u<v;u+=3)if(xe(sr,u,g,p),sr.needsUpdate=!0,d.intersectsTriangle(sr))return!0;return!1}});for(let m=b*3,d=(x+b)*3;m<d;m+=3){xe(rr,m,g,p),rr.a.applyMatrix4(Yr),rr.b.applyMatrix4(Yr),rr.c.applyMatrix4(Yr),rr.needsUpdate=!0;for(let u=0,v=_.count;u<v;u+=3)if(xe(sr,u,_,M),sr.needsUpdate=!0,rr.intersectsTriangle(sr))return!0}}else{const f=i+8,g=o[i+6];return fe(f,s,io),!!(r.intersectsBox(io)&&xl(f,t,e,n,r)||(fe(g,s,io),r.intersectsBox(io)&&xl(g,t,e,n,r)))}}const so=new $t,ic=new Ve,$r=new Ve,j0=new U,K0=new U,Z0=new U,J0=new U;function Q0(i,t,e,n={},r={},s=0,a=1/0){t.boundingBox||t.computeBoundingBox(),ic.set(t.boundingBox.min,t.boundingBox.max,e),ic.needsUpdate=!0;const o=i.geometry,c=o.attributes.position,h=o.index,f=t.attributes.position,g=t.index,p=ln.getPrimitive(),_=ln.getPrimitive();let M=j0,b=K0,x=null,m=null;r&&(x=Z0,m=J0);let d=1/0,u=null,v=null;return so.copy(e).invert(),$r.matrix.copy(so),i.shapecast({boundsTraverseOrder:l=>ic.distanceToBox(l),intersectsBounds:(l,R,T)=>T<d&&T<a?(R&&($r.min.copy(l.min),$r.max.copy(l.max),$r.needsUpdate=!0),!0):!1,intersectsRange:(l,R)=>{if(t.boundsTree)return t.boundsTree.shapecast({boundsTraverseOrder:E=>$r.distanceToBox(E),intersectsBounds:(E,y,S)=>S<d&&S<a,intersectsRange:(E,y)=>{for(let S=E,A=E+y;S<A;S++){xe(_,3*S,g,f),_.a.applyMatrix4(e),_.b.applyMatrix4(e),_.c.applyMatrix4(e),_.needsUpdate=!0;for(let w=l,I=l+R;w<I;w++){xe(p,3*w,h,c),p.needsUpdate=!0;const N=p.distanceToTriangle(_,M,x);if(N<d&&(b.copy(M),m&&m.copy(x),d=N,u=w,v=S),N<s)return!0}}}});{const T=Nr(t);for(let E=0,y=T;E<y;E++){xe(_,3*E,g,f),_.a.applyMatrix4(e),_.b.applyMatrix4(e),_.c.applyMatrix4(e),_.needsUpdate=!0;for(let S=l,A=l+R;S<A;S++){xe(p,3*S,h,c),p.needsUpdate=!0;const w=p.distanceToTriangle(_,M,x);if(w<d&&(b.copy(M),m&&m.copy(x),d=w,u=S,v=E),w<s)return!0}}}}}),ln.releasePrimitive(p),ln.releasePrimitive(_),d===1/0?null:(n.point?n.point.copy(b):n.point=b.clone(),n.distance=d,n.faceIndex=u,r&&(r.point?r.point.copy(m):r.point=m.clone(),r.point.applyMatrix4(so),b.applyMatrix4(so),r.distance=b.sub(r.point).length(),r.faceIndex=v),n)}function ty(i,t=null){t&&Array.isArray(t)&&(t=new Set(t));const e=i.geometry,n=e.index?e.index.array:null,r=e.attributes.position;let s,a,o,c,h=0;const f=i._roots;for(let p=0,_=f.length;p<_;p++)s=f[p],a=new Uint32Array(s),o=new Uint16Array(s),c=new Float32Array(s),g(0,h),h+=s.byteLength;function g(p,_,M=!1){const b=p*2;if(o[b+15]===jo){const m=a[p+6],d=o[b+14];let u=1/0,v=1/0,l=1/0,R=-1/0,T=-1/0,E=-1/0;for(let y=m,S=m+d;y<S;y++){const A=3*i.resolveTriangleIndex(y);for(let w=0;w<3;w++){let I=A+w;I=n?n[I]:I;const N=r.getX(I),B=r.getY(I),F=r.getZ(I);N<u&&(u=N),N>R&&(R=N),B<v&&(v=B),B>T&&(T=B),F<l&&(l=F),F>E&&(E=F)}}return c[p+0]!==u||c[p+1]!==v||c[p+2]!==l||c[p+3]!==R||c[p+4]!==T||c[p+5]!==E?(c[p+0]=u,c[p+1]=v,c[p+2]=l,c[p+3]=R,c[p+4]=T,c[p+5]=E,!0):!1}else{const m=p+8,d=a[p+6],u=m+_,v=d+_;let l=M,R=!1,T=!1;t?l||(R=t.has(u),T=t.has(v),l=!R&&!T):(R=!0,T=!0);const E=l||R,y=l||T;let S=!1;E&&(S=g(m,_,l));let A=!1;y&&(A=g(d,_,l));const w=S||A;if(w)for(let I=0;I<3;I++){const N=m+I,B=d+I,F=c[N],k=c[N+3],z=c[B],J=c[B+3];c[p+I]=F<z?F:z,c[p+I+3]=k>J?k:J}return w}}}function ey(i,t,e,n,r,s,a){ae.setBuffer(i._roots[t]),vl(0,i,e,n,r,s,a),ae.clearBuffer()}function vl(i,t,e,n,r,s,a){const{float32Array:o,uint16Array:c,uint32Array:h}=ae,f=i*2;if(We(f,c)){const p=Ze(i,h),_=on(f,c);G0(t,e,n,p,_,r,s,a)}else{const p=an(i);gi(p,o,n,s,a)&&vl(p,t,e,n,r,s,a);const _=cn(i,h);gi(_,o,n,s,a)&&vl(_,t,e,n,r,s,a)}}const ny=["x","y","z"];function iy(i,t,e,n,r,s){ae.setBuffer(i._roots[t]);const a=yl(0,i,e,n,r,s);return ae.clearBuffer(),a}function yl(i,t,e,n,r,s){const{float32Array:a,uint16Array:o,uint32Array:c}=ae;let h=i*2;if(We(h,o)){const g=Ze(i,c),p=on(h,o);return k0(t,e,n,g,p,r,s)}else{const g=Vf(i,c),p=ny[g],M=n.direction[p]>=0;let b,x;M?(b=an(i),x=cn(i,c)):(b=cn(i,c),x=an(i));const d=gi(b,a,n,r,s)?yl(b,t,e,n,r,s):null;if(d){const l=d.point[p];if(M?l<=a[x+g]:l>=a[x+g+3])return d}const v=gi(x,a,n,r,s)?yl(x,t,e,n,r,s):null;return d&&v?d.distance<=v.distance?d:v:d||v||null}}const oo=new ye,or=new hn,ar=new hn,jr=new $t,bh=new Ve,ao=new Ve;function ry(i,t,e,n){ae.setBuffer(i._roots[t]);const r=Sl(0,i,e,n);return ae.clearBuffer(),r}function Sl(i,t,e,n,r=null){const{float32Array:s,uint16Array:a,uint32Array:o}=ae;let c=i*2;if(r===null&&(e.boundingBox||e.computeBoundingBox(),bh.set(e.boundingBox.min,e.boundingBox.max,n),r=bh),We(c,a)){const f=t.geometry,g=f.index,p=f.attributes.position,_=e.index,M=e.attributes.position,b=Ze(i,o),x=on(c,a);if(jr.copy(n).invert(),e.boundsTree)return fe(i,s,ao),ao.matrix.copy(jr),ao.needsUpdate=!0,e.boundsTree.shapecast({intersectsBounds:d=>ao.intersectsBox(d),intersectsTriangle:d=>{d.a.applyMatrix4(n),d.b.applyMatrix4(n),d.c.applyMatrix4(n),d.needsUpdate=!0;for(let u=b,v=x+b;u<v;u++)if(xe(ar,3*t.resolveTriangleIndex(u),g,p),ar.needsUpdate=!0,d.intersectsTriangle(ar))return!0;return!1}});for(let m=b,d=x+b;m<d;m++){const u=t.resolveTriangleIndex(m);xe(or,3*u,g,p),or.a.applyMatrix4(jr),or.b.applyMatrix4(jr),or.c.applyMatrix4(jr),or.needsUpdate=!0;for(let v=0,l=_.count;v<l;v+=3)if(xe(ar,v,_,M),ar.needsUpdate=!0,or.intersectsTriangle(ar))return!0}}else{const f=i+8,g=o[i+6];return fe(f,s,oo),!!(r.intersectsBox(oo)&&Sl(f,t,e,n,r)||(fe(g,s,oo),r.intersectsBox(oo)&&Sl(g,t,e,n,r)))}}const co=new $t,rc=new Ve,Kr=new Ve,sy=new U,oy=new U,ay=new U,cy=new U;function ly(i,t,e,n={},r={},s=0,a=1/0){t.boundingBox||t.computeBoundingBox(),rc.set(t.boundingBox.min,t.boundingBox.max,e),rc.needsUpdate=!0;const o=i.geometry,c=o.attributes.position,h=o.index,f=t.attributes.position,g=t.index,p=ln.getPrimitive(),_=ln.getPrimitive();let M=sy,b=oy,x=null,m=null;r&&(x=ay,m=cy);let d=1/0,u=null,v=null;return co.copy(e).invert(),Kr.matrix.copy(co),i.shapecast({boundsTraverseOrder:l=>rc.distanceToBox(l),intersectsBounds:(l,R,T)=>T<d&&T<a?(R&&(Kr.min.copy(l.min),Kr.max.copy(l.max),Kr.needsUpdate=!0),!0):!1,intersectsRange:(l,R)=>{if(t.boundsTree){const T=t.boundsTree;return T.shapecast({boundsTraverseOrder:E=>Kr.distanceToBox(E),intersectsBounds:(E,y,S)=>S<d&&S<a,intersectsRange:(E,y)=>{for(let S=E,A=E+y;S<A;S++){const w=T.resolveTriangleIndex(S);xe(_,3*w,g,f),_.a.applyMatrix4(e),_.b.applyMatrix4(e),_.c.applyMatrix4(e),_.needsUpdate=!0;for(let I=l,N=l+R;I<N;I++){const B=i.resolveTriangleIndex(I);xe(p,3*B,h,c),p.needsUpdate=!0;const F=p.distanceToTriangle(_,M,x);if(F<d&&(b.copy(M),m&&m.copy(x),d=F,u=I,v=S),F<s)return!0}}}})}else{const T=Nr(t);for(let E=0,y=T;E<y;E++){xe(_,3*E,g,f),_.a.applyMatrix4(e),_.b.applyMatrix4(e),_.c.applyMatrix4(e),_.needsUpdate=!0;for(let S=l,A=l+R;S<A;S++){const w=i.resolveTriangleIndex(S);xe(p,3*w,h,c),p.needsUpdate=!0;const I=p.distanceToTriangle(_,M,x);if(I<d&&(b.copy(M),m&&m.copy(x),d=I,u=S,v=E),I<s)return!0}}}}}),ln.releasePrimitive(p),ln.releasePrimitive(_),d===1/0?null:(n.point?n.point.copy(b):n.point=b.clone(),n.distance=d,n.faceIndex=u,r&&(r.point?r.point.copy(m):r.point=m.clone(),r.point.applyMatrix4(co),b.applyMatrix4(co),r.distance=b.sub(r.point).length(),r.faceIndex=v),n)}function uy(){return typeof SharedArrayBuffer<"u"}const ss=new ae.constructor,Go=new ae.constructor,ii=new Fl(()=>new ye),cr=new ye,lr=new ye,sc=new ye,oc=new ye;let ac=!1;function hy(i,t,e,n){if(ac)throw new Error("MeshBVH: Recursive calls to bvhcast not supported.");ac=!0;const r=i._roots,s=t._roots;let a,o=0,c=0;const h=new $t().copy(e).invert();for(let f=0,g=r.length;f<g;f++){ss.setBuffer(r[f]),c=0;const p=ii.getPrimitive();fe(0,ss.float32Array,p),p.applyMatrix4(h);for(let _=0,M=s.length;_<M&&(Go.setBuffer(s[_]),a=_n(0,0,e,h,n,o,c,0,0,p),Go.clearBuffer(),c+=s[_].length,!a);_++);if(ii.releasePrimitive(p),ss.clearBuffer(),o+=r[f].length,a)break}return ac=!1,a}function _n(i,t,e,n,r,s=0,a=0,o=0,c=0,h=null,f=!1){let g,p;f?(g=Go,p=ss):(g=ss,p=Go);const _=g.float32Array,M=g.uint32Array,b=g.uint16Array,x=p.float32Array,m=p.uint32Array,d=p.uint16Array,u=i*2,v=t*2,l=We(u,b),R=We(v,d);let T=!1;if(R&&l)f?T=r(Ze(t,m),on(t*2,d),Ze(i,M),on(i*2,b),c,a+t,o,s+i):T=r(Ze(i,M),on(i*2,b),Ze(t,m),on(t*2,d),o,s+i,c,a+t);else if(R){const E=ii.getPrimitive();fe(t,x,E),E.applyMatrix4(e);const y=an(i),S=cn(i,M);fe(y,_,cr),fe(S,_,lr);const A=E.intersectsBox(cr),w=E.intersectsBox(lr);T=A&&_n(t,y,n,e,r,a,s,c,o+1,E,!f)||w&&_n(t,S,n,e,r,a,s,c,o+1,E,!f),ii.releasePrimitive(E)}else{const E=an(t),y=cn(t,m);fe(E,x,sc),fe(y,x,oc);const S=h.intersectsBox(sc),A=h.intersectsBox(oc);if(S&&A)T=_n(i,E,e,n,r,s,a,o,c+1,h,f)||_n(i,y,e,n,r,s,a,o,c+1,h,f);else if(S)if(l)T=_n(i,E,e,n,r,s,a,o,c+1,h,f);else{const w=ii.getPrimitive();w.copy(sc).applyMatrix4(e);const I=an(i),N=cn(i,M);fe(I,_,cr),fe(N,_,lr);const B=w.intersectsBox(cr),F=w.intersectsBox(lr);T=B&&_n(E,I,n,e,r,a,s,c,o+1,w,!f)||F&&_n(E,N,n,e,r,a,s,c,o+1,w,!f),ii.releasePrimitive(w)}else if(A)if(l)T=_n(i,y,e,n,r,s,a,o,c+1,h,f);else{const w=ii.getPrimitive();w.copy(oc).applyMatrix4(e);const I=an(i),N=cn(i,M);fe(I,_,cr),fe(N,_,lr);const B=w.intersectsBox(cr),F=w.intersectsBox(lr);T=B&&_n(y,I,n,e,r,a,s,c,o+1,w,!f)||F&&_n(y,N,n,e,r,a,s,c,o+1,w,!f),ii.releasePrimitive(w)}}return T}const lo=new Ve,Ah=new ye,fy={strategy:Bf,maxDepth:40,maxLeafTris:10,useSharedArrayBuffer:!1,setBoundingBox:!0,onProgress:null,indirect:!1,verbose:!0,range:null};class Pr{static serialize(t,e={}){e={cloneBuffers:!0,...e};const n=t.geometry,r=t._roots,s=t._indirectBuffer,a=n.getIndex();let o;return e.cloneBuffers?o={roots:r.map(c=>c.slice()),index:a?a.array.slice():null,indirectBuffer:s?s.slice():null}:o={roots:r,index:a?a.array:null,indirectBuffer:s},o}static deserialize(t,e,n={}){n={setIndex:!0,indirect:!!t.indirectBuffer,...n};const{index:r,roots:s,indirectBuffer:a}=t,o=new Pr(e,{...n,[Ja]:!0});if(o._roots=s,o._indirectBuffer=a||null,n.setIndex){const c=e.getIndex();if(c===null){const h=new de(t.index,1,!1);e.setIndex(h)}else c.array!==r&&(c.array.set(r),c.needsUpdate=!0)}return o}get indirect(){return!!this._indirectBuffer}constructor(t,e={}){if(t.isBufferGeometry){if(t.index&&t.index.isInterleavedBufferAttribute)throw new Error("MeshBVH: InterleavedBufferAttribute is not supported for the index attribute.")}else throw new Error("MeshBVH: Only BufferGeometries are supported.");if(e=Object.assign({...fy,[Ja]:!1},e),e.useSharedArrayBuffer&&!uy())throw new Error("MeshBVH: SharedArrayBuffer is not available.");this.geometry=t,this._roots=null,this._indirectBuffer=null,e[Ja]||(w0(this,e),!t.boundingBox&&e.setBoundingBox&&(t.boundingBox=this.getBoundingBox(new ye))),this.resolveTriangleIndex=e.indirect?n=>this._indirectBuffer[n]:n=>n}refit(t=null){return(this.indirect?ty:H0)(this,t)}traverse(t,e=0){const n=this._roots[e],r=new Uint32Array(n),s=new Uint16Array(n);a(0);function a(o,c=0){const h=o*2,f=s[h+15]===jo;if(f){const g=r[o+6],p=s[h+14];t(c,f,new Float32Array(n,o*4,6),g,p)}else{const g=o+rs/4,p=r[o+6],_=r[o+7];t(c,f,new Float32Array(n,o*4,6),_)||(a(g,c+1),a(p,c+1))}}}raycast(t,e=In,n=0,r=1/0){const s=this._roots,a=this.geometry,o=[],c=e.isMaterial,h=Array.isArray(e),f=a.groups,g=c?e.side:e,p=this.indirect?ey:X0;for(let _=0,M=s.length;_<M;_++){const b=h?e[f[_].materialIndex].side:g,x=o.length;if(p(this,_,b,t,o,n,r),h){const m=f[_].materialIndex;for(let d=x,u=o.length;d<u;d++)o[d].face.materialIndex=m}}return o}raycastFirst(t,e=In,n=0,r=1/0){const s=this._roots,a=this.geometry,o=e.isMaterial,c=Array.isArray(e);let h=null;const f=a.groups,g=o?e.side:e,p=this.indirect?iy:Y0;for(let _=0,M=s.length;_<M;_++){const b=c?e[f[_].materialIndex].side:g,x=p(this,_,b,t,n,r);x!=null&&(h==null||x.distance<h.distance)&&(h=x,c&&(x.face.materialIndex=f[_].materialIndex))}return h}intersectsGeometry(t,e){let n=!1;const r=this._roots,s=this.indirect?ry:$0;for(let a=0,o=r.length;a<o&&(n=s(this,a,t,e),!n);a++);return n}shapecast(t){const e=ln.getPrimitive(),n=this.indirect?W0:V0;let{boundsTraverseOrder:r,intersectsBounds:s,intersectsRange:a,intersectsTriangle:o}=t;if(a&&o){const g=a;a=(p,_,M,b,x)=>g(p,_,M,b,x)?!0:n(p,_,this,o,M,b,e)}else a||(o?a=(g,p,_,M)=>n(g,p,this,o,_,M,e):a=(g,p,_)=>_);let c=!1,h=0;const f=this._roots;for(let g=0,p=f.length;g<p;g++){const _=f[g];if(c=D0(this,g,s,a,r,h),c)break;h+=_.byteLength}return ln.releasePrimitive(e),c}bvhcast(t,e,n){let{intersectsRanges:r,intersectsTriangles:s}=n;const a=ln.getPrimitive(),o=this.geometry.index,c=this.geometry.attributes.position,h=this.indirect?M=>{const b=this.resolveTriangleIndex(M);xe(a,b*3,o,c)}:M=>{xe(a,M*3,o,c)},f=ln.getPrimitive(),g=t.geometry.index,p=t.geometry.attributes.position,_=t.indirect?M=>{const b=t.resolveTriangleIndex(M);xe(f,b*3,g,p)}:M=>{xe(f,M*3,g,p)};if(s){const M=(b,x,m,d,u,v,l,R)=>{for(let T=m,E=m+d;T<E;T++){_(T),f.a.applyMatrix4(e),f.b.applyMatrix4(e),f.c.applyMatrix4(e),f.needsUpdate=!0;for(let y=b,S=b+x;y<S;y++)if(h(y),a.needsUpdate=!0,s(a,f,y,T,u,v,l,R))return!0}return!1};if(r){const b=r;r=function(x,m,d,u,v,l,R,T){return b(x,m,d,u,v,l,R,T)?!0:M(x,m,d,u,v,l,R,T)}}else r=M}return hy(this,t,e,r)}intersectsBox(t,e){return lo.set(t.min,t.max,e),lo.needsUpdate=!0,this.shapecast({intersectsBounds:n=>lo.intersectsBox(n),intersectsTriangle:n=>lo.intersectsTriangle(n)})}intersectsSphere(t){return this.shapecast({intersectsBounds:e=>t.intersectsBox(e),intersectsTriangle:e=>e.intersectsSphere(t)})}closestPointToGeometry(t,e,n={},r={},s=0,a=1/0){return(this.indirect?ly:Q0)(this,t,e,n,r,s,a)}closestPointToPoint(t,e={},n=0,r=1/0){return U0(this,t,e,n,r)}getBoundingBox(t){return t.makeEmpty(),this._roots.forEach(n=>{fe(0,new Float32Array(n),Ah),t.union(Ah)}),t}}function wh(i,t,e){return i===null?null:(i.point.applyMatrix4(t.matrixWorld),i.distance=i.point.distanceTo(e.ray.origin),i.object=t,i)}const dy=parseInt(ms)>=166,uo=new Lr,Rh=new U,Ch=new $t,py=Ie.prototype.raycast,gy=bo.prototype.raycast,Ph=new U,Ae=new Ie,ho=[];function Ih(i,t){this.isBatchedMesh?my.call(this,i,t):_y.call(this,i,t)}function my(i,t){if(this.boundsTrees){const e=this.boundsTrees,n=this._drawInfo||this._instanceInfo,r=this._drawRanges||this._geometryInfo,s=this.matrixWorld;Ae.material=this.material,Ae.geometry=this.geometry;const a=Ae.geometry.boundsTree,o=Ae.geometry.drawRange;Ae.geometry.boundingSphere===null&&(Ae.geometry.boundingSphere=new Rn);for(let c=0,h=n.length;c<h;c++){if(!this.getVisibleAt(c))continue;const f=n[c].geometryIndex;if(Ae.geometry.boundsTree=e[f],this.getMatrixAt(c,Ae.matrixWorld).premultiply(s),!Ae.geometry.boundsTree){this.getBoundingBoxAt(f,Ae.geometry.boundingBox),this.getBoundingSphereAt(f,Ae.geometry.boundingSphere);const g=r[f];Ae.geometry.setDrawRange(g.start,g.count)}Ae.raycast(i,ho);for(let g=0,p=ho.length;g<p;g++){const _=ho[g];_.object=this,_.batchId=c,t.push(_)}ho.length=0}Ae.geometry.boundsTree=a,Ae.geometry.drawRange=o,Ae.material=null,Ae.geometry=null}else gy.call(this,i,t)}function _y(i,t){if(this.geometry.boundsTree){if(this.material===void 0)return;Ch.copy(this.matrixWorld).invert(),uo.copy(i.ray).applyMatrix4(Ch),Ph.setFromMatrixScale(this.matrixWorld),Rh.copy(uo.direction).multiply(Ph);const e=Rh.length(),n=i.near/e,r=i.far/e,s=this.geometry.boundsTree;if(i.firstHitOnly===!0){const a=wh(s.raycastFirst(uo,this.material,n,r),this,i);a&&t.push(a)}else{const a=s.raycast(uo,this.material,n,r);for(let o=0,c=a.length;o<c;o++){const h=wh(a[o],this,i);h&&t.push(h)}}}else py.call(this,i,t)}function xy(i={}){return this.boundsTree=new Pr(this,i),this.boundsTree}function vy(){this.boundsTree=null}function yy(i=-1,t={}){if(!dy)throw new Error("BatchedMesh: Three r166+ is required to compute bounds trees.");t.indirect&&console.warn('"Indirect" is set to false because it is not supported for BatchedMesh.'),t={...t,indirect:!1,range:null};const e=this._drawRanges||this._geometryInfo,n=this._geometryCount;this.boundsTrees||(this.boundsTrees=new Array(n).fill(null));const r=this.boundsTrees;for(;r.length<n;)r.push(null);if(i<0){for(let s=0;s<n;s++)t.range=e[s],r[s]=new Pr(this.geometry,t);return r}else return i<e.length&&(t.range=e[i],r[i]=new Pr(this.geometry,t)),r[i]||null}function Sy(i=-1){i<0?this.boundsTrees.fill(null):i<this.boundsTree.length&&(this.boundsTrees[i]=null)}function kf(i,t=1e-4){t=Math.max(t,Number.EPSILON);const e={},n=i.getIndex(),r=i.getAttribute("position"),s=n?n.count:r.count;let a=0;const o=Object.keys(i.attributes),c={},h={},f=[],g=["getX","getY","getZ","getW"],p=["setX","setY","setZ","setW"];for(let d=0,u=o.length;d<u;d++){const v=o[d],l=i.attributes[v];c[v]=new l.constructor(new l.array.constructor(l.count*l.itemSize),l.itemSize,l.normalized);const R=i.morphAttributes[v];R&&(h[v]||(h[v]=[]),R.forEach((T,E)=>{const y=new T.array.constructor(T.count*T.itemSize);h[v][E]=new T.constructor(y,T.itemSize,T.normalized)}))}const _=t*.5,M=Math.log10(1/t),b=Math.pow(10,M),x=_*b;for(let d=0;d<s;d++){const u=n?n.getX(d):d;let v="";for(let l=0,R=o.length;l<R;l++){const T=o[l],E=i.getAttribute(T),y=E.itemSize;for(let S=0;S<y;S++)v+=`${~~(E[g[S]](u)*b+x)},`}if(v in e)f.push(e[v]);else{for(let l=0,R=o.length;l<R;l++){const T=o[l],E=i.getAttribute(T),y=i.morphAttributes[T],S=E.itemSize,A=c[T],w=h[T];for(let I=0;I<S;I++){const N=g[I],B=p[I];if(A[B](a,E[N](u)),y)for(let F=0,k=y.length;F<k;F++)w[F][B](a,y[F][N](u))}}e[v]=a,f.push(a),a++}}const m=i.clone();for(const d in i.attributes){const u=c[d];if(m.setAttribute(d,new u.constructor(u.array.slice(0,a*u.itemSize),u.itemSize,u.normalized)),d in h)for(let v=0;v<h[d].length;v++){const l=h[d][v];m.morphAttributes[d][v]=new l.constructor(l.array.slice(0,a*l.itemSize),l.itemSize,l.normalized)}}return m.setIndex(f),m}const Wf=1e-6,My=Wf*.5,Xf=Math.pow(10,-Math.log10(Wf)),Ey=My*Xf;function wn(i){return~~(i*Xf+Ey)}function Ty(i){return`${wn(i.x)},${wn(i.y)}`}function Lh(i){return`${wn(i.x)},${wn(i.y)},${wn(i.z)}`}function by(i){return`${wn(i.x)},${wn(i.y)},${wn(i.z)},${wn(i.w)}`}function Ay(i,t,e){e.direction.subVectors(t,i).normalize();const n=i.dot(e.direction);return e.origin.copy(i).addScaledVector(e.direction,-n),e}function qf(){return typeof SharedArrayBuffer<"u"}function wy(i){if(i.buffer instanceof SharedArrayBuffer)return i;const t=i.constructor,e=i.buffer,n=new SharedArrayBuffer(e.byteLength),r=new Uint8Array(e);return new Uint8Array(n).set(r,0),new t(n)}function Ry(i,t=ArrayBuffer){return i>65535?new Uint32Array(new t(4*i)):new Uint16Array(new t(2*i))}function Cy(i,t){if(!i.index){const e=i.attributes.position.count,n=t.useSharedArrayBuffer?SharedArrayBuffer:ArrayBuffer,r=Ry(e,n);i.setIndex(new de(r,1));for(let s=0;s<e;s++)r[s]=s}}function Py(i){return i.index?i.index.count:i.attributes.position.count}function Bl(i){return Py(i)/3}const Iy=1e-8,Ly=new U;function Dy(i){return~~(i/3)}function Uy(i){return i%3}function Dh(i,t){return i.start-t.start}function Uh(i,t){return Ly.subVectors(t,i.origin).dot(i.direction)}function Ny(i,t,e,n=Iy){i.sort(Dh),t.sort(Dh);for(let o=0;o<i.length;o++){const c=i[o];for(let h=0;h<t.length;h++){const f=t[h];if(!(f.start>c.end)){if(c.end<f.start||f.end<c.start)continue;if(c.start<=f.start&&c.end>=f.end)s(f.end,c.end)||i.splice(o+1,0,{start:f.end,end:c.end,index:c.index}),c.end=f.start,f.start=0,f.end=0;else if(c.start>=f.start&&c.end<=f.end)s(c.end,f.end)||t.splice(h+1,0,{start:c.end,end:f.end,index:f.index}),f.end=c.start,c.start=0,c.end=0;else if(c.start<=f.start&&c.end<=f.end){const g=c.end;c.end=f.start,f.start=g}else if(c.start>=f.start&&c.end>=f.end){const g=f.end;f.end=c.start,c.start=g}else throw new Error}if(e.has(c.index)||e.set(c.index,[]),e.has(f.index)||e.set(f.index,[]),e.get(c.index).push(f.index),e.get(f.index).push(c.index),a(f)&&(t.splice(h,1),h--),a(c)){i.splice(o,1),o--;break}}}r(i),r(t);function r(o){for(let c=0;c<o.length;c++)a(o[c])&&(o.splice(c,1),c--)}function s(o,c){return Math.abs(c-o)<n}function a(o){return Math.abs(o.end-o.start)<n}}const Nh=1e-5,Fh=1e-4;class Fy{constructor(){this._rays=[]}addRay(t){this._rays.push(t)}findClosestRay(t){const e=this._rays,n=t.clone();n.direction.multiplyScalar(-1);let r=1/0,s=null;for(let c=0,h=e.length;c<h;c++){const f=e[c];if(a(f,t)&&a(f,n))continue;const g=o(f,t),p=o(f,n),_=Math.min(g,p);_<r&&(r=_,s=f)}return s;function a(c,h){const f=c.origin.distanceTo(h.origin)>Nh;return c.direction.angleTo(h.direction)>Fh||f}function o(c,h){const f=c.origin.distanceTo(h.origin),g=c.direction.angleTo(h.direction);return f/Nh+g/Fh}}}const cc=new U,lc=new U,fo=new Lr;function By(i,t,e){const n=i.attributes,r=i.index,s=n.position,a=new Map,o=new Map,c=Array.from(t),h=new Fy;for(let f=0,g=c.length;f<g;f++){const p=c[f],_=Dy(p),M=Uy(p);let b=3*_+M,x=3*_+(M+1)%3;r&&(b=r.getX(b),x=r.getX(x)),cc.fromBufferAttribute(s,b),lc.fromBufferAttribute(s,x),Ay(cc,lc,fo);let m,d=h.findClosestRay(fo);d===null&&(d=fo.clone(),h.addRay(d)),o.has(d)||o.set(d,{forward:[],reverse:[],ray:d}),m=o.get(d);let u=Uh(d,cc),v=Uh(d,lc);u>v&&([u,v]=[v,u]),fo.direction.dot(d.direction)<0?m.reverse.push({start:u,end:v,index:p}):m.forward.push({start:u,end:v,index:p})}return o.forEach(({forward:f,reverse:g},p)=>{Ny(f,g,a,e),f.length===0&&g.length===0&&o.delete(p)}),{disjointConnectivityMap:a,fragmentMap:o}}const Oy=new kt,uc=new U,zy=new ie,hc=["","",""];class Vy{constructor(t=null){this.data=null,this.disjointConnections=null,this.unmatchedDisjointEdges=null,this.unmatchedEdges=-1,this.matchedEdges=-1,this.useDrawRange=!0,this.useAllAttributes=!1,this.matchDisjointEdges=!1,this.degenerateEpsilon=1e-8,t&&this.updateFrom(t)}getSiblingTriangleIndex(t,e){const n=this.data[t*3+e];return n===-1?-1:~~(n/3)}getSiblingEdgeIndex(t,e){const n=this.data[t*3+e];return n===-1?-1:n%3}getDisjointSiblingTriangleIndices(t,e){const n=t*3+e,r=this.disjointConnections.get(n);return r?r.map(s=>~~(s/3)):[]}getDisjointSiblingEdgeIndices(t,e){const n=t*3+e,r=this.disjointConnections.get(n);return r?r.map(s=>s%3):[]}isFullyConnected(){return this.unmatchedEdges===0}updateFrom(t){const{useAllAttributes:e,useDrawRange:n,matchDisjointEdges:r,degenerateEpsilon:s}=this,a=e?u:d,o=new Map,{attributes:c}=t,h=e?Object.keys(c):null,f=t.index,g=c.position;let p=Bl(t);const _=p;let M=0;n&&(M=t.drawRange.start,t.drawRange.count!==1/0&&(p=~~(t.drawRange.count/3)));let b=this.data;(!b||b.length<3*_)&&(b=new Int32Array(3*_)),b.fill(-1);let x=0,m=new Set;for(let v=M,l=p*3+M;v<l;v+=3){const R=v;for(let T=0;T<3;T++){let E=R+T;f&&(E=f.getX(E)),hc[T]=a(E)}for(let T=0;T<3;T++){const E=(T+1)%3,y=hc[T],S=hc[E],A=`${S}_${y}`;if(o.has(A)){const w=R+T,I=o.get(A);b[w]=I,b[I]=w,o.delete(A),x+=2,m.delete(I)}else{const w=`${y}_${S}`,I=R+T;o.set(w,I),m.add(I)}}}if(r){const{fragmentMap:v,disjointConnectivityMap:l}=By(t,m,s);m.clear(),v.forEach(({forward:R,reverse:T})=>{R.forEach(({index:E})=>m.add(E)),T.forEach(({index:E})=>m.add(E))}),this.unmatchedDisjointEdges=v,this.disjointConnections=l,x=p*3-m.size}this.matchedEdges=x,this.unmatchedEdges=m.size,this.data=b;function d(v){return uc.fromBufferAttribute(g,v),Lh(uc)}function u(v){let l="";for(let R=0,T=h.length;R<T;R++){const E=c[h[R]];let y;switch(E.itemSize){case 1:y=wn(E.getX(v));break;case 2:y=Ty(Oy.fromBufferAttribute(E,v));break;case 3:y=Lh(uc.fromBufferAttribute(E,v));break;case 4:y=by(zy.fromBufferAttribute(E,v));break}l!==""&&(l+="|"),l+=y}return l}}}class ps extends Ie{constructor(...t){super(...t),this.isBrush=!0,this._previousMatrix=new $t,this._previousMatrix.elements.fill(0)}markUpdated(){this._previousMatrix.copy(this.matrix)}isDirty(){const{matrix:t,_previousMatrix:e}=this,n=t.elements,r=e.elements;for(let s=0;s<16;s++)if(n[s]!==r[s])return!0;return!1}prepareGeometry(){const t=this.geometry,e=t.attributes,n=qf();if(n)for(const r in e){const s=e[r];if(s.isInterleavedBufferAttribute)throw new Error("Brush: InterleavedBufferAttributes are not supported.");s.array=wy(s.array)}if(t.boundsTree||(Cy(t,{useSharedArrayBuffer:n}),t.boundsTree=new Pr(t,{maxLeafTris:3,indirect:!0,useSharedArrayBuffer:n})),t.halfEdges||(t.halfEdges=new Vy(t)),!t.groupIndices){const r=Bl(t),s=new Uint16Array(r),a=t.groups;for(let o=0,c=a.length;o<c;o++){const{start:h,count:f}=a[o];for(let g=h/3,p=(h+f)/3;g<p;g++)s[g]=o}t.groupIndices=s}}disposeCacheData(){const{geometry:t}=this;t.halfEdges=null,t.boundsTree=null,t.groupIndices=null}}const Hy=1e-14,fc=new U,Bh=new U,Oh=new U;function si(i,t=Hy){fc.subVectors(i.b,i.a),Bh.subVectors(i.c,i.a),Oh.subVectors(i.b,i.c);const e=fc.angleTo(Bh),n=fc.angleTo(Oh),r=Math.PI-e-n;return Math.abs(e)<t||Math.abs(n)<t||Math.abs(r)<t||i.a.distanceToSquared(i.b)<t||i.a.distanceToSquared(i.c)<t||i.b.distanceToSquared(i.c)<t}const dc=1e-10,Zr=1e-10,Gy=1e-10,Vn=new un,pe=new un,Hn=new U,pc=new U,zh=new U,po=new En,gc=new hn;class ky{constructor(){this._pool=[],this._index=0}getTriangle(){return this._index>=this._pool.length&&this._pool.push(new ve),this._pool[this._index++]}clear(){this._index=0}reset(){this._pool.length=0,this._index=0}}class Wy{constructor(){this.trianglePool=new ky,this.triangles=[],this.normal=new U,this.coplanarTriangleUsed=!1}initialize(t){this.reset();const{triangles:e,trianglePool:n,normal:r}=this;if(Array.isArray(t))for(let s=0,a=t.length;s<a;s++){const o=t[s];if(s===0)o.getNormal(r);else if(Math.abs(1-o.getNormal(Hn).dot(r))>dc)throw new Error("Triangle Splitter: Cannot initialize with triangles that have different normals.");const c=n.getTriangle();c.copy(o),e.push(c)}else{t.getNormal(r);const s=n.getTriangle();s.copy(t),e.push(s)}}splitByTriangle(t){const{normal:e,triangles:n}=this;if(t.getNormal(pc).normalize(),Math.abs(1-Math.abs(pc.dot(e)))<Gy){this.coplanarTriangleUsed=!0;for(let s=0,a=n.length;s<a;s++){const o=n[s];o.coplanarCount=0}const r=[t.a,t.b,t.c];for(let s=0;s<3;s++){const a=(s+1)%3,o=r[s],c=r[a];Hn.subVectors(c,o).normalize(),zh.crossVectors(pc,Hn),po.setFromNormalAndCoplanarPoint(zh,o),this.splitByPlane(po,t)}}else t.getPlane(po),this.splitByPlane(po,t)}splitByPlane(t,e){const{triangles:n,trianglePool:r}=this;gc.copy(e),gc.needsUpdate=!0;for(let s=0,a=n.length;s<a;s++){const o=n[s];if(!gc.intersectsTriangle(o,Vn,!0))continue;const{a:c,b:h,c:f}=o;let g=0,p=-1,_=!1,M=[],b=[];const x=[c,h,f];for(let m=0;m<3;m++){const d=(m+1)%3;Vn.start.copy(x[m]),Vn.end.copy(x[d]);const u=t.distanceToPoint(Vn.start),v=t.distanceToPoint(Vn.end);if(Math.abs(u)<Zr&&Math.abs(v)<Zr){_=!0;break}if(u>0?M.push(m):b.push(m),Math.abs(u)<Zr)continue;let l=!!t.intersectLine(Vn,Hn);!l&&Math.abs(v)<Zr&&(Hn.copy(Vn.end),l=!0),l&&!(Hn.distanceTo(Vn.start)<dc)&&(Hn.distanceTo(Vn.end)<dc&&(p=m),g===0?pe.start.copy(Hn):pe.end.copy(Hn),g++)}if(!_&&g===2&&pe.distance()>Zr)if(p!==-1){p=(p+1)%3;let m=0;m===p&&(m=(m+1)%3);let d=m+1;d===p&&(d=(d+1)%3);const u=r.getTriangle();u.a.copy(x[d]),u.b.copy(pe.end),u.c.copy(pe.start),si(u)||n.push(u),o.a.copy(x[m]),o.b.copy(pe.start),o.c.copy(pe.end),si(o)&&(n.splice(s,1),s--,a--)}else{const m=M.length>=2?b[0]:M[0];if(m===0){let R=pe.start;pe.start=pe.end,pe.end=R}const d=(m+1)%3,u=(m+2)%3,v=r.getTriangle(),l=r.getTriangle();x[d].distanceToSquared(pe.start)<x[u].distanceToSquared(pe.end)?(v.a.copy(x[d]),v.b.copy(pe.start),v.c.copy(pe.end),l.a.copy(x[d]),l.b.copy(x[u]),l.c.copy(pe.start)):(v.a.copy(x[u]),v.b.copy(pe.start),v.c.copy(pe.end),l.a.copy(x[d]),l.b.copy(x[u]),l.c.copy(pe.end)),o.a.copy(x[m]),o.b.copy(pe.end),o.c.copy(pe.start),si(v)||n.push(v),si(l)||n.push(l),si(o)&&(n.splice(s,1),s--,a--)}else g===3&&console.warn("TriangleClipper: Coplanar clip not handled")}}reset(){this.triangles.length=0,this.trianglePool.clear(),this.coplanarTriangleUsed=!1}}function Xy(i){return i=~~i,i+4-i%4}class Vh{constructor(t,e=500){this.expansionFactor=1.5,this.type=t,this.length=0,this.array=null,this.setSize(e)}setType(t){if(this.length!==0)throw new Error("TypeBackedArray: Cannot change the type while there is used data in the buffer.");const e=this.array.buffer;this.array=new t(e),this.type=t}setSize(t){if(this.array&&t===this.array.length)return;const e=this.type,n=qf()?SharedArrayBuffer:ArrayBuffer,r=new e(new n(Xy(t*e.BYTES_PER_ELEMENT)));this.array&&r.set(this.array,0),this.array=r}expand(){const{array:t,expansionFactor:e}=this;this.setSize(t.length*e)}push(...t){let{array:e,length:n}=this;n+t.length>e.length&&(this.expand(),e=this.array);for(let r=0,s=t.length;r<s;r++)e[n+r]=t[r];this.length+=t.length}clear(){this.length=0}}class qy{constructor(){this.groupAttributes=[{}],this.groupCount=0}getType(t){return this.groupAttributes[0][t].type}getItemSize(t){return this.groupAttributes[0][t].itemSize}getNormalized(t){return this.groupAttributes[0][t].normalized}getCount(t){if(this.groupCount<=t)return 0;const e=this.getGroupAttrArray("position",t);return e.length/e.itemSize}getTotalLength(t){const{groupCount:e,groupAttributes:n}=this;let r=0;for(let s=0;s<e;s++){const a=n[s];r+=a[t].length}return r}getGroupAttrSet(t=0){const{groupAttributes:e}=this;if(e[t])return this.groupCount=Math.max(this.groupCount,t+1),e[t];const n=e[0];for(this.groupCount=Math.max(this.groupCount,t+1);t>=e.length;){const r={};e.push(r);for(const s in n){const a=n[s],o=new Vh(a.type);o.itemSize=a.itemSize,o.normalized=a.normalized,r[s]=o}}return e[t]}getGroupAttrArray(t,e=0){const{groupAttributes:n}=this;if(!n[0][t])throw new Error(`TypedAttributeData: Attribute with "${t}" has not been initialized`);return this.getGroupAttrSet(e)[t]}initializeArray(t,e,n,r){const{groupAttributes:s}=this,o=s[0][t];if(o){if(o.type!==e)for(let c=0,h=s.length;c<h;c++){const f=s[c][t];f.setType(e),f.itemSize=n,f.normalized=r}}else for(let c=0,h=s.length;c<h;c++){const f=new Vh(e);f.itemSize=n,f.normalized=r,s[c][t]=f}}clear(){this.groupCount=0;const{groupAttributes:t}=this;t.forEach(e=>{for(const n in e)e[n].clear()})}delete(t){this.groupAttributes.forEach(e=>{delete e[t]})}reset(){this.groupAttributes=[],this.groupCount=0}}class Hh{constructor(){this.intersectionSet={},this.ids=[]}add(t,e){const{intersectionSet:n,ids:r}=this;n[t]||(n[t]=[],r.push(t)),n[t].push(e)}}const Yf=0,$f=1,Yy=2,$y=3,jy=4,jf=5,Kf=6,nn=new Lr,Gh=new $t,Ne=new ve,Gn=new U,kh=new ie,Wh=new ie,Xh=new ie,mc=new ie,go=new ie,mo=new ie,qh=new un,_c=new U,xc=1e-8,Ky=1e-15,Ui=-1,Ni=1,Io=-2,Lo=2,os=0,Ci=1,Ol=2,Zy=1e-14;let Do=null;function Yh(i){Do=i}function Zf(i,t){i.getMidpoint(nn.origin),i.getNormal(nn.direction);const e=t.raycastFirst(nn,Be);return!!(e&&nn.direction.dot(e.face.normal)>0)?Ui:Ni}function Jy(i,t){function e(){return Math.random()-.5}i.getNormal(_c),nn.direction.copy(_c),i.getMidpoint(nn.origin);const n=3;let r=0,s=1/0;for(let a=0;a<n;a++){nn.direction.x+=e()*xc,nn.direction.y+=e()*xc,nn.direction.z+=e()*xc,nn.direction.multiplyScalar(-1);const o=t.raycastFirst(nn,Be);if(!!(o&&nn.direction.dot(o.face.normal)>0)&&r++,o!==null&&(s=Math.min(s,o.distance)),s<=Ky)return o.face.normal.dot(_c)>0?Lo:Io;if(r/n>.5||(a-r+1)/n>.5)break}return r/n>.5?Ui:Ni}function Qy(i,t){const e=new Hh,n=new Hh;return Gh.copy(i.matrixWorld).invert().multiply(t.matrixWorld),i.geometry.boundsTree.bvhcast(t.geometry.boundsTree,Gh,{intersectsTriangles(r,s,a,o){if(!si(r)&&!si(s)){let c=r.intersectsTriangle(s,qh,!0);if(!c){const h=r.plane,f=s.plane,g=h.normal,p=f.normal;g.dot(p)===1&&Math.abs(h.constant-f.constant)<Zy&&(c=!0)}if(c){let h=i.geometry.boundsTree.resolveTriangleIndex(a),f=t.geometry.boundsTree.resolveTriangleIndex(o);e.add(h,f),n.add(f,h),Do&&(Do.addEdge(qh),Do.addIntersectingTriangles(a,r,o,s))}}return!1}}),{aIntersections:e,bIntersections:n}}function tS(i,t,e,n,r,s,a=!1){const o=e.attributes,c=e.index,h=i*3,f=c.getX(h+0),g=c.getX(h+1),p=c.getX(h+2);for(const _ in s){const M=o[_],b=s[_];if(!(_ in o))throw new Error(`CSG Operations: Attribute ${_} not available on geometry.`);const x=M.itemSize;_==="position"?(Ne.a.fromBufferAttribute(M,f).applyMatrix4(n),Ne.b.fromBufferAttribute(M,g).applyMatrix4(n),Ne.c.fromBufferAttribute(M,p).applyMatrix4(n),vc(Ne.a,Ne.b,Ne.c,t,3,b,a)):_==="normal"?(Ne.a.fromBufferAttribute(M,f).applyNormalMatrix(r),Ne.b.fromBufferAttribute(M,g).applyNormalMatrix(r),Ne.c.fromBufferAttribute(M,p).applyNormalMatrix(r),a&&(Ne.a.multiplyScalar(-1),Ne.b.multiplyScalar(-1),Ne.c.multiplyScalar(-1)),vc(Ne.a,Ne.b,Ne.c,t,3,b,a,!0)):(kh.fromBufferAttribute(M,f),Wh.fromBufferAttribute(M,g),Xh.fromBufferAttribute(M,p),vc(kh,Wh,Xh,t,x,b,a))}}function eS(i,t,e,n,r,s,a,o=!1){yc(i,n,r,s,a,o),yc(o?e:t,n,r,s,a,o),yc(o?t:e,n,r,s,a,o)}function Jf(i,t,e=!1){switch(i){case Yf:if(t===Ni||t===Lo&&!e)return Ci;break;case $f:if(e){if(t===Ui)return os}else if(t===Ni||t===Io)return Ci;break;case Yy:if(e){if(t===Ni||t===Io)return Ci}else if(t===Ui)return os;break;case jy:if(t===Ui)return os;if(t===Ni)return Ci;break;case $y:if(t===Ui||t===Lo&&!e)return Ci;break;case jf:if(!e&&(t===Ni||t===Io))return Ci;break;case Kf:if(!e&&(t===Ui||t===Lo))return Ci;break;default:throw new Error(`Unrecognized CSG operation enum "${i}".`)}return Ol}function vc(i,t,e,n,r,s,a=!1,o=!1){const c=h=>{s.push(h.x),r>1&&s.push(h.y),r>2&&s.push(h.z),r>3&&s.push(h.w)};mc.set(0,0,0,0).addScaledVector(i,n.a.x).addScaledVector(t,n.a.y).addScaledVector(e,n.a.z),go.set(0,0,0,0).addScaledVector(i,n.b.x).addScaledVector(t,n.b.y).addScaledVector(e,n.b.z),mo.set(0,0,0,0).addScaledVector(i,n.c.x).addScaledVector(t,n.c.y).addScaledVector(e,n.c.z),o&&(mc.normalize(),go.normalize(),mo.normalize()),c(mc),a?(c(mo),c(go)):(c(go),c(mo))}function yc(i,t,e,n,r,s=!1){for(const a in r){const o=t[a],c=r[a];if(!(a in t))throw new Error(`CSG Operations: Attribute ${a} no available on geometry.`);const h=o.itemSize;a==="position"?(Gn.fromBufferAttribute(o,i).applyMatrix4(e),c.push(Gn.x,Gn.y,Gn.z)):a==="normal"?(Gn.fromBufferAttribute(o,i).applyNormalMatrix(n),s&&Gn.multiplyScalar(-1),c.push(Gn.x,Gn.y,Gn.z)):(c.push(o.getX(i)),h>1&&c.push(o.getY(i)),h>2&&c.push(o.getZ(i)),h>3&&c.push(o.getW(i)))}}class nS{constructor(t){this.triangle=new ve().copy(t),this.intersects={}}addTriangle(t,e){this.intersects[t]=new ve().copy(e)}getIntersectArray(){const t=[],{intersects:e}=this;for(const n in e)t.push(e[n]);return t}}class $h{constructor(){this.data={}}addTriangleIntersection(t,e,n,r){const{data:s}=this;s[t]||(s[t]=new nS(e)),s[t].addTriangle(n,r)}getTrianglesAsArray(t=null){const{data:e}=this,n=[];if(t!==null)t in e&&n.push(e[t].triangle);else for(const r in e)n.push(e[r].triangle);return n}getTriangleIndices(){return Object.keys(this.data).map(t=>parseInt(t))}getIntersectionIndices(t){const{data:e}=this;return e[t]?Object.keys(e[t].intersects).map(n=>parseInt(n)):[]}getIntersectionsAsArray(t=null,e=null){const{data:n}=this,r=new Set,s=[],a=o=>{if(n[o])if(e!==null)n[o].intersects[e]&&s.push(n[o].intersects[e]);else{const c=n[o].intersects;for(const h in c)r.has(h)||(r.add(h),s.push(c[h]))}};if(t!==null)a(t);else for(const o in n)a(o);return s}reset(){this.data={}}}class iS{constructor(){this.enabled=!1,this.triangleIntersectsA=new $h,this.triangleIntersectsB=new $h,this.intersectionEdges=[]}addIntersectingTriangles(t,e,n,r){const{triangleIntersectsA:s,triangleIntersectsB:a}=this;s.addTriangleIntersection(t,e,n,r),a.addTriangleIntersection(n,r,t,e)}addEdge(t){this.intersectionEdges.push(t.clone())}reset(){this.triangleIntersectsA.reset(),this.triangleIntersectsB.reset(),this.intersectionEdges=[]}init(){this.enabled&&(this.reset(),Yh(this))}complete(){this.enabled&&Yh(null)}}const ai=new $t,ko=new Gt,Pi=new ve,_o=new ve,ei=new ve,xo=new ve,xn=[],zi=[];function rS(i){for(const t of i)return t}function sS(i,t,e,n,r,s={}){const{useGroups:a=!0}=s,{aIntersections:o,bIntersections:c}=Qy(i,t),h=[];let f=null,g;return g=a?0:-1,jh(i,t,o,e,!1,n,r,g),Kh(i,t,o,e,!1,r,g),e.findIndex(_=>_!==Kf&&_!==jf)!==-1&&(g=a?i.geometry.groups.length||1:-1,jh(t,i,c,e,!0,n,r,g),Kh(t,i,c,e,!0,r,g)),xn.length=0,zi.length=0,{groups:h,materials:f}}function jh(i,t,e,n,r,s,a,o=0){const c=i.matrixWorld.determinant()<0;ai.copy(t.matrixWorld).invert().multiply(i.matrixWorld),ko.getNormalMatrix(i.matrixWorld).multiplyScalar(c?-1:1);const h=i.geometry.groupIndices,f=i.geometry.index,g=i.geometry.attributes.position,p=t.geometry.boundsTree,_=t.geometry.index,M=t.geometry.attributes.position,b=e.ids,x=e.intersectionSet;for(let m=0,d=b.length;m<d;m++){const u=b[m],v=o===-1?0:h[u]+o,l=3*u,R=f.getX(l+0),T=f.getX(l+1),E=f.getX(l+2);Pi.a.fromBufferAttribute(g,R).applyMatrix4(ai),Pi.b.fromBufferAttribute(g,T).applyMatrix4(ai),Pi.c.fromBufferAttribute(g,E).applyMatrix4(ai),s.reset(),s.initialize(Pi);const y=x[u];for(let A=0,w=y.length;A<w;A++){const I=3*y[A],N=_.getX(I+0),B=_.getX(I+1),F=_.getX(I+2);_o.a.fromBufferAttribute(M,N),_o.b.fromBufferAttribute(M,B),_o.c.fromBufferAttribute(M,F),s.splitByTriangle(_o)}const S=s.triangles;for(let A=0,w=S.length;A<w;A++){const I=S[A],N=s.coplanarTriangleUsed?Jy(I,p):Zf(I,p);xn.length=0,zi.length=0;for(let B=0,F=n.length;B<F;B++){const k=Jf(n[B],N,r);k!==Ol&&(zi.push(k),xn.push(a[B].getGroupAttrSet(v)))}if(xn.length!==0){Pi.getBarycoord(I.a,xo.a),Pi.getBarycoord(I.b,xo.b),Pi.getBarycoord(I.c,xo.c);for(let B=0,F=xn.length;B<F;B++){const k=xn[B],J=zi[B]===os;tS(u,xo,i.geometry,i.matrixWorld,ko,k,c!==J)}}}}return b.length}function Kh(i,t,e,n,r,s,a=0){const o=i.matrixWorld.determinant()<0;ai.copy(t.matrixWorld).invert().multiply(i.matrixWorld),ko.getNormalMatrix(i.matrixWorld).multiplyScalar(o?-1:1);const c=t.geometry.boundsTree,h=i.geometry.groupIndices,f=i.geometry.index,g=i.geometry.attributes,p=g.position,_=[],M=i.geometry.halfEdges,b=new Set,x=Bl(i.geometry);for(let m=0,d=x;m<d;m++)m in e.intersectionSet||b.add(m);for(;b.size>0;){const m=rS(b);b.delete(m),_.push(m);const d=3*m,u=f.getX(d+0),v=f.getX(d+1),l=f.getX(d+2);ei.a.fromBufferAttribute(p,u).applyMatrix4(ai),ei.b.fromBufferAttribute(p,v).applyMatrix4(ai),ei.c.fromBufferAttribute(p,l).applyMatrix4(ai);const R=Zf(ei,c);zi.length=0,xn.length=0;for(let T=0,E=n.length;T<E;T++){const y=Jf(n[T],R,r);y!==Ol&&(zi.push(y),xn.push(s[T]))}for(;_.length>0;){const T=_.pop();for(let E=0;E<3;E++){const y=M.getSiblingTriangleIndex(T,E);y!==-1&&b.has(y)&&(_.push(y),b.delete(y))}if(xn.length!==0){const E=3*T,y=f.getX(E+0),S=f.getX(E+1),A=f.getX(E+2),w=a===-1?0:h[T]+a;if(ei.a.fromBufferAttribute(p,y),ei.b.fromBufferAttribute(p,S),ei.c.fromBufferAttribute(p,A),!si(ei))for(let I=0,N=xn.length;I<N;I++){const B=zi[I],F=xn[I].getGroupAttrSet(w),k=B===os;eS(y,S,A,g,i.matrixWorld,ko,F,k!==o)}}}}}function oS(i){for(let t=0;t<i.length-1;t++){const e=i[t],n=i[t+1];if(e.materialIndex===n.materialIndex){const r=e.start,s=n.start+n.count;n.start=r,n.count=s-r,i.splice(t,1),t--}}}function aS(i,t,e,n){e.clear();const r=i.attributes;for(let s=0,a=n.length;s<a;s++){const o=n[s],c=r[o];e.initializeArray(o,c.array.constructor,c.itemSize,c.normalized)}for(const s in e.attributes)n.includes(s)||e.delete(s);for(const s in t.attributes)n.includes(s)||(t.deleteAttribute(s),t.dispose())}function cS(i,t,e){let n=!1,r=-1;const s=i.attributes,a=t.groupAttributes[0];for(const c in a){const h=t.getTotalLength(c),f=t.getType(c),g=t.getItemSize(c),p=t.getNormalized(c);let _=s[c];(!_||_.array.length<h)&&(_=new de(new f(h),g,p),i.setAttribute(c,_),n=!0);let M=0;for(let b=0,x=Math.min(e.length,t.groupCount);b<x;b++){const m=e[b].index,{array:d,type:u,length:v}=t.groupAttributes[m][c],l=new u(d.buffer,0,v);_.array.set(l,M),M+=l.length}_.needsUpdate=!0,r=h/_.itemSize}if(i.index){const c=i.index.array;if(c.length<r)i.index=null,n=!0;else for(let h=0,f=c.length;h<f;h++)c[h]=h}let o=0;i.clearGroups();for(let c=0,h=Math.min(e.length,t.groupCount);c<h;c++){const{index:f,materialIndex:g}=e[c],p=t.getCount(f);p!==0&&(i.addGroup(o,p,g),o+=p)}i.setDrawRange(0,r),i.boundsTree=null,n&&i.dispose()}function Zh(i,t){let e=t;return Array.isArray(t)||(e=[],i.forEach(n=>{e[n.materialIndex]=t})),e}class Qf{constructor(){this.triangleSplitter=new Wy,this.attributeData=[],this.attributes=["position","uv","normal"],this.useGroups=!0,this.consolidateGroups=!0,this.debug=new iS}getGroupRanges(t){return!this.useGroups||t.groups.length===0?[{start:0,count:1/0,materialIndex:0}]:t.groups.map(e=>({...e}))}evaluate(t,e,n,r=new ps){let s=!0;if(Array.isArray(n)||(n=[n]),Array.isArray(r)||(r=[r],s=!1),r.length!==n.length)throw new Error("Evaluator: operations and target array passed as different sizes.");t.prepareGeometry(),e.prepareGeometry();const{triangleSplitter:a,attributeData:o,attributes:c,useGroups:h,consolidateGroups:f,debug:g}=this;for(;o.length<r.length;)o.push(new qy);r.forEach((m,d)=>{aS(t.geometry,m.geometry,o[d],c)}),g.init(),sS(t,e,n,a,o,{useGroups:h}),g.complete();const p=this.getGroupRanges(t.geometry),_=Zh(p,t.material),M=this.getGroupRanges(e.geometry),b=Zh(M,e.material);M.forEach(m=>m.materialIndex+=_.length);let x=[...p,...M].map((m,d)=>({...m,index:d}));if(h){const m=[..._,...b];f&&(x=x.map(u=>{const v=m[u.materialIndex];return u.materialIndex=m.indexOf(v),u}).sort((u,v)=>u.materialIndex-v.materialIndex));const d=[];for(let u=0,v=m.length;u<v;u++){let l=!1;for(let R=0,T=x.length;R<T;R++){const E=x[R];E.materialIndex===u&&(l=!0,E.materialIndex=d.length)}l&&d.push(m[u])}r.forEach(u=>{u.material=d})}else x=[{start:0,count:1/0,index:0,materialIndex:0}],r.forEach(m=>{m.material=_[0]});return r.forEach((m,d)=>{const u=m.geometry;cS(u,o[d],x),f&&oS(u.groups)}),s?r:r[0]}evaluateHierarchy(t,e=new ps){t.updateMatrixWorld(!0);const n=(s,a)=>{const o=s.children;for(let c=0,h=o.length;c<h;c++){const f=o[c];f.isOperationGroup?n(f,a):a(f)}},r=s=>{const a=s.children;let o=!1;for(let h=0,f=a.length;h<f;h++){const g=a[h];o=r(g)||o}const c=s.isDirty();if(c&&s.markUpdated(),o&&!s.isOperationGroup){let h;return n(s,f=>{h?h=this.evaluate(h,f,f.operation):h=this.evaluate(s,f,f.operation)}),s._cachedGeometry=h.geometry,s._cachedMaterials=h.material,!0}else return o||c};return r(t),e.geometry=t._cachedGeometry,e.material=t._cachedMaterials,e}reset(){this.triangleSplitter.reset()}}let Xe,qe;const lS=new U(0,0,-1),uS=new U(1,0,0),hS=new U(0,1,0);let Te,zl,Zo=!1,fi=!1,gs=!1,Ml=!1,Sc=[],ge=[],Pn,Jr,as,Mc;const Vl=3368703,fS=16711680,td=12041720,dS=16711680,Yn=new qp,ci=new kt;let Oe=[],ue=new gr,se=new gr,pr=[],Xt=[];const _e=new Set,ed=.5;let vo=0;pS();requestAnimationFrame(id);function pS(){gS(),Xe=new Ap,qe=new sn(75,window.innerWidth/window.innerHeight,.1,1e3),qe.position.set(0,0,10),Te=new Cv({antialias:!0}),Te.setSize(window.innerWidth,window.innerHeight),document.body.appendChild(Te.domElement),Te.domElement.id="canvas",zl=document.getElementById("canvas"),Te.domElement.addEventListener("mousedown",_S),Te.domElement.addEventListener("mousemove",Uo),Te.domElement.addEventListener("mouseup",MS),Te.domElement.addEventListener("mouseleave",ES),Te.domElement.addEventListener("dblclick",FS),window.addEventListener("resize",AS),window.addEventListener("wheel",NS),document.addEventListener("keydown",RS),document.addEventListener("keyup",wS),document.addEventListener("pointerlockchange",SS);let i=new Wp("#0c0c0c");Xe.add(i);let t=new kp(16777215,3);t.position.set(1,1,3),Xe.add(t);const e=mS(),n=new Ef({map:e,side:Be});Mc=new Ms(100,100),Jr=new Ie(Mc,n),Mc.computeBoundsTree(),Jr.rotation.x=-Math.PI/2,Jr.receiveShadow=!0,Jr.position.set(0,-5,0),ue.add(Jr),ue.updateWorldMatrix(),se.add(ue),se.position.set(0,0,10),se.updateWorldMatrix(),Xe.add(se)}function gS(){De.prototype.computeBoundsTree=xy,De.prototype.disposeBoundsTree=vy,Ie.prototype.raycast=Ih,bo.prototype.computeBoundsTree=yy,bo.prototype.disposeBoundsTree=Sy,bo.prototype.raycast=Ih,Yn.firstHitOnly=!0}function mS(i=512,t=8){const e=document.createElement("canvas");e.width=e.height=i;const n=e.getContext("2d"),r=i/t;for(let a=0;a<t;a++)for(let o=0;o<t;o++)n.fillStyle=(o+a)%2===0?"#ffffff":"#000000",n.fillRect(o*r,a*r,r,r);const s=new Op(e);return s.wrapS=s.wrapT=No,s.repeat.set(10,10),s}function nd(i){const t=Te.domElement.getBoundingClientRect();ci.x=gs?0:(i.clientX-t.left)/t.width*2-1,ci.y=gs?0:-((i.clientY-t.top)/t.height)*2+1;const e=new U(ci.x,ci.y,.5);e.unproject(qe);const n=e.sub(qe.position).normalize(),r=-qe.position.z/n.z;return qe.position.clone().add(n.multiplyScalar(r))}function _S(i){Zo=!0,Xe.remove(Pn),as=new De;const t=new Sf({color:td});Pn=new Bp(as,t),Xe.add(Pn),ge=[],TS();const e=nd(i);ge.push(new U(e.x,e.y,0)),Hl()}function Uo(i){const t=nd(i);if(document.getElementById("mousePos").innerHTML=`(${t.x.toFixed(2)}, ${t.y.toFixed(2)})`,!fi&&Zo&&(fi=!0),!fi){if(_e.has("control")){let s=i.movementX,a=i.movementY;se.rotation.x+a/100>=1.4&&(a=(1.4-se.rotation.x)*100),se.rotation.x+a/100<=-1.4&&(a=(-1.4-se.rotation.x)*100),se.rotation.x+=a/100,se.rotation.y+=s/100}return}const e=new U(t.x,t.y,0);Yn.setFromCamera(ci,qe);const n=Yn.intersectObjects(Xe.children).filter(s=>Oe.includes(s.object));n.length>0&&n[0].object==Xt[Xt.length-1]&&(Ml=!0);const r=ge.length;if(r>=1){const s=ge[r-1],a=e;if(a.distanceTo(s)<ed)return;for(let o=0;o<r-2;o++){const c=ge[o],h=ge[o+1];if(bS(s,a,c,h)){vn(),Wo(),cs();return}}}ge.push(e),Hl()}function xS(){return!(ge.length<=3||ge[ge.length-1].distanceTo(ge[0])>3*ed)}function vS(i){let t=new kt(0,0);for(let e of i)t.x+=e.x,t.y+=e.y;t.x/=i.length,t.y/=i.length;for(let e of i)e.x-=t.x,e.y-=t.y;return[t,i]}function yS(i){let t=null;[t,i]=vS(i);const e=qv(i);var n=Pv(e,i);n=Uv(n);var r,s;[r,s]=Yv(n);let a,o;[a,o]=t0(s,r);const c=new De;c.setAttribute("position",new de(new Float32Array(a),3)),c.setIndex(new de(new Uint32Array(o),1)),c.computeVertexNormals();const h=new Tf({color:Vl,transmission:.6,opacity:.6,transparent:!0,roughness:.1,metalness:0,ior:2,thickness:.5,side:Be}),f=new ps(c,h);f.position.set(t.x,t.y,0),c.computeBoundsTree(),f.updateWorldMatrix(),Oe.push(f),ue.attach(f),ue.updateWorldMatrix(),se.updateWorldMatrix(),Xe.remove(Pn)}function SS(){vn(),document.pointerLockElement===zl?(gs=!0,document.getElementById("mousePos").innerHTML="View Mode",document.getElementById("crosshair").style.display="block",Te.domElement.removeEventListener("mousemove",Uo),Te.domElement.removeEventListener("mousemove",Ec),Te.domElement.addEventListener("mousemove",Ec)):(gs=!1,document.getElementById("crosshair").style.display="none",Te.domElement.removeEventListener("mousemove",Ec),Te.domElement.removeEventListener("mousemove",Uo),Te.domElement.addEventListener("mousemove",Uo))}function Ec(i){let t=i.movementX,e=i.movementY;se.rotation.x+e/100>=1.4&&(e=(1.4-se.rotation.x)*100),se.rotation.x+e/100<=-1.4&&(e=(-1.4-se.rotation.x)*100),se.rotation.x+=e/100,se.rotation.y+=t/100}function MS(){if(Zo=!1,!!fi){if(Ml){cs(),Ml=!1,Yn.setFromCamera(ci,qe);const i=Yn.intersectObjects(Xe.children);for(let t=0;t<i.length;t++)if(i[t].object==Xt[Xt.length-1]){vn(),Wo();return}Sc=[];for(let t of ge)Sc.push(new kt(t.x,t.y));Xt.length>=1&&IS(Xt[Xt.length-1],Sc),Xe.remove(Pn),vn();return}if(vn(),!xS()){Wo(),cs();return}ge.push(new U(ge[0].x,ge[0].y,0)),Hl(),cs(),yS(ge)}}function ES(){fi&&(vn(),Wo(),cs())}function Wo(){Pn.material.color=new qt(dS),Pn.material.needsUpdate=!0}function TS(){Pn.material.color=new qt(td),Pn.material.needsUpdate=!0}function cs(){Zo=!1,fi=!1}function Hl(){const i=[];for(let t=0;t<ge.length-1;t++)i.push(ge[t].x,ge[t].y,0),i.push(ge[t+1].x,ge[t+1].y,0);as.setAttribute("position",new Cn(i,3)),as.setDrawRange(0,i.length),as.attributes.position.needsUpdate=!0}function bS(i,t,e,n){function r(h,f,g){return(f.x-h.x)*(g.y-h.y)-(f.y-h.y)*(g.x-h.x)}const s=r(i,t,e),a=r(i,t,n),o=r(e,n,i),c=r(e,n,t);return s*a<0&&o*c<0}function AS(){qe.aspect=window.innerWidth/window.innerHeight,qe.updateProjectionMatrix(),Te.setSize(window.innerWidth,window.innerHeight)}function wS(i){_e.delete(i.key.toLowerCase())}function RS(i){if(_e.add(i.key.toLowerCase()),!fi)switch(Xe.remove(Pn),i.key.toLowerCase()){case"w":case"s":case"a":case"d":case"q":case"e":case"space":case"shift":_e.has("control")&&i.preventDefault();break;case"c":if(Xt.length>0){vn();break}_e.has("control")?(i.preventDefault(),DS()):US();break;case"enter":vn();break;case"u":let t=Xt.length;t>=2&&LS(Xt[t-1],Xt[t-2]),vn();break;case"o":vn(),_e.has("control")?(i.preventDefault(),se.rotation.set(0,0,0,"XYZ")):ue.position.set(0,0,0);break;case"f":gs?document.exitPointerLock():(vn(),zl.requestPointerLock());break;case"i":Ff();break}}function ur(i,t){const e=t.normalize();return i.clone().sub(e.clone().multiplyScalar(i.dot(e)))}function CS(i,t){let s=[],a=[];const o=i.length;for(let p=0;p<o;p++){let _=new U(i[p].x,i[p].y,0);const M=_.clone().sub(qe.position).normalize();let b=_.clone().sub(M.clone().multiplyScalar(10)),x=_.clone().add(M.clone().multiplyScalar(50));s.push(b.x,b.y,b.z),s.push(x.x,x.y,x.z);let m=null,d=null,u=null;p>0&&(m=i[p].clone().sub(i[p-1]),m.set(m.y,-m.x).normalize()),p<o-1&&(d=i[p+1].clone().sub(i[p]),d.set(d.y,-d.x).normalize()),m!=null&&d!=null?u=m.clone().add(d).normalize():m!=null?u=m.clone():u=d.clone(),u.multiplyScalar(.01);const v=_.clone().add(new U(u.x,u.y,0));b=v.clone().sub(M.clone().multiplyScalar(10)),x=v.clone().add(M.clone().multiplyScalar(50)),s.push(x.x,x.y,x.z),s.push(b.x,b.y,b.z)}for(let p=0;p<s.length-4;p+=4)a.push(p,p+4,p+1),a.push(p+4,p+5,p+1),a.push(p+3,p+2,p+7),a.push(p+2,p+6,p+7),a.push(p,p+3,p+4),a.push(p+3,p+7,p+4),a.push(p+1,p+5,p+2),a.push(p+5,p+6,p+2);a.push(0,1,3),a.push(1,2,3);const c=s.length-4;a.push(c+0,c+3,c+1),a.push(c+3,c+2,c+1);const h=new De;h.setAttribute("position",new de(new Float32Array(s),3)),h.setIndex(new de(new Uint32Array(a),1)),h.computeVertexNormals();const f=new Tf({color:16777215,opacity:0,transparent:!0,side:Be}),g=new ps(h,f);return h.computeBoundsTree(),g.updateWorldMatrix(),g}function PS(i,t,e){const n=i.length/3;let r=new Int32Array(n).fill(-1);function s(_){_>=n&&console.log("error:",_,n);let M=[];for(;r[_]>=0;)M.push(_),_=r[_];for(let b of M)r[b]=_;return _}function a(_,M){let b=s(_),x=s(M);if(b==x)return;let m=r[b]+r[x];r[b]<r[x]?(r[x]=b,r[b]=m):(r[b]=x,r[x]=m)}function o(){let _=[],M=[],b=[];for(let x=0;x<n;x++){let m=s(x);_.indexOf(m)===-1&&(_.push(m),M.push(new U(0,0,0)),b.push(0)),M[_.indexOf(m)].add(new U(i[x*3],i[x*3+1],i[x*3+2])),b[_.indexOf(m)]++}for(let x=0;x<_.length;x++)M[x].multiplyScalar(1/b[x]);for(let x=0;x<n;x++){let m=_.indexOf(s(x));i[x*3]-=M[m].x,i[x*3+1]-=M[m].y,i[x*3+2]-=M[m].z}return[_,M]}const c=t.length;for(let _=0;_<c;_+=3)a(t[_],t[_+1]),a(t[_+1],t[_+2]),a(t[_+2],t[_]);let[h,f]=o(),g=[];for(let _=0;_<h.length;_++)g.push([new Float32Array(i),[]]);for(let _=0;_<c;_+=3){let M=h.indexOf(s(t[_]));for(let b=0;b<3;b++){let x=h.indexOf(s(t[_+b]));(x!=M||x==-1)&&console.log("bad:",M,x),g[x][1].push(t[_+b])}}let p=[];for(let _=0;_<h.length;_++){let M=new De;M.setAttribute("position",new de(g[_][0],3)),M.setIndex(new de(new Uint32Array(g[_][1]),1)),M=kf(M),M.computeVertexNormals();const b=new ps(M,e.clone());M.computeBoundsTree(),b.position.copy(f[_]),b.updateWorldMatrix(),p.push(b)}return p}function IS(i,t){let e=CS(t,i.position.z);ue.remove(i),Oe.splice(Oe.indexOf(i),1),Xt.splice(Xt.indexOf(i),1);const n=new Qf;n.attributes=["position"];let r=i.material,s=n.evaluate(i,e,$f),a=s.geometry,o=kf(a);s.material=r;let c=PS(o.attributes.position.array,o.getIndex().array,r);for(let h of c)ue.attach(h),Oe.push(h),Xt.push(h)}function LS(i,t){const e=se.rotation.clone(),n=ue.position.clone();se.rotation.set(0,0,0,"XYZ"),ue.position.set(0,0,0),ue.remove(i),ue.remove(t),Oe.splice(Oe.indexOf(i),1),Oe.splice(Oe.indexOf(t),1),Xt.splice(Xt.indexOf(i),1),Xt.splice(Xt.indexOf(t),1);let r=new U().addVectors(i.position.clone(),t.position.clone()).multiplyScalar(.5);i.position.sub(r),t.position.sub(r),i.updateWorldMatrix(),t.updateWorldMatrix();let s=new Qf;s.attributes=["position","normal"];let a=i.material,o=s.evaluate(i,t,Yf);o.material=a.clone(),o.position.copy(r),o.geometry.computeBoundsTree(),o.updateWorldMatrix(),ue.add(o),ue.updateWorldMatrix(),se.updateWorldMatrix(),Oe.push(o),Xt.push(o),se.rotation.copy(e),ue.position.copy(n)}function DS(){if(pr.length==0)return;let i=pr[pr.length-1];Oe.push(i),ue.add(i),pr.splice(pr.length-1,1)}function US(){Yn.setFromCamera(ci,qe);const i=Yn.intersectObjects(Xe.children);let t=0;for(;i.length>t&&Oe.includes(i[t].object);){if(!i[t].object.visible){t++;continue}let e=i[t].object;pr.push(e),Oe.splice(Oe.indexOf(e),1),ue.remove(e);break}}function NS(i){if(Xt.length>0)for(let t of Xt)t.scale.multiplyScalar(Math.tanh(i.deltaY/1e3)+1)}function FS(){if(fi)return;Yn.setFromCamera(ci,qe);const i=Yn.intersectObjects(Xe.children);let t=0;for(;i.length>t&&Oe.includes(i[t].object);){if(!i[t].object.visible){t++;continue}let e=i[t].object;Xt.includes(e)?(Xt.splice(Xt.indexOf(e),1),e.material.color.set(Vl)):BS(e);break}}function BS(i){Xt.push(i),i.material.color.set(fS)}function vn(){if(Xt.length!=0){for(let i of Xt)i.material.color.set(Vl);Xt=[]}}const hr=20,fr=5;function id(i){vo||(vo=i);const t=(i-vo)/1e3;vo=i;let e=se.worldToLocal(new U(0,0,0)),n=se.worldToLocal(lS.clone()).sub(e).normalize(),r=se.worldToLocal(uS.clone()).sub(e).normalize(),s=se.worldToLocal(hS.clone()).sub(e).normalize(),a=new U(0,1,0),o;if(_e.has("w"))if(o=ur(n,a).normalize(),Xt.length>0)for(let c of Xt)_e.has("r")?c.rotation.x-=fr*t:c.position.addScaledVector(o,hr*t);else ue.position.addScaledVector(o,-20*t);else if(_e.has("s"))if(o=ur(n,a).normalize(),Xt.length>0)for(let c of Xt)_e.has("r")?c.rotation.x+=fr*t:c.position.addScaledVector(o,-20*t);else ue.position.addScaledVector(o,hr*t);if(_e.has("a"))if(o=ur(r,a).normalize(),Xt.length>0)for(let c of Xt)_e.has("r")?c.rotation.y-=fr*t:c.position.addScaledVector(o,-20*t);else ue.position.addScaledVector(o,hr*t);else if(_e.has("d"))if(o=ur(r,a).normalize(),Xt.length>0)for(let c of Xt)_e.has("r")?c.rotation.y+=fr*t:c.position.addScaledVector(o,hr*t);else ue.position.addScaledVector(o,-20*t);if(_e.has("q")||_e.has(" "))if(o=s.clone().sub(ur(s,a)).normalize(),Xt.length>0)for(let c of Xt)_e.has("r")?c.rotation.z+=fr*t:c.position.addScaledVector(o,hr*t);else ue.position.addScaledVector(o,-20*t);else if(_e.has("e")||_e.has("shift"))if(o=s.clone().sub(ur(s,a)).normalize(),Xt.length>0)for(let c of Xt)_e.has("r")?c.rotation.z-=fr*t:c.position.addScaledVector(o,-20*t);else ue.position.addScaledVector(o,hr*t);Te.render(Xe,qe),requestAnimationFrame(id)}
