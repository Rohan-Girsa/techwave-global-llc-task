import { useState, useEffect } from "react";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import "./App.css";

function App() {
	const [news, setNews] = useState([]);
	const [error, setError] = useState("");

	useEffect(() => {
		fetchNews();
	}, []);

	const fetchNews = async () => {
		try {
			const response = await fetch("http://localhost:7761/news");
			const data = await response.json();

			if (data.statusDescription.statusCode !== 200) {
				setError(data.statusDescription.statusMessage);
				return;
			}

			setNews(data.response);
		} catch (error) {
			setError("Something went wrong while fetching the news.");
			console.error(error);
		}
	};

	return (
		<div className="relative bg-black-100 flex justify-center items-center flex-col sm:px-10 px-5 w-screen min-h-screen text-white-100 overflow-auto">
			<h1 className="text-4xl mb-8">Latest News</h1>
			{error && <p className="text-red-500 mb-4">{error}</p>}
			<div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6 w-full">
				{news.map((item) => (
					<Card
						key={item.id}
						className="bg-white text-black p-4 rounded-md shadow-md"
					>
						<CardMedia
							component="img"
							height="140"
							image={item.image}
							alt={item.title}
							className="w-full h-48 object-cover mb-4"
						/>
						<CardContent>
							<Typography gutterBottom variant="h5" component="div">
								{item.title}
							</Typography>
							<Typography variant="body2" color="text.secondary">
								{item.description}
							</Typography>
						</CardContent>
						<CardActions>
							<Button
								size="small"
								color="primary"
								href={item.url}
								target="_blank"
								rel="noopener noreferrer"
							>
								Read more
							</Button>
						</CardActions>
					</Card>
				))}
			</div>
		</div>
	);
}

export default App;
