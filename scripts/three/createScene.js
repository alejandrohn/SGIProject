import {
	cameraAxonometrica,
	cameraPerspective,
	setCamera
} from './typeOfCamera.js';


var lookAtCoord = {
	x: 10,
	y: 0,
	z: 10
};

var posCamera = {
	x: 5,
	y: 10,
	z: 100
};

var camera, scene, renderer;

function initScene() {
	scene = new THREE.Scene();
	return scene;

}

function initCamera(typeOfCamara = 'persp',positionCamera = posCamera, lookAt = lookAtCoord) {

	camera = setCamera(typeOfCamara);
	camera.position.set(positionCamera.x, positionCamera.y, positionCamera.z);
	camera.lookAt(lookAt.x, lookAt.y, lookAt.z);
	camera.zoom = 4;
	camera.updateProjectionMatrix();
	return camera;

}

function initRender() {
	var container = document.getElementById('canvasSection');
	var canvas = document.getElementById('glCanvas');
	var context = canvas.getContext('webgl2');


	renderer = new THREE.WebGLRenderer({
		canvas: canvas,
		context: context
	});
	renderer.setSize($(container).width(), 565);
	document.body.appendChild(renderer.domElement);
	return renderer;
}


export {
	initScene, initCamera, initRender
};