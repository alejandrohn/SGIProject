var cameraPerspective  = new THREE.PerspectiveCamera( 100, window.innerWidth / window.innerHeight, 1, 1000 );


var cameraAxonometrica = new THREE.OrthographicCamera(window.innerWidth / -2,
	window.innerWidth / 2,
	window.innerHeight / 2,
	window.innerHeight / -2,
	0.1, 1000);

function setCamera(cameraName) {
	if (cameraName == 'axo') {
		return cameraAxonometrica;
	}
	if (cameraName == 'persp') {
		return cameraPerspective;
	}
}

export {
	cameraPerspective,
	cameraAxonometrica,
	setCamera
};