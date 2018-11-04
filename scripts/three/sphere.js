import {
	setColorThree
} from './color.js';

var paramsDefaultSphere = {
	color: setColorThree(170, 0, 170)
}


function createSphere(geometry = {
	radius: 30,
	width: 20,
	height: 20
}, color = paramsDefaultSphere.color) {
	var sphereGeometry = new THREE.SphereGeometry(geometry.radius, geometry.width, geometry.height);
	var sphereMaterial = new THREE.MeshBasicMaterial({
		color: color,
		wireframe: true
	});
	sphereGeometry.translate(40, -20, -10.5);
	var sphere = new THREE.Mesh(sphereGeometry, sphereMaterial);

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
	x: 100,
	y: 10,
	z: 10
}) {
	sphere.position.x = pos.x;
	sphere.position.y = pos.y;
	sphere.position.z = pos.z;
}

export {
	createSphere, rotateSphere
};