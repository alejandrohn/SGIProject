import {
	setColorThree
} from './color.js';

var colorDefault = setColorThree(100, 0, 0);

function pyramidCreate(tetradonGeometry = {
	radius: 38,
	detail: 0
}, color = colorDefault) {

	var pyramidGeometry = new THREE.TetrahedronBufferGeometry(tetradonGeometry.radius, tetradonGeometry.detail);



	var pyramid = new THREE.Mesh(pyramidGeometry,
		new THREE.MeshBasicMaterial({
			color: color,
			wireframe: true
		}));
	pyramid.castShadow = true;

	pyramidPosition(pyramid);
	return pyramid;
}

var SPEED = 0.01;

function rotatePyramid(pyramid) {
	pyramid.rotation.x -= SPEED * 2;
	pyramid.rotation.y -= SPEED;
	pyramid.rotation.z -= SPEED * 1;
}

function pyramidPosition(pyramid, pos = {
	x: 80,
	y: 120,
	z: -40
}) {
	pyramid.position.x = pos.x;
	pyramid.position.y = pos.y;
	pyramid.position.z = pos.z;
}

export {
	pyramidCreate,
	rotatePyramid
};