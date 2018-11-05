import {
	setColorThree
} from './color.js';

function getColorRandom() {
	var x, y, z;

	x = Math.floor(Math.random() * 250);
	y = Math.floor(Math.random() * 250);
	z = Math.floor(Math.random() * 250);
	return setColorThree(x, y, z);
}

function getGeometry() {
	var xSize, ySize, zSize;

	xSize = Math.floor(Math.random() * 20);
	ySize = Math.floor(Math.random() * 40);
	zSize = Math.floor(Math.random() * 20);

	return [xSize, ySize, zSize];
}

function getPosition() {
	var x, y, z;

	x = Math.abs(150 - Math.floor(Math.random() * 250));
	y = Math.abs(150 - Math.floor(Math.random() * 250));
	z = Math.abs(150 - Math.floor(Math.random() * 250));
	return [x, y, z];
}

export {
	getColorRandom,
	getGeometry,
	getPosition
};