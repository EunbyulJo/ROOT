/**
 * 
 */

	function openRequest() {
		if(window.ActiveXObject) {
			try{
				return new ActiveXObject("Msxl2.XMLHTTP");
			}catch(e) {
				return new ActiveXObject("Microsoft.XMLHTTP");
			}
		}else {
			return new XMLHttpRequest();
		}
	}