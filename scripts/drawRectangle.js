const canvasName = "glCanvas";


function rectangle() {
	var canvas = document.getElementById(canvasName);
	var gl = canvas.getContext('2d');

	gl.fillStyle = 'rgba(0,0,255,1.0)';
	gl.fillRect(120, 10, 150, 150);
	return;
}

//export { rectangle };