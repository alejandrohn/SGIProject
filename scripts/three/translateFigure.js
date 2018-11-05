function translateFigure(figure, x, y, z) {
	if (x) {
		figure.translateX(x);
	}
	if (y) {
		figure.translateY(y);
	}
	if (z) {
		figure.translateZ(z);
	}

}

function translateFigureInScene(buttonClass, xyzClass, figure) {
	$(`.${buttonClass}`).click(function () {

		var valueX = $(`.${xyzClass} .x`).val();
		var valueY = $(`.${xyzClass} .y`).val();
		var valueZ = $(`.${xyzClass} .z`).val();
		translateFigure(figure, valueX, valueY, valueZ);
	});
}

export {
	translateFigureInScene
};