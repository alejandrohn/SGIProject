function createCube(gl) {
	// Vertex Data
	var vertexBuffer;
	vertexBuffer = gl.createBuffer();
	gl.bindBuffer(gl.ARRAY_BUFFER, vertexBuffer);
	var verts = [
		// Front face
		-1.0, -1.0, 1.0,
		1.0, -1.0, 1.0,
		1.0, 1.0, 1.0,
		-1.0, 1.0, 1.0,
		// Back face
		-1.0, -1.0, -1.0,
		-1.0, 1.0, -1.0,
		1.0, 1.0, -1.0,
		1.0, -1.0, -1.0,
		// Top face
		-1.0, -1.0, 1.0,
		1.0, 1.0, -1.0,
		1.0, 1.0, 1.0,
		1.0, 1.0, -1.0,
		// Bottom face
		-1.0, -1.0, -1.0,
		1.0, -1.0, -1.0,
		1.0, -1.0, 1.0,
		-1.0, -1.0, 1.0,
		// Right face
		1.0, -1.0, -1.0,
		1.0, 1.0, -1.0,
		1.0, 1.0, 1.0,
		1.0, -1.0, 1.0,
		// Left face
		-1.0, -1.0, -1.0,
		-1.0, -1.0, 1.0,
		-1.0, 1.0, 1.0,
		-1.0, 1.0, -1.0
	];

	gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(verts), gl.STATIC_DRAW);

	// Color data
	var colorBuffer = gl.createBuffer();
	gl.bindBuffer(gl.ARRAY_BUFFER, colorBuffer);
	var faceColors = [
		[1.0, 0.0, 0.0, 1.0], // Front face
		[0.0, 1.0, 0.0, 1.0], // Back face
		[0.0, 0.0, 1.0, 1.0], // Top face
		[1.0, 1.0, 0.0, 1.0], // Bottom face
		[1.0, 0.0, 1.0, 1.0], // Right face
		[0.0, 1.0, 1.0, 1.0] // Left face
	];
	var vertexColors = [];
	for (var i in faceColors) {
		var color = faceColors[i];
		for (var j = 0; j < 4; j++) {
			vertexColors = vertexColors.concat(color);
		}
	}
	gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(vertexColors),
		gl.STATIC_DRAW);
}