import {
	initCamera,
	initScene,
	initRender
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
	rotateSphere
} from './sphere.js';

import {
	pyramidCreate,
	rotatePyramid
} from './pyramid.js';

import {
	scaleFigureInScene
} from './scaleFigure.js';
var camera, scene, renderer;
var cube, sphere, pyramid;

function drawObject3D() {

	scene = initScene();
	camera = initCamera();
	renderer = initRender();
	initFigure();
	changeTypeOfCamera();


	scaleFigureInScene('spherebutton', 'sphere', sphere);
	scaleFigureInScene('cubebutton', 'cube', cube);
	scaleFigureInScene('pyramidbutton', 'pyramid', pyramid);

	animate();
}


function animate() {
	requestAnimationFrame(animate);
	rotateCube(cube);
	rotateSphere(sphere);
	rotatePyramid(pyramid);



	renderer.render(scene, camera);

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


export {
	drawObject3D
};