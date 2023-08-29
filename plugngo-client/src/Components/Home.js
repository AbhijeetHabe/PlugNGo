import React, { useState } from "react";
import "./Home.css";
const Home = () => {
  const images = [
    "https://deltaelectronicsindia.com/wp-content/uploads/2020/02/ev-1.png",
    "https://blogs.iadb.org/energia/wp-content/uploads/sites/16/2021/08/Electric-Vehicles-Charging-Infrastructure.png",
    "https://www.einfochips.com/blog/wp-content/uploads/2021/05/an-overview-of-electric-vehicle-charging-station-infrastructure-blog-fetaured.jpg",
  ];
  const [currentImageIndex, setCurrentImageIndex] = useState(0);
  const handleNextImage = () => {
    setCurrentImageIndex((prevIndex) => (prevIndex + 1) % images.length);
  };

  return (
    <div className="slideshow">
      {images.map((imageUrl, index) => (
        <img
          key={index}
          src={imageUrl}
          alt={`Charging Station ${index + 1}`} // Use a concise description
          loading="lazy"
          style={{
            display: index === currentImageIndex ? "block" : "none",
          }}
        />
      ))}
      <button className="next-button" onClick={handleNextImage}>
        Next
      </button>
    </div>
  );
};
export default Home;
