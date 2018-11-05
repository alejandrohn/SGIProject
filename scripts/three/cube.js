import {
	setColorThree
} from './color.js';

function createCube(hasTexture = true, color = setColorThree(20, 20, 200), geometryBox = {
	width: 23,
	height: 23,
	depth: 23
}) {
	var cubeGeometry = new THREE.BoxGeometry(geometryBox.width, geometryBox.height, geometryBox.depth);

	for (var i = 0; i < cubeGeometry.faces.length; i++) {
		cubeGeometry.faces[i].color.setHex(Math.random() * 0xffffff);
	}
	var cubeMaterial;
	if (hasTexture) {
		var textureLoader = new THREE.TextureLoader();
		var createTexture = textureLoader.load('../../img/images.png');
		var createdBumpMap = textureLoader.load('../../img/images.png');

		cubeMaterial = new THREE.MeshBasicMaterial({
			color: 0xffffff,
			vertexColors: THREE.FaceColors,
			map: createTexture,
			bumMap: createdBumpMap
		});
	} else {
		cubeMaterial = new THREE.MeshBasicMaterial({
			color: 0xffffff,
			vertexColors: THREE.FaceColors,
			map: createTexture,
			bumMap: createdBumpMap
		});
	}



	var cube = new THREE.Mesh(cubeGeometry, cubeMaterial);
	cube.castShadow = true;
	cube.receiveShadow = false;
	cubePosition(cube);
	return cube;
}

var SPEED = 0.01;


function setSpeedCube(value) {
	SPEED = value;
}

function rotateCube(cube) {
	cube.rotation.x -= SPEED * 2;
	cube.rotation.y -= SPEED;
	cube.rotation.z -= SPEED * 4;
}

function cubePosition(cube, pos = {
	x: 140,
	y: 40,
	z: 30
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