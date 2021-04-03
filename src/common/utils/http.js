const BASE_URL = 'http://localhost:3001';

export const request = {
	get: (path) => fetch(`${BASE_URL}/${path}`, { method: 'GET' }).then((response) => response.json()),
	post: (path) => fetch(`${BASE_URL}/${path}`, { method: 'POST' }).then((response) => response.json()),
	patch: (path) => fetch(`${BASE_URL}/${path}`, { method: 'PATCH' }).then((response) => response.json()),
	put: (path) => fetch(`${BASE_URL}/${path}`, { method: 'PUT' }).then((response) => response.json()),
};
