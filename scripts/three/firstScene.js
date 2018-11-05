import {
	initCamera,
	initScene,
	initRender,
	initStats,
	initLight
} from './createScene.js';
import {
	setColorThree
} from './color.js';

import {
	createCube,
	rotateCube,
	cubePosition

} from './cube.js';

import {
	createSphere,
	rotateSphere,
	spherePosition
} from './sphere.js';

import {
	pyramidCreate,
	rotatePyramid
} from './pyramid.js';

import {
	scaleFigureInScene
} from './scaleFigure.js';

import {
	translateFigureInScene
} from './translateFigure.js';

import {
	dragFigure
} from './dragFigure.js';

import {
	initControl
} from './controls.js';

import {
	getColorRandom,
	getGeometry,
	getPosition
} from './helpFunctionality.js';
import {
	planeAndLight
} from './plane.js';

var stats;
var camera, scene, renderer, controls, light;
var cube, sphere, pyramid;
var figures = [];

function drawObject3D() {


	scene = initScene();
	camera = initCamera();
	renderer = initRender();


	initFigure();
	figures.push(cube);
	figures.push(sphere);
	figures.push(pyramid);
	scene.add(new THREE.AxisHelper(200));
	var meshAndLight = planeAndLight();
	scene.add(meshAndLight.mesh);
	scene.add(meshAndLight.light);


	scene.add(camera);



	controls = initControl(camera, renderer);

	var texture = THREE.ImageUtils.loadTexture('./../../img/images.png', {}, function () {
		renderer.render(scene);
	});

	//initFigure();
	changeTypeOfCamera();


	scaleFigureInScene('spherebutton', 'sphere', sphere);
	scaleFigureInScene('cubebutton', 'cube', cube);
	scaleFigureInScene('pyramidbutton', 'pyramid', pyramid);

	translateFigureInScene('sphereTranslbutton', 'sphereTransl', sphere);
	translateFigureInScene('cubeTranslbutton', 'cubeTransl', cube);
	translateFigureInScene('pyramidTranslbutton', 'pyramidTransl', pyramid);

	dragFigure(figures, camera, renderer, controls);

	window.addEventListener('resize', onWindowResize, false);

	$('#elementCube').click(function () {
		addCube();
	});
	animate();
}


function onWindowResize() {

	camera.aspect = window.innerWidth / window.innerHeight;
	camera.updateProjectionMatrix();
	renderer.setSize(window.innerWidth, window.innerHeight);
	render();

}

function render() {
	controls.update();
	renderer.render(scene, camera);
}



function animate() {
	requestAnimationFrame(animate);
	rotateCube(cube);
	rotateSphere(sphere);
	rotatePyramid(pyramid);
	render();
}



function initFigure() {
	cube = createCube();

	scene.add(cube);
	sphere = createSphere();
	scene.add(sphere);
	pyramid = pyramidCreate();
	pyramid.position.x = 10;
	scene.add(pyramid);
}

function changeTypeOfCamera() {
	$("input[name='camera']").click(function () {
		camera = initCamera(this.value);
	});
}

function addCube() {

	var figureRandom = Math.floor(Math.random() * 2);
	var textureRandom = Math.floor(Math.random() * 2);
	var textureVal = false;

	var color = getColorRandom();
	var geometry = getGeometry();
	var positionDyn = getPosition();

	var sphereDyn = createSphere(color, {
		radius: geometry[0],
		width: geometry[1],
		height: geometry[2]
	});
	spherePosition(sphereDyn, {
		x: positionDyn[0],
		y: positionDyn[1],
		z: positionDyn[2]
	});

	if (textureRandom == 0) {
		textureVal = true;
	} else {
		textureRandom = false;
	}
	var cubeDyn = createCube(textureVal, color, {
		depth: geometry[0],
		width: geometry[1],
		height: geometry[2]
	});

	cubePosition(cubeDyn, {
		x: positionDyn[0],
		y: positionDyn[1],
		z: positionDyn[2]
	})

	if (figureRandom == 0) {
		scene.add(sphereDyn);
	} else {
		scene.add(cubeDyn);
	}
}


export {
	drawObject3D
};