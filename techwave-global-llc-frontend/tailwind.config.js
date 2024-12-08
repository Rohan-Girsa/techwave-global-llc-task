/** @type {import('tailwindcss').Config} */
export default {
	content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
	prefix: "",
	theme: {
		container: {
			center: true,
			padding: "2rem",
			screens: {
				"2xl": "1400px",
			},
		},
		extend: {
			colors: {
				black: {
					DEFAULT: "#000",
					100: "#000319",
					200: "rgba(17, 25, 40, 0.75)",
					300: "rgba(255, 255, 255, 0.125)",
				},
				white: {
					DEFAULT: "#FFF",
					100: "#BEC1DD",
					200: "#C1C2D3",
				},
				blue: {
					100: "#E4ECFF",
				},
			},
		},
	},
	plugins: [],
};
