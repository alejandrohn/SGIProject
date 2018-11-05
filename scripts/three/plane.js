import {
	setColorThree
} from './color.js';

function planeAndLight(planeGeometry = {
	width: 100,
	height: 45,
	widthSegments: 1,
	heightSegments: 1
}, color = setColorThree(40, 30, 40)) {

	var container = document.getElementById('canvasSection');
	var material = new THREE.MeshLambertMaterial({
		color: 0xaaffaa
	});
	var geometry = new THREE.PlaneBufferGeometry(260, 260, 22, 22);
	geometry.applyMatrix(new THREE.Matrix4().makeRotationX(-Math.PI / 2));
	var mesh = new THREE.Mesh(geometry, material);
	mesh.receiveShadow = true;




	var light = new THREE.SpotLight(0xffffff);
	light.position.set(100, 1000, 100);

	light.castShadow = true;
	light.shadow.mapSize.width = 2000; //$(container).width();
	light.shadow.mapSize.height = 2000;// $(container).height();
	light.shadow.camera.fov = 20;
	light.shadow.camera.near = 200;
	light.shadow.camera.far = 2000;

	light.shadow.camera.left = -2000 / 2;
	light.shadow.camera.right = 2000 / 2;
	light.shadow.camera.top = -2000 / 2;
	light.shadow.camera.bottom = 2000 / 2;
	return {
		mesh: mesh,
		light: light
	};
}
export {
	planeAndLight
};