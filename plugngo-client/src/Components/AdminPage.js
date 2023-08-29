import React, { useState } from "react";
import "./AdminPage.css";
import "../Components/Header";

export const AdminPage = () => {
  const [searchQuery, setSearchQuery] = useState("");
  const [chargingStations, setChargingStations] = useState([
    { id: 1, name: "Station 1", location: "Location A", status: "Active" },
    { id: 2, name: "Station 2", location: "Location B", status: "Active" },
    // Add more charging station data as needed
  ]);

  const [showForm, setShowForm] = useState(false);
  const [newStationData, setNewStationData] = useState({
    name: "",
    location: "",
    photos: [],
  });

  const handleSearchQueryChange = (event) => {
    setSearchQuery(event.target.value);
  };

  const handleAddStation = () => {
    setShowForm(true); // Show the form when adding a new station
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setNewStationData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleFileChange = (event) => {
    const files = event.target.files;
    setNewStationData((prevData) => ({ ...prevData, photos: files }));
  };

  const handleSubmit = () => {
    // Add new station data to the chargingStations array
    const newStation = {
      id: chargingStations.length + 1,
      name: newStationData.name,
      location: newStationData.location,
      status: "Active", // Assuming all new stations are active
    };

    setChargingStations([...chargingStations, newStation]);
    setShowForm(false); // Hide the form after submitting
    setNewStationData({ name: "", location: "", photos: [] });
  };

  const handleDeleteStation = (stationId) => {
    // Delete the station with the specified ID from chargingStations
    const updatedStations = chargingStations.filter(
      (station) => station.id !== stationId
    );
    setChargingStations(updatedStations);
  };

  return (
    <div className="admin-page">
      <header>
        <div className="header-section">PLUGNgo</div>
        <div className="header-section">Logout</div>
      </header>
      <main>
        <h1>My Charging Stations</h1>
        <section>
          <div className="search-bar">
            <input
              type="text"
              placeholder="Search for stations..."
              value={searchQuery}
              onChange={handleSearchQueryChange}
            />
            <button onClick={handleAddStation}>Add new station</button>
          </div>
          {showForm && (
            <form className="station-form">
              <label>Station Name</label>
              <input
                type="text"
                name="name"
                value={newStationData.name}
                onChange={handleInputChange}
              />
              <label>Location</label>
              <input
                type="text"
                name="location"
                value={newStationData.location}
                onChange={handleInputChange}
              />
              <label>Photos</label>
              <input
                type="file"
                name="photos"
                multiple
                onChange={handleFileChange}
              />
              <button type="button" onClick={handleSubmit}>
                Submit
              </button>
            </form>
          )}
          <ul className="station-list">
            {chargingStations.map((station) => (
              <li key={station.id}>
                <strong>{station.name}</strong> - {station.location} (
                {station.status})
                <button onClick={() => handleDeleteStation(station.id)}>
                  Delete
                </button>
              </li>
            ))}
          </ul>
        </section>
      </main>
    </div>
  );
};

export default AdminPage;
