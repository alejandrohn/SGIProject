import {
	setColorThree
} from './color.js';

function createCube(geometryBox = {
	width: 23,
	height: 23,
	depth: 23
}, color = setColorThree(15, 50, 40)) {
	var cubeGeometry = new THREE.BoxGeometry(geometryBox.width, geometryBox.height, geometryBox.depth);
	var cubeMaterial = new THREE.MeshBasicMaterial({
		color: color
	});
	cubeGeometry.translate(0, 20, 10.5);
	var cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cubePosition(cube);
	cube.scale.set( 1,1,1 );
	return cube;
}


var SPEED = 0.01;

function rotateCube(cube) {
	cube.rotation.x -= SPEED * 2;
	cube.rotation.y -= SPEED;
	cube.rotation.z -= SPEED * 4;
}

function cubePosition(cube, pos = {
	x: -100,
	y: 10,
	z: 10
}) {
	cube.position.x = pos.x;
	cube.position.y = pos.y;
	cube.position.z = pos.z;
}

export {
	createCube,
	rotateCube,
	cubePosition
};