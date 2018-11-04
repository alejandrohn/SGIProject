function setColorThree(r = 50, g = 50, b = 50) {

	var color = new THREE.Color(`rgb(${r},${g},${b})`);
	return color;
}

export {
	setColorThree
};