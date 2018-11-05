import {
	setColorThree
} from './color.js';

var paramsDefaultSphere = {
	color: setColorThree(100, 0, 170)
}


function createSphere(color = paramsDefaultSphere.color, geometry = {
	radius: 30,
	width: 10,
	height: 10
}) {
	var sphereGeometry = new THREE.SphereGeometry(geometry.radius, geometry.width, geometry.height);


	for (var i = 0; i < sphereGeometry.faces.length; i++) {
		sphereGeometry.faces[i].color.setHex(Math.random() * 0xffffff);
	}


	var sphereMaterial = new THREE.MeshBasicMaterial({
		color: 0xffffff,
		vertexColors: THREE.FaceColors,
		wireframe: true
	});
	//sphereGeometry.translate(40, -20, -10.5);
	var sphere = new THREE.Mesh(sphereGeometry, sphereMaterial);
	sphere.castShadow = true;
	sphere.receiveShadow = false;
	spherePosition(sphere);
	return sphere;
}

var SPEED = 0.01;

function rotateSphere(sphere) {
	sphere.rotation.x -= SPEED * 4;
	sphere.rotation.y -= SPEED;
	sphere.rotation.z -= SPEED * 1;
}


function spherePosition(sphere, pos = {
	x: -80,
	y: 20,
	z: 10
}) {
	sphere.position.x = pos.x;
	sphere.position.y = pos.y;
	sphere.position.z = pos.z;
}

export {
	createSphere,
	rotateSphere,
	spherePosition
};