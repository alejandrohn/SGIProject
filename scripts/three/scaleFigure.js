function scaleFigure(figure, x, y, z) {
	if (x) {
		figure.scale.x = x;
	}
	if (y) {
		figure.scale.y = y;
	}
	if (z) {
		figure.scale.z = z;
	}

}

function scaleFigureInScene(buttonClass, xyzClass, figure) {
	$(`.${buttonClass}`).click(function () {

		var valueX = $(`.${xyzClass} .x`).val();
		var valueY = $(`.${xyzClass} .y`).val();
		var valueZ = $(`.${xyzClass} .z`).val();
		scaleFigure(figure, valueX, valueY, valueZ);
	});
}

export {
	scaleFigureInScene
};