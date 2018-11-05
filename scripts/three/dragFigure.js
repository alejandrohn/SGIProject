function dragFigure(objects, camera, renderer, controls) {
	var dragControls = new THREE.DragControls(objects, camera, renderer.domElement);

	dragControls.addEventListener('dragstart', function () {

		controls.enabled = false;

	});

	dragControls.addEventListener('dragend', function () {

		controls.enabled = true;

	});
}

export { dragFigure };