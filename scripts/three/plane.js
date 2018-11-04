import {
	setColorThree
} from './color.js';

function createPlane(planeGeometry = {
	width: 100,
	height: 45,
	widthSegments: 1,
	heightSegments: 1
}, color = setColorThree(40, 30, 40)) {

	var planeGeometryCurrent = new THREE.PlaneGeometry(
		planeGeometry.width,
		planeGeometry.height,
		planeGeometry.widthSegments,
		planeGeometry.heightSegments);
	var planeMaterial = new THREE.MeshBasicMaterial({
		color: color
	});
	var plane = new THREE.Mesh(planeGeometryCurrent, planeMaterial);
	return plane;
}

export {
	createPlane
};