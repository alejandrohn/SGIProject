import {
	setColorThree
} from './color.js';

var colorDefault = setColorThree(100, 150, 190);

function pyramidCreate(tetradonGeometry = {
	radius: 38,
	detail: 0
}, color = colorDefault) {

	var pyramidGeometry = new THREE.TetrahedronBufferGeometry(tetradonGeometry.radius, tetradonGeometry.detail);
	pyramidGeometry.translate(20, 3, 5);
	var pyramid = new THREE.Mesh(pyramidGeometry,
		new THREE.MeshPhongMaterial({
			color: color,
			wireframe: true
		}));

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
	x: 100,
	y: 50,
	z: 10
}) {
	pyramid.position.x = pos.x;
	pyramid.position.y = pos.y;
	pyramid.position.z = pos.z;
}

export {
	pyramidCreate, rotatePyramid
};