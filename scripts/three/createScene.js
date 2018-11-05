import {
	cameraAxonometrica,
	cameraPerspective,
	setCamera
} from './typeOfCamera.js';


var lookAtCoord = {
	x: 140,
	y: 50,
	z: 150
};

var posCamera = {
	x: 150,
	y: 50,
	z: 150
};

var camera, scene, renderer, stats, light;

function initScene() {
	scene = new THREE.Scene();
	return scene;

}

function initCamera(typeOfCamara = 'persp', positionCamera = posCamera, lookAt = lookAtCoord) {

	camera = setCamera(typeOfCamara);
	camera.position.set(positionCamera.x, positionCamera.y, positionCamera.z);
	camera.lookAt(lookAt.x, lookAt.y, lookAt.z);
	// camera.zoom = 4;
	// camera.updateProjectionMatrix();
	return camera;

}

function initRender() {
	var container = document.getElementById('canvasSection');
	var canvas = document.getElementById('glCanvas');
	var context = canvas.getContext('webgl2');


	renderer = new THREE.WebGLRenderer({
		canvas: canvas,
		context: context,
		antialias: true
	});

	//renderer.physicallyCorrectLights = true;

	// renderer.toneMapping = THREE.ReinhardToneMapping;
	// renderer.setPixelRatio(window.devicePixelRatio);
	renderer.setSize($(container).width(), $(container).height());
	renderer.shadowMap.enabled = true;
	renderer.shadowMap.type = THREE.PCFSoftShadowMap;
	// renderer.gammaInput = true;
	// renderer.gammaOutput = true;

	document.body.appendChild(renderer.domElement);
	return renderer;
}

function initStats() {
	var container = document.getElementById('canvasSection');
	stats = new Stats();
	container.appendChild(stats.dom);
	return stats;
}

function initLight() {

}


export {
	initScene,
	initCamera,
	initRender,
	initStats,
	initLight
};